package com.azure.core.util.metrics;

import com.azure.core.util.Context;
import com.azure.core.util.TelemetryAttributes;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class NoopMeter implements Meter {
    public static final Meter INSTANCE = new NoopMeter();
    private static final DoubleHistogram NOOP_LONG_HISTOGRAM = new DoubleHistogram() { // from class: com.azure.core.util.metrics.NoopMeter.1
        @Override // com.azure.core.util.metrics.DoubleHistogram
        public boolean isEnabled() {
            return false;
        }

        @Override // com.azure.core.util.metrics.DoubleHistogram
        public void record(double d, TelemetryAttributes telemetryAttributes, Context context) {
        }
    };
    private static final LongCounter NOOP_LONG_COUNTER = new LongCounter() { // from class: com.azure.core.util.metrics.NoopMeter.2
        @Override // com.azure.core.util.metrics.LongCounter
        public void add(long j, TelemetryAttributes telemetryAttributes, Context context) {
        }

        @Override // com.azure.core.util.metrics.LongCounter
        public boolean isEnabled() {
            return false;
        }
    };
    private static final TelemetryAttributes NOOP_ATTRIBUTES = new TelemetryAttributes() { // from class: com.azure.core.util.metrics.NoopMeter.3
    };

    @Override // com.azure.core.util.metrics.Meter, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.azure.core.util.metrics.Meter
    public boolean isEnabled() {
        return false;
    }

    private NoopMeter() {
    }

    @Override // com.azure.core.util.metrics.Meter
    public DoubleHistogram createDoubleHistogram(String str, String str2, String str3) {
        Objects.requireNonNull(str, "'name' cannot be null.");
        Objects.requireNonNull(str2, "'description' cannot be null.");
        return NOOP_LONG_HISTOGRAM;
    }

    @Override // com.azure.core.util.metrics.Meter
    public LongCounter createLongCounter(String str, String str2, String str3) {
        Objects.requireNonNull(str, "'name' cannot be null.");
        Objects.requireNonNull(str2, "'description' cannot be null.");
        return NOOP_LONG_COUNTER;
    }

    @Override // com.azure.core.util.metrics.Meter
    public LongCounter createLongUpDownCounter(String str, String str2, String str3) {
        Objects.requireNonNull(str, "'name' cannot be null.");
        Objects.requireNonNull(str2, "'description' cannot be null.");
        return NOOP_LONG_COUNTER;
    }

    @Override // com.azure.core.util.metrics.Meter
    public TelemetryAttributes createAttributes(Map<String, Object> map) {
        Objects.requireNonNull(map, "'attributeMap' cannot be null.");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Objects.requireNonNull(entry.getKey(), "'key' cannot be null.");
            Objects.requireNonNull(entry.getValue(), "'value' cannot be null.");
        }
        return NOOP_ATTRIBUTES;
    }
}
