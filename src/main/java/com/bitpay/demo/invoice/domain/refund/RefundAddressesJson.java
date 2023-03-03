/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.refund;

import lombok.NonNull;

public class RefundAddressesJson {

    private String value;

    public RefundAddressesJson(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected RefundAddressesJson() {
    }
}
