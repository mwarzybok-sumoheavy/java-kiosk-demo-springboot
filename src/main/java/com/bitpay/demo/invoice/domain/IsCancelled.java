/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

public class IsCancelled {

    private boolean value;

    public IsCancelled(final boolean value) {
        this.value = value;
    }

    public boolean value() {
        return this.value;
    }

    protected IsCancelled() {
    }
}
