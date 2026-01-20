package com.checkpoint.springredis.dao;

import com.checkpoint.springredis.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.SerializationUtils;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImplV2 {

    Logger logger= LoggerFactory.getLogger(ProductRepositoryImplV2.class);


    @Autowired
    RedisTemplate redisTemplate;

    public void saveInSet(Product product){
        redisTemplate.opsForSet().add("checkpoint:products:set:v2", product);
    }

    public void saveAllInSet(JsonNode rootArray){
        ObjectMapper objectMapper = new ObjectMapper();
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (JsonNode node : rootArray) {
                    try {
                        Product product = objectMapper.treeToValue(node, Product.class);
                        prepareIndexOnPrice(redisConnection, product);
                        if (Objects.nonNull(product)) {
                            redisConnection.setCommands().sAdd("checkpoint:products:set:v2".getBytes(), new Jackson2JsonRedisSerializer(Product.class).serialize(product));

                        }
                    } catch (JsonProcessingException e) {
                        logger.error("Exception occurred while processing Json tree", e);
                    }
                }
                return null;
            }


        });
    }

    private void prepareIndexOnPrice(RedisConnection redisConnection, Product product) {
        redisConnection.zSetCommands().zAdd("product.price".getBytes(), Double.parseDouble(product.getPrice()), String.valueOf(product.getObjectId()).getBytes());
    }

    public Collection<Product> findAllProductsFromSet(){
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Product.class));
        return (Collection<Product>)(Collection)redisTemplate.opsForSet().members("checkpoint:products:set:v2");
    }

    public Product findSingleProductFromSet(long id){
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Product.class));
        return findAllProductsFromSet().parallelStream().filter(product -> product.getObjectId()==id).collect(Collectors.toList()).get(0);
    }

    public Collection<Product> filterProductsByPriceRange(String priceRange, int limit, int offSet){
        String priceStart = priceRange.split("-")[0].trim();
        String priceEnd = priceRange.split("-")[1].trim();
        Collection<Product> products= new HashSet<>();
        if(limit==0 ){
            limit=10;
        }
        Set<Integer> rangeOfProdIds = (Set<Integer>)(Set)redisTemplate.opsForZSet().rangeByScore("product.price", Long.parseLong(priceStart), Long.parseLong(priceEnd), offSet, limit );
        List<Object> objectList = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Collection<Product> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (Integer prodId : rangeOfProdIds) {
                    Product product = (Product) SerializationUtils.deserialize(redisConnection.hashCommands().hGet("checkpoint:products:map:v2".getBytes(), new Jackson2JsonRedisSerializer(Integer.class).serialize(prodId)));
                    products.add(product);
                }
                return null;
            }
        });

        return (Collection<Product>)(Collection)objectList;
    }

    public Collection<Product> filterProductsByBrand(String brand, int limit, int offSet){

        Collection<Product> products= new HashSet<>();
        RedisZSetCommands.Range range = RedisZSetCommands.Range.range().gte(brand).lt(getMax(brand));
        if(limit==0 ){
            limit=10;
        }
        RedisZSetCommands.Limit limitNoffSet = RedisZSetCommands.Limit.limit().count(limit).offset(offSet);

        redisTemplate.setValueSerializer(null);
        Set<byte[]> rangeObjects = (Set<byte[]>)(Set)redisTemplate.opsForZSet().rangeByLex("product.brand", range, limitNoffSet);
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Product.class));
        List<Object> objectList = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Collection<Product> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (byte[] brandNProdId : rangeObjects) {
                    String strBrandNProdId= new String(brandNProdId);
                    Integer prodId = Integer.valueOf(strBrandNProdId.split(":")[1]);
                    Product product = (Product) SerializationUtils.deserialize(redisConnection.hashCommands().hGet("checkpoint:products:map:v2".getBytes(), new Jackson2JsonRedisSerializer(Integer.class).serialize(prodId)));
                    products.add(product);
                }
                return null;
            }
        });

        return (Collection<Product>)(Collection)objectList;
    }

    private String getMax(String brand) {
        char lastCharOfBrand=brand.charAt(brand.length() - 1);
        char upperLimitChar=(char) (lastCharOfBrand + 1);
        String upperLimitStr = brand.replace(brand.charAt(brand.length() - 1), upperLimitChar);
        return  upperLimitStr;
    }

    public Iterable<Product> findAllProductsFromMap() {
        return (Collection<Product>)(Collection)redisTemplate.opsForHash().values("checkpoint:products:map:v2");
    }

    public void saveAllInMap(JsonNode rootArray) {

        ObjectMapper objectMapper = new ObjectMapper();
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (JsonNode node : rootArray) {
                    try {
                        Product product = objectMapper.treeToValue(node, Product.class);
                        prepareIndexOnPrice(redisConnection, product);
                        prepareIndexOnBrand(redisConnection, product);
                        if (Objects.nonNull(product)) {
                            redisConnection.hashCommands().hSet("checkpoint:products:map:v2".getBytes(), String.valueOf(product.getObjectId()).getBytes(), new Jackson2JsonRedisSerializer(Product.class).serialize(product));

                        }
                    } catch (JsonProcessingException e) {
                        logger.error("Exception occurred while processing Json tree", e);
                    }
                }
                return null;
            }


        });

    }

    private void prepareIndexOnBrand(RedisConnection redisConnection, Product product) {
        redisConnection.zSetCommands().zAdd("product.brand".getBytes(), 0, String.valueOf(product.getBrand() + ":" + product.getObjectId()).getBytes());
    }

    private double generateHashCode(String brand) {
        int i = brand.trim().hashCode();
        if(i<0){
           i= i*-1;
        }
        return Double.valueOf(i);

    }

    public void saveInMap(Product product) {
        redisTemplate.opsForZSet().add("product.price",  String.valueOf(product.getObjectId()).getBytes(), Double.parseDouble(product.getPrice()));
        redisTemplate.opsForHash().put("checkpoint:products:map:v2", product.getObjectId(), product);
    }
}
