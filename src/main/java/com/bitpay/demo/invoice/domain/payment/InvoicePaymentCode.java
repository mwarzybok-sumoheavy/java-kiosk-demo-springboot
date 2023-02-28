/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import lombok.NonNull;

public class InvoicePaymentCode {
    private Long id;
    private InvoicePaymentTotal paymentTotal;
    private PaymentCode paymentCode;
    private PaymentCodeUrl paymentCodeUrl;

    public InvoicePaymentCode(
        @NonNull final InvoicePaymentTotal paymentTotal,
        @NonNull final PaymentCode paymentCode,
        @NonNull final PaymentCodeUrl paymentCodeUrl
    ) {
        this.paymentTotal = paymentTotal;
        this.paymentCode = paymentCode;
        this.paymentCodeUrl = paymentCodeUrl;
    }

    InvoicePaymentCode() {
    }
}
