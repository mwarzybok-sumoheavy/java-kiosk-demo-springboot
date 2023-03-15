/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.shared.bitpayproperties.Field;
import lombok.NonNull;

class MissingRequiredField extends RuntimeException {

    private final Field field;

    MissingRequiredField(@NonNull final Field field) {
        this.field = field;
    }

    @NonNull
    public String getMessage() {
        return String.format("Value for field %s is missing.", this.field.getLabel());
    }
}
