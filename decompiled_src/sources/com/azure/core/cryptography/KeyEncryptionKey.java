package com.azure.core.cryptography;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface KeyEncryptionKey {
    String getKeyId();

    byte[] unwrapKey(String str, byte[] bArr);

    byte[] wrapKey(String str, byte[] bArr);
}
