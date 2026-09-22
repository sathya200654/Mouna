package com.azure.core.implementation.jackson;

import com.azure.core.implementation.ReflectionSerializable;
import com.azure.core.implementation.ReflectionUtils;
import com.azure.core.implementation.ReflectiveInvoker;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class JsonSerializableDeserializer extends JsonDeserializer<JsonSerializable<?>> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) JsonSerializableDeserializer.class);
    private final Class<? extends JsonSerializable<?>> jsonSerializableType;
    private final ReflectiveInvoker readJson;

    public static Module getModule() {
        return new SimpleModule().setDeserializerModifier(new BeanDeserializerModifier() { // from class: com.azure.core.implementation.jackson.JsonSerializableDeserializer.1
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig deserializationConfig, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
                return ReflectionSerializable.supportsJsonSerializable(beanDescription.getBeanClass()) ? new JsonSerializableDeserializer(beanDescription.getBeanClass()) : jsonDeserializer;
            }
        });
    }

    JsonSerializableDeserializer(Class<? extends JsonSerializable<?>> cls) {
        this.jsonSerializableType = cls;
        try {
            this.readJson = ReflectionUtils.getMethodInvoker(cls, cls.getDeclaredMethod("fromJson", JsonReader.class));
        } catch (Exception e) {
            throw LOGGER.logExceptionAsError(new IllegalStateException(e));
        }
    }

    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public JsonSerializable<?> m1206deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        try {
            return this.jsonSerializableType.cast(this.readJson.invokeStatic(AzureJsonUtils.createReader(jsonParser)));
        } catch (Exception e) {
            throw ((IOException) LOGGER.logThrowableAsError(e instanceof IOException ? (IOException) e : new IOException(e)));
        }
    }
}
