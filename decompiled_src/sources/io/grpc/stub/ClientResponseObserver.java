package io.grpc.stub;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ClientResponseObserver<ReqT, RespT> extends StreamObserver<RespT> {
    void beforeStart(ClientCallStreamObserver<ReqT> clientCallStreamObserver);
}
