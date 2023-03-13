/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared;

import com.bitpay.demo.DependencyInjection;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;
import lombok.NonNull;

@DependencyInjection
public class StringToObjectParser {

    private static final HashMap<Class<?>, Function<String, ?>> PARSER = new HashMap<>();

    static {
        PARSER.put(boolean.class, Boolean::parseBoolean);
        PARSER.put(int.class, Integer::parseInt);
        PARSER.put(long.class, Long::parseLong);
        PARSER.put(Boolean.class, Boolean::valueOf);
        PARSER.put(Integer.class, Integer::valueOf);
        PARSER.put(Long.class, Long::valueOf);
        PARSER.put(Double.class, Double::valueOf);
        PARSER.put(Float.class, Float::valueOf);
        PARSER.put(String.class, String::valueOf);
        PARSER.put(BigDecimal.class, BigDecimal::new);
        PARSER.put(BigInteger.class, BigInteger::new);
        PARSER.put(LocalDate.class, LocalDate::parse);
    }

    @Nullable
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Object parse(
        @NonNull final Class classType,
        @Nullable final String value
    ) throws UnsupportedOperationException {
        if (Objects.isNull(value)) {
            return null;
        }

        final Function<String, ?> func = PARSER.get(classType);
        if (Objects.nonNull(func)) {
            return func.apply(value);
        }

        if (classType.isEnum()) {
            return Enum.valueOf(classType, value);
        }

        throw new UnsupportedOperationException("Cannot parse string to " + classType.getName());
    }
}
