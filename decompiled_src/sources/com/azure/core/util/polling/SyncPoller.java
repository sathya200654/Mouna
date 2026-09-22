package com.azure.core.util.polling;

import com.azure.core.http.rest.Response;
import com.azure.core.util.serializer.TypeReference;
import java.time.Duration;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface SyncPoller<T, U> {
    void cancelOperation();

    U getFinalResult();

    PollResponse<T> poll();

    default SyncPoller<T, U> setPollInterval(Duration duration) {
        return this;
    }

    PollResponse<T> waitForCompletion();

    PollResponse<T> waitForCompletion(Duration duration);

    PollResponse<T> waitUntil(LongRunningOperationStatus longRunningOperationStatus);

    PollResponse<T> waitUntil(Duration duration, LongRunningOperationStatus longRunningOperationStatus);

    default U getFinalResult(Duration duration) {
        return getFinalResult();
    }

    static <T, U> SyncPoller<T, U> createPoller(Duration duration, Function<PollingContext<T>, PollResponse<T>> function, Function<PollingContext<T>, PollResponse<T>> function2, BiFunction<PollingContext<T>, PollResponse<T>, T> biFunction, Function<PollingContext<T>, U> function3) {
        return new SimpleSyncPoller(duration, function, function2, biFunction, function3);
    }

    static <T, U> SyncPoller<T, U> createPoller(Duration duration, final Supplier<Response<?>> supplier, final SyncPollingStrategy<T, U> syncPollingStrategy, final TypeReference<T> typeReference, final TypeReference<U> typeReference2) {
        Function function = new Function() { // from class: com.azure.core.util.polling.SyncPoller$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SyncPoller.lambda$createPoller$0(supplier, syncPollingStrategy, typeReference, (PollingContext) obj);
            }
        };
        Function function2 = new Function() { // from class: com.azure.core.util.polling.SyncPoller$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return syncPollingStrategy.poll((PollingContext) obj, typeReference);
            }
        };
        Objects.requireNonNull(syncPollingStrategy);
        return createPoller(duration, function, function2, new BiFunction() { // from class: com.azure.core.util.polling.SyncPoller$$ExternalSyntheticLambda2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return syncPollingStrategy.cancel((PollingContext) obj, (PollResponse) obj2);
            }
        }, new Function() { // from class: com.azure.core.util.polling.SyncPoller$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return syncPollingStrategy.getResult((PollingContext) obj, typeReference2);
            }
        });
    }

    static /* synthetic */ PollResponse lambda$createPoller$0(Supplier supplier, SyncPollingStrategy syncPollingStrategy, TypeReference typeReference, PollingContext pollingContext) {
        Response<?> response = (Response) supplier.get();
        if (!syncPollingStrategy.canPoll(response)) {
            throw new IllegalStateException("Cannot poll with strategy " + syncPollingStrategy.getClass().getSimpleName());
        }
        return syncPollingStrategy.onInitialResponse(response, pollingContext, typeReference);
    }
}
