package com.azure.core.cryptography;

import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface AsyncKeyEncryptionKeyResolver {
    Mono<? extends AsyncKeyEncryptionKey> buildAsyncKeyEncryptionKey(String str);
}
