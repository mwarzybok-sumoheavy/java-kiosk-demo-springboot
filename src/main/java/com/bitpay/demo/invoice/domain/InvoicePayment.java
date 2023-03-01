/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import com.bitpay.demo.invoice.domain.payment.InvoicePaymentTotal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import lombok.NonNull;

public class InvoicePayment {

    private Long id;
    private TargetConfirmations targetConfirmations;
    private TransactionsJson transactions;
    private RefundAddressesJson refundAddresses;
    private LowFeeDetected lowFeeDetected;
    private AmountPaid amountPaid;
    private DisplayAmountPaid displayAmountPaid;
    private RefundAddressRequestPending refundAddressRequestPending;
    private NonPayProPaymentReceived nonPayProPaymentReceived;
    private AutoRedirect autoRedirect;
    private ShopperUser shopperUser;
    private RefundInfoJson refundInfo;
    private JsonPayProRequired jsonPayProRequired;
    private UniversalCodesPaymentString universalCodesPaymentString;
    private UniversalCodesVerificationLink universalCodesVerificationLink;
    private BitPayIdRequired bitPayIdRequired;
    private IsCancelled isCancelled;
    private ItemizedDetailsJson itemizedDetails;
    private TransactionCurrency transactionCurrency;
    private UnderpaidAmount underpaidAmount;
    private OverpaidAmount overpaidAmount;
    private Collection<InvoicePaymentTotal> paymentTotals = List.of();

    public InvoicePayment(
        @NonNull final TargetConfirmations targetConfirmations,
        @NonNull final TransactionsJson transactions,
        @NonNull final RefundAddressesJson refundAddresses,
        @NonNull final LowFeeDetected lowFeeDetected,
        @NonNull final AmountPaid amountPaid,
        @NonNull final DisplayAmountPaid displayAmountPaid,
        @NonNull final RefundAddressRequestPending refundAddressRequestPending,
        @NonNull final NonPayProPaymentReceived nonPayProPaymentReceived,
        @NonNull final AutoRedirect autoRedirect,
        @NonNull final ShopperUser shopperUser,
        @NonNull final RefundInfoJson refundInfo,
        @NonNull final JsonPayProRequired jsonPayProRequired,
        @NonNull final UniversalCodesPaymentString universalCodesPaymentString,
        @NonNull final UniversalCodesVerificationLink universalCodesVerificationLink,
        @NonNull final BitPayIdRequired bitPayIdRequired,
        @NonNull final IsCancelled isCancelled,
        @NonNull final ItemizedDetailsJson itemizedDetails,
        @NonNull final TransactionCurrency transactionCurrency,
        @Nullable final UnderpaidAmount underpaidAmount,
        @Nullable final OverpaidAmount overpaidAmount
    ) {
        this.targetConfirmations = targetConfirmations;
        this.transactions = transactions;
        this.refundAddresses = refundAddresses;
        this.lowFeeDetected = lowFeeDetected;
        this.amountPaid = amountPaid;
        this.displayAmountPaid = displayAmountPaid;
        this.refundAddressRequestPending = refundAddressRequestPending;
        this.nonPayProPaymentReceived = nonPayProPaymentReceived;
        this.autoRedirect = autoRedirect;
        this.shopperUser = shopperUser;
        this.refundInfo = refundInfo;
        this.jsonPayProRequired = jsonPayProRequired;
        this.universalCodesPaymentString = universalCodesPaymentString;
        this.universalCodesVerificationLink = universalCodesVerificationLink;
        this.bitPayIdRequired = bitPayIdRequired;
        this.isCancelled = isCancelled;
        this.itemizedDetails = itemizedDetails;
        this.transactionCurrency = transactionCurrency;
        this.underpaidAmount = underpaidAmount;
        this.overpaidAmount = overpaidAmount;
    }

    InvoicePayment() {
    }

    public void addPaymentTotals(@NonNull final Collection<InvoicePaymentTotal> invoicePaymentTotal) {
        final var paymentTotals = new ArrayList<>(this.paymentTotals);
        paymentTotals.addAll(invoicePaymentTotal);

        this.paymentTotals = paymentTotals;
    }
}
