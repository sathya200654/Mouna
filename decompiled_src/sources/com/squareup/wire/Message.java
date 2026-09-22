package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: Message.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 $*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0002#$B\u001d\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\bJ\r\u0010\u001b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000b\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0004R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012¨\u0006%"}, d2 = {"Lcom/squareup/wire/Message;", "M", "B", "Lcom/squareup/wire/Message$Builder;", "Ljava/io/Serializable;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "unknownFields", "Lokio/ByteString;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)V", "()Lcom/squareup/wire/ProtoAdapter;", "cachedSerializedSize", "", "getCachedSerializedSize$wire_runtime", "()I", "setCachedSerializedSize$wire_runtime", "(I)V", "hashCode", "()Lokio/ByteString;", "encode", "", "", "stream", "Ljava/io/OutputStream;", "sink", "Lokio/BufferedSink;", "encodeByteString", "newBuilder", "()Lcom/squareup/wire/Message$Builder;", "toString", "", "withoutUnknownFields", "()Lcom/squareup/wire/Message;", "writeReplace", "", "Builder", "Companion", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    private transient int cachedSerializedSize;
    protected transient int hashCode;
    private final transient ByteString unknownFields;

    public abstract B newBuilder();

    protected Message(ProtoAdapter<M> protoAdapter, ByteString byteString) {
        Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
        Intrinsics.checkNotNullParameter(byteString, "unknownFields");
        this.adapter = protoAdapter;
        this.unknownFields = byteString;
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final ByteString unknownFields() {
        ByteString byteString = this.unknownFields;
        return byteString == null ? ByteString.EMPTY : byteString;
    }

    /* JADX INFO: renamed from: getCachedSerializedSize$wire_runtime, reason: from getter */
    public final int getCachedSerializedSize() {
        return this.cachedSerializedSize;
    }

    public final void setCachedSerializedSize$wire_runtime(int i) {
        this.cachedSerializedSize = i;
    }

    public final M withoutUnknownFields() {
        return (M) newBuilder().clearUnknownFields().build();
    }

    public String toString() {
        ProtoAdapter<M> protoAdapter = this.adapter;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.squareup.wire.Message");
        return protoAdapter.toString(this);
    }

    protected final Object writeReplace() throws ObjectStreamException {
        byte[] bArrEncode = encode();
        Class<?> cls = getClass();
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<M of com.squareup.wire.Message>");
        return new MessageSerializedForm(bArrEncode, cls);
    }

    public final void encode(BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        ProtoAdapter<M> protoAdapter = this.adapter;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.squareup.wire.Message");
        protoAdapter.encode(sink, this);
    }

    public final byte[] encode() {
        ProtoAdapter<M> protoAdapter = this.adapter;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.squareup.wire.Message");
        return protoAdapter.encode(this);
    }

    public final ByteString encodeByteString() {
        ProtoAdapter<M> protoAdapter = this.adapter;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.squareup.wire.Message");
        return protoAdapter.encodeByteString(this);
    }

    public final void encode(OutputStream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        ProtoAdapter<M> protoAdapter = this.adapter;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.squareup.wire.Message");
        protoAdapter.encode(stream, this);
    }

    /* JADX INFO: compiled from: Message.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u0014\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0003\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u00020\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0005J,\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0006\u0010\u001f\u001a\u00020\rJ\r\u0010 \u001a\u00028\u0002H&¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\rJ\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000J\b\u0010$\u001a\u00020%H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/squareup/wire/Message$Builder;", "M", "Lcom/squareup/wire/Message;", "B", "", "()V", "unknownFieldsBuffer", "Lokio/Buffer;", "getUnknownFieldsBuffer$wire_runtime", "()Lokio/Buffer;", "setUnknownFieldsBuffer$wire_runtime", "(Lokio/Buffer;)V", "unknownFieldsByteString", "Lokio/ByteString;", "getUnknownFieldsByteString$wire_runtime", "()Lokio/ByteString;", "setUnknownFieldsByteString$wire_runtime", "(Lokio/ByteString;)V", "unknownFieldsWriter", "Lcom/squareup/wire/ProtoWriter;", "getUnknownFieldsWriter$wire_runtime", "()Lcom/squareup/wire/ProtoWriter;", "setUnknownFieldsWriter$wire_runtime", "(Lcom/squareup/wire/ProtoWriter;)V", "addUnknownField", "tag", "", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "value", "addUnknownFields", "unknownFields", "build", "()Lcom/squareup/wire/Message;", "buildUnknownFields", "clearUnknownFields", "prepareForNewUnknownFields", "", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {
        private transient Buffer unknownFieldsBuffer;
        private transient ByteString unknownFieldsByteString = ByteString.EMPTY;
        private transient ProtoWriter unknownFieldsWriter;

        public abstract M build();

        protected Builder() {
        }

        /* JADX INFO: renamed from: getUnknownFieldsByteString$wire_runtime, reason: from getter */
        public final ByteString getUnknownFieldsByteString() {
            return this.unknownFieldsByteString;
        }

        public final void setUnknownFieldsByteString$wire_runtime(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "<set-?>");
            this.unknownFieldsByteString = byteString;
        }

        /* JADX INFO: renamed from: getUnknownFieldsBuffer$wire_runtime, reason: from getter */
        public final Buffer getUnknownFieldsBuffer() {
            return this.unknownFieldsBuffer;
        }

        public final void setUnknownFieldsBuffer$wire_runtime(Buffer buffer) {
            this.unknownFieldsBuffer = buffer;
        }

        /* JADX INFO: renamed from: getUnknownFieldsWriter$wire_runtime, reason: from getter */
        public final ProtoWriter getUnknownFieldsWriter() {
            return this.unknownFieldsWriter;
        }

        public final void setUnknownFieldsWriter$wire_runtime(ProtoWriter protoWriter) {
            this.unknownFieldsWriter = protoWriter;
        }

        public final Builder<M, B> addUnknownFields(ByteString unknownFields) throws IOException {
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            if (unknownFields.size() > 0) {
                prepareForNewUnknownFields();
                ProtoWriter protoWriter = this.unknownFieldsWriter;
                Intrinsics.checkNotNull(protoWriter);
                protoWriter.writeBytes(unknownFields);
            }
            return this;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final Builder<M, B> addUnknownField(int tag, FieldEncoding fieldEncoding, Object value) throws NoWhenBranchMatchedException, IOException {
            Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
            prepareForNewUnknownFields();
            ProtoAdapter<?> protoAdapterRawProtoAdapter = fieldEncoding.rawProtoAdapter();
            Intrinsics.checkNotNull(protoAdapterRawProtoAdapter, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
            ProtoWriter protoWriter = this.unknownFieldsWriter;
            Intrinsics.checkNotNull(protoWriter);
            protoAdapterRawProtoAdapter.encodeWithTag(protoWriter, tag, value);
            return this;
        }

        public final Builder<M, B> clearUnknownFields() {
            this.unknownFieldsByteString = ByteString.EMPTY;
            Buffer buffer = this.unknownFieldsBuffer;
            if (buffer != null) {
                Intrinsics.checkNotNull(buffer);
                buffer.clear();
                this.unknownFieldsBuffer = null;
            }
            this.unknownFieldsWriter = null;
            return this;
        }

        public final ByteString buildUnknownFields() {
            Buffer buffer = this.unknownFieldsBuffer;
            if (buffer != null) {
                Intrinsics.checkNotNull(buffer);
                this.unknownFieldsByteString = buffer.readByteString();
                this.unknownFieldsBuffer = null;
                this.unknownFieldsWriter = null;
            }
            return this.unknownFieldsByteString;
        }

        private final void prepareForNewUnknownFields() throws IOException {
            if (this.unknownFieldsBuffer == null) {
                this.unknownFieldsBuffer = new Buffer();
                BufferedSink bufferedSink = this.unknownFieldsBuffer;
                Intrinsics.checkNotNull(bufferedSink);
                ProtoWriter protoWriter = new ProtoWriter(bufferedSink);
                this.unknownFieldsWriter = protoWriter;
                Intrinsics.checkNotNull(protoWriter);
                protoWriter.writeBytes(this.unknownFieldsByteString);
                this.unknownFieldsByteString = ByteString.EMPTY;
            }
        }
    }

    /* JADX INFO: compiled from: Message.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/squareup/wire/Message$Companion;", "", "()V", "serialVersionUID", "", "getSerialVersionUID$annotations", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getSerialVersionUID$annotations() {
        }

        private Companion() {
        }
    }
}
