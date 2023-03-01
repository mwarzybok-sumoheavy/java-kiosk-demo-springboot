/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.AmountPaid;
import com.bitpay.demo.invoice.domain.AutoRedirect;
import com.bitpay.demo.invoice.domain.BitPayIdRequired;
import com.bitpay.demo.invoice.domain.DisplayAmountPaid;
import com.bitpay.demo.invoice.domain.InvoicePayment;
import com.bitpay.demo.invoice.domain.IsCancelled;
import com.bitpay.demo.invoice.domain.ItemizedDetailsJson;
import com.bitpay.demo.invoice.domain.JsonPayProRequired;
import com.bitpay.demo.invoice.domain.LowFeeDetected;
import com.bitpay.demo.invoice.domain.NonPayProPaymentReceived;
import com.bitpay.demo.invoice.domain.OverpaidAmount;
import com.bitpay.demo.invoice.domain.RefundAddressRequestPending;
import com.bitpay.demo.invoice.domain.RefundAddressesJson;
import com.bitpay.demo.invoice.domain.RefundInfoJson;
import com.bitpay.demo.invoice.domain.ShopperUser;
import com.bitpay.demo.invoice.domain.TargetConfirmations;
import com.bitpay.demo.invoice.domain.TransactionCurrency;
import com.bitpay.demo.invoice.domain.TransactionsJson;
import com.bitpay.demo.invoice.domain.UnderpaidAmount;
import com.bitpay.demo.invoice.domain.UniversalCodesPaymentString;
import com.bitpay.demo.invoice.domain.UniversalCodesVerificationLink;
import com.bitpay.demo.invoice.domain.payment.InvoicePaymentTotal;
import com.bitpay.demo.shared.ObjectToJsonConverter;
import java.util.Collection;
import java.util.Optional;
import lombok.NonNull;

@DependencyInjection
class InvoicePaymentFactory {

    private final ObjectToJsonConverter objectToJsonConverter;
    private final InvoicePaymentTotalFactory invoiceTotalFactory;

    InvoicePaymentFactory(
        @NonNull final ObjectToJsonConverter objectToJsonConverter,
        @NonNull final InvoicePaymentTotalFactory invoiceTotalFactory
    ) {
        this.objectToJsonConverter = objectToJsonConverter;
        this.invoiceTotalFactory = invoiceTotalFactory;
    }

    @NonNull
    InvoicePayment create(@NonNull final com.bitpay.sdk.model.Invoice.Invoice bitPayInvoice) {
        final var invoicePayment = new InvoicePayment(
            new TargetConfirmations(bitPayInvoice.getTargetConfirmations()),
            new TransactionsJson(this.objectToJsonConverter.execute(bitPayInvoice.getTransactions())),
            new RefundAddressesJson(this.objectToJsonConverter.execute(bitPayInvoice.getRefundAddresses())),
            new LowFeeDetected(bitPayInvoice.getLowFeeDetected()),
            new AmountPaid(bitPayInvoice.getAmountPaid().doubleValue()),
            new DisplayAmountPaid(bitPayInvoice.getDisplayAmountPaid().doubleValue()),
            new RefundAddressRequestPending(bitPayInvoice.getRefundAddressRequestPending()),
            new NonPayProPaymentReceived(bitPayInvoice.getNonPayProPaymentReceived()),
            new AutoRedirect(bitPayInvoice.getAutoRedirect()),
            new ShopperUser(bitPayInvoice.getShopper().getName()),
            new RefundInfoJson(this.objectToJsonConverter.execute(bitPayInvoice.getRefundInfo())),
            new JsonPayProRequired(bitPayInvoice.getJsonPayProRequired()),
            new UniversalCodesPaymentString(bitPayInvoice.getUniversalCodes().getBitpay()),
            new UniversalCodesVerificationLink(bitPayInvoice.getUniversalCodes().getVerificationLink()),
            new BitPayIdRequired(bitPayInvoice.getBitpayIdRequired()),
            new IsCancelled(bitPayInvoice.getIsCancelled()),
            new ItemizedDetailsJson(this.objectToJsonConverter.execute(bitPayInvoice.getItemizedDetails())),
            new TransactionCurrency(bitPayInvoice.getTransactionCurrency()),
            Optional.ofNullable(bitPayInvoice.getUnderPaidAmount())
                .map(amount -> new UnderpaidAmount(amount.doubleValue()))
                .orElse(null),
            Optional.ofNullable(bitPayInvoice.getOverPaidAmount())
                .map(amount -> new OverpaidAmount(amount.doubleValue()))
                .orElse(null)
        );

        invoicePayment.addPaymentTotals(
            getInvoicePaymentTotal(
                invoicePayment,
                bitPayInvoice
            )
        );

        return invoicePayment;
    }

    @NonNull
    private Collection<InvoicePaymentTotal> getInvoicePaymentTotal(
        @NonNull final InvoicePayment invoicePayment,
        @NonNull final com.bitpay.sdk.model.Invoice.Invoice bitPayInvoice
    ) {
        return bitPayInvoice.getPaymentTotals().entrySet().stream()
            .map(code -> this.invoiceTotalFactory.create(code, invoicePayment, bitPayInvoice))
            .toList();
    }
}
