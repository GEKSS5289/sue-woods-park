package com.sue.rabbit.producer.constant;

import lombok.Getter;

/**
 * @author sue
 * @date 2020/8/16 11:54
 */
@Getter
public enum BrokerMessageStatus {

    SENDING("0"),
    SEND_OK("1"),
    SEND_FAIL("2"),
    SEND_FAIL_A_MOMENT("3");
    private String code;

    BrokerMessageStatus(String code) {
        this.code = code;
    }


}
