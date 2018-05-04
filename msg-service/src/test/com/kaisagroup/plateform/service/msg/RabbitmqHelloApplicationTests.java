package com.kaisagroup.plateform.service.msg;

import com.kaisagroup.plateform.service.msg.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jackssy on 2018/5/4.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqHelloApplicationTests.class)
public class RabbitmqHelloApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() {
        sender.send();
    }
}