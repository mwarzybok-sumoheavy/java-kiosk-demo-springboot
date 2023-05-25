/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.form;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import com.bitpay.demo.shared.bitpayproperties.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

@DependencyInjection
@ConditionalOnExpression("'${bitpay.design.mode:standard}'.equals('standard')")
public class GetValidatedPosParams implements GetValidatedParams {

    private final BitPayProperties bitPayProperties;

    public GetValidatedPosParams(@NonNull final BitPayProperties bitPayProperties) {
        this.bitPayProperties = bitPayProperties;
    }

    @NonNull
    @Override
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
