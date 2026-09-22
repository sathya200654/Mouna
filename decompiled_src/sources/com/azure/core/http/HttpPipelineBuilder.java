package com.azure.core.http;

import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.implementation.http.UrlSanitizer;
import com.azure.core.implementation.http.policy.InstrumentationPolicy;
import com.azure.core.util.ClientOptions;
import com.azure.core.util.HttpClientOptions;
import com.azure.core.util.tracing.Tracer;
import com.azure.core.util.tracing.TracerProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpPipelineBuilder {
    private ClientOptions clientOptions;
    private HttpClient httpClient;
    private List<HttpPipelinePolicy> pipelinePolicies;
    private Tracer tracer;

    public HttpPipeline build() {
        List<HttpPipelinePolicy> arrayList = this.pipelinePolicies;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        HttpClient httpClientCreateDefault = this.httpClient;
        if (httpClientCreateDefault == null) {
            ClientOptions clientOptions = this.clientOptions;
            if (clientOptions instanceof HttpClientOptions) {
                httpClientCreateDefault = HttpClient.createDefault((HttpClientOptions) clientOptions);
            } else {
                httpClientCreateDefault = HttpClient.createDefault();
            }
        }
        configureTracing(arrayList, this.clientOptions);
        return new HttpPipeline(httpClientCreateDefault, arrayList, this.tracer);
    }

    private void configureTracing(List<HttpPipelinePolicy> list, ClientOptions clientOptions) {
        if (this.tracer == null) {
            this.tracer = TracerProvider.getDefaultProvider().createTracer("azure-core", null, null, clientOptions == null ? null : clientOptions.getTracingOptions());
        }
        for (HttpPipelinePolicy httpPipelinePolicy : list) {
            if (httpPipelinePolicy instanceof InstrumentationPolicy) {
                ((InstrumentationPolicy) httpPipelinePolicy).initialize(this.tracer, new UrlSanitizer(getAllowedQueryParams(clientOptions)));
            }
        }
    }

    private static Set<String> getAllowedQueryParams(ClientOptions clientOptions) {
        if (clientOptions == null || clientOptions.getTracingOptions() == null) {
            return null;
        }
        return clientOptions.getTracingOptions().getAllowedTracingQueryParamNames();
    }

    public HttpPipelineBuilder httpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public HttpPipelineBuilder policies(HttpPipelinePolicy... httpPipelinePolicyArr) {
        if (this.pipelinePolicies == null) {
            this.pipelinePolicies = new ArrayList();
        }
        this.pipelinePolicies.addAll(Arrays.asList(httpPipelinePolicyArr));
        return this;
    }

    public HttpPipelineBuilder clientOptions(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        return this;
    }

    public HttpPipelineBuilder tracer(Tracer tracer) {
        this.tracer = tracer;
        return this;
    }
}
