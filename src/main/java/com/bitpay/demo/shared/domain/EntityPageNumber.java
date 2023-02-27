/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.domain;

import java.util.Objects;
import javax.annotation.Nullable;

public class EntityPageNumber {

    private static final int DEFAULT_VALUE = 1;

    private final Integer value;

    public EntityPageNumber(@Nullable final Integer value) {
        this.value = value;
    }

    public int value() {
        if (Objects.isNull(this.value)) {
            return DEFAULT_VALUE;
        }

        return this.value;
    }
}
