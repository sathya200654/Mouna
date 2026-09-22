package io.grpc.stub;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class CallStreamObserver<V> implements StreamObserver<V> {
    public abstract void disableAutoInboundFlowControl();

    public abstract boolean isReady();

    public abstract void request(int i);

    public abstract void setMessageCompression(boolean z);

    public abstract void setOnReadyHandler(Runnable runnable);
}
