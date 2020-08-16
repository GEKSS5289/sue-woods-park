package com.sue.rabbit.producer.broker;

import com.google.common.base.Preconditions;
import com.sue.rabbit.api.producer.MessageProducer;
import com.sue.rabbit.api.producer.SendCallback;
import com.sue.rabbit.entity.Message;
import com.sue.rabbit.exception.MessageRunTimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sue.rabbit.constant.MessageType;
import java.util.List;

/**
 * @author sue
 * @date 2020/8/15 17:08
 */

@Component
public class ProducerClient implements MessageProducer {


    @Autowired
    private RabbitBroker rabbitBroker;


    /**
     * 消息的发送 附带SendCallBack回调执行响应的业务逻辑处理
     *
     * @param message
     * @param sendCallback
     * @throws MessageRunTimeException
     */
    @Override
    public void send(Message message, SendCallback sendCallback) throws MessageRunTimeException {

    }

    /**
     * 消息的发送
     *
     * @param message
     * @throws MessageRunTimeException
     */
    @Override
    public void send(Message message) throws MessageRunTimeException {

        Preconditions.checkNotNull(message.getTopic());
        String messageType = message.getMessageType();
        switch (messageType){
            case MessageType.RAPID:
                rabbitBroker.rapidSend(message);
                break;
            case MessageType.CONFIRM:
                rabbitBroker.confirmSend(message);
                break;
            case MessageType.RELIANT:
                rabbitBroker.reliantSend(message);
                break;
            default:
                break;
        }
    }

    /**
     * 消息的批量发送
     *
     * @param messages
     * @throws MessageRunTimeException
     */
    @Override
    public void send(List<Message> messages) throws MessageRunTimeException {

    }
}
