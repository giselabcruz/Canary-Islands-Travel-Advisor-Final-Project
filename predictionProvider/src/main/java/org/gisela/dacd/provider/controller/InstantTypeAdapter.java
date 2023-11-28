package org.gisela.dacd.provider.controller;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.Instant;

public class InstantTypeAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {
    @Override
    public JsonElement serialize(Instant instant, Type srcType,
                                 JsonSerializationContext context) {
        return new JsonPrimitive(instant.toString());
    }
    @Override
    public Instant deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context) throws JsonParseException {
        return Instant.parse(json.getAsString());
    }
}