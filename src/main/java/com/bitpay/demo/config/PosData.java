/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.config;

import java.util.ArrayList;
import java.util.Collection;

public class PosData {
    private Collection<Field> fields = new ArrayList<>();

    public Collection<Field> getFields() {
        return this.fields;
    }

    public void setFields(final Collection<Field> fields) {
        this.fields = fields;
    }
}
