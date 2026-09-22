package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Singleton
public class ImpressionStorageClient {
    private static final CampaignImpressionList EMPTY_IMPRESSIONS = CampaignImpressionList.getDefaultInstance();
    private Maybe<CampaignImpressionList> cachedImpressionsMaybe = Maybe.empty();
    private final ProtoStorageClient storageClient;

    @Inject
    ImpressionStorageClient(@ImpressionStore ProtoStorageClient protoStorageClient) {
        this.storageClient = protoStorageClient;
    }

    private static CampaignImpressionList appendImpression(CampaignImpressionList campaignImpressionList, CampaignImpression campaignImpression) {
        return CampaignImpressionList.newBuilder(campaignImpressionList).addAlreadySeenCampaigns(campaignImpression).build();
    }

    public Completable storeImpression(final CampaignImpression campaignImpression) {
        return getAllImpressions().defaultIfEmpty(EMPTY_IMPRESSIONS).flatMapCompletable(new Function() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2015xbcc22e8a(campaignImpression, (CampaignImpressionList) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$storeImpression$1$com-google-firebase-inappmessaging-internal-ImpressionStorageClient, reason: not valid java name */
    /* synthetic */ CompletableSource m2015xbcc22e8a(CampaignImpression campaignImpression, CampaignImpressionList campaignImpressionList) throws Exception {
        final CampaignImpressionList campaignImpressionListAppendImpression = appendImpression(campaignImpressionList, campaignImpression);
        return this.storageClient.write(campaignImpressionListAppendImpression).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.m2014xcb709f09(campaignImpressionListAppendImpression);
            }
        });
    }

    public Maybe<CampaignImpressionList> getAllImpressions() {
        return this.cachedImpressionsMaybe.switchIfEmpty(this.storageClient.read(CampaignImpressionList.parser()).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.m2014xcb709f09((CampaignImpressionList) obj);
            }
        })).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.m2013x50581fe0((Throwable) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getAllImpressions$2$com-google-firebase-inappmessaging-internal-ImpressionStorageClient, reason: not valid java name */
    /* synthetic */ void m2013x50581fe0(Throwable th) throws Exception {
        clearInMemCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initInMemCache, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void m2014xcb709f09(CampaignImpressionList campaignImpressionList) {
        this.cachedImpressionsMaybe = Maybe.just(campaignImpressionList);
    }

    private void clearInMemCache() {
        this.cachedImpressionsMaybe = Maybe.empty();
    }

    public Single<Boolean> isImpressed(CampaignProto.ThickContent thickContent) {
        String campaignId;
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            campaignId = thickContent.getVanillaPayload().getCampaignId();
        } else {
            campaignId = thickContent.getExperimentalPayload().getCampaignId();
        }
        return getAllImpressions().map(new Function() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((CampaignImpressionList) obj).getAlreadySeenCampaignsList();
            }
        }).flatMapObservable(new Function() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Observable.fromIterable((List) obj);
            }
        }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((CampaignImpression) obj).getCampaignId();
            }
        }).contains(campaignId);
    }

    public Completable clearImpressions(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        String campaignId;
        final HashSet hashSet = new HashSet();
        for (CampaignProto.ThickContent thickContent : fetchEligibleCampaignsResponse.getMessagesList()) {
            if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
                campaignId = thickContent.getVanillaPayload().getCampaignId();
            } else {
                campaignId = thickContent.getExperimentalPayload().getCampaignId();
            }
            hashSet.add(campaignId);
        }
        Logging.logd("Potential impressions to clear: " + hashSet.toString());
        return getAllImpressions().defaultIfEmpty(EMPTY_IMPRESSIONS).flatMapCompletable(new Function() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2012x82f1969a(hashSet, (CampaignImpressionList) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$clearImpressions$4$com-google-firebase-inappmessaging-internal-ImpressionStorageClient, reason: not valid java name */
    /* synthetic */ CompletableSource m2012x82f1969a(HashSet hashSet, CampaignImpressionList campaignImpressionList) throws Exception {
        Logging.logd("Existing impressions: " + campaignImpressionList.toString());
        CampaignImpressionList.Builder builderNewBuilder = CampaignImpressionList.newBuilder();
        for (CampaignImpression campaignImpression : campaignImpressionList.getAlreadySeenCampaignsList()) {
            if (!hashSet.contains(campaignImpression.getCampaignId())) {
                builderNewBuilder.addAlreadySeenCampaigns(campaignImpression);
            }
        }
        final CampaignImpressionList campaignImpressionListBuild = builderNewBuilder.build();
        Logging.logd("New cleared impression list: " + campaignImpressionListBuild.toString());
        return this.storageClient.write(campaignImpressionListBuild).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.ImpressionStorageClient$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.m2011x91a00719(campaignImpressionListBuild);
            }
        });
    }
}
