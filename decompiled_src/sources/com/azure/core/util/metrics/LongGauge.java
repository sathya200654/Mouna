package com.azure.core.util.metrics;

import com.azure.core.util.TelemetryAttributes;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface LongGauge {
    boolean isEnabled();

    AutoCloseable registerCallback(Supplier<Long> supplier, TelemetryAttributes telemetryAttributes);
}
