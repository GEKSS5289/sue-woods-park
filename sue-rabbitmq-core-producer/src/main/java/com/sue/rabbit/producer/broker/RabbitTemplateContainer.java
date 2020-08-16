package com.sue.rabbit.producer.broker;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.sue.rabbit.constant.MessageType;
import com.sue.rabbit.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author sue
 * @date 2020/8/16 9:12
 */

/**
 * 池化RabbitTemplate封装
 */
@Slf4j
@Component
public class RabbitTemplateContainer implements RabbitTemplate.ConfirmCallback {


    private Map<String, RabbitTemplate> rabbitMap = Maps.newConcurrentMap();

    private Splitter splitter = Splitter.on("#");

    @Autowired
    private ConnectionFactory connectionFactory;

    public RabbitTemplate getTemplate(Message message){
        Preconditions.checkNotNull(message);
        String topic = message.getTopic();
        RabbitTemplate rabbitTemplate = rabbitMap.get(topic);
        if(rabbitTemplate != null){
            return rabbitTemplate;
        }
        log.info("#RabbitTemplateContainer.getTemplate#topic:{}is not exists,create one",topic);
        RabbitTemplate newRabbitTemplate = new RabbitTemplate(connectionFactory);
        newRabbitTemplate.setExchange(topic);
        newRabbitTemplate.setRetryTemplate(new RetryTemplate());
        newRabbitTemplate.setRoutingKey(message.getRoutingKey());

        //对于message序列化方式




        String messageType = message.getMessageType();
        if(!MessageType.RAPID.equals(messageType)){
            newRabbitTemplate.setConfirmCallback(this);
            //事务消息
//            newRabbitTemplate.setChannelTransacted(true);
        }
        rabbitMap.putIfAbsent(topic,newRabbitTemplate);
        return rabbitMap.get(topic);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String s) {
            //具体消息应答
        List<String> strings = splitter.splitToList(correlationData.getId());
        String messageId = strings.get(0);
        long sendTime = Long.parseLong(strings.get(1));

        if(ack){
            log.info("send message is OK confirm messageId:{},sendTime:{}",messageId,sendTime);
        }else{
            log.error("send message is Fail,confirm messageId:{},sendTime:{}",messageId,sendTime);
        }

    }
}
