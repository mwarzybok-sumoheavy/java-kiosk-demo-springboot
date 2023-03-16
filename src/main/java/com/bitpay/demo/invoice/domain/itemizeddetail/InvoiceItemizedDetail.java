/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.itemizeddetail;

import com.bitpay.demo.invoice.domain.Amount;
import com.bitpay.demo.invoice.domain.Invoice;
import com.bitpay.demo.shared.FieldExcludedFromSerialization;
import lombok.NonNull;

public class InvoiceItemizedDetail {
    private Long id;
    @FieldExcludedFromSerialization
    private Invoice invoice;
    private Amount amount;
    private Description description;
    private IsFee isFee;

    public InvoiceItemizedDetail(
        @NonNull final Invoice invoice,
        @NonNull final Amount amount,
        @NonNull final Description description,
        @NonNull final IsFee isFee
    ) {
        this.invoice = invoice;
        this.amount = amount;
        this.description = description;
        this.isFee = isFee;
    }

    InvoiceItemizedDetail() {
    }
}
