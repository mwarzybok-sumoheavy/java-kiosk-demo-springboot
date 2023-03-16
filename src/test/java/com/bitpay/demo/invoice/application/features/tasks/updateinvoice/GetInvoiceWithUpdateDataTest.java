/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.updateinvoice;

import com.bitpay.demo.UnitTest;
import com.bitpay.demo.invoice.domain.Invoice;
import com.bitpay.demo.shared.StringToObjectParser;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class GetInvoiceWithUpdateDataTest implements UnitTest {

    @Test
    void shouldCreateNewInvoiceWithUpdateData() throws ReflectiveOperationException, JSONException {
        // given
        final var invoiceJson = getDataFromFile("invoice.json");
        final var invoice = toObject(invoiceJson, Invoice.class);
        final var updateDataJson = getDataFromFile("updateData.json");
        final var updateData = toObject(updateDataJson, Map.class);

        // when
        final var result = getTestedClass().create(
            updateData,
            invoice
        );

        // then
        JSONAssert.assertEquals(
            toJson(result),
            getDataFromFile("updatedInvoice.json"),
            false
        );
    }

    private GetInvoiceWithUpdateData getTestedClass() {
        return new GetInvoiceWithUpdateData(new StringToObjectParser());
    }
}
