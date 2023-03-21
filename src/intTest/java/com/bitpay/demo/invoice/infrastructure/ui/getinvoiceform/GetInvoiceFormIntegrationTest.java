/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.getinvoiceform;

import com.bitpay.demo.AbstractUiIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class GetInvoiceFormIntegrationTest extends AbstractUiIntegrationTest {

    private static final String URL = "/";

    @BeforeEach
    public void initialize() {
        super.initialize();
    }

    @Test
    public void invoiceFormatShouldContainsAllSpecifiedFields() throws Exception {
        // given

        // when
        final var result = getResultActions();

        // then
        result.andExpect(MockMvcResultMatchers.xpath("//select[@name='store']").exists())
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='register']").nodeCount(2))
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='reg_transaction_no']").exists())
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='price']").exists());
    }

    private ResultActions getResultActions() throws Exception {
        return get(URL);
    }
}
