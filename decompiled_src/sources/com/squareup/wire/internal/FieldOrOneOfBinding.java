package com.squareup.wire.internal;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.azure.core.util.tracing.Tracer;
import com.google.firebase.messaging.Constants;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FieldOrOneOfBinding.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010,\u001a\u00028\u0001H&¢\u0006\u0002\u0010*J\u0018\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0003J\u0010\u00101\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H\u0002J\u001f\u00102\u001a\u0002032\u0006\u0010,\u001a\u00028\u00012\b\u00100\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u00104J\u001d\u00100\u001a\u0002032\u0006\u0010,\u001a\u00028\u00012\u0006\u00100\u001a\u00020\u0003H&¢\u0006\u0002\u00104R'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u0012\u0010\u001c\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012R\u0016\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0012\u0010$\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000fR\u0012\u0010&\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0012¨\u00065"}, d2 = {"Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "M", "B", "", "()V", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "getAdapter$annotations", "getAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "declaredName", "", "getDeclaredName", "()Ljava/lang/String;", "isMap", "", "()Z", "isMessage", "keyAdapter", "getKeyAdapter", Constants.ScionAnalytics.PARAM_LABEL, "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "getSingleAdapter", "tag", "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "writeIdentityValues", "getWriteIdentityValues", "get", ResponseKeys.KEY_MESSAGE, "(Ljava/lang/Object;)Ljava/lang/Object;", "getFromBuilder", Tracer.SPAN_BUILDER_KEY, "omitFromJson", "syntax", "Lcom/squareup/wire/Syntax;", "value", "omitIdentity", "set", "", "(Ljava/lang/Object;Ljava/lang/Object;)V", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class FieldOrOneOfBinding<M, B> {

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter = LazyKt.lazy(new Function0<ProtoAdapter<Object>>(this) { // from class: com.squareup.wire.internal.FieldOrOneOfBinding$adapter$2
        final /* synthetic */ FieldOrOneOfBinding<M, B> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ProtoAdapter<Object> m2212invoke() {
            if (this.this$0.isMap()) {
                ProtoAdapter.Companion companion = ProtoAdapter.INSTANCE;
                ProtoAdapter<?> keyAdapter = this.this$0.getKeyAdapter();
                Intrinsics.checkNotNull(keyAdapter, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                ProtoAdapter<?> singleAdapter = this.this$0.getSingleAdapter();
                Intrinsics.checkNotNull(singleAdapter, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                ProtoAdapter<Object> protoAdapterNewMapAdapter = companion.newMapAdapter(keyAdapter, singleAdapter);
                Intrinsics.checkNotNull(protoAdapterNewMapAdapter, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                return protoAdapterNewMapAdapter;
            }
            ProtoAdapter<?> protoAdapterWithLabel$wire_runtime = this.this$0.getSingleAdapter().withLabel$wire_runtime(this.this$0.getLabel());
            Intrinsics.checkNotNull(protoAdapterWithLabel$wire_runtime, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
            return protoAdapterWithLabel$wire_runtime;
        }
    });

    public static /* synthetic */ void getAdapter$annotations() {
    }

    public abstract Object get(M message);

    public abstract String getDeclaredName();

    public abstract Object getFromBuilder(B builder);

    public abstract ProtoAdapter<?> getKeyAdapter();

    public abstract WireField.Label getLabel();

    public abstract String getName();

    public abstract boolean getRedacted();

    public abstract ProtoAdapter<?> getSingleAdapter();

    public abstract int getTag();

    public abstract String getWireFieldJsonName();

    public abstract boolean getWriteIdentityValues();

    public abstract boolean isMap();

    public abstract boolean isMessage();

    public abstract void set(B builder, Object value);

    public abstract void value(B builder, Object value);

    public final ProtoAdapter<Object> getAdapter() {
        return (ProtoAdapter) this.adapter.getValue();
    }

    public final boolean omitFromJson(Syntax syntax, Object value) {
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        if (value == null) {
            return true;
        }
        return omitIdentity(syntax) && Intrinsics.areEqual(value, getAdapter().getIdentity());
    }

    private final boolean omitIdentity(Syntax syntax) {
        if (getWriteIdentityValues()) {
            return false;
        }
        if (getLabel() == WireField.Label.OMIT_IDENTITY) {
            return true;
        }
        if (getLabel().isRepeated() && syntax == Syntax.PROTO_3) {
            return true;
        }
        return isMap() && syntax == Syntax.PROTO_3;
    }
}
