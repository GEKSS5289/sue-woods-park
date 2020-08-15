package com.sue.rabbit.api.producer;

/**
 * @author sue
 * @date 2020/8/15 16:51
 */

/**
 * 回调函数处理
 */
public interface SendCallback {
    void onSuccess();
    void onFailure();
}
