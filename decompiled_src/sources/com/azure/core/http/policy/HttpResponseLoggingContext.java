package com.azure.core.http.policy;

import com.azure.core.http.HttpResponse;
import com.azure.core.util.Context;
import java.time.Duration;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpResponseLoggingContext {
    private final Context context;
    private final HttpResponse httpResponse;
    private final Duration responseDuration;
    private final Integer tryCount;

    HttpResponseLoggingContext(HttpResponse httpResponse, Duration duration, Context context, Integer num) {
        this.httpResponse = httpResponse;
        this.responseDuration = duration;
        this.context = context;
        this.tryCount = num;
    }

    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }

    public Duration getResponseDuration() {
        return this.responseDuration;
    }

    public Context getContext() {
        return this.context;
    }

    public Integer getTryCount() {
        return this.tryCount;
    }
}
