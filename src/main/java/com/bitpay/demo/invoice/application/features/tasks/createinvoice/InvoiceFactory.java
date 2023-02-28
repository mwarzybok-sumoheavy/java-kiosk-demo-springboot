/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.AcceptanceWindow;
import com.bitpay.demo.invoice.domain.BillId;
import com.bitpay.demo.invoice.domain.BitPayGuid;
import com.bitpay.demo.invoice.domain.BitPayId;
import com.bitpay.demo.invoice.domain.BitPayOrderId;
import com.bitpay.demo.invoice.domain.BitPayUrl;
import com.bitpay.demo.invoice.domain.BuyerJson;
import com.bitpay.demo.invoice.domain.BuyerProvidedEmail;
import com.bitpay.demo.invoice.domain.CloseUrl;
import com.bitpay.demo.invoice.domain.Currency;
import com.bitpay.demo.invoice.domain.ExceptionStatus;
import com.bitpay.demo.invoice.domain.FacadeType;
import com.bitpay.demo.invoice.domain.Invoice;
import com.bitpay.demo.invoice.domain.InvoiceBuyer;
import com.bitpay.demo.invoice.domain.ItemDescription;
import com.bitpay.demo.invoice.domain.MerchantName;
import com.bitpay.demo.invoice.domain.PosDataJson;
import com.bitpay.demo.invoice.domain.Price;
import com.bitpay.demo.invoice.domain.RedirectUrl;
import com.bitpay.demo.invoice.domain.Status;
import com.bitpay.demo.invoice.domain.Token;
import com.bitpay.demo.invoice.domain.buyer.BuyerEmailAddress;
import com.bitpay.demo.invoice.domain.buyer.BuyerName;
import com.bitpay.demo.invoice.domain.buyer.BuyerPhoneNumber;
import com.bitpay.demo.invoice.domain.buyer.BuyerSelectedTransactionCurrency;
import com.bitpay.demo.invoice.domain.buyer.BuyerSelectedWallet;
import com.bitpay.demo.invoice.domain.buyer.BuyerSms;
import com.bitpay.demo.invoice.domain.buyer.InvoiceBuyerProvidedInfo;
import com.bitpay.demo.shared.ObjectToJsonConverter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.NonNull;

@DependencyInjection
class InvoiceFactory {

    private final ObjectToJsonConverter objectToJsonConverter;
    private final InvoicePaymentFactory invoicePaymentFactory;

    InvoiceFactory(
        @NonNull final ObjectToJsonConverter objectToJsonConverter,
        @NonNull final InvoicePaymentFactory invoicePaymentFactory
    ) {
        this.objectToJsonConverter = objectToJsonConverter;
        this.invoicePaymentFactory = invoicePaymentFactory;
    }

    @NonNull
    Invoice create(@NonNull final com.bitpay.sdk.model.Invoice.Invoice bitPayInvoice) {
        return new Invoice(
            new PosDataJson(bitPayInvoice.getPosData()),
            new Price(bitPayInvoice.getPrice()),
            new Currency(bitPayInvoice.getCurrency()),
            new BitPayId(bitPayInvoice.getId()),
            new Status(bitPayInvoice.getStatus()),
            LocalDateTime.ofInstant(Instant.ofEpochMilli(bitPayInvoice.getInvoiceTime()), ZoneId.systemDefault()),
            new BitPayOrderId(bitPayInvoice.getOrderId()),
            LocalDateTime.ofInstant(Instant.ofEpochMilli(bitPayInvoice.getExpirationTime()), ZoneId.systemDefault()),
            new FacadeType("pos/invoice"),
            new BitPayGuid(bitPayInvoice.getGuid()),
            new ExceptionStatus(bitPayInvoice.getExceptionStatus()),
            new BitPayUrl(bitPayInvoice.getUrl()),
            new RedirectUrl(bitPayInvoice.getRedirectURL()),
            new CloseUrl(bitPayInvoice.getCloseURL()),
            new AcceptanceWindow(bitPayInvoice.getAcceptanceWindow()),
            new Token(bitPayInvoice.getToken()),
            new MerchantName(bitPayInvoice.getMerchantName()),
            new ItemDescription(bitPayInvoice.getItemDesc()),
            new BillId(bitPayInvoice.getBillId()),
            this.invoicePaymentFactory.create(bitPayInvoice),
            getInvoiceBuyer(bitPayInvoice),
            getInvoiceBuyerProvidedInfo(bitPayInvoice.getInvoiceBuyerProvidedInfo())
        );
    }

    @NonNull
    private InvoiceBuyerProvidedInfo getInvoiceBuyerProvidedInfo(
        @NonNull final com.bitpay.sdk.model.Invoice.InvoiceBuyerProvidedInfo invoiceBuyerProvidedInfo
    ) {
        return new InvoiceBuyerProvidedInfo(
            new BuyerName(invoiceBuyerProvidedInfo.getName()),
            new BuyerPhoneNumber(invoiceBuyerProvidedInfo.getPhoneNumber()),
            new BuyerSelectedTransactionCurrency(invoiceBuyerProvidedInfo.getSelectedTransactionCurrency()),
            new BuyerEmailAddress(invoiceBuyerProvidedInfo.getEmailAddress()),
            new BuyerSelectedWallet(invoiceBuyerProvidedInfo.getSelectedWallet()),
            new BuyerSms(invoiceBuyerProvidedInfo.getSms())
        );
    }

    @NonNull
    private InvoiceBuyer getInvoiceBuyer(@NonNull final com.bitpay.sdk.model.Invoice.Invoice bitPayInvoice) {
        return new InvoiceBuyer(
            new BuyerJson(this.objectToJsonConverter.execute(bitPayInvoice.getBuyer())),
            new BuyerProvidedEmail(bitPayInvoice.getBuyerProvidedEmail())
        );
    }
}
