package com.lookout.rediscachedemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * SET below jvm property or command line property
 * --app.location=/Users/apparao.varri/Workspace/
 */
@ConfigurationProperties(prefix = "redis")
@Configuration
@PropertySource("file:${app.location}redis-application.properties" )
@Data
public class RedisConfig {
    private String host;
    private String port;
    private int dbNumber;
    private boolean pubSubOrder;
    private int nettyThreads;

}
