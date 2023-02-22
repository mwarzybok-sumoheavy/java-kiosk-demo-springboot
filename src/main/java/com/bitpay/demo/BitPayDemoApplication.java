/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = @ComponentScan.Filter(
    type = FilterType.ANNOTATION,
    classes = DependencyInjection.class)
)
public class BitPayDemoApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BitPayDemoApplication.class, args);
    }

}
