package com.sue.rabbit.api.producer;

import com.sue.rabbit.entity.Message;
import com.sue.rabbit.exception.MessageRunTimeException;

import java.util.List;

/**
 * @author sue
 * @date 2020/8/15 16:49
 */

public interface MessageProducer {

    /**
     * 消息的发送 附带SendCallBack回调执行响应的业务逻辑处理
     * @param message
     * @param sendCallback
     * @throws MessageRunTimeException
     */
    void send(Message message,SendCallback sendCallback) throws MessageRunTimeException;

    /**
     * 消息的发送
     * @param message
     * @throws MessageRunTimeException
     */
    void send(Message message) throws MessageRunTimeException;

    /**
     * 消息的批量发送
     * @param messages
     * @throws MessageRunTimeException
     */
    void send(List<Message> messages) throws MessageRunTimeException;
}
