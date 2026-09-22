package com.azure.core.implementation;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class AccessibleByteArrayOutputStream extends ByteArrayOutputStream {
    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public AccessibleByteArrayOutputStream() {
    }

    public AccessibleByteArrayOutputStream(int i) {
        super(i);
    }

    @Override // java.io.ByteArrayOutputStream
    public byte[] toByteArray() {
        return Arrays.copyOf(this.buf, this.count);
    }

    public byte[] toByteArray(int i, int i2) {
        if (i < 0 || i2 >= this.count || i > i2) {
            throw new IndexOutOfBoundsException("start: " + i + ", end: " + i2 + ", count: " + this.count);
        }
        return Arrays.copyOfRange(this.buf, i, i2);
    }

    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(this.buf, 0, this.count).asReadOnlyBuffer();
    }

    public int count() {
        return this.count;
    }

    @Override // java.io.ByteArrayOutputStream
    public String toString(Charset charset) {
        return new String(this.buf, 0, this.count, charset);
    }

    public String bomAwareToString(String str) {
        return ImplUtils.bomAwareToString(this.buf, 0, this.count, str);
    }
}
