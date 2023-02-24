/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.getinvoiceform;

import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpGetInvoiceForm {

    private final BitPayProperties bitPayProperties;

    public HttpGetInvoiceForm(@NonNull final BitPayProperties bitPayProperties) {
        this.bitPayProperties = bitPayProperties;
    }

    @GetMapping("/")
    public String execute(@NonNull final Model model) {
        model.addAttribute("design", this.bitPayProperties.getDesign());

        return "index";
    }
}
