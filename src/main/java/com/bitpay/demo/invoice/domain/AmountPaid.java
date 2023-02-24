/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class AmountPaid {

    private Double value;

    public AmountPaid(final @NonNull Double value) {
        this.value = value;
    }

    protected AmountPaid() {
    }

    public Double value() {
        return this.value;
    }
}
