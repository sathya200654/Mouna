package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FieldEncoding.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/squareup/wire/FieldEncoding;", "", "value", "", "(Ljava/lang/String;II)V", "getValue$wire_runtime", "()I", "rawProtoAdapter", "Lcom/squareup/wire/ProtoAdapter;", "VARINT", "FIXED64", "LENGTH_DELIMITED", "FIXED32", "Companion", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);

    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: FieldEncoding.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FieldEncoding.values().length];
            try {
                iArr[FieldEncoding.VARINT.ordinal()] = 1;
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
                iArr[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<FieldEncoding> getEntries() {
        return $ENTRIES;
    }

    FieldEncoding(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: getValue$wire_runtime, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final ProtoAdapter<?> rawProtoAdapter() throws NoWhenBranchMatchedException {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return ProtoAdapter.UINT64;
        }
        if (i == 2) {
            return ProtoAdapter.FIXED32;
        }
        if (i == 3) {
            return ProtoAdapter.FIXED64;
        }
        if (i == 4) {
            return ProtoAdapter.BYTES;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: FieldEncoding.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0081\u0002¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/squareup/wire/FieldEncoding$Companion;", "", "()V", "get", "Lcom/squareup/wire/FieldEncoding;", "value", "", "get$wire_runtime", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FieldEncoding get$wire_runtime(int value) throws IOException {
            if (value == 0) {
                return FieldEncoding.VARINT;
            }
            if (value == 1) {
                return FieldEncoding.FIXED64;
            }
            if (value == 2) {
                return FieldEncoding.LENGTH_DELIMITED;
            }
            if (value == 5) {
                return FieldEncoding.FIXED32;
            }
            throw new ProtocolException("Unexpected FieldEncoding: " + value);
        }
    }
}
