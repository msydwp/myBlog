package com.uy.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;

public class JsonUtils {

    // 将对象转换为 JSON 字符串
    public static String toJsonString(Object object) {
        return JSON.toJSONString(object);
    }

    // 将 JSON 字符串转换为指定类型的对象
    public static <T> T fromJsonString(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz);
    }

    // 将 JSON 字符串转换为 JSONObject 对象
    public static JSONObject toJsonObject(String jsonString) {
        return JSON.parseObject(jsonString);
    }

    // 将对象转换为格式化的 JSON 字符串
    public static String toFormattedJsonString(Object object) {
        return JSON.toJSONString(object, SerializerFeature.PrettyFormat);
    }


}
