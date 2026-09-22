package com.azure.core.util.metrics;

import com.azure.core.util.LibraryTelemetryOptions;
import com.azure.core.util.MetricsOptions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface MeterProvider {
    Meter createMeter(String str, String str2, MetricsOptions metricsOptions);

    default Meter createMeter(LibraryTelemetryOptions libraryTelemetryOptions, MetricsOptions metricsOptions) {
        return createMeter(libraryTelemetryOptions.getLibraryName(), libraryTelemetryOptions.getLibraryVersion(), metricsOptions);
    }

    static MeterProvider getDefaultProvider() {
        return DefaultMeterProvider.getInstance();
    }
}
