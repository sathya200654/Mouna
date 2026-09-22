package com.azure.core.implementation.accesshelpers;

import com.azure.core.http.policy.FixedDelay;
import com.azure.core.http.policy.FixedDelayOptions;
import com.azure.core.http.policy.RequestRetryCondition;
import java.time.Duration;
import java.util.function.Predicate;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class FixedDelayAccessHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static FixedDelayAccessor accessor;

    public interface FixedDelayAccessor {
        FixedDelay create(FixedDelayOptions fixedDelayOptions, Predicate<RequestRetryCondition> predicate);
    }

    public static void setAccessor(FixedDelayAccessor fixedDelayAccessor) {
        accessor = fixedDelayAccessor;
    }

    public static FixedDelay create(FixedDelayOptions fixedDelayOptions, Predicate<RequestRetryCondition> predicate) {
        if (accessor == null) {
            new FixedDelay(1, Duration.ofMillis(1L));
        }
        return accessor.create(fixedDelayOptions, predicate);
    }

    private FixedDelayAccessHelper() {
    }
}
