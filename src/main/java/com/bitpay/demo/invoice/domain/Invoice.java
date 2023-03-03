/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import com.bitpay.demo.invoice.domain.buyer.InvoiceBuyer;
import com.bitpay.demo.invoice.domain.buyer.InvoiceBuyerProvidedInfo;
import com.bitpay.demo.invoice.domain.itemizeddetail.InvoiceItemizedDetail;
import com.bitpay.demo.invoice.domain.payment.InvoicePayment;
import com.bitpay.demo.invoice.domain.refund.InvoiceRefund;
import com.bitpay.demo.invoice.domain.transaction.InvoiceTransaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

public class Invoice {

    private Long id;
    private PosDataJson posData;
    private Price price;
    private CurrencyCode currencyCode;
    private BitPayId bitPayId;
    private Status status;
    private LocalDateTime createdDate;
    private BitPayOrderId bitPayOrderId;
    private LocalDateTime expirationTime;
    private FacadeType facadeType;
    private BitPayGuid bitPayGuid;
    private ExceptionStatus exceptionStatus;
    private BitPayUrl bitPayUrl;
    private RedirectUrl redirectUrl;
    private CloseUrl closeUrl;
    private AcceptanceWindow acceptanceWindow;
    private Token token;
    private MerchantName merchantName;
    private ItemDescription itemDescription;
    private BillId billId;
    private TargetConfirmations targetConfirmations;
    private LowFeeDetected lowFeeDetected;
    private AutoRedirect autoRedirect;
    private ShopperUser shopperUser;
    private JsonPayProRequired jsonPayProRequired;
    private BitPayIdRequired bitPayIdRequired;
    private IsCancelled isCancelled;
    private InvoicePayment invoicePayment;
    private InvoiceBuyer invoiceBuyer;
    private InvoiceBuyerProvidedInfo invoiceBuyerProvidedInfo;
    private InvoiceRefund invoiceRefund;
    private Collection<InvoiceTransaction> invoiceTransactions = List.of();
    private Collection<InvoiceItemizedDetail> invoiceItemizedDetails = List.of();

    public Invoice(
        @NonNull final PosDataJson posData,
        @NonNull final Price price,
        @NonNull final CurrencyCode currencyCode,
        @NonNull final BitPayId bitPayId,
        @NonNull final Status status,
        @NonNull final LocalDateTime createdDate,
        @NonNull final BitPayOrderId bitPayOrderId,
        @NonNull final LocalDateTime expirationTime,
        @NonNull final FacadeType facadeType,
        @NonNull final BitPayGuid bitPayGuid,
        @NonNull final ExceptionStatus exceptionStatus,
        @NonNull final BitPayUrl bitPayUrl,
        @NonNull final RedirectUrl redirectUrl,
        @NonNull final CloseUrl closeUrl,
        @NonNull final AcceptanceWindow acceptanceWindow,
        @NonNull final Token token,
        @NonNull final MerchantName merchantName,
        @NonNull final ItemDescription itemDescription,
        @NonNull final BillId billId,
        @NonNull final TargetConfirmations targetConfirmations,
        @NonNull final LowFeeDetected lowFeeDetected,
        @NonNull final AutoRedirect autoRedirect,
        @NonNull final ShopperUser shopperUser,
        @NonNull final JsonPayProRequired jsonPayProRequired,
        @NonNull final BitPayIdRequired bitPayIdRequired,
        @NonNull final IsCancelled isCancelled,
        @NonNull final InvoicePayment invoicePayment,
        @NonNull final InvoiceBuyer invoiceBuyer,
        @NonNull final InvoiceBuyerProvidedInfo invoiceBuyerProvidedInfo,
        @NonNull final InvoiceRefund invoiceRefund
    ) {
        this.posData = posData;
        this.price = price;
        this.currencyCode = currencyCode;
        this.bitPayId = bitPayId;
        this.status = status;
        this.createdDate = createdDate;
        this.bitPayOrderId = bitPayOrderId;
        this.expirationTime = expirationTime;
        this.facadeType = facadeType;
        this.bitPayGuid = bitPayGuid;
        this.exceptionStatus = exceptionStatus;
        this.bitPayUrl = bitPayUrl;
        this.redirectUrl = redirectUrl;
        this.closeUrl = closeUrl;
        this.acceptanceWindow = acceptanceWindow;
        this.token = token;
        this.merchantName = merchantName;
        this.itemDescription = itemDescription;
        this.billId = billId;
        this.targetConfirmations = targetConfirmations;
        this.lowFeeDetected = lowFeeDetected;
        this.autoRedirect = autoRedirect;
        this.shopperUser = shopperUser;
        this.jsonPayProRequired = jsonPayProRequired;
        this.bitPayIdRequired = bitPayIdRequired;
        this.isCancelled = isCancelled;
        this.invoicePayment = invoicePayment;
        this.invoiceBuyer = invoiceBuyer;
        this.invoiceBuyerProvidedInfo = invoiceBuyerProvidedInfo;
        this.invoiceRefund = invoiceRefund;
    }

    Invoice() {
    }

    public @NonNull Long getId() {
        return this.id;
    }

    public @NonNull PosDataJson getPosData() {
        return this.posData;
    }

    public @NonNull Price getPrice() {
        return this.price;
    }

    public @NonNull CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public @NonNull Status getStatus() {
        return this.status;
    }

    public @NonNull BitPayId getBitPayId() {
        return this.bitPayId;
    }

    public @NonNull LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public @NonNull BitPayOrderId getBitPayOrderId() {
        return this.bitPayOrderId;
    }

    public @NonNull ItemDescription getItemDescription() {
        return this.itemDescription;
    }

    public void addInvoiceTransactions(@NonNull final Collection<InvoiceTransaction> invoiceTransactions) {
        final var transactions = new ArrayList<>(this.invoiceTransactions);
        transactions.addAll(invoiceTransactions);

        this.invoiceTransactions = transactions;
    }

    public void addInvoiceItemizedDetails(final Collection<InvoiceItemizedDetail> invoiceItemizedDetails) {
        final var itemizedDetails = new ArrayList<>(this.invoiceItemizedDetails);
        itemizedDetails.addAll(invoiceItemizedDetails);

        this.invoiceItemizedDetails = itemizedDetails;
    }
}
