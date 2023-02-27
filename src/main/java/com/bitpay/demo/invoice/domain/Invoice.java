/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import java.time.LocalDateTime;
import lombok.NonNull;

public class Invoice {

    private Long id;
    private PosDataJson posData;
    private Price price;
    private Currency currency;
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
    private InvoicePayment invoicePayment;
    private InvoiceBuyer invoiceBuyer;

    public Invoice(
        @NonNull final PosDataJson posData,
        @NonNull final Price price,
        @NonNull final Currency currency,
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
        @NonNull final InvoicePayment invoicePayment,
        @NonNull final InvoiceBuyer invoiceBuyer
    ) {
        this.posData = posData;
        this.price = price;
        this.currency = currency;
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
        this.invoicePayment = invoicePayment;
        this.invoiceBuyer = invoiceBuyer;
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

    public @NonNull Currency getCurrency() {
        return this.currency;
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
}
