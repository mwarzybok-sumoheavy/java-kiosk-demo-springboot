/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import lombok.NonNull;

public class Subtotal {

    private String value;

    public Subtotal(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected Subtotal() {
    }
}
