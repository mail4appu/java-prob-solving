package com.checkpoint.swaggerdemo;

import com.checkpoint.swaggerdemo.model.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SwaggerDemoApplicationTests {
	private Logger logger=LoggerFactory.getLogger(SwaggerDemoApplication.class);
	public static final String serverURL="http://localhost:9090/demo-app";

	@Test
	void contextLoads() {
		RestTemplate template= new RestTemplate();
		Product product = new Product();
		product.setDescription("windows Z series");
		product.setName("Lenovo Idea Pad z1");
		product.setOs("linux");
		product.setType("high-endd");
		product.setPrice("3000$");

		HttpEntity<Product> request = new HttpEntity<>(product);
		try {
			ResponseEntity response = template
					.exchange(serverURL + "/products", HttpMethod.POST, request, Product.class);
			System.out.println("Reponse Body from the server: " + response.getBody());
		}catch(Exception ex){
			logger.error("Exception occurred while creating product ", ex);

		}
	}

}
