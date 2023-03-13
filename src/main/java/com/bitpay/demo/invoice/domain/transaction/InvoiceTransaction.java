/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.transaction;

import com.bitpay.demo.invoice.domain.Amount;
import com.bitpay.demo.invoice.domain.Invoice;
import com.bitpay.demo.shared.FieldExcludedFromSerialization;
import java.time.LocalDate;
import javax.annotation.Nullable;
import lombok.NonNull;

public class InvoiceTransaction {
    private Long id;
    @FieldExcludedFromSerialization
    private Invoice invoice;
    private Amount amount;
    private Confirmations confirmations;
    private LocalDate receivedTime;
    private Txid txid;

    public InvoiceTransaction(
        @NonNull final Invoice invoice,
        @Nullable final Amount amount,
        @Nullable final Confirmations confirmations,
        @Nullable final LocalDate receivedTime,
        @Nullable final Txid txid
    ) {
        this.invoice = invoice;
        this.amount = amount;
        this.confirmations = confirmations;
        this.receivedTime = receivedTime;
        this.txid = txid;
    }

    InvoiceTransaction() {
    }
}
