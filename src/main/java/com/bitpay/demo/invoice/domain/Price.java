/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class Price {

    private Double value;

    public Price(final @NonNull Double value) {
        this.value = value;
    }

    public Double value() {
        return this.value;
    }

    protected Price() {
    }
}
