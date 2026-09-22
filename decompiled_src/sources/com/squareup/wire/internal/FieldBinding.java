package com.squareup.wire.internal;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.azure.core.util.tracing.Tracer;
import com.google.firebase.messaging.Constants;
import com.squareup.wire.KotlinConstructorBuilder;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Regex;

/* JADX INFO: compiled from: FieldBinding.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 C*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001CBG\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0018\u00107\u001a\u0004\u0018\u00010\u00162\u0006\u00108\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00109J*\u0010:\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J0\u0010;\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00190\u00182\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0017\u0010<\u001a\u0004\u0018\u00010\u00162\u0006\u0010=\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010>J$\u0010?\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u001f\u0010@\u001a\u00020\u00192\u0006\u0010=\u001a\u00028\u00012\b\u0010A\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010BJ\u001d\u0010A\u001a\u00020\u00192\u0006\u0010=\u001a\u00028\u00012\u0006\u0010A\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010BR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001fR\u0018\u0010!\u001a\u0006\u0012\u0002\b\u00030\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0014\u0010,\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0018\u0010.\u001a\u0006\u0012\u0002\b\u00030\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010$R\u0014\u00100\u001a\u000201X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001cR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001f¨\u0006D"}, d2 = {"Lcom/squareup/wire/internal/FieldBinding;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "wireField", "Lcom/squareup/wire/WireField;", "messageType", "Ljava/lang/Class;", "messageField", "Ljava/lang/reflect/Field;", "builderType", "writeIdentityValues", "", "classLoader", "Ljava/lang/ClassLoader;", "(Lcom/squareup/wire/WireField;Ljava/lang/Class;Ljava/lang/reflect/Field;Ljava/lang/Class;ZLjava/lang/ClassLoader;)V", "adapterString", "", "builderGetter", "Lkotlin/Function1;", "", "builderSetter", "Lkotlin/Function2;", "", "declaredName", "getDeclaredName", "()Ljava/lang/String;", "instanceGetter", "isMap", "()Z", "isMessage", "keyAdapter", "Lcom/squareup/wire/ProtoAdapter;", "getKeyAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "keyAdapterString", Constants.ScionAnalytics.PARAM_LABEL, "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "getSingleAdapter", "tag", "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "getWriteIdentityValues", "get", ResponseKeys.KEY_MESSAGE, "(Lcom/squareup/wire/Message;)Ljava/lang/Object;", "getBuilderGetter", "getBuilderSetter", "getFromBuilder", Tracer.SPAN_BUILDER_KEY, "(Lcom/squareup/wire/Message$Builder;)Ljava/lang/Object;", "getInstanceGetter", "set", "value", "(Lcom/squareup/wire/Message$Builder;Ljava/lang/Object;)V", "Companion", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> extends FieldOrOneOfBinding<M, B> {
    private static final Regex IS_GETTER_FIELD_NAME_REGEX = new Regex("^is[^a-z].*$");
    private final String adapterString;
    private final Function1<B, Object> builderGetter;
    private final Function2<B, Object, Unit> builderSetter;
    private final ClassLoader classLoader;
    private final String declaredName;
    private final Function1<M, Object> instanceGetter;
    private final String keyAdapterString;
    private final WireField.Label label;
    private final Field messageField;
    private final String name;
    private final boolean redacted;
    private final int tag;
    private final String wireFieldJsonName;
    private final boolean writeIdentityValues;

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getWriteIdentityValues() {
        return this.writeIdentityValues;
    }

    public /* synthetic */ FieldBinding(WireField wireField, Class cls, Field field, Class cls2, boolean z, ClassLoader classLoader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(wireField, cls, field, cls2, z, (i & 32) != 0 ? cls.getClassLoader() : classLoader);
    }

    public FieldBinding(WireField wireField, Class<M> cls, Field field, Class<B> cls2, boolean z, ClassLoader classLoader) {
        String strDeclaredName;
        Intrinsics.checkNotNullParameter(wireField, "wireField");
        Intrinsics.checkNotNullParameter(cls, "messageType");
        Intrinsics.checkNotNullParameter(field, "messageField");
        Intrinsics.checkNotNullParameter(cls2, "builderType");
        this.messageField = field;
        this.writeIdentityValues = z;
        this.classLoader = classLoader;
        this.label = wireField.label();
        String name = field.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        this.name = name;
        this.wireFieldJsonName = wireField.jsonName();
        if (wireField.declaredName().length() == 0) {
            strDeclaredName = field.getName();
            Intrinsics.checkNotNullExpressionValue(strDeclaredName, "getName(...)");
        } else {
            strDeclaredName = wireField.declaredName();
        }
        this.declaredName = strDeclaredName;
        this.tag = wireField.tag();
        this.keyAdapterString = wireField.keyAdapter();
        this.adapterString = wireField.adapter();
        this.redacted = wireField.redacted();
        this.builderSetter = getBuilderSetter(cls2, wireField);
        this.builderGetter = getBuilderGetter(cls2, wireField);
        this.instanceGetter = getInstanceGetter(cls);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public WireField.Label getLabel() {
        return this.label;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getName() {
        return this.name;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getWireFieldJsonName() {
        return this.wireFieldJsonName;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getDeclaredName() {
        return this.declaredName;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public int getTag() {
        return this.tag;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getRedacted() {
        return this.redacted;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public ProtoAdapter<?> getKeyAdapter() {
        return ProtoAdapter.INSTANCE.get(this.keyAdapterString, this.classLoader);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public ProtoAdapter<?> getSingleAdapter() {
        return ProtoAdapter.INSTANCE.get(this.adapterString, this.classLoader);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMap() {
        return this.keyAdapterString.length() > 0;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMessage() {
        KClass<?> type = getSingleAdapter().getType();
        Class javaObjectType = type != null ? JvmClassMappingKt.getJavaObjectType(type) : null;
        Intrinsics.checkNotNull(javaObjectType);
        return Message.class.isAssignableFrom(javaObjectType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Function2<B, Object, Unit> getBuilderSetter(Class<?> builderType, final WireField wireField) {
        if (builderType.isAssignableFrom(KotlinConstructorBuilder.class)) {
            return new Function2<B, Object, Unit>() { // from class: com.squareup.wire.internal.FieldBinding.getBuilderSetter.1
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Message.Builder) obj, obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(B b, Object obj) {
                    Intrinsics.checkNotNullParameter(b, Tracer.SPAN_BUILDER_KEY);
                    ((KotlinConstructorBuilder) b).set(wireField, obj);
                }
            };
        }
        if (wireField.label().isOneOf()) {
            Class<?> type = this.messageField.getType();
            try {
                final Method method = builderType.getMethod(getName(), type);
                return new Function2<B, Object, Unit>() { // from class: com.squareup.wire.internal.FieldBinding.getBuilderSetter.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
                        invoke((Message.Builder) obj, obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(B b, Object obj) throws IllegalAccessException, InvocationTargetException {
                        Intrinsics.checkNotNullParameter(b, Tracer.SPAN_BUILDER_KEY);
                        method.invoke(b, obj);
                    }
                };
            } catch (NoSuchMethodException unused) {
                throw new AssertionError("No builder method " + builderType.getName() + '.' + getName() + '(' + type.getName() + ')');
            }
        }
        try {
            final Field field = builderType.getField(getName());
            return new Function2<B, Object, Unit>() { // from class: com.squareup.wire.internal.FieldBinding.getBuilderSetter.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IllegalAccessException {
                    invoke((Message.Builder) obj, obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(B b, Object obj) throws IllegalAccessException {
                    Intrinsics.checkNotNullParameter(b, Tracer.SPAN_BUILDER_KEY);
                    field.set(b, obj);
                }
            };
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError("No builder field " + builderType.getName() + '.' + getName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Function1<B, Object> getBuilderGetter(Class<?> builderType, final WireField wireField) {
        if (builderType.isAssignableFrom(KotlinConstructorBuilder.class)) {
            return new Function1<B, Object>() { // from class: com.squareup.wire.internal.FieldBinding.getBuilderGetter.1
                {
                    super(1);
                }

                public final Object invoke(B b) {
                    Intrinsics.checkNotNullParameter(b, Tracer.SPAN_BUILDER_KEY);
                    return ((KotlinConstructorBuilder) b).get(wireField);
                }
            };
        }
        try {
            final Field field = builderType.getField(getName());
            return new Function1<B, Object>() { // from class: com.squareup.wire.internal.FieldBinding.getBuilderGetter.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Object invoke(B b) {
                    Intrinsics.checkNotNullParameter(b, Tracer.SPAN_BUILDER_KEY);
                    return field.get(b);
                }
            };
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + builderType.getName() + '.' + getName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Function1<M, Object> getInstanceGetter(Class<M> messageType) throws NoSuchMethodException {
        if (Modifier.isPrivate(this.messageField.getModifiers())) {
            String name = this.messageField.getName();
            Regex regex = IS_GETTER_FIELD_NAME_REGEX;
            Intrinsics.checkNotNull(name);
            String str = name;
            if (!regex.matches(str)) {
                StringBuilder sb = new StringBuilder("get");
                if (str.length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    String strValueOf = String.valueOf(name.charAt(0));
                    Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    StringBuilder sbAppend = sb2.append((Object) upperCase);
                    String strSubstring = name.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    name = sbAppend.append(strSubstring).toString();
                }
                name = sb.append(name).toString();
            }
            final Method method = messageType.getMethod(name, new Class[0]);
            return new Function1<M, Object>() { // from class: com.squareup.wire.internal.FieldBinding.getInstanceGetter.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Object invoke(M m) {
                    Intrinsics.checkNotNullParameter(m, "instance");
                    return method.invoke(m, new Object[0]);
                }
            };
        }
        return new Function1<M, Object>(this) { // from class: com.squareup.wire.internal.FieldBinding.getInstanceGetter.2
            final /* synthetic */ FieldBinding<M, B> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public final Object invoke(M m) {
                Intrinsics.checkNotNullParameter(m, "instance");
                return ((FieldBinding) this.this$0).messageField.get(m);
            }
        };
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public void value(B builder, Object value) {
        Intrinsics.checkNotNullParameter(builder, Tracer.SPAN_BUILDER_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        if (getLabel().isRepeated()) {
            Object fromBuilder = getFromBuilder((Message.Builder) builder);
            if (TypeIntrinsics.isMutableList(fromBuilder)) {
                Intrinsics.checkNotNull(fromBuilder, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
                TypeIntrinsics.asMutableList(fromBuilder).add(value);
                return;
            } else {
                if (fromBuilder instanceof List) {
                    List mutableList = CollectionsKt.toMutableList((Collection) fromBuilder);
                    mutableList.add(value);
                    set((Message.Builder) builder, (Object) mutableList);
                    return;
                }
                throw new ClassCastException("Expected a list type, got " + (fromBuilder != null ? fromBuilder.getClass() : null) + '.');
            }
        }
        if (this.keyAdapterString.length() > 0) {
            Object fromBuilder2 = getFromBuilder((Message.Builder) builder);
            if (TypeIntrinsics.isMutableMap(fromBuilder2)) {
                ((Map) fromBuilder2).putAll((Map) value);
                return;
            } else {
                if (fromBuilder2 instanceof Map) {
                    Map mutableMap = MapsKt.toMutableMap((Map) fromBuilder2);
                    mutableMap.putAll((Map) value);
                    set((Message.Builder) builder, (Object) mutableMap);
                    return;
                }
                throw new ClassCastException("Expected a map type, got " + (fromBuilder2 != null ? fromBuilder2.getClass() : null) + '.');
            }
        }
        set((Message.Builder) builder, value);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public void set(B builder, Object value) {
        Intrinsics.checkNotNullParameter(builder, Tracer.SPAN_BUILDER_KEY);
        this.builderSetter.invoke(builder, value);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public Object get(M message) {
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        return this.instanceGetter.invoke(message);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public Object getFromBuilder(B builder) {
        Intrinsics.checkNotNullParameter(builder, Tracer.SPAN_BUILDER_KEY);
        return this.builderGetter.invoke(builder);
    }
}
