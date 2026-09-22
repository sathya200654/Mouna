package com.azure.core.implementation;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class TypeUtil {
    private static final Map<Type, Type> SUPER_TYPE_MAP = new ConcurrentHashMap();

    static /* synthetic */ boolean lambda$typeImplementsInterface$1(Class cls, Class cls2) {
        return cls2 == cls;
    }

    public static List<Class<?>> getAllClasses(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static Type[] getTypeArguments(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return new Type[0];
        }
        return ((ParameterizedType) type).getActualTypeArguments();
    }

    public static Type getTypeArgument(Type type) {
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        return null;
    }

    public static Class<?> getRawClass(Type type) {
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        return (Class) type;
    }

    public static Type getSuperType(final Type type) {
        Map<Type, Type> map = SUPER_TYPE_MAP;
        Type type2 = map.get(type);
        return type2 != null ? type2 : map.computeIfAbsent(type, new Function() { // from class: com.azure.core.implementation.TypeUtil$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return TypeUtil.lambda$getSuperType$0(type, (Type) obj);
            }
        });
    }

    static /* synthetic */ Type lambda$getSuperType$0(Type type, Type type2) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type genericSuperclass = ((Class) parameterizedType.getRawType()).getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return genericSuperclass;
            }
            Type[] typeArguments = getTypeArguments(genericSuperclass);
            TypeVariable<?>[] typeParameters = ((GenericDeclaration) parameterizedType.getRawType()).getTypeParameters();
            int i = 0;
            for (int i2 = 0; i2 != typeArguments.length; i2++) {
                int i3 = 0;
                while (i2 < typeParameters.length) {
                    if (typeParameters[i3].equals(typeArguments[i2])) {
                        typeArguments[i2] = parameterizedType.getActualTypeArguments()[i];
                        i++;
                        break;
                    }
                    i3++;
                }
            }
            return createParameterizedType(((ParameterizedType) genericSuperclass).getRawType(), typeArguments);
        }
        return ((Class) type).getGenericSuperclass();
    }

    public static boolean typeImplementsInterface(Type type, final Class<?> cls) {
        if (getRawClass(type) == cls) {
            return true;
        }
        if (type instanceof ParameterizedType) {
            return typeImplementsInterface(((ParameterizedType) type).getRawType(), cls);
        }
        return Arrays.stream(((Class) type).getInterfaces()).anyMatch(new Predicate() { // from class: com.azure.core.implementation.TypeUtil$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return TypeUtil.lambda$typeImplementsInterface$1(cls, (Class) obj);
            }
        });
    }

    public static Type getSuperType(Type type, Class<?> cls) {
        while (type != null && getRawClass(type) != cls) {
            type = getSuperType(type);
        }
        return type;
    }

    public static boolean isTypeOrSubTypeOf(Type type, Type type2) {
        return getRawClass(type2).isAssignableFrom(getRawClass(type));
    }

    public static ParameterizedType createParameterizedType(final Type type, final Type... typeArr) {
        return new ParameterizedType() { // from class: com.azure.core.implementation.TypeUtil.1
            @Override // java.lang.reflect.ParameterizedType
            public Type getOwnerType() {
                return null;
            }

            @Override // java.lang.reflect.ParameterizedType
            public Type[] getActualTypeArguments() {
                return typeArr;
            }

            @Override // java.lang.reflect.ParameterizedType
            public Type getRawType() {
                return type;
            }
        };
    }

    public static Type getRestResponseBodyType(Type type) {
        Type[] typeArguments = getTypeArguments(type);
        if (typeArguments != null && typeArguments.length > 0) {
            return typeArguments[typeArguments.length - 1];
        }
        return getRestResponseBodyType(getSuperType(type));
    }

    private TypeUtil() {
    }
}
