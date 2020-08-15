package com.sue.rabbit.exception;

/**
 * @author sue
 * @date 2020/8/15 16:42
 */

/**
 * 运行时异常
 */
public class MessageRunTimeException extends RuntimeException{
    public MessageRunTimeException(){
        super();
    }
    public MessageRunTimeException(String message){
        super(message);
    }
    public MessageRunTimeException(String message,Throwable cause){
        super(message,cause);
    }
    public MessageRunTimeException(Throwable cause){
        super(cause);
    }
}
