/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.form;

import com.bitpay.demo.shared.bitpayproperties.Field;
import lombok.NonNull;

public class MissingRequiredField extends RuntimeException {

    private final Field field;

    public MissingRequiredField(@NonNull final Field field) {
        this.field = field;
    }

    @Override
    @NonNull
    public String getMessage() {
        return String.format("Value for field %s is missing.", this.field.getLabel());
    }
}
