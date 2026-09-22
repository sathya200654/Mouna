package io.grpc;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ServerCallExecutorSupplier {
    @Nullable
    <ReqT, RespT> Executor getExecutor(ServerCall<ReqT, RespT> serverCall, Metadata metadata);
}
