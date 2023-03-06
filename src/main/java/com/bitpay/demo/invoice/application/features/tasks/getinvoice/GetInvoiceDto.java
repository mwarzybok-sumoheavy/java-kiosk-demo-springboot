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
import com.bitpay.demo.shared.logger.LogCode;
import com.bitpay.demo.shared.logger.Logger;
import java.util.Map;
import lombok.NonNull;

@DependencyInjection
public class GetInvoiceDto {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceDtoMapper invoiceDtoMapper;
    private final Logger logger;

    GetInvoiceDto(
        @NonNull final InvoiceRepository invoiceRepository,
        @NonNull final InvoiceDtoMapper invoiceDtoMapper,
        @NonNull final Logger logger
    ) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceDtoMapper = invoiceDtoMapper;
        this.logger = logger;
    }

    @NonNull
    public InvoiceDto execute(@NonNull final InvoiceId invoiceId) throws InvoiceNotFound {
        final var invoice = this.invoiceRepository.findById(invoiceId);

        this.logger.info(
            LogCode.INVOICE_GET,
            "Loaded invoice",
            Map.of("id", invoice.getId())
        );

        return this.invoiceDtoMapper.execute(invoice);
    }
}
