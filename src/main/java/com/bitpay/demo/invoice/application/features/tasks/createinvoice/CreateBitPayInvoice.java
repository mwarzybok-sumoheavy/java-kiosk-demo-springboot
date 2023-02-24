/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.shared.ObjectToJsonConverter;
import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import com.bitpay.sdk.Client;
import com.bitpay.sdk.exceptions.BitPayException;
import com.bitpay.sdk.model.Invoice.Invoice;
import java.util.Map;
import java.util.UUID;
import lombok.NonNull;

@DependencyInjection
class CreateBitPayInvoice {

    private final Client bitpayClient;
    private final BitPayProperties bitPayProperties;
    private final ObjectToJsonConverter objectToJsonConverter;

    CreateBitPayInvoice(
        @NonNull final Client bitpayClient,
        @NonNull final BitPayProperties bitPayProperties,
        @NonNull final ObjectToJsonConverter objectToJsonConverter
    ) {
        this.bitpayClient = bitpayClient;
        this.bitPayProperties = bitPayProperties;
        this.objectToJsonConverter = objectToJsonConverter;
    }

    @NonNull
    public Invoice execute(@NonNull final Map<String, Object> validatedParams) throws BitPayException {
        final Double price = Double.parseDouble(validatedParams.get("price").toString());
        final String posData = this.objectToJsonConverter.execute(validatedParams);
        final Invoice invoice = new Invoice(price, this.bitPayProperties.getCurrency());
        invoice.setOrderId(UUID.randomUUID().toString());
        invoice.setNotificationEmail(this.bitPayProperties.getNotificationEmail());
        invoice.setTransactionSpeed("medium");
        invoice.setItemDesc("Example");
        invoice.setPosData(posData);

        return this.bitpayClient.createInvoice(invoice);
    }
}
