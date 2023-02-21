/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared;

import lombok.NonNull;

public interface ObjectToStringConverter {

    @NonNull
    String execute(@NonNull Object object);
}
