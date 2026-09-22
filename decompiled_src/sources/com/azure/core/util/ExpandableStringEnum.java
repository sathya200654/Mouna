package com.azure.core.util;

import com.azure.core.implementation.ReflectionUtils;
import com.azure.core.implementation.ReflectiveInvoker;
import com.azure.core.util.ExpandableStringEnum;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class ExpandableStringEnum<T extends ExpandableStringEnum<T>> implements ExpandableEnum<String> {
    private Class<T> clazz;
    private String name;
    private static final Map<Class<?>, ReflectiveInvoker> CONSTRUCTORS = new ConcurrentHashMap();
    private static final Map<Class<?>, ConcurrentHashMap<String, ? extends ExpandableStringEnum<?>>> VALUES = new ConcurrentHashMap();
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ExpandableStringEnum.class);

    @Deprecated
    public ExpandableStringEnum() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static <T extends ExpandableStringEnum<T>> T fromString(String str, final Class<T> cls) {
        if (str == null) {
            return null;
        }
        T t = (T) VALUES.computeIfAbsent(cls, new Function() { // from class: com.azure.core.util.ExpandableStringEnum$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ExpandableStringEnum.lambda$fromString$0((Class) obj);
            }
        }).get(str);
        if (t != null) {
            return t;
        }
        Map<Class<?>, ReflectiveInvoker> map = CONSTRUCTORS;
        if (map.size() > 10000) {
            map.clear();
        }
        ReflectiveInvoker reflectiveInvokerComputeIfAbsent = map.computeIfAbsent(cls, new Function() { // from class: com.azure.core.util.ExpandableStringEnum$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ExpandableStringEnum.getDefaultConstructor((Class) obj);
            }
        });
        if (reflectiveInvokerComputeIfAbsent == null) {
            return null;
        }
        try {
            ExpandableStringEnum expandableStringEnum = (ExpandableStringEnum) reflectiveInvokerComputeIfAbsent.invokeStatic(new Object[0]);
            return (T) expandableStringEnum.nameAndAddValue(str, expandableStringEnum, cls);
        } catch (Exception e) {
            LOGGER.log(LogLevel.WARNING, new Supplier() { // from class: com.azure.core.util.ExpandableStringEnum$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ExpandableStringEnum.lambda$fromString$1(cls);
                }
            }, e);
            return null;
        }
    }

    static /* synthetic */ ConcurrentHashMap lambda$fromString$0(Class cls) {
        return new ConcurrentHashMap();
    }

    static /* synthetic */ String lambda$fromString$1(Class cls) {
        return "Failed to create " + cls.getName() + ", default constructor threw exception";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> ReflectiveInvoker getDefaultConstructor(final Class<T> cls) {
        try {
            return ReflectionUtils.getConstructorInvoker(cls, cls.getDeclaredConstructor(new Class[0]));
        } catch (IllegalAccessException | NoSuchMethodException e) {
            LOGGER.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.util.ExpandableStringEnum$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ExpandableStringEnum.lambda$getDefaultConstructor$2(cls);
                }
            }, e);
            return null;
        } catch (Exception e2) {
            LOGGER.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.util.ExpandableStringEnum$$ExternalSyntheticLambda4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ExpandableStringEnum.lambda$getDefaultConstructor$3(cls);
                }
            }, e2);
            return null;
        }
    }

    static /* synthetic */ String lambda$getDefaultConstructor$2(Class cls) {
        return "Can't find or access default constructor for " + cls.getName() + ", make sure corresponding package is open to azure-core";
    }

    static /* synthetic */ String lambda$getDefaultConstructor$3(Class cls) {
        return "Failed to get default constructor for " + cls.getName();
    }

    T nameAndAddValue(String str, T t, Class<T> cls) {
        this.name = str;
        this.clazz = cls;
        VALUES.get(cls).put(str, t);
        return this;
    }

    protected static <T extends ExpandableStringEnum<T>> Collection<T> values(Class<T> cls) {
        return new ArrayList(VALUES.getOrDefault(cls, new ConcurrentHashMap<>()).values());
    }

    @JsonValue
    public String toString() {
        return this.name;
    }

    @Override // com.azure.core.util.ExpandableEnum
    public String getValue() {
        return this.name;
    }

    public int hashCode() {
        return Objects.hash(this.clazz, this.name);
    }

    public boolean equals(Object obj) {
        Class<T> cls;
        if (obj == null || (cls = this.clazz) == null || !cls.isAssignableFrom(obj.getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = this.name;
        if (str == null) {
            return ((ExpandableStringEnum) obj).name == null;
        }
        return str.equals(((ExpandableStringEnum) obj).name);
    }
}
