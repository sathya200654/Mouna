package com.azure.core.util.metrics;

import com.azure.core.util.Context;
import com.azure.core.util.TelemetryAttributes;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface LongCounter {
    void add(long j, TelemetryAttributes telemetryAttributes, Context context);

    boolean isEnabled();
}
