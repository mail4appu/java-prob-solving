package com.lookout.rediscachedemo;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class RedisConnectionUtil {

    RedissonClient redissonClient;

    @Autowired
    RedisConfig redisConfig;

    Map<String, String> testMap;

    @PostConstruct
    public void init(){

        Config redissonConfig= new Config();
        redissonConfig.setCodec(new JsonJacksonCodec());
        redissonConfig.setKeepPubSubOrder(redisConfig.isPubSubOrder());
        redissonConfig.setNettyThreads(redissonConfig.getNettyThreads());
        SingleServerConfig singleServerConfig = redissonConfig.useSingleServer();
        singleServerConfig.setAddress("redis://"+redisConfig.getHost()+":"+redisConfig.getPort());
        singleServerConfig.setDatabase(redisConfig.getDbNumber());
        redissonClient = Redisson.create(redissonConfig);

    }

    public RedissonClient getRedissonClient(){
        return redissonClient;
    }





}
