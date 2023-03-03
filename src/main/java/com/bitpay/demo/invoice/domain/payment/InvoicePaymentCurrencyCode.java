/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import lombok.NonNull;

public class InvoicePaymentCurrencyCode {
    private Long id;
    private InvoicePaymentCurrency paymentCurrency;
    private PaymentCode paymentCode;
    private PaymentCodeUrl paymentCodeUrl;

    public InvoicePaymentCurrencyCode(
        @NonNull final InvoicePaymentCurrency paymentCurrency,
        @NonNull final PaymentCode paymentCode,
        @NonNull final PaymentCodeUrl paymentCodeUrl
    ) {
        this.paymentCurrency = paymentCurrency;
        this.paymentCode = paymentCode;
        this.paymentCodeUrl = paymentCodeUrl;
    }

    InvoicePaymentCurrencyCode() {
    }
}
