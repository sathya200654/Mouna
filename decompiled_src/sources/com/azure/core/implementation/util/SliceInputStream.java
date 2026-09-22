package com.azure.core.implementation.util;

import com.azure.core.util.logging.ClientLogger;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SliceInputStream extends InputStream {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) SliceInputStream.class);
    private final long endOfSlice;
    private final InputStream innerStream;
    private final long startOfSlice;
    private long innerPosition = 0;
    private long mark = -1;

    public SliceInputStream(InputStream inputStream, long j, long j2) {
        this.innerStream = (InputStream) Objects.requireNonNull(inputStream, "'inputStream' cannot be null");
        if (j < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'position' cannot be negative"));
        }
        if (j2 < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'count' cannot be negative"));
        }
        this.startOfSlice = j;
        this.endOfSlice = j + j2;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (ensureInWindow() < 0) {
            return 0L;
        }
        long j2 = this.innerPosition;
        long j3 = this.endOfSlice;
        if (j2 > j3) {
            return 0L;
        }
        long jSkip = this.innerStream.skip(Math.min(j, Math.max(0L, j3 - j2)));
        this.innerPosition += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (ensureInWindow() < 0) {
            return -1;
        }
        int i = this.innerStream.read();
        if (i >= 0) {
            this.innerPosition++;
        }
        return i;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        if (ensureInWindow() < 0) {
            return -1;
        }
        int i3 = this.innerStream.read(bArr, i, i2);
        if (i3 > 0) {
            long j = i3;
            long j2 = this.innerPosition + j;
            this.innerPosition = j2;
            long j3 = this.endOfSlice;
            if (j2 > j3) {
                return (int) (j - (j2 - j3));
            }
        }
        return i3;
    }

    private long ensureInWindow() throws IOException {
        long j = this.startOfSlice;
        long j2 = this.endOfSlice;
        if (j == j2 || this.innerPosition >= j2) {
            return -1L;
        }
        long j3 = 0;
        while (true) {
            long j4 = this.innerPosition;
            long j5 = this.startOfSlice;
            if (j4 >= j5) {
                return j3;
            }
            long jSkip = this.innerStream.skip(j5 - j4);
            j3 += jSkip;
            this.innerPosition += jSkip;
            if (jSkip == 0) {
                if (this.innerStream.read() < 0) {
                    return -1L;
                }
                j3++;
                this.innerPosition++;
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.innerStream.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.innerStream.markSupported();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        try {
            ensureInWindow();
            this.innerStream.mark(i);
            this.mark = this.innerPosition;
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.innerStream.reset();
        this.innerPosition = this.mark;
    }
}
