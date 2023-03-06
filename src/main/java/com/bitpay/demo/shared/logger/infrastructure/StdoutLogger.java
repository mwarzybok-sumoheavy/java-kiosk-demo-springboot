/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.logger.infrastructure;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.shared.ObjectToJsonConverter;
import com.bitpay.demo.shared.logger.LogCode;
import com.bitpay.demo.shared.logger.Logger;
import java.sql.Timestamp;
import java.util.Map;
import lombok.NonNull;

@DependencyInjection
class StdoutLogger implements Logger {

    private final ObjectToJsonConverter objectToJsonConverter;

    StdoutLogger(@NonNull final ObjectToJsonConverter objectToJsonConverter) {
        this.objectToJsonConverter = objectToJsonConverter;
    }

    @Override
    public void info(
        @NonNull final LogCode code,
        @NonNull final String message,
        @NonNull final Map<String, Object> context
    ) {
        printLog("INFO", code, message, context);
    }

    @Override
    public void error(
        @NonNull final LogCode code,
        @NonNull final String message,
        @NonNull final Map<String, Object> context
    ) {
        printLog("ERROR", code, message, context);
    }

    private void printLog(
        @NonNull final String level,
        @NonNull final LogCode code,
        @NonNull final String message,
        @NonNull final Map<String, Object> context
    ) {
        final var json = this.objectToJsonConverter.execute(
            Map.of(
                "level", level,
                "timestamp", new Timestamp(System.currentTimeMillis()),
                "code", code,
                "message", message,
                "context", context
            )
        );

        System.out.println(json);
    }
}
