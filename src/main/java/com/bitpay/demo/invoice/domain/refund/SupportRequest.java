/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.refund;

import lombok.NonNull;

public class SupportRequest {

    private String value;

    public SupportRequest(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected SupportRequest() {
    }
}
