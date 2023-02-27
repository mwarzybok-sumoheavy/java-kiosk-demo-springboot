/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.domain;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.NonNull;

public class Page<T> {

    private final List<T> content;
    private final int currentPageNumber;
    private final int maxElementsPerPage;
    private final long totalElements;
    private final int totalPages;

    public Page(
        @NonNull final List<T> content,
        final int currentPageNumber,
        final int maxElementsPerPage,
        final long totalElements,
        final int totalPages
    ) {
        this.content = content;
        this.currentPageNumber = currentPageNumber;
        this.maxElementsPerPage = maxElementsPerPage;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public @NonNull List<T> getContent() {
        return this.content;
    }

    public int getCurrentPageNumber() {
        return this.currentPageNumber;
    }

    public int getMaxElementsPerPage() {
        return this.maxElementsPerPage;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public @NonNull <U> Page<U> mapElementsToNewType(@NonNull final Function<T, U> converter) {
        return new Page<>(
            this.content.stream().map(converter).collect(Collectors.toList()),
            this.currentPageNumber,
            this.maxElementsPerPage,
            this.totalElements,
            this.totalPages
        );
    }
}

