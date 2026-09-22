package com.azure.core.implementation;

import com.azure.core.util.ProgressReporter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ByteCountingWritableByteChannel implements WritableByteChannel {
    private static final AtomicLongFieldUpdater<ByteCountingWritableByteChannel> BYTES_WRITTEN_ATOMIC_UPDATER = AtomicLongFieldUpdater.newUpdater(ByteCountingWritableByteChannel.class, "bytesWritten");
    private volatile long bytesWritten;
    private final WritableByteChannel channel;
    private final ProgressReporter progressReporter;

    public ByteCountingWritableByteChannel(WritableByteChannel writableByteChannel, ProgressReporter progressReporter) {
        this.channel = (WritableByteChannel) Objects.requireNonNull(writableByteChannel, "'channel' must not be null");
        this.progressReporter = progressReporter;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        int iWrite = this.channel.write(byteBuffer);
        long j = iWrite;
        BYTES_WRITTEN_ATOMIC_UPDATER.addAndGet(this, j);
        ProgressReporter progressReporter = this.progressReporter;
        if (progressReporter != null) {
            progressReporter.reportProgress(j);
        }
        return iWrite;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.channel.isOpen();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    public long getBytesWritten() {
        return BYTES_WRITTEN_ATOMIC_UPDATER.get(this);
    }
}
