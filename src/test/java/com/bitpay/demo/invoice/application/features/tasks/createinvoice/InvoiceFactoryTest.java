/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.UnitTest;
import com.bitpay.demo.invoice.domain.InvoiceUuid;
import com.bitpay.demo.invoice.domain.buyer.BuyerEmailAddress;
import com.bitpay.demo.invoice.domain.buyer.BuyerName;
import com.bitpay.demo.invoice.domain.buyer.BuyerPhoneNumber;
import com.bitpay.demo.invoice.domain.buyer.BuyerSelectedTransactionCurrency;
import com.bitpay.demo.invoice.domain.buyer.BuyerSelectedWallet;
import com.bitpay.demo.invoice.domain.buyer.BuyerSms;
import com.bitpay.demo.invoice.domain.buyer.BuyerSmsVerified;
import com.bitpay.demo.invoice.domain.buyer.InvoiceBuyer;
import com.bitpay.demo.invoice.domain.buyer.InvoiceBuyerProvidedInfo;
import com.bitpay.demo.invoice.domain.payment.InvoicePayment;
import com.bitpay.demo.invoice.domain.refund.InvoiceRefund;
import com.bitpay.demo.invoice.domain.refund.RefundAddressRequestPending;
import com.bitpay.demo.invoice.domain.refund.RefundAddressesJson;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;

class InvoiceFactoryTest implements UnitTest, GetBitPayInvoice {

    @Test
    void shouldMapToInvoice() throws JSONException {
        // given
        final com.bitpay.sdk.model.Invoice.Invoice bitPayInvoice = getBitPayInvoice();

        // when
        final var result = getTestedClass().create(bitPayInvoice, new InvoiceUuid("123-456-789"));

        // then
        JSONAssert.assertEquals(
            toJson(result),
            getDataFromFile("invoice.json"),
            false
        );
    }

    private InvoiceFactory getTestedClass() {
        return new InvoiceFactory(
            getInvoicePaymentFactory(),
            getInvoiceBuyerFactory(),
            getInvoiceRefundFactory(),
            Mockito.mock(InvoiceTransactionFactory.class),
            Mockito.mock(InvoiceItemizedDetailFactory.class)
        );
    }

    private InvoiceRefundFactory getInvoiceRefundFactory() {
        final var mock = Mockito.mock(InvoiceRefundFactory.class);
        Mockito.when(mock.create(ArgumentMatchers.any())).thenReturn(
            new InvoiceRefund(
                new RefundAddressesJson(""),
                new RefundAddressRequestPending(false)
            )
        );

        return mock;
    }

    private InvoiceBuyerFactory getInvoiceBuyerFactory() {
        final var mock = Mockito.mock(InvoiceBuyerFactory.class);
        Mockito.when(mock.create(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(
            new InvoiceBuyer(
                new InvoiceBuyerProvidedInfo(
                    new BuyerName(""),
                    new BuyerPhoneNumber(""),
                    new BuyerSelectedTransactionCurrency(""),
                    new BuyerEmailAddress(""),
                    new BuyerSelectedWallet(""),
                    new BuyerSms(""),
                    new BuyerSmsVerified(false)
                ),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
        );

        return mock;
    }

    private InvoicePaymentFactory getInvoicePaymentFactory() {
        final var mock = Mockito.mock(InvoicePaymentFactory.class);
        Mockito.when(mock.create(ArgumentMatchers.any())).thenReturn(
            new InvoicePayment(
                null, null, null, null, null, null, null, null
            )
        );

        return mock;
    }
}
