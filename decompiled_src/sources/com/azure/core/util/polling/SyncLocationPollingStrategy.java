package com.azure.core.util.polling;

import com.azure.core.exception.AzureException;
import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.Response;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.serializer.DefaultJsonSerializer;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.UrlBuilder;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.implementation.PollingConstants;
import com.azure.core.util.polling.implementation.PollingUtils;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class SyncLocationPollingStrategy<T, U> implements SyncPollingStrategy<T, U> {
    private static final ObjectSerializer DEFAULT_SERIALIZER = new DefaultJsonSerializer();
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) SyncLocationPollingStrategy.class);
    private final Context context;
    private final String endpoint;
    private final HttpPipeline httpPipeline;
    private final ObjectSerializer serializer;
    private final String serviceVersion;

    public SyncLocationPollingStrategy(HttpPipeline httpPipeline) {
        this(httpPipeline, DEFAULT_SERIALIZER, Context.NONE);
    }

    public SyncLocationPollingStrategy(HttpPipeline httpPipeline, ObjectSerializer objectSerializer) {
        this(httpPipeline, objectSerializer, Context.NONE);
    }

    public SyncLocationPollingStrategy(HttpPipeline httpPipeline, ObjectSerializer objectSerializer, Context context) {
        this(httpPipeline, null, objectSerializer, context);
    }

    public SyncLocationPollingStrategy(HttpPipeline httpPipeline, String str, ObjectSerializer objectSerializer, Context context) {
        this(new PollingStrategyOptions(httpPipeline).setEndpoint(str).setSerializer(objectSerializer).setContext(context));
    }

    public SyncLocationPollingStrategy(PollingStrategyOptions pollingStrategyOptions) {
        ObjectSerializer serializer;
        Objects.requireNonNull(pollingStrategyOptions, "'pollingStrategyOptions' cannot be null");
        this.httpPipeline = pollingStrategyOptions.getHttpPipeline();
        this.endpoint = pollingStrategyOptions.getEndpoint();
        if (pollingStrategyOptions.getSerializer() == null) {
            serializer = DEFAULT_SERIALIZER;
        } else {
            serializer = pollingStrategyOptions.getSerializer();
        }
        this.serializer = serializer;
        this.serviceVersion = pollingStrategyOptions.getServiceVersion();
        this.context = pollingStrategyOptions.getContext() == null ? Context.NONE : pollingStrategyOptions.getContext();
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public boolean canPoll(Response<?> response) {
        return PollingUtil.locationCanPoll(response, this.endpoint, LOGGER);
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public PollResponse<T> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        HttpHeader httpHeader = response.getHeaders().get(HttpHeaderName.LOCATION);
        if (httpHeader != null) {
            pollingContext.setData("Location", PollingUtils.getAbsolutePath(httpHeader.getValue(), this.endpoint, LOGGER));
        }
        pollingContext.setData(PollingConstants.HTTP_METHOD, response.getRequest().getHttpMethod().name());
        pollingContext.setData(PollingConstants.REQUEST_URL, response.getRequest().getUrl().toString());
        if (response.getStatusCode() == 200 || response.getStatusCode() == 201 || response.getStatusCode() == 202 || response.getStatusCode() == 204) {
            return new PollResponse<>(LongRunningOperationStatus.IN_PROGRESS, PollingUtils.convertResponseSync(response.getValue(), this.serializer, typeReference), ImplUtils.getRetryAfterFromHeaders(response.getHeaders(), new SyncLocationPollingStrategy$$ExternalSyntheticLambda0()));
        }
        throw LOGGER.logExceptionAsError(new AzureException(String.format("Operation failed or cancelled with status code %d, 'Location' header: %s, and response body: %s", Integer.valueOf(response.getStatusCode()), httpHeader, PollingUtils.serializeResponseSync(response.getValue(), this.serializer))));
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public PollResponse<T> poll(PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        LongRunningOperationStatus longRunningOperationStatus;
        HttpResponse httpResponseSendSync = this.httpPipeline.sendSync(new HttpRequest(HttpMethod.GET, setServiceVersionQueryParam(pollingContext.getData("Location"))), this.context);
        try {
            HttpHeader httpHeader = httpResponseSendSync.getHeaders().get(HttpHeaderName.LOCATION);
            if (httpHeader != null) {
                pollingContext.setData("Location", httpHeader.getValue());
            }
            if (httpResponseSendSync.getStatusCode() == 202) {
                longRunningOperationStatus = LongRunningOperationStatus.IN_PROGRESS;
            } else if (httpResponseSendSync.getStatusCode() >= 200 && httpResponseSendSync.getStatusCode() <= 204) {
                longRunningOperationStatus = LongRunningOperationStatus.SUCCESSFULLY_COMPLETED;
            } else {
                longRunningOperationStatus = LongRunningOperationStatus.FAILED;
            }
            BinaryData bodyAsBinaryData = httpResponseSendSync.getBodyAsBinaryData();
            pollingContext.setData(PollingConstants.POLL_RESPONSE_BODY, bodyAsBinaryData.toString());
            PollResponse<T> pollResponse = new PollResponse<>(longRunningOperationStatus, PollingUtils.deserializeResponseSync(bodyAsBinaryData, this.serializer, typeReference), ImplUtils.getRetryAfterFromHeaders(httpResponseSendSync.getHeaders(), new SyncLocationPollingStrategy$$ExternalSyntheticLambda0()));
            if (httpResponseSendSync != null) {
                httpResponseSendSync.close();
            }
            return pollResponse;
        } catch (Throwable th) {
            if (httpResponseSendSync != null) {
                try {
                    httpResponseSendSync.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public U getResult(PollingContext<T> pollingContext, TypeReference<U> typeReference) {
        String data;
        if (pollingContext.getLatestResponse().getStatus() == LongRunningOperationStatus.FAILED) {
            throw LOGGER.logExceptionAsError(new AzureException("Long-running operation failed."));
        }
        if (pollingContext.getLatestResponse().getStatus() == LongRunningOperationStatus.USER_CANCELLED) {
            throw LOGGER.logExceptionAsError(new AzureException("Long-running operation cancelled."));
        }
        String data2 = pollingContext.getData(PollingConstants.HTTP_METHOD);
        if (HttpMethod.PUT.name().equalsIgnoreCase(data2) || HttpMethod.PATCH.name().equalsIgnoreCase(data2)) {
            data = pollingContext.getData(PollingConstants.REQUEST_URL);
        } else if (HttpMethod.POST.name().equalsIgnoreCase(data2)) {
            data = pollingContext.getData("Location");
        } else {
            throw LOGGER.logExceptionAsError(new AzureException("Cannot get final result"));
        }
        if (data == null) {
            return (U) PollingUtils.deserializeResponseSync(BinaryData.fromString(pollingContext.getData(PollingConstants.POLL_RESPONSE_BODY)), this.serializer, typeReference);
        }
        HttpResponse httpResponseSendSync = this.httpPipeline.sendSync(new HttpRequest(HttpMethod.GET, setServiceVersionQueryParam(data)), this.context);
        try {
            U u = (U) PollingUtils.deserializeResponseSync(httpResponseSendSync.getBodyAsBinaryData(), this.serializer, typeReference);
            if (httpResponseSendSync != null) {
                httpResponseSendSync.close();
            }
            return u;
        } catch (Throwable th) {
            if (httpResponseSendSync != null) {
                try {
                    httpResponseSendSync.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private String setServiceVersionQueryParam(String str) {
        if (CoreUtils.isNullOrEmpty(this.serviceVersion)) {
            return str;
        }
        UrlBuilder urlBuilder = UrlBuilder.parse(str);
        urlBuilder.setQueryParameter("api-version", this.serviceVersion);
        return urlBuilder.toString();
    }
}
