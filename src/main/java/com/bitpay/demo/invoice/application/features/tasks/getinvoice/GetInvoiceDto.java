/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.getinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.application.features.shared.InvoiceDto;
import com.bitpay.demo.invoice.application.features.shared.InvoiceDtoMapper;
import com.bitpay.demo.invoice.domain.InvoiceId;
import com.bitpay.demo.invoice.domain.InvoiceNotFound;
import com.bitpay.demo.invoice.domain.InvoiceRepository;
import lombok.NonNull;

@DependencyInjection
public class GetInvoiceDto {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceDtoMapper invoiceDtoMapper;

    GetInvoiceDto(
        @NonNull final InvoiceRepository invoiceRepository,
        @NonNull final InvoiceDtoMapper invoiceDtoMapper
    ) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceDtoMapper = invoiceDtoMapper;
    }

    @NonNull
    public InvoiceDto execute(@NonNull final InvoiceId invoiceId) throws InvoiceNotFound {
        final var invoice = this.invoiceRepository.findById(invoiceId);

        return this.invoiceDtoMapper.execute(invoice);
    }
}
