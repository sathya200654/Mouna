package com.azure.core.util.tracing;

import com.azure.core.util.Context;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class NoopTracer implements Tracer {
    static final Tracer INSTANCE = new NoopTracer();

    @Override // com.azure.core.util.tracing.Tracer
    public void end(String str, Throwable th, Context context) {
    }

    @Override // com.azure.core.util.tracing.Tracer
    public boolean isEnabled() {
        return false;
    }

    NoopTracer() {
    }

    @Override // com.azure.core.util.tracing.Tracer
    public Context start(String str, Context context) {
        Objects.requireNonNull(str, "'spanName' cannot be null");
        return context;
    }

    @Override // com.azure.core.util.tracing.Tracer
    public void setAttribute(String str, String str2, Context context) {
        Objects.requireNonNull(str, "'key' cannot be null");
        Objects.requireNonNull(str2, "'value' cannot be null");
    }

    @Override // com.azure.core.util.tracing.Tracer
    public AutoCloseable makeSpanCurrent(Context context) {
        return Utils.NOOP_CLOSEABLE;
    }
}
