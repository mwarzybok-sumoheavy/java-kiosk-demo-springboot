/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.updateinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.invoice.domain.BitPayId;
import com.bitpay.demo.invoice.domain.InvoiceNotFound;
import com.bitpay.demo.invoice.domain.InvoiceRepository;
import com.bitpay.demo.invoice.domain.InvoiceUuid;
import com.bitpay.demo.shared.logger.LogCode;
import com.bitpay.demo.shared.logger.Logger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
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
            final var invoiceUpdate = this.getInvoiceWithUpdateData.execute(updateData, invoice);
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
            sendUpdateInvoiceEventStream(updateData, invoice);
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
            throw validationInvoiceUpdateDataFailed;
        }
    }

    private void sendUpdateInvoiceEventStream(
        @NonNull Map<String, Object> updateData,
        @NonNull com.bitpay.demo.invoice.domain.Invoice invoice
    ) {
        var eventName = (String) updateData.get("eventName");
        this.sendUpdateInvoiceNotification.execute(
            invoice,
            this.getEventMessageTypeFromEventName(eventName),
            this.getEventMessageFromEventName(invoice.getBitPayId(), eventName)
        );
    }

    private String getEventMessageFromEventName(BitPayId bitPayId, String eventName) {
        if (Objects.isNull(eventName)) {
            return null;
        }

        return switch (eventName) {
            case ("invoice_manuallyNotified"), ("invoice_refundComplete") -> null;
            case ("invoice_paidInFull") -> String.format("Invoice %s has been paid in full.", bitPayId.value());
            case ("invoice_expired") -> String.format("Invoice %s has expired.", bitPayId.value());
            case ("invoice_confirmed") -> String.format("Invoice %s has been confirmed.", bitPayId.value());
            case ("invoice_completed") -> String.format("Invoice %s is complete.", bitPayId.value());
            case ("invoice_failedToConfirm") -> String.format("Invoice %s has failed to confirm.", bitPayId.value());
            case ("invoice_declined") -> String.format("Invoice %s has been declined..", bitPayId.value());
            default -> null;
        };
    }

    private UpdateInvoiceEventType getEventMessageTypeFromEventName(String eventName) {
        if (Objects.isNull(eventName)) {
            return null;
        }

        return switch (eventName) {
            case ("invoice_manuallyNotified"), ("invoice_refundComplete") -> null;
            case ("invoice_paidInFull"), ("invoice_confirmed"), ("invoice_completed") -> UpdateInvoiceEventType.SUCCESS;
            case ("invoice_expired"), ("invoice_failedToConfirm"), ("invoice_declined") -> UpdateInvoiceEventType.ERROR;
            default -> null;
        };
    }
}
