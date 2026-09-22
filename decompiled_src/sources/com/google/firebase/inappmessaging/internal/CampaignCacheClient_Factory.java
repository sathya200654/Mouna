package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class CampaignCacheClient_Factory implements Factory<CampaignCacheClient> {
    private final Provider<Application> applicationProvider;
    private final Provider<Clock> clockProvider;
    private final Provider<ProtoStorageClient> storageClientProvider;

    public CampaignCacheClient_Factory(Provider<ProtoStorageClient> provider, Provider<Application> provider2, Provider<Clock> provider3) {
        this.storageClientProvider = provider;
        this.applicationProvider = provider2;
        this.clockProvider = provider3;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public CampaignCacheClient m1998get() {
        return newInstance((ProtoStorageClient) this.storageClientProvider.get(), (Application) this.applicationProvider.get(), (Clock) this.clockProvider.get());
    }

    public static CampaignCacheClient_Factory create(Provider<ProtoStorageClient> provider, Provider<Application> provider2, Provider<Clock> provider3) {
        return new CampaignCacheClient_Factory(provider, provider2, provider3);
    }

    public static CampaignCacheClient newInstance(ProtoStorageClient protoStorageClient, Application application, Clock clock) {
        return new CampaignCacheClient(protoStorageClient, application, clock);
    }
}
