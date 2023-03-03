/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.itemizeddetail;

import lombok.NonNull;

public class Description {

    private String value;

    public Description(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected Description() {
    }
}
