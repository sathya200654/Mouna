package com.squareup.wire.internal;

import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: IntArrayList.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/squareup/wire/internal/IntArrayList;", "", "initialCapacity", "", "(I)V", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "size", "add", "", "int", "ensureCapacity", "minCapacity", "isNotEmpty", "", "toArray", "toString", "", "Companion", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IntArrayList {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int[] data;
    private int size;

    public IntArrayList(int i) {
        this.data = new int[i];
    }

    public final int[] toArray() {
        int i = this.size;
        int[] iArr = this.data;
        if (i < iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.data = iArrCopyOf;
        }
        return this.data;
    }

    public final void add(int i) {
        ensureCapacity(this.size + 1);
        int[] iArr = this.data;
        int i2 = this.size;
        this.size = i2 + 1;
        iArr[i2] = i;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    private final void ensureCapacity(int minCapacity) {
        int[] iArr = this.data;
        if (minCapacity > iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, Math.max(((iArr.length * 3) / 2) + 1, minCapacity));
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.data = iArrCopyOf;
        }
    }

    public String toString() {
        int[] iArrCopyOf = Arrays.copyOf(this.data, this.size);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        String string = Arrays.toString(iArrCopyOf);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: IntArrayList.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/squareup/wire/internal/IntArrayList$Companion;", "", "()V", "forDecoding", "Lcom/squareup/wire/internal/IntArrayList;", "minLengthInBytes", "", "minimumElementByteSize", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IntArrayList forDecoding(long minLengthInBytes, long minimumElementByteSize) {
            return new IntArrayList((int) RangesKt.coerceAtMost(minLengthInBytes / minimumElementByteSize, 2147483647L));
        }
    }
}
