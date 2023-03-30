/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.features.tasks.updateinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.application.features.tasks.updateinvoice.SendUpdateInvoiceNotification;
import com.bitpay.demo.invoice.application.features.tasks.updateinvoice.UpdateInvoiceEventType;
import com.bitpay.demo.invoice.domain.Invoice;
import com.bitpay.demo.shared.sse.SseEmitterFacade;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@DependencyInjection
class SendSseNotification implements SendUpdateInvoiceNotification {

    private final SseEmitterFacade sseEmitterFacade;

    SendSseNotification(@NonNull final SseEmitterFacade sseEmitterFacade) {
        this.sseEmitterFacade = sseEmitterFacade;
    }

    @Override
    public void execute(
        @NonNull final Invoice invoice,
        @Nullable UpdateInvoiceEventType eventType,
        @Nullable String eventMessage
    ) {
        this.sseEmitterFacade.sendAll(
            List.of(
                getEvent(invoice, "invoice/update", eventType, eventMessage),
                getEvent(invoice, "invoice/update/" + invoice.getId(), eventType, eventMessage)
            )
        );
    }

    private SseEmitter.SseEventBuilder getEvent(
        @NonNull Invoice invoice,
        @NonNull final String eventName,
        @Nullable final UpdateInvoiceEventType eventType,
        @Nullable final String eventMessage
    ) {
        return SseEmitter.event()
            .id(String.valueOf(System.currentTimeMillis()))
            .data(
                getData(invoice, eventType, eventMessage),
                MediaType.APPLICATION_JSON
            )
            .name(eventName);
    }

    @NonNull
    private Map<String, Object> getData(
        @NonNull final Invoice invoice,
        @Nullable UpdateInvoiceEventType eventType,
        @Nullable String eventMessage
    ) {
        return Map.of(
            "invoiceId", invoice.getId(),
            "status", invoice.getStatus().value(),
            "eventType", Objects.isNull(eventType) ? null : eventType.name().toLowerCase(),
            "eventMessage", Objects.isNull(eventMessage) ? null : eventMessage
        );
    }
}
