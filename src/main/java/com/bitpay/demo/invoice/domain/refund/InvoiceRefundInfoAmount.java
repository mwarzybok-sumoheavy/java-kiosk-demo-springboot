/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.refund;


import com.bitpay.demo.invoice.domain.CurrencyCode;
import com.bitpay.demo.shared.FieldExcludedFromSerialization;
import lombok.NonNull;

public class InvoiceRefundInfoAmount {
    private Long id;
    @FieldExcludedFromSerialization
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

    public Long getId() {
        return this.id;
    }

    public InvoiceRefundInfo getInvoiceRefundInfo() {
        return this.invoiceRefundInfo;
    }

    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public Amount getAmount() {
        return this.amount;
    }
}
