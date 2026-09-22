package com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class BigSignificand {
    private static final long LONG_MASK = 4294967295L;
    private int firstNonZeroInt;
    private final int numInts;
    private final int[] x;

    public BigSignificand(long j) {
        if (j <= 0 || j >= 2147483647L) {
            throw new IllegalArgumentException("numBits=" + j);
        }
        int i = (((int) ((j + 63) >>> 6)) + 1) << 1;
        this.numInts = i;
        this.x = new int[i];
        this.firstNonZeroInt = i;
    }

    public void add(int i) {
        if (i == 0) {
            return;
        }
        long j = ((long) i) & LONG_MASK;
        int i2 = this.numInts;
        while (true) {
            i2--;
            if (j != 0) {
                long jX = (((long) x(i2)) & LONG_MASK) + j;
                x(i2, (int) jX);
                j = jX >>> 32;
            } else {
                this.firstNonZeroInt = Math.min(this.firstNonZeroInt, i2 + 1);
                return;
            }
        }
    }

    public void fma(int i, int i2) {
        long j = ((long) i) & LONG_MASK;
        long j2 = i2;
        int i3 = this.numInts;
        while (true) {
            i3--;
            if (i3 < this.firstNonZeroInt) {
                break;
            }
            long jX = ((((long) x(i3)) & LONG_MASK) * j) + j2;
            x(i3, (int) jX);
            j2 = jX >>> 32;
        }
        if (j2 != 0) {
            x(i3, (int) j2);
            this.firstNonZeroInt = i3;
        }
    }

    public BigInteger toBigInteger() {
        byte[] bArr = new byte[this.x.length << 2];
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).asIntBuffer();
        int i = 0;
        while (true) {
            int[] iArr = this.x;
            if (i < iArr.length) {
                intBufferAsIntBuffer.put(i, iArr[i]);
                i++;
            } else {
                return new BigInteger(bArr);
            }
        }
    }

    private void x(int i, int i2) {
        this.x[i] = i2;
    }

    private int x(int i) {
        return this.x[i];
    }
}
