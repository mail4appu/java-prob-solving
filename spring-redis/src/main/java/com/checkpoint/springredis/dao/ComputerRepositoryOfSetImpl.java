package com.checkpoint.springredis.dao;

import com.checkpoint.springredis.model.Computer;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.SerializationUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.stream.Collectors;

@Repository
public class ComputerRepositoryOfSetImpl  implements ComputerRepositoryOfSet{
    RedisTemplate<String, Object> redisTemplate;
    SetOperations<String, Computer> setOperations;

    public ComputerRepositoryOfSetImpl(RedisTemplate redisTemplate) {
        this.redisTemplate=redisTemplate;
        this.setOperations = redisTemplate.opsForSet();
    }

    @Override
    public Collection<Computer> findAll() {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Computer.class));
        return setOperations.members("computers:set");
    }

    @Override
    public Collection<Computer> findAllComputers() {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Computer.class));
        return setOperations.members("computers:set");
    }

    @Override
    public Computer getSingleComputer(String id) {
       return findAllComputers().stream().filter(computer -> computer.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    @Override
    public void saveComputer(Computer computer) {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Computer.class));
        setOperations.add("computers:set", computer);

    }

    @Override
    public void saveComputerUsingBytes(Computer computer){
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
               redisConnection.setCommands().sAdd("computers:set".getBytes(), new Jackson2JsonRedisSerializer<>(Computer.class).serialize(computer));
                return null;
            }
        });
    }
}
