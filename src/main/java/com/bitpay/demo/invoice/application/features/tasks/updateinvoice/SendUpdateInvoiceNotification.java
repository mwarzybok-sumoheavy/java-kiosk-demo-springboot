/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.updateinvoice;

import com.bitpay.demo.invoice.domain.Invoice;
import lombok.NonNull;

public interface SendUpdateInvoiceNotification {
    void execute(@NonNull Invoice invoice);
}
