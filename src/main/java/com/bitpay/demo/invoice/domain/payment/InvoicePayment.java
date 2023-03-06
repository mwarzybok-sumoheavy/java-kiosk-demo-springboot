/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import lombok.NonNull;

public class InvoicePayment {

    private Long id;
    private AmountPaid amountPaid;
    private DisplayAmountPaid displayAmountPaid;
    private UnderpaidAmount underpaidAmount;
    private OverpaidAmount overpaidAmount;
    private NonPayProPaymentReceived nonPayProPaymentReceived;
    private UniversalCodesPaymentString universalCodesPaymentString;
    private UniversalCodesVerificationLink universalCodesVerificationLink;
    private TransactionCurrency transactionCurrency;
    private Collection<InvoicePaymentCurrency> paymentCurrencies = List.of();

    public InvoicePayment(
        @NonNull final AmountPaid amountPaid,
        @NonNull final DisplayAmountPaid displayAmountPaid,
        @NonNull final NonPayProPaymentReceived nonPayProPaymentReceived,
        @NonNull final UniversalCodesPaymentString universalCodesPaymentString,
        @NonNull final UniversalCodesVerificationLink universalCodesVerificationLink,
        @NonNull final TransactionCurrency transactionCurrency,
        @Nullable final UnderpaidAmount underpaidAmount,
        @Nullable final OverpaidAmount overpaidAmount
    ) {
        this.amountPaid = amountPaid;
        this.displayAmountPaid = displayAmountPaid;
        this.nonPayProPaymentReceived = nonPayProPaymentReceived;
        this.universalCodesPaymentString = universalCodesPaymentString;
        this.universalCodesVerificationLink = universalCodesVerificationLink;
        this.transactionCurrency = transactionCurrency;
        this.underpaidAmount = underpaidAmount;
        this.overpaidAmount = overpaidAmount;
    }

    InvoicePayment() {
    }

    public void addPaymentCurrencies(@NonNull final Collection<InvoicePaymentCurrency> invoicePaymentTotal) {
        final var paymentCurrencies = new ArrayList<>(this.paymentCurrencies);
        paymentCurrencies.addAll(invoicePaymentTotal);

        this.paymentCurrencies = paymentCurrencies;
    }
}
