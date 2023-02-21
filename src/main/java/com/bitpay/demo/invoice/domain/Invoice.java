/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class Invoice {

    private Long id;
    private Fields fields;
    private Response response;

    Invoice() {
    }

    public Invoice(
        @NonNull final Fields fields,
        @NonNull final Response response
    ) {
        this.fields = fields;
        this.response = response;
    }
}
