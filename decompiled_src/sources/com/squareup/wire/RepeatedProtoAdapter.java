package com.squareup.wire;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ProtoAdapter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/squareup/wire/RepeatedProtoAdapter;", "E", "Lcom/squareup/wire/ProtoAdapter;", "", "originalAdapter", "(Lcom/squareup/wire/ProtoAdapter;)V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RepeatedProtoAdapter<E> extends ProtoAdapter<List<? extends E>> {
    private final ProtoAdapter<E> originalAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepeatedProtoAdapter(ProtoAdapter<E> protoAdapter) {
        super(protoAdapter.getFieldEncoding(), (KClass<?>) Reflection.getOrCreateKotlinClass(List.class), (String) null, protoAdapter.getSyntax(), CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(protoAdapter, "originalAdapter");
        this.originalAdapter = protoAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(List<? extends E> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSizeWithTag(int tag, List<? extends E> value) {
        if (value == null) {
            return 0;
        }
        int size = value.size();
        int iEncodedSizeWithTag = 0;
        for (int i = 0; i < size; i++) {
            iEncodedSizeWithTag += this.originalAdapter.encodedSizeWithTag(tag, value.get(i));
        }
        return iEncodedSizeWithTag;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter writer, List<? extends E> value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ReverseProtoWriter writer, List<? extends E> value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encodeWithTag(ProtoWriter writer, int tag, List<? extends E> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value == null) {
            return;
        }
        int size = value.size();
        for (int i = 0; i < size; i++) {
            this.originalAdapter.encodeWithTag(writer, tag, value.get(i));
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encodeWithTag(ReverseProtoWriter writer, int tag, List<? extends E> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value == null) {
            return;
        }
        int size = value.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            } else {
                this.originalAdapter.encodeWithTag(writer, tag, value.get(size));
            }
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public List<E> decode(ProtoReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        return CollectionsKt.listOf(this.originalAdapter.decode(reader));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public List<E> redact(List<? extends E> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return CollectionsKt.emptyList();
    }
}
