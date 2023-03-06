/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.transaction;

import lombok.NonNull;

public class Confirmations {

    private Integer value;

    public Confirmations(final @NonNull Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }

    protected Confirmations() {
    }
}
