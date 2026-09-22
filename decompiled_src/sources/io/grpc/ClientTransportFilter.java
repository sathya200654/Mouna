package io.grpc;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ClientTransportFilter {
    public Attributes transportReady(Attributes attributes) {
        return attributes;
    }

    public void transportTerminated(Attributes attributes) {
    }
}
