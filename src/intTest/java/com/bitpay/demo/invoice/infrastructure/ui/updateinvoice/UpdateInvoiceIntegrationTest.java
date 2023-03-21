/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.updateinvoice;

import com.bitpay.demo.AbstractUiIntegrationTest;
import com.bitpay.demo.invoice.domain.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class UpdateInvoiceIntegrationTest extends AbstractUiIntegrationTest {

    private static final String URL = "/invoices/";

    @BeforeEach
    public void initialize() {
        super.initialize();
    }

    @Test
    public void shouldUpdateInvoice() throws Exception {
        // given
        final var invoice = createInvoice();

        // when
        final var result = getResultActions(invoice.getUuid().value(), getDataFromFile("updateData.json"));

        result.andExpect(MockMvcResultMatchers.status().isOk());
        Assertions.assertEquals(
            "expired",
            this.invoiceRepository.findById(invoice.getInvoiceId()).getStatus().value()
        );
    }

    @Test
    public void shouldNotUpdateInvoiceWhenInvoiceForUuidDoesNotExists() throws Exception {
        // given
        final var invoice = createInvoice();

        // when
        final var result = getResultActions("12312412", getDataFromFile("updateData.json"));

        result.andExpect(MockMvcResultMatchers.status().isNotFound());
        Assertions.assertEquals(
            "new",
            this.invoiceRepository.findById(invoice.getInvoiceId()).getStatus().value()
        );
    }

    @Test
    public void shouldNotUpdateInvoiceWhenUpdateDataAreInvalid() throws Exception {
        // given
        final var invoice = createInvoice();

        // when
        final var result = getResultActions(
            invoice.getUuid().value(),
            getDataFromFile("invalidUpdateData.json")
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.content().json(getDataFromFile("invalidUpdateDataResponse.json"), false));
        Assertions.assertEquals(
            "new",
            this.invoiceRepository.findById(invoice.getInvoiceId()).getStatus().value()
        );
    }

    private ResultActions getResultActions(
        final String invoiceUuId,
        final String requestBody
    ) throws Exception {
        return post(URL + invoiceUuId, requestBody);
    }

    private Invoice createInvoice() {
        final String invoiceJson = getDataFromFile("invoice.json");
        final var invoice = toObject(invoiceJson, Invoice.class);
        this.invoiceRepository.save(invoice);

        return invoice;
    }
}
