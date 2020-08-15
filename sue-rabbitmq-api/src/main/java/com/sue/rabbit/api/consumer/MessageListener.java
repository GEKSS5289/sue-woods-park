package com.sue.rabbit.api.consumer;

import com.sue.rabbit.entity.Message;

/**
 * @author sue
 * @date 2020/8/15 16:54
 */


/**
 * 消费者监听
 */
public interface MessageListener {
    void onMessage(Message message);
}
