package com.checkpoint.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@SpringBootApplication
public class SpringZookeeperApp extends SpringBootServletInitializer {

    @Autowired
    CuratorFramework curatorFramework;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringZookeeperApp.class);
    }



    public static void main(String[] args) {

        SpringApplication.run(SpringZookeeperApp.class, args);
    }

}
