package com.squareup.wire;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: ProtoReader.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\u0006\u0010\u001b\u001a\u00020\tJ\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\tH\u0007J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\tJ%\u0010 \u001a\u00020\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\"H\u0087\bø\u0001\u0000¢\u0006\u0002\b#J\b\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u000fH\u0002J\u0006\u0010&\u001a\u00020\tJ\u0006\u0010'\u001a\u00020\u000fJ\u0006\u0010(\u001a\u00020\u000fJ\b\u0010)\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010*\u001a\u00020\u001fJ\u0006\u0010+\u001a\u00020\u000fJ\u0006\u0010,\u001a\u00020\tJ\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u00100\u001a\u00020\u000fJ\u0006\u00101\u001a\u00020\tJ\u0006\u00102\u001a\u00020\u0013J\u0010\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00066"}, d2 = {"Lcom/squareup/wire/ProtoReader;", "", Constants.ScionAnalytics.PARAM_SOURCE, "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "bufferStack", "", "Lokio/Buffer;", "limit", "", "nextFieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "pos", "pushedLimit", "recursionDepth", "", RemoteConfigConstants.ResponseFieldKey.STATE, "tag", "addUnknownField", "", "fieldEncoding", "value", "afterPackableScalar", "beforeLengthDelimitedScalar", "beforePossiblyPackedScalar", "", "beforePossiblyPackedScalar$wire_runtime", "beginMessage", "endMessage", "token", "endMessageAndGetUnknownFields", "Lokio/ByteString;", "forEachTag", "tagHandler", "Lkotlin/Function1;", "-forEachTag", "internalNextLengthDelimited", "internalReadVarint32", "nextFieldMinLengthInBytes", "nextLengthDelimited", "nextTag", "peekFieldEncoding", "readBytes", "readFixed32", "readFixed64", "readString", "", "readUnknownField", "readVarint32", "readVarint64", "skip", "skipGroup", "expectedEndTag", "Companion", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ProtoReader {
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    public static final int TAG_FIELD_ENCODING_BITS = 3;
    private final List<Buffer> bufferStack;
    private long limit;
    private FieldEncoding nextFieldEncoding;
    private long pos;
    private long pushedLimit;
    private int recursionDepth;
    private final BufferedSource source;
    private int state;
    private int tag;

    /* JADX INFO: compiled from: ProtoReader.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FieldEncoding.values().length];
            try {
                iArr[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FieldEncoding.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FieldEncoding.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FieldEncoding.VARINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ProtoReader(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, Constants.ScionAnalytics.PARAM_SOURCE);
        this.source = bufferedSource;
        this.limit = Long.MAX_VALUE;
        this.state = 2;
        this.tag = -1;
        this.pushedLimit = -1L;
        this.bufferStack = new ArrayList();
    }

    public final long beginMessage() throws IOException {
        if (this.state != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()".toString());
        }
        int i = this.recursionDepth + 1;
        this.recursionDepth = i;
        if (i > RECURSION_LIMIT) {
            throw new IOException("Wire recursion limit exceeded");
        }
        if (i > this.bufferStack.size()) {
            this.bufferStack.add(new Buffer());
        }
        long j = this.pushedLimit;
        this.pushedLimit = -1L;
        this.state = 6;
        return j;
    }

    public final ByteString endMessageAndGetUnknownFields(long token) throws IOException {
        if (this.state != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()".toString());
        }
        int i = this.recursionDepth - 1;
        this.recursionDepth = i;
        if (i < 0 || this.pushedLimit != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()".toString());
        }
        if (this.pos != this.limit && i != 0) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        }
        this.limit = token;
        Buffer buffer = this.bufferStack.get(i);
        if (buffer.size() > 0) {
            return buffer.readByteString();
        }
        return ByteString.EMPTY;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "prefer endMessageAndGetUnknownFields()", replaceWith = @ReplaceWith(expression = "endMessageAndGetUnknownFields(token)", imports = {}))
    public final void endMessage(long token) throws IOException {
        endMessageAndGetUnknownFields(token);
    }

    public final int nextLengthDelimited() throws IOException {
        int i = this.state;
        if (i == 6 || i == 2) {
            return internalNextLengthDelimited();
        }
        throw new IllegalStateException("Unexpected call to nextDelimited()".toString());
    }

    private final int internalNextLengthDelimited() throws ProtocolException, EOFException {
        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        this.state = 2;
        int iInternalReadVarint32 = internalReadVarint32();
        if (iInternalReadVarint32 < 0) {
            throw new ProtocolException("Negative length: " + iInternalReadVarint32);
        }
        if (this.pushedLimit != -1) {
            throw new IllegalStateException();
        }
        long j = this.limit;
        this.pushedLimit = j;
        long j2 = this.pos + ((long) iInternalReadVarint32);
        this.limit = j2;
        if (j2 <= j) {
            return iInternalReadVarint32;
        }
        throw new EOFException();
    }

    public final int nextTag() throws IOException {
        int i = this.state;
        if (i == 7) {
            this.state = 2;
            return this.tag;
        }
        if (i != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        while (this.pos < this.limit && !this.source.exhausted()) {
            int iInternalReadVarint32 = internalReadVarint32();
            if (iInternalReadVarint32 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = iInternalReadVarint32 >> 3;
            this.tag = i2;
            int i3 = iInternalReadVarint32 & 7;
            if (i3 == 0) {
                this.nextFieldEncoding = FieldEncoding.VARINT;
                this.state = 0;
                return this.tag;
            }
            if (i3 == 1) {
                this.nextFieldEncoding = FieldEncoding.FIXED64;
                this.state = 1;
                return this.tag;
            }
            if (i3 == 2) {
                internalNextLengthDelimited();
                return this.tag;
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    throw new ProtocolException("Unexpected end group");
                }
                if (i3 == 5) {
                    this.nextFieldEncoding = FieldEncoding.FIXED32;
                    this.state = 5;
                    return this.tag;
                }
                throw new ProtocolException("Unexpected field encoding: " + i3);
            }
            skipGroup(i2);
        }
        return -1;
    }

    /* JADX INFO: renamed from: peekFieldEncoding, reason: from getter */
    public final FieldEncoding getNextFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public final void skip() throws IOException {
        int i = this.state;
        if (i == 0) {
            readVarint64();
            return;
        }
        if (i == 1) {
            readFixed64();
            return;
        }
        if (i == 2) {
            this.source.skip(beforeLengthDelimitedScalar());
        } else {
            if (i == 5) {
                readFixed32();
                return;
            }
            throw new IllegalStateException("Unexpected call to skip()");
        }
    }

    private final void skipGroup(int expectedEndTag) throws IOException {
        while (this.pos < this.limit && !this.source.exhausted()) {
            int iInternalReadVarint32 = internalReadVarint32();
            if (iInternalReadVarint32 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i = iInternalReadVarint32 >> 3;
            int i2 = iInternalReadVarint32 & 7;
            if (i2 == 0) {
                this.state = 0;
                readVarint64();
            } else if (i2 == 1) {
                this.state = 1;
                readFixed64();
            } else if (i2 == 2) {
                long jInternalReadVarint32 = internalReadVarint32();
                this.pos += jInternalReadVarint32;
                this.source.skip(jInternalReadVarint32);
            } else if (i2 == 3) {
                skipGroup(i);
            } else if (i2 == 4) {
                if (i != expectedEndTag) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i2 == 5) {
                this.state = 5;
                readFixed32();
            } else {
                throw new ProtocolException("Unexpected field encoding: " + i2);
            }
        }
        throw new EOFException();
    }

    public final ByteString readBytes() throws IOException {
        long jBeforeLengthDelimitedScalar = beforeLengthDelimitedScalar();
        this.source.require(jBeforeLengthDelimitedScalar);
        return this.source.readByteString(jBeforeLengthDelimitedScalar);
    }

    public final boolean beforePossiblyPackedScalar$wire_runtime() throws ProtocolException {
        int i = this.state;
        if (i != 0 && i != 1) {
            if (i == 2) {
                if (this.pos < this.limit) {
                    return true;
                }
                this.limit = this.pushedLimit;
                this.pushedLimit = -1L;
                this.state = 6;
                return false;
            }
            if (i != 5) {
                throw new ProtocolException("unexpected state: " + this.state);
            }
        }
        return true;
    }

    public final String readString() throws IOException {
        long jBeforeLengthDelimitedScalar = beforeLengthDelimitedScalar();
        this.source.require(jBeforeLengthDelimitedScalar);
        return this.source.readUtf8(jBeforeLengthDelimitedScalar);
    }

    public final int readVarint32() throws IOException {
        int i = this.state;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        int iInternalReadVarint32 = internalReadVarint32();
        afterPackableScalar(0);
        return iInternalReadVarint32;
    }

    private final int internalReadVarint32() throws ProtocolException {
        int i;
        this.source.require(1L);
        this.pos++;
        byte b = this.source.readByte();
        if (b >= 0) {
            return b;
        }
        int i2 = b & 127;
        this.source.require(1L);
        this.pos++;
        byte b2 = this.source.readByte();
        if (b2 >= 0) {
            i = b2 << 7;
        } else {
            i2 |= (b2 & 127) << 7;
            this.source.require(1L);
            this.pos++;
            byte b3 = this.source.readByte();
            if (b3 >= 0) {
                i = b3 << 14;
            } else {
                i2 |= (b3 & 127) << 14;
                this.source.require(1L);
                this.pos++;
                byte b4 = this.source.readByte();
                if (b4 < 0) {
                    int i3 = i2 | ((b4 & 127) << 21);
                    this.source.require(1L);
                    this.pos++;
                    byte b5 = this.source.readByte();
                    int i4 = i3 | (b5 << 28);
                    if (b5 < 0) {
                        for (int i5 = 0; i5 < 5; i5++) {
                            this.source.require(1L);
                            this.pos++;
                            if (this.source.readByte() < 0) {
                            }
                        }
                        throw new ProtocolException("Malformed VARINT");
                    }
                    return i4;
                }
                i = b4 << 21;
            }
        }
        return i | i2;
    }

    public final long readVarint64() throws IOException {
        int i = this.state;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            this.source.require(1L);
            this.pos++;
            byte b = this.source.readByte();
            j |= ((long) (b & 127)) << i2;
            if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                afterPackableScalar(0);
                return j;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public final int readFixed32() throws IOException {
        int i = this.state;
        if (i != 5 && i != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(4L);
        this.pos += (long) 4;
        int intLe = this.source.readIntLe();
        afterPackableScalar(5);
        return intLe;
    }

    public final long readFixed64() throws IOException {
        int i = this.state;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(8L);
        this.pos += (long) 8;
        long longLe = this.source.readLongLe();
        afterPackableScalar(1);
        return longLe;
    }

    private final void afterPackableScalar(int fieldEncoding) throws IOException {
        if (this.state == fieldEncoding) {
            this.state = 6;
            return;
        }
        long j = this.pos;
        long j2 = this.limit;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        }
        if (j == j2) {
            this.limit = this.pushedLimit;
            this.pushedLimit = -1L;
            this.state = 6;
            return;
        }
        this.state = 7;
    }

    private final long beforeLengthDelimitedScalar() throws IOException {
        if (this.state != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
        }
        long j = this.limit - this.pos;
        this.source.require(j);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1L;
        return j;
    }

    /* JADX INFO: renamed from: -forEachTag, reason: not valid java name */
    public final ByteString m2209forEachTag(Function1<? super Integer, ? extends Object> tagHandler) throws IOException {
        Intrinsics.checkNotNullParameter(tagHandler, "tagHandler");
        long jBeginMessage = beginMessage();
        while (true) {
            int iNextTag = nextTag();
            if (iNextTag != -1) {
                tagHandler.invoke(Integer.valueOf(iNextTag));
            } else {
                return endMessageAndGetUnknownFields(jBeginMessage);
            }
        }
    }

    public final void readUnknownField(int tag) {
        FieldEncoding nextFieldEncoding = getNextFieldEncoding();
        Intrinsics.checkNotNull(nextFieldEncoding);
        addUnknownField(tag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(this));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final void addUnknownField(int tag, FieldEncoding fieldEncoding, Object value) throws NoWhenBranchMatchedException, IOException {
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        ProtoWriter protoWriter = new ProtoWriter(this.bufferStack.get(this.recursionDepth - 1));
        ProtoAdapter<?> protoAdapterRawProtoAdapter = fieldEncoding.rawProtoAdapter();
        Intrinsics.checkNotNull(protoAdapterRawProtoAdapter, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
        protoAdapterRawProtoAdapter.encodeWithTag(protoWriter, tag, value);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final long nextFieldMinLengthInBytes() throws NoWhenBranchMatchedException {
        FieldEncoding fieldEncoding = this.nextFieldEncoding;
        int i = fieldEncoding == null ? -1 : WhenMappings.$EnumSwitchMapping$0[fieldEncoding.ordinal()];
        if (i == -1) {
            throw new IllegalStateException("nextFieldEncoding is not set");
        }
        if (i == 1) {
            return this.limit - this.pos;
        }
        if (i == 2) {
            return 4L;
        }
        if (i == 3) {
            return 8L;
        }
        if (i == 4) {
            return 1L;
        }
        throw new NoWhenBranchMatchedException();
    }
}
