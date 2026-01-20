package com.checkpoint.consumer.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableJms
public class MessagingConfiguration {

	@Value("${local-active-mq-broker}")
	private String brokerUrl;

	@Bean
	public org.apache.activemq.ActiveMQConnectionFactory mqConnectionFactory() {
		org.apache.activemq.ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory(brokerUrl);
		mqConnectionFactory.setTrustAllPackages(true);
		return mqConnectionFactory;
	}
	
	@Bean 
	public JmsTemplate jmsTemplate(){
		JmsTemplate template = new JmsTemplate();
		template.setDefaultDestinationName("order-topic");
		template.setConnectionFactory(mqConnectionFactory());
		template.setPubSubDomain(true);

		return template;
	}





	
}
