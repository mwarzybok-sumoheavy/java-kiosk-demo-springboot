/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain;

import com.bitpay.demo.shared.domain.EntityPageNumber;
import com.bitpay.demo.shared.domain.EntityPageSize;
import com.bitpay.demo.shared.domain.Page;
import java.util.Collection;
import lombok.NonNull;

public interface InvoiceRepository {
    void save(@NonNull Invoice invoice);

    @NonNull
    Invoice findById(@NonNull InvoiceId invoiceId) throws InvoiceNotFound;

    @NonNull
    Page<Invoice> findAllPaginated(
        @NonNull EntityPageNumber pageNumber,
        @NonNull EntityPageSize pageSize
    );

    @NonNull
    Invoice findByUuid(@NonNull InvoiceUuid invoiceUuid) throws InvoiceNotFound;

    @NonNull
    Collection<Invoice> findAll();
}
