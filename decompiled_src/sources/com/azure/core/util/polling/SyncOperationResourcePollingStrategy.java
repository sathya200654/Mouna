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
import com.azure.core.util.polling.implementation.PollResult;
import com.azure.core.util.polling.implementation.PollingConstants;
import com.azure.core.util.polling.implementation.PollingUtils;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class SyncOperationResourcePollingStrategy<T, U> implements SyncPollingStrategy<T, U> {
    private final Context context;
    private final String endpoint;
    private final HttpPipeline httpPipeline;
    private final HttpHeaderName operationLocationHeaderName;
    private final ObjectSerializer serializer;
    private final String serviceVersion;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) SyncOperationResourcePollingStrategy.class);
    private static final HttpHeaderName DEFAULT_OPERATION_LOCATION_HEADER = HttpHeaderName.fromString("Operation-Location");
    private static final TypeReference<PollResult> POLL_RESULT_TYPE_REFERENCE = TypeReference.createInstance(PollResult.class);

    public SyncOperationResourcePollingStrategy(HttpPipeline httpPipeline) {
        this(DEFAULT_OPERATION_LOCATION_HEADER, new PollingStrategyOptions(httpPipeline));
    }

    public SyncOperationResourcePollingStrategy(HttpPipeline httpPipeline, ObjectSerializer objectSerializer, String str) {
        this(httpPipeline, objectSerializer, str, Context.NONE);
    }

    public SyncOperationResourcePollingStrategy(HttpPipeline httpPipeline, ObjectSerializer objectSerializer, String str, Context context) {
        this(httpPipeline, null, objectSerializer, str, context);
    }

    public SyncOperationResourcePollingStrategy(HttpPipeline httpPipeline, String str, ObjectSerializer objectSerializer, String str2, Context context) {
        this(str2 == null ? null : HttpHeaderName.fromString(str2), new PollingStrategyOptions(httpPipeline).setEndpoint(str).setSerializer(objectSerializer).setContext(context));
    }

    public SyncOperationResourcePollingStrategy(HttpHeaderName httpHeaderName, PollingStrategyOptions pollingStrategyOptions) {
        ObjectSerializer defaultJsonSerializer;
        Objects.requireNonNull(pollingStrategyOptions, "'pollingStrategyOptions' cannot be null");
        this.httpPipeline = pollingStrategyOptions.getHttpPipeline();
        this.endpoint = pollingStrategyOptions.getEndpoint();
        if (pollingStrategyOptions.getSerializer() != null) {
            defaultJsonSerializer = pollingStrategyOptions.getSerializer();
        } else {
            defaultJsonSerializer = new DefaultJsonSerializer();
        }
        this.serializer = defaultJsonSerializer;
        this.operationLocationHeaderName = httpHeaderName == null ? DEFAULT_OPERATION_LOCATION_HEADER : httpHeaderName;
        this.serviceVersion = pollingStrategyOptions.getServiceVersion();
        this.context = pollingStrategyOptions.getContext() == null ? Context.NONE : pollingStrategyOptions.getContext();
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public boolean canPoll(Response<?> response) {
        return PollingUtil.operationResourceCanPoll(response, this.operationLocationHeaderName, this.endpoint, LOGGER);
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public PollResponse<T> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        HttpHeader httpHeader = response.getHeaders().get(this.operationLocationHeaderName);
        HttpHeader httpHeader2 = response.getHeaders().get(HttpHeaderName.LOCATION);
        if (httpHeader != null) {
            pollingContext.setData(this.operationLocationHeaderName.getCaseSensitiveName(), PollingUtils.getAbsolutePath(httpHeader.getValue(), this.endpoint, LOGGER));
        }
        if (httpHeader2 != null) {
            pollingContext.setData("Location", PollingUtils.getAbsolutePath(httpHeader2.getValue(), this.endpoint, LOGGER));
        }
        pollingContext.setData(PollingConstants.HTTP_METHOD, response.getRequest().getHttpMethod().name());
        pollingContext.setData(PollingConstants.REQUEST_URL, response.getRequest().getUrl().toString());
        if (response.getStatusCode() == 200 || response.getStatusCode() == 201 || response.getStatusCode() == 202 || response.getStatusCode() == 204) {
            return new PollResponse<>(LongRunningOperationStatus.IN_PROGRESS, PollingUtils.convertResponseSync(response.getValue(), this.serializer, typeReference), ImplUtils.getRetryAfterFromHeaders(response.getHeaders(), new SyncOperationResourcePollingStrategy$$ExternalSyntheticLambda0()));
        }
        throw LOGGER.logExceptionAsError(new AzureException(String.format("Operation failed or cancelled with status code %d, '%s' header: %s, and response body: %s", Integer.valueOf(response.getStatusCode()), this.operationLocationHeaderName, httpHeader, PollingUtils.serializeResponseSync(response.getValue(), this.serializer))));
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public PollResponse<T> poll(PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        HttpResponse httpResponseSendSync = this.httpPipeline.sendSync(new HttpRequest(HttpMethod.GET, setServiceVersionQueryParam(pollingContext.getData(this.operationLocationHeaderName.getCaseSensitiveName()))), this.context);
        try {
            BinaryData bodyAsBinaryData = httpResponseSendSync.getBodyAsBinaryData();
            PollResult pollResult = (PollResult) PollingUtils.deserializeResponseSync(bodyAsBinaryData, this.serializer, POLL_RESULT_TYPE_REFERENCE);
            String resourceLocation = pollResult.getResourceLocation();
            if (resourceLocation != null) {
                pollingContext.setData(PollingConstants.RESOURCE_LOCATION, PollingUtils.getAbsolutePath(resourceLocation, this.endpoint, LOGGER));
            }
            pollingContext.setData(PollingConstants.POLL_RESPONSE_BODY, bodyAsBinaryData.toString());
            PollResponse<T> pollResponse = new PollResponse<>(pollResult.getStatus(), PollingUtils.deserializeResponseSync(bodyAsBinaryData, this.serializer, typeReference), ImplUtils.getRetryAfterFromHeaders(httpResponseSendSync.getHeaders(), new SyncOperationResourcePollingStrategy$$ExternalSyntheticLambda0()));
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
        if (pollingContext.getLatestResponse().getStatus() == LongRunningOperationStatus.FAILED) {
            throw LOGGER.logExceptionAsError(new AzureException("Long running operation failed."));
        }
        if (pollingContext.getLatestResponse().getStatus() == LongRunningOperationStatus.USER_CANCELLED) {
            throw LOGGER.logExceptionAsError(new AzureException("Long running operation cancelled."));
        }
        String data = pollingContext.getData(PollingConstants.RESOURCE_LOCATION);
        if (data == null) {
            String data2 = pollingContext.getData(PollingConstants.HTTP_METHOD);
            if (HttpMethod.PUT.name().equalsIgnoreCase(data2) || HttpMethod.PATCH.name().equalsIgnoreCase(data2)) {
                data = pollingContext.getData(PollingConstants.REQUEST_URL);
            } else if (HttpMethod.POST.name().equalsIgnoreCase(data2)) {
                data = pollingContext.getData("Location");
            } else {
                throw LOGGER.logExceptionAsError(new AzureException("Cannot get final result"));
            }
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
