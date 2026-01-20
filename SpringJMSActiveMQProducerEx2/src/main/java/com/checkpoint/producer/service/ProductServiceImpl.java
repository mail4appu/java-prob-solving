package com.checkpoint.producer.service;

import com.checkpoint.producer.messaging.MessageSender;
import com.checkpoint.producer.model.Product;
import com.checkpoint.producer.util.BasicUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "/orders")
public class ProductServiceImpl implements ProductService{

	static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
	private static AtomicInteger id = new AtomicInteger();

	@Autowired
	MessageSender messageSender;
	
	@Override
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void sendProduct(@RequestBody  Product product) {
		LOG.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		LOG.debug("Application : sending order request {}", product);
		product.setProductId(BasicUtil.getUniqueId());
		messageSender.sendMessage(product);
		LOG.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	
	
}
