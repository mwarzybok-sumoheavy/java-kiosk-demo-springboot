/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.shared;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.Invoice;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

@DependencyInjection
public class InvoiceDtoMapper {
    @NonNull
    public InvoiceDto execute(@NonNull final Invoice invoice) {
        return new InvoiceDto(
            invoice.getId(),
            invoice.getBitPayId().value(),
            invoice.getPrice().value(),
            formatToString(invoice.getCreatedDate()),
            invoice.getBitPayOrderId().value(),
            invoice.getStatus().value()
        );
    }

    private @NonNull String formatToString(@NotNull @NonNull final LocalDateTime dateTime) {
        final ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("UTC"));
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
        return zonedDateTime.format(formatter);
    }
}
