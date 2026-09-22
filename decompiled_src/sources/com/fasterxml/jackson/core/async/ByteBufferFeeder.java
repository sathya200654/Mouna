package com.fasterxml.jackson.core.async;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface ByteBufferFeeder extends NonBlockingInputFeeder {
    void feedInput(ByteBuffer byteBuffer) throws IOException;
}
