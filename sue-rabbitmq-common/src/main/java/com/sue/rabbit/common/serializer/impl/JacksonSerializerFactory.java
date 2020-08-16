package com.sue.rabbit.common.serializer.impl;


import com.sue.rabbit.common.serializer.Serializer;
import com.sue.rabbit.common.serializer.SerializerFactory;
import com.sue.rabbit.entity.Message;

public class JacksonSerializerFactory implements SerializerFactory {

	public static final SerializerFactory INSTANCE = new JacksonSerializerFactory();

	@Override
	public Serializer create() {
		return JacksonSerializer.createParametricType(Message.class);
	}

}
