package com.squareup.wire;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ProtoAdapter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/squareup/wire/DoubleProtoAdapter;", "Lcom/squareup/wire/ProtoAdapter;", "", "()V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Double;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "", "redact", "(D)Ljava/lang/Double;", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DoubleProtoAdapter extends ProtoAdapter<Double> {
    public int encodedSize(double value) {
        return 8;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Double d) throws IOException {
        encode(protoWriter, d.doubleValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Double d) throws IOException {
        encode(reverseProtoWriter, d.doubleValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Double d) {
        return encodedSize(d.doubleValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Double redact(Double d) {
        return redact(d.doubleValue());
    }

    public DoubleProtoAdapter() {
        super(FieldEncoding.FIXED64, (KClass<?>) Reflection.getOrCreateKotlinClass(Double.TYPE), (String) null, Syntax.PROTO_2, Double.valueOf(0.0d));
    }

    public void encode(ProtoWriter writer, double value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        writer.writeFixed64(Double.doubleToLongBits(value));
    }

    public void encode(ReverseProtoWriter writer, double value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        writer.writeFixed64(Double.doubleToLongBits(value));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.wire.ProtoAdapter
    public Double decode(ProtoReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.valueOf(Double.longBitsToDouble(reader.readFixed64()));
    }

    public Double redact(double value) {
        throw new UnsupportedOperationException();
    }
}
