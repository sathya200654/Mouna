package com.azure.core.implementation.http;

import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpClientProvider;
import com.azure.core.implementation.util.Providers;
import com.azure.core.util.ClientOptions;
import com.azure.core.util.Configuration;
import com.azure.core.util.HttpClientOptions;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpClientProviders {
    private static final String NO_DEFAULT_PROVIDER_MESSAGE = "A request was made to load the default HttpClient provider but one could not be found on the classpath. If you are using a dependency manager, consider including a dependency on azure-core-http-netty or azure-core-http-okhttp. Depending on your existing dependencies, you have the choice of Netty or OkHttp implementations. Additionally, refer to https://aka.ms/azsdk/java/docs/custom-httpclient to learn about writing your own implementation.";
    private static final Providers<HttpClientProvider, HttpClient> HTTP_CLIENT_PROVIDERS = new Providers<>(HttpClientProvider.class, Configuration.getGlobalConfiguration().get(Configuration.PROPERTY_AZURE_HTTP_CLIENT_IMPLEMENTATION), NO_DEFAULT_PROVIDER_MESSAGE);

    private HttpClientProviders() {
    }

    public static HttpClient createInstance() {
        return createInstance(null);
    }

    public static HttpClient createInstance(ClientOptions clientOptions) {
        final HttpClientOptions httpClientOptions;
        Class<? extends HttpClientProvider> httpClientProvider;
        if (clientOptions instanceof HttpClientOptions) {
            httpClientOptions = (HttpClientOptions) clientOptions;
            httpClientProvider = httpClientOptions.getHttpClientProvider();
        } else {
            httpClientOptions = null;
            httpClientProvider = null;
        }
        return HTTP_CLIENT_PROVIDERS.create(new Function() { // from class: com.azure.core.implementation.http.HttpClientProviders$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((HttpClientProvider) obj).createInstance(httpClientOptions);
            }
        }, null, httpClientProvider);
    }
}
