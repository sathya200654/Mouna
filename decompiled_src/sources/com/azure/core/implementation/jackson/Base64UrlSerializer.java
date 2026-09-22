package com.azure.core.implementation.jackson;

import com.azure.core.util.Base64Url;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class Base64UrlSerializer extends JsonSerializer<Base64Url> {
    Base64UrlSerializer() {
    }

    public static SimpleModule getModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Base64Url.class, new Base64UrlSerializer());
        return simpleModule;
    }

    public void serialize(Base64Url base64Url, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(base64Url.toString());
    }
}
