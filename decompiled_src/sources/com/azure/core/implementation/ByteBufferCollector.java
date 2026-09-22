package com.azure.core.implementation;

import com.azure.core.util.logging.ClientLogger;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ByteBufferCollector {
    private static final int DEFAULT_INITIAL_SIZE = 1024;
    private static final String INVALID_INITIAL_SIZE = "'initialSize' cannot be less than 0.";
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ByteBufferCollector.class);
    private static final String REQUESTED_BUFFER_INVALID = "Required capacity is greater than Integer.MAX_VALUE.";
    private byte[] buffer;
    private int position;

    public ByteBufferCollector() {
        this(1024);
    }

    public ByteBufferCollector(int i) {
        if (i < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(INVALID_INITIAL_SIZE));
        }
        this.buffer = new byte[i];
        this.position = 0;
    }

    public void write(ByteBuffer byteBuffer) {
        int iRemaining;
        if (byteBuffer == null || (iRemaining = byteBuffer.remaining()) == 0) {
            return;
        }
        ensureCapacity(iRemaining);
        byteBuffer.get(this.buffer, this.position, iRemaining);
        this.position += iRemaining;
    }

    public byte[] toByteArray() {
        byte[] bArr = this.buffer;
        int length = bArr.length;
        int i = this.position;
        return length == i ? bArr : Arrays.copyOf(bArr, i);
    }

    private void ensureCapacity(int i) {
        byte[] bArr = this.buffer;
        int length = bArr.length;
        int i2 = this.position;
        int i3 = i2 + i;
        if (((i ^ i3) & (i2 ^ i3)) < 0) {
            throw LOGGER.logExceptionAsError(new IllegalStateException(REQUESTED_BUFFER_INVALID));
        }
        if (length >= i3) {
            return;
        }
        int i4 = length << 1;
        if (i4 - i3 >= 0) {
            i3 = i4;
        }
        if (i3 < 0) {
            i3 = 2147483639;
        }
        this.buffer = Arrays.copyOf(bArr, i3);
    }
}
