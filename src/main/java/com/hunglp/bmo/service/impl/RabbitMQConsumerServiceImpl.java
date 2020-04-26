package com.hunglp.bmo.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.hunglp.bmo.service.RabbitMQConsumerService;

@Service
public class RabbitMQConsumerServiceImpl implements RabbitMQConsumerService {

	@Override
	@RabbitListener(queues = "${bmo.queue}")
	public void recieveMessage(Object object) {
		System.out.println("Recieved Message From RabbitMQ: " + object);

	}

}