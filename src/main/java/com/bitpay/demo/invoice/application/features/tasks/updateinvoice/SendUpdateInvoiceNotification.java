/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.updateinvoice;

import com.bitpay.demo.invoice.domain.Invoice;
import javax.annotation.Nullable;
import lombok.NonNull;

public interface SendUpdateInvoiceNotification {
    void execute(
        @NonNull Invoice invoice,
        @Nullable UpdateInvoiceEventType eventType,
        @Nullable String eventMessage
    );
}
