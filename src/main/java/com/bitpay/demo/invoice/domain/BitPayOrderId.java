/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class BitPayOrderId {

    private String value;

    public BitPayOrderId(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected BitPayOrderId() {
    }
}
