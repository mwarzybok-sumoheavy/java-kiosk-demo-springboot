/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.infrastructure;

import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;


@Configuration
class CustomErrorViewResolver implements ErrorViewResolver {

    private final BitPayProperties bitPayProperties;

    CustomErrorViewResolver(@NonNull final BitPayProperties bitPayProperties) {
        this.bitPayProperties = bitPayProperties;
    }

    @Override
    public ModelAndView resolveErrorView(
        @NonNull final HttpServletRequest request,
        @NonNull final HttpStatus status,
        @NonNull final Map<String, Object> model
    ) {
        if (!HttpStatus.NOT_FOUND.equals(status)) {
            return null;
        }

        return new ModelAndView("error/404", "design", this.bitPayProperties.getDesign());
    }
}
