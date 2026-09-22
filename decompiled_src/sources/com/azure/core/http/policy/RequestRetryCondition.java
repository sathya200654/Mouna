package com.azure.core.http.policy;

import com.azure.core.http.HttpResponse;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class RequestRetryCondition {
    private final HttpResponse response;
    private final List<Throwable> retriedExceptions;
    private final Throwable throwable;
    private final int tryCount;

    RequestRetryCondition(HttpResponse httpResponse, Throwable th, int i, List<Throwable> list) {
        this.response = httpResponse;
        this.throwable = th;
        this.tryCount = i;
        this.retriedExceptions = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public List<Throwable> getRetriedThrowables() {
        return this.retriedExceptions;
    }
}
