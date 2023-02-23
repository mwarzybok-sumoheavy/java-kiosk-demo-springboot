/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import lombok.NonNull;

public interface InvoiceRepository {
    void save(@NonNull Invoice invoice);

    @NonNull
    Invoice findById(@NonNull InvoiceId invoiceId) throws InvoiceNotFound;
}
