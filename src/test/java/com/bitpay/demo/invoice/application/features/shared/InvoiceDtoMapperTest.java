/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.shared;

import com.bitpay.demo.UnitTest;
import com.bitpay.demo.invoice.domain.Invoice;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class InvoiceDtoMapperTest implements UnitTest {

    @Test
    void shouldMapInvoiceToInvoiceDto() throws JSONException {
        // given
        final String invoiceJson = getDataFromFile("invoice.json");
        final Invoice invoice = toObject(invoiceJson, Invoice.class);

        // when
        final InvoiceDto result = getTestedClass().execute(invoice);

        // then
        JSONAssert.assertEquals(
            toJson(result),
            getDataFromFile("invoiceDto.json"),
            false
        );
    }

    private InvoiceDtoMapper getTestedClass() {
        return new InvoiceDtoMapper();
    }
}
