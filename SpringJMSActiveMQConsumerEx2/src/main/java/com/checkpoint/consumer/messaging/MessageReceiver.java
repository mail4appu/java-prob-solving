package com.checkpoint.consumer.messaging;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.checkpoint.consumer.model.Product;
import com.checkpoint.consumer.service.OrderService;


@Component
public class MessageReceiver {

	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

	@Autowired
	OrderService orderService;

	@Autowired
	private ObjectMapper objectMapper;

	@JmsListener(destination = "${topic.name}")
	public void onMessage(final Message message) throws JMSException, JsonProcessingException {
		LOG.info("----------------------------------------------------");
		MessageHeaders headers = message.getHeaders();
		LOG.info("Application : headers received : {}", headers);
		//if (message instanceof TextMessage) {
			//String json = ((TextMessage) message).getText(); // here you have your event object as json string
			//Product product = objectMapper.readValue(json, Product.class);
		   String productString=(String)message.getPayload();
		   Product product=objectMapper.readValue(productString, Product.class);

			LOG.info("Application : product : {}", product);

			orderService.processOrder(product);
			LOG.info("----------------------------------------------------");

		//}
	}

}
