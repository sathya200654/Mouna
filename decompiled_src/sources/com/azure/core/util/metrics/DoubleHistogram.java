package com.azure.core.util.metrics;

import com.azure.core.util.Context;
import com.azure.core.util.TelemetryAttributes;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface DoubleHistogram {
    boolean isEnabled();

    void record(double d, TelemetryAttributes telemetryAttributes, Context context);
}
