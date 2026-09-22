package com.azure.core.implementation.jackson;

import com.azure.core.models.ResponseError;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class ResponseErrorDeserializer extends StdDeserializer<Object> {
    public static final String ERROR_PROPERTY_KEY = "error";
    private static final long serialVersionUID = 1;
    private final ObjectMapper mapper;
    private static final Pattern CODE_PATTERN = Pattern.compile("\"code\"", 2);
    private static final Pattern MESSAGE_PATTERN = Pattern.compile("\"message\"", 2);
    private static final Pattern TARGET_PATTERN = Pattern.compile("\"target\"", 2);
    private static final Pattern DETAILS_PATTERN = Pattern.compile("\"details\"", 2);

    private ResponseErrorDeserializer(Class<?> cls, ObjectMapper objectMapper) {
        super(cls);
        this.mapper = objectMapper;
    }

    public static SimpleModule getModule(final ObjectMapper objectMapper) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.setDeserializerModifier(new BeanDeserializerModifier() { // from class: com.azure.core.implementation.jackson.ResponseErrorDeserializer.1
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig deserializationConfig, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
                return ResponseError.class.isAssignableFrom(beanDescription.getBeanClass()) ? new ResponseErrorDeserializer(beanDescription.getBeanClass(), objectMapper) : jsonDeserializer;
            }
        });
        return simpleModule;
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        jsonParser.setCodec(this.mapper);
        JsonNode valueAsTree = jsonParser.readValueAsTree();
        if (valueAsTree == null) {
            return null;
        }
        if (valueAsTree.get("error") != null) {
            valueAsTree = valueAsTree.get("error");
        }
        JsonParser jsonParserCreateParser = new JsonFactory().createParser(DETAILS_PATTERN.matcher(TARGET_PATTERN.matcher(MESSAGE_PATTERN.matcher(CODE_PATTERN.matcher(valueAsTree.toString()).replaceFirst("\"code\"")).replaceFirst("\"message\"")).replaceFirst("\"target\"")).replaceFirst("\"details\""));
        jsonParserCreateParser.setCodec(this.mapper);
        return jsonParserCreateParser.readValueAs(handledType());
    }
}
