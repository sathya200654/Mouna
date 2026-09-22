package io.grpc.internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface BackoffPolicy {

    public interface Provider {
        BackoffPolicy get();
    }

    long nextBackoffNanos();
}
