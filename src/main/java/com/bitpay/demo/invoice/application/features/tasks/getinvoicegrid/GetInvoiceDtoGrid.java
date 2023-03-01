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
import com.bitpay.demo.shared.logger.LogCode;
import com.bitpay.demo.shared.logger.Logger;
import java.util.Map;
import lombok.NonNull;

@DependencyInjection
public class GetInvoiceDtoGrid {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceDtoMapper invoiceDtoMapper;
    private final Logger logger;

    GetInvoiceDtoGrid(
        @NonNull final InvoiceRepository invoiceRepository,
        @NonNull final InvoiceDtoMapper invoiceDtoMapper,
        @NonNull final Logger logger
    ) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceDtoMapper = invoiceDtoMapper;
        this.logger = logger;
    }

    @NonNull
    public Page<InvoiceDto> execute(@NonNull final EntityPageNumber entityPageNumber) {
        final var pagedInvoice = this.invoiceRepository.findAllPaginated(
            entityPageNumber,
            new EntityPageSize(10)
        );

        this.logger.info(
            LogCode.INVOICE_GRID_GET,
            "Loaded invoice grid",
            Map.of("page", pagedInvoice.getCurrentPageNumber())
        );

        return pagedInvoice.mapElementsToNewType(this.invoiceDtoMapper::execute);
    }
}
