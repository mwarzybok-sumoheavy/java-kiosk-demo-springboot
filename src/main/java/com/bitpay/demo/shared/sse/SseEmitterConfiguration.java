/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.sse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Configuration
class SseEmitterConfiguration {

    @Bean
    public SseEmitter sseEmitter() {
        return new SseEmitter(Long.MAX_VALUE);
    }
}
