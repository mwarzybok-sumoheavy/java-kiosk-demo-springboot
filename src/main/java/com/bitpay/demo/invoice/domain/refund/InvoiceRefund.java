/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.refund;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

public class InvoiceRefund {
    private Long id;
    private RefundAddressesJson addressesJson;
    private RefundAddressRequestPending addressRequestPending;
    private Collection<InvoiceRefundInfo> refundInfo = List.of();

    public InvoiceRefund(
        @NonNull final RefundAddressesJson addressesJson,
        @NonNull final RefundAddressRequestPending addressRequestPending
    ) {
        this.addressesJson = addressesJson;
        this.addressRequestPending = addressRequestPending;
    }

    InvoiceRefund() {
    }

    public void addRefundInfo(@NonNull final Collection<InvoiceRefundInfo> invoiceRefundInfo) {
        final var refundInfo = new ArrayList<>(this.refundInfo);
        refundInfo.addAll(invoiceRefundInfo);

        this.refundInfo = refundInfo;
    }
}
