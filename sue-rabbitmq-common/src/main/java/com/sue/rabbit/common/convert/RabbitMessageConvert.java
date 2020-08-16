package com.sue.rabbit.common.convert;

import com.google.common.base.Preconditions;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 * @author sue
 * @date 2020/8/16 9:54
 */


/**
 * 装饰者模式
 */
public class RabbitMessageConvert implements MessageConverter {

    private GenericMessageConverter delegate;

    private final String delaultExprie = String.valueOf(24*60*60*1000);

    public RabbitMessageConvert(GenericMessageConverter genericMessageConverter){
        Preconditions.checkNotNull(genericMessageConverter);
        this.delegate = genericMessageConverter;
    }

    @Override
    public Message toMessage(Object o, MessageProperties messageProperties) throws MessageConversionException {
        messageProperties.setExpiration(delaultExprie);

        return this.delegate.toMessage(o,messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        return (com.sue.rabbit.entity.Message)this.delegate.fromMessage(message);
    }
}
