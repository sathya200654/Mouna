package com.azure.core.implementation.jackson;

import com.azure.core.annotation.HeaderCollection;
import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpHeaders;
import com.azure.core.implementation.ReflectionSerializable;
import com.azure.core.implementation.ReflectionUtils;
import com.azure.core.implementation.ReflectiveInvoker;
import com.azure.core.implementation.TypeUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ObjectMapperShim {
    private static final int CACHE_SIZE_LIMIT = 10000;
    private final ObjectMapper mapper;
    private MemberNameConverterImpl memberNameConverter;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ObjectMapperShim.class);
    private static final Map<Type, JavaType> TYPE_TO_JAVA_TYPE_CACHE = new ConcurrentHashMap();
    private static final Map<Type, ReflectiveInvoker> TYPE_TO_STRONGLY_TYPED_HEADERS_CONSTRUCTOR_CACHE = new ConcurrentHashMap();
    private static final ReflectiveInvoker NO_CONSTRUCTOR_REFLECTIVE_INVOKER = ReflectionUtils.createNoOpInvoker();

    public static ObjectMapperShim createJsonMapper(ObjectMapperShim objectMapperShim, BiConsumer<ObjectMapper, ObjectMapper> biConsumer) {
        try {
            ObjectMapper objectMapperCreateJsonMapper = ObjectMapperFactory.INSTANCE.createJsonMapper(objectMapperShim.mapper);
            biConsumer.accept(objectMapperCreateJsonMapper, objectMapperShim.mapper);
            return new ObjectMapperShim(objectMapperCreateJsonMapper);
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public static ObjectMapperShim createXmlMapper() {
        try {
            return new ObjectMapperShim(ObjectMapperFactory.INSTANCE.createXmlMapper());
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public static ObjectMapperShim createSimpleMapper() {
        try {
            return new ObjectMapperShim(ObjectMapperFactory.INSTANCE.createSimpleMapper());
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public static ObjectMapperShim createDefaultMapper() {
        try {
            return new ObjectMapperShim(ObjectMapperFactory.INSTANCE.createDefaultMapper());
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public static ObjectMapperShim createPrettyPrintMapper() {
        try {
            return new ObjectMapperShim(ObjectMapperFactory.INSTANCE.createPrettyPrintMapper());
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public static ObjectMapperShim createHeaderMapper() {
        try {
            return new ObjectMapperShim(ObjectMapperFactory.INSTANCE.createHeaderMapper());
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public ObjectMapperShim(ObjectMapper objectMapper) {
        this.mapper = objectMapper;
    }

    public String writeValueAsString(Object obj) throws IOException {
        try {
            return this.mapper.writeValueAsString(obj);
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public byte[] writeValueAsBytes(Object obj) throws IOException {
        try {
            return this.mapper.writeValueAsBytes(obj);
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public void writeValue(OutputStream outputStream, Object obj) throws IOException {
        try {
            this.mapper.writeValue(outputStream, obj);
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public <T> T readValue(String str, Type type) throws IOException {
        try {
            return (T) this.mapper.readValue(str, createJavaType(type));
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public <T> T readValue(byte[] bArr, Type type) throws IOException {
        try {
            return (T) this.mapper.readValue(bArr, createJavaType(type));
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public <T> T readValue(InputStream inputStream, Type type) throws IOException {
        try {
            return (T) this.mapper.readValue(inputStream, createJavaType(type));
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public JsonNode readTree(String str) throws IOException {
        try {
            return this.mapper.readTree(str);
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    public JsonNode readTree(byte[] bArr) throws IOException {
        try {
            return this.mapper.readTree(bArr);
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    private JavaType createJavaType(Type type) {
        if (type == null) {
            return null;
        }
        if (type instanceof JavaType) {
            return (JavaType) type;
        }
        if (type instanceof ParameterizedType) {
            final ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            final JavaType[] javaTypeArr = new JavaType[actualTypeArguments.length];
            for (int i = 0; i != actualTypeArguments.length; i++) {
                javaTypeArr[i] = createJavaType(actualTypeArguments[i]);
            }
            return getFromTypeCache(type, new Function() { // from class: com.azure.core.implementation.jackson.ObjectMapperShim$$ExternalSyntheticLambda3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m1207x17b75e8d(parameterizedType, javaTypeArr, (Type) obj);
                }
            });
        }
        return getFromTypeCache(type, new Function() { // from class: com.azure.core.implementation.jackson.ObjectMapperShim$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1208x18edb16c((Type) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$createJavaType$0$com-azure-core-implementation-jackson-ObjectMapperShim, reason: not valid java name */
    /* synthetic */ JavaType m1207x17b75e8d(ParameterizedType parameterizedType, JavaType[] javaTypeArr, Type type) {
        return this.mapper.getTypeFactory().constructParametricType((Class) parameterizedType.getRawType(), javaTypeArr);
    }

    /* JADX INFO: renamed from: lambda$createJavaType$1$com-azure-core-implementation-jackson-ObjectMapperShim, reason: not valid java name */
    /* synthetic */ JavaType m1208x18edb16c(Type type) {
        JavaType javaTypeConstructType = this.mapper.constructType(type);
        if (!javaTypeConstructType.isContainerType()) {
            Class rawClass = javaTypeConstructType.getRawClass();
            if (ReflectionSerializable.supportsJsonSerializable(rawClass)) {
                return javaTypeConstructType.withValueHandler(new JsonSerializableDeserializer(rawClass));
            }
        } else {
            Stack stack = new Stack();
            JavaType contentType = javaTypeConstructType;
            while (contentType.isContainerType()) {
                stack.add(contentType);
                contentType = contentType.getContentType();
            }
            Class rawClass2 = contentType.getRawClass();
            if (ReflectionSerializable.supportsJsonSerializable(rawClass2)) {
                javaTypeConstructType = contentType.withValueHandler(new JsonSerializableDeserializer(rawClass2));
                while (!stack.isEmpty()) {
                    javaTypeConstructType = ((JavaType) stack.pop()).withContentType(javaTypeConstructType);
                }
            }
        }
        return javaTypeConstructType;
    }

    public <T> T deserialize(HttpHeaders httpHeaders, final Type type) throws IOException {
        if (type == null) {
            return null;
        }
        try {
            ReflectiveInvoker fromHeadersConstructorCache = getFromHeadersConstructorCache(type);
            if (fromHeadersConstructorCache != NO_CONSTRUCTOR_REFLECTIVE_INVOKER) {
                return (T) fromHeadersConstructorCache.invokeStatic(httpHeaders);
            }
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw LOGGER.logExceptionAsError((RuntimeException) e);
            }
            LOGGER.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.implementation.jackson.ObjectMapperShim$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ObjectMapperShim.lambda$deserialize$2(type);
                }
            });
        }
        final T t = (T) this.mapper.convertValue(httpHeaders, createJavaType(type));
        Field[] declaredFields = TypeUtil.getRawClass(type).getDeclaredFields();
        ArrayList<HeaderCollectionHandler> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(HeaderCollection.class)) {
                Type genericType = field.getGenericType();
                if (TypeUtil.isTypeOrSubTypeOf(field.getType(), Map.class)) {
                    Type[] typeArguments = TypeUtil.getTypeArguments(genericType);
                    if (typeArguments.length == 2 && typeArguments[0] == String.class && typeArguments[1] == String.class) {
                        String lowerCase = ((HeaderCollection) field.getAnnotation(HeaderCollection.class)).value().toLowerCase(Locale.ROOT);
                        if (lowerCase.length() != 0) {
                            arrayList.add(new HeaderCollectionHandler(lowerCase, field));
                            hashSet.add(Character.valueOf(lowerCase.charAt(0)));
                        }
                    }
                }
            }
        }
        for (HttpHeader httpHeader : httpHeaders) {
            String lowerCase2 = httpHeader.getName().toLowerCase(Locale.ROOT);
            if (hashSet.contains(Character.valueOf(lowerCase2.charAt(0)))) {
                for (HeaderCollectionHandler headerCollectionHandler : arrayList) {
                    if (headerCollectionHandler.headerStartsWithPrefix(lowerCase2)) {
                        headerCollectionHandler.addHeader(httpHeader.getName(), httpHeader.getValue());
                    }
                }
            }
        }
        arrayList.forEach(new Consumer() { // from class: com.azure.core.implementation.jackson.ObjectMapperShim$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((HeaderCollectionHandler) obj).injectValuesIntoDeclaringField(t, ObjectMapperShim.LOGGER);
            }
        });
        return t;
    }

    static /* synthetic */ String lambda$deserialize$2(Type type) {
        return "Failed to find or use invoker Constructor that accepts HttpHeaders for " + type + ".";
    }

    public String convertMemberName(Member member) {
        if (this.memberNameConverter == null) {
            this.memberNameConverter = new MemberNameConverterImpl(this.mapper);
        }
        try {
            return this.memberNameConverter.convertMemberName(member);
        } catch (LinkageError e) {
            throw ((LinkageError) LOGGER.logThrowableAsError(new LinkageError(JacksonVersion.getHelpInfo(), e)));
        }
    }

    private static JavaType getFromTypeCache(Type type, Function<Type, JavaType> function) {
        Map<Type, JavaType> map = TYPE_TO_JAVA_TYPE_CACHE;
        if (map.size() >= 10000) {
            map.clear();
        }
        return map.computeIfAbsent(type, function);
    }

    private static ReflectiveInvoker getFromHeadersConstructorCache(Type type) {
        Map<Type, ReflectiveInvoker> map = TYPE_TO_STRONGLY_TYPED_HEADERS_CONSTRUCTOR_CACHE;
        if (map.size() >= 10000) {
            map.clear();
        }
        return map.computeIfAbsent(type, new Function() { // from class: com.azure.core.implementation.jackson.ObjectMapperShim$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ObjectMapperShim.lambda$getFromHeadersConstructorCache$4((Type) obj);
            }
        });
    }

    static /* synthetic */ ReflectiveInvoker lambda$getFromHeadersConstructorCache$4(Type type) {
        try {
            Class<?> rawClass = TypeUtil.getRawClass(type);
            return ReflectionUtils.getConstructorInvoker(rawClass, rawClass.getDeclaredConstructor(HttpHeaders.class));
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw ((Error) LOGGER.logThrowableAsError(th));
            }
            return NO_CONSTRUCTOR_REFLECTIVE_INVOKER;
        }
    }
}
