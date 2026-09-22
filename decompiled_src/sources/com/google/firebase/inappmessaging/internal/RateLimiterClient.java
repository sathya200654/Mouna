package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;
import com.google.firebase.inappmessaging.internal.time.Clock;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Singleton
public class RateLimiterClient {
    private static final RateLimitProto.RateLimit EMPTY_RATE_LIMITS = RateLimitProto.RateLimit.getDefaultInstance();
    private Maybe<RateLimitProto.RateLimit> cachedRateLimts = Maybe.empty();
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    @Inject
    RateLimiterClient(@RateLimit ProtoStorageClient protoStorageClient, Clock clock) {
        this.storageClient = protoStorageClient;
        this.clock = clock;
    }

    private static RateLimitProto.Counter increment(RateLimitProto.Counter counter) {
        return RateLimitProto.Counter.newBuilder(counter).clearValue().setValue(counter.getValue() + 1).build();
    }

    public Completable increment(final com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return getRateLimits().defaultIfEmpty(EMPTY_RATE_LIMITS).flatMapCompletable(new Function() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2042xcfbc40e8(rateLimit, (RateLimitProto.RateLimit) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$increment$4$com-google-firebase-inappmessaging-internal-RateLimiterClient, reason: not valid java name */
    /* synthetic */ CompletableSource m2042xcfbc40e8(final com.google.firebase.inappmessaging.model.RateLimit rateLimit, final RateLimitProto.RateLimit rateLimit2) throws Exception {
        return Observable.just(rateLimit2.getLimitsOrDefault(rateLimit.limiterKey(), newCounter())).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return this.f$0.m2039x17e2fe4(rateLimit, (RateLimitProto.Counter) obj);
            }
        }).switchIfEmpty(Observable.just(newCounter())).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RateLimitProto.RateLimit.newBuilder(rateLimit2).putLimits(rateLimit.limiterKey(), RateLimiterClient.increment((RateLimitProto.Counter) obj)).build();
            }
        }).flatMapCompletable(new Function() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2041xdc2cbca7((RateLimitProto.RateLimit) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$increment$0$com-google-firebase-inappmessaging-internal-RateLimiterClient, reason: not valid java name */
    /* synthetic */ boolean m2039x17e2fe4(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) throws Exception {
        return !isLimitExpired(counter, rateLimit);
    }

    /* JADX INFO: renamed from: lambda$increment$3$com-google-firebase-inappmessaging-internal-RateLimiterClient, reason: not valid java name */
    /* synthetic */ CompletableSource m2041xdc2cbca7(final RateLimitProto.RateLimit rateLimit) throws Exception {
        return this.storageClient.write(rateLimit).doOnComplete(new Action() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.m2040xe89d3866(rateLimit);
            }
        });
    }

    public Single<Boolean> isRateLimited(final com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return getRateLimits().switchIfEmpty(Maybe.just(RateLimitProto.RateLimit.getDefaultInstance())).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.m2043x7448494a(rateLimit, (RateLimitProto.RateLimit) obj);
            }
        }).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return this.f$0.m2044x67d7cd8b(rateLimit, (RateLimitProto.Counter) obj);
            }
        }).isEmpty();
    }

    /* JADX INFO: renamed from: lambda$isRateLimited$5$com-google-firebase-inappmessaging-internal-RateLimiterClient, reason: not valid java name */
    /* synthetic */ RateLimitProto.Counter m2043x7448494a(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.RateLimit rateLimit2) throws Exception {
        return rateLimit2.getLimitsOrDefault(rateLimit.limiterKey(), newCounter());
    }

    /* JADX INFO: renamed from: lambda$isRateLimited$6$com-google-firebase-inappmessaging-internal-RateLimiterClient, reason: not valid java name */
    /* synthetic */ boolean m2044x67d7cd8b(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) throws Exception {
        return isLimitExpired(counter, rateLimit) || counter.getValue() < rateLimit.limit();
    }

    private boolean isLimitExpired(RateLimitProto.Counter counter, com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return this.clock.now() - counter.getStartTimeEpoch() > rateLimit.timeToLiveMillis();
    }

    private Maybe<RateLimitProto.RateLimit> getRateLimits() {
        return this.cachedRateLimts.switchIfEmpty(this.storageClient.read(RateLimitProto.RateLimit.parser()).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.m2040xe89d3866((RateLimitProto.RateLimit) obj);
            }
        })).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.m2038xa98355ca((Throwable) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getRateLimits$7$com-google-firebase-inappmessaging-internal-RateLimiterClient, reason: not valid java name */
    /* synthetic */ void m2038xa98355ca(Throwable th) throws Exception {
        clearInMemCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initInMemCache, reason: merged with bridge method [inline-methods] */
    public void m2040xe89d3866(RateLimitProto.RateLimit rateLimit) {
        this.cachedRateLimts = Maybe.just(rateLimit);
    }

    private void clearInMemCache() {
        this.cachedRateLimts = Maybe.empty();
    }

    private RateLimitProto.Counter newCounter() {
        return RateLimitProto.Counter.newBuilder().setValue(0L).setStartTimeEpoch(this.clock.now()).build();
    }
}
