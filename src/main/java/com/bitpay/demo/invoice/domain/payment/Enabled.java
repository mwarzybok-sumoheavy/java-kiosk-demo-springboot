/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

public class Enabled {

    private boolean value;

    public Enabled(final boolean value) {
        this.value = value;
    }

    public boolean value() {
        return this.value;
    }

    protected Enabled() {
    }
}
