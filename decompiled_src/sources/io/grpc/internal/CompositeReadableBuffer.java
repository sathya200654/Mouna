package io.grpc.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class CompositeReadableBuffer extends AbstractReadableBuffer {
    private final Queue<ReadableBuffer> buffers;
    private boolean marked;
    private final Deque<ReadableBuffer> readableBuffers;
    private int readableBytes;
    private Deque<ReadableBuffer> rewindableBuffers;
    private static final NoThrowReadOperation<Void> UBYTE_OP = new NoThrowReadOperation<Void>() { // from class: io.grpc.internal.CompositeReadableBuffer.1
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i, Void r3, int i2) {
            return readableBuffer.readUnsignedByte();
        }
    };
    private static final NoThrowReadOperation<Void> SKIP_OP = new NoThrowReadOperation<Void>() { // from class: io.grpc.internal.CompositeReadableBuffer.2
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i, Void r3, int i2) {
            readableBuffer.skipBytes(i);
            return 0;
        }
    };
    private static final NoThrowReadOperation<byte[]> BYTE_ARRAY_OP = new NoThrowReadOperation<byte[]>() { // from class: io.grpc.internal.CompositeReadableBuffer.3
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i, byte[] bArr, int i2) {
            readableBuffer.readBytes(bArr, i2, i);
            return i2 + i;
        }
    };
    private static final NoThrowReadOperation<ByteBuffer> BYTE_BUF_OP = new NoThrowReadOperation<ByteBuffer>() { // from class: io.grpc.internal.CompositeReadableBuffer.4
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i, ByteBuffer byteBuffer, int i2) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i);
            readableBuffer.readBytes(byteBuffer);
            byteBuffer.limit(iLimit);
            return 0;
        }
    };
    private static final ReadOperation<OutputStream> STREAM_OP = new ReadOperation<OutputStream>() { // from class: io.grpc.internal.CompositeReadableBuffer.5
        @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i, OutputStream outputStream, int i2) throws IOException {
            readableBuffer.readBytes(outputStream, i);
            return 0;
        }
    };

    private interface NoThrowReadOperation<T> extends ReadOperation<T> {
        @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
        int read(ReadableBuffer readableBuffer, int i, T t, int i2);
    }

    private interface ReadOperation<T> {
        int read(ReadableBuffer readableBuffer, int i, T t, int i2) throws IOException;
    }

    public CompositeReadableBuffer(int i) {
        this.buffers = new ArrayDeque(2);
        this.readableBuffers = new ArrayDeque(i);
    }

    public CompositeReadableBuffer() {
        this.buffers = new ArrayDeque(2);
        this.readableBuffers = new ArrayDeque();
    }

    public void addBuffer(ReadableBuffer readableBuffer) {
        boolean z = this.marked && this.readableBuffers.isEmpty();
        enqueueBuffer(readableBuffer);
        if (z) {
            this.readableBuffers.peek().mark();
        }
    }

    private void enqueueBuffer(ReadableBuffer readableBuffer) {
        if (!(readableBuffer instanceof CompositeReadableBuffer)) {
            this.readableBuffers.add(readableBuffer);
            this.readableBytes += readableBuffer.readableBytes();
            return;
        }
        CompositeReadableBuffer compositeReadableBuffer = (CompositeReadableBuffer) readableBuffer;
        while (!compositeReadableBuffer.readableBuffers.isEmpty()) {
            this.readableBuffers.add(compositeReadableBuffer.readableBuffers.remove());
        }
        this.readableBytes += compositeReadableBuffer.readableBytes;
        compositeReadableBuffer.readableBytes = 0;
        compositeReadableBuffer.close();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return this.readableBytes;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        return executeNoThrow(UBYTE_OP, 1, null, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int i) {
        executeNoThrow(SKIP_OP, i, null, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(byte[] bArr, int i, int i2) {
        executeNoThrow(BYTE_ARRAY_OP, i2, bArr, i);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(ByteBuffer byteBuffer) {
        executeNoThrow(BYTE_BUF_OP, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(OutputStream outputStream, int i) throws IOException {
        execute(STREAM_OP, i, outputStream, 0);
    }

    public void readBytes(CompositeReadableBuffer compositeReadableBuffer, int i) {
        checkReadable(i);
        this.readableBytes -= i;
        while (i > 0) {
            ReadableBuffer readableBufferPeek = this.buffers.peek();
            if (readableBufferPeek.readableBytes() > i) {
                compositeReadableBuffer.addBuffer(readableBufferPeek.readBytes(i));
                i = 0;
            } else {
                compositeReadableBuffer.addBuffer(this.buffers.poll());
                i -= readableBufferPeek.readableBytes();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [io.grpc.internal.ReadableBuffer] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [io.grpc.internal.ReadableBuffer] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [io.grpc.internal.CompositeReadableBuffer] */
    /* JADX WARN: Type inference failed for: r1v3, types: [io.grpc.internal.CompositeReadableBuffer] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // io.grpc.internal.ReadableBuffer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.grpc.internal.ReadableBuffer readBytes(int r7) {
        /*
            r6 = this;
            if (r7 > 0) goto L7
            io.grpc.internal.ReadableBuffer r6 = io.grpc.internal.ReadableBuffers.empty()
            return r6
        L7:
            r6.checkReadable(r7)
            int r0 = r6.readableBytes
            int r0 = r0 - r7
            r6.readableBytes = r0
            r0 = 0
            r1 = r0
        L11:
            java.util.Deque<io.grpc.internal.ReadableBuffer> r2 = r6.readableBuffers
            java.lang.Object r2 = r2.peek()
            io.grpc.internal.ReadableBuffer r2 = (io.grpc.internal.ReadableBuffer) r2
            int r3 = r2.readableBytes()
            if (r3 <= r7) goto L25
            io.grpc.internal.ReadableBuffer r7 = r2.readBytes(r7)
            r2 = 0
            goto L3d
        L25:
            boolean r4 = r6.marked
            if (r4 == 0) goto L31
            io.grpc.internal.ReadableBuffer r2 = r2.readBytes(r3)
            r6.advanceBuffer()
            goto L39
        L31:
            java.util.Deque<io.grpc.internal.ReadableBuffer> r2 = r6.readableBuffers
            java.lang.Object r2 = r2.poll()
            io.grpc.internal.ReadableBuffer r2 = (io.grpc.internal.ReadableBuffer) r2
        L39:
            int r7 = r7 - r3
            r5 = r2
            r2 = r7
            r7 = r5
        L3d:
            if (r0 != 0) goto L41
            r0 = r7
            goto L60
        L41:
            if (r1 != 0) goto L5d
            io.grpc.internal.CompositeReadableBuffer r1 = new io.grpc.internal.CompositeReadableBuffer
            r3 = 2
            if (r2 != 0) goto L49
            goto L56
        L49:
            java.util.Deque<io.grpc.internal.ReadableBuffer> r4 = r6.readableBuffers
            int r4 = r4.size()
            int r4 = r4 + r3
            r3 = 16
            int r3 = java.lang.Math.min(r4, r3)
        L56:
            r1.<init>(r3)
            r1.addBuffer(r0)
            r0 = r1
        L5d:
            r1.addBuffer(r7)
        L60:
            if (r2 > 0) goto L63
            return r0
        L63:
            r7 = r2
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.CompositeReadableBuffer.readBytes(int):io.grpc.internal.ReadableBuffer");
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public boolean markSupported() {
        Iterator<ReadableBuffer> it = this.readableBuffers.iterator();
        while (it.hasNext()) {
            if (!it.next().markSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public void mark() {
        if (this.rewindableBuffers == null) {
            this.rewindableBuffers = new ArrayDeque(Math.min(this.readableBuffers.size(), 16));
        }
        while (!this.rewindableBuffers.isEmpty()) {
            this.rewindableBuffers.remove().close();
        }
        this.marked = true;
        ReadableBuffer readableBufferPeek = this.readableBuffers.peek();
        if (readableBufferPeek != null) {
            readableBufferPeek.mark();
        }
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public void reset() {
        if (!this.marked) {
            throw new InvalidMarkException();
        }
        ReadableBuffer readableBufferPeek = this.readableBuffers.peek();
        if (readableBufferPeek != null) {
            int i = readableBufferPeek.readableBytes();
            readableBufferPeek.reset();
            this.readableBytes += readableBufferPeek.readableBytes() - i;
        }
        while (true) {
            ReadableBuffer readableBufferPollLast = this.rewindableBuffers.pollLast();
            if (readableBufferPollLast == null) {
                return;
            }
            readableBufferPollLast.reset();
            this.readableBuffers.addFirst(readableBufferPollLast);
            this.readableBytes += readableBufferPollLast.readableBytes();
        }
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public boolean byteBufferSupported() {
        Iterator<ReadableBuffer> it = this.readableBuffers.iterator();
        while (it.hasNext()) {
            if (!it.next().byteBufferSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    @Nullable
    public ByteBuffer getByteBuffer() {
        if (this.readableBuffers.isEmpty()) {
            return null;
        }
        return this.readableBuffers.peek().getByteBuffer();
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.readableBuffers.isEmpty()) {
            this.readableBuffers.remove().close();
        }
        if (this.rewindableBuffers != null) {
            while (!this.rewindableBuffers.isEmpty()) {
                this.rewindableBuffers.remove().close();
            }
        }
    }

    private <T> int execute(ReadOperation<T> readOperation, int i, T t, int i2) throws IOException {
        checkReadable(i);
        if (!this.readableBuffers.isEmpty()) {
            advanceBufferIfNecessary();
        }
        while (i > 0 && !this.readableBuffers.isEmpty()) {
            ReadableBuffer readableBufferPeek = this.readableBuffers.peek();
            int iMin = Math.min(i, readableBufferPeek.readableBytes());
            i2 = readOperation.read(readableBufferPeek, iMin, t, i2);
            i -= iMin;
            this.readableBytes -= iMin;
            advanceBufferIfNecessary();
        }
        if (i <= 0) {
            return i2;
        }
        throw new AssertionError("Failed executing read operation");
    }

    private <T> int executeNoThrow(NoThrowReadOperation<T> noThrowReadOperation, int i, T t, int i2) {
        try {
            return execute(noThrowReadOperation, i, t, i2);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private void advanceBufferIfNecessary() {
        if (this.readableBuffers.peek().readableBytes() == 0) {
            advanceBuffer();
        }
    }

    private void advanceBuffer() {
        if (this.marked) {
            this.rewindableBuffers.add(this.readableBuffers.remove());
            ReadableBuffer readableBufferPeek = this.readableBuffers.peek();
            if (readableBufferPeek != null) {
                readableBufferPeek.mark();
                return;
            }
            return;
        }
        this.readableBuffers.remove().close();
    }
}
