package com.squareup.wire;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ProtoAdapter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\u0010\u0007J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00122\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J.\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016J.\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016J\u001c\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J&\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016J(\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/squareup/wire/MapProtoAdapter;", "K", "V", "Lcom/squareup/wire/ProtoAdapter;", "", "keyAdapter", "valueAdapter", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)V", "entryAdapter", "Lcom/squareup/wire/MapEntryProtoAdapter;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, ? extends V>> {
    private final MapEntryProtoAdapter<K, V> entryAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        super(FieldEncoding.LENGTH_DELIMITED, (KClass<?>) Reflection.getOrCreateKotlinClass(Map.class), (String) null, protoAdapter2.getSyntax(), MapsKt.emptyMap());
        Intrinsics.checkNotNullParameter(protoAdapter, "keyAdapter");
        Intrinsics.checkNotNullParameter(protoAdapter2, "valueAdapter");
        this.entryAdapter = new MapEntryProtoAdapter<>(protoAdapter, protoAdapter2);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(Map<K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSizeWithTag(int tag, Map<K, ? extends V> value) {
        int iEncodedSizeWithTag = 0;
        if (value == null) {
            return 0;
        }
        Iterator<Map.Entry<K, ? extends V>> it = value.entrySet().iterator();
        while (it.hasNext()) {
            iEncodedSizeWithTag += this.entryAdapter.encodedSizeWithTag(tag, it.next());
        }
        return iEncodedSizeWithTag;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter writer, Map<K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ReverseProtoWriter writer, Map<K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encodeWithTag(ProtoWriter writer, int tag, Map<K, ? extends V> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value == null) {
            return;
        }
        Iterator<Map.Entry<K, ? extends V>> it = value.entrySet().iterator();
        while (it.hasNext()) {
            this.entryAdapter.encodeWithTag(writer, tag, it.next());
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encodeWithTag(ReverseProtoWriter writer, int tag, Map<K, ? extends V> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value == null) {
            return;
        }
        Map.Entry[] entryArr = (Map.Entry[]) value.entrySet().toArray(new Map.Entry[0]);
        ArraysKt.reverse(entryArr);
        for (Map.Entry entry : entryArr) {
            this.entryAdapter.encodeWithTag(writer, tag, entry);
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map<K, V> decode(ProtoReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        K identity = this.entryAdapter.getKeyAdapter$wire_runtime().getIdentity();
        V identity2 = this.entryAdapter.getValueAdapter$wire_runtime().getIdentity();
        long jBeginMessage = reader.beginMessage();
        while (true) {
            int iNextTag = reader.nextTag();
            if (iNextTag == -1) {
                break;
            }
            if (iNextTag == 1) {
                identity = this.entryAdapter.getKeyAdapter$wire_runtime().decode(reader);
            } else if (iNextTag == 2) {
                identity2 = this.entryAdapter.getValueAdapter$wire_runtime().decode(reader);
            }
        }
        reader.endMessageAndGetUnknownFields(jBeginMessage);
        if (identity == null) {
            throw new IllegalStateException("Map entry with null key".toString());
        }
        if (identity2 == null) {
            throw new IllegalStateException("Map entry with null value".toString());
        }
        return MapsKt.mapOf(TuplesKt.to(identity, identity2));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map<K, V> redact(Map<K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return MapsKt.emptyMap();
    }
}
