package com.checkpoint.springredis.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class ApplicationConfiguration {


    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration= new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("168.61.33.129");
        redisStandaloneConfiguration.setPort(6379);
        return new JedisConnectionFactory(redisStandaloneConfiguration);

    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        return template;
    }



    @Bean
    public StringRedisTemplate strRedisTemplate(){
     StringRedisTemplate stringRedisTemplate= new StringRedisTemplate();
     stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
     return stringRedisTemplate;
    }


    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://ckpadmin:M856FREsjy$@zeusdesiqualqatestdb.eastus.cloudapp.azure.com:27017/DesigualProdMVPDB2");

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "DesigualProdMVPDB2");
    }


}
