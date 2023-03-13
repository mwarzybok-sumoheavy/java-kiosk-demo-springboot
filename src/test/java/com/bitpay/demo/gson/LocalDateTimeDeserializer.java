/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.gson;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(
        final JsonElement json,
        final Type type,
        final JsonDeserializationContext jsonDeserializationContext
    ) throws JsonParseException {
        try {
            return LocalDateTime.parse(json.getAsString());
        } catch (final DateTimeParseException exception) {
            return new Gson().fromJson(json, LocalDateTime.class);
        }
    }
}
