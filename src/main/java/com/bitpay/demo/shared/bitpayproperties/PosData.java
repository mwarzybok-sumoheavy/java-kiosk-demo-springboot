/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.bitpayproperties;

import java.util.ArrayList;
import java.util.Collection;
import lombok.NonNull;

public class PosData {
    private Collection<Field> fields = new ArrayList<>();

    public Collection<Field> getFields() {
        return this.fields;
    }

    void setFields(@NonNull final Collection<Field> fields) {
        final var modifiableFieldCollection = new ArrayList<>(fields);
        if (hasPriceField(modifiableFieldCollection)) {
            modifiableFieldCollection.add(Field.createPriceField());
        }

        this.fields = modifiableFieldCollection;
    }

    private static boolean hasPriceField(@NonNull final Collection<Field> fields) {
        return fields.stream().noneMatch(field -> "price".equals(field.getName()));
    }
}
