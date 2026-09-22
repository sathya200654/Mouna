package com.azure.core.implementation.jackson;

import com.azure.core.implementation.Option;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.type.ReferenceType;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class OptionSerializerProvider extends Serializers.Base implements Serializable {
    private static final long serialVersionUID = 1;

    OptionSerializerProvider() {
    }

    public JsonSerializer<?> findReferenceSerializer(SerializationConfig serializationConfig, ReferenceType referenceType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        if (Option.class.isAssignableFrom(referenceType.getRawClass())) {
            return new OptionSerializer(referenceType, typeSerializer == null && serializationConfig.isEnabled(MapperFeature.USE_STATIC_TYPING), typeSerializer, jsonSerializer);
        }
        return null;
    }
}
