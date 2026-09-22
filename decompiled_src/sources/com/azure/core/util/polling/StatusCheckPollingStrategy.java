package com.azure.core.util.polling;

import com.azure.core.exception.AzureException;
import com.azure.core.http.rest.Response;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.serializer.DefaultJsonSerializer;
import com.azure.core.util.polling.implementation.PollingUtils;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class StatusCheckPollingStrategy<T, U> implements PollingStrategy<T, U> {
    private static final ObjectSerializer DEFAULT_SERIALIZER = new DefaultJsonSerializer();
    private final ObjectSerializer serializer;

    public StatusCheckPollingStrategy() {
        this(DEFAULT_SERIALIZER);
    }

    public StatusCheckPollingStrategy(ObjectSerializer objectSerializer) {
        this.serializer = objectSerializer == null ? DEFAULT_SERIALIZER : objectSerializer;
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<Boolean> canPoll(Response<?> response) {
        return Mono.just(true);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<PollResponse<T>> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        if (response.getStatusCode() == 200 || response.getStatusCode() == 201 || response.getStatusCode() == 202 || response.getStatusCode() == 204) {
            final Duration retryAfterFromHeaders = ImplUtils.getRetryAfterFromHeaders(response.getHeaders(), new Supplier() { // from class: com.azure.core.util.polling.StatusCheckPollingStrategy$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return OffsetDateTime.now();
                }
            });
            return PollingUtils.convertResponse(response.getValue(), this.serializer, typeReference).map(new Function() { // from class: com.azure.core.util.polling.StatusCheckPollingStrategy$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return StatusCheckPollingStrategy.lambda$onInitialResponse$0(retryAfterFromHeaders, obj);
                }
            }).switchIfEmpty(Mono.fromSupplier(new Supplier() { // from class: com.azure.core.util.polling.StatusCheckPollingStrategy$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return StatusCheckPollingStrategy.lambda$onInitialResponse$1(retryAfterFromHeaders);
                }
            }));
        }
        return Mono.error(new AzureException("Operation failed or cancelled: " + response.getStatusCode()));
    }

    static /* synthetic */ PollResponse lambda$onInitialResponse$0(Duration duration, Object obj) {
        return new PollResponse(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED, obj, duration);
    }

    static /* synthetic */ PollResponse lambda$onInitialResponse$1(Duration duration) {
        return new PollResponse(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED, null, duration);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<PollResponse<T>> poll(PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        return Mono.error(new IllegalStateException("StatusCheckPollingStrategy doesn't support polling"));
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<U> getResult(PollingContext<T> pollingContext, TypeReference<U> typeReference) {
        return PollingUtils.convertResponse(pollingContext.getActivationResponse().getValue(), this.serializer, typeReference);
    }
}
