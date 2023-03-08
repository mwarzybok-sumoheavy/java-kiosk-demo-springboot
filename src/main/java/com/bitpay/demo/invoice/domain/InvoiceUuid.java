/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class InvoiceUuid {

    private String value;

    public InvoiceUuid(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected InvoiceUuid() {
    }
}
