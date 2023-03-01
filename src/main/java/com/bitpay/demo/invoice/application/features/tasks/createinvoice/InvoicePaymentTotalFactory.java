/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.InvoicePayment;
import com.bitpay.demo.invoice.domain.payment.CurrencyCode;
import com.bitpay.demo.invoice.domain.payment.DisplaySubtotal;
import com.bitpay.demo.invoice.domain.payment.DisplayTotal;
import com.bitpay.demo.invoice.domain.payment.Enabled;
import com.bitpay.demo.invoice.domain.payment.ExchangeRate;
import com.bitpay.demo.invoice.domain.payment.FiatAmount;
import com.bitpay.demo.invoice.domain.payment.InvoicePaymentCode;
import com.bitpay.demo.invoice.domain.payment.InvoicePaymentExchangeRate;
import com.bitpay.demo.invoice.domain.payment.InvoicePaymentMinerFee;
import com.bitpay.demo.invoice.domain.payment.InvoicePaymentSupportedTransactionCurrency;
import com.bitpay.demo.invoice.domain.payment.InvoicePaymentTotal;
import com.bitpay.demo.invoice.domain.payment.PaymentCode;
import com.bitpay.demo.invoice.domain.payment.PaymentCodeUrl;
import com.bitpay.demo.invoice.domain.payment.Reason;
import com.bitpay.demo.invoice.domain.payment.SatoshisPerByte;
import com.bitpay.demo.invoice.domain.payment.Subtotal;
import com.bitpay.demo.invoice.domain.payment.Total;
import com.bitpay.demo.invoice.domain.payment.TotalFee;
import com.bitpay.sdk.model.Invoice.MinerFees;
import com.bitpay.sdk.model.Invoice.MinerFeesItem;
import com.bitpay.sdk.model.Invoice.SupportedTransactionCurrencies;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.NonNull;

@DependencyInjection
class InvoicePaymentTotalFactory {

    @NonNull
    InvoicePaymentTotal create(
        @NonNull final Map.Entry<String, String> code,
        @NonNull final InvoicePayment invoicePayment,
        @NonNull final com.bitpay.sdk.model.Invoice.Invoice bitPayInvoice
    ) {
        final var bitPaySupportedTransactionCurrency = getBitPaySupportedTransactionCurrency(
            code.getKey(),
            bitPayInvoice.getSupportedTransactionCurrencies()
        );

        final var bitPayMinerFee = getBitPayMinerFee(
            code.getKey(),
            bitPayInvoice.getMinerFees()
        );

        final var invoicePaymentTotal = new InvoicePaymentTotal(
            invoicePayment,
            new CurrencyCode(code.getKey()),
            new Total(code.getValue()),
            new Subtotal(bitPayInvoice.getPaymentSubTotals().getOrDefault(code.getKey(), null)),
            new DisplayTotal(bitPayInvoice.getPaymentDisplayTotals().getOrDefault(code.getKey(), null)),
            new DisplaySubtotal(bitPayInvoice.getPaymentDisplaySubTotals().getOrDefault(code.getKey(), null)),
            getSupportedTransactionCurrency(bitPaySupportedTransactionCurrency),
            getMinerFee(bitPayMinerFee)
        );

        invoicePaymentTotal.addExchangeRates(
            getExchangeRates(
                invoicePaymentTotal,
                bitPayInvoice.getExchangeRates().getOrDefault(code.getKey(), new Hashtable<>())
            )
        );
        invoicePaymentTotal.addPaymentCodes(
            getPaymentCodes(
                invoicePaymentTotal,
                bitPayInvoice.getPaymentCodes().getOrDefault(code.getKey(), new Hashtable<>())
            )
        );

        return invoicePaymentTotal;
    }


    private Collection<InvoicePaymentCode> getPaymentCodes(
        @NonNull final InvoicePaymentTotal invoicePaymentTotal,
        @NonNull final Map<String, String> paymentCodes
    ) {
        return paymentCodes.entrySet().stream()
            .map(paymentCode ->
                new InvoicePaymentCode(
                    invoicePaymentTotal,
                    new PaymentCode(paymentCode.getKey()),
                    new PaymentCodeUrl(paymentCode.getValue())
                )
            )
            .toList();
    }

    private Collection<InvoicePaymentExchangeRate> getExchangeRates(
        @NonNull final InvoicePaymentTotal invoicePaymentTotal,
        @NonNull final Map<String, String> exchangeRates
    ) {
        return exchangeRates.entrySet().stream()
            .map(exchangeRate ->
                new InvoicePaymentExchangeRate(
                    invoicePaymentTotal,
                    new CurrencyCode(exchangeRate.getKey()),
                    new ExchangeRate(exchangeRate.getValue())
                )
            )
            .toList();
    }

    @Nullable
    private MinerFeesItem getBitPayMinerFee(
        @NonNull final String code,
        @NonNull final MinerFees minerFees
    ) {
        return switch (code.toLowerCase()) {
            case "gusd" -> minerFees.getGusd();
            case "btc" -> minerFees.getBtc();
            case "usdc" -> minerFees.getUsdc();
            case "eth" -> minerFees.getEth();
            case "bch" -> minerFees.getBch();
            case "pax" -> minerFees.getPax();
            default -> null;
        };
    }

    @Nullable
    private com.bitpay.sdk.model.Invoice.SupportedTransactionCurrency getBitPaySupportedTransactionCurrency(
        @NonNull final String code,
        @NonNull final SupportedTransactionCurrencies supportedTransactionCurrencies
    ) {
        return switch (code.toLowerCase()) {
            case "gusd" -> supportedTransactionCurrencies.getGusd();
            case "btc" -> supportedTransactionCurrencies.getBtc();
            case "usdc" -> supportedTransactionCurrencies.getUsdc();
            case "eth" -> supportedTransactionCurrencies.getEth();
            case "bch" -> supportedTransactionCurrencies.getBch();
            case "pax" -> supportedTransactionCurrencies.getPax();
            default -> null;
        };
    }

    @NonNull
    private InvoicePaymentMinerFee getMinerFee(@Nullable final MinerFeesItem bitPayMinerFee) {
        if (Objects.isNull(bitPayMinerFee)) {
            return new InvoicePaymentMinerFee();
        }

        return new InvoicePaymentMinerFee(
            new SatoshisPerByte(bitPayMinerFee.getSatoshisPerByte().doubleValue()),
            new TotalFee(bitPayMinerFee.getTotalFee().doubleValue()),
            new FiatAmount(bitPayMinerFee.getFiatAmount())
        );
    }

    @NonNull
    private InvoicePaymentSupportedTransactionCurrency getSupportedTransactionCurrency(
        @Nullable final com.bitpay.sdk.model.Invoice.SupportedTransactionCurrency bitPaySupportedTransactionCurrency
    ) {
        if (Objects.isNull(bitPaySupportedTransactionCurrency)) {
            return new InvoicePaymentSupportedTransactionCurrency(
                new Enabled(false),
                null
            );
        }

        return new InvoicePaymentSupportedTransactionCurrency(
            new Enabled(bitPaySupportedTransactionCurrency.getEnabled()),
            new Reason(bitPaySupportedTransactionCurrency.getReason())
        );
    }
}
