package com.azure.core.cryptography;

import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface AsyncKeyEncryptionKey {
    Mono<String> getKeyId();

    Mono<byte[]> unwrapKey(String str, byte[] bArr);

    Mono<byte[]> wrapKey(String str, byte[] bArr);
}
