package com.azure.core.util.metrics;

import com.azure.core.util.TelemetryAttributes;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface Meter extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    TelemetryAttributes createAttributes(Map<String, Object> map);

    DoubleHistogram createDoubleHistogram(String str, String str2, String str3);

    LongCounter createLongCounter(String str, String str2, String str3);

    LongCounter createLongUpDownCounter(String str, String str2, String str3);

    boolean isEnabled();

    default LongGauge createLongGauge(String str, String str2, String str3) {
        return DefaultMeterProvider.NOOP_GAUGE;
    }
}
