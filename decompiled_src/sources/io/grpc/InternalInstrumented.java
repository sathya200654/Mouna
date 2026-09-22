package io.grpc;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface InternalInstrumented<T> extends InternalWithLogId {
    ListenableFuture<T> getStats();
}
