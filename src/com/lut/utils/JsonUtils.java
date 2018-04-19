package com.lut.utils;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

public class JsonUtils {

    private static Gson gson = new Gson();

    private JsonUtils() {

    }

    /**
     * 
     * @MethodName : toJson
     * @Description : 将对象转换为JSON串， 此方法能够满足大部分需求
     * @param src：将要被转化的对象
     * 	   @return：
     */
    public static String toJson(Object src) {
	if (src == null) {
	    return gson.toJson(JsonNull.INSTANCE);
	}
	return gson.toJson(src);
    }

}
