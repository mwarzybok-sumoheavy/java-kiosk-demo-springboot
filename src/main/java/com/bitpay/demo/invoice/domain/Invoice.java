/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import com.bitpay.demo.invoice.domain.buyer.InvoiceBuyer;
import com.bitpay.demo.invoice.domain.itemizeddetail.InvoiceItemizedDetail;
import com.bitpay.demo.invoice.domain.payment.InvoicePayment;
import com.bitpay.demo.invoice.domain.refund.InvoiceRefund;
import com.bitpay.demo.invoice.domain.transaction.InvoiceTransaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import lombok.NonNull;

public class Invoice {

    private Long id;
    private InvoiceUuid uuid;
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
    private InvoiceRefund invoiceRefund;
    private Collection<InvoiceTransaction> invoiceTransactions = List.of();
    private Collection<InvoiceItemizedDetail> invoiceItemizedDetails = List.of();

    public Invoice(
        @NonNull final InvoiceUuid uuid,
        @NonNull final PosDataJson posData,
        @NonNull final Price price,
        @NonNull final CurrencyCode currencyCode,
        @NonNull final BitPayId bitPayId,
        @NonNull final Status status,
        @NonNull final LocalDateTime createdDate,
        @NonNull final InvoicePayment invoicePayment,
        @NonNull final InvoiceBuyer invoiceBuyer,
        @NonNull final InvoiceRefund invoiceRefund,
        @Nullable final BitPayOrderId bitPayOrderId,
        @Nullable final LocalDateTime expirationTime,
        @Nullable final FacadeType facadeType,
        @Nullable final BitPayGuid bitPayGuid,
        @Nullable final ExceptionStatus exceptionStatus,
        @Nullable final BitPayUrl bitPayUrl,
        @Nullable final RedirectUrl redirectUrl,
        @Nullable final CloseUrl closeUrl,
        @Nullable final AcceptanceWindow acceptanceWindow,
        @Nullable final Token token,
        @Nullable final MerchantName merchantName,
        @Nullable final ItemDescription itemDescription,
        @Nullable final BillId billId,
        @Nullable final TargetConfirmations targetConfirmations,
        @Nullable final LowFeeDetected lowFeeDetected,
        @Nullable final AutoRedirect autoRedirect,
        @Nullable final ShopperUser shopperUser,
        @Nullable final JsonPayProRequired jsonPayProRequired,
        @Nullable final BitPayIdRequired bitPayIdRequired,
        @Nullable final IsCancelled isCancelled
    ) {
        this.uuid = uuid;
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

    public @NonNull LocalDateTime getExpirationTime() {
        return this.expirationTime;
    }

    public @NonNull FacadeType getFacadeType() {
        return this.facadeType;
    }

    public @NonNull BitPayGuid getBitPayGuid() {
        return this.bitPayGuid;
    }

    public @NonNull ExceptionStatus getExceptionStatus() {
        return this.exceptionStatus;
    }

    public @NonNull BitPayUrl getBitPayUrl() {
        return this.bitPayUrl;
    }

    public @NonNull RedirectUrl getRedirectUrl() {
        return this.redirectUrl;
    }

    public @NonNull CloseUrl getCloseUrl() {
        return this.closeUrl;
    }

    public @NonNull AcceptanceWindow getAcceptanceWindow() {
        return this.acceptanceWindow;
    }

    public @NonNull Token getToken() {
        return this.token;
    }

    public @NonNull MerchantName getMerchantName() {
        return this.merchantName;
    }

    public @NonNull BillId getBillId() {
        return this.billId;
    }

    public @NonNull TargetConfirmations getTargetConfirmations() {
        return this.targetConfirmations;
    }

    public @NonNull LowFeeDetected getLowFeeDetected() {
        return this.lowFeeDetected;
    }

    public @NonNull AutoRedirect getAutoRedirect() {
        return this.autoRedirect;
    }

    public @NonNull ShopperUser getShopperUser() {
        return this.shopperUser;
    }

    public @NonNull JsonPayProRequired getJsonPayProRequired() {
        return this.jsonPayProRequired;
    }

    public @NonNull BitPayIdRequired getBitPayIdRequired() {
        return this.bitPayIdRequired;
    }

    public @NonNull IsCancelled getIsCancelled() {
        return this.isCancelled;
    }

    public @NonNull InvoicePayment getInvoicePayment() {
        return this.invoicePayment;
    }

    public @NonNull InvoiceBuyer getInvoiceBuyer() {
        return this.invoiceBuyer;
    }

    public @NonNull InvoiceRefund getInvoiceRefund() {
        return this.invoiceRefund;
    }

    public @NonNull Collection<InvoiceTransaction> getInvoiceTransactions() {
        return this.invoiceTransactions;
    }

    public @NonNull Collection<InvoiceItemizedDetail> getInvoiceItemizedDetails() {
        return this.invoiceItemizedDetails;
    }

    public @NonNull InvoiceUuid getUuid() {
        return this.uuid;
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

    public void update(@NonNull final Invoice invoice) {
        this.price = invoice.getPrice();
        this.currencyCode = invoice.getCurrencyCode();
        this.status = invoice.getStatus();
        this.bitPayOrderId = invoice.getBitPayOrderId();
        this.expirationTime = invoice.getExpirationTime();
        this.exceptionStatus = invoice.getExceptionStatus();
        this.bitPayUrl = invoice.getBitPayUrl();
        this.invoicePayment.update(invoice.getInvoicePayment());
        this.invoiceBuyer.update(invoice.getInvoiceBuyer());
    }

    @NonNull
    public InvoiceId getInvoiceId() {
        return new InvoiceId(this.id);
    }
}
