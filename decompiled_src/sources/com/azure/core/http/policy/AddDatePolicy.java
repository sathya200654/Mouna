package com.azure.core.http.policy;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.DateTimeRfc1123;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class AddDatePolicy implements HttpPipelinePolicy {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'").withZone(ZoneOffset.UTC).withLocale(Locale.US);

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(final HttpPipelineCallContext httpPipelineCallContext, final HttpPipelineNextPolicy httpPipelineNextPolicy) {
        return Mono.defer(new Supplier() { // from class: com.azure.core.http.policy.AddDatePolicy$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return AddDatePolicy.lambda$process$0(httpPipelineCallContext, httpPipelineNextPolicy);
            }
        });
    }

    static /* synthetic */ Mono lambda$process$0(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        setDate(httpPipelineCallContext);
        return httpPipelineNextPolicy.process();
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        setDate(httpPipelineCallContext);
        return httpPipelineNextSyncPolicy.processSync();
    }

    private static void setDate(HttpPipelineCallContext httpPipelineCallContext) {
        OffsetDateTime offsetDateTimeNow = OffsetDateTime.now(ZoneOffset.UTC);
        try {
            httpPipelineCallContext.getHttpRequest().setHeader(HttpHeaderName.DATE, DateTimeRfc1123.toRfc1123String(offsetDateTimeNow));
        } catch (IllegalArgumentException unused) {
            httpPipelineCallContext.getHttpRequest().setHeader(HttpHeaderName.DATE, FORMATTER.format(offsetDateTimeNow));
        }
    }
}
