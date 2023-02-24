/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

public class TargetConfirmations {

    private long value;

    public TargetConfirmations(final long value) {
        this.value = value;
    }

    public long value() {
        return this.value;
    }

    protected TargetConfirmations() {
    }
}
