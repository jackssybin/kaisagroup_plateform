package com.kaisagroup.plateform.service.mail.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by jackssy on 2018/5/15.
 */
@Component
public class RabbitMqEmailConfig {

    @Bean
    public Queue emailQueue() {
        return new Queue("emailQueue");
    }
}
