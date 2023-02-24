/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class InvoiceId {

    private Long value;

    public InvoiceId(final @NonNull Long value) {
        this.value = value;
    }

    protected InvoiceId() {
    }

    public Long value() {
        return this.value;
    }
}
