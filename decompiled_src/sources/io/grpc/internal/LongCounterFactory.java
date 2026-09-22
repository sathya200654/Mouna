package io.grpc.internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class LongCounterFactory {
    LongCounterFactory() {
    }

    public static LongCounter create() {
        if (ReflectionLongAdderCounter.isAvailable()) {
            return new ReflectionLongAdderCounter();
        }
        return new AtomicLongCounter();
    }
}
