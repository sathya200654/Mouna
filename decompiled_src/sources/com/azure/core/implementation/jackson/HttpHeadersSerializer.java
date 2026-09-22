package com.azure.core.implementation.jackson;

import com.azure.core.http.HttpHeaders;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class HttpHeadersSerializer extends JsonSerializer<HttpHeaders> {
    HttpHeadersSerializer() {
    }

    public static SimpleModule getModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(HttpHeaders.class, new HttpHeadersSerializer());
        return simpleModule;
    }

    public void serialize(HttpHeaders httpHeaders, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(httpHeaders.toMap());
    }
}
