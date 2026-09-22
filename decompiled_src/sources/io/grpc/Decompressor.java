package io.grpc;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface Decompressor {
    InputStream decompress(InputStream inputStream) throws IOException;

    String getMessageEncoding();
}
