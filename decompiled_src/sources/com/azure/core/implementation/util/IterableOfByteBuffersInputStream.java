package com.azure.core.implementation.util;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class IterableOfByteBuffersInputStream extends InputStream {
    private final Iterator<ByteBuffer> buffers;
    private ByteBuffer currentBuffer;

    public IterableOfByteBuffersInputStream(Iterable<ByteBuffer> iterable) {
        Objects.requireNonNull(iterable, "'buffers' must not be null");
        this.buffers = iterable.iterator();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        ByteBuffer currentBuffer = getCurrentBuffer();
        if (currentBuffer == null) {
            return -1;
        }
        return currentBuffer.get() & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        ByteBuffer currentBuffer = getCurrentBuffer();
        if (currentBuffer == null) {
            return -1;
        }
        int i3 = 0;
        while (i2 > 0 && currentBuffer != null) {
            int iMin = Math.min(currentBuffer.remaining(), i2);
            currentBuffer.get(bArr, i, iMin);
            i3 += iMin;
            i += iMin;
            i2 -= iMin;
            currentBuffer = getCurrentBuffer();
        }
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        ByteBuffer currentBuffer = getCurrentBuffer();
        if (currentBuffer == null) {
            return 0;
        }
        return currentBuffer.remaining();
    }

    private ByteBuffer getCurrentBuffer() {
        ByteBuffer byteBuffer = this.currentBuffer;
        if (byteBuffer != null && byteBuffer.hasRemaining()) {
            return this.currentBuffer;
        }
        while (this.buffers.hasNext()) {
            ByteBuffer next = this.buffers.next();
            if (next.hasRemaining()) {
                ByteBuffer byteBufferDuplicate = next.duplicate();
                this.currentBuffer = byteBufferDuplicate;
                return byteBufferDuplicate;
            }
        }
        return null;
    }
}
