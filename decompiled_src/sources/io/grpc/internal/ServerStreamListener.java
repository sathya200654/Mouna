package io.grpc.internal;

import io.grpc.Status;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ServerStreamListener extends StreamListener {
    void closed(Status status);

    void halfClosed();
}
