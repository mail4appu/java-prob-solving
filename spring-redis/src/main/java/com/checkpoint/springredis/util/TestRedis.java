package com.checkpoint.springredis.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;

import java.util.Collection;
import java.util.LinkedHashSet;

public class TestRedis {
    public static void main(String[] args) {
        scan(redisTemplate(),"*", 100);


    }

   static JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration= new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("52.186.168.106");
        redisStandaloneConfiguration.setPort(6379);
        return new JedisConnectionFactory(redisStandaloneConfiguration);

    }


    public static RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }



    public static void scan(RedisTemplate redisTemplate, String pattern, int count) {
        Cursor cursor = redisTemplate.opsForSet().scan("products:set", ScanOptions.scanOptions().match(pattern).count(count).build());
        Collection<JsonNode> productSet= new LinkedHashSet<>();
        while(cursor.hasNext()){
            JsonNode node=(JsonNode) cursor.next();
            productSet.add(node);
        }

        System.out.println(productSet.size());
    }

}
