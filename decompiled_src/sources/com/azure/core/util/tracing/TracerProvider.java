package com.azure.core.util.tracing;

import com.azure.core.util.LibraryTelemetryOptions;
import com.azure.core.util.TracingOptions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface TracerProvider {
    Tracer createTracer(String str, String str2, String str3, TracingOptions tracingOptions);

    default Tracer createTracer(LibraryTelemetryOptions libraryTelemetryOptions, TracingOptions tracingOptions) {
        return createTracer(libraryTelemetryOptions.getLibraryName(), libraryTelemetryOptions.getLibraryVersion(), libraryTelemetryOptions.getResourceProviderNamespace(), tracingOptions);
    }

    static TracerProvider getDefaultProvider() {
        return DefaultTracerProvider.getInstance();
    }
}
