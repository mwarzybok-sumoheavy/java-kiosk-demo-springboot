/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.form;

import com.bitpay.demo.DependencyInjection;
import java.text.DecimalFormat;

@DependencyInjection
public class FormUtils {
    public static String format(final double value) {
        final DecimalFormat format = new DecimalFormat("0.#");
        return format.format(value);
    }
}
