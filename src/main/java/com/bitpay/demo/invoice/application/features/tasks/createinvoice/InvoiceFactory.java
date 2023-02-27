/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.AcceptanceWindow;
import com.bitpay.demo.invoice.domain.AmountPaid;
import com.bitpay.demo.invoice.domain.AutoRedirect;
import com.bitpay.demo.invoice.domain.BillId;
import com.bitpay.demo.invoice.domain.BitPayGuid;
import com.bitpay.demo.invoice.domain.BitPayId;
import com.bitpay.demo.invoice.domain.BitPayIdRequired;
import com.bitpay.demo.invoice.domain.BitPayOrderId;
import com.bitpay.demo.invoice.domain.BitPayUrl;
import com.bitpay.demo.invoice.domain.BuyerJson;
import com.bitpay.demo.invoice.domain.BuyerProvidedEmail;
import com.bitpay.demo.invoice.domain.CloseUrl;
import com.bitpay.demo.invoice.domain.Currency;
import com.bitpay.demo.invoice.domain.DisplayAmountPaid;
import com.bitpay.demo.invoice.domain.ExceptionStatus;
import com.bitpay.demo.invoice.domain.ExchangeRatesJson;
import com.bitpay.demo.invoice.domain.FacadeType;
import com.bitpay.demo.invoice.domain.Invoice;
import com.bitpay.demo.invoice.domain.InvoiceBuyer;
import com.bitpay.demo.invoice.domain.InvoicePayment;
import com.bitpay.demo.invoice.domain.IsCancelled;
import com.bitpay.demo.invoice.domain.ItemDescription;
import com.bitpay.demo.invoice.domain.ItemizedDetailsJson;
import com.bitpay.demo.invoice.domain.JsonPayProRequired;
import com.bitpay.demo.invoice.domain.LowFeeDetected;
import com.bitpay.demo.invoice.domain.MerchantName;
import com.bitpay.demo.invoice.domain.MinerFeesJson;
import com.bitpay.demo.invoice.domain.NonPayProPaymentReceived;
import com.bitpay.demo.invoice.domain.OverpaidAmount;
import com.bitpay.demo.invoice.domain.PaymentCodesJson;
import com.bitpay.demo.invoice.domain.PaymentDisplaySubtotalsJson;
import com.bitpay.demo.invoice.domain.PaymentDisplayTotalsJson;
import com.bitpay.demo.invoice.domain.PaymentSubtotalsJson;
import com.bitpay.demo.invoice.domain.PaymentTotalsJson;
import com.bitpay.demo.invoice.domain.PosDataJson;
import com.bitpay.demo.invoice.domain.Price;
import com.bitpay.demo.invoice.domain.RedirectUrl;
import com.bitpay.demo.invoice.domain.RefundAddressRequestPending;
import com.bitpay.demo.invoice.domain.RefundAddressesJson;
import com.bitpay.demo.invoice.domain.RefundInfoJson;
import com.bitpay.demo.invoice.domain.ShopperJson;
import com.bitpay.demo.invoice.domain.Status;
import com.bitpay.demo.invoice.domain.SupportedTransactionCurrenciesJson;
import com.bitpay.demo.invoice.domain.TargetConfirmations;
import com.bitpay.demo.invoice.domain.Token;
import com.bitpay.demo.invoice.domain.TransactionCurrency;
import com.bitpay.demo.invoice.domain.TransactionsJson;
import com.bitpay.demo.invoice.domain.UnderpaidAmount;
import com.bitpay.demo.invoice.domain.UniversalCodesJson;
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
import java.util.Optional;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

@DependencyInjection
class InvoiceFactory {

    private final ObjectToJsonConverter objectToJsonConverter;

    InvoiceFactory(@NonNull final ObjectToJsonConverter objectToJsonConverter) {
        this.objectToJsonConverter = objectToJsonConverter;
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
            getInvoicePayment(bitPayInvoice),
            getInvoiceBuyer(bitPayInvoice),
            getInvoiceBuyerProvidedInfo(bitPayInvoice.getInvoiceBuyerProvidedInfo())
        );
    }

    @NotNull
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

    @NotNull
    private InvoiceBuyer getInvoiceBuyer(@NotNull final com.bitpay.sdk.model.Invoice.Invoice bitPayInvoice) {
        return new InvoiceBuyer(
            new BuyerJson(this.objectToJsonConverter.execute(bitPayInvoice.getBuyer())),
            new BuyerProvidedEmail(bitPayInvoice.getBuyerProvidedEmail())
        );
    }

    @NotNull
    private InvoicePayment getInvoicePayment(@NotNull final com.bitpay.sdk.model.Invoice.Invoice bitPayInvoice) {
        return new InvoicePayment(
            new TargetConfirmations(bitPayInvoice.getTargetConfirmations()),
            new TransactionsJson(this.objectToJsonConverter.execute(bitPayInvoice.getTransactions())),
            new RefundAddressesJson(this.objectToJsonConverter.execute(bitPayInvoice.getRefundAddresses())),
            new LowFeeDetected(bitPayInvoice.getLowFeeDetected()),
            new AmountPaid(bitPayInvoice.getAmountPaid().doubleValue()),
            new DisplayAmountPaid(bitPayInvoice.getDisplayAmountPaid().doubleValue()),
            new RefundAddressRequestPending(bitPayInvoice.getRefundAddressRequestPending()),
            new PaymentSubtotalsJson(this.objectToJsonConverter.execute(bitPayInvoice.getPaymentSubTotals())),
            new PaymentTotalsJson(this.objectToJsonConverter.execute(bitPayInvoice.getPaymentTotals())),
            new PaymentDisplayTotalsJson(this.objectToJsonConverter.execute(bitPayInvoice.getPaymentDisplayTotals())),
            new PaymentDisplaySubtotalsJson(
                this.objectToJsonConverter.execute(bitPayInvoice.getPaymentDisplaySubTotals())
            ),
            new ExchangeRatesJson(this.objectToJsonConverter.execute(bitPayInvoice.getExchangeRates())),
            new SupportedTransactionCurrenciesJson(
                this.objectToJsonConverter.execute(bitPayInvoice.getSupportedTransactionCurrencies())
            ),
            new MinerFeesJson(this.objectToJsonConverter.execute(bitPayInvoice.getMinerFees())),
            new NonPayProPaymentReceived(bitPayInvoice.getNonPayProPaymentReceived()),
            new AutoRedirect(bitPayInvoice.getAutoRedirect()),
            new ShopperJson(this.objectToJsonConverter.execute(bitPayInvoice.getShopper())),
            new RefundInfoJson(this.objectToJsonConverter.execute(bitPayInvoice.getRefundInfo())),
            new JsonPayProRequired(bitPayInvoice.getJsonPayProRequired()),
            new UniversalCodesJson(this.objectToJsonConverter.execute(bitPayInvoice.getUniversalCodes())),
            new BitPayIdRequired(bitPayInvoice.getBitpayIdRequired()),
            new IsCancelled(bitPayInvoice.getIsCancelled()),
            new ItemizedDetailsJson(this.objectToJsonConverter.execute(bitPayInvoice.getItemizedDetails())),
            new TransactionCurrency(bitPayInvoice.getTransactionCurrency()),
            new PaymentCodesJson(this.objectToJsonConverter.execute(bitPayInvoice.getPaymentCodes())),
            Optional.ofNullable(bitPayInvoice.getUnderPaidAmount())
                .map(amount -> new UnderpaidAmount(amount.doubleValue()))
                .orElse(null),
            Optional.ofNullable(bitPayInvoice.getOverPaidAmount())
                .map(amount -> new OverpaidAmount(amount.doubleValue()))
                .orElse(null)
        );
    }
}
