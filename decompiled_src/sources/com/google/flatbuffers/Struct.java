package com.google.flatbuffers;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class Struct {
    protected ByteBuffer bb;
    protected int bb_pos;

    protected void __reset(int i, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer != null) {
            this.bb_pos = i;
        } else {
            this.bb_pos = 0;
        }
    }

    public void __reset() {
        __reset(0, null);
    }
}
