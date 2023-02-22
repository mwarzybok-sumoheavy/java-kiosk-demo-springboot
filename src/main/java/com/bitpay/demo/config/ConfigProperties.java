/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.config;

import com.bitpay.sdk.Client;
import com.bitpay.sdk.Environment;
import com.bitpay.sdk.PosToken;
import com.bitpay.sdk.exceptions.BitPayException;
import com.bitpay.sdk.util.BitPayLogger;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {

    @Bean
    @ConfigurationProperties(prefix = "bitpay")
    public BitPayProperties bitpay() {
        return new BitPayProperties();
    }

    @Bean
    public Client bitpayClient(@NonNull final BitPayProperties bitPayProperties) throws BitPayException {
        final Client client = new Client(new PosToken(bitPayProperties.getToken()), Environment.TEST);
        client.setLoggerLevel(BitPayLogger.DEBUG);

        return client;
    }
}
