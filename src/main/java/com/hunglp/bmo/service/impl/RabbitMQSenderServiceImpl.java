package com.hunglp.bmo.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hunglp.bmo.entity.Domain;
import com.hunglp.bmo.service.RabbitMQSenderService;

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${bmo.exchange}")
	private String exchange;

	@Value("${bmo.routingkey}")
	private String routingkey;

	@Override
	public void send(Object object) {
		rabbitTemplate.convertAndSend(exchange, routingkey, object);
		System.out.println("Send msg = " + object);

	}

}
