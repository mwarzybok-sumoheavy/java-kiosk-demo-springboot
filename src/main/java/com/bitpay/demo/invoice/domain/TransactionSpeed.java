/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class TransactionSpeed {

    private String value;

    public TransactionSpeed(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected TransactionSpeed() {
    }
}
