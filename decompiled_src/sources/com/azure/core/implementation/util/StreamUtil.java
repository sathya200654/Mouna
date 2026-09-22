package com.azure.core.implementation.util;

import com.azure.core.util.logging.ClientLogger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class StreamUtil {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) StreamUtil.class);

    private StreamUtil() {
    }

    public static Tuple2<Long, List<ByteBuffer>> readStreamToListOfByteBuffers(InputStream inputStream, Long l, int i, int i2) throws IOException {
        int i3;
        ByteBuffer byteBufferAllocate;
        Objects.requireNonNull(inputStream, "'inputStream' must not be null");
        if (i <= 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'initialBufferSize' must be positive integer"));
        }
        if (i2 < i) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'maxBufferSize' must not be smaller than 'maxBufferSize'"));
        }
        long j = 0;
        if (l != null && l.longValue() < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'length' must not be negative"));
        }
        if (l != null) {
            i = (int) Math.max(1L, Math.min(i2, l.longValue()));
        }
        long jLongValue = l != null ? l.longValue() : Long.MAX_VALUE;
        ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(inputStream);
        LinkedList linkedList = new LinkedList();
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        do {
            i3 = readableByteChannelNewChannel.read(byteBufferAllocate2);
            if (i3 >= 0) {
                j += (long) i3;
                if (!byteBufferAllocate2.hasRemaining()) {
                    int i4 = i * 2;
                    if (i4 <= jLongValue - j && i4 <= i2) {
                        i = i4;
                    }
                    byteBufferAllocate2.flip();
                    linkedList.add(byteBufferAllocate2);
                    if (j == jLongValue) {
                        ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(1);
                        i3 = readableByteChannelNewChannel.read(byteBufferAllocate3);
                        if (i3 != -1) {
                            byteBufferAllocate = ByteBuffer.allocate(i);
                            byteBufferAllocate3.flip();
                            byteBufferAllocate.put(byteBufferAllocate3);
                        } else {
                            byteBufferAllocate = null;
                        }
                    } else {
                        byteBufferAllocate = ByteBuffer.allocate(i);
                    }
                    byteBufferAllocate2 = byteBufferAllocate;
                }
            } else {
                byteBufferAllocate2.flip();
                if (byteBufferAllocate2.hasRemaining()) {
                    linkedList.add(byteBufferAllocate2);
                }
            }
        } while (i3 >= 0);
        return Tuples.of(Long.valueOf(j), Collections.unmodifiableList(linkedList));
    }
}
