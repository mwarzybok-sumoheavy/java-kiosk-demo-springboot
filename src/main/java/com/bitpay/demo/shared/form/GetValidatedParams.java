/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.form;

import java.util.Map;
import lombok.NonNull;

public interface GetValidatedParams {
    @NonNull
    Map<String, Object> execute(
        @NonNull Map<String, Object> requestParameters
    ) throws MissingRequiredField;
}
