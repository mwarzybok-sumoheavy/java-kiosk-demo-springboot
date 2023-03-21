/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.getinvoicegrid;

import com.bitpay.demo.AbstractUiIntegrationTest;
import com.bitpay.demo.invoice.domain.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class GetInvoiceGridIntegrationTest extends AbstractUiIntegrationTest {

    private static final String URL = "/invoices?page=";

    @BeforeEach
    public void initialize() {
        super.initialize();
    }

    @Test
    public void invoiceGridShouldContains2Invoices() throws Exception {
        // given
        createInvoice();
        createInvoice();

        // when
        final var result = getResultActions(1);

        // then
        result.andExpect(
            MockMvcResultMatchers
                .xpath("//td[contains(@class, 'status')]")
                .nodeCount(2)
        );
    }

    @Test
    public void invoiceGridShouldNotContainsInvoicesForPage2() throws Exception {
        // given
        createInvoice();
        createInvoice();

        // when
        final var result = getResultActions(2);

        // then
        result.andExpect(
            MockMvcResultMatchers
                .xpath("//td[contains(@class, 'status')]")
                .nodeCount(0)
        );
    }

    private ResultActions getResultActions(final Integer pageNumber) throws Exception {
        return get(URL + pageNumber);
    }

    private void createInvoice() {
        final String invoiceJson = getDataFromFile("invoice.json");
        final var invoice = toObject(invoiceJson, Invoice.class);
        this.invoiceRepository.save(invoice);
    }
}
