package com.azure.core.implementation.jackson;

import com.azure.core.util.CoreUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.time.Duration;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class DurationSerializer extends JsonSerializer<Duration> {
    DurationSerializer() {
    }

    public static SimpleModule getModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Duration.class, new DurationSerializer());
        return simpleModule;
    }

    public void serialize(Duration duration, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(toString(duration));
    }

    public static String toString(Duration duration) {
        return CoreUtils.durationToStringWithDays(duration);
    }
}
