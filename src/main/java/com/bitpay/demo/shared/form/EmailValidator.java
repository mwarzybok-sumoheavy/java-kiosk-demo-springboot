/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.form;

import lombok.NonNull;

public class EmailValidator implements Validator {
    @Override
    public boolean execute(@NonNull final String value) {
        return value.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
}
