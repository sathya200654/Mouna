package com.squareup.wire;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ProtoAdapter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\"\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/squareup/wire/LongArrayProtoAdapter;", "Lcom/squareup/wire/ProtoAdapter;", "", "originalAdapter", "", "(Lcom/squareup/wire/ProtoAdapter;)V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LongArrayProtoAdapter extends ProtoAdapter<long[]> {
    private final ProtoAdapter<Long> originalAdapter;

    @Override // com.squareup.wire.ProtoAdapter
    public long[] redact(long[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new long[0];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongArrayProtoAdapter(ProtoAdapter<Long> protoAdapter) {
        super(FieldEncoding.LENGTH_DELIMITED, (KClass<?>) Reflection.getOrCreateKotlinClass(long[].class), (String) null, protoAdapter.getSyntax(), new long[0]);
        Intrinsics.checkNotNullParameter(protoAdapter, "originalAdapter");
        this.originalAdapter = protoAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encodeWithTag(ProtoWriter writer, int tag, long[] value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value != null) {
            if (value.length == 0) {
                return;
            }
            super.encodeWithTag(writer, tag, value);
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encodeWithTag(ReverseProtoWriter writer, int tag, long[] value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value != null) {
            if (value.length == 0) {
                return;
            }
            super.encodeWithTag(writer, tag, value);
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(long[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int iEncodedSize = 0;
        for (long j : value) {
            iEncodedSize += this.originalAdapter.encodedSize(Long.valueOf(j));
        }
        return iEncodedSize;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSizeWithTag(int tag, long[] value) {
        if (value == null || value.length == 0) {
            return 0;
        }
        return super.encodedSizeWithTag(tag, value);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter writer, long[] value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        for (long j : value) {
            this.originalAdapter.encode(writer, Long.valueOf(j));
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ReverseProtoWriter writer, long[] value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        int length = value.length;
        while (true) {
            length--;
            if (-1 >= length) {
                return;
            } else {
                this.originalAdapter.encode(writer, Long.valueOf(value[length]));
            }
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public long[] decode(ProtoReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        return new long[]{this.originalAdapter.decode(reader).longValue()};
    }
}
