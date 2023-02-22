/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.infrastructure;

import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BitPayPropertiesConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "bitpay")
    public BitPayProperties bitpay() {
        return new BitPayProperties();
    }
}
