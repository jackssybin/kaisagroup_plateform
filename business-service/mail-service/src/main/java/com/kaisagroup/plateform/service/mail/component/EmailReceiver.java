package com.kaisagroup.plateform.service.mail.component;



import com.alibaba.fastjson.JSON;
import com.kaisagroup.plateform.service.mail.bean.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailReceiver {

    @RabbitListener(queues = "emailQueue")
    public void process(String emailJson) {
        Email email =JSON.parseObject(emailJson,Email.class);
     /*   try {
              log.info("休眠两秒");
             Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        log.info("Receiver object : " + email.getFromUser());
    }

}
