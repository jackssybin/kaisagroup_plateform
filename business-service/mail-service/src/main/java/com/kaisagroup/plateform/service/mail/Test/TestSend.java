package com.kaisagroup.plateform.service.mail.Test;


import com.kaisagroup.plateform.service.mail.bean.Email;
import com.kaisagroup.plateform.service.mail.component.EmailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by jackssy on 2018/4/4.
 */

@Component
@EnableScheduling
/*@Async("mySimpleAsync")*/
public class TestSend {

    public static int count=0;

    @Resource
    private EmailSender objectSender;


    private volatile int num =0;


  /*  @Scheduled(fixedDelay = 60000)
    public void send() {
        System.out.println("定时发送开始");
        messageProducer.sendMessage("123");
        System.out.println("定时发送结束");
    }*/
   /* @Scheduled(cron = "${cron.potion[cron.mdlog.task]:11 0 0 * * ?}")
    public void testSend(){
        System.out.println("我发送了"+count++);
    }
*/
//    @Scheduled(fixedDelay = 2000)
    public void sendEveryMin() {
        String msg ="测试消息"+count++;
        System.out.println("定时发送开始"+count);
//        objectSender.se
        Email email = new Email();
        email.setFromUser("asfdas");
        email.setToUser("asf");
        objectSender.send(email);
        System.out.println("定时发送结束"+count);
    }
}