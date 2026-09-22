package com.fasterxml.jackson.core.async;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface ByteArrayFeeder extends NonBlockingInputFeeder {
    void feedInput(byte[] bArr, int i, int i2) throws IOException;
}
