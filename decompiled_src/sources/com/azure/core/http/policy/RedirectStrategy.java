package com.azure.core.http.policy;

import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface RedirectStrategy {
    HttpRequest createRedirectRequest(HttpResponse httpResponse);

    int getMaxAttempts();

    boolean shouldAttemptRedirect(HttpPipelineCallContext httpPipelineCallContext, HttpResponse httpResponse, int i, Set<String> set);
}
