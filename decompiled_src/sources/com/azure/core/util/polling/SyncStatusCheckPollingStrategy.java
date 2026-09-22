package com.azure.core.util.polling;

import com.azure.core.exception.AzureException;
import com.azure.core.http.rest.Response;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.serializer.DefaultJsonSerializer;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.implementation.PollingUtils;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import java.time.OffsetDateTime;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class SyncStatusCheckPollingStrategy<T, U> implements SyncPollingStrategy<T, U> {
    private final ObjectSerializer serializer;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) SyncStatusCheckPollingStrategy.class);
    private static final ObjectSerializer DEFAULT_SERIALIZER = new DefaultJsonSerializer();

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public boolean canPoll(Response<?> response) {
        return true;
    }

    public SyncStatusCheckPollingStrategy() {
        this(DEFAULT_SERIALIZER);
    }

    public SyncStatusCheckPollingStrategy(ObjectSerializer objectSerializer) {
        this.serializer = objectSerializer == null ? DEFAULT_SERIALIZER : objectSerializer;
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public PollResponse<T> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        if (response.getStatusCode() == 200 || response.getStatusCode() == 201 || response.getStatusCode() == 202 || response.getStatusCode() == 204) {
            return new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED, PollingUtils.convertResponseSync(response.getValue(), this.serializer, typeReference), ImplUtils.getRetryAfterFromHeaders(response.getHeaders(), new Supplier() { // from class: com.azure.core.util.polling.SyncStatusCheckPollingStrategy$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return OffsetDateTime.now();
                }
            }));
        }
        throw LOGGER.logExceptionAsError(new AzureException("Operation failed or cancelled: " + response.getStatusCode()));
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public PollResponse<T> poll(PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        throw LOGGER.logExceptionAsError(new IllegalStateException("StatusCheckPollingStrategy doesn't support polling"));
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public U getResult(PollingContext<T> pollingContext, TypeReference<U> typeReference) {
        return (U) PollingUtils.convertResponseSync(pollingContext.getActivationResponse().getValue(), this.serializer, typeReference);
    }
}
