/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

public class JsonPayProRequired {

    private boolean value;

    public JsonPayProRequired(final boolean value) {
        this.value = value;
    }

    public boolean value() {
        return this.value;
    }

    protected JsonPayProRequired() {
    }
}
