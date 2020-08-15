package com.sue.rabbit.exception;



/**
 * @author sue
 * @date 2020/8/15 16:38
 */

/**
 * 初始化异常
 */
public class MessageException extends Exception {
    public MessageException(){
        super();
    }
    public MessageException(String message){
        super(message);
    }
    public MessageException(String message,Throwable cause){
        super(message,cause);
    }
    public MessageException(Throwable cause){
        super(cause);
    }
}
