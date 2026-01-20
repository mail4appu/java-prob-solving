package com.checkpoint.producer.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.checkpoint.producer.model.Product;

import javax.jms.*;


@Component
public class MessageSender {

    Logger logger = LoggerFactory.getLogger(MessageSender.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${topic.name}")
    private String topic;

    @Autowired
    ObjectMapper objectMapper;

    public void sendMessage(final Product product) {

        jmsTemplate.send(topic, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                String message = null;
                try {
                    message = objectMapper.writeValueAsString(product);
                } catch (JsonProcessingException e) {
                    logger.error("Exception occurred while processing object", e);
                }
                logger.debug("Product {} to jms broker ", product);
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
    }

}
