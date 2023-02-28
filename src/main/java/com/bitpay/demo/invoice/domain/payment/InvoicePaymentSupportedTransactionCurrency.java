/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import javax.annotation.Nullable;
import lombok.NonNull;

public class InvoicePaymentSupportedTransactionCurrency {
    private Long id;
    private Enabled enabled;
    private Reason reason;

    public InvoicePaymentSupportedTransactionCurrency(
        @NonNull final Enabled enabled,
        @Nullable final Reason reason
    ) {
        this.enabled = enabled;
        this.reason = reason;
    }

    InvoicePaymentSupportedTransactionCurrency() {
    }
}
