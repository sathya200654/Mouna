package com.azure.core.util.tracing;

import com.azure.core.util.Context;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Deprecated
public final class TracerProxy {
    private static Tracer tracer = TracerProvider.getDefaultProvider().createTracer("azure-core", null, null, null);

    private TracerProxy() {
    }

    public static Context start(String str, Context context) {
        Tracer tracer2 = tracer;
        return tracer2 == null ? context : tracer2.start(str, context);
    }

    public static Context start(String str, StartSpanOptions startSpanOptions, Context context) {
        return tracer.start(str, startSpanOptions, context);
    }

    public static void setAttribute(String str, String str2, Context context) {
        tracer.setAttribute(str, str2, context);
    }

    public static void end(int i, Throwable th, Context context) {
        tracer.end(i, th, context);
    }

    public static Context setSpanName(String str, Context context) {
        return tracer.setSpanName(str, context);
    }

    public static boolean isTracingEnabled() {
        return tracer.isEnabled();
    }
}
