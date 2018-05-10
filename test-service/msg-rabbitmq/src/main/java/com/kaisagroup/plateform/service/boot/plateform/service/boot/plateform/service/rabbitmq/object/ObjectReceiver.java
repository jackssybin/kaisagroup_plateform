package com.kaisagroup.plateform.service.boot.plateform.service.boot.plateform.service.rabbitmq.object;



import com.kaisagroup.plateform.service.boot.plateform.service.boot.plateform.service.rabbitmq.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;

/*
@Component
@RabbitListener(queues = "object")*/
public class ObjectReceiver {

    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver object : " + user);
    }

}
