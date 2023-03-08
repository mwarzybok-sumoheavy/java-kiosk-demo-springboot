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
        @Nullable final AmountPaid amountPaid,
        @Nullable final DisplayAmountPaid displayAmountPaid,
        @Nullable final NonPayProPaymentReceived nonPayProPaymentReceived,
        @Nullable final UniversalCodesPaymentString universalCodesPaymentString,
        @Nullable final UniversalCodesVerificationLink universalCodesVerificationLink,
        @Nullable final TransactionCurrency transactionCurrency,
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

    public AmountPaid getAmountPaid() {
        return this.amountPaid;
    }

    public DisplayAmountPaid getDisplayAmountPaid() {
        return this.displayAmountPaid;
    }

    public UnderpaidAmount getUnderpaidAmount() {
        return this.underpaidAmount;
    }

    public OverpaidAmount getOverpaidAmount() {
        return this.overpaidAmount;
    }

    public NonPayProPaymentReceived getNonPayProPaymentReceived() {
        return this.nonPayProPaymentReceived;
    }

    public UniversalCodesPaymentString getUniversalCodesPaymentString() {
        return this.universalCodesPaymentString;
    }

    public UniversalCodesVerificationLink getUniversalCodesVerificationLink() {
        return this.universalCodesVerificationLink;
    }

    public TransactionCurrency getTransactionCurrency() {
        return this.transactionCurrency;
    }

    public Collection<InvoicePaymentCurrency> getPaymentCurrencies() {
        return this.paymentCurrencies;
    }

    public void addPaymentCurrencies(@NonNull final Collection<InvoicePaymentCurrency> invoicePaymentTotal) {
        final var paymentCurrencies = new ArrayList<>(this.paymentCurrencies);
        paymentCurrencies.addAll(invoicePaymentTotal);

        this.paymentCurrencies = paymentCurrencies;
    }

    public void update(@NonNull final InvoicePayment invoicePayment) {
        this.amountPaid = invoicePayment.getAmountPaid();
        this.transactionCurrency = invoicePayment.getTransactionCurrency();
    }
}
