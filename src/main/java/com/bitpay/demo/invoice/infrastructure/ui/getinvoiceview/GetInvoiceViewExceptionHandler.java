/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.getinvoiceview;

import com.bitpay.demo.invoice.domain.InvoiceNotFound;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.bitpay.demo.invoice.infrastructure.ui.getinvoiceview")
public class GetInvoiceViewExceptionHandler {

    @ExceptionHandler(InvoiceNotFound.class)
    public String handleInvoiceNotFound() {
        return "redirect:/404";
    }
}
