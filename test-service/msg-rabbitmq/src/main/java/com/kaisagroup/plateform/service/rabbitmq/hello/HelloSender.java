package com.kaisagroup.plateform.service.boot.plateform.service.boot.plateform.service.rabbitmq.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class HelloSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		log.info("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hellouser", context);
	}

	public void send(String context){
		log.info("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hellouser", context);
	}

}