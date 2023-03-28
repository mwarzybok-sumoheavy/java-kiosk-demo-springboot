/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import javax.annotation.Nullable;
import lombok.NonNull;

public class InvoicePaymentCurrencySupportedTransactionCurrency {
    private Long id;
    private Enabled enabled;
    private Reason reason;

    public InvoicePaymentCurrencySupportedTransactionCurrency(
        @NonNull final Enabled enabled,
        @Nullable final Reason reason
    ) {
        this.enabled = enabled;
        this.reason = reason;
    }

    InvoicePaymentCurrencySupportedTransactionCurrency() {
    }

    public Long getId() {
        return this.id;
    }

    public Enabled getEnabled() {
        return this.enabled;
    }

    public Reason getReason() {
        return this.reason;
    }
}
