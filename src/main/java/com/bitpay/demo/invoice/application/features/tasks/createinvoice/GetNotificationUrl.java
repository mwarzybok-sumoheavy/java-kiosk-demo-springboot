/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.invoice.domain.InvoiceUuid;
import lombok.NonNull;

public interface GetNotificationUrl {

    @NonNull
    String execute(@NonNull InvoiceUuid uuid);
}
