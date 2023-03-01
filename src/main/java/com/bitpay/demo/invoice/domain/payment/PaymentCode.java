/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import lombok.NonNull;

public class PaymentCode {

    private String value;

    public PaymentCode(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected PaymentCode() {
    }
}
