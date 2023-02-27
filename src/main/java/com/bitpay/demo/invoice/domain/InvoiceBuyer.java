/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public class InvoiceBuyer {

    private Long id;
    private BuyerJson buyer;
    private BuyerProvidedEmail buyerProvidedEmail;

    public InvoiceBuyer(
        @NonNull final BuyerJson buyer,
        @NonNull final BuyerProvidedEmail buyerProvidedEmail
    ) {
        this.buyer = buyer;
        this.buyerProvidedEmail = buyerProvidedEmail;
    }

    InvoiceBuyer() {
    }
}
