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
        JsonObject returnObj = new JsonParser().parse(json).getAsJsonObject();
        JsonElement jsonElement = returnObj.get(field);

        return jsonElement == null ? "" : jsonElement.getAsString();
    }

    public static Boolean fromJsonAsBoolean(String json, String field) {
        JsonObject returnObj = new JsonParser().parse(json).getAsJsonObject();

        JsonElement jsonElement = returnObj.get(field);

        return jsonElement == null ? true : jsonElement.getAsBoolean();
    }
}
