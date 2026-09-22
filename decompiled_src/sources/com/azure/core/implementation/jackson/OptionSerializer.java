package com.azure.core.implementation.jackson;

import com.azure.core.implementation.Option;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.ReferenceTypeSerializer;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class OptionSerializer extends ReferenceTypeSerializer<Option<?>> {
    private static final long serialVersionUID = 1;

    OptionSerializer(ReferenceType referenceType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(referenceType, z, typeSerializer, jsonSerializer);
    }

    private OptionSerializer(OptionSerializer optionSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer nameTransformer, Object obj, boolean z) {
        super(optionSerializer, beanProperty, typeSerializer, jsonSerializer, nameTransformer, obj, z);
    }

    protected ReferenceTypeSerializer<Option<?>> withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer nameTransformer) {
        return new OptionSerializer(this, beanProperty, typeSerializer, jsonSerializer, nameTransformer, ((ReferenceTypeSerializer) this)._suppressableValue, ((ReferenceTypeSerializer) this)._suppressNulls);
    }

    public ReferenceTypeSerializer<Option<?>> withContentInclusion(Object obj, boolean z) {
        return new OptionSerializer(this, ((ReferenceTypeSerializer) this)._property, ((ReferenceTypeSerializer) this)._valueTypeSerializer, ((ReferenceTypeSerializer) this)._valueSerializer, ((ReferenceTypeSerializer) this)._unwrapper, obj, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean _isValuePresent(Option<?> option) {
        return option.isInitialized();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object _getReferenced(Option<?> option) {
        return option.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object _getReferencedIfPresent(Option<?> option) {
        if (option.isInitialized()) {
            return option.getValue();
        }
        return null;
    }
}
