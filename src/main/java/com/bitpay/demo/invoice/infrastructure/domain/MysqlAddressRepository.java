/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.domain;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.Invoice;
import com.bitpay.demo.invoice.domain.InvoiceRepository;
import lombok.NonNull;

@DependencyInjection
class MysqlAddressRepository implements InvoiceRepository {

    SpringInvoiceRepository repo;

    MysqlAddressRepository(@NonNull final SpringInvoiceRepository repo) {
        this.repo = repo;
    }

    @Override
    public void save(@NonNull final Invoice invoice) {
        this.repo.save(invoice);
    }
}
