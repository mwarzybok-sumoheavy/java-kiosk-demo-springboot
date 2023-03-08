/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.sse;

import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class HttpStreamSse {

    private final SseEmitter sseEmitter;

    public HttpStreamSse(@NonNull final SseEmitter sseEmitter) {
        this.sseEmitter = sseEmitter;
    }

    @GetMapping("/stream-sse")
    public SseEmitter execute() {
        return this.sseEmitter;
    }
}
