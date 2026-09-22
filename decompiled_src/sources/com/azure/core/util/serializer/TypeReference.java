package com.azure.core.util.serializer;

import com.azure.core.implementation.TypeUtil;
import com.azure.core.util.logging.ClientLogger;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class TypeReference<T> {
    private static final String MISSING_TYPE = "Type constructed without type information.";
    private final Class<T> clazz;
    private final Type javaType;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) TypeReference.class);
    private static final Map<Class<?>, TypeReference<?>> CACHE = new ConcurrentHashMap();

    public TypeReference() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(MISSING_TYPE));
        }
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        this.javaType = type;
        this.clazz = (Class<T>) TypeUtil.getRawClass(type);
    }

    private TypeReference(Class<T> cls) {
        this.javaType = cls;
        this.clazz = cls;
    }

    public Type getJavaType() {
        return this.javaType;
    }

    public static <T> TypeReference<T> createInstance(final Class<T> cls) {
        return (TypeReference) CACHE.computeIfAbsent(cls, new Function() { // from class: com.azure.core.util.serializer.TypeReference$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return TypeReference.lambda$createInstance$0(cls, (Class) obj);
            }
        });
    }

    static /* synthetic */ TypeReference lambda$createInstance$0(Class cls, Class cls2) {
        return new TypeReference<T>(cls) { // from class: com.azure.core.util.serializer.TypeReference.1
        };
    }

    public Class<T> getJavaClass() {
        return this.clazz;
    }
}
