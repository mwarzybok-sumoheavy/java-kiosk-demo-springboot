/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.domain;

import java.util.Objects;
import javax.annotation.Nullable;

public class EntityPageSize {

    private static final int DEFAULT_VALUE = 10;

    private final Integer value;

    public EntityPageSize(@Nullable final Integer value) {
        this.value = value;
    }

    public int value() {
        if (Objects.isNull(this.value)) {
            return DEFAULT_VALUE;
        }

        return this.value;
    }
}
