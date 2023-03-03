/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.refund;

public class RefundAddressRequestPending {

    private boolean value;

    public RefundAddressRequestPending(final boolean value) {
        this.value = value;
    }

    protected RefundAddressRequestPending() {
    }

    public boolean value() {
        return this.value;
    }
}
