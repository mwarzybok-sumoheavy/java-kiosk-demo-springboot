/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.buyer;

import lombok.NonNull;

public class InvoiceBuyerProvidedInfo {

    private Long id;
    private BuyerName name;
    private BuyerPhoneNumber phoneNumber;
    private BuyerSelectedTransactionCurrency selectedTransactionCurrency;
    private BuyerEmailAddress emailAddress;
    private BuyerSelectedWallet selectedWallet;
    private BuyerSms sms;
    private BuyerSmsVerified smsVerified;

    public InvoiceBuyerProvidedInfo(
        @NonNull final BuyerName name,
        @NonNull final BuyerPhoneNumber phoneNumber,
        @NonNull final BuyerSelectedTransactionCurrency selectedTransactionCurrency,
        @NonNull final BuyerEmailAddress emailAddress,
        @NonNull final BuyerSelectedWallet selectedWallet,
        @NonNull final BuyerSms sms,
        @NonNull final BuyerSmsVerified smsVerified
    ) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.selectedTransactionCurrency = selectedTransactionCurrency;
        this.emailAddress = emailAddress;
        this.selectedWallet = selectedWallet;
        this.sms = sms;
        this.smsVerified = smsVerified;
    }

    InvoiceBuyerProvidedInfo() {
    }
}
