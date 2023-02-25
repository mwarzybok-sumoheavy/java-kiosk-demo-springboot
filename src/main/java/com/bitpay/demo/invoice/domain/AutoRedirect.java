/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

public class AutoRedirect {

    private boolean value;

    public AutoRedirect(final boolean value) {
        this.value = value;
    }

    protected AutoRedirect() {
    }

    public boolean value() {
        return this.value;
    }
}
