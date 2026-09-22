package io.grpc;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ServerCallHandler<RequestT, ResponseT> {
    ServerCall.Listener<RequestT> startCall(ServerCall<RequestT, ResponseT> serverCall, Metadata metadata);
}
