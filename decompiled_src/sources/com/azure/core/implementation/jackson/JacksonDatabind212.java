package com.azure.core.implementation.jackson;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.std.DelegatingDeserializer;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.AccessPattern;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class JacksonDatabind212 {
    JacksonDatabind212() {
    }

    static ObjectMapper mutateXmlCoercions(ObjectMapper objectMapper) {
        objectMapper.registerModule(new SimpleModule().setDeserializerModifier(new BeanDeserializerModifier() { // from class: com.azure.core.implementation.jackson.JacksonDatabind212.1
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig deserializationConfig, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
                return String.class.isAssignableFrom(beanDescription.getBeanClass()) ? new DelegatingDeserializer(jsonDeserializer) { // from class: com.azure.core.implementation.jackson.JacksonDatabind212.1.1
                    protected JsonDeserializer<?> newDelegatingInstance(JsonDeserializer<?> jsonDeserializer2) {
                        return this;
                    }

                    public AccessPattern getNullAccessPattern() {
                        return AccessPattern.DYNAMIC;
                    }

                    public Object getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
                        return deserializationContext.getParser().getParsingContext().inArray() ? "" : super.getNullValue(deserializationContext);
                    }
                } : jsonDeserializer;
            }
        }));
        objectMapper.coercionConfigDefaults().setCoercion(CoercionInputShape.EmptyString, CoercionAction.AsNull);
        return objectMapper;
    }

    static String removePrefix(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, AnnotatedMethod annotatedMethod, String str) {
        AccessorNamingStrategy accessorNamingStrategyForPOJO = mapperConfig.getAccessorNaming().forPOJO(mapperConfig, annotatedClass);
        String strFindNameForIsGetter = accessorNamingStrategyForPOJO.findNameForIsGetter(annotatedMethod, str);
        return strFindNameForIsGetter == null ? accessorNamingStrategyForPOJO.findNameForRegularGetter(annotatedMethod, str) : strFindNameForIsGetter;
    }
}
