package com.checkpoint.producer.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class AppConfiguration {


	@Value("${local-active-mq-broker}")
	private String brokerUrl;


	@Bean
	public ActiveMQConnectionFactory mqConnectionFactory() {
		ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory(brokerUrl);
		mqConnectionFactory.setTrustAllPackages(true);
		return mqConnectionFactory;
	}
	

	@Bean
	public JmsTemplate template() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(mqConnectionFactory());
		template.setPubSubDomain(true);
		return template;
	}

	/*@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}*/

}
