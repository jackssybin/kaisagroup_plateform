package com.kaisagroup.plateform.service.mail.component;

import com.alibaba.fastjson.JSON;
import com.kaisagroup.plateform.service.mail.bean.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(Email email) {
		log.info("Sender object: " + email.getToUser());
		this.rabbitTemplate.convertAndSend("emailQueue", JSON.toJSONString(email));
	}

}