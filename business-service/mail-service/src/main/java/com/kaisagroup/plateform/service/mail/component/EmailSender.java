package com.kaisagroup.plateform.service.mail.component;

import com.alibaba.fastjson.JSON;
import com.kaisagroup.plateform.service.mail.bean.Email;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(Email email) {
		System.out.println("Sender object: " + email.toString());
		this.rabbitTemplate.convertAndSend("object", JSON.toJSONString(email));
	}

}