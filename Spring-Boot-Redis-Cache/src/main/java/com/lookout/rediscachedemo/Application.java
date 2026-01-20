package com.lookout.rediscachedemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * Add below system or command line property to run this application
 * --app.location=/Users/apparao.varri/Workspace/
 */
@SpringBootApplication
@EnableCaching
@ConfigurationPropertiesScan
public class Application {

    private final Logger LOG = LoggerFactory.getLogger(getClass());


    public static void main(String[] args) throws JsonProcessingException {
        for(String arg:args){
            System.out.println("ARGS =================="+arg);
        }
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        RedisConnectionUtil redisConnectionUtil = (RedisConnectionUtil)applicationContext.getBean("redisConnectionUtil");
        RedissonClient redissonClient = redisConnectionUtil.getRedissonClient();

        RList<Object> youlist = redissonClient.getList("youlist");
        /*String json="{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        ObjectMapper objectMapper= new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);

        youlist.add(json.getBytes());*/
        youlist.add("}Apparao\\{".getBytes());
        System.out.println("done with processing"+args.length);

    }

}
