package io.grpc.internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface WritableBuffer {
    int readableBytes();

    void release();

    int writableBytes();

    void write(byte b);

    void write(byte[] bArr, int i, int i2);
}
