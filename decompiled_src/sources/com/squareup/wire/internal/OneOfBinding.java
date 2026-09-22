package com.squareup.wire.internal;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.azure.core.util.tracing.Tracer;
import com.google.firebase.messaging.Constants;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.OneOf;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: OneOfBinding.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B1\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u00101\u001a\u0004\u0018\u00010%2\u0006\u00102\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00103J\u0017\u00104\u001a\u0004\u0018\u00010%2\u0006\u00105\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00106J\u001f\u00107\u001a\u0002082\u0006\u00105\u001a\u00028\u00012\b\u00109\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u0010:J\u001d\u00109\u001a\u0002082\u0006\u00105\u001a\u00028\u00012\u0006\u00109\u001a\u00020%H\u0016¢\u0006\u0002\u0010:R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u0014\u0010!\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0015R \u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8VX\u0096\u0004¢\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0013R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0015¨\u0006;"}, d2 = {"Lcom/squareup/wire/internal/OneOfBinding;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "messageField", "Ljava/lang/reflect/Field;", "builderType", "Ljava/lang/Class;", "key", "Lcom/squareup/wire/OneOf$Key;", "writeIdentityValues", "", "(Ljava/lang/reflect/Field;Ljava/lang/Class;Lcom/squareup/wire/OneOf$Key;Z)V", "builderField", "declaredName", "", "getDeclaredName", "()Ljava/lang/String;", "isMap", "()Z", "isMessage", "keyAdapter", "", "getKeyAdapter", "()Ljava/lang/Void;", Constants.ScionAnalytics.PARAM_LABEL, "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "Lcom/squareup/wire/ProtoAdapter;", "", "getSingleAdapter$annotations", "()V", "getSingleAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "tag", "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "getWriteIdentityValues", "get", ResponseKeys.KEY_MESSAGE, "(Lcom/squareup/wire/Message;)Ljava/lang/Object;", "getFromBuilder", Tracer.SPAN_BUILDER_KEY, "(Lcom/squareup/wire/Message$Builder;)Ljava/lang/Object;", "set", "", "value", "(Lcom/squareup/wire/Message$Builder;Ljava/lang/Object;)V", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OneOfBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> extends FieldOrOneOfBinding<M, B> {
    private final Field builderField;
    private final OneOf.Key<?> key;
    private final Field messageField;
    private final boolean writeIdentityValues;

    public static /* synthetic */ void getSingleAdapter$annotations() {
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMap() {
        return false;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ ProtoAdapter getKeyAdapter() {
        return (ProtoAdapter) m2217getKeyAdapter();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getWriteIdentityValues() {
        return this.writeIdentityValues;
    }

    public OneOfBinding(Field field, Class<B> cls, OneOf.Key<?> key, boolean z) throws NoSuchFieldException {
        Intrinsics.checkNotNullParameter(field, "messageField");
        Intrinsics.checkNotNullParameter(cls, "builderType");
        Intrinsics.checkNotNullParameter(key, "key");
        this.messageField = field;
        this.key = key;
        this.writeIdentityValues = z;
        Field declaredField = cls.getDeclaredField(field.getName());
        Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
        this.builderField = declaredField;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public int getTag() {
        return this.key.getTag();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public WireField.Label getLabel() {
        return WireField.Label.OPTIONAL;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getRedacted() {
        return this.key.getRedacted();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getWireFieldJsonName() {
        return this.key.getJsonName();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getName() {
        return this.key.getDeclaredName();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getDeclaredName() {
        return this.key.getDeclaredName();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMessage() {
        KClass<?> type = getSingleAdapter().getType();
        return Message.class.isAssignableFrom(type != null ? JvmClassMappingKt.getJavaObjectType(type) : null);
    }

    /* JADX INFO: renamed from: getKeyAdapter, reason: collision with other method in class */
    public Void m2217getKeyAdapter() {
        throw new IllegalStateException("not a map".toString());
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public ProtoAdapter<Object> getSingleAdapter() {
        ProtoAdapter<?> adapter = this.key.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
        return adapter;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public void value(B builder, Object value) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(builder, Tracer.SPAN_BUILDER_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        set((Message.Builder) builder, value);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public void set(B builder, Object value) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(builder, Tracer.SPAN_BUILDER_KEY);
        Field field = this.builderField;
        OneOf.Key<?> key = this.key;
        Intrinsics.checkNotNull(key, "null cannot be cast to non-null type com.squareup.wire.OneOf.Key<kotlin.Any>");
        Intrinsics.checkNotNull(value);
        field.set(builder, new OneOf(key, value));
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public Object get(M message) {
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        OneOf oneOf = (OneOf) this.messageField.get(message);
        if (oneOf != null) {
            return oneOf.getOrNull(this.key);
        }
        return null;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public Object getFromBuilder(B builder) {
        Intrinsics.checkNotNullParameter(builder, Tracer.SPAN_BUILDER_KEY);
        OneOf oneOf = (OneOf) this.builderField.get(builder);
        if (oneOf != null) {
            return oneOf.getOrNull(this.key);
        }
        return null;
    }
}
