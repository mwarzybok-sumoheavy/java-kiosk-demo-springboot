/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

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
    private PaymentSubtotalsJson paymentSubtotals;
    private PaymentTotalsJson paymentTotals;
    private PaymentDisplayTotalsJson paymentDisplayTotals;
    private PaymentDisplaySubtotalsJson paymentDisplaySubtotals;
    private ExchangeRatesJson exchangeRates;
    private SupportedTransactionCurrenciesJson supportedTransactionCurrencies;
    private MinerFeesJson minerFees;
    private NonPayProPaymentReceived nonPayProPaymentReceived;
    private AutoRedirect autoRedirect;
    private ShopperJson shopper;
    private RefundInfoJson refundInfo;
    private JsonPayProRequired jsonPayProRequired;
    private UniversalCodesJson universalCodes;
    private BitPayIdRequired bitPayIdRequired;
    private IsCancelled isCancelled;
    private ItemizedDetailsJson itemizedDetails;
    private TransactionCurrency transactionCurrency;
    private UnderpaidAmount underpaidAmount;
    private OverpaidAmount overpaidAmount;
    private PaymentCodesJson paymentCodes;

    public InvoicePayment(
        @NonNull final TargetConfirmations targetConfirmations,
        @NonNull final TransactionsJson transactions,
        @NonNull final RefundAddressesJson refundAddresses,
        @NonNull final LowFeeDetected lowFeeDetected,
        @NonNull final AmountPaid amountPaid,
        @NonNull final DisplayAmountPaid displayAmountPaid,
        @NonNull final RefundAddressRequestPending refundAddressRequestPending,
        @NonNull final PaymentSubtotalsJson paymentSubtotals,
        @NonNull final PaymentTotalsJson paymentTotals,
        @NonNull final PaymentDisplayTotalsJson paymentDisplayTotals,
        @NonNull final PaymentDisplaySubtotalsJson paymentDisplaySubtotals,
        @NonNull final ExchangeRatesJson exchangeRates,
        @NonNull final SupportedTransactionCurrenciesJson supportedTransactionCurrencies,
        @NonNull final MinerFeesJson minerFees,
        @NonNull final NonPayProPaymentReceived nonPayProPaymentReceived,
        @NonNull final AutoRedirect autoRedirect,
        @NonNull final ShopperJson shopper,
        @NonNull final RefundInfoJson refundInfo,
        @NonNull final JsonPayProRequired jsonPayProRequired,
        @NonNull final UniversalCodesJson universalCodes,
        @NonNull final BitPayIdRequired bitPayIdRequired,
        @NonNull final IsCancelled isCancelled,
        @NonNull final ItemizedDetailsJson itemizedDetails,
        @NonNull final TransactionCurrency transactionCurrency,
        @NonNull final PaymentCodesJson paymentCodes,
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
        this.paymentSubtotals = paymentSubtotals;
        this.paymentTotals = paymentTotals;
        this.paymentDisplayTotals = paymentDisplayTotals;
        this.paymentDisplaySubtotals = paymentDisplaySubtotals;
        this.exchangeRates = exchangeRates;
        this.supportedTransactionCurrencies = supportedTransactionCurrencies;
        this.minerFees = minerFees;
        this.nonPayProPaymentReceived = nonPayProPaymentReceived;
        this.autoRedirect = autoRedirect;
        this.shopper = shopper;
        this.refundInfo = refundInfo;
        this.jsonPayProRequired = jsonPayProRequired;
        this.universalCodes = universalCodes;
        this.bitPayIdRequired = bitPayIdRequired;
        this.isCancelled = isCancelled;
        this.itemizedDetails = itemizedDetails;
        this.transactionCurrency = transactionCurrency;
        this.underpaidAmount = underpaidAmount;
        this.overpaidAmount = overpaidAmount;
        this.paymentCodes = paymentCodes;
    }

    InvoicePayment() {
    }
}
