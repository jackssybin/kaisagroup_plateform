package com.kaisagroup.plateform.service.msg.Test;


import com.kaisagroup.plateform.service.msg.rabbitmq.Sender;
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
//@Async("mySimpleAsync")
public class TestSend {

    public static int count=0;

    @Resource
    private Sender sender;

    private volatile int num =0;


    @Scheduled(cron = "${cron.potion[cron.mdlog.task]:11 0 0 * * ?}")
    public void testSend(){
        System.out.println("我发送了"+count++);
    }

    @Scheduled(fixedDelay = 2000)
    public void sendEveryMin() {
        String msg ="测试消息"+count++;
        System.out.println("定时发送开始"+count);
        sender.send();
        System.out.println("定时发送结束"+count);
    }
}