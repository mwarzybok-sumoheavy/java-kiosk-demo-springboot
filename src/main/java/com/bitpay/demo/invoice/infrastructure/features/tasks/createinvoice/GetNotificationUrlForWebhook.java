/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.application.features.tasks.createinvoice.GetNotificationUrl;
import com.bitpay.demo.invoice.domain.InvoiceUuid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

@DependencyInjection
class GetNotificationUrlForWebhook implements GetNotificationUrl {

    private final String appUrl;

    GetNotificationUrlForWebhook(@Value("${app-url}") @NonNull final String appUrl) {
        this.appUrl = appUrl;
    }

    @Override
    public @NonNull String execute(@NonNull final InvoiceUuid uuid) {
        return String.format("%s/invoices/%s", this.appUrl, uuid.value());
    }
}
