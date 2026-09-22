package io.grpc.internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ServerListener {
    void serverShutdown();

    ServerTransportListener transportCreated(ServerTransport serverTransport);
}
