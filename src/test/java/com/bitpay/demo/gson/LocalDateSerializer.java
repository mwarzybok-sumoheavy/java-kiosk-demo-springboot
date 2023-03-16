/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateSerializer implements JsonSerializer<LocalDate> {

    @Override
    public JsonElement serialize(
        final LocalDate localDate,
        final Type type,
        final JsonSerializationContext context
    ) throws JsonParseException {
        return new JsonPrimitive(localDate.toString());
    }
}
