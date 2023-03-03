/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.refund;

import com.bitpay.demo.invoice.domain.CurrencyCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

public class InvoiceRefundInfo {
    private Long id;
    private InvoiceRefund invoiceRefund;
    private SupportRequest supportRequest;
    private CurrencyCode currencyCode;
    private Collection<InvoiceRefundInfoAmount> invoiceRefundInfoAmounts = List.of();

    public InvoiceRefundInfo(
        @NonNull final InvoiceRefund invoiceRefund,
        @NonNull final SupportRequest supportRequest,
        @NonNull final CurrencyCode currencyCode
    ) {
        this.invoiceRefund = invoiceRefund;
        this.supportRequest = supportRequest;
        this.currencyCode = currencyCode;
    }

    InvoiceRefundInfo() {
    }

    public void addRefundInfoAmounts(@NonNull final Collection<InvoiceRefundInfoAmount> invoiceRefundInfoAmounts) {
        final var refundInfoAmounts = new ArrayList<>(this.invoiceRefundInfoAmounts);
        refundInfoAmounts.addAll(invoiceRefundInfoAmounts);

        this.invoiceRefundInfoAmounts = refundInfoAmounts;
    }
}
