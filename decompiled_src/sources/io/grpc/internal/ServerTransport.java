package io.grpc.internal;

import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.Status;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ServerTransport extends InternalInstrumented<InternalChannelz.SocketStats> {
    ScheduledExecutorService getScheduledExecutorService();

    void shutdown();

    void shutdownNow(Status status);
}
