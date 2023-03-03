/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.itemizeddetail;

import lombok.NonNull;

public class IsFee {

    private Boolean value;

    public IsFee(final @NonNull Boolean value) {
        this.value = value;
    }

    public Boolean value() {
        return this.value;
    }

    protected IsFee() {
    }
}
