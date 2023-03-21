/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.getinvoiceview;

import com.bitpay.demo.AbstractUiIntegrationTest;
import com.bitpay.demo.invoice.domain.Invoice;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class GetInvoiceViewIntegrationTest extends AbstractUiIntegrationTest {

    private static final String URL = "/invoices/";

    private final DecimalFormat df = new DecimalFormat("#,###.00#");


    @BeforeEach
    public void initialize() {
        super.initialize();
    }

    @Test
    public void invoiceViewShouldShowValues() throws Exception {
        // given
        final var invoice = createInvoice();

        // when
        final var result = getResultActions(invoice.getId());

        // then
        result.andExpect(
            MockMvcResultMatchers
                .xpath("//span[text()='" + invoice.getBitPayId().value() + "']")
                .exists()
        ).andExpect(
            MockMvcResultMatchers
                .xpath("//span[text()='" + invoice.getStatus().value() + "']")
                .exists()
        ).andExpect(
            MockMvcResultMatchers
                .xpath("//span[text()='" + this.df.format(invoice.getPrice().value()) + "']")
                .exists()
        ).andExpect(
            MockMvcResultMatchers
                .xpath("//dd[text()='" + formatToString(invoice.getCreatedDate()) + "']")
                .exists()
        ).andExpect(
            MockMvcResultMatchers
                .xpath("//dd[text()='" + invoice.getBitPayOrderId().value() + "']")
                .exists()
        );
    }

    @Test
    public void invoiceViewShouldRedirectTo404WhenInvoiceForIdNotExists() throws Exception {
        // given

        // when
        final var result = getResultActions(123L);

        // then
        result.andExpect(MockMvcResultMatchers.redirectedUrl("/404"));
    }

    private ResultActions getResultActions(final Long invoiceId) throws Exception {
        return get(URL + invoiceId);
    }

    private Invoice createInvoice() {
        final String invoiceJson = getDataFromFile("invoice.json");
        final var invoice = toObject(invoiceJson, Invoice.class);
        this.invoiceRepository.save(invoice);

        return invoice;
    }

    private String formatToString(final LocalDateTime dateTime) {
        final ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("UTC"));
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
        return zonedDateTime.format(formatter);
    }
}
