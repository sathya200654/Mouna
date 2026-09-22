package com.azure.core.implementation.jackson;

import com.azure.core.implementation.ReflectionSerializable;
import com.azure.json.JsonSerializable;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class JsonSerializableSerializer extends JsonSerializer<JsonSerializable> {
    JsonSerializableSerializer() {
    }

    public static Module getModule() {
        return new SimpleModule().setSerializerModifier(new BeanSerializerModifier() { // from class: com.azure.core.implementation.jackson.JsonSerializableSerializer.1
            public BeanSerializerBuilder updateBuilder(SerializationConfig serializationConfig, BeanDescription beanDescription, BeanSerializerBuilder beanSerializerBuilder) {
                return ReflectionSerializable.supportsJsonSerializable(beanDescription.getBeanClass()) ? new BeanSerializerBuilder(beanDescription) { // from class: com.azure.core.implementation.jackson.JsonSerializableSerializer.1.1
                    public JsonSerializer<?> build() {
                        return new JsonSerializableSerializer();
                    }
                } : beanSerializerBuilder;
            }

            public JsonSerializer<?> modifySerializer(SerializationConfig serializationConfig, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
                return ReflectionSerializable.supportsJsonSerializable(beanDescription.getBeanClass()) ? new JsonSerializableSerializer() : jsonSerializer;
            }
        });
    }

    public void serialize(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        new JacksonJsonWriter(jsonGenerator).writeJson(jsonSerializable);
    }

    public Class<JsonSerializable> handledType() {
        return JsonSerializable.class;
    }
}
