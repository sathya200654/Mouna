package com.azure.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface JsonProvider {
    JsonReader createReader(InputStream inputStream, JsonOptions jsonOptions) throws IOException;

    JsonReader createReader(Reader reader, JsonOptions jsonOptions) throws IOException;

    JsonReader createReader(String str, JsonOptions jsonOptions) throws IOException;

    JsonReader createReader(byte[] bArr, JsonOptions jsonOptions) throws IOException;

    JsonWriter createWriter(OutputStream outputStream, JsonOptions jsonOptions) throws IOException;

    JsonWriter createWriter(Writer writer, JsonOptions jsonOptions) throws IOException;
}
