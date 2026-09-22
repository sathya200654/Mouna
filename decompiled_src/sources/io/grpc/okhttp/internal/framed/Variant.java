package io.grpc.okhttp.internal.framed;

import io.grpc.okhttp.internal.Protocol;
import okio.BufferedSink;
import okio.BufferedSource;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface Variant {
    Protocol getProtocol();

    FrameReader newReader(BufferedSource bufferedSource, boolean z);

    FrameWriter newWriter(BufferedSink bufferedSink, boolean z);
}
