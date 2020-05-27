package com.bitmart.api.common;

import com.bitmart.api.response.CloudResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;

public final class JsonUtils {
    public JsonUtils() {
    }

    public static CloudResponse toObj(String src, Type type) {
        Gson gson = new Gson();
        return (CloudResponse) gson.fromJson(src, type);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        Gson gson = new Gson();
        return (T) gson.fromJson(json, clazz);
    }

    public static String toJson(Object obj) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.PROTECTED) // <---
                .create();
        return gson.toJson(obj);
    }

    public static Map toMap(String src) {
        Gson gson = new Gson();
        return gson.fromJson(src, Map.class);
    }


}
