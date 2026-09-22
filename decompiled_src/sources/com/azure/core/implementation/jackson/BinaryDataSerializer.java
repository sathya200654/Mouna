package com.azure.core.implementation.jackson;

import com.azure.core.util.BinaryData;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class BinaryDataSerializer extends JsonSerializer<BinaryData> {
    BinaryDataSerializer() {
    }

    public static SimpleModule getModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(BinaryData.class, new BinaryDataSerializer());
        return simpleModule;
    }

    public void serialize(BinaryData binaryData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (binaryData == null) {
            return;
        }
        binaryData.writeTo(new JacksonJsonWriter(jsonGenerator));
    }
}
