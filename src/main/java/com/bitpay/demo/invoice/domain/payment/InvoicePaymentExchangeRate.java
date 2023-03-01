/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import lombok.NonNull;

public class InvoicePaymentExchangeRate {
    private Long id;
    private InvoicePaymentTotal paymentTotal;
    private CurrencyCode currencyCode;
    private ExchangeRate exchangeRate;

    public InvoicePaymentExchangeRate(
        @NonNull final InvoicePaymentTotal paymentTotal,
        @NonNull final CurrencyCode currencyCode,
        @NonNull final ExchangeRate exchangeRate
    ) {
        this.paymentTotal = paymentTotal;
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

    InvoicePaymentExchangeRate() {
    }
}
