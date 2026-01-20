package com.checkpoint.springredis.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "/strings")
public class StringResource {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/fields", method = RequestMethod.POST)
    public ResponseEntity insertKeys(@RequestParam @DefaultValue(value = "true") String restart) {
        if ("true".equals(restart)) {
            stringRedisTemplate.executePipelined(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    IntStream rangeStream = IntStream.range(1, 100000);
                    rangeStream.forEach(i -> {
                        redisConnection.stringCommands().set(("field-" + i).getBytes(), ("value-" + i).getBytes());
                    });
                    return null;
                }

            });
        }

        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }


    @RequestMapping(value = "/str-keys/{id}", method = RequestMethod.GET)
    public String getSingleKey(@PathVariable(value = "id") String key) {
        ValueOperations<String, String> strValueOperations = stringRedisTemplate.opsForValue();
        return strValueOperations.get(key);
    }


}


