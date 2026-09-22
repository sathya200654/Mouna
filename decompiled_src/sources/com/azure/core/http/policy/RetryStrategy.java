package com.azure.core.http.policy;

import com.azure.core.http.HttpResponse;
import java.time.Duration;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface RetryStrategy {
    public static final int HTTP_STATUS_TOO_MANY_REQUESTS = 429;

    Duration calculateRetryDelay(int i);

    int getMaxRetries();

    default boolean shouldRetry(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        if (statusCode == 408 || statusCode == 429) {
            return true;
        }
        return (statusCode < 500 || statusCode == 501 || statusCode == 505) ? false : true;
    }

    default boolean shouldRetryException(Throwable th) {
        return th instanceof Exception;
    }

    default boolean shouldRetryCondition(RequestRetryCondition requestRetryCondition) {
        if (requestRetryCondition.getResponse() != null) {
            return shouldRetry(requestRetryCondition.getResponse());
        }
        return shouldRetryException(requestRetryCondition.getThrowable());
    }
}
