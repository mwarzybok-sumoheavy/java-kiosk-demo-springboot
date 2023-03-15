/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.sse;

import com.bitpay.demo.DependencyInjection;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import lombok.NonNull;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@DependencyInjection
public class SseEmitterFacade {
    private final Collection<SseEmitter> emitters = new HashSet<>();

    @NonNull
    public SseEmitter createEmitter() {
        final SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);
        this.emitters.add(sseEmitter);
        sseEmitter.onCompletion(() -> this.emitters.remove(sseEmitter));
        sseEmitter.onTimeout(() -> this.emitters.remove(sseEmitter));
        sseEmitter.onError((ex) -> this.emitters.remove(sseEmitter));

        return sseEmitter;
    }

    public void sendAll(@NonNull final Collection<SseEmitter.SseEventBuilder> events) {
        Set.copyOf(this.emitters).forEach(
            emitter -> {
                events.forEach(event -> {
                    try {
                        emitter.send(event);
                    } catch (final IOException | IllegalStateException e) {
                        //ignore;
                    }
                });
                emitter.complete();
            }
        );
    }
}
