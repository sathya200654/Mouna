package com.azure.core.implementation;

import androidx.camera.view.PreviewView$1$;
import com.azure.core.credential.AccessToken;
import com.azure.core.credential.SimpleTokenCache$$ExternalSyntheticLambda6;
import com.azure.core.credential.TokenCredential;
import com.azure.core.credential.TokenRequestContext;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.azure.core.util.logging.LoggingEventBuilder;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;
import reactor.core.publisher.Sinks;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AccessTokenCache {
    private static final ClientLogger LOGGER;
    private static final Duration REFRESH_DELAY;
    private static final String REFRESH_DELAY_STRING;
    private static final Duration REFRESH_OFFSET;
    private final AtomicReference<AccessTokenCacheInfo> cacheInfo;
    private final Lock lock;
    private final Predicate<AccessToken> shouldRefresh;
    private final TokenCredential tokenCredential;
    private TokenRequestContext tokenRequestContext;
    private final Supplier<Mono<AccessToken>> tokenSupplierAsync;
    private final Supplier<AccessToken> tokenSupplierSync;
    private final AtomicReference<Sinks.One<AccessToken>> wip;

    static /* synthetic */ AccessToken lambda$retrieveToken$9(AccessToken accessToken) {
        return accessToken;
    }

    static {
        Duration durationOfSeconds = Duration.ofSeconds(30L);
        REFRESH_DELAY = durationOfSeconds;
        REFRESH_DELAY_STRING = String.valueOf(durationOfSeconds.getSeconds());
        REFRESH_OFFSET = Duration.ofMinutes(5L);
        LOGGER = new ClientLogger((Class<?>) AccessTokenCache.class);
    }

    public AccessTokenCache(final TokenCredential tokenCredential) {
        Objects.requireNonNull(tokenCredential, "The token credential cannot be null");
        this.wip = new AtomicReference<>();
        this.tokenCredential = tokenCredential;
        this.cacheInfo = new AtomicReference<>(new AccessTokenCacheInfo(null, OffsetDateTime.now()));
        this.shouldRefresh = new Predicate() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda7
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AccessTokenCache.lambda$new$0((AccessToken) obj);
            }
        };
        this.tokenSupplierAsync = new Supplier() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1150lambda$new$1$comazurecoreimplementationAccessTokenCache(tokenCredential);
            }
        };
        this.tokenSupplierSync = new Supplier() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda9
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1151lambda$new$2$comazurecoreimplementationAccessTokenCache(tokenCredential);
            }
        };
        this.lock = new ReentrantLock();
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

    /* JADX INFO: renamed from: lambda$new$1$com-azure-core-implementation-AccessTokenCache, reason: not valid java name */
    /* synthetic */ Mono m1150lambda$new$1$comazurecoreimplementationAccessTokenCache(TokenCredential tokenCredential) {
        return tokenCredential.getToken(this.tokenRequestContext);
    }

    /* JADX INFO: renamed from: lambda$new$2$com-azure-core-implementation-AccessTokenCache, reason: not valid java name */
    /* synthetic */ AccessToken m1151lambda$new$2$comazurecoreimplementationAccessTokenCache(TokenCredential tokenCredential) {
        return tokenCredential.getTokenSync(this.tokenRequestContext);
    }

    public Mono<AccessToken> getToken(TokenRequestContext tokenRequestContext, boolean z) {
        return Mono.defer(retrieveToken(tokenRequestContext, z)).repeatWhenEmpty(new Function() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda11
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Flux) obj).concatMap(new Function() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda10
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return Flux.just(true).delayElements(Duration.ofMillis(500L));
                    }
                });
            }
        });
    }

    public AccessToken getTokenSync(TokenRequestContext tokenRequestContext, boolean z) {
        this.lock.lock();
        try {
            return retrieveTokenSync(tokenRequestContext, z).get();
        } finally {
            this.lock.unlock();
        }
    }

    private Supplier<Mono<? extends AccessToken>> retrieveToken(final TokenRequestContext tokenRequestContext, final boolean z) {
        return new Supplier() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda12
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1153xb6374305(tokenRequestContext, z);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$retrieveToken$10$com-azure-core-implementation-AccessTokenCache, reason: not valid java name */
    /* synthetic */ Mono m1153xb6374305(TokenRequestContext tokenRequestContext, boolean z) {
        Mono monoDefer;
        Mono monoEmpty;
        try {
            if (tokenRequestContext == null) {
                return Mono.error(LOGGER.logExceptionAsError(new IllegalArgumentException("The token request context input cannot be null.")));
            }
            AccessTokenCacheInfo accessTokenCacheInfo = this.cacheInfo.get();
            final AccessToken cachedAccessToken = accessTokenCacheInfo.getCachedAccessToken();
            if (!PreviewView$1$.ExternalSyntheticBackportWithForwarding0.m(this.wip, (Object) null, Sinks.one())) {
                if (cachedAccessToken != null && !cachedAccessToken.isExpired() && !z) {
                    return Mono.just(cachedAccessToken);
                }
                if (z) {
                    return Mono.empty();
                }
                Sinks.One<AccessToken> one = this.wip.get();
                return one == null ? Mono.just(cachedAccessToken) : one.asMono().switchIfEmpty(Mono.fromSupplier(new Supplier() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda4
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return AccessTokenCache.lambda$retrieveToken$9(cachedAccessToken);
                    }
                }));
            }
            final Sinks.One<AccessToken> one2 = this.wip.get();
            final OffsetDateTime offsetDateTimeNow = OffsetDateTime.now();
            if ((z && checkIfForceRefreshRequired(tokenRequestContext)) || this.tokenRequestContext == null) {
                this.tokenRequestContext = tokenRequestContext;
                monoDefer = Mono.defer(new Supplier() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return this.f$0.m1154x1c7973f7();
                    }
                });
                monoEmpty = Mono.empty();
            } else if (cachedAccessToken != null && !this.shouldRefresh.test(cachedAccessToken)) {
                monoDefer = Mono.empty();
                monoEmpty = Mono.just(cachedAccessToken);
            } else if (cachedAccessToken == null || cachedAccessToken.isExpired()) {
                monoDefer = Mono.defer(this.tokenSupplierAsync);
                monoEmpty = Mono.empty();
            } else {
                monoDefer = offsetDateTimeNow.isAfter(accessTokenCacheInfo.getNextTokenRefresh()) ? Mono.defer(this.tokenSupplierAsync) : Mono.empty();
                monoEmpty = Mono.just(cachedAccessToken);
            }
            final Mono mono = monoDefer;
            final Mono mono2 = monoEmpty;
            return Mono.using(new Callable() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m1155x564415d6();
                }
            }, new Function() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m1156x900eb7b5(mono, one2, offsetDateTimeNow, mono2, (AtomicReference) obj);
                }
            }, new Consumer() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((AtomicReference) obj).set(null);
                }
            });
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    /* JADX INFO: renamed from: lambda$retrieveToken$5$com-azure-core-implementation-AccessTokenCache, reason: not valid java name */
    /* synthetic */ Mono m1154x1c7973f7() {
        return this.tokenCredential.getToken(this.tokenRequestContext);
    }

    /* JADX INFO: renamed from: lambda$retrieveToken$6$com-azure-core-implementation-AccessTokenCache, reason: not valid java name */
    /* synthetic */ AtomicReference m1155x564415d6() throws Exception {
        return this.wip;
    }

    /* JADX INFO: renamed from: lambda$retrieveToken$7$com-azure-core-implementation-AccessTokenCache, reason: not valid java name */
    /* synthetic */ Mono m1156x900eb7b5(Mono mono, Sinks.One one, OffsetDateTime offsetDateTime, Mono mono2, AtomicReference atomicReference) {
        Mono monoFlatMap = mono.materialize().flatMap(processTokenRefreshResult(one, offsetDateTime, mono2));
        Objects.requireNonNull(one);
        return monoFlatMap.doOnError(new SimpleTokenCache$$ExternalSyntheticLambda6(one));
    }

    private Supplier<AccessToken> retrieveTokenSync(final TokenRequestContext tokenRequestContext, final boolean z) {
        return new Supplier() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1157xe0762edf(tokenRequestContext, z);
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:34:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: lambda$retrieveTokenSync$11$com-azure-core-implementation-AccessTokenCache, reason: not valid java name */
    /* synthetic */ AccessToken m1157xe0762edf(TokenRequestContext tokenRequestContext, boolean z) {
        Supplier<AccessToken> supplier;
        AccessToken accessToken;
        if (tokenRequestContext == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("The token request context input cannot be null."));
        }
        AccessTokenCacheInfo accessTokenCacheInfo = this.cacheInfo.get();
        AccessToken cachedAccessToken = accessTokenCacheInfo.getCachedAccessToken();
        OffsetDateTime offsetDateTimeNow = OffsetDateTime.now();
        Supplier<AccessToken> supplier2 = null;
        if ((!z || !checkIfForceRefreshRequired(tokenRequestContext)) && this.tokenRequestContext != null) {
            if (cachedAccessToken == null || this.shouldRefresh.test(cachedAccessToken)) {
                if (cachedAccessToken == null || cachedAccessToken.isExpired()) {
                    supplier = this.tokenSupplierSync;
                } else if (offsetDateTimeNow.isAfter(accessTokenCacheInfo.getNextTokenRefresh())) {
                    supplier2 = this.tokenSupplierSync;
                }
            }
            accessToken = cachedAccessToken;
            if (supplier2 != null) {
                try {
                    AccessToken accessToken2 = supplier2.get();
                    buildTokenRefreshLog(LogLevel.VERBOSE, cachedAccessToken, offsetDateTimeNow).log("Acquired a new access token.");
                    this.cacheInfo.set(new AccessTokenCacheInfo(accessToken2, OffsetDateTime.now().plus((TemporalAmount) REFRESH_DELAY)));
                    return accessToken2;
                } catch (Throwable th) {
                    buildTokenRefreshLog(LogLevel.ERROR, cachedAccessToken, offsetDateTimeNow).log("Failed to acquire a new access token.", th);
                    this.cacheInfo.set(new AccessTokenCacheInfo(cachedAccessToken, OffsetDateTime.now()));
                    if (accessToken == null) {
                        throw th;
                    }
                }
            }
            return accessToken;
        }
        this.tokenRequestContext = tokenRequestContext;
        supplier = this.tokenSupplierSync;
        supplier2 = supplier;
        accessToken = null;
        if (supplier2 != null) {
            AccessToken accessToken3 = supplier2.get();
            buildTokenRefreshLog(LogLevel.VERBOSE, cachedAccessToken, offsetDateTimeNow).log("Acquired a new access token.");
            this.cacheInfo.set(new AccessTokenCacheInfo(accessToken3, OffsetDateTime.now().plus((TemporalAmount) REFRESH_DELAY)));
            return accessToken3;
        }
        return accessToken;
    }

    private boolean checkIfForceRefreshRequired(TokenRequestContext tokenRequestContext) {
        TokenRequestContext tokenRequestContext2 = this.tokenRequestContext;
        if (tokenRequestContext2 == null) {
            return true;
        }
        if (tokenRequestContext2.getClaims() == null) {
            if (tokenRequestContext.getClaims() != null) {
                return true;
            }
        } else if (tokenRequestContext.getClaims() == null || !tokenRequestContext.getClaims().equals(this.tokenRequestContext.getClaims())) {
            return true;
        }
        return !this.tokenRequestContext.getScopes().equals(tokenRequestContext.getScopes());
    }

    private Function<Signal<AccessToken>, Mono<? extends AccessToken>> processTokenRefreshResult(final Sinks.One<AccessToken> one, final OffsetDateTime offsetDateTime, final Mono<AccessToken> mono) {
        return new Function() { // from class: com.azure.core.implementation.AccessTokenCache$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1152x73243b14(offsetDateTime, one, mono, (Signal) obj);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$processTokenRefreshResult$12$com-azure-core-implementation-AccessTokenCache, reason: not valid java name */
    /* synthetic */ Mono m1152x73243b14(OffsetDateTime offsetDateTime, Sinks.One one, Mono mono, Signal signal) {
        AccessToken accessToken = (AccessToken) signal.get();
        Throwable throwable = signal.getThrowable();
        AccessToken cachedAccessToken = this.cacheInfo.get().getCachedAccessToken();
        if (signal.isOnNext() && accessToken != null) {
            buildTokenRefreshLog(LogLevel.VERBOSE, cachedAccessToken, offsetDateTime).log("Acquired a new access token.");
            one.tryEmitValue(accessToken);
            this.cacheInfo.set(new AccessTokenCacheInfo(accessToken, OffsetDateTime.now().plus((TemporalAmount) REFRESH_DELAY)));
            return Mono.just(accessToken);
        }
        if (signal.isOnError() && throwable != null) {
            buildTokenRefreshLog(LogLevel.ERROR, cachedAccessToken, offsetDateTime).log("Failed to acquire a new access token.", throwable);
            this.cacheInfo.set(new AccessTokenCacheInfo(cachedAccessToken, OffsetDateTime.now()));
            return mono.switchIfEmpty(Mono.error(throwable));
        }
        one.tryEmitEmpty();
        return mono;
    }

    private static LoggingEventBuilder buildTokenRefreshLog(LogLevel logLevel, AccessToken accessToken, OffsetDateTime offsetDateTime) {
        ClientLogger clientLogger = LOGGER;
        LoggingEventBuilder loggingEventBuilderAtLevel = clientLogger.atLevel(logLevel);
        if (accessToken == null || !clientLogger.canLogAtLevel(logLevel)) {
            return loggingEventBuilderAtLevel;
        }
        Duration durationUntilExpiration = accessToken.getDurationUntilExpiration();
        return loggingEventBuilderAtLevel.addKeyValue("expiresAt", accessToken.getExpiresAt()).addKeyValue("tteSeconds", String.valueOf(durationUntilExpiration.abs().getSeconds())).addKeyValue("retryAfterSeconds", REFRESH_DELAY_STRING).addKeyValue("expired", durationUntilExpiration.isNegative());
    }
}
