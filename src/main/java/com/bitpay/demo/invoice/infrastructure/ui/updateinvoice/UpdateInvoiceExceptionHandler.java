/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.infrastructure.ui.updateinvoice;

import com.bitpay.demo.invoice.application.features.tasks.updateinvoice.ValidationInvoiceUpdateDataFailed;
import com.bitpay.demo.invoice.domain.InvoiceNotFound;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Map;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice("com.bitpay.demo.invoice.infrastructure.ui.updateinvoice")
public class UpdateInvoiceExceptionHandler {

    private static final String RESPONSE_TIMESTAMP_KEY = "timestamp";
    private static final String RESPONSE_ERRORS_KEY = "errors";
    private static final String RESPONSE_STATUS_KEY = "status";
    private static final String RESPONSE_MESSAGE_KEY = "message";
    private static final String RESPONSE_PATH_KEY = "path";

    @NonNull
    @ExceptionHandler(InvoiceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Map<String, Object> handleInvoiceNotFoundException(@NonNull final HttpServletRequest request) {
        return getResponse(
            request,
            HttpStatus.NOT_FOUND,
            "Invoice not found."
        );
    }

    @NonNull
    @ExceptionHandler(ValidationInvoiceUpdateDataFailed.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, Object> handleValidationInvoiceUpdateDataFailedException(
        @NonNull final HttpServletRequest request,
        @NonNull final ValidationInvoiceUpdateDataFailed validationInvoiceUpdateDataFailed
    ) {
        return getResponse(
            request,
            HttpStatus.BAD_REQUEST,
            validationInvoiceUpdateDataFailed.getErrors()
        );
    }

    @NonNull
    private Map<String, Object> getResponse(
        @NonNull final HttpServletRequest request,
        @NonNull final HttpStatus httpStatus,
        @NonNull final Object message
    ) {
        return Map.of(
            RESPONSE_TIMESTAMP_KEY, new Timestamp(System.currentTimeMillis()),
            RESPONSE_STATUS_KEY, httpStatus.value(),
            RESPONSE_ERRORS_KEY, httpStatus.getReasonPhrase(),
            RESPONSE_MESSAGE_KEY, message,
            RESPONSE_PATH_KEY, request.getRequestURI()
        );
    }
}
