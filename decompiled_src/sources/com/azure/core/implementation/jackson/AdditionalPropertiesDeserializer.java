package com.azure.core.implementation.jackson;

import com.azure.core.annotation.JsonFlatten;
import com.azure.core.implementation.TypeUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class AdditionalPropertiesDeserializer extends StdDeserializer<Object> implements ResolvableDeserializer {
    private static final long serialVersionUID = 700052863615540646L;
    private final JsonDeserializer<?> defaultDeserializer;
    private final ObjectMapper mapper;

    protected AdditionalPropertiesDeserializer(Class<?> cls, JsonDeserializer<?> jsonDeserializer, ObjectMapper objectMapper) {
        super(cls);
        this.defaultDeserializer = jsonDeserializer;
        this.mapper = objectMapper;
    }

    public static SimpleModule getModule(final ObjectMapper objectMapper) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.setDeserializerModifier(new BeanDeserializerModifier() { // from class: com.azure.core.implementation.jackson.AdditionalPropertiesDeserializer.1
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig deserializationConfig, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
                JsonProperty annotation;
                Iterator<Class<?>> it = TypeUtil.getAllClasses(beanDescription.getBeanClass()).iterator();
                while (it.hasNext()) {
                    for (Field field : it.next().getDeclaredFields()) {
                        if ("additionalProperties".equalsIgnoreCase(field.getName()) && (annotation = field.getAnnotation(JsonProperty.class)) != null && annotation.value().isEmpty()) {
                            return new AdditionalPropertiesDeserializer(beanDescription.getBeanClass(), jsonDeserializer, objectMapper);
                        }
                    }
                }
                return jsonDeserializer;
            }
        });
        return simpleModule;
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectNode tree = this.mapper.readTree(jsonParser);
        ObjectNode objectNodeDeepCopy = tree.deepCopy();
        Class clsHandledType = this.defaultDeserializer.handledType();
        boolean z = clsHandledType.getAnnotation(JsonFlatten.class) != null;
        Iterator<Class<?>> it = TypeUtil.getAllClasses(clsHandledType).iterator();
        while (it.hasNext()) {
            for (Field field : it.next().getDeclaredFields()) {
                if (!field.isSynthetic()) {
                    String strValue = field.getAnnotation(JsonProperty.class).value();
                    if (z) {
                        strValue = jsonFlattenSplit(strValue);
                    }
                    if (!strValue.isEmpty() && objectNodeDeepCopy.has(strValue)) {
                        objectNodeDeepCopy.remove(strValue);
                    }
                }
            }
        }
        tree.set("additionalProperties", objectNodeDeepCopy);
        JsonParser jsonParserCreateParser = new JsonFactory().createParser(tree.toString());
        jsonParserCreateParser.nextToken();
        return this.defaultDeserializer.deserialize(jsonParserCreateParser, deserializationContext);
    }

    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        this.defaultDeserializer.resolve(deserializationContext);
    }

    private static String jsonFlattenSplit(String str) {
        int iIndexOfSplit = indexOfSplit(str);
        return iIndexOfSplit == -1 ? str : str.substring(0, iIndexOfSplit);
    }

    private static int indexOfSplit(String str) {
        int i;
        int iIndexOf = 0;
        do {
            iIndexOf = str.indexOf(46, iIndexOf);
            if (iIndexOf == -1) {
                return -1;
            }
            i = iIndexOf - 2;
            if (i < 0 || str.charAt(iIndexOf - 1) != '\\') {
                break;
            }
        } while (str.charAt(i) == '\\');
        return iIndexOf;
    }
}
