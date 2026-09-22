package com.azure.core.implementation.jackson;

import com.azure.core.util.DateTimeRfc1123;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class DateTimeRfc1123Serializer extends JsonSerializer<DateTimeRfc1123> {
    DateTimeRfc1123Serializer() {
    }

    public static SimpleModule getModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(DateTimeRfc1123.class, new DateTimeRfc1123Serializer());
        return simpleModule;
    }

    public void serialize(DateTimeRfc1123 dateTimeRfc1123, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (serializerProvider.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.writeNumber(dateTimeRfc1123.getDateTime().toInstant().toEpochMilli());
        } else {
            jsonGenerator.writeString(dateTimeRfc1123.toString());
        }
    }
}
