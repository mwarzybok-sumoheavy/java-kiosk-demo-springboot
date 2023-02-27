/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.getinvoiceview;

import com.bitpay.demo.invoice.application.features.tasks.getinvoice.GetInvoiceDto;
import com.bitpay.demo.invoice.domain.InvoiceId;
import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HttpGetInvoiceView {

    private final BitPayProperties bitPayProperties;
    private final GetInvoiceDto getInvoiceDto;

    public HttpGetInvoiceView(
        @NonNull final BitPayProperties bitPayProperties,
        @NonNull final GetInvoiceDto getInvoiceDto
    ) {
        this.bitPayProperties = bitPayProperties;
        this.getInvoiceDto = getInvoiceDto;
    }

    @GetMapping("/invoices/{id}")
    public String execute(
        @NonNull @PathVariable("id") final Long invoiceId,
        @NonNull final Model model
    ) {
        model.addAttribute("design", this.bitPayProperties.getDesign());
        model.addAttribute("invoice", this.getInvoiceDto.execute(new InvoiceId(invoiceId)));

        return "invoiceView";
    }
}
