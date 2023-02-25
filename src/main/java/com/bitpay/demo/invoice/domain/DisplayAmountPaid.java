/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class DisplayAmountPaid {

    private Double value;

    public DisplayAmountPaid(final @NonNull Double value) {
        this.value = value;
    }

    protected DisplayAmountPaid() {
    }

    public Double value() {
        return this.value;
    }
}
