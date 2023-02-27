/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.buyer;

import lombok.NonNull;

public class BuyerEmailAddress {

    private String value;

    public BuyerEmailAddress(final @NonNull String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    protected BuyerEmailAddress() {
    }
}
