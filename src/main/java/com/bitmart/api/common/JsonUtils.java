package com.bitmart.api.common;

import com.google.gson.*;

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

    public static String fromJson(String json, String field) {
        JsonElement fieldElement = JsonParser.parseString(json).getAsJsonObject().get(field);
        return fieldElement == null ? "" : fieldElement.getAsString();
    }

}
