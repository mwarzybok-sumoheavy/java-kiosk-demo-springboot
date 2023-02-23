/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.getinvoicegrid;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.application.features.shared.InvoiceDto;
import com.bitpay.demo.invoice.application.features.shared.InvoiceDtoMapper;
import com.bitpay.demo.invoice.domain.InvoiceRepository;
import com.bitpay.demo.shared.domain.EntityPageNumber;
import com.bitpay.demo.shared.domain.EntityPageSize;
import com.bitpay.demo.shared.domain.Page;
import lombok.NonNull;

@DependencyInjection
public class GetInvoiceDtoGrid {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceDtoMapper invoiceDtoMapper;

    GetInvoiceDtoGrid(
        @NonNull final InvoiceRepository invoiceRepository,
        @NonNull final InvoiceDtoMapper invoiceDtoMapper
    ) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceDtoMapper = invoiceDtoMapper;
    }

    @NonNull
    public Page<InvoiceDto> execute(@NonNull final EntityPageNumber entityPageNumber) {
        final var pagedInvoiceDto = this.invoiceRepository.findAllPaginated(
            entityPageNumber,
            new EntityPageSize(10)
        );

        return pagedInvoiceDto.mapElementsToNewType(this.invoiceDtoMapper::execute);
    }
}
