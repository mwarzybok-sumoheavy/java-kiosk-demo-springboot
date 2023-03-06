/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.buyer;

import lombok.NonNull;

public class BuyerNotify {

    private Boolean value;

    public BuyerNotify(final @NonNull Boolean value) {
        this.value = value;
    }

    public Boolean value() {
        return this.value;
    }

    protected BuyerNotify() {
    }
}
