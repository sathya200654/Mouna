package io.grpc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface HasByteBuffer {
    boolean byteBufferSupported();

    @Nullable
    ByteBuffer getByteBuffer();
}
