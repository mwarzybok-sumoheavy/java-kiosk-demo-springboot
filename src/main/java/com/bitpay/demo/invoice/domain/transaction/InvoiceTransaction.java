/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.transaction;

import com.bitpay.demo.invoice.domain.Amount;
import com.bitpay.demo.invoice.domain.Invoice;
import java.time.LocalDate;
import lombok.NonNull;

public class InvoiceTransaction {
    private Long id;
    private Invoice invoice;
    private Amount amount;
    private Confirmations confirmations;
    private LocalDate time;
    private LocalDate receivedTime;
    private Txid txid;

    public InvoiceTransaction(
        @NonNull final Invoice invoice,
        @NonNull final Amount amount,
        @NonNull final Confirmations confirmations,
        @NonNull final LocalDate time,
        @NonNull final LocalDate receivedTime,
        @NonNull final Txid txid
    ) {
        this.invoice = invoice;
        this.amount = amount;
        this.confirmations = confirmations;
        this.time = time;
        this.receivedTime = receivedTime;
        this.txid = txid;
    }

    InvoiceTransaction() {
    }
}
