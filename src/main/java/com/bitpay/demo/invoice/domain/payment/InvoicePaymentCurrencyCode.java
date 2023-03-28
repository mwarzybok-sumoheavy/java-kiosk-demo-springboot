/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import com.bitpay.demo.shared.FieldExcludedFromSerialization;
import lombok.NonNull;

public class InvoicePaymentCurrencyCode {
    private Long id;
    @FieldExcludedFromSerialization
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

    public Long getId() {
        return this.id;
    }

    public InvoicePaymentCurrency getPaymentCurrency() {
        return this.paymentCurrency;
    }

    public PaymentCode getPaymentCode() {
        return this.paymentCode;
    }

    public PaymentCodeUrl getPaymentCodeUrl() {
        return this.paymentCodeUrl;
    }
}
