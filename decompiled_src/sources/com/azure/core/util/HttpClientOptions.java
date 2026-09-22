package com.azure.core.util;

import com.azure.core.http.HttpClientProvider;
import com.azure.core.http.ProxyOptions;
import com.azure.core.implementation.util.HttpUtils;
import com.azure.core.util.logging.ClientLogger;
import java.time.Duration;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpClientOptions extends ClientOptions {
    private static final Duration DEFAULT_CONNECTION_IDLE_TIMEOUT = Duration.ofSeconds(60);
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) HttpClientOptions.class);
    private Configuration configuration;
    private Duration connectTimeout;
    private Duration connectionIdleTimeout;
    private Class<? extends HttpClientProvider> httpClientProvider;
    private Integer maximumConnectionPoolSize;
    private ProxyOptions proxyOptions;
    private Duration readTimeout;
    private Duration responseTimeout;
    private Duration writeTimeout;

    @Override // com.azure.core.util.ClientOptions
    public /* bridge */ /* synthetic */ ClientOptions setHeaders(Iterable iterable) {
        return setHeaders((Iterable<Header>) iterable);
    }

    @Override // com.azure.core.util.ClientOptions
    public HttpClientOptions setApplicationId(String str) {
        super.setApplicationId(str);
        return this;
    }

    @Override // com.azure.core.util.ClientOptions
    public HttpClientOptions setHeaders(Iterable<Header> iterable) {
        super.setHeaders(iterable);
        return this;
    }

    public HttpClientOptions setProxyOptions(ProxyOptions proxyOptions) {
        this.proxyOptions = proxyOptions;
        return this;
    }

    public ProxyOptions getProxyOptions() {
        return this.proxyOptions;
    }

    public HttpClientOptions setConfiguration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }

    public HttpClientOptions setConnectTimeout(Duration duration) {
        this.connectTimeout = duration;
        return this;
    }

    public Duration getConnectTimeout() {
        return HttpUtils.getTimeout(this.connectTimeout, HttpUtils.getDefaultConnectTimeout());
    }

    public HttpClientOptions setWriteTimeout(Duration duration) {
        this.writeTimeout = duration;
        return this;
    }

    public Duration getWriteTimeout() {
        return HttpUtils.getTimeout(this.writeTimeout, HttpUtils.getDefaultWriteTimeout());
    }

    public HttpClientOptions responseTimeout(Duration duration) {
        this.responseTimeout = duration;
        return this;
    }

    public HttpClientOptions setResponseTimeout(Duration duration) {
        this.responseTimeout = duration;
        return this;
    }

    public Duration getResponseTimeout() {
        return HttpUtils.getTimeout(this.responseTimeout, HttpUtils.getDefaultResponseTimeout());
    }

    public HttpClientOptions readTimeout(Duration duration) {
        this.readTimeout = duration;
        return this;
    }

    public HttpClientOptions setReadTimeout(Duration duration) {
        this.readTimeout = duration;
        return this;
    }

    public Duration getReadTimeout() {
        return HttpUtils.getTimeout(this.readTimeout, HttpUtils.getDefaultReadTimeout());
    }

    public HttpClientOptions setMaximumConnectionPoolSize(Integer num) {
        if (num != null && num.intValue() <= 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'maximumConnectionPoolSize' cannot be less than 1."));
        }
        this.maximumConnectionPoolSize = num;
        return this;
    }

    public Integer getMaximumConnectionPoolSize() {
        return this.maximumConnectionPoolSize;
    }

    public HttpClientOptions setConnectionIdleTimeout(Duration duration) {
        this.connectionIdleTimeout = duration;
        return this;
    }

    public Duration getConnectionIdleTimeout() {
        return HttpUtils.getTimeout(this.connectionIdleTimeout, DEFAULT_CONNECTION_IDLE_TIMEOUT);
    }

    public HttpClientOptions setHttpClientProvider(Class<? extends HttpClientProvider> cls) {
        this.httpClientProvider = cls;
        return this;
    }

    public Class<? extends HttpClientProvider> getHttpClientProvider() {
        return this.httpClientProvider;
    }
}
