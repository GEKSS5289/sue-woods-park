package com.sue.rabbit.producer.broker;

import com.sue.rabbit.api.producer.MessageProducer;
import com.sue.rabbit.api.producer.SendCallback;
import com.sue.rabbit.entity.Message;
import com.sue.rabbit.exception.MessageRunTimeException;

import java.util.List;

/**
 * @author sue
 * @date 2020/8/15 17:08
 */

public class ProducerClient implements MessageProducer {
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
