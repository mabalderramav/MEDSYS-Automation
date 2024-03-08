package com.bo.medsys.automation.core.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParser {
    private JsonParser() {
        // Default constructor.
    }

    public static <T> String toJsonString(final T object, final Class<T> entityClass) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        return gson.toJson(object, entityClass);
    }

    public static <T> T fromJsonString(final String json, final Class<T> entityClass) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.fromJson(json, entityClass);
    }
}
