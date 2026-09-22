package com.azure.core.implementation.jackson;

import com.azure.core.annotation.JsonFlatten;
import com.azure.core.implementation.TypeUtil;
import com.azure.core.util.CoreUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class FlatteningDeserializer extends StdDeserializer<Object> implements ResolvableDeserializer {
    private static final Pattern IS_FLATTENED_PATTERN = Pattern.compile(".+[^\\\\]\\..+");
    private static final Pattern SPLIT_KEY_PATTERN = Pattern.compile("((?<!\\\\))\\.");
    private static final long serialVersionUID = -2133095337545715498L;
    private final BeanDescription beanDescription;
    private final boolean classHasJsonFlatten;
    private final JsonDeserializer<?> defaultDeserializer;
    private final ObjectMapper mapper;

    protected FlatteningDeserializer(BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer, ObjectMapper objectMapper) {
        super(beanDescription.getBeanClass());
        this.beanDescription = beanDescription;
        this.defaultDeserializer = jsonDeserializer;
        this.mapper = objectMapper;
        this.classHasJsonFlatten = beanDescription.getClassAnnotations().has(JsonFlatten.class);
    }

    /* JADX INFO: renamed from: com.azure.core.implementation.jackson.FlatteningDeserializer$1, reason: invalid class name */
    class AnonymousClass1 extends BeanDeserializerModifier {
        final /* synthetic */ ObjectMapper val$mapper;

        AnonymousClass1(ObjectMapper objectMapper) {
            this.val$mapper = objectMapper;
        }

        public JsonDeserializer<?> modifyDeserializer(DeserializationConfig deserializationConfig, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
            return (beanDescription.getClassAnnotations().has(JsonFlatten.class) || beanDescription.findProperties().stream().filter(new Predicate() { // from class: com.azure.core.implementation.jackson.FlatteningDeserializer$1$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((BeanPropertyDefinition) obj).hasField();
                }
            }).map(new Function() { // from class: com.azure.core.implementation.jackson.FlatteningDeserializer$1$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((BeanPropertyDefinition) obj).getField();
                }
            }).anyMatch(new Predicate() { // from class: com.azure.core.implementation.jackson.FlatteningDeserializer$1$$ExternalSyntheticLambda2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((AnnotatedField) obj).hasAnnotation(JsonFlatten.class);
                }
            })) ? new FlatteningDeserializer(beanDescription, jsonDeserializer, this.val$mapper) : jsonDeserializer;
        }
    }

    public static SimpleModule getModule(ObjectMapper objectMapper) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.setDeserializerModifier(new AnonymousClass1(objectMapper));
        return simpleModule;
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        ObjectNode objectNode;
        JsonNode jsonNodeRemove;
        ObjectNode objectNode2 = (JsonNode) this.mapper.readTree(jsonParser);
        Iterator<Class<?>> it = TypeUtil.getAllClasses(this.defaultDeserializer.handledType()).iterator();
        while (it.hasNext()) {
            JsonTypeInfo annotation = it.next().getAnnotation(JsonTypeInfo.class);
            if (annotation != null) {
                String strProperty = annotation.property();
                if (containsDot(strProperty) && (jsonNodeRemove = (objectNode = objectNode2).remove(unescapeEscapedDots(strProperty))) != null) {
                    objectNode.set(strProperty, jsonNodeRemove);
                }
            }
        }
        return typeDeserializer.deserializeTypedFromAny(newJsonParserForNode(objectNode2), deserializationContext);
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectNode tree = deserializationContext.readTree(jsonParser);
        if (tree.isNull()) {
            tree = this.mapper.getNodeFactory().objectNode();
        }
        for (BeanPropertyDefinition beanPropertyDefinition : this.beanDescription.findProperties()) {
            if (beanPropertyDefinition.hasField()) {
                handleFlatteningForField(beanPropertyDefinition.getField(), tree);
            }
        }
        return this.defaultDeserializer.deserialize(newJsonParserForNode(tree), deserializationContext);
    }

    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        ResolvableDeserializer resolvableDeserializer = this.defaultDeserializer;
        if (resolvableDeserializer instanceof ResolvableDeserializer) {
            resolvableDeserializer.resolve(deserializationContext);
        }
    }

    private void handleFlatteningForField(AnnotatedField annotatedField, JsonNode jsonNode) {
        JsonProperty annotation = annotatedField.getAnnotation(JsonProperty.class);
        if (annotation != null) {
            String strValue = annotation.value();
            if (jsonNode.has(strValue)) {
                ((ObjectNode) jsonNode).set(strValue.replace(".", "\\."), jsonNode.get(strValue));
            }
            if ((this.classHasJsonFlatten || annotatedField.hasAnnotation(JsonFlatten.class)) && IS_FLATTENED_PATTERN.matcher(strValue).matches()) {
                String[] strArr = (String[]) Arrays.stream(SPLIT_KEY_PATTERN.split(strValue)).map(new Function() { // from class: com.azure.core.implementation.jackson.FlatteningDeserializer$$ExternalSyntheticLambda0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return FlatteningDeserializer.unescapeEscapedDots((String) obj);
                    }
                }).toArray(new IntFunction() { // from class: com.azure.core.implementation.jackson.FlatteningDeserializer$$ExternalSyntheticLambda1
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return FlatteningDeserializer.lambda$handleFlatteningForField$0(i);
                    }
                });
                ArrayList arrayList = new ArrayList();
                arrayList.add(jsonNode);
                JsonNode jsonNode2 = jsonNode;
                int i = 1;
                for (String str : strArr) {
                    jsonNode2 = jsonNode2.get(str);
                    i++;
                    if (jsonNode2 == null) {
                        break;
                    }
                    arrayList.add(jsonNode2);
                }
                if (arrayList.size() == i - 1) {
                    ((ObjectNode) jsonNode).set(strValue, (JsonNode) null);
                    return;
                }
                if (!((JsonNode) arrayList.get(arrayList.size() - 2)).has(strArr[strArr.length - 1])) {
                    ((ObjectNode) jsonNode).set(strValue, (JsonNode) null);
                } else {
                    ((ObjectNode) jsonNode).set(strValue, (JsonNode) arrayList.get(arrayList.size() - 1));
                }
                for (int size = arrayList.size() - 2; size >= 0; size--) {
                    if (size == arrayList.size() - 2 && arrayList.size() - 1 != strArr.length && ((JsonNode) arrayList.get(size)).get(strArr[size]).size() != 0) {
                        return;
                    }
                    ((ObjectNode) arrayList.get(size)).remove(strArr[size]);
                    if (((JsonNode) arrayList.get(size)).size() > 0) {
                        return;
                    }
                }
            }
        }
    }

    static /* synthetic */ String[] lambda$handleFlatteningForField$0(int i) {
        return new String[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String unescapeEscapedDots(String str) {
        return str.replace("\\.", ".");
    }

    private static boolean containsDot(String str) {
        return !CoreUtils.isNullOrEmpty(str) && str.contains(".");
    }

    private static JsonParser newJsonParserForNode(JsonNode jsonNode) throws IOException {
        JsonParser jsonParserCreateParser = new JsonFactory().createParser(jsonNode.toString());
        jsonParserCreateParser.nextToken();
        return jsonParserCreateParser;
    }
}
