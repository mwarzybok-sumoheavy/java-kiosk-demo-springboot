/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.domain;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.Invoice;
import com.bitpay.demo.invoice.domain.InvoiceId;
import com.bitpay.demo.invoice.domain.InvoiceNotFound;
import com.bitpay.demo.invoice.domain.InvoiceRepository;
import com.bitpay.demo.invoice.domain.InvoiceUuid;
import com.bitpay.demo.shared.domain.EntityPageNumber;
import com.bitpay.demo.shared.domain.EntityPageSize;
import com.bitpay.demo.shared.domain.Page;
import com.bitpay.demo.shared.domain.PageFactory;
import com.bitpay.demo.shared.domain.SpringPageRequest;
import java.util.Collection;
import lombok.NonNull;

@DependencyInjection
class MysqlAddressRepository implements InvoiceRepository {

    private final PageFactory<Invoice> pageFactory = new PageFactory<>();

    SpringInvoiceRepository repo;

    MysqlAddressRepository(@NonNull final SpringInvoiceRepository repo) {
        this.repo = repo;
    }

    @Override
    public void save(@NonNull final Invoice invoice) {
        this.repo.save(invoice);
    }

    @Override
    public @NonNull Invoice findById(@NonNull final InvoiceId invoiceId) throws InvoiceNotFound {
        return this.repo.findById(invoiceId.value()).orElseThrow(InvoiceNotFound::new);
    }

    @Override
    public @NonNull Page<Invoice> findAllPaginated(
        @NonNull final EntityPageNumber pageNumber,
        @NonNull final EntityPageSize pageSize
    ) {
        return this.pageFactory.create(
            this.repo.findAll(
                new SpringPageRequest(
                    pageNumber,
                    pageSize
                ).value()
            )
        );
    }

    @Override
    public @NonNull Invoice findByUuid(@NonNull final InvoiceUuid invoiceUuid) throws InvoiceNotFound {
        return this.repo.findByUuid(invoiceUuid).orElseThrow(InvoiceNotFound::new);
    }

    @Override
    public @NonNull Collection<Invoice> findAll() {
        return this.repo.findAll();
    }
}
