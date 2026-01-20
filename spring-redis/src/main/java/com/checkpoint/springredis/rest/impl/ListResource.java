package com.checkpoint.springredis.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "/lists")
public class ListResource {

    @Autowired
    RedisTemplate redisTemplate;


    @RequestMapping(value = "/cities", method = RequestMethod.POST)
    public ResponseEntity bulkInsertIntoList(){
        IntStream range = IntStream.range(1, 100000);
        List<Object> results = redisTemplate.executePipelined(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                range.forEach(i-> connection.rPush("cities".getBytes(), ("city"+i).getBytes()));
                return null;
            }
        });
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @RequestMapping(value = "/cities/{index}", method = RequestMethod.GET)
    public String getSingleCity(@PathVariable(value = "index") int index){
        IntStream range = IntStream.range(0, 10);
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ListOperations listOperations = redisTemplate.opsForList();
        String city =(String) listOperations.index("cities", index);
        return city;

    }

}
