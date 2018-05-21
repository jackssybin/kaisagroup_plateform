package com.kaisagroup.plateform.service.boot.plateform.service.boot.plateform.service.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 *
 * @description:
 * @Date: 11:32 2017/10/9
 */

@Component
@Slf4j
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入
     */
    @Autowired
    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
//        MessageProperties messageProperties = new MessageProperties();
//        messageProperties.setContentType("application/json");
//        //指定的__TypeId__属性值必须是消费端的Order的全类名，如果不匹配则会报错。
//        messageProperties.getHeaders().put("__TypeId__","com.example.demo.model.User");
//        Message message = new Message(content.getBytes(),messageProperties);
        rabbitTemplate.convertAndSend(RabbitMqTestConfig.DEMO_EXANGE, RabbitMqTestConfig.DEMO_ROUTINGKEY, content, correlationId);
        log.info("correlationId="+correlationId);
        // 消息确认  properties 需要配置   publisher-returns: true
//        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
//            String correlationId1 = message.getMessageProperties().getCorrelationIdString();
//            log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId1, replyCode, replyText, exchange, routingKey);
//        });
//        消息确认  properties 需要配置  publisher-confirms :true
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.info("消息发送到exchange成功,id: {}", correlationData.getId());
            } else {
                log.info("消息发送到exchange失败,原因: {}", cause);
            }
        });

    }


}