package com.squareup.wire;

import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: RuntimeEnumAdapter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u0016*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0016B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0015\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0014¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/squareup/wire/RuntimeEnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "Lcom/squareup/wire/EnumAdapter;", "javaType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "syntax", "Lcom/squareup/wire/Syntax;", "(Ljava/lang/Class;Lcom/squareup/wire/Syntax;)V", "fromValueMethod", "Ljava/lang/reflect/Method;", "equals", "", "other", "", "fromValue", "value", "", "(I)Lcom/squareup/wire/WireEnum;", "getFromValueMethod", "hashCode", "Companion", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Method fromValueMethod;
    private final Class<E> javaType;

    @JvmStatic
    public static final <E extends WireEnum> RuntimeEnumAdapter<E> create(Class<E> cls) {
        return INSTANCE.create(cls);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuntimeEnumAdapter(Class<E> cls, Syntax syntax) {
        super((KClass<WireEnum>) JvmClassMappingKt.getKotlinClass(cls), syntax, Internal.getIdentityOrNull(cls));
        Intrinsics.checkNotNullParameter(cls, "javaType");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        this.javaType = cls;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RuntimeEnumAdapter(Class<E> cls) {
        this(cls, Syntax.PROTO_2);
        Intrinsics.checkNotNullParameter(cls, "javaType");
    }

    private final Method getFromValueMethod() throws NoSuchMethodException {
        Method method = this.fromValueMethod;
        if (method != null) {
            return method;
        }
        Method method2 = this.javaType.getMethod("fromValue", Integer.TYPE);
        this.fromValueMethod = method2;
        Intrinsics.checkNotNullExpressionValue(method2, "also(...)");
        return method2;
    }

    @Override // com.squareup.wire.EnumAdapter
    protected E fromValue(int value) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = getFromValueMethod().invoke(null, Integer.valueOf(value));
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type E of com.squareup.wire.RuntimeEnumAdapter");
        return (E) objInvoke;
    }

    public boolean equals(Object other) {
        return (other instanceof RuntimeEnumAdapter) && Intrinsics.areEqual(((RuntimeEnumAdapter) other).getType(), getType());
    }

    public int hashCode() {
        KClass<?> type = getType();
        if (type != null) {
            return type.hashCode();
        }
        return 0;
    }

    /* JADX INFO: compiled from: RuntimeEnumAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0007¨\u0006\t"}, d2 = {"Lcom/squareup/wire/RuntimeEnumAdapter$Companion;", "", "()V", "create", "Lcom/squareup/wire/RuntimeEnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "enumType", "Ljava/lang/Class;", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <E extends WireEnum> RuntimeEnumAdapter<E> create(Class<E> enumType) {
            Intrinsics.checkNotNullParameter(enumType, "enumType");
            return new RuntimeEnumAdapter<>(enumType, ProtoAdapter.INSTANCE.get(enumType).getSyntax());
        }
    }
}
