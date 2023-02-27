/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.shared;

import lombok.NonNull;

public class InvoiceDto {
    private final Long id;
    private final String bitPayId;
    private final Double price;
    private final String createdDate;
    private final String bitPayOrderId;
    private final String status;

    public InvoiceDto(
        @NonNull final Long id,
        @NonNull final String bitPayId,
        @NonNull final Double price,
        @NonNull final String createdDate,
        @NonNull final String bitPayOrderId,
        @NonNull final String status
    ) {
        this.id = id;
        this.bitPayId = bitPayId;
        this.price = price;
        this.createdDate = createdDate;
        this.bitPayOrderId = bitPayOrderId;
        this.status = status;
    }

    public @NonNull Long getId() {
        return this.id;
    }

    public @NonNull String getBitPayId() {
        return this.bitPayId;
    }

    public @NonNull Double getPrice() {
        return this.price;
    }

    public @NonNull String getCreatedDate() {
        return this.createdDate;
    }

    public @NonNull String getBitPayOrderId() {
        return this.bitPayOrderId;
    }

    public @NonNull String getStatus() {
        return this.status;
    }
}
