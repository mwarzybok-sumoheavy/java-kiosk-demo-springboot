/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

public class AcceptanceWindow {

    private long value;

    public AcceptanceWindow(final long value) {
        this.value = value;
    }

    public long value() {
        return this.value;
    }

    protected AcceptanceWindow() {
    }
}
