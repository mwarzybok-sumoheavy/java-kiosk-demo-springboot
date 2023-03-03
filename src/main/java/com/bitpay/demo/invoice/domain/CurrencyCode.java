/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class CurrencyCode {

    private String value;

    public CurrencyCode(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected CurrencyCode() {
    }
}
