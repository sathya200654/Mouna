package com.azure.core.implementation.jackson;

import com.azure.core.implementation.TypeUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class AdditionalPropertiesSerializer extends StdSerializer<Object> implements ResolvableSerializer {
    private static final long serialVersionUID = -3458779491516161716L;
    private final JsonSerializer<?> defaultSerializer;
    private final ObjectMapper mapper;

    protected AdditionalPropertiesSerializer(Class<?> cls, JsonSerializer<?> jsonSerializer, ObjectMapper objectMapper) {
        super(cls, false);
        this.defaultSerializer = jsonSerializer;
        this.mapper = objectMapper;
    }

    public static SimpleModule getModule(final ObjectMapper objectMapper) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.setSerializerModifier(new BeanSerializerModifier() { // from class: com.azure.core.implementation.jackson.AdditionalPropertiesSerializer.1
            public JsonSerializer<?> modifySerializer(SerializationConfig serializationConfig, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
                JsonProperty annotation;
                for (Class<?> cls : TypeUtil.getAllClasses(beanDescription.getBeanClass())) {
                    if (!cls.isAssignableFrom(Object.class)) {
                        for (Field field : cls.getDeclaredFields()) {
                            if ("additionalProperties".equalsIgnoreCase(field.getName()) && (annotation = field.getAnnotation(JsonProperty.class)) != null && annotation.value().isEmpty()) {
                                return new AdditionalPropertiesSerializer(beanDescription.getBeanClass(), jsonSerializer, objectMapper);
                            }
                        }
                    }
                }
                return jsonSerializer;
            }
        });
        return simpleModule;
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ObjectNode objectNodeValueToTree = this.mapper.valueToTree(obj);
        ObjectNode objectNodeDeepCopy = objectNodeValueToTree.deepCopy();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        linkedBlockingQueue.add(objectNodeValueToTree);
        linkedBlockingQueue2.add(objectNodeDeepCopy);
        while (!linkedBlockingQueue.isEmpty()) {
            ObjectNode objectNode = (ObjectNode) linkedBlockingQueue.poll();
            ObjectNode objectNode2 = (ObjectNode) linkedBlockingQueue2.poll();
            Iterator itFields = objectNode.fields();
            while (itFields.hasNext()) {
                Map.Entry entry = (Map.Entry) itFields.next();
                String str = (String) entry.getKey();
                ObjectNode objectNode3 = objectNode2.get(str);
                if ("additionalProperties".equals(str)) {
                    objectNode2.remove(str);
                    Iterator itFields2 = objectNode3.fields();
                    while (itFields2.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) itFields2.next();
                        objectNode2.set((String) entry2.getKey(), (JsonNode) entry2.getValue());
                    }
                }
                if (entry.getValue() instanceof ObjectNode) {
                    linkedBlockingQueue.add((ObjectNode) entry.getValue());
                    linkedBlockingQueue2.add(objectNode3);
                } else if ((entry.getValue() instanceof ArrayNode) && ((JsonNode) entry.getValue()).size() > 0 && (((JsonNode) entry.getValue()).get(0) instanceof ObjectNode)) {
                    Iterator itElements = ((JsonNode) entry.getValue()).elements();
                    Iterator itElements2 = objectNode3.elements();
                    while (itElements.hasNext()) {
                        linkedBlockingQueue.add((ObjectNode) itElements.next());
                        linkedBlockingQueue2.add((ObjectNode) itElements2.next());
                    }
                }
            }
        }
        jsonGenerator.writeTree(objectNodeDeepCopy);
    }

    public void resolve(SerializerProvider serializerProvider) throws JsonMappingException {
        this.defaultSerializer.resolve(serializerProvider);
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        serialize(obj, jsonGenerator, serializerProvider);
    }
}
