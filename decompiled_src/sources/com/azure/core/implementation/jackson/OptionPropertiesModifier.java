package com.azure.core.implementation.jackson;

import com.azure.core.implementation.Option;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class OptionPropertiesModifier extends BeanSerializerModifier {
    OptionPropertiesModifier() {
    }

    public List<BeanPropertyWriter> changeProperties(SerializationConfig serializationConfig, BeanDescription beanDescription, List<BeanPropertyWriter> list) {
        for (int i = 0; i < list.size(); i++) {
            BeanPropertyWriter beanPropertyWriter = list.get(i);
            if (beanPropertyWriter.getType().isTypeOrSubTypeOf(Option.class)) {
                list.set(i, new OptionBeanPropertyWriter(beanPropertyWriter));
            }
        }
        return list;
    }
}
