package com.azure.core.implementation.http.rest;

import com.azure.core.exception.UnexpectedLengthException;
import com.azure.core.util.logging.ClientLogger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class LengthValidatingInputStream extends InputStream {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) LengthValidatingInputStream.class);
    private final long expectedReadSize;
    private final InputStream inner;
    private long mark = -1;
    private long position;

    LengthValidatingInputStream(InputStream inputStream, long j) {
        this.inner = (InputStream) Objects.requireNonNull(inputStream, "'inputStream' cannot be null.");
        if (j < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'expectedReadSize' cannot be less than 0."));
        }
        this.expectedReadSize = j;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        i3 = 0;
        do {
            int i4 = this.inner.read(bArr, i + i3, i2 - i3);
            validateLength(i4);
            if (i4 != -1) {
                i3 += i4;
            } else if (i3 == 0) {
                i3 = -1;
            }
            if (i4 == -1) {
                break;
            }
        } while (i3 != i2);
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        long jSkip;
        jSkip = this.inner.skip(j);
        this.position += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.inner.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inner.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.inner.mark(i);
        this.mark = this.position;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.inner.reset();
        this.position = this.mark;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.inner.markSupported();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i;
        i = this.inner.read();
        int i2 = -1;
        if (i != -1) {
            i2 = 1;
        }
        validateLength(i2);
        return i;
    }

    private void validateLength(int i) {
        if (i == -1) {
            long j = this.position;
            long j2 = this.expectedReadSize;
            if (j > j2) {
                throw LOGGER.logExceptionAsError(new UnexpectedLengthException(String.format(RestProxyUtils.BODY_TOO_LARGE, Long.valueOf(this.position), Long.valueOf(this.expectedReadSize)), this.position, this.expectedReadSize));
            }
            if (j < j2) {
                throw LOGGER.logExceptionAsError(new UnexpectedLengthException(String.format(RestProxyUtils.BODY_TOO_SMALL, Long.valueOf(this.position), Long.valueOf(this.expectedReadSize)), this.position, this.expectedReadSize));
            }
            return;
        }
        this.position += (long) i;
    }
}
