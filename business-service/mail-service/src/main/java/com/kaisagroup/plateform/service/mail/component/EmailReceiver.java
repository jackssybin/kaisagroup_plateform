package com.kaisagroup.plateform.service.mail.component;



import com.alibaba.fastjson.JSON;
import com.kaisagroup.plateform.service.mail.bean.Email;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "emialQueue")
public class ObjectReceiver {

    @RabbitHandler
    public void process(String emailJson) {
        Email email =JSON.parseObject(emailJson,Email.class);
        System.out.println("Receiver object : " + email);
    }

}
