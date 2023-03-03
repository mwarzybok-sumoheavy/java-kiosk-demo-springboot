/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.refund;


import com.bitpay.demo.invoice.domain.CurrencyCode;
import lombok.NonNull;

public class InvoiceRefundInfoAmount {
    private Long id;
    private InvoiceRefundInfo invoiceRefundInfo;
    private CurrencyCode currencyCode;
    private Amount amount;

    public InvoiceRefundInfoAmount(
        @NonNull final InvoiceRefundInfo invoiceRefundInfo,
        @NonNull final CurrencyCode currencyCode,
        @NonNull final Amount amount
    ) {
        this.invoiceRefundInfo = invoiceRefundInfo;
        this.currencyCode = currencyCode;
        this.amount = amount;
    }

    InvoiceRefundInfoAmount() {
    }
}
