/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.form;

import lombok.NonNull;

public class ZipCodeValidator implements Validator {
    @Override
    public boolean execute(@NonNull final String value) {
        return value.matches("^\\d{5}(?:[-\\s]\\d{4})?$");
    }
}
