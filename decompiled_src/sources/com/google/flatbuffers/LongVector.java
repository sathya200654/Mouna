package com.google.flatbuffers;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class LongVector extends BaseVector {
    public LongVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 8, byteBuffer);
        return this;
    }

    public long get(int i) {
        return this.bb.getLong(__element(i));
    }
}
