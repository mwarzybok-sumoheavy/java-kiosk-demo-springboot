/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class PosData {

    private String value;

    public PosData(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected PosData() {
    }
}
