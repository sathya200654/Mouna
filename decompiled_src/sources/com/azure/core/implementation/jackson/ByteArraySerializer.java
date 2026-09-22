package com.azure.core.implementation.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class ByteArraySerializer extends JsonSerializer<Byte[]> {
    ByteArraySerializer() {
    }

    public static SimpleModule getModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Byte[].class, new ByteArraySerializer());
        return simpleModule;
    }

    public void serialize(Byte[] bArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        jsonGenerator.writeBinary(bArr2);
    }
}
