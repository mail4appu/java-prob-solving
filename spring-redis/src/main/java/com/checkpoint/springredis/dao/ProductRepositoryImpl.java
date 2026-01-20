package com.checkpoint.springredis.dao;

import com.checkpoint.springredis.model.ProductCustomizations;
import com.fasterxml.jackson.databind.JsonNode;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);



    RedisTemplate redisTemplate;
    HashOperations hashOperations;



    public ProductRepositoryImpl(RedisTemplate redisTemplate) {

        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, JsonNode> findAll() {
        return null;
    }

    @Override
    public Collection<JsonNode> findAllProducts() {
        return (Collection<JsonNode>) hashOperations.entries("products").values();

    }

    @Override
    public JsonNode getSingleProduct(String id) {
        return (JsonNode) hashOperations.get("products", id);
    }

    @Override
    public void saveProductsInSet(JsonNode rootArray) {

        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (JsonNode node : rootArray) {
                    if (Objects.nonNull(node)) {
                            redisConnection.setCommands().sAdd("products:set".getBytes(), new Jackson2JsonRedisSerializer(JsonNode.class).serialize(node));

                    }
                }
                return null;
            }


        });


    }

    @Override
    public void saveProductsInMap(JsonNode rootArray) {
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (JsonNode node : rootArray) {
                    if (Objects.nonNull(node) && Objects.nonNull(node.get("objectID"))) {
                        String objectId = node.get("objectID").asText();
                            redisConnection.hashCommands().hSet("products:map".getBytes(),objectId.getBytes(), new Jackson2JsonRedisSerializer(JsonNode.class).serialize(node));

                    }
                }
                return null;
            }


        });


    }

    private byte[] getBytes(JsonNode root) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream os = new ObjectOutputStream(bos)) {
            os.writeObject(root);
        }
        return bos.toByteArray();
    }

    @Override
    public Collection<JsonNode> findAllProductsFromMap(ProductCustomizations productCustomizations) {
        Collection<JsonNode> allProducts=(Collection<JsonNode>) hashOperations.entries("products:map").values();

        String priceRange=productCustomizations.getPriceRange();
        if(StringUtils.isNotBlank(priceRange)){
            return allProducts.stream().filter(product -> (product.get("price_range").asText()).equals(priceRange)).collect(Collectors.toList());
        }
        else{
            return allProducts;
        }


    }


    @Override
    public Collection<JsonNode> findAllProductsFromSet(ProductCustomizations productCustomizations) {
       long start= System.currentTimeMillis();
        Collection<JsonNode> products= new LinkedHashSet<>();
        Set<byte[]> execute =(Set<byte[]>)(Set) redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Set<byte[]> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.setCommands().sMembers("products:set".getBytes());

            }
        });
        Set<JsonNode> collect = execute.stream().map(node -> new Jackson2JsonRedisSerializer<>(JsonNode.class).deserialize(node)).collect(Collectors.toSet());
        long end=System.currentTimeMillis();
        logger.debug("Time taken to fetch with RedisConnection {} ", (end-start));
        return collect;

    }


    @Override
    public Collection<JsonNode> findAllProductsFromSetWithTemplate(ProductCustomizations productCustomizations) {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(JsonNode.class));
        long start= System.currentTimeMillis();
        Set<JsonNode> members = redisTemplate.opsForSet().members("products:set");
        long end=System.currentTimeMillis();
        logger.debug("Time taken to fetch with RedisTemplate {} ", (end-start));
        return members;

    }
    /*@Override
    public Collection<JsonNode> findAllProductsFromSet(ProductCustomizations productCustomizations) {
        Collection<JsonNode> productSet= new LinkedHashSet<>();

        Cursor<Object> scan = redisTemplate.opsForSet().scan("products:set", ScanOptions.scanOptions().count(100).build());
        while(scan.hasNext()){
            JsonNode next = (JsonNode)scan.next();
            productSet.add(next);
        }
        try {
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productSet;
    }*/

    private void getResultsByPipeLine(ProductCustomizations productCustomizations, Collection<JsonNode> filteredProducts) {
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                List<byte[]> bytes = redisConnection.hashCommands().hVals("products".getBytes());
                if(StringUtils.isNotBlank(productCustomizations.getPriceRange())) {
                    bytes.stream().forEach(i -> {
                        try {
                            JsonNode productNode=getObject(i);
                            if (productNode.get("price_range").equals(productCustomizations.getPriceRange())) {
                                filteredProducts.add(productNode);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                    });
                }
                else{
                    return bytes;
                }
                return null;
            }
        });
    }


    private static JsonNode getObject(byte[] byteArr) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
        ObjectInput in = new ObjectInputStream(bis);
        return (JsonNode)in.readObject();
    }
}
