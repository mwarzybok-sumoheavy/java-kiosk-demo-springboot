/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.domain;

import lombok.NonNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class SpringPageRequest {

    private final PageRequest value;

    public SpringPageRequest(
        @NonNull final EntityPageNumber pageNumber,
        @NonNull final EntityPageSize pageSize
    ) {
        this.value = PageRequest.of(
            Math.max(pageNumber.value() - 1, 0),
            pageSize.value(),
            Sort.by(Sort.Direction.ASC, "id")
        );
    }

    public SpringPageRequest(
        @NonNull final EntityPageNumber pageNumber,
        @NonNull final EntityPageSize pageSize,
        @NonNull final Sort sort) {
        this.value = PageRequest.of(
            Math.max(pageNumber.value() - 1, 0),
            pageSize.value(),
            sort
        );
    }

    public PageRequest value() {
        return this.value;
    }
}
