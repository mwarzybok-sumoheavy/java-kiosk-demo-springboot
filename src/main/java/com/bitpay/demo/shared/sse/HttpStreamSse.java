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

    private final SseEmitterFacade sseEmitterFacade;

    public HttpStreamSse(@NonNull final SseEmitterFacade sseEmitterFacade) {
        this.sseEmitterFacade = sseEmitterFacade;
    }

    @GetMapping("/stream-sse")
    public SseEmitter execute() {
        return this.sseEmitterFacade.createEmitter();
    }
}
