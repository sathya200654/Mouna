package com.squareup.wire.internal;

import com.squareup.wire.KotlinConstructorBuilder;
import com.squareup.wire.Message;
import com.squareup.wire.OneOf;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: reflection.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a`\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001at\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\b\u001a\u00020\t\u001aH\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0002\u001aF\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"createRuntimeMessageAdapter", "Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "M", "B", "Lcom/squareup/wire/Message;", "Lcom/squareup/wire/Message$Builder;", "messageType", "Ljava/lang/Class;", "writeIdentityValues", "", "classLoader", "Ljava/lang/ClassLoader;", "typeUrl", "", "syntax", "Lcom/squareup/wire/Syntax;", "getBuilderType", "getKeys", "", "Lcom/squareup/wire/OneOf$Key;", "messageField", "Ljava/lang/reflect/Field;", "wire-runtime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ReflectionKt {
    public static /* synthetic */ RuntimeMessageAdapter createRuntimeMessageAdapter$default(Class cls, String str, Syntax syntax, ClassLoader classLoader, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            classLoader = cls.getClassLoader();
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return createRuntimeMessageAdapter(cls, str, syntax, classLoader, z);
    }

    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> createRuntimeMessageAdapter(final Class<M> cls, String str, Syntax syntax, ClassLoader classLoader, boolean z) {
        Intrinsics.checkNotNullParameter(cls, "messageType");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        final Class builderType = getBuilderType(cls);
        Function0 function0 = new Function0<B>() { // from class: com.squareup.wire.internal.ReflectionKt$createRuntimeMessageAdapter$newBuilderInstance$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TB; */
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Message.Builder m2218invoke() throws IllegalAccessException, InstantiationException {
                if (builderType.isAssignableFrom(KotlinConstructorBuilder.class)) {
                    return new KotlinConstructorBuilder(cls);
                }
                B bNewInstance = builderType.newInstance();
                Intrinsics.checkNotNull(bNewInstance);
                return (Message.Builder) bNewInstance;
            }
        };
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        for (Field field : declaredFields) {
            WireField wireField = (WireField) field.getAnnotation(WireField.class);
            if (wireField != null) {
                Integer numValueOf = Integer.valueOf(wireField.tag());
                Intrinsics.checkNotNull(field);
                linkedHashMap.put(numValueOf, new FieldBinding(wireField, cls, field, builderType, z, classLoader));
            } else if (Intrinsics.areEqual(field.getType(), OneOf.class)) {
                Intrinsics.checkNotNull(field);
                for (OneOf.Key<?> key : getKeys(field)) {
                    linkedHashMap.put(Integer.valueOf(key.getTag()), new OneOfBinding(field, builderType, key, z));
                }
            }
        }
        KClass kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(...)");
        return new RuntimeMessageAdapter<>(new RuntimeMessageBinding(kotlinClass, builderType, function0, mapUnmodifiableMap, str, syntax));
    }

    private static final <M extends Message<M, B>, B extends Message.Builder<M, B>> Set<OneOf.Key<?>> getKeys(Field field) throws IllegalAccessException, NoSuchFieldException {
        Class<?> declaringClass = field.getDeclaringClass();
        String name = field.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Field declaredField = declaringClass.getDeclaredField(Internal.boxedOneOfKeysFieldName(name));
        declaredField.setAccessible(true);
        Object obj = declaredField.get(null);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Set<com.squareup.wire.OneOf.Key<*>>");
        return (Set) obj;
    }

    public static /* synthetic */ RuntimeMessageAdapter createRuntimeMessageAdapter$default(Class cls, boolean z, ClassLoader classLoader, int i, Object obj) {
        if ((i & 4) != 0) {
            classLoader = cls.getClassLoader();
        }
        return createRuntimeMessageAdapter(cls, z, classLoader);
    }

    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> createRuntimeMessageAdapter(Class<M> cls, boolean z, ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(cls, "messageType");
        ProtoAdapter protoAdapter = ProtoAdapter.INSTANCE.get(cls);
        return createRuntimeMessageAdapter(cls, protoAdapter.getTypeUrl(), protoAdapter.getSyntax(), classLoader, z);
    }

    private static final <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> cls) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Class<?> cls2 = Class.forName(cls.getName() + "$Builder");
            Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<B of com.squareup.wire.internal.ReflectionKt.getBuilderType$lambda$0>");
            obj = Result.constructor-impl(cls2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Class<B> cls3 = (Class) obj;
        return cls3 == null ? KotlinConstructorBuilder.class : cls3;
    }
}
