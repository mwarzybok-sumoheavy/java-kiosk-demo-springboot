/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.features.tasks.updateinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.application.features.tasks.updateinvoice.SendUpdateInvoiceNotification;
import com.bitpay.demo.invoice.domain.Invoice;
import java.io.IOException;
import java.util.Map;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@DependencyInjection
class SendSseNotification implements SendUpdateInvoiceNotification {

    private final SseEmitter sseEmitter;

    SendSseNotification(@NonNull final SseEmitter sseEmitter) {
        this.sseEmitter = sseEmitter;
    }

    @Override
    public void execute(@NonNull final Invoice invoice) {
        try {
            send(invoice, "invoice/update");
            send(invoice, "invoice/update/" + invoice.getId());
        } catch (final IOException e) {
            this.sseEmitter.completeWithError(e);
        }
    }

    private void send(
        @NonNull final Invoice invoice,
        @NonNull final String eventName
    ) throws IOException {
        this.sseEmitter.send(getEvent(invoice, eventName));
    }

    @NonNull
    private SseEmitter.SseEventBuilder getEvent(
        @NonNull final Invoice invoice,
        @NonNull final String eventName
    ) {
        return SseEmitter.event()
            .data(
                getData(invoice),
                MediaType.APPLICATION_JSON
            )
            .name(eventName);
    }

    @NonNull
    private Map<String, Object> getData(@NonNull final Invoice invoice) {
        return Map.of(
            "invoiceId", invoice.getId(),
            "status", invoice.getStatus().value()
        );
    }
}
