/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.shared;

import lombok.NonNull;

public class InvoiceDto {
    private final Long id;
    private final String bitPayId;
    private final String price;
    private final String createdDate;
    private final String bitPayOrderId;
    private final String status;
    private final String description;

    public InvoiceDto(
        @NonNull final Long id,
        @NonNull final String bitPayId,
        @NonNull final String price,
        @NonNull final String createdDate,
        @NonNull final String bitPayOrderId,
        @NonNull final String status,
        @NonNull final String description
    ) {
        this.id = id;
        this.bitPayId = bitPayId;
        this.price = price;
        this.createdDate = createdDate;
        this.bitPayOrderId = bitPayOrderId;
        this.status = status;
        this.description = description;
    }

    public @NonNull Long getId() {
        return this.id;
    }

    public @NonNull String getBitPayId() {
        return this.bitPayId;
    }

    public @NonNull String getPrice() {
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

    public @NonNull String getDescription() {
        return this.description;
    }
}
