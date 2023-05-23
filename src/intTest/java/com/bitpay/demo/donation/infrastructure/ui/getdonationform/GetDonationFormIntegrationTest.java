/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.donation.infrastructure.ui.getdonationform;

import com.bitpay.demo.AbstractUiIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@TestPropertySource(properties = {
    "spring.config.location=classpath:application-integrationtest.yaml",
    "bitpay.design.mode=donation"
})
public class GetDonationFormIntegrationTest extends AbstractUiIntegrationTest {

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
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='price']").exists())
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='buyerName']").exists())
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='buyerAddress1']").exists())
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='buyerAddress2']").exists())
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='buyerLocality']").exists())
            .andExpect(MockMvcResultMatchers.xpath("//select[@name='buyerRegion']").exists())
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='buyerPostalCode']").exists())
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='buyerPhone']").exists())
            .andExpect(MockMvcResultMatchers.xpath("//input[@name='buyerEmail']").exists());
    }

    private ResultActions getResultActions() throws Exception {
        return get(URL);
    }
}
