/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import com.bitpay.demo.invoice.domain.CurrencyCode;
import com.bitpay.demo.shared.FieldExcludedFromSerialization;
import lombok.NonNull;

public class InvoicePaymentCurrencyExchangeRate {
    private Long id;

    @FieldExcludedFromSerialization
    private InvoicePaymentCurrency paymentCurrency;
    private CurrencyCode currencyCode;
    private Rate rate;

    public InvoicePaymentCurrencyExchangeRate(
        @NonNull final InvoicePaymentCurrency paymentCurrency,
        @NonNull final CurrencyCode currencyCode,
        @NonNull final Rate rate
    ) {
        this.paymentCurrency = paymentCurrency;
        this.currencyCode = currencyCode;
        this.rate = rate;
    }

    InvoicePaymentCurrencyExchangeRate() {
    }

    public Long getId() {
        return this.id;
    }

    public InvoicePaymentCurrency getPaymentCurrency() {
        return this.paymentCurrency;
    }

    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public Rate getRate() {
        return this.rate;
    }
}
