package com.checkpoint.consumer;

import com.checkpoint.consumer.configuration.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@PropertySource("classpath:application.properties")
public class ConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		((AbstractApplicationContext) context).close();
	}
}
