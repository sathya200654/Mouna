package com.azure.core.util.metrics;

import com.azure.core.implementation.util.Providers;
import com.azure.core.util.LibraryTelemetryOptions;
import com.azure.core.util.MetricsOptions;
import com.azure.core.util.TelemetryAttributes;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class DefaultMeterProvider implements MeterProvider {
    private static final MeterProvider INSTANCE = new DefaultMeterProvider();
    private static final MetricsOptions DEFAULT_OPTIONS = new MetricsOptions();
    private static final AutoCloseable NOOP_CLOSEABLE = new AutoCloseable() { // from class: com.azure.core.util.metrics.DefaultMeterProvider$$ExternalSyntheticLambda1
        @Override // java.lang.AutoCloseable
        public final void close() throws Exception {
            DefaultMeterProvider.lambda$static$0();
        }
    };
    private static final String NO_DEFAULT_PROVIDER = "A request was made to load the default MeterProvider provider but one could not be found on the classpath. If you are using a dependency manager, consider including a dependency on azure-core-metrics-opentelemetry or enabling instrumentation package.";
    private static final Providers<MeterProvider, Meter> METER_PROVIDER = new Providers<>(MeterProvider.class, null, NO_DEFAULT_PROVIDER);
    static final LongGauge NOOP_GAUGE = new LongGauge() { // from class: com.azure.core.util.metrics.DefaultMeterProvider.1
        @Override // com.azure.core.util.metrics.LongGauge
        public boolean isEnabled() {
            return false;
        }

        @Override // com.azure.core.util.metrics.LongGauge
        public AutoCloseable registerCallback(Supplier<Long> supplier, TelemetryAttributes telemetryAttributes) {
            return DefaultMeterProvider.NOOP_CLOSEABLE;
        }
    };

    static /* synthetic */ void lambda$static$0() throws Exception {
    }

    private DefaultMeterProvider() {
    }

    static MeterProvider getInstance() {
        return INSTANCE;
    }

    @Override // com.azure.core.util.metrics.MeterProvider
    public Meter createMeter(String str, String str2, MetricsOptions metricsOptions) {
        Objects.requireNonNull(str, "'libraryName' cannot be null.");
        return createMeter(new LibraryTelemetryOptions(str).setLibraryVersion(str2), metricsOptions);
    }

    @Override // com.azure.core.util.metrics.MeterProvider
    public Meter createMeter(final LibraryTelemetryOptions libraryTelemetryOptions, final MetricsOptions metricsOptions) {
        Objects.requireNonNull(libraryTelemetryOptions, "'libraryOptions' cannot be null.");
        if (metricsOptions == null) {
            metricsOptions = DEFAULT_OPTIONS;
        }
        return METER_PROVIDER.create(new Function() { // from class: com.azure.core.util.metrics.DefaultMeterProvider$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((MeterProvider) obj).createMeter(libraryTelemetryOptions, metricsOptions);
            }
        }, NoopMeter.INSTANCE, metricsOptions.getMeterProvider());
    }
}
