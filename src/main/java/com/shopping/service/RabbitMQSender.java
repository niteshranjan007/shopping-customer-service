package com.shopping.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shopping.entity.CustomerEntity;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${shopping.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${shopping.rabbitmq.routingkey}")
	private String routingkey;	
	String kafkaTopic = "java_in_use_topic";
	
	public void send(CustomerEntity customer) {
		amqpTemplate.convertAndSend(exchange, routingkey, customer);
		System.out.println("Send msg = " + customer);
	    
	}
}