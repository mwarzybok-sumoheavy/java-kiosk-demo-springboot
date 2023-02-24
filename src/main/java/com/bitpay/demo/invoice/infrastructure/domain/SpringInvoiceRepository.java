/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.domain;

import com.bitpay.demo.invoice.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SpringInvoiceRepository extends JpaRepository<Invoice, Long> {
}
