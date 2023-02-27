/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.domain;

import lombok.NonNull;

public class PageFactory<T> {
    public @NonNull Page<T> create(@NonNull final org.springframework.data.domain.Page<T> springPage) {
        return new Page<>(
            springPage.getContent(),
            springPage.getNumber(),
            springPage.getSize(),
            springPage.getTotalElements(),
            springPage.getTotalPages()
        );
    }
}
