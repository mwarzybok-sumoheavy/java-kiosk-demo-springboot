/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.BitPayId;
import com.bitpay.demo.invoice.domain.BitPayOrderId;
import com.bitpay.demo.invoice.domain.Currency;
import com.bitpay.demo.invoice.domain.Invoice;
import com.bitpay.demo.invoice.domain.PosData;
import com.bitpay.demo.invoice.domain.Price;
import com.bitpay.demo.invoice.domain.Status;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.NonNull;

@DependencyInjection
class InvoiceFactory {

    @NonNull
    Invoice create(@NonNull final com.bitpay.sdk.model.Invoice.Invoice bitPayInvoice) {
        return new Invoice(
            new PosData(bitPayInvoice.getPosData()),
            new Price(bitPayInvoice.getPrice()),
            new Currency(bitPayInvoice.getCurrency()),
            new BitPayId(bitPayInvoice.getId()),
            new Status(bitPayInvoice.getStatus()),
            LocalDateTime.ofInstant(Instant.ofEpochMilli(bitPayInvoice.getInvoiceTime()), ZoneId.systemDefault()),
            new BitPayOrderId(bitPayInvoice.getOrderId())
        );
    }
}
