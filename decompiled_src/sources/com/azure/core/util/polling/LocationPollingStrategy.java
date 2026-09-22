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
public class LocationPollingStrategy<T, U> implements PollingStrategy<T, U> {
    private static final ObjectSerializer DEFAULT_SERIALIZER = new DefaultJsonSerializer();
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) LocationPollingStrategy.class);
    private final Context context;
    private final String endpoint;
    private final HttpPipeline httpPipeline;
    private final ObjectSerializer serializer;
    private final String serviceVersion;

    public LocationPollingStrategy(HttpPipeline httpPipeline) {
        this(httpPipeline, DEFAULT_SERIALIZER, Context.NONE);
    }

    public LocationPollingStrategy(HttpPipeline httpPipeline, ObjectSerializer objectSerializer) {
        this(httpPipeline, objectSerializer, Context.NONE);
    }

    public LocationPollingStrategy(HttpPipeline httpPipeline, ObjectSerializer objectSerializer, Context context) {
        this(httpPipeline, null, objectSerializer, context);
    }

    public LocationPollingStrategy(HttpPipeline httpPipeline, String str, ObjectSerializer objectSerializer, Context context) {
        this(new PollingStrategyOptions(httpPipeline).setEndpoint(str).setSerializer(objectSerializer).setContext(context));
    }

    public LocationPollingStrategy(PollingStrategyOptions pollingStrategyOptions) {
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

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<Boolean> canPoll(final Response<?> response) {
        return Mono.fromSupplier(new Supplier() { // from class: com.azure.core.util.polling.LocationPollingStrategy$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1259x7a74e78a(response);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$canPoll$0$com-azure-core-util-polling-LocationPollingStrategy, reason: not valid java name */
    /* synthetic */ Boolean m1259x7a74e78a(Response response) {
        return Boolean.valueOf(PollingUtil.locationCanPoll(response, this.endpoint, LOGGER));
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<PollResponse<T>> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        HttpHeader httpHeader = response.getHeaders().get(HttpHeaderName.LOCATION);
        if (httpHeader != null) {
            pollingContext.setData("Location", PollingUtils.getAbsolutePath(httpHeader.getValue(), this.endpoint, LOGGER));
        }
        pollingContext.setData(PollingConstants.HTTP_METHOD, response.getRequest().getHttpMethod().name());
        pollingContext.setData(PollingConstants.REQUEST_URL, response.getRequest().getUrl().toString());
        if (response.getStatusCode() == 200 || response.getStatusCode() == 201 || response.getStatusCode() == 202 || response.getStatusCode() == 204) {
            final Duration retryAfterFromHeaders = ImplUtils.getRetryAfterFromHeaders(response.getHeaders(), new LocationPollingStrategy$$ExternalSyntheticLambda4());
            return PollingUtils.convertResponse(response.getValue(), this.serializer, typeReference).map(new Function() { // from class: com.azure.core.util.polling.LocationPollingStrategy$$ExternalSyntheticLambda5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return LocationPollingStrategy.lambda$onInitialResponse$1(retryAfterFromHeaders, obj);
                }
            }).switchIfEmpty(Mono.fromSupplier(new Supplier() { // from class: com.azure.core.util.polling.LocationPollingStrategy$$ExternalSyntheticLambda6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return LocationPollingStrategy.lambda$onInitialResponse$2(retryAfterFromHeaders);
                }
            }));
        }
        return Mono.error(new AzureException(String.format("Operation failed or cancelled with status code %d,, 'Location' header: %s, and response body: %s", Integer.valueOf(response.getStatusCode()), httpHeader, PollingUtils.serializeResponse(response.getValue(), this.serializer))));
    }

    static /* synthetic */ PollResponse lambda$onInitialResponse$1(Duration duration, Object obj) {
        return new PollResponse(LongRunningOperationStatus.IN_PROGRESS, obj, duration);
    }

    static /* synthetic */ PollResponse lambda$onInitialResponse$2(Duration duration) {
        return new PollResponse(LongRunningOperationStatus.IN_PROGRESS, null, duration);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<PollResponse<T>> poll(final PollingContext<T> pollingContext, final TypeReference<T> typeReference) {
        final HttpRequest httpRequest = new HttpRequest(HttpMethod.GET, setServiceVersionQueryParam(pollingContext.getData("Location")));
        return FluxUtil.withContext(new Function() { // from class: com.azure.core.util.polling.LocationPollingStrategy$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1262xceddf37(httpRequest, (Context) obj);
            }
        }).flatMap(new Function() { // from class: com.azure.core.util.polling.LocationPollingStrategy$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1264xb49df3ba(pollingContext, typeReference, (HttpResponse) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$poll$3$com-azure-core-util-polling-LocationPollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1262xceddf37(HttpRequest httpRequest, Context context) {
        return this.httpPipeline.send(httpRequest, CoreUtils.mergeContexts(context, this.context));
    }

    /* JADX INFO: renamed from: lambda$poll$6$com-azure-core-util-polling-LocationPollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1264xb49df3ba(final PollingContext pollingContext, final TypeReference typeReference, final HttpResponse httpResponse) {
        LongRunningOperationStatus longRunningOperationStatus;
        HttpHeader httpHeader = httpResponse.getHeaders().get(HttpHeaderName.LOCATION);
        if (httpHeader != null) {
            pollingContext.setData("Location", httpHeader.getValue());
        }
        if (httpResponse.getStatusCode() == 202) {
            longRunningOperationStatus = LongRunningOperationStatus.IN_PROGRESS;
        } else if (httpResponse.getStatusCode() >= 200 && httpResponse.getStatusCode() <= 204) {
            longRunningOperationStatus = LongRunningOperationStatus.SUCCESSFULLY_COMPLETED;
        } else {
            longRunningOperationStatus = LongRunningOperationStatus.FAILED;
        }
        final LongRunningOperationStatus longRunningOperationStatus2 = longRunningOperationStatus;
        return httpResponse.getBodyAsByteArray().map(new LocationPollingStrategy$$ExternalSyntheticLambda0()).flatMap(new Function() { // from class: com.azure.core.util.polling.LocationPollingStrategy$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1263x27634239(pollingContext, httpResponse, typeReference, longRunningOperationStatus2, (BinaryData) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$poll$5$com-azure-core-util-polling-LocationPollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1263x27634239(PollingContext pollingContext, HttpResponse httpResponse, TypeReference typeReference, final LongRunningOperationStatus longRunningOperationStatus, BinaryData binaryData) {
        pollingContext.setData(PollingConstants.POLL_RESPONSE_BODY, binaryData.toString());
        final Duration retryAfterFromHeaders = ImplUtils.getRetryAfterFromHeaders(httpResponse.getHeaders(), new LocationPollingStrategy$$ExternalSyntheticLambda4());
        return PollingUtils.deserializeResponse(binaryData, this.serializer, typeReference).map(new Function() { // from class: com.azure.core.util.polling.LocationPollingStrategy$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return LocationPollingStrategy.lambda$poll$4(longRunningOperationStatus, retryAfterFromHeaders, obj);
            }
        });
    }

    static /* synthetic */ PollResponse lambda$poll$4(LongRunningOperationStatus longRunningOperationStatus, Duration duration, Object obj) {
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
        String data;
        if (pollingContext.getLatestResponse().getStatus() == LongRunningOperationStatus.FAILED) {
            return Mono.error(new AzureException("Long running operation failed."));
        }
        if (pollingContext.getLatestResponse().getStatus() == LongRunningOperationStatus.USER_CANCELLED) {
            return Mono.error(new AzureException("Long running operation cancelled."));
        }
        String data2 = pollingContext.getData(PollingConstants.HTTP_METHOD);
        if (HttpMethod.PUT.name().equalsIgnoreCase(data2) || HttpMethod.PATCH.name().equalsIgnoreCase(data2)) {
            data = pollingContext.getData(PollingConstants.REQUEST_URL);
        } else if (HttpMethod.POST.name().equalsIgnoreCase(data2)) {
            data = pollingContext.getData("Location");
        } else {
            return Mono.error(new AzureException("Cannot get final result"));
        }
        if (data == null) {
            return PollingUtils.deserializeResponse(BinaryData.fromString(pollingContext.getData(PollingConstants.POLL_RESPONSE_BODY)), this.serializer, typeReference);
        }
        final HttpRequest httpRequest = new HttpRequest(HttpMethod.GET, setServiceVersionQueryParam(data));
        return FluxUtil.withContext(new Function() { // from class: com.azure.core.util.polling.LocationPollingStrategy$$ExternalSyntheticLambda9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1260xd71229b5(httpRequest, (Context) obj);
            }
        }).flatMap(new LocationPollingStrategy$$ExternalSyntheticLambda10()).map(new LocationPollingStrategy$$ExternalSyntheticLambda0()).flatMap(new Function() { // from class: com.azure.core.util.polling.LocationPollingStrategy$$ExternalSyntheticLambda11
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1261x644cdb36(typeReference, (BinaryData) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getResult$7$com-azure-core-util-polling-LocationPollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1260xd71229b5(HttpRequest httpRequest, Context context) {
        return this.httpPipeline.send(httpRequest, CoreUtils.mergeContexts(context, this.context));
    }

    /* JADX INFO: renamed from: lambda$getResult$8$com-azure-core-util-polling-LocationPollingStrategy, reason: not valid java name */
    /* synthetic */ Mono m1261x644cdb36(TypeReference typeReference, BinaryData binaryData) {
        return PollingUtils.deserializeResponse(binaryData, this.serializer, typeReference);
    }
}
