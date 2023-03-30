/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.updateinvoice;

import com.bitpay.demo.invoice.application.features.tasks.updateinvoice.UpdateInvoice;
import com.bitpay.demo.invoice.application.features.tasks.updateinvoice.ValidationInvoiceUpdateDataFailed;
import com.bitpay.demo.invoice.domain.InvoiceNotFound;
import com.bitpay.demo.invoice.domain.InvoiceUuid;
import java.util.Map;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpUpdateInvoice {
    private final UpdateInvoice updateInvoice;

    public HttpUpdateInvoice(@NonNull final UpdateInvoice updateInvoice) {
        this.updateInvoice = updateInvoice;
    }

    @PostMapping("/invoices/{uuid}")
    public void execute(
        @NonNull @PathVariable("uuid") final String invoiceUuid,
        @NonNull @RequestBody final Map<String, Object> updateData
    ) throws ReflectiveOperationException, ValidationInvoiceUpdateDataFailed, InvoiceNotFound {
        var data = (Map<String, Object>) updateData.get("data");
        var event = (Map<String, Object>) updateData.get("event");
        if (!event.isEmpty() && event.containsKey("name")) {
            data.put("eventName", event.get("name"));
        }

        this.updateInvoice.execute(
            new InvoiceUuid(invoiceUuid),
            data
        );
    }
}
