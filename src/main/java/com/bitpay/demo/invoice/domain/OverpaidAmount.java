/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class OverpaidAmount {

    private Double value;

    public OverpaidAmount(final @NonNull Double value) {
        this.value = value;
    }

    protected OverpaidAmount() {
    }

    public Double value() {
        return this.value;
    }
}
