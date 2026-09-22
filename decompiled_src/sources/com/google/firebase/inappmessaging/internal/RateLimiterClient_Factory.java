package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class RateLimiterClient_Factory implements Factory<RateLimiterClient> {
    private final Provider<Clock> clockProvider;
    private final Provider<ProtoStorageClient> storageClientProvider;

    public RateLimiterClient_Factory(Provider<ProtoStorageClient> provider, Provider<Clock> provider2) {
        this.storageClientProvider = provider;
        this.clockProvider = provider2;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public RateLimiterClient m2045get() {
        return newInstance((ProtoStorageClient) this.storageClientProvider.get(), (Clock) this.clockProvider.get());
    }

    public static RateLimiterClient_Factory create(Provider<ProtoStorageClient> provider, Provider<Clock> provider2) {
        return new RateLimiterClient_Factory(provider, provider2);
    }

    public static RateLimiterClient newInstance(ProtoStorageClient protoStorageClient, Clock clock) {
        return new RateLimiterClient(protoStorageClient, clock);
    }
}
