package com.bitmart.api.common;

import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Modifier;

@Slf4j
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
        try {
            final JsonElement jsonElement = JsonParser.parseString(json);
            if (jsonElement != null && jsonElement.isJsonObject()) {
                final JsonObject asJsonObject = jsonElement.getAsJsonObject();
                if (asJsonObject != null && asJsonObject.has(field)) {
                    return asJsonObject.get(field).getAsString();
                }
            }
        } catch (Exception e) {
            log.warn("fromJson", e);
        }

        return null;
    }

}
