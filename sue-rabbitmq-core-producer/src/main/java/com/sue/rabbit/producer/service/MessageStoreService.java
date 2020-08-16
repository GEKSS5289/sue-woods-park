package com.sue.rabbit.producer.service;

import com.sue.rabbit.producer.constant.BrokerMessageStatus;
import com.sue.rabbit.producer.mapper.BrokerMessageMapper;
import com.sue.rabbit.producer.pojo.BrokerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sue
 * @date 2020/8/16 11:50
 */

@Service
public class MessageStoreService {
    @Autowired
    private BrokerMessageMapper brokerMessageMapper;
    public int insert(BrokerMessage brokerMessage){
        return this.brokerMessageMapper.insert(brokerMessage);
    }

    public void success(String messageId) {
        this.brokerMessageMapper.changeBrokerMessageStatus(messageId, BrokerMessageStatus.SEND_OK.getCode(),new Date());
    }

    public void failure(String messageId){
        this.brokerMessageMapper.changeBrokerMessageStatus(messageId, BrokerMessageStatus.SEND_FAIL.getCode(),new Date());
    }
}
