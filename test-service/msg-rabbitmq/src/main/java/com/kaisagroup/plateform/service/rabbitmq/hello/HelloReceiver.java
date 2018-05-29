package com.kaisagroup.plateform.service.rabbitmq.hello;

import com.alibaba.fastjson.JSONObject;
import com.kaisagroup.plateform.service.rabbitmq.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class HelloReceiver {

    @RabbitListener(queues = "hellouser")
    public void process(String hello) {
        log.info("Receiver  : " + hello);
        try{
            User user= JSONObject.parseObject(hello,User.class);
            log.info(user.toString());
        }catch(Exception e){

        }

    }


}
