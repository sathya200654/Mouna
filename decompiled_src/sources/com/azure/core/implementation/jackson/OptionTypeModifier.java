package com.azure.core.implementation.jackson;

import com.azure.core.implementation.Option;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.type.TypeModifier;
import java.io.Serializable;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class OptionTypeModifier extends TypeModifier implements Serializable {
    private static final long serialVersionUID = 1;

    OptionTypeModifier() {
    }

    public JavaType modifyType(JavaType javaType, Type type, TypeBindings typeBindings, TypeFactory typeFactory) {
        return (javaType.isReferenceType() || javaType.isContainerType() || javaType.getRawClass() != Option.class) ? javaType : ReferenceType.upgradeFrom(javaType, javaType.containedTypeOrUnknown(0));
    }
}
