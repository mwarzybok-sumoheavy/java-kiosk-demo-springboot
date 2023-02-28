/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.shared;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.Invoice;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import lombok.NonNull;

@DependencyInjection
public class InvoiceDtoMapper {

    private final DecimalFormat df = new DecimalFormat("#,###.00#");

    @NonNull
    public InvoiceDto execute(@NonNull final Invoice invoice) {
        return new InvoiceDto(
            invoice.getId(),
            invoice.getBitPayId().value(),
            this.df.format(invoice.getPrice().value()),
            formatToString(invoice.getCreatedDate()),
            invoice.getBitPayOrderId().value(),
            invoice.getStatus().value(),
            invoice.getItemDescription().value()
        );
    }

    private @NonNull String formatToString(@NonNull final LocalDateTime dateTime) {
        final ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("UTC"));
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
        return zonedDateTime.format(formatter);
    }
}
