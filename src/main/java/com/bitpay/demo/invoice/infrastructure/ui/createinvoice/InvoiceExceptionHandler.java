/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.createinvoice;

import com.bitpay.sdk.exceptions.BitPayException;
import lombok.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice("com.bitpay.demo.invoice.infrastructure.ui.postcreateinvoice")
public class InvoiceExceptionHandler {

    @ExceptionHandler(BitPayException.class)
    public String handleBitPayException(
        @NonNull final BitPayException exception,
        @NonNull final RedirectAttributes redirectAttrs
    ) {
        redirectAttrs.addFlashAttribute("error", exception.getReasonPhrase());

        return "redirect:";
    }
}
