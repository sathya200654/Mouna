package com.azure.core.util;

import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface AsyncCloseable {
    Mono<Void> closeAsync();
}
