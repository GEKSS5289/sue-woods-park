package com.sue.rabbit.producer.broker;

import com.sue.rabbit.constant.MessageType;
import com.sue.rabbit.entity.Message;
import com.sue.rabbit.producer.broker.AsyncBaseQueue;
import com.sue.rabbit.producer.broker.RabbitBroker;
import com.sue.rabbit.producer.broker.RabbitTemplateContainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sue
 * @date 2020/8/16 8:48
 */

/**
 * 实现发送不同消息实现类
 */
@Component
@Slf4j
public class RabbitBrokerImpl implements RabbitBroker {


    @Autowired
    private RabbitTemplateContainer rabbitTemplateContainer;


    /**
     * 迅速发消息 使用异步线程池发送消息
     * @param message
     */
    @Override
    public void rapidSend(Message message) {
        message.setMessageType(MessageType.RAPID);
        sendKernel(message);
    }

    /**
     * 发送消息的核心方法
     * @param message
     */
    private void sendKernel(Message message) {
        AsyncBaseQueue.submit(()->{
            CorrelationData correlationData = new CorrelationData(String.format("%s#%s",message.getMessageId(),System.currentTimeMillis()));
            String topic = message.getTopic();
            String routingKey = message.getRoutingKey();
            RabbitTemplate rabbitTemplate = rabbitTemplateContainer.getTemplate(message);
            rabbitTemplate.convertAndSend("exchange",routingKey,message,correlationData);
            log.info("#RabbitBrokerImpl.sendKernel# send to rabbitmq,messageId:{}",message.getMessageId());
        });

    }

    @Override
    public void confirmSend(Message message) {
        message.setMessageType(MessageType.CONFIRM);
        sendKernel(message);
    }

    @Override
    public void reliantSend(Message message) {

    }

    @Override
    public void sendMessage() {

    }
}
