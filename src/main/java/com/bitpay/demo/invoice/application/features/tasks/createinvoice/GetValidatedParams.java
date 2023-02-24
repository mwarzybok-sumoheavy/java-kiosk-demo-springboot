/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import com.bitpay.demo.shared.bitpayproperties.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.NonNull;

@DependencyInjection
class GetValidatedParams {

    private final BitPayProperties bitPayProperties;

    GetValidatedParams(@NonNull final BitPayProperties bitPayProperties) {
        this.bitPayProperties = bitPayProperties;
    }

    @NonNull
    public Map<String, Object> execute(
        @NonNull final Map<String, Object> requestParameters
    ) throws MissingRequiredField {
        final var validatedParams = new HashMap<String, Object>();
        this.bitPayProperties.getDesign().getPosData().getFields().forEach(
            field -> {
                final var value = requestParameters.getOrDefault(field.getName(), null);
                if (isMissingRequiredField(field, value)) {
                    throw new MissingRequiredField(field);
                }

                if (Objects.nonNull(value)) {
                    validatedParams.put(field.getName(), value);
                }
            }
        );

        return validatedParams;
    }

    private boolean isMissingRequiredField(
        @NonNull final Field field,
        @Nullable final Object value
    ) {
        return field.isRequired() && Objects.isNull(value);
    }
}
