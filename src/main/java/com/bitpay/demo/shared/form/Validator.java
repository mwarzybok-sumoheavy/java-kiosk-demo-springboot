/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.form;

import lombok.NonNull;

public interface Validator {
    boolean execute(@NonNull String value);
}
