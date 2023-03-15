/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.gson;

import com.bitpay.demo.shared.FieldExcludedFromSerialization;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class ExcludeFields implements ExclusionStrategy {


    @Override
    public boolean shouldSkipField(final FieldAttributes field) {
        return field.getAnnotation(FieldExcludedFromSerialization.class) != null;
    }

    @Override
    public boolean shouldSkipClass(final Class<?> clazz) {
        return false;
    }
}
