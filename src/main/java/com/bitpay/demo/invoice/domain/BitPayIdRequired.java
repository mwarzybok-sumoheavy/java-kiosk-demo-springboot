/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

public class BitPayIdRequired {

    private boolean value;

    public BitPayIdRequired(final boolean value) {
        this.value = value;
    }

    public boolean value() {
        return this.value;
    }

    protected BitPayIdRequired() {
    }
}
