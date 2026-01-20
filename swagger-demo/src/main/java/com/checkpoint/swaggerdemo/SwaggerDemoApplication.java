package com.checkpoint.swaggerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class SwaggerDemoApplication  extends SpringBootServletInitializer {
    private static Logger logger = LoggerFactory.getLogger(SwaggerDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemoApplication.class, args);


    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SwaggerDemoApplication.class);
    }

}
