/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.payment;

import lombok.NonNull;

public class InvoicePaymentCurrencyMinerFee {
    private Long id;
    private SatoshisPerByte satoshisPerByte;
    private TotalFee totalFee;
    private FiatAmount fiatAmount;

    public InvoicePaymentCurrencyMinerFee(
        @NonNull final SatoshisPerByte satoshisPerByte,
        @NonNull final TotalFee totalFee,
        @NonNull final FiatAmount fiatAmount
    ) {
        this.satoshisPerByte = satoshisPerByte;
        this.totalFee = totalFee;
        this.fiatAmount = fiatAmount;
    }

    public InvoicePaymentCurrencyMinerFee() {
    }

    public Long getId() {
        return this.id;
    }

    public SatoshisPerByte getSatoshisPerByte() {
        return this.satoshisPerByte;
    }

    public TotalFee getTotalFee() {
        return this.totalFee;
    }

    public FiatAmount getFiatAmount() {
        return this.fiatAmount;
    }
}
