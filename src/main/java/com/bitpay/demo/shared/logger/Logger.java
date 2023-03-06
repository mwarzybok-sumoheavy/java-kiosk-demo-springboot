/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.logger;

import java.util.Map;
import lombok.NonNull;

public interface Logger {

    void info(
        @NonNull LogCode code,
        @NonNull String message,
        @NonNull Map<String, Object> context
    );

    void error(
        @NonNull LogCode code,
        @NonNull String message,
        @NonNull Map<String, Object> context
    );

}
