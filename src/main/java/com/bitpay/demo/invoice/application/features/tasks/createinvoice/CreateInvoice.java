/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.InvoiceRepository;
import com.bitpay.sdk.exceptions.BitPayException;
import com.bitpay.sdk.model.Invoice.Invoice;
import java.util.Map;
import lombok.NonNull;

@DependencyInjection
public class CreateInvoice {

    private final GetValidatedParams getValidatedParams;
    private final CreateBitPayInvoice createBitPayInvoice;
    private final InvoiceFactory invoiceFactory;
    private final InvoiceRepository invoiceRepository;

    CreateInvoice(
        @NonNull final GetValidatedParams getValidatedParams,
        @NonNull final CreateBitPayInvoice createBitPayInvoice,
        @NonNull final InvoiceFactory invoiceFactory,
        @NonNull final InvoiceRepository invoiceRepository
    ) {
        this.getValidatedParams = getValidatedParams;
        this.createBitPayInvoice = createBitPayInvoice;
        this.invoiceFactory = invoiceFactory;
        this.invoiceRepository = invoiceRepository;
    }

    @NonNull
    public String execute(@NonNull final Map<String, Object> requestParameters)
        throws MissingRequiredField, BitPayException {

        final Map<String, Object> validatedParams = this.getValidatedParams.execute(requestParameters);

        try {
            final Invoice bitPayInvoice = this.createBitPayInvoice.execute(validatedParams);
            final com.bitpay.demo.invoice.domain.Invoice invoice = this.invoiceFactory.create(bitPayInvoice);

            this.invoiceRepository.save(invoice);

            return bitPayInvoice.getUrl();
        } catch (final BitPayException exception) {
            final com.bitpay.demo.invoice.domain.Invoice invoice = this.invoiceFactory.create(
                validatedParams,
                exception
            );

            this.invoiceRepository.save(invoice);

            throw exception;
        }
    }
}
