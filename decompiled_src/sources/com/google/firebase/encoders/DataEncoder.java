package com.google.firebase.encoders;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface DataEncoder {
    String encode(Object obj);

    void encode(Object obj, Writer writer) throws IOException;
}
