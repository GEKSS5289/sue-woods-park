package com.sue.rabbit.producer.broker;

import com.sue.rabbit.entity.Message;

/**
 * @author sue
 * @date 2020/8/16 8:44
 */


public interface RabbitBroker {
    void rapidSend(Message message);
    void confirmSend(Message message);
    void reliantSend(Message message);
    void sendMessage();
}
