/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.updateinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.InvoiceNotFound;
import com.bitpay.demo.invoice.domain.InvoiceRepository;
import com.bitpay.demo.invoice.domain.InvoiceUuid;
import com.bitpay.demo.shared.logger.LogCode;
import com.bitpay.demo.shared.logger.Logger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import lombok.NonNull;

@DependencyInjection
public class UpdateInvoice {

    private final InvoiceRepository invoiceRepository;
    private final GetInvoiceWithUpdateData getInvoiceWithUpdateData;
    private final SendUpdateInvoiceNotification sendUpdateInvoiceNotification;
    private final ValidateUpdateData validateUpdateData;
    private final Logger logger;

    UpdateInvoice(
        @NonNull final InvoiceRepository invoiceRepository,
        @NonNull final GetInvoiceWithUpdateData getInvoiceWithUpdateData,
        @NonNull final SendUpdateInvoiceNotification sendUpdateInvoiceNotification,
        @NonNull final ValidateUpdateData validateUpdateData,
        @NonNull final Logger logger
    ) {
        this.invoiceRepository = invoiceRepository;
        this.getInvoiceWithUpdateData = getInvoiceWithUpdateData;
        this.sendUpdateInvoiceNotification = sendUpdateInvoiceNotification;
        this.validateUpdateData = validateUpdateData;
        this.logger = logger;
    }

    public void execute(
        @NonNull final InvoiceUuid invoiceUuid,
        @NonNull final Map<String, Object> updateData
    ) throws ReflectiveOperationException, ValidationInvoiceUpdateDataFailed, InvoiceNotFound {
        try {
            this.logger.info(
                LogCode.IPN_RECEIVED,
                "Received IPN",
                updateData
            );
            final var invoice = this.invoiceRepository.findByUuid(invoiceUuid);
            this.validateUpdateData.execute(updateData, invoice.getBitPayId());
            final var invoiceUpdate = this.getInvoiceWithUpdateData.create(updateData, invoice);
            this.logger.info(
                LogCode.IPN_VALIDATE_SUCCESS,
                "Successfully validated IPN",
                Map.of("id", invoice.getId())
            );
            invoice.update(invoiceUpdate);
            this.invoiceRepository.save(invoice);
            this.logger.info(
                LogCode.INVOICE_UPDATE_SUCCESS,
                "Successfully updated invoice",
                Map.of("id", invoice.getId())
            );
            this.sendUpdateInvoiceNotification.execute(invoice);
        } catch (final InvoiceNotFound invoiceNotFound) {
            this.logger.error(
                LogCode.INVOICE_UPDATE_FAIL,
                "Failed to update invoice",
                Map.of("uuid", invoiceUuid.value())
            );
            throw invoiceNotFound;
        } catch (final ValidationInvoiceUpdateDataFailed validationInvoiceUpdateDataFailed) {
            final LinkedList<String> stackTrace = new LinkedList<>();
            Arrays.stream(validationInvoiceUpdateDataFailed.getStackTrace()).forEach(
                stackTraceElement -> stackTrace.addLast(stackTraceElement.toString())
            );
            this.logger.error(
                LogCode.IPN_VALIDATE_FAIL,
                "Failed to validate IPN",
                Map.of(
                    "errorMessage", validationInvoiceUpdateDataFailed.getErrors(),
                    "stackTrace", stackTrace
                )
            );
        }
    }
}
