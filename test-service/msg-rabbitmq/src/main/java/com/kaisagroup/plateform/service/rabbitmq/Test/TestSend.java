package com.kaisagroup.plateform.service.rabbitmq.Test;



import com.kaisagroup.plateform.service.rabbitmq.hello.HelloSender;
import com.kaisagroup.plateform.service.rabbitmq.model.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by jackssy on 2018/4/4.
 */

@Component
@EnableScheduling
@Async("mySimpleAsync")
public class TestSend {

    public static int count=0;

   /* @Resource
    private MessageProducer messageProducer;
    @Resource
    private FanoutSender fanoutSender;
    @Resource
    private ObjectSender objectSender;



    @Resource
    private NeoSender neoSender;*/

    @Resource
    private HelloSender helloSender;

    private volatile int num =0;


  /*  @Scheduled(fixedDelay = 60000)
    public void send() {
        System.out.println("定时发送开始");
        messageProducer.sendMessage("123");
        System.out.println("定时发送结束");
    }*/
    @Scheduled(cron = "${cron.potion[cron.mdlog.task]:11 0 0 * * ?}")
    public void testSend(){
        System.out.println("我发送了"+count++);
    }

    @Scheduled(fixedDelay = 2000)
    public void sendEveryMin() {
        String msg ="测试消息"+count++;
        System.out.println("定时发送开始"+count);
//        messageProducer.send(msg);
//        fanoutSender.send(msg);
        User user = new User();
        user.setName("name");
        user.setPass("pass");
//        fanoutSender.send(JSON.toJSONString(user));
//        objectSender.send(user);
//        messageProducer.send(JSON.toJSONString(user));
//        neoSender.send(msg);
        helloSender.send(user.getName());
        System.out.println("定时发送结束"+count);
    }
}