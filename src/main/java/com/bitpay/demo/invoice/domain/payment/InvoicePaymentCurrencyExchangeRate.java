/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import com.bitpay.demo.invoice.domain.CurrencyCode;
import lombok.NonNull;

public class InvoicePaymentCurrencyExchangeRate {
    private Long id;
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
}
