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
import com.azure.core.util.FluxUtil;
import com.azure.core.util.UrlBuilder;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.implementation.PollResult;
import com.azure.core.util.polling.implementation.PollingConstants;
import com.azure.core.util.polling.implementation.PollingUtils;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class OperationResourcePollingStrategy<T, U> implements PollingStrategy<T, U> {
    private final Context context;
    private final String endpoint;
    private final HttpPipeline httpPipeline;
    private final HttpHeaderName operationLocationHeaderName;
    private final ObjectSerializer serializer;
    private final String serviceVersion;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) OperationResourcePollingStrategy.class);
    private static final HttpHeaderName DEFAULT_OPERATION_LOCATION_HEADER = HttpHeaderName.fromString("Operation-Location");
    private static final TypeReference<PollResult> POLL_RESULT_TYPE_REFERENCE = TypeReference.createInstance(PollResult.class);

    public OperationResourcePollingStrategy(HttpPipeline httpPipeline) {
        this(DEFAULT_OPERATION_LOCATION_HEADER, new PollingStrategyOptions(httpPipeline));
    }

    public OperationResourcePollingStrategy(HttpPipeline httpPipeline, ObjectSerializer objectSerializer, String str) {
        this(httpPipeline, objectSerializer, str, Context.NONE);
    }

    public OperationResourcePollingStrategy(HttpPipeline httpPipeline, ObjectSerializer objectSerializer, String str, Context context) {
        this(httpPipeline, null, objectSerializer, str, context);
    }

    public OperationResourcePollingStrategy(HttpPipeline httpPipeline, String str, ObjectSerializer objectSerializer, String str2, Context context) {
        this(str2 == null ? null : HttpHeaderName.fromString(str2), new PollingStrategyOptions(httpPipeline).setEndpoint(str).setSerializer(objectSerializer).setContext(context));
    }

    public OperationResourcePollingStrategy(HttpHeaderName httpHeaderName, PollingStrategyOptions pollingStrategyOptions) {
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

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<Boolean> canPoll(final Response<?> response) {
        return Mono.fromSupplier(new Supplier() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1265x851d4378(response);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$canPoll$0$com-azure-core-util-polling-OperationResourcePollingStrategy, reason: not valid java name */
    /* synthetic */ Boolean m1265x851d4378(Response response) {
        return Boolean.valueOf(PollingUtil.operationResourceCanPoll(response, this.operationLocationHeaderName, this.endpoint, LOGGER));
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<PollResponse<T>> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference) {
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
            final Duration retryAfterFromHeaders = ImplUtils.getRetryAfterFromHeaders(response.getHeaders(), new OperationResourcePollingStrategy$$ExternalSyntheticLambda6());
            return PollingUtils.convertResponse(response.getValue(), this.serializer, typeReference).map(new Function() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return OperationResourcePollingStrategy.lambda$onInitialResponse$1(retryAfterFromHeaders, obj);
                }
            }).switchIfEmpty(Mono.fromSupplier(new Supplier() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda11
                @Override // java.util.function.Supplier
                public final Object get() {
                    return OperationResourcePollingStrategy.lambda$onInitialResponse$2(retryAfterFromHeaders);
                }
            }));
        }
        return Mono.error(new AzureException(String.format("Operation failed or cancelled with status code %d,, '%s' header: %s, and response body: %s", Integer.valueOf(response.getStatusCode()), this.operationLocationHeaderName, httpHeader, PollingUtils.serializeResponse(response.getValue(), this.serializer))));
    }

    static /* synthetic */ PollResponse lambda$onInitialResponse$1(Duration duration, Object obj) {
        return new PollResponse(LongRunningOperationStatus.IN_PROGRESS, obj, duration);
    }

    static /* synthetic */ PollResponse lambda$onInitialResponse$2(Duration duration) {
        return new PollResponse(LongRunningOperationStatus.IN_PROGRESS, null, duration);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<PollResponse<T>> poll(final PollingContext<T> pollingContext, final TypeReference<T> typeReference) {
        final HttpRequest httpRequest = new HttpRequest(HttpMethod.GET, setServiceVersionQueryParam(pollingContext.getData(this.operationLocationHeaderName.getCaseSensitiveName())));
        return FluxUtil.withContext(new Function() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1268x2b6b9e6b(httpRequest, (Context) obj);
            }
        }).flatMap(new Function() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1272x10a3cc86(pollingContext, typeReference, (HttpResponse) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$poll$3$com-azure-core-util-polling-OperationResourcePollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1268x2b6b9e6b(HttpRequest httpRequest, Context context) {
        return this.httpPipeline.send(httpRequest, CoreUtils.mergeContexts(context, this.context));
    }

    /* JADX INFO: renamed from: lambda$poll$8$com-azure-core-util-polling-OperationResourcePollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1272x10a3cc86(final PollingContext pollingContext, final TypeReference typeReference, final HttpResponse httpResponse) {
        return httpResponse.getBodyAsByteArray().map(new LocationPollingStrategy$$ExternalSyntheticLambda0()).flatMap(new Function() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1271x7c655ce7(pollingContext, httpResponse, typeReference, (BinaryData) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$poll$7$com-azure-core-util-polling-OperationResourcePollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1271x7c655ce7(final PollingContext pollingContext, final HttpResponse httpResponse, final TypeReference typeReference, final BinaryData binaryData) {
        return PollingUtils.deserializeResponse(binaryData, this.serializer, POLL_RESULT_TYPE_REFERENCE).map(new Function() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1269xbfaa0e0a(pollingContext, binaryData, (PollResult) obj);
            }
        }).flatMap(new Function() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1270xe826ed48(httpResponse, binaryData, typeReference, (LongRunningOperationStatus) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$poll$4$com-azure-core-util-polling-OperationResourcePollingStrategy, reason: not valid java name */
    /* synthetic */ LongRunningOperationStatus m1269xbfaa0e0a(PollingContext pollingContext, BinaryData binaryData, PollResult pollResult) {
        String resourceLocation = pollResult.getResourceLocation();
        if (resourceLocation != null) {
            pollingContext.setData(PollingConstants.RESOURCE_LOCATION, PollingUtils.getAbsolutePath(resourceLocation, this.endpoint, LOGGER));
        }
        pollingContext.setData(PollingConstants.POLL_RESPONSE_BODY, binaryData.toString());
        return pollResult.getStatus();
    }

    /* JADX INFO: renamed from: lambda$poll$6$com-azure-core-util-polling-OperationResourcePollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1270xe826ed48(HttpResponse httpResponse, BinaryData binaryData, TypeReference typeReference, final LongRunningOperationStatus longRunningOperationStatus) {
        final Duration retryAfterFromHeaders = ImplUtils.getRetryAfterFromHeaders(httpResponse.getHeaders(), new OperationResourcePollingStrategy$$ExternalSyntheticLambda6());
        return PollingUtils.deserializeResponse(binaryData, this.serializer, typeReference).map(new Function() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return OperationResourcePollingStrategy.lambda$poll$5(longRunningOperationStatus, retryAfterFromHeaders, obj);
            }
        });
    }

    static /* synthetic */ PollResponse lambda$poll$5(LongRunningOperationStatus longRunningOperationStatus, Duration duration, Object obj) {
        return new PollResponse(longRunningOperationStatus, obj, duration);
    }

    private String setServiceVersionQueryParam(String str) {
        if (CoreUtils.isNullOrEmpty(this.serviceVersion)) {
            return str;
        }
        UrlBuilder urlBuilder = UrlBuilder.parse(str);
        urlBuilder.setQueryParameter("api-version", this.serviceVersion);
        return urlBuilder.toString();
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<U> getResult(PollingContext<T> pollingContext, final TypeReference<U> typeReference) {
        if (pollingContext.getLatestResponse().getStatus() == LongRunningOperationStatus.FAILED) {
            return Mono.error(new AzureException("Long running operation failed."));
        }
        if (pollingContext.getLatestResponse().getStatus() == LongRunningOperationStatus.USER_CANCELLED) {
            return Mono.error(new AzureException("Long running operation cancelled."));
        }
        String data = pollingContext.getData(PollingConstants.RESOURCE_LOCATION);
        if (data == null) {
            String data2 = pollingContext.getData(PollingConstants.HTTP_METHOD);
            if (HttpMethod.PUT.name().equalsIgnoreCase(data2) || HttpMethod.PATCH.name().equalsIgnoreCase(data2)) {
                data = pollingContext.getData(PollingConstants.REQUEST_URL);
            } else if (HttpMethod.POST.name().equalsIgnoreCase(data2)) {
                data = pollingContext.getData("Location");
            } else {
                return Mono.error(new AzureException("Cannot get final result"));
            }
        }
        if (data == null) {
            return PollingUtils.deserializeResponse(BinaryData.fromString(pollingContext.getData(PollingConstants.POLL_RESPONSE_BODY)), this.serializer, typeReference);
        }
        final HttpRequest httpRequest = new HttpRequest(HttpMethod.GET, setServiceVersionQueryParam(data));
        return FluxUtil.withContext(new Function() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1267x291d20eb(httpRequest, (Context) obj);
            }
        }).flatMap(new LocationPollingStrategy$$ExternalSyntheticLambda10()).map(new LocationPollingStrategy$$ExternalSyntheticLambda0()).flatMap(new Function() { // from class: com.azure.core.util.polling.OperationResourcePollingStrategy$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1266x9c68f2a9(typeReference, (BinaryData) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getResult$9$com-azure-core-util-polling-OperationResourcePollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1267x291d20eb(HttpRequest httpRequest, Context context) {
        return this.httpPipeline.send(httpRequest, CoreUtils.mergeContexts(context, this.context));
    }

    /* JADX INFO: renamed from: lambda$getResult$10$com-azure-core-util-polling-OperationResourcePollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1266x9c68f2a9(TypeReference typeReference, BinaryData binaryData) {
        return PollingUtils.deserializeResponse(binaryData, this.serializer, typeReference);
    }
}
