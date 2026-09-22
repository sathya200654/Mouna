package com.azure.core.implementation.jackson;

import com.azure.core.implementation.Option;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class OptionBeanPropertyWriter extends BeanPropertyWriter {
    private static final long serialVersionUID = 1;

    OptionBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter) {
        super(beanPropertyWriter);
    }

    private OptionBeanPropertyWriter(OptionBeanPropertyWriter optionBeanPropertyWriter, PropertyName propertyName) {
        super(optionBeanPropertyWriter, propertyName);
    }

    protected BeanPropertyWriter _new(PropertyName propertyName) {
        return new OptionBeanPropertyWriter(this, propertyName);
    }

    public BeanPropertyWriter unwrappingWriter(NameTransformer nameTransformer) {
        return new UnwrappingOptionBeanPropertyWriter(this, nameTransformer);
    }

    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Object obj2;
        if (((BeanPropertyWriter) this)._nullSerializer == null && ((obj2 = super.get(obj)) == null || obj2.equals(Option.uninitialized()))) {
            return;
        }
        super.serializeAsField(obj, jsonGenerator, serializerProvider);
    }

    private static final class UnwrappingOptionBeanPropertyWriter extends UnwrappingBeanPropertyWriter {
        private static final long serialVersionUID = 1;

        UnwrappingOptionBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, NameTransformer nameTransformer) {
            super(beanPropertyWriter, nameTransformer);
        }

        private UnwrappingOptionBeanPropertyWriter(UnwrappingOptionBeanPropertyWriter unwrappingOptionBeanPropertyWriter, NameTransformer nameTransformer, SerializedString serializedString) {
            super(unwrappingOptionBeanPropertyWriter, nameTransformer, serializedString);
        }

        protected UnwrappingBeanPropertyWriter _new(NameTransformer nameTransformer, SerializedString serializedString) {
            return new UnwrappingOptionBeanPropertyWriter(this, nameTransformer, serializedString);
        }

        public void serializeAsField(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
            Object obj2;
            if (((UnwrappingBeanPropertyWriter) this)._nullSerializer == null && ((obj2 = super.get(obj)) == null || obj2.equals(Option.uninitialized()))) {
                return;
            }
            super.serializeAsField(obj, jsonGenerator, serializerProvider);
        }
    }
}
