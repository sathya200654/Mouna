package com.azure.core.http.rest;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpRequest;
import com.azure.core.implementation.http.rest.ErrorOptions;
import com.azure.core.implementation.http.rest.UrlEscapers;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import java.util.EnumSet;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class RequestOptions {
    private Context context;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) RequestOptions.class);
    private static final EnumSet<ErrorOptions> DEFAULT = EnumSet.of(ErrorOptions.THROW);
    private Consumer<HttpRequest> requestCallback = new Consumer() { // from class: com.azure.core.http.rest.RequestOptions$$ExternalSyntheticLambda4
        @Override // java.util.function.Consumer
        public final void accept(Object obj) {
            RequestOptions.lambda$new$0((HttpRequest) obj);
        }
    };
    private EnumSet<ErrorOptions> errorOptions = DEFAULT;

    static /* synthetic */ void lambda$new$0(HttpRequest httpRequest) {
    }

    Consumer<HttpRequest> getRequestCallback() {
        return this.requestCallback;
    }

    EnumSet<ErrorOptions> getErrorOptions() {
        return this.errorOptions;
    }

    public Context getContext() {
        return this.context;
    }

    @Deprecated
    public RequestOptions addHeader(final String str, final String str2) {
        this.requestCallback = this.requestCallback.andThen(new Consumer() { // from class: com.azure.core.http.rest.RequestOptions$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((HttpRequest) obj).getHeaders().add(str, str2);
            }
        });
        return this;
    }

    public RequestOptions addHeader(final HttpHeaderName httpHeaderName, final String str) {
        this.requestCallback = this.requestCallback.andThen(new Consumer() { // from class: com.azure.core.http.rest.RequestOptions$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((HttpRequest) obj).getHeaders().add(httpHeaderName, str);
            }
        });
        return this;
    }

    @Deprecated
    public RequestOptions setHeader(final String str, final String str2) {
        this.requestCallback = this.requestCallback.andThen(new Consumer() { // from class: com.azure.core.http.rest.RequestOptions$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((HttpRequest) obj).getHeaders().set(str, str2);
            }
        });
        return this;
    }

    public RequestOptions setHeader(final HttpHeaderName httpHeaderName, final String str) {
        this.requestCallback = this.requestCallback.andThen(new Consumer() { // from class: com.azure.core.http.rest.RequestOptions$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((HttpRequest) obj).getHeaders().set(httpHeaderName, str);
            }
        });
        return this;
    }

    public RequestOptions addQueryParam(String str, String str2) {
        return addQueryParam(str, str2, false);
    }

    public RequestOptions addQueryParam(final String str, final String str2, final boolean z) {
        this.requestCallback = this.requestCallback.andThen(new Consumer() { // from class: com.azure.core.http.rest.RequestOptions$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                RequestOptions.lambda$addQueryParam$5(z, str, str2, (HttpRequest) obj);
            }
        });
        return this;
    }

    static /* synthetic */ void lambda$addQueryParam$5(boolean z, String str, String str2, HttpRequest httpRequest) {
        String string = httpRequest.getUrl().toString();
        if (!z) {
            str = UrlEscapers.QUERY_ESCAPER.escape(str);
        }
        if (!z) {
            str2 = UrlEscapers.QUERY_ESCAPER.escape(str2);
        }
        httpRequest.setUrl(string + (string.contains("?") ? "&" : "?") + str + "=" + str2);
    }

    public RequestOptions addRequestCallback(Consumer<HttpRequest> consumer) {
        Objects.requireNonNull(consumer, "'requestCallback' cannot be null.");
        this.requestCallback = this.requestCallback.andThen(consumer);
        return this;
    }

    public RequestOptions setBody(final BinaryData binaryData) {
        Objects.requireNonNull(binaryData, "'requestBody' cannot be null.");
        this.requestCallback = this.requestCallback.andThen(new Consumer() { // from class: com.azure.core.http.rest.RequestOptions$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((HttpRequest) obj).setBody(binaryData);
            }
        });
        return this;
    }

    RequestOptions setErrorOptions(EnumSet<ErrorOptions> enumSet) {
        Objects.requireNonNull(enumSet, "'errorOptions' cannot be null.");
        if (enumSet.contains(ErrorOptions.THROW) && enumSet.contains(ErrorOptions.NO_THROW)) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'errorOptions' cannot contain both 'ErrorOptions.THROW' and 'ErrorOptions.NO_THROW'."));
        }
        this.errorOptions = enumSet;
        return this;
    }

    public RequestOptions setContext(Context context) {
        this.context = context;
        return this;
    }
}
