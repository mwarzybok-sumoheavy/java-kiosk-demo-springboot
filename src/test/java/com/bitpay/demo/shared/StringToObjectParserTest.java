/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared;

import com.bitpay.demo.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringToObjectParserTest implements UnitTest {

    @Test
    void parseBooleanPrimitive() {
        // given
        final var classType = boolean.class;
        final var value = "true";

        // when
        final var result = getTestedClass().parse(classType, value);

        // then
        Assertions.assertEquals(true, result);
    }

    @Test
    void parseIntPrimitive() {
        // given
        final var classType = int.class;
        final var value = "1";

        // when
        final var result = getTestedClass().parse(classType, value);

        // then
        Assertions.assertEquals(1, result);
    }

    @Test
    void parseLongPrimitive() {
        // given
        final var classType = long.class;
        final var value = "1";

        // when
        final var result = getTestedClass().parse(classType, value);

        // then
        Assertions.assertEquals(1L, result);
    }

    @Test
    void parseBoolean() {
        // given
        final var classType = Boolean.class;
        final var value = "true";

        // when
        final var result = getTestedClass().parse(classType, value);

        // then
        Assertions.assertEquals(true, result);
    }

    @Test
    void parseInteger() {
        // given
        final var classType = Integer.class;
        final var value = "1";

        // when
        final var result = getTestedClass().parse(classType, value);

        // then
        Assertions.assertEquals(1, result);
    }

    @Test
    void parseLong() {
        // given
        final var classType = Long.class;
        final var value = "1";

        // when
        final var result = getTestedClass().parse(classType, value);

        // then
        Assertions.assertEquals(1L, result);
    }

    @Test
    void parseDouble() {
        // given
        final var classType = Double.class;
        final var value = "1.0";

        // when
        final var result = getTestedClass().parse(classType, value);

        // then
        Assertions.assertEquals(1.0, result);
    }

    @Test
    void parseFloat() {
        // given
        final var classType = Float.class;
        final var value = "1.0";

        // when
        final var result = getTestedClass().parse(classType, value);

        // then
        Assertions.assertEquals(1F, result);
    }

    private StringToObjectParser getTestedClass() {
        return new StringToObjectParser();
    }
}
