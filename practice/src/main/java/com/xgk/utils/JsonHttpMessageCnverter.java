package com.xgk.utils;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

public class JsonHttpMessageCnverter extends FastJsonHttpMessageConverter {
	@Override
	protected void writeInternal(Object obj,HttpOutputMessage outputMessagge) throws HttpMessageNotWritableException, IOException {
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		String json = JSON.toJSONString(obj,SerializerFeature.WriteDateUseDateFormat);
		System.out.println(json);
		super.writeInternal(obj, outputMessagge);
	}
}
