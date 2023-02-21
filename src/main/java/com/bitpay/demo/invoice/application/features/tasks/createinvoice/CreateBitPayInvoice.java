/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.config.BitPayProperties;
import com.bitpay.demo.shared.ObjectToStringConverter;
import com.bitpay.sdk.Client;
import com.bitpay.sdk.exceptions.BitPayException;
import com.bitpay.sdk.model.Currency;
import com.bitpay.sdk.model.Invoice.Invoice;
import java.util.Map;
import java.util.UUID;
import lombok.NonNull;

@DependencyInjection
class CreateBitPayInvoice {

    private final Client bitpayClient;
    private final BitPayProperties bitPayProperties;
    private final ObjectToStringConverter objectToStringConverter;

    CreateBitPayInvoice(
        @NonNull final Client bitpayClient,
        @NonNull final BitPayProperties bitPayProperties,
        @NonNull final ObjectToStringConverter objectToStringConverter
    ) {
        this.bitpayClient = bitpayClient;
        this.bitPayProperties = bitPayProperties;
        this.objectToStringConverter = objectToStringConverter;
    }

    @NonNull
    public Invoice execute(@NonNull final Map<String, Object> validatedParams) throws BitPayException {
        final Double price = Double.parseDouble(validatedParams.get("price").toString());
        final String posData = this.objectToStringConverter.execute(validatedParams);
        final Invoice invoice = new Invoice(price, Currency.USD);
        invoice.setOrderId(UUID.randomUUID().toString());
        invoice.setNotificationEmail(this.bitPayProperties.getNotificationEmail());
        invoice.setTransactionSpeed("medium");
        invoice.setItemDesc("Example");
        invoice.setPosData(posData);

        return this.bitpayClient.createInvoice(invoice);
    }
}
