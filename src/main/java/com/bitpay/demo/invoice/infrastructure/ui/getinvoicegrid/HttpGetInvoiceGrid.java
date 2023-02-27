/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.getinvoicegrid;

import com.bitpay.demo.invoice.application.features.tasks.getinvoicegrid.GetInvoiceDtoGrid;
import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import com.bitpay.demo.shared.domain.EntityPageNumber;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HttpGetInvoiceGrid {

    private final BitPayProperties bitPayProperties;
    private final GetInvoiceDtoGrid getInvoiceDtoGrid;

    public HttpGetInvoiceGrid(
        @NonNull final BitPayProperties bitPayProperties,
        @NonNull final GetInvoiceDtoGrid getInvoiceDtoGrid
    ) {
        this.bitPayProperties = bitPayProperties;
        this.getInvoiceDtoGrid = getInvoiceDtoGrid;
    }

    @GetMapping("/invoices")
    public String execute(
        @RequestParam(value = "page", defaultValue = "1") final int page,
        @NonNull final Model model
    ) {
        final var grid = this.getInvoiceDtoGrid.execute(new EntityPageNumber(page));
        model.addAttribute("design", this.bitPayProperties.getDesign());
        model.addAttribute("grid", grid);
        model.addAttribute("navigationPrevious", Math.max(grid.getCurrentPageNumber(), 1));
        model.addAttribute("navigationNext", Math.min(grid.getCurrentPageNumber() + 2, grid.getTotalPages()));

        return "invoiceGrid";
    }
}
