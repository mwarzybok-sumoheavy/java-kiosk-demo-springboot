/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.config.Field;
import lombok.NonNull;

class MissingRequiredField extends RuntimeException {

    private final Field field;

    public MissingRequiredField(@NonNull final Field field) {
        this.field = field;
    }
}
