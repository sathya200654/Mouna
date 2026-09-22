package com.azure.core.implementation.jackson;

import com.azure.core.implementation.AccessControllerUtils;
import com.azure.core.implementation.ReflectionUtils;
import com.azure.core.implementation.ReflectiveInvoker;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class HeaderCollectionHandler {
    private static final int CACHE_SIZE_LIMIT = 10000;
    private static final Map<Field, ReflectiveInvoker> FIELD_TO_SETTER_INVOKER_CACHE = new ConcurrentHashMap();
    private static final ReflectiveInvoker NO_SETTER_REFLECTIVE_INVOKER = ReflectionUtils.createNoOpInvoker();
    private final Field declaringField;
    private final String prefix;
    private final int prefixLength;
    private final Map<String, String> values = new HashMap();

    HeaderCollectionHandler(String str, Field field) {
        this.prefix = str;
        this.prefixLength = str.length();
        this.declaringField = field;
    }

    boolean headerStartsWithPrefix(String str) {
        return str.startsWith(this.prefix);
    }

    void addHeader(String str, String str2) {
        this.values.put(str.substring(this.prefixLength), str2);
    }

    void injectValuesIntoDeclaringField(Object obj, ClientLogger clientLogger) {
        if (usePublicSetter(obj, clientLogger)) {
            return;
        }
        boolean zIsAccessible = this.declaringField.isAccessible();
        if (!zIsAccessible) {
            try {
                AccessControllerUtils.doPrivileged(new Supplier() { // from class: com.azure.core.implementation.jackson.HeaderCollectionHandler$$ExternalSyntheticLambda4
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return this.f$0.m1204x685ee359();
                    }
                });
            } catch (IllegalAccessException e) {
                clientLogger.log(LogLevel.WARNING, new Supplier() { // from class: com.azure.core.implementation.jackson.HeaderCollectionHandler$$ExternalSyntheticLambda6
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return HeaderCollectionHandler.lambda$injectValuesIntoDeclaringField$1();
                    }
                }, e);
                if (zIsAccessible) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (!zIsAccessible) {
                    AccessControllerUtils.doPrivileged(new Supplier() { // from class: com.azure.core.implementation.jackson.HeaderCollectionHandler$$ExternalSyntheticLambda5
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            return this.f$0.m1205x4f7debdb();
                        }
                    });
                }
            }
        }
        this.declaringField.set(obj, this.values);
        clientLogger.verbose("Set header collection by accessing the field directly.");
    }

    /* JADX INFO: renamed from: lambda$injectValuesIntoDeclaringField$0$com-azure-core-implementation-jackson-HeaderCollectionHandler, reason: not valid java name */
    /* synthetic */ Object m1204x685ee359() {
        this.declaringField.setAccessible(true);
        return null;
    }

    static /* synthetic */ String lambda$injectValuesIntoDeclaringField$1() {
        return "Failed to inject header collection values into deserialized headers.";
    }

    /* JADX INFO: renamed from: lambda$injectValuesIntoDeclaringField$2$com-azure-core-implementation-jackson-HeaderCollectionHandler, reason: not valid java name */
    /* synthetic */ Object m1205x4f7debdb() {
        this.declaringField.setAccessible(false);
        return null;
    }

    private boolean usePublicSetter(Object obj, ClientLogger clientLogger) {
        Class<?> cls = obj.getClass();
        final String simpleName = cls.getSimpleName();
        final String name = this.declaringField.getName();
        ReflectiveInvoker fromCache = getFromCache(this.declaringField, cls, simpleName, name, clientLogger);
        if (fromCache == NO_SETTER_REFLECTIVE_INVOKER) {
            return false;
        }
        try {
            fromCache.invokeWithArguments(obj, this.values);
            clientLogger.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.implementation.jackson.HeaderCollectionHandler$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return HeaderCollectionHandler.lambda$usePublicSetter$3(name, simpleName);
                }
            });
            return true;
        } catch (Exception e) {
            clientLogger.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.implementation.jackson.HeaderCollectionHandler$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return HeaderCollectionHandler.lambda$usePublicSetter$4(name, simpleName);
                }
            }, e);
            return false;
        }
    }

    static /* synthetic */ String lambda$usePublicSetter$3(String str, String str2) {
        return "Set header collection " + str + " on class " + str2 + " using reflection.";
    }

    static /* synthetic */ String lambda$usePublicSetter$4(String str, String str2) {
        return "Failed to set header " + str + " collection on class " + str2 + " using reflection.";
    }

    private static String getPotentialSetterName(String str) {
        return "set" + str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1);
    }

    private static ReflectiveInvoker getFromCache(Field field, final Class<?> cls, final String str, final String str2, final ClientLogger clientLogger) {
        Map<Field, ReflectiveInvoker> map = FIELD_TO_SETTER_INVOKER_CACHE;
        if (map.size() >= 10000) {
            map.clear();
        }
        return map.computeIfAbsent(field, new Function() { // from class: com.azure.core.implementation.jackson.HeaderCollectionHandler$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return HeaderCollectionHandler.lambda$getFromCache$7(str2, cls, clientLogger, str, (Field) obj);
            }
        });
    }

    static /* synthetic */ ReflectiveInvoker lambda$getFromCache$7(String str, Class cls, ClientLogger clientLogger, final String str2, Field field) {
        final String potentialSetterName = getPotentialSetterName(str);
        try {
            ReflectiveInvoker methodInvoker = ReflectionUtils.getMethodInvoker(cls, cls.getDeclaredMethod(potentialSetterName, Map.class));
            clientLogger.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.implementation.jackson.HeaderCollectionHandler$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return HeaderCollectionHandler.lambda$getFromCache$5(potentialSetterName, str2);
                }
            });
            return methodInvoker;
        } catch (Exception e) {
            clientLogger.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.implementation.jackson.HeaderCollectionHandler$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return HeaderCollectionHandler.lambda$getFromCache$6(potentialSetterName, str2);
                }
            }, e);
            return NO_SETTER_REFLECTIVE_INVOKER;
        }
    }

    static /* synthetic */ String lambda$getFromCache$5(String str, String str2) {
        return "Using invoker for setter " + str + " on class " + str2 + ".";
    }

    static /* synthetic */ String lambda$getFromCache$6(String str, String str2) {
        return "Failed to retrieve invoker for setter " + str + " on class " + str2 + ". Will attempt to make field accessible. Please consider adding public setter.";
    }
}
