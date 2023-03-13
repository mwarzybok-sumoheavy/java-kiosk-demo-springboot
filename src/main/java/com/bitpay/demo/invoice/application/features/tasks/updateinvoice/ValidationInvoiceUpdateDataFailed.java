/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.updateinvoice;

import java.util.Map;
import lombok.NonNull;

public class ValidationInvoiceUpdateDataFailed extends RuntimeException {

    private final Map<String, String> errors;

    ValidationInvoiceUpdateDataFailed(@NonNull final Map<String, String> errors) {
        this.errors = errors;
    }

    public @NonNull Map<String, String> getErrors() {
        return this.errors;
    }
}
