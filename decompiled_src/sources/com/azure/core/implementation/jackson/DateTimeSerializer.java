package com.azure.core.implementation.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class DateTimeSerializer extends JsonSerializer<OffsetDateTime> {
    private static final SimpleModule MODULE = new SimpleModule().addSerializer(OffsetDateTime.class, new DateTimeSerializer());

    DateTimeSerializer() {
    }

    public static SimpleModule getModule() {
        return MODULE;
    }

    public void serialize(OffsetDateTime offsetDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (serializerProvider.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.writeNumber(offsetDateTime.toInstant().toEpochMilli());
        } else {
            jsonGenerator.writeString(toString(offsetDateTime));
        }
    }

    public static String toString(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        String str = DateTimeFormatter.ISO_INSTANT.format(offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC));
        return str.startsWith("+") ? str.substring(1) : str;
    }
}
