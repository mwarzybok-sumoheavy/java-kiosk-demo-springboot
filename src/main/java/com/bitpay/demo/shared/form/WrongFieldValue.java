/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.form;

import com.bitpay.demo.shared.bitpayproperties.Field;
import lombok.NonNull;

public class WrongFieldValue extends RuntimeException {

    private final Field field;
    private final Object value;

    public WrongFieldValue(
        @NonNull final Field field,
        @NonNull final Object value
    ) {
        this.field = field;
        this.value = value;
    }

    @Override
    @NonNull
    public String getMessage() {
        return String.format(
            "Field: %s has wrong value: %s.",
            this.field.getLabel(),
            this.value.toString()
        );
    }
}
