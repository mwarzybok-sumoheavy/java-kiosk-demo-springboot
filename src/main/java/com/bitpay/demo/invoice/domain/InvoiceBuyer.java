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
    private BuyerProvidedInfoJson buyerProvidedInfo;

    public InvoiceBuyer(
        @NonNull final BuyerJson buyer,
        @NonNull final BuyerProvidedEmail buyerProvidedEmail,
        @NonNull final BuyerProvidedInfoJson buyerProvidedInfo
    ) {
        this.buyer = buyer;
        this.buyerProvidedEmail = buyerProvidedEmail;
        this.buyerProvidedInfo = buyerProvidedInfo;
    }

    InvoiceBuyer() {
    }
}
