package com.azure.core.credential;

import androidx.camera.view.PreviewView$1$;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.azure.core.util.logging.LoggingEventBuilder;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;
import reactor.core.publisher.Sinks;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class SimpleTokenCache {
    private volatile AccessToken cache;
    private volatile OffsetDateTime nextTokenRefresh;
    private final Duration refreshDelay;
    private final String refreshDelayString;
    private final Predicate<AccessToken> shouldRefresh;
    private final Supplier<Mono<AccessToken>> tokenSupplier;
    private final AtomicReference<Sinks.One<AccessToken>> wip;
    private static final Duration REFRESH_OFFSET = Duration.ofMinutes(5);
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) SimpleTokenCache.class);

    static /* synthetic */ Throwable lambda$getToken$2(Throwable th) {
        return th;
    }

    public SimpleTokenCache(Supplier<Mono<AccessToken>> supplier) {
        this(supplier, Duration.ofSeconds(30L));
    }

    SimpleTokenCache(Supplier<Mono<AccessToken>> supplier, Duration duration) {
        this.nextTokenRefresh = OffsetDateTime.now();
        this.wip = new AtomicReference<>();
        this.tokenSupplier = supplier;
        this.shouldRefresh = new Predicate() { // from class: com.azure.core.credential.SimpleTokenCache$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SimpleTokenCache.lambda$new$0((AccessToken) obj);
            }
        };
        this.refreshDelay = duration;
        this.refreshDelayString = String.valueOf(duration.getSeconds());
    }

    static /* synthetic */ boolean lambda$new$0(AccessToken accessToken) {
        OffsetDateTime refreshAt;
        OffsetDateTime offsetDateTimeNow = OffsetDateTime.now();
        if (accessToken.getRefreshAt() == null) {
            refreshAt = accessToken.getExpiresAt().minus((TemporalAmount) REFRESH_OFFSET);
        } else {
            refreshAt = accessToken.getRefreshAt();
        }
        return offsetDateTimeNow.isAfter(refreshAt);
    }

    public Mono<AccessToken> getToken() {
        return Mono.defer(new Supplier() { // from class: com.azure.core.credential.SimpleTokenCache$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1119lambda$getToken$7$comazurecorecredentialSimpleTokenCache();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getToken$7$com-azure-core-credential-SimpleTokenCache, reason: not valid java name */
    /* synthetic */ Mono m1119lambda$getToken$7$comazurecorecredentialSimpleTokenCache() {
        Mono monoDelaySubscription;
        Mono monoEmpty;
        try {
            if (PreviewView$1$.ExternalSyntheticBackportWithForwarding0.m(this.wip, (Object) null, Sinks.one())) {
                final Sinks.One<AccessToken> one = this.wip.get();
                final OffsetDateTime offsetDateTimeNow = OffsetDateTime.now();
                if (this.cache != null && !this.shouldRefresh.test(this.cache)) {
                    monoDelaySubscription = Mono.empty();
                    monoEmpty = Mono.just(this.cache);
                } else if (this.cache == null || this.cache.isExpired()) {
                    if (offsetDateTimeNow.isAfter(this.nextTokenRefresh)) {
                        monoDelaySubscription = Mono.defer(this.tokenSupplier);
                    } else {
                        monoDelaySubscription = Mono.defer(this.tokenSupplier).delaySubscription(Duration.between(offsetDateTimeNow, this.nextTokenRefresh));
                    }
                    monoEmpty = Mono.empty();
                } else {
                    if (offsetDateTimeNow.isAfter(this.nextTokenRefresh)) {
                        monoDelaySubscription = Mono.defer(this.tokenSupplier);
                    } else {
                        monoDelaySubscription = Mono.empty();
                    }
                    monoEmpty = Mono.just(this.cache);
                }
                final Mono mono = monoDelaySubscription;
                final Mono mono2 = monoEmpty;
                return Mono.using(new Callable() { // from class: com.azure.core.credential.SimpleTokenCache$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f$0.m1115lambda$getToken$1$comazurecorecredentialSimpleTokenCache();
                    }
                }, new Function() { // from class: com.azure.core.credential.SimpleTokenCache$$ExternalSyntheticLambda1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.f$0.m1117lambda$getToken$4$comazurecorecredentialSimpleTokenCache(mono, offsetDateTimeNow, one, mono2, (AtomicReference) obj);
                    }
                }, new Consumer() { // from class: com.azure.core.credential.SimpleTokenCache$$ExternalSyntheticLambda2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((AtomicReference) obj).set(null);
                    }
                });
            }
            if (this.cache != null && !this.cache.isExpired()) {
                return Mono.just(this.cache);
            }
            Sinks.One<AccessToken> one2 = this.wip.get();
            if (one2 == null) {
                return Mono.just(this.cache);
            }
            return one2.asMono().switchIfEmpty(Mono.fromSupplier(new Supplier() { // from class: com.azure.core.credential.SimpleTokenCache$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.m1118lambda$getToken$6$comazurecorecredentialSimpleTokenCache();
                }
            }));
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    /* JADX INFO: renamed from: lambda$getToken$1$com-azure-core-credential-SimpleTokenCache, reason: not valid java name */
    /* synthetic */ AtomicReference m1115lambda$getToken$1$comazurecorecredentialSimpleTokenCache() throws Exception {
        return this.wip;
    }

    /* JADX INFO: renamed from: lambda$getToken$4$com-azure-core-credential-SimpleTokenCache, reason: not valid java name */
    /* synthetic */ Mono m1117lambda$getToken$4$comazurecorecredentialSimpleTokenCache(Mono mono, final OffsetDateTime offsetDateTime, final Sinks.One one, final Mono mono2, AtomicReference atomicReference) {
        Mono monoFlatMap = mono.materialize().flatMap(new Function() { // from class: com.azure.core.credential.SimpleTokenCache$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1116lambda$getToken$3$comazurecorecredentialSimpleTokenCache(offsetDateTime, one, mono2, (Signal) obj);
            }
        });
        Objects.requireNonNull(one);
        return monoFlatMap.doOnError(new SimpleTokenCache$$ExternalSyntheticLambda6(one));
    }

    /* JADX INFO: renamed from: lambda$getToken$3$com-azure-core-credential-SimpleTokenCache, reason: not valid java name */
    /* synthetic */ Mono m1116lambda$getToken$3$comazurecorecredentialSimpleTokenCache(OffsetDateTime offsetDateTime, Sinks.One one, Mono mono, Signal signal) {
        AccessToken accessToken = (AccessToken) signal.get();
        final Throwable throwable = signal.getThrowable();
        if (signal.isOnNext() && accessToken != null) {
            buildTokenRefreshLog(LogLevel.INFORMATIONAL, this.cache, offsetDateTime).log("Acquired a new access token");
            this.cache = accessToken;
            one.tryEmitValue(accessToken);
            this.nextTokenRefresh = OffsetDateTime.now().plus((TemporalAmount) this.refreshDelay);
            return Mono.just(accessToken);
        }
        if (signal.isOnError() && throwable != null) {
            buildTokenRefreshLog(LogLevel.ERROR, this.cache, offsetDateTime).log("Failed to acquire a new access token");
            this.nextTokenRefresh = OffsetDateTime.now().plus((TemporalAmount) this.refreshDelay);
            return mono.switchIfEmpty(Mono.error(new Supplier() { // from class: com.azure.core.credential.SimpleTokenCache$$ExternalSyntheticLambda7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return SimpleTokenCache.lambda$getToken$2(throwable);
                }
            }));
        }
        one.tryEmitEmpty();
        return mono;
    }

    /* JADX INFO: renamed from: lambda$getToken$6$com-azure-core-credential-SimpleTokenCache, reason: not valid java name */
    /* synthetic */ AccessToken m1118lambda$getToken$6$comazurecorecredentialSimpleTokenCache() {
        return this.cache;
    }

    Sinks.One<AccessToken> getWipValue() {
        return this.wip.get();
    }

    private LoggingEventBuilder buildTokenRefreshLog(LogLevel logLevel, AccessToken accessToken, OffsetDateTime offsetDateTime) {
        ClientLogger clientLogger = LOGGER;
        LoggingEventBuilder loggingEventBuilderAtLevel = clientLogger.atLevel(logLevel);
        if (accessToken == null || !clientLogger.canLogAtLevel(logLevel)) {
            return loggingEventBuilderAtLevel;
        }
        Duration durationBetween = Duration.between(offsetDateTime, accessToken.getExpiresAt());
        return loggingEventBuilderAtLevel.addKeyValue("expiresAt", accessToken.getExpiresAt()).addKeyValue("tteSeconds", String.valueOf(durationBetween.abs().getSeconds())).addKeyValue("retryAfterSeconds", this.refreshDelayString).addKeyValue("expired", durationBetween.isNegative());
    }
}
