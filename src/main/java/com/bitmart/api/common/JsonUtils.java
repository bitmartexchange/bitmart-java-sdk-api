package com.bitmart.api.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

public final class JsonUtils {
    public JsonUtils() {
    }

    public static String toJson(Object obj) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.PROTECTED) // <---
                .create();
        return gson.toJson(obj);
    }


}
