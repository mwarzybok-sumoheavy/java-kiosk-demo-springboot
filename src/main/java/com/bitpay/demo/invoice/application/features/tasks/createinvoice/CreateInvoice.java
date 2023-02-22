/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.sdk.exceptions.BitPayException;
import com.bitpay.sdk.model.Invoice.Invoice;
import java.util.Map;
import lombok.NonNull;

@DependencyInjection
public class CreateInvoice {

    private final GetValidatedParams getValidatedParams;
    private final CreateBitPayInvoice createBitPayInvoice;

    CreateInvoice(
        @NonNull final GetValidatedParams getValidatedParams,
        @NonNull final CreateBitPayInvoice createBitPayInvoice
    ) {
        this.getValidatedParams = getValidatedParams;
        this.createBitPayInvoice = createBitPayInvoice;
    }

    @NonNull
    public String execute(@NonNull final Map<String, Object> requestParameters)
        throws MissingRequiredField, BitPayException {

        final Map<String, Object> validatedParams = this.getValidatedParams.execute(requestParameters);
        final Invoice invoice = this.createBitPayInvoice.execute(validatedParams);

        return invoice.getUrl();
    }
}
