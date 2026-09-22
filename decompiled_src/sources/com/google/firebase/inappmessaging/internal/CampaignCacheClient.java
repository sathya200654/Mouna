package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Singleton
public class CampaignCacheClient {
    private final Application application;

    @Nullable
    private FetchEligibleCampaignsResponse cachedResponse;
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    @Inject
    CampaignCacheClient(@CampaignCache ProtoStorageClient protoStorageClient, Application application, Clock clock) {
        this.storageClient = protoStorageClient;
        this.application = application;
        this.clock = clock;
    }

    public Completable put(final FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return this.storageClient.write(fetchEligibleCampaignsResponse).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.CampaignCacheClient$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.m1997xf10f1ae(fetchEligibleCampaignsResponse);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$put$0$com-google-firebase-inappmessaging-internal-CampaignCacheClient, reason: not valid java name */
    /* synthetic */ void m1997xf10f1ae(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) throws Exception {
        this.cachedResponse = fetchEligibleCampaignsResponse;
    }

    public Maybe<FetchEligibleCampaignsResponse> get() {
        return Maybe.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.CampaignCacheClient$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1994x1a129836();
            }
        }).switchIfEmpty(this.storageClient.read(FetchEligibleCampaignsResponse.parser()).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.CampaignCacheClient$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.m1995x67d21037((FetchEligibleCampaignsResponse) obj);
            }
        })).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.CampaignCacheClient$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return this.f$0.isResponseValid((FetchEligibleCampaignsResponse) obj);
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.CampaignCacheClient$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.m1996xb5918838((Throwable) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$get$1$com-google-firebase-inappmessaging-internal-CampaignCacheClient, reason: not valid java name */
    /* synthetic */ FetchEligibleCampaignsResponse m1994x1a129836() throws Exception {
        return this.cachedResponse;
    }

    /* JADX INFO: renamed from: lambda$get$2$com-google-firebase-inappmessaging-internal-CampaignCacheClient, reason: not valid java name */
    /* synthetic */ void m1995x67d21037(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) throws Exception {
        this.cachedResponse = fetchEligibleCampaignsResponse;
    }

    /* JADX INFO: renamed from: lambda$get$3$com-google-firebase-inappmessaging-internal-CampaignCacheClient, reason: not valid java name */
    /* synthetic */ void m1996xb5918838(Throwable th) throws Exception {
        this.cachedResponse = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isResponseValid(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        long expirationEpochTimestampMillis = fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis();
        long jNow = this.clock.now();
        File file = new File(this.application.getApplicationContext().getFilesDir(), ProtoStorageClientModule.CAMPAIGN_CACHE_FILE);
        if (expirationEpochTimestampMillis != 0) {
            return jNow < expirationEpochTimestampMillis;
        }
        return !file.exists() || jNow < file.lastModified() + TimeUnit.DAYS.toMillis(1L);
    }
}
