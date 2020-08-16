package com.sue.rabbit.common.serializer;

/**
 * @author sue
 * @date 2020/8/16 9:39
 */

/**
 * 序列化和反序列化接口
 */
public interface Serializer {
    byte[] serializeRaw(Object data);
    String serialize(Object data);
    <T> T deserialize(String content);
    <T> T deserialize(byte[] content);
}
