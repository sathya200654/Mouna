package com.azure.core.implementation.jackson;

import com.azure.core.annotation.JsonFlatten;
import com.azure.core.util.ExpandableStringEnum;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class FlatteningSerializer extends StdSerializer<Object> implements ResolvableSerializer {
    private static final long serialVersionUID = -6130180289951110573L;
    private final BeanDescription beanDescription;
    private final boolean classHasJsonFlatten;
    private final JsonSerializer<?> defaultSerializer;
    private final Set<String> jsonPropertiesWithJsonFlatten;
    private final ObjectMapper mapper;
    private static final Pattern CHECK_IF_FLATTEN_PROPERTY_PATTERN = Pattern.compile(".+[^\\\\]\\..+");
    private static final Pattern UNESCAPED_PERIOD_PATTERN = Pattern.compile("((?<!\\\\))\\.");
    private static final Pattern CHECK_IF_ESCAPED_MAP_PATTERN = Pattern.compile(".*[^\\\\]\\\\..+");
    private static final Pattern REPLACE_ESCAPED_MAP_PATTERN = Pattern.compile("\\\\.");
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) FlatteningSerializer.class);

    FlatteningSerializer(BeanDescription beanDescription, JsonSerializer<?> jsonSerializer, ObjectMapper objectMapper) {
        super(beanDescription.getBeanClass(), false);
        this.beanDescription = beanDescription;
        this.defaultSerializer = jsonSerializer;
        this.mapper = objectMapper;
        boolean zHas = beanDescription.getClassAnnotations().has(JsonFlatten.class);
        this.classHasJsonFlatten = zHas;
        if (zHas) {
            this.jsonPropertiesWithJsonFlatten = Collections.emptySet();
        } else {
            this.jsonPropertiesWithJsonFlatten = (Set) beanDescription.findProperties().stream().filter(new Predicate() { // from class: com.azure.core.implementation.jackson.FlatteningSerializer$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((BeanPropertyDefinition) obj).hasField();
                }
            }).filter(new Predicate() { // from class: com.azure.core.implementation.jackson.FlatteningSerializer$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((BeanPropertyDefinition) obj).getField().hasAnnotation(JsonFlatten.class);
                }
            }).map(new Function() { // from class: com.azure.core.implementation.jackson.FlatteningSerializer$$ExternalSyntheticLambda2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((BeanPropertyDefinition) obj).getName();
                }
            }).collect(Collectors.toSet());
        }
    }

    /* JADX INFO: renamed from: com.azure.core.implementation.jackson.FlatteningSerializer$1, reason: invalid class name */
    class AnonymousClass1 extends BeanSerializerModifier {
        final /* synthetic */ ObjectMapper val$mapper;

        AnonymousClass1(ObjectMapper objectMapper) {
            this.val$mapper = objectMapper;
        }

        public JsonSerializer<?> modifySerializer(SerializationConfig serializationConfig, BeanDescription beanDescription, JsonSerializer<?> jsonSerializer) {
            return (beanDescription.getClassAnnotations().has(JsonFlatten.class) || beanDescription.findProperties().stream().filter(new Predicate() { // from class: com.azure.core.implementation.jackson.FlatteningSerializer$1$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((BeanPropertyDefinition) obj).hasField();
                }
            }).map(new Function() { // from class: com.azure.core.implementation.jackson.FlatteningSerializer$1$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((BeanPropertyDefinition) obj).getField();
                }
            }).anyMatch(new Predicate() { // from class: com.azure.core.implementation.jackson.FlatteningSerializer$1$$ExternalSyntheticLambda2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((AnnotatedField) obj).hasAnnotation(JsonFlatten.class);
                }
            })) ? new FlatteningSerializer(beanDescription, jsonSerializer, this.val$mapper) : jsonSerializer;
        }
    }

    public static SimpleModule getModule(ObjectMapper objectMapper) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.setSerializerModifier(new AnonymousClass1(objectMapper));
        return simpleModule;
    }

    private static List<Field> getAllDeclaredFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && !cls.equals(Object.class)) {
            for (Field field : cls.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (!Modifier.isFinal(modifiers) && !Modifier.isStatic(modifiers)) {
                    arrayList.add(field);
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    private static void escapeMapKeys(Object obj, ClientLogger clientLogger) {
        if (obj == null || obj.getClass().isPrimitive() || obj.getClass().isEnum() || (obj instanceof OffsetDateTime) || (obj instanceof Duration) || (obj instanceof String) || (obj instanceof ExpandableStringEnum)) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : new HashSet(map.keySet())) {
                if (str.contains(".")) {
                    map.put(UNESCAPED_PERIOD_PATTERN.matcher(str).replaceAll("\\\\."), map.remove(str));
                }
            }
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                escapeMapKeys(it.next(), clientLogger);
            }
            return;
        }
        if (obj instanceof List) {
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                escapeMapKeys(it2.next(), clientLogger);
            }
            return;
        }
        for (Field field : getAllDeclaredFields(obj.getClass())) {
            field.setAccessible(true);
            try {
                escapeMapKeys(field.get(obj), clientLogger);
            } catch (IllegalAccessException e) {
                throw clientLogger.logExceptionAsError(new RuntimeException(e));
            }
        }
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        if (obj == null) {
            jsonGenerator.writeNull();
            return;
        }
        if (this.classHasJsonFlatten) {
            classLevelFlattenSerialize(obj, jsonGenerator);
            return;
        }
        ObjectNode objectNodeCreateObjectNode = this.mapper.createObjectNode();
        if (typeSerializer != null) {
            objectNodeCreateObjectNode.put(typeSerializer.getPropertyName(), typeSerializer.getTypeIdResolver().idFromValue(obj));
        }
        propertyOnlyFlattenSerialize(obj, jsonGenerator, serializerProvider, objectNodeCreateObjectNode);
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializeWithType(obj, jsonGenerator, serializerProvider, null);
    }

    public void resolve(SerializerProvider serializerProvider) throws JsonMappingException {
        ResolvableSerializer resolvableSerializer = this.defaultSerializer;
        if (resolvableSerializer instanceof ResolvableSerializer) {
            resolvableSerializer.resolve(serializerProvider);
        }
    }

    private void propertyOnlyFlattenSerialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, ObjectNode objectNode) throws IOException {
        ObjectNode objectNodePutObject;
        for (BeanPropertyDefinition beanPropertyDefinition : this.beanDescription.findProperties()) {
            String name = beanPropertyDefinition.getName();
            if (this.jsonPropertiesWithJsonFlatten.contains(beanPropertyDefinition.getName())) {
                String[] strArrSplit = UNESCAPED_PERIOD_PATTERN.split(beanPropertyDefinition.getName());
                String str = strArrSplit[strArrSplit.length - 1];
                objectNodePutObject = objectNode;
                for (int i = 0; i < strArrSplit.length - 1; i++) {
                    if (objectNodePutObject.has(strArrSplit[i])) {
                        objectNodePutObject = (ObjectNode) objectNodePutObject.get(strArrSplit[i]);
                    } else {
                        objectNodePutObject = objectNodePutObject.putObject(strArrSplit[i]);
                    }
                }
                name = str;
            } else {
                objectNodePutObject = objectNode;
            }
            objectNodePutObject.putPOJO(name, beanPropertyDefinition.getField().getValue(obj));
        }
        jsonGenerator.writeStartObject();
        Iterator itFields = objectNode.fields();
        while (itFields.hasNext()) {
            Map.Entry entry = (Map.Entry) itFields.next();
            jsonGenerator.writeFieldName((String) entry.getKey());
            jsonGenerator.writeTree((TreeNode) entry.getValue());
        }
        AnnotatedMember annotatedMemberFindAnyGetter = this.beanDescription.findAnyGetter();
        if (annotatedMemberFindAnyGetter != null && annotatedMemberFindAnyGetter.getAnnotation(JsonAnyGetter.class).enabled()) {
            BeanProperty.Std std = new BeanProperty.Std(PropertyName.construct(annotatedMemberFindAnyGetter.getName()), annotatedMemberFindAnyGetter.getType(), (PropertyName) null, annotatedMemberFindAnyGetter, PropertyMetadata.STD_OPTIONAL);
            try {
                new AnyGetterWriter(std, annotatedMemberFindAnyGetter, serializerProvider.findTypedValueSerializer(annotatedMemberFindAnyGetter.getType(), true, std)).getAndSerialize(obj, jsonGenerator, serializerProvider);
            } catch (IOException e) {
                throw ((IOException) LOGGER.logThrowableAsError(e));
            } catch (Exception e2) {
                throw ((IOException) LOGGER.logThrowableAsError(new IOException(e2)));
            }
        }
        jsonGenerator.writeEndObject();
    }

    private void classLevelFlattenSerialize(Object obj, JsonGenerator jsonGenerator) throws IOException {
        escapeMapKeys(obj, LOGGER);
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
                JsonNode jsonNode = objectNode2.get(str);
                if (CHECK_IF_FLATTEN_PROPERTY_PATTERN.matcher(str).matches()) {
                    String[] strArrSplit = UNESCAPED_PERIOD_PATTERN.split(str);
                    ObjectNode objectNode3 = objectNode2;
                    for (int i = 0; i < strArrSplit.length; i++) {
                        String strReplace = strArrSplit[i].replace("\\.", ".");
                        strArrSplit[i] = strReplace;
                        if (i == strArrSplit.length - 1) {
                            break;
                        }
                        if (objectNode3.has(strReplace)) {
                            objectNode3 = (ObjectNode) objectNode3.get(strReplace);
                        } else {
                            ObjectNode objectNode4 = new ObjectNode(JsonNodeFactory.instance);
                            objectNode3.set(strReplace, objectNode4);
                            objectNode3 = objectNode4;
                        }
                    }
                    objectNode3.set(strArrSplit[strArrSplit.length - 1], objectNode2.get(str));
                    objectNode2.remove(str);
                    jsonNode = objectNode3.get(strArrSplit[strArrSplit.length - 1]);
                } else if (CHECK_IF_ESCAPED_MAP_PATTERN.matcher(str).matches()) {
                    String strReplaceAll = REPLACE_ESCAPED_MAP_PATTERN.matcher(str).replaceAll(".");
                    objectNode2.remove(str);
                    objectNode2.set(strReplaceAll, jsonNode);
                }
                if (entry.getValue() instanceof ObjectNode) {
                    linkedBlockingQueue.add((ObjectNode) entry.getValue());
                    linkedBlockingQueue2.add((ObjectNode) jsonNode);
                } else if ((entry.getValue() instanceof ArrayNode) && ((JsonNode) entry.getValue()).size() > 0 && (((JsonNode) entry.getValue()).get(0) instanceof ObjectNode)) {
                    Iterator itElements = ((JsonNode) entry.getValue()).elements();
                    Iterator itElements2 = jsonNode.elements();
                    while (itElements.hasNext()) {
                        linkedBlockingQueue.add((ObjectNode) itElements.next());
                        linkedBlockingQueue2.add((ObjectNode) itElements2.next());
                    }
                }
            }
        }
        jsonGenerator.writeTree(objectNodeDeepCopy);
    }
}
