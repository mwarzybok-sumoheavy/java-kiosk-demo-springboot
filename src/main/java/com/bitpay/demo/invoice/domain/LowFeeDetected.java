/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

public class LowFeeDetected {

    private boolean value;

    public LowFeeDetected(final boolean value) {
        this.value = value;
    }

    protected LowFeeDetected() {
    }

    public boolean value() {
        return this.value;
    }
}
