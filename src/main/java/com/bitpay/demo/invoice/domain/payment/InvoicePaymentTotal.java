/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import com.bitpay.demo.invoice.domain.InvoicePayment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

public class InvoicePaymentTotal {

    private Long id;
    private InvoicePayment invoicePayment;
    private CurrencyCode currencyCode;
    private Total total;
    private Subtotal subtotal;
    private DisplayTotal displayTotal;
    private DisplaySubtotal displaySubtotal;
    private Collection<InvoicePaymentExchangeRate> exchangeRates = List.of();
    private Collection<InvoicePaymentCode> paymentCodes = List.of();
    private InvoicePaymentSupportedTransactionCurrency supportedTransactionCurrency;
    private InvoicePaymentMinerFee minerFee;

    public InvoicePaymentTotal(
        @NonNull final InvoicePayment invoicePayment,
        @NonNull final CurrencyCode currencyCode,
        @NonNull final Total total,
        @NonNull final Subtotal subtotal,
        @NonNull final DisplayTotal displayTotal,
        @NonNull final DisplaySubtotal displaySubtotal,
        @NonNull final InvoicePaymentSupportedTransactionCurrency supportedTransactionCurrency,
        @NonNull final InvoicePaymentMinerFee minerFee
    ) {
        this.invoicePayment = invoicePayment;
        this.currencyCode = currencyCode;
        this.total = total;
        this.subtotal = subtotal;
        this.displayTotal = displayTotal;
        this.displaySubtotal = displaySubtotal;
        this.supportedTransactionCurrency = supportedTransactionCurrency;
        this.minerFee = minerFee;
    }

    InvoicePaymentTotal() {
    }

    public void addExchangeRates(@NonNull final Collection<InvoicePaymentExchangeRate> paymentExchangeRates) {
        final var exchangeRates = new ArrayList<>(this.exchangeRates);
        exchangeRates.addAll(paymentExchangeRates);

        this.exchangeRates = exchangeRates;
    }

    public void addPaymentCodes(@NonNull final Collection<InvoicePaymentCode> invoicePaymentCodes) {
        final var paymentCodes = new ArrayList<>(this.paymentCodes);
        paymentCodes.addAll(invoicePaymentCodes);

        this.paymentCodes = paymentCodes;
    }
}
