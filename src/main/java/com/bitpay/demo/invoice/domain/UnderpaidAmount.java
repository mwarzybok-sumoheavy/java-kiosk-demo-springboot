/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class UnderpaidAmount {

    private Double value;

    public UnderpaidAmount(final @NonNull Double value) {
        this.value = value;
    }

    protected UnderpaidAmount() {
    }

    public Double value() {
        return this.value;
    }
}
