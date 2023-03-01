/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import lombok.NonNull;

public class SatoshisPerByte {

    private Double value;

    public SatoshisPerByte(final @NonNull Double value) {
        this.value = value;
    }

    public Double value() {
        return this.value;
    }

    protected SatoshisPerByte() {
    }
}
