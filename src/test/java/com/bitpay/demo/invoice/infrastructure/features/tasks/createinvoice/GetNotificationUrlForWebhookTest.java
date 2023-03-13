/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.features.tasks.createinvoice;

import com.bitpay.demo.UnitTest;
import com.bitpay.demo.invoice.domain.InvoiceUuid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetNotificationUrlForWebhookTest implements UnitTest {

    @Test
    void shouldReturnNotificationUrl() {
        // given
        final var invoiceUuid = new InvoiceUuid("123-456-789");

        // when
        final var result = getTestedClass().execute(invoiceUuid);

        // then
        Assertions.assertEquals("http://localhost/invoices/123-456-789", result);
    }

    private GetNotificationUrlForWebhook getTestedClass() {
        return new GetNotificationUrlForWebhook("http://localhost");
    }
}
