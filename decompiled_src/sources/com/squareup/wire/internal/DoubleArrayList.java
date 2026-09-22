package com.squareup.wire.internal;

import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DoubleArrayList.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/squareup/wire/internal/DoubleArrayList;", "", "initialCapacity", "", "(I)V", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "size", "add", "", "double", "", "ensureCapacity", "minCapacity", "isNotEmpty", "", "toArray", "toString", "", "Companion", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DoubleArrayList {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private double[] data;
    private int size;

    public DoubleArrayList(int i) {
        this.data = new double[i];
    }

    public final double[] toArray() {
        int i = this.size;
        double[] dArr = this.data;
        if (i < dArr.length) {
            double[] dArrCopyOf = Arrays.copyOf(dArr, i);
            Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
            this.data = dArrCopyOf;
        }
        return this.data;
    }

    public final void add(double d) {
        ensureCapacity(this.size + 1);
        double[] dArr = this.data;
        int i = this.size;
        this.size = i + 1;
        dArr[i] = d;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    private final void ensureCapacity(int minCapacity) {
        double[] dArr = this.data;
        if (minCapacity > dArr.length) {
            double[] dArrCopyOf = Arrays.copyOf(dArr, Math.max(((dArr.length * 3) / 2) + 1, minCapacity));
            Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
            this.data = dArrCopyOf;
        }
    }

    public String toString() {
        double[] dArrCopyOf = Arrays.copyOf(this.data, this.size);
        Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
        String string = Arrays.toString(dArrCopyOf);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: DoubleArrayList.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/squareup/wire/internal/DoubleArrayList$Companion;", "", "()V", "forDecoding", "Lcom/squareup/wire/internal/DoubleArrayList;", "minLengthInBytes", "", "minimumElementByteSize", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DoubleArrayList forDecoding(long minLengthInBytes, long minimumElementByteSize) {
            return new DoubleArrayList((int) RangesKt.coerceAtMost(minLengthInBytes / minimumElementByteSize, 2147483647L));
        }
    }
}
