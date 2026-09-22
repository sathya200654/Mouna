package com.azure.core.implementation.accesshelpers;

import com.azure.core.http.policy.ExponentialBackoff;
import com.azure.core.http.policy.ExponentialBackoffOptions;
import com.azure.core.http.policy.RequestRetryCondition;
import java.util.function.Predicate;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ExponentialBackoffAccessHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ExponentialBackoffAccessor accessor;

    public interface ExponentialBackoffAccessor {
        ExponentialBackoff create(ExponentialBackoffOptions exponentialBackoffOptions, Predicate<RequestRetryCondition> predicate);
    }

    public static void setAccessor(ExponentialBackoffAccessor exponentialBackoffAccessor) {
        accessor = exponentialBackoffAccessor;
    }

    public static ExponentialBackoff create(ExponentialBackoffOptions exponentialBackoffOptions, Predicate<RequestRetryCondition> predicate) {
        if (accessor == null) {
            new ExponentialBackoff();
        }
        return accessor.create(exponentialBackoffOptions, predicate);
    }

    private ExponentialBackoffAccessHelper() {
    }
}
