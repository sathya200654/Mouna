package com.azure.json.implementation;

import com.azure.json.JsonOptions;
import com.azure.json.JsonProvider;
import com.azure.json.JsonReader;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DefaultJsonProvider implements JsonProvider {
    private static final String JSON_READER_EXCEPTION = "Both 'json' and 'options' must be passed as non-null to create an instance of JsonReader.";
    private static final String JSON_WRITER_EXCEPTION = "Both 'json' and 'options' must be passed as non-null to create an instance of JsonWriter.";

    @Override // com.azure.json.JsonProvider
    public JsonReader createReader(byte[] bArr, JsonOptions jsonOptions) throws IOException {
        validate(bArr, jsonOptions, JSON_READER_EXCEPTION);
        return DefaultJsonReader.fromBytes(bArr, jsonOptions);
    }

    @Override // com.azure.json.JsonProvider
    public JsonReader createReader(String str, JsonOptions jsonOptions) throws IOException {
        validate(str, jsonOptions, JSON_READER_EXCEPTION);
        return DefaultJsonReader.fromString(str, jsonOptions);
    }

    @Override // com.azure.json.JsonProvider
    public JsonReader createReader(InputStream inputStream, JsonOptions jsonOptions) throws IOException {
        validate(inputStream, jsonOptions, JSON_READER_EXCEPTION);
        return DefaultJsonReader.fromStream(inputStream, jsonOptions);
    }

    @Override // com.azure.json.JsonProvider
    public JsonReader createReader(Reader reader, JsonOptions jsonOptions) throws IOException {
        validate(reader, jsonOptions, JSON_READER_EXCEPTION);
        return DefaultJsonReader.fromReader(reader, jsonOptions);
    }

    @Override // com.azure.json.JsonProvider
    public JsonWriter createWriter(OutputStream outputStream, JsonOptions jsonOptions) throws IOException {
        validate(outputStream, jsonOptions, JSON_WRITER_EXCEPTION);
        return DefaultJsonWriter.toStream(outputStream, jsonOptions);
    }

    @Override // com.azure.json.JsonProvider
    public JsonWriter createWriter(Writer writer, JsonOptions jsonOptions) throws IOException {
        validate(writer, jsonOptions, JSON_WRITER_EXCEPTION);
        return DefaultJsonWriter.toWriter(writer, jsonOptions);
    }

    private static void validate(Object obj, JsonOptions jsonOptions, String str) {
        if (obj == null || jsonOptions == null) {
            throw new NullPointerException(str);
        }
    }
}
