/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

public class NonPayProPaymentReceived {

    private boolean value;

    public NonPayProPaymentReceived(final boolean value) {
        this.value = value;
    }

    public boolean value() {
        return this.value;
    }

    protected NonPayProPaymentReceived() {
    }
}
