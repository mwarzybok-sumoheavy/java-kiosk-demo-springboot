/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import lombok.NonNull;

public class Reason {

    private String value;

    public Reason(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected Reason() {
    }
}
