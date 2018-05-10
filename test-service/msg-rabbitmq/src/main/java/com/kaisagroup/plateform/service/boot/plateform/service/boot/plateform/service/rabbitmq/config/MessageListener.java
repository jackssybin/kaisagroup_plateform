package com.kaisagroup.plateform.service.boot.plateform.service.boot.plateform.service.rabbitmq.config;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

/**
 * Created by jackssy on 2018/4/10.
 */
@Slf4j
public class MessageListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
            long tag =message.getMessageProperties().getDeliveryTag();
            String msg =new String(message.getBody());
            log.info("receive 接收队列A:"+msg+" tag="+tag +" messageId="+message.getMessageProperties().getCorrelationIdString());
            channel.basicAck(tag,false);//处理业务成功则调用
//          channel.basicNack(tag,false,false);//如果处理失败可以调用basicNack()方法，调用该方法之后，服务器会自动的重新发送该消息，让消费端重新处理，直到消费端返回basicAsk
    }
}
