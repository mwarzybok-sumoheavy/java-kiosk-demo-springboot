/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.transaction;

import lombok.NonNull;

public class Txid {

    private String value;

    public Txid(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected Txid() {
    }
}
