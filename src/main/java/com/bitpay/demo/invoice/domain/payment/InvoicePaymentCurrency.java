/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import com.bitpay.demo.invoice.domain.CurrencyCode;
import com.bitpay.demo.shared.FieldExcludedFromSerialization;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

public class InvoicePaymentCurrency {

    private Long id;
    @FieldExcludedFromSerialization
    private InvoicePayment invoicePayment;
    private CurrencyCode currencyCode;
    private Total total;
    private Subtotal subtotal;
    private DisplayTotal displayTotal;
    private DisplaySubtotal displaySubtotal;
    private Collection<InvoicePaymentCurrencyExchangeRate> exchangeRates = List.of();
    private Collection<InvoicePaymentCurrencyCode> currencyCodes = List.of();
    private InvoicePaymentCurrencySupportedTransactionCurrency supportedTransactionCurrency;
    private InvoicePaymentCurrencyMinerFee minerFee;

    public InvoicePaymentCurrency(
        @NonNull final InvoicePayment invoicePayment,
        @NonNull final CurrencyCode currencyCode,
        @NonNull final Total total,
        @NonNull final Subtotal subtotal,
        @NonNull final DisplayTotal displayTotal,
        @NonNull final DisplaySubtotal displaySubtotal,
        @NonNull final InvoicePaymentCurrencySupportedTransactionCurrency supportedTransactionCurrency,
        @NonNull final InvoicePaymentCurrencyMinerFee minerFee
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

    InvoicePaymentCurrency() {
    }

    public Long getId() {
        return this.id;
    }

    public InvoicePayment getInvoicePayment() {
        return this.invoicePayment;
    }

    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public Total getTotal() {
        return this.total;
    }

    public Subtotal getSubtotal() {
        return this.subtotal;
    }

    public DisplayTotal getDisplayTotal() {
        return this.displayTotal;
    }

    public DisplaySubtotal getDisplaySubtotal() {
        return this.displaySubtotal;
    }

    public Collection<InvoicePaymentCurrencyExchangeRate> getExchangeRates() {
        return this.exchangeRates;
    }

    public Collection<InvoicePaymentCurrencyCode> getCurrencyCodes() {
        return this.currencyCodes;
    }

    public InvoicePaymentCurrencySupportedTransactionCurrency getSupportedTransactionCurrency() {
        return this.supportedTransactionCurrency;
    }

    public InvoicePaymentCurrencyMinerFee getMinerFee() {
        return this.minerFee;
    }

    public void addExchangeRates(@NonNull final Collection<InvoicePaymentCurrencyExchangeRate> paymentExchangeRates) {
        final var exchangeRates = new ArrayList<>(this.exchangeRates);
        exchangeRates.addAll(paymentExchangeRates);

        this.exchangeRates = exchangeRates;
    }

    public void addPaymentCodes(@NonNull final Collection<InvoicePaymentCurrencyCode> invoicePaymentCodes) {
        final var paymentCodes = new ArrayList<>(this.currencyCodes);
        paymentCodes.addAll(invoicePaymentCodes);

        this.currencyCodes = paymentCodes;
    }
}
