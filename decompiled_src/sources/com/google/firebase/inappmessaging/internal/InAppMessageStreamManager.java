package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class InAppMessageStreamManager {
    public static final String ON_FOREGROUND = "ON_FOREGROUND";
    private final AbtIntegrationHelper abtIntegrationHelper;
    private final AnalyticsEventsManager analyticsEventsManager;
    private final ApiClient apiClient;
    private final ConnectableFlowable<String> appForegroundEventFlowable;
    private final RateLimit appForegroundRateLimit;
    private final Executor blockingExecutor;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ImpressionStorageClient impressionStorageClient;
    private final ConnectableFlowable<String> programmaticTriggerEventFlowable;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final TestDeviceHelper testDeviceHelper;

    static /* synthetic */ CampaignProto.ThickContent lambda$createFirebaseInAppMessageStream$10(CampaignProto.ThickContent thickContent, Boolean bool) throws Exception {
        return thickContent;
    }

    static /* synthetic */ CampaignProto.ThickContent lambda$getContentIfNotRateLimited$24(CampaignProto.ThickContent thickContent, Boolean bool) throws Exception {
        return thickContent;
    }

    @Inject
    public InAppMessageStreamManager(@AppForeground ConnectableFlowable<String> connectableFlowable, @ProgrammaticTrigger ConnectableFlowable<String> connectableFlowable2, CampaignCacheClient campaignCacheClient, Clock clock, ApiClient apiClient, AnalyticsEventsManager analyticsEventsManager, Schedulers schedulers, ImpressionStorageClient impressionStorageClient, RateLimiterClient rateLimiterClient, @AppForeground RateLimit rateLimit, TestDeviceHelper testDeviceHelper, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionHelper dataCollectionHelper, AbtIntegrationHelper abtIntegrationHelper, Executor executor) {
        this.appForegroundEventFlowable = connectableFlowable;
        this.programmaticTriggerEventFlowable = connectableFlowable2;
        this.campaignCacheClient = campaignCacheClient;
        this.clock = clock;
        this.apiClient = apiClient;
        this.analyticsEventsManager = analyticsEventsManager;
        this.schedulers = schedulers;
        this.impressionStorageClient = impressionStorageClient;
        this.rateLimiterClient = rateLimiterClient;
        this.appForegroundRateLimit = rateLimit;
        this.testDeviceHelper = testDeviceHelper;
        this.dataCollectionHelper = dataCollectionHelper;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.abtIntegrationHelper = abtIntegrationHelper;
        this.blockingExecutor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsTriggeringCondition(String str, CampaignProto.ThickContent thickContent) {
        if (isAppForegroundEvent(str) && thickContent.getIsTestCampaign()) {
            return true;
        }
        for (CommonTypesProto.TriggeringCondition triggeringCondition : thickContent.getTriggeringConditionsList()) {
            if (hasFiamTrigger(triggeringCondition, str) || hasAnalyticsTrigger(triggeringCondition, str)) {
                Logging.logd(String.format("The event %s is contained in the list of triggers", str));
                return true;
            }
        }
        return false;
    }

    private static boolean hasFiamTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getFiamTrigger().toString().equals(str);
    }

    private static boolean hasAnalyticsTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getEvent().getName().equals(str);
    }

    private static boolean isActive(Clock clock, CampaignProto.ThickContent thickContent) {
        long campaignStartTimeMillis;
        long campaignEndTimeMillis;
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            campaignStartTimeMillis = thickContent.getVanillaPayload().getCampaignStartTimeMillis();
            campaignEndTimeMillis = thickContent.getVanillaPayload().getCampaignEndTimeMillis();
        } else {
            if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
                campaignStartTimeMillis = thickContent.getExperimentalPayload().getCampaignStartTimeMillis();
                campaignEndTimeMillis = thickContent.getExperimentalPayload().getCampaignEndTimeMillis();
            }
        }
        long jNow = clock.now();
        return jNow > campaignStartTimeMillis && jNow < campaignEndTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareByPriority(CampaignProto.ThickContent thickContent, CampaignProto.ThickContent thickContent2) {
        if (thickContent.getIsTestCampaign() && !thickContent2.getIsTestCampaign()) {
            return -1;
        }
        if (!thickContent2.getIsTestCampaign() || thickContent.getIsTestCampaign()) {
            return Integer.compare(thickContent.getPriority().getValue(), thickContent2.getPriority().getValue());
        }
        return 1;
    }

    public static boolean isAppForegroundEvent(CommonTypesProto.TriggeringCondition triggeringCondition) {
        return triggeringCondition.getFiamTrigger().toString().equals(ON_FOREGROUND);
    }

    public static boolean isAppForegroundEvent(String str) {
        return str.equals(ON_FOREGROUND);
    }

    private boolean shouldIgnoreCache(String str) {
        if (this.testDeviceHelper.isAppInstallFresh()) {
            return isAppForegroundEvent(str);
        }
        return this.testDeviceHelper.isDeviceInTestMode();
    }

    public Flowable<TriggeredInAppMessage> createFirebaseInAppMessageStream() {
        return Flowable.merge(this.appForegroundEventFlowable, this.analyticsEventsManager.getAnalyticsEventsFlowable(), this.programmaticTriggerEventFlowable).doOnNext(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.logd("Event Triggered: " + ((String) obj));
            }
        }).observeOn(this.schedulers.io()).concatMap(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2024x99e694cd((String) obj);
            }
        }).observeOn(this.schedulers.mainThread());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$createFirebaseInAppMessageStream$21$com-google-firebase-inappmessaging-internal-InAppMessageStreamManager, reason: not valid java name */
    /* synthetic */ Publisher m2024x99e694cd(final String str) throws Exception {
        Maybe<FetchEligibleCampaignsResponse> maybeOnErrorResumeNext = this.campaignCacheClient.get().doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda29
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.logd("Fetched from cache");
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda30
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.logw("Cache read error: " + ((Throwable) obj).getMessage());
            }
        }).onErrorResumeNext(Maybe.empty());
        Consumer consumer = new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda31
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.m2025x22058af2((FetchEligibleCampaignsResponse) obj);
            }
        };
        final Function function = new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda32
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2018x179bdfee((CampaignProto.ThickContent) obj);
            }
        };
        final Function function2 = new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda33
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2019xfac7932f(str, (CampaignProto.ThickContent) obj);
            }
        };
        final Function function3 = new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda34
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$13((CampaignProto.ThickContent) obj);
            }
        };
        Function<? super FetchEligibleCampaignsResponse, ? extends MaybeSource<? extends R>> function4 = new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda35
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2020xc11ef9b1(str, function, function2, function3, (FetchEligibleCampaignsResponse) obj);
            }
        };
        Maybe<CampaignImpressionList> maybeOnErrorResumeNext2 = this.impressionStorageClient.getAllImpressions().doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.logw("Impressions store read fail: " + ((Throwable) obj).getMessage());
            }
        }).defaultIfEmpty(CampaignImpressionList.getDefaultInstance()).onErrorResumeNext(Maybe.just(CampaignImpressionList.getDefaultInstance()));
        final Maybe maybeObserveOn = Maybe.zip(taskToMaybe(this.firebaseInstallations.getId(), this.blockingExecutor), taskToMaybe(this.firebaseInstallations.getToken(false), this.blockingExecutor), new BiFunction() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return InstallationIdResult.create((String) obj, (InstallationTokenResult) obj2);
            }
        }).observeOn(this.schedulers.io());
        Function<? super CampaignImpressionList, ? extends MaybeSource<? extends R>> function5 = new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2023xb6bae18c(maybeObserveOn, (CampaignImpressionList) obj);
            }
        };
        if (shouldIgnoreCache(str)) {
            Logging.logi(String.format("Forcing fetch from service rather than cache. Test Device: %s | App Fresh Install: %s", Boolean.valueOf(this.testDeviceHelper.isDeviceInTestMode()), Boolean.valueOf(this.testDeviceHelper.isAppInstallFresh())));
            return maybeOnErrorResumeNext2.flatMap(function5).flatMap(function4).toFlowable();
        }
        Logging.logd("Attempting to fetch campaigns using cache");
        return maybeOnErrorResumeNext.switchIfEmpty(maybeOnErrorResumeNext2.flatMap(function5).doOnSuccess(consumer)).flatMap(function4).toFlowable();
    }

    /* JADX INFO: renamed from: lambda$createFirebaseInAppMessageStream$6$com-google-firebase-inappmessaging-internal-InAppMessageStreamManager, reason: not valid java name */
    /* synthetic */ void m2025x22058af2(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) throws Exception {
        this.campaignCacheClient.put(fetchEligibleCampaignsResponse).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Action
            public final void run() {
                Logging.logd("Wrote to cache");
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.logw("Cache write error: " + ((Throwable) obj).getMessage());
            }
        }).onErrorResumeNext(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Completable.complete();
            }
        }).subscribe();
    }

    /* JADX INFO: renamed from: lambda$createFirebaseInAppMessageStream$11$com-google-firebase-inappmessaging-internal-InAppMessageStreamManager, reason: not valid java name */
    /* synthetic */ Maybe m2018x179bdfee(final CampaignProto.ThickContent thickContent) throws Exception {
        if (thickContent.getIsTestCampaign()) {
            return Maybe.just(thickContent);
        }
        return this.impressionStorageClient.isImpressed(thickContent).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.logw("Impression store read fail: " + ((Throwable) obj).getMessage());
            }
        }).onErrorResumeNext(Single.just(false)).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InAppMessageStreamManager.logImpressionStatus(thickContent, (Boolean) obj);
            }
        }).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$9((Boolean) obj);
            }
        }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$10(thickContent, (Boolean) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$createFirebaseInAppMessageStream$9(Boolean bool) throws Exception {
        return !bool.booleanValue();
    }

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase;

        static {
            int[] iArr = new int[MessagesProto.Content.MessageDetailsCase.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase = iArr;
            try {
                iArr[MessagesProto.Content.MessageDetailsCase.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.IMAGE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$13(CampaignProto.ThickContent thickContent) throws Exception {
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[thickContent.getContent().getMessageDetailsCase().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return Maybe.just(thickContent);
        }
        Logging.logd("Filtering non-displayable message");
        return Maybe.empty();
    }

    /* JADX INFO: renamed from: lambda$createFirebaseInAppMessageStream$20$com-google-firebase-inappmessaging-internal-InAppMessageStreamManager, reason: not valid java name */
    /* synthetic */ Maybe m2023xb6bae18c(Maybe maybe, final CampaignImpressionList campaignImpressionList) throws Exception {
        if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logi("Automatic data collection is disabled, not attempting campaign fetch from service.");
            return Maybe.just(cacheExpiringResponse());
        }
        Maybe maybeDoOnSuccess = maybe.filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return InAppMessageStreamManager.validIID((InstallationIdResult) obj);
            }
        }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2021x87766033(campaignImpressionList, (InstallationIdResult) obj);
            }
        }).switchIfEmpty(Maybe.just(cacheExpiringResponse())).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.logi(String.format(Locale.US, "Successfully fetched %d messages from backend", Integer.valueOf(((FetchEligibleCampaignsResponse) obj).getMessagesList().size())));
            }
        }).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.m2022x4dcdc6b5((FetchEligibleCampaignsResponse) obj);
            }
        });
        final AnalyticsEventsManager analyticsEventsManager = this.analyticsEventsManager;
        Objects.requireNonNull(analyticsEventsManager);
        Maybe maybeDoOnSuccess2 = maybeDoOnSuccess.doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                analyticsEventsManager.updateContextualTriggers((FetchEligibleCampaignsResponse) obj);
            }
        });
        final TestDeviceHelper testDeviceHelper = this.testDeviceHelper;
        Objects.requireNonNull(testDeviceHelper);
        return maybeDoOnSuccess2.doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                testDeviceHelper.processCampaignFetch((FetchEligibleCampaignsResponse) obj);
            }
        }).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.logw("Service fetch error: " + ((Throwable) obj).getMessage());
            }
        }).onErrorResumeNext(Maybe.empty());
    }

    /* JADX INFO: renamed from: lambda$createFirebaseInAppMessageStream$16$com-google-firebase-inappmessaging-internal-InAppMessageStreamManager, reason: not valid java name */
    /* synthetic */ FetchEligibleCampaignsResponse m2021x87766033(CampaignImpressionList campaignImpressionList, InstallationIdResult installationIdResult) throws Exception {
        return this.apiClient.getFiams(installationIdResult, campaignImpressionList);
    }

    /* JADX INFO: renamed from: lambda$createFirebaseInAppMessageStream$18$com-google-firebase-inappmessaging-internal-InAppMessageStreamManager, reason: not valid java name */
    /* synthetic */ void m2022x4dcdc6b5(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) throws Exception {
        this.impressionStorageClient.clearImpressions(fetchEligibleCampaignsResponse).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getContentIfNotRateLimited, reason: merged with bridge method [inline-methods] */
    public Maybe<CampaignProto.ThickContent> m2019xfac7932f(String str, final CampaignProto.ThickContent thickContent) {
        if (!thickContent.getIsTestCampaign() && isAppForegroundEvent(str)) {
            return this.rateLimiterClient.isRateLimited(this.appForegroundRateLimit).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Logging.logi("App foreground rate limited ? : " + ((Boolean) obj));
                }
            }).onErrorResumeNext(Single.just(false)).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda11
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    return InAppMessageStreamManager.lambda$getContentIfNotRateLimited$23((Boolean) obj);
                }
            }).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda22
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return InAppMessageStreamManager.lambda$getContentIfNotRateLimited$24(thickContent, (Boolean) obj);
                }
            });
        }
        return Maybe.just(thickContent);
    }

    static /* synthetic */ boolean lambda$getContentIfNotRateLimited$23(Boolean bool) throws Exception {
        return !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logImpressionStatus(CampaignProto.ThickContent thickContent, Boolean bool) {
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            Logging.logi(String.format("Already impressed campaign %s ? : %s", thickContent.getVanillaPayload().getCampaignName(), bool));
        } else if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            Logging.logi(String.format("Already impressed experiment %s ? : %s", thickContent.getExperimentalPayload().getCampaignName(), bool));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getTriggeredInAppMessageMaybe, reason: merged with bridge method [inline-methods] */
    public Maybe<TriggeredInAppMessage> m2020xc11ef9b1(final String str, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> function, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> function2, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> function3, FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return Flowable.fromIterable(fetchEligibleCampaignsResponse.getMessagesList()).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return this.f$0.m2026xb1c6f55d((CampaignProto.ThickContent) obj);
            }
        }).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda26
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return InAppMessageStreamManager.containsTriggeringCondition(str, (CampaignProto.ThickContent) obj);
            }
        }).flatMapMaybe(function).flatMapMaybe(function2).flatMapMaybe(function3).sorted(new Comparator() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda27
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return InAppMessageStreamManager.compareByPriority((CampaignProto.ThickContent) obj, (CampaignProto.ThickContent) obj2);
            }
        }).firstElement().flatMap(new Function() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda28
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2027x781e5bdf(str, (CampaignProto.ThickContent) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getTriggeredInAppMessageMaybe$25$com-google-firebase-inappmessaging-internal-InAppMessageStreamManager, reason: not valid java name */
    /* synthetic */ boolean m2026xb1c6f55d(CampaignProto.ThickContent thickContent) throws Exception {
        return this.testDeviceHelper.isDeviceInTestMode() || isActive(this.clock, thickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: triggeredInAppMessage, reason: merged with bridge method [inline-methods] */
    public Maybe<TriggeredInAppMessage> m2027x781e5bdf(CampaignProto.ThickContent thickContent, String str) {
        String campaignId;
        String campaignName;
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            campaignId = thickContent.getVanillaPayload().getCampaignId();
            campaignName = thickContent.getVanillaPayload().getCampaignName();
        } else if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            String campaignId2 = thickContent.getExperimentalPayload().getCampaignId();
            String campaignName2 = thickContent.getExperimentalPayload().getCampaignName();
            if (!thickContent.getIsTestCampaign()) {
                this.abtIntegrationHelper.setExperimentActive(thickContent.getExperimentalPayload().getExperimentPayload());
            }
            campaignId = campaignId2;
            campaignName = campaignName2;
        } else {
            return Maybe.empty();
        }
        InAppMessage inAppMessageDecode = ProtoMarshallerClient.decode(thickContent.getContent(), campaignId, campaignName, thickContent.getIsTestCampaign(), thickContent.getDataBundleMap());
        if (inAppMessageDecode.getMessageType().equals(MessageType.UNSUPPORTED)) {
            return Maybe.empty();
        }
        return Maybe.just(new TriggeredInAppMessage(inAppMessageDecode, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validIID(InstallationIdResult installationIdResult) {
        return (TextUtils.isEmpty(installationIdResult.installationId()) || TextUtils.isEmpty(installationIdResult.installationTokenResult().getToken())) ? false : true;
    }

    static FetchEligibleCampaignsResponse cacheExpiringResponse() {
        return FetchEligibleCampaignsResponse.newBuilder().setExpirationEpochTimestampMillis(1L).build();
    }

    private static <T> Maybe<T> taskToMaybe(final Task<T> task, final Executor executor) {
        return Maybe.create(new MaybeOnSubscribe() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda4
            @Override // io.reactivex.MaybeOnSubscribe
            public final void subscribe(MaybeEmitter maybeEmitter) throws Exception {
                InAppMessageStreamManager.lambda$taskToMaybe$30(task, executor, maybeEmitter);
            }
        });
    }

    static /* synthetic */ void lambda$taskToMaybe$30(Task task, Executor executor, final MaybeEmitter maybeEmitter) throws Exception {
        task.addOnSuccessListener(executor, new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda18
            public final void onSuccess(Object obj) {
                InAppMessageStreamManager.lambda$taskToMaybe$28(maybeEmitter, obj);
            }
        });
        task.addOnFailureListener(executor, new OnFailureListener() { // from class: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$ExternalSyntheticLambda19
            public final void onFailure(Exception exc) {
                InAppMessageStreamManager.lambda$taskToMaybe$29(maybeEmitter, exc);
            }
        });
    }

    static /* synthetic */ void lambda$taskToMaybe$28(MaybeEmitter maybeEmitter, Object obj) {
        maybeEmitter.onSuccess(obj);
        maybeEmitter.onComplete();
    }

    static /* synthetic */ void lambda$taskToMaybe$29(MaybeEmitter maybeEmitter, Exception exc) {
        maybeEmitter.onError(exc);
        maybeEmitter.onComplete();
    }
}
