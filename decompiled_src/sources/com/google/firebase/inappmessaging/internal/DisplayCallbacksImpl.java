package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class DisplayCallbacksImpl implements FirebaseInAppMessagingDisplayCallbacks {
    private static final String MESSAGE_CLICK = "message click to metrics logger";
    private final RateLimit appForegroundRateLimit;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final ImpressionStorageClient impressionStorageClient;
    private final InAppMessage inAppMessage;
    private final MetricsLoggerClient metricsLoggerClient;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final String triggeringEvent;
    private boolean wasImpressed = false;

    DisplayCallbacksImpl(ImpressionStorageClient impressionStorageClient, Clock clock, Schedulers schedulers, RateLimiterClient rateLimiterClient, CampaignCacheClient campaignCacheClient, RateLimit rateLimit, MetricsLoggerClient metricsLoggerClient, DataCollectionHelper dataCollectionHelper, InAppMessage inAppMessage, String str) {
        this.impressionStorageClient = impressionStorageClient;
        this.clock = clock;
        this.schedulers = schedulers;
        this.rateLimiterClient = rateLimiterClient;
        this.campaignCacheClient = campaignCacheClient;
        this.appForegroundRateLimit = rateLimit;
        this.metricsLoggerClient = metricsLoggerClient;
        this.dataCollectionHelper = dataCollectionHelper;
        this.inAppMessage = inAppMessage;
        this.triggeringEvent = str;
    }

    boolean wasImpressed() {
        return this.wasImpressed;
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> impressionDetected() {
        if (shouldLog() && !this.wasImpressed) {
            Logging.logd("Attempting to record: message impression to metrics logger");
            return maybeToTask(logToImpressionStore().andThen(Completable.fromAction(new Action() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda11
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.m2004x6aaf82e5();
                }
            })).andThen(updateWasImpressed()).toMaybe(), this.schedulers.io());
        }
        logActionNotTaken("message impression to metrics logger");
        return new TaskCompletionSource().getTask();
    }

    /* JADX INFO: renamed from: lambda$impressionDetected$0$com-google-firebase-inappmessaging-internal-DisplayCallbacksImpl, reason: not valid java name */
    /* synthetic */ void m2004x6aaf82e5() throws Exception {
        this.metricsLoggerClient.logImpression(this.inAppMessage);
    }

    private Completable updateWasImpressed() {
        return Completable.fromAction(new Action() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.m2007x170830d1();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updateWasImpressed$1$com-google-firebase-inappmessaging-internal-DisplayCallbacksImpl, reason: not valid java name */
    /* synthetic */ void m2007x170830d1() throws Exception {
        this.wasImpressed = true;
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> messageDismissed(final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (shouldLog()) {
            Logging.logd("Attempting to record: message dismissal to metrics logger");
            return logImpressionIfNeeded(Completable.fromAction(new Action() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.m2006x4301cfcc(inAppMessagingDismissType);
                }
            }));
        }
        logActionNotTaken("message dismissal to metrics logger");
        return new TaskCompletionSource().getTask();
    }

    /* JADX INFO: renamed from: lambda$messageDismissed$2$com-google-firebase-inappmessaging-internal-DisplayCallbacksImpl, reason: not valid java name */
    /* synthetic */ void m2006x4301cfcc(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) throws Exception {
        this.metricsLoggerClient.logDismiss(this.inAppMessage, inAppMessagingDismissType);
    }

    @Deprecated
    public Task<Void> messageClicked() {
        return messageClicked(this.inAppMessage.getAction());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> messageClicked(com.google.firebase.inappmessaging.model.Action action) {
        if (shouldLog()) {
            if (action.getActionUrl() == null) {
                return messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
            }
            return logMessageClick(action);
        }
        logActionNotTaken(MESSAGE_CLICK);
        return new TaskCompletionSource().getTask();
    }

    private Task<Void> logMessageClick(final com.google.firebase.inappmessaging.model.Action action) {
        Logging.logd("Attempting to record: message click to metrics logger");
        return logImpressionIfNeeded(Completable.fromAction(new Action() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.m2005x9197eea2(action);
            }
        }));
    }

    /* JADX INFO: renamed from: lambda$logMessageClick$3$com-google-firebase-inappmessaging-internal-DisplayCallbacksImpl, reason: not valid java name */
    /* synthetic */ void m2005x9197eea2(com.google.firebase.inappmessaging.model.Action action) throws Exception {
        this.metricsLoggerClient.logMessageClick(this.inAppMessage, action);
    }

    private boolean actionMatches(com.google.firebase.inappmessaging.model.Action action, com.google.firebase.inappmessaging.model.Action action2) {
        if (action == null) {
            return action2 == null || TextUtils.isEmpty(action2.getActionUrl());
        }
        return action.getActionUrl().equals(action2.getActionUrl());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> displayErrorEncountered(final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (shouldLog()) {
            Logging.logd("Attempting to record: render error to metrics logger");
            return maybeToTask(logToImpressionStore().andThen(Completable.fromAction(new Action() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.m2003x61de90ba(inAppMessagingErrorReason);
                }
            })).andThen(updateWasImpressed()).toMaybe(), this.schedulers.io());
        }
        logActionNotTaken("render error to metrics logger");
        return new TaskCompletionSource().getTask();
    }

    /* JADX INFO: renamed from: lambda$displayErrorEncountered$4$com-google-firebase-inappmessaging-internal-DisplayCallbacksImpl, reason: not valid java name */
    /* synthetic */ void m2003x61de90ba(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) throws Exception {
        this.metricsLoggerClient.logRenderError(this.inAppMessage, inAppMessagingErrorReason);
    }

    private boolean shouldLog() {
        return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
    }

    private Task<Void> logImpressionIfNeeded(Completable completable) {
        if (!this.wasImpressed) {
            impressionDetected();
        }
        return maybeToTask(completable.toMaybe(), this.schedulers.io());
    }

    private void logActionNotTaken(String str, Maybe<String> maybe) {
        if (maybe != null) {
            Logging.logd(String.format("Not recording: %s. Reason: %s", str, maybe));
            return;
        }
        if (this.inAppMessage.getCampaignMetadata().getIsTestMessage()) {
            Logging.logd(String.format("Not recording: %s. Reason: Message is test message", str));
        } else if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logd(String.format("Not recording: %s. Reason: Data collection is disabled", str));
        } else {
            Logging.logd(String.format("Not recording: %s", str));
        }
    }

    private void logActionNotTaken(String str) {
        logActionNotTaken(str, null);
    }

    private Completable logToImpressionStore() {
        String campaignId = this.inAppMessage.getCampaignMetadata().getCampaignId();
        Logging.logd("Attempting to record message impression in impression store for id: " + campaignId);
        Completable completableDoOnComplete = this.impressionStorageClient.storeImpression(CampaignImpression.newBuilder().setImpressionTimestampMillis(this.clock.now()).setCampaignId(campaignId).build()).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.loge("Impression store write failure");
            }
        }).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Action
            public final void run() {
                Logging.logd("Impression store write success");
            }
        });
        return InAppMessageStreamManager.isAppForegroundEvent(this.triggeringEvent) ? this.rateLimiterClient.increment(this.appForegroundRateLimit).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Logging.loge("Rate limiter client write failure");
            }
        }).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Action
            public final void run() {
                Logging.logd("Rate limiter client write success");
            }
        }).onErrorComplete().andThen(completableDoOnComplete) : completableDoOnComplete;
    }

    private static <T> Task<T> maybeToTask(Maybe<T> maybe, Scheduler scheduler) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Objects.requireNonNull(taskCompletionSource);
        maybe.doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                taskCompletionSource.setResult(obj);
            }
        }).switchIfEmpty(Maybe.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DisplayCallbacksImpl.lambda$maybeToTask$9(taskCompletionSource);
            }
        })).onErrorResumeNext(new Function() { // from class: com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DisplayCallbacksImpl.lambda$maybeToTask$10(taskCompletionSource, (Throwable) obj);
            }
        }).subscribeOn(scheduler).subscribe();
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ Object lambda$maybeToTask$9(TaskCompletionSource taskCompletionSource) throws Exception {
        taskCompletionSource.setResult((Object) null);
        return null;
    }

    static /* synthetic */ MaybeSource lambda$maybeToTask$10(TaskCompletionSource taskCompletionSource, Throwable th) throws Exception {
        if (th instanceof Exception) {
            taskCompletionSource.setException((Exception) th);
        } else {
            taskCompletionSource.setException(new RuntimeException(th));
        }
        return Maybe.empty();
    }
}
