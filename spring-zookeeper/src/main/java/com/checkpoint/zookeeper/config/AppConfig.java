package com.checkpoint.zookeeper.config;

import com.checkpoint.zookeeper.model.CustomerDefinedConfiguration;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.async.AsyncCuratorFramework;
import org.apache.curator.x.async.modeled.JacksonModelSerializer;
import org.apache.curator.x.async.modeled.ModelSpec;
import org.apache.curator.x.async.modeled.ModeledFramework;
import org.apache.curator.x.async.modeled.ZPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AppConfig {
    Logger logger= LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    CuratorFramework curatorFramework;

    @Value("${spring.application.name}")
    private String appName;

    @Bean
    AsyncCuratorFramework getAsyncCuratorFramework() {
        return AsyncCuratorFramework.wrap(curatorFramework);

    }


    @Bean
    ModelSpec<CustomerDefinedConfiguration> getModelSpec(){
       return ModelSpec.builder(
                ZPath.parseWithIds("/config/"),
                JacksonModelSerializer.build(CustomerDefinedConfiguration.class))
                .build();
    }


    @Bean
    ModeledFramework<CustomerDefinedConfiguration> getModelFramework(){
        return ModeledFramework.wrap(getAsyncCuratorFramework(), getModelSpec());
    }

    @Bean
    ModeledFramework<Map> getModelFrameworkRandom(){
        return ModeledFramework.wrap(getAsyncCuratorFramework(), getModelSpecRandom());
    }

    private ModelSpec<Map> getModelSpecRandom() {
        return ModelSpec.builder(
                ZPath.parseWithIds("/config/"+appName+"/appConfiguration"),
                JacksonModelSerializer.build(Map.class))
                .build();
    }


}
