package com.checkpoint.springredis.dao;

import com.checkpoint.springredis.model.Computer;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
public class ComputerRepositoryImpl implements ComputerRepository {

    RedisTemplate<String, Object> redisTemplate;
    HashOperations hashOperations;

    public ComputerRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {

        this.redisTemplate = redisTemplate;
        hashOperations=redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Computer> findAll() {
        return hashOperations.entries("product");
    }

    @Override
    public Collection<Computer> findAllComputers() {
        return (Collection<Computer>) hashOperations.entries("product").values();
    }
    @Override
    public Computer getSingleComputer(String id) {
        return (Computer)hashOperations.get("product", id);
    }

    @Override
    public void saveComputer(Computer computer) {
        hashOperations.put("product", computer.getId(), computer);


    }
}
