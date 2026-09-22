package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Metadata;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ServerTransportListener {
    void streamCreated(ServerStream serverStream, String str, Metadata metadata);

    Attributes transportReady(Attributes attributes);

    void transportTerminated();
}
