/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import lombok.NonNull;

public class DisplaySubtotal {

    private String value;

    public DisplaySubtotal(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected DisplaySubtotal() {
    }
}
