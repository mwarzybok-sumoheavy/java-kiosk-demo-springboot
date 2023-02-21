/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.Fields;
import com.bitpay.demo.invoice.domain.Invoice;
import com.bitpay.demo.invoice.domain.Response;
import com.bitpay.demo.shared.ObjectToStringConverter;
import com.bitpay.sdk.exceptions.BitPayException;
import java.util.Map;
import lombok.NonNull;

@DependencyInjection
class InvoiceFactory {

    private final ObjectToStringConverter objectToStringConverter;

    InvoiceFactory(@NonNull final ObjectToStringConverter objectToStringConverter) {
        this.objectToStringConverter = objectToStringConverter;
    }

    @NonNull
    Invoice create(@NonNull final com.bitpay.sdk.model.Invoice.Invoice bitPayInvoice) {
        return new Invoice(
            new Fields(bitPayInvoice.getPosData()),
            new Response(this.objectToStringConverter.execute(bitPayInvoice))
        );
    }

    @NonNull
    public Invoice create(
        @NonNull final Map<String, Object> validatedParams,
        @NonNull final BitPayException exception
    ) {
        return new Invoice(
            new Fields(this.objectToStringConverter.execute(validatedParams)),
            new Response(exception.getMessage())
        );
    }
}
