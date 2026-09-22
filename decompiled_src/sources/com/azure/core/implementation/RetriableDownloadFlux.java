package com.azure.core.implementation;

import com.azure.core.http.policy.RetryOptions;
import com.azure.core.http.policy.RetryStrategy;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.reactivestreams.Publisher;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class RetriableDownloadFlux extends Flux<ByteBuffer> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) RetriableDownloadFlux.class);
    private final Supplier<Flux<ByteBuffer>> downloadSupplier;
    private final int maxRetries;
    private final BiFunction<Throwable, Long, Flux<ByteBuffer>> onDownloadErrorResume;
    private final long position;
    private final int retryCount;
    private final RetryStrategy retryStrategy;

    public RetriableDownloadFlux(Supplier<Flux<ByteBuffer>> supplier, BiFunction<Throwable, Long, Flux<ByteBuffer>> biFunction, RetryOptions retryOptions, long j) {
        this(supplier, biFunction, ImplUtils.getRetryStrategyFromOptions(retryOptions), j, 0);
    }

    private RetriableDownloadFlux(Supplier<Flux<ByteBuffer>> supplier, BiFunction<Throwable, Long, Flux<ByteBuffer>> biFunction, RetryStrategy retryStrategy, long j, int i) {
        this.downloadSupplier = supplier;
        this.onDownloadErrorResume = biFunction;
        this.retryStrategy = retryStrategy;
        this.maxRetries = retryStrategy.getMaxRetries();
        this.position = j;
        this.retryCount = i;
    }

    public void subscribe(CoreSubscriber<? super ByteBuffer> coreSubscriber) {
        final long[] jArr = {this.position};
        this.downloadSupplier.get().map(new Function() { // from class: com.azure.core.implementation.RetriableDownloadFlux$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return RetriableDownloadFlux.lambda$subscribe$0(jArr, (ByteBuffer) obj);
            }
        }).onErrorResume(Exception.class, new Function() { // from class: com.azure.core.implementation.RetriableDownloadFlux$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1161x40877de5(jArr, (Exception) obj);
            }
        }).subscribe(coreSubscriber);
    }

    static /* synthetic */ ByteBuffer lambda$subscribe$0(long[] jArr, ByteBuffer byteBuffer) {
        jArr[0] = jArr[0] + ((long) byteBuffer.remaining());
        return byteBuffer;
    }

    /* JADX INFO: renamed from: lambda$subscribe$4$com-azure-core-implementation-RetriableDownloadFlux, reason: not valid java name */
    /* synthetic */ Publisher m1161x40877de5(final long[] jArr, final Exception exc) {
        final int i = this.retryCount + 1;
        if (i > this.maxRetries) {
            LOGGER.log(LogLevel.ERROR, new Supplier() { // from class: com.azure.core.implementation.RetriableDownloadFlux$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.m1158x98d76962();
                }
            }, exc);
            return Flux.error(exc);
        }
        LOGGER.log(LogLevel.INFORMATIONAL, new Supplier() { // from class: com.azure.core.implementation.RetriableDownloadFlux$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1159x26121ae3(i);
            }
        }, exc);
        Duration durationCalculateRetryDelay = this.retryStrategy.calculateRetryDelay(i);
        RetriableDownloadFlux retriableDownloadFlux = new RetriableDownloadFlux(new Supplier() { // from class: com.azure.core.implementation.RetriableDownloadFlux$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1160xb34ccc64(exc, jArr);
            }
        }, this.onDownloadErrorResume, this.retryStrategy, jArr[0], i);
        return (durationCalculateRetryDelay == null || durationCalculateRetryDelay.isNegative() || durationCalculateRetryDelay.isZero()) ? retriableDownloadFlux : retriableDownloadFlux.delaySubscription(durationCalculateRetryDelay);
    }

    /* JADX INFO: renamed from: lambda$subscribe$1$com-azure-core-implementation-RetriableDownloadFlux, reason: not valid java name */
    /* synthetic */ String m1158x98d76962() {
        return "Exhausted all retry attempts while downloading, " + this.maxRetries + " of " + this.maxRetries + ".";
    }

    /* JADX INFO: renamed from: lambda$subscribe$2$com-azure-core-implementation-RetriableDownloadFlux, reason: not valid java name */
    /* synthetic */ String m1159x26121ae3(int i) {
        return "Using retry attempt " + i + " of " + this.maxRetries + " while downloading.";
    }

    /* JADX INFO: renamed from: lambda$subscribe$3$com-azure-core-implementation-RetriableDownloadFlux, reason: not valid java name */
    /* synthetic */ Flux m1160xb34ccc64(Exception exc, long[] jArr) {
        return this.onDownloadErrorResume.apply(exc, Long.valueOf(jArr[0]));
    }
}
