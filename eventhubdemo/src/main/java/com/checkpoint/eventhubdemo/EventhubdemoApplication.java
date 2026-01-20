package com.checkpoint.eventhubdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EventhubdemoApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(EventhubdemoApplication.class, args);

	}

}
