/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import lombok.NonNull;

public class FiatAmount {

    private Double value;

    public FiatAmount(final @NonNull Double value) {
        this.value = value;
    }

    public Double value() {
        return this.value;
    }

    protected FiatAmount() {
    }
}
