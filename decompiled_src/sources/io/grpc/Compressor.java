package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface Compressor {
    OutputStream compress(OutputStream outputStream) throws IOException;

    String getMessageEncoding();
}
