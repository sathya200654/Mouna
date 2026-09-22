package com.azure.core.http.policy;

import com.azure.core.implementation.accesshelpers.ExponentialBackoffAccessHelper;
import com.azure.core.implementation.util.ObjectsUtil;
import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ExponentialBackoff implements RetryStrategy {
    private static final int DEFAULT_MAX_RETRIES;
    private static final double JITTER_FACTOR = 0.05d;
    private final long baseDelayNanos;
    private final long maxDelayNanos;
    private final int maxRetries;
    private final Predicate<RequestRetryCondition> shouldRetryCondition;
    private static final Duration DEFAULT_BASE_DELAY = Duration.ofMillis(800);
    private static final Duration DEFAULT_MAX_DELAY = Duration.ofSeconds(8);
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ExponentialBackoff.class);

    public static /* synthetic */ ExponentialBackoff $r8$lambda$KRq2D6BKf2khnwep5RpB4BinFeQ(ExponentialBackoffOptions exponentialBackoffOptions, Predicate predicate) {
        return new ExponentialBackoff(exponentialBackoffOptions, predicate);
    }

    static {
        String str = Configuration.getGlobalConfiguration().get(Configuration.PROPERTY_AZURE_REQUEST_RETRY_COUNT);
        int i = 3;
        if (!CoreUtils.isNullOrEmpty(str)) {
            try {
                int i2 = Integer.parseInt(str);
                if (i2 >= 0) {
                    i = i2;
                }
            } catch (NumberFormatException unused) {
                LOGGER.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.http.policy.ExponentialBackoff$$ExternalSyntheticLambda0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return ExponentialBackoff.lambda$static$0();
                    }
                });
            }
        }
        DEFAULT_MAX_RETRIES = i;
        ExponentialBackoffAccessHelper.setAccessor(new ExponentialBackoffAccessHelper.ExponentialBackoffAccessor() { // from class: com.azure.core.http.policy.ExponentialBackoff$$ExternalSyntheticLambda1
            @Override // com.azure.core.implementation.accesshelpers.ExponentialBackoffAccessHelper.ExponentialBackoffAccessor
            public final ExponentialBackoff create(ExponentialBackoffOptions exponentialBackoffOptions, Predicate predicate) {
                return ExponentialBackoff.$r8$lambda$KRq2D6BKf2khnwep5RpB4BinFeQ(exponentialBackoffOptions, predicate);
            }
        });
    }

    static /* synthetic */ String lambda$static$0() {
        return "AZURE_REQUEST_RETRY_COUNT was loaded but is an invalid number. Using 3 retries as the maximum.";
    }

    public ExponentialBackoff() {
        this(DEFAULT_MAX_RETRIES, DEFAULT_BASE_DELAY, DEFAULT_MAX_DELAY);
    }

    public ExponentialBackoff(ExponentialBackoffOptions exponentialBackoffOptions) {
        this(((Integer) ObjectsUtil.requireNonNullElse(((ExponentialBackoffOptions) Objects.requireNonNull(exponentialBackoffOptions, "'options' cannot be null.")).getMaxRetries(), Integer.valueOf(DEFAULT_MAX_RETRIES))).intValue(), (Duration) ObjectsUtil.requireNonNullElse(((ExponentialBackoffOptions) Objects.requireNonNull(exponentialBackoffOptions, "'options' cannot be null.")).getBaseDelay(), DEFAULT_BASE_DELAY), (Duration) ObjectsUtil.requireNonNullElse(((ExponentialBackoffOptions) Objects.requireNonNull(exponentialBackoffOptions, "'options' cannot be null.")).getMaxDelay(), DEFAULT_MAX_DELAY));
    }

    private ExponentialBackoff(ExponentialBackoffOptions exponentialBackoffOptions, Predicate<RequestRetryCondition> predicate) {
        this(((Integer) ObjectsUtil.requireNonNullElse(((ExponentialBackoffOptions) Objects.requireNonNull(exponentialBackoffOptions, "'options' cannot be null.")).getMaxRetries(), Integer.valueOf(DEFAULT_MAX_RETRIES))).intValue(), (Duration) ObjectsUtil.requireNonNullElse(((ExponentialBackoffOptions) Objects.requireNonNull(exponentialBackoffOptions, "'options' cannot be null.")).getBaseDelay(), DEFAULT_BASE_DELAY), (Duration) ObjectsUtil.requireNonNullElse(((ExponentialBackoffOptions) Objects.requireNonNull(exponentialBackoffOptions, "'options' cannot be null.")).getMaxDelay(), DEFAULT_MAX_DELAY), predicate);
    }

    public ExponentialBackoff(int i, Duration duration, Duration duration2) {
        this(i, duration, duration2, null);
    }

    private ExponentialBackoff(int i, Duration duration, Duration duration2, Predicate<RequestRetryCondition> predicate) {
        if (i < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("Max retries cannot be less than 0."));
        }
        Objects.requireNonNull(duration, "'baseDelay' cannot be null.");
        Objects.requireNonNull(duration2, "'maxDelay' cannot be null.");
        if (duration.isZero() || duration.isNegative()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'baseDelay' cannot be negative or 0."));
        }
        if (duration.compareTo(duration2) > 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'baseDelay' cannot be greater than 'maxDelay'."));
        }
        this.maxRetries = i;
        this.baseDelayNanos = duration.toNanos();
        this.maxDelayNanos = duration2.toNanos();
        this.shouldRetryCondition = predicate;
    }

    @Override // com.azure.core.http.policy.RetryStrategy
    public int getMaxRetries() {
        return this.maxRetries;
    }

    @Override // com.azure.core.http.policy.RetryStrategy
    public Duration calculateRetryDelay(int i) {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        long j = this.baseDelayNanos;
        return Duration.ofNanos(Math.min((1 << i) * threadLocalRandomCurrent.nextLong((long) (j * 0.95d), (long) (j * 1.05d)), this.maxDelayNanos));
    }

    @Override // com.azure.core.http.policy.RetryStrategy
    public boolean shouldRetryCondition(RequestRetryCondition requestRetryCondition) {
        Predicate<RequestRetryCondition> predicate = this.shouldRetryCondition;
        if (predicate == null) {
            return super.shouldRetryCondition(requestRetryCondition);
        }
        return predicate.test(requestRetryCondition);
    }
}
