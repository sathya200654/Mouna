package com.azure.core.util.tracing;

import com.azure.core.implementation.util.Providers;
import com.azure.core.util.LibraryTelemetryOptions;
import com.azure.core.util.TracingOptions;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import java.util.Iterator;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class DefaultTracerProvider implements TracerProvider {
    private static final TracerProvider INSTANCE = new DefaultTracerProvider();
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) DefaultTracerProvider.class);
    private static final TracingOptions DEFAULT_OPTIONS = new TracingOptions();
    private static final String NO_DEFAULT_PROVIDER = "A request was made to load the default TracerProvider provider but one could not be found on the classpath. If you are using a dependency manager, consider including a dependency on azure-core-tracing-opentelemetry or enabling instrumentation java agent.";
    private static final Providers<TracerProvider, Tracer> TRACER_PROVIDERS = new Providers<>(TracerProvider.class, null, NO_DEFAULT_PROVIDER);
    private static final Tracer FALLBACK_TRACER = createFallbackTracer();

    private DefaultTracerProvider() {
    }

    private static Tracer createFallbackTracer() {
        Iterator it = ServiceLoader.load(Tracer.class, Tracer.class.getClassLoader()).iterator();
        if (it.hasNext()) {
            final Tracer tracer = (Tracer) it.next();
            LOGGER.log(LogLevel.INFORMATIONAL, new Supplier() { // from class: com.azure.core.util.tracing.DefaultTracerProvider$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return DefaultTracerProvider.lambda$createFallbackTracer$0(tracer);
                }
            });
            return tracer;
        }
        return NoopTracer.INSTANCE;
    }

    static /* synthetic */ String lambda$createFallbackTracer$0(Tracer tracer) {
        return "Found Tracer implementation on the classpath: " + tracer.getClass().getName();
    }

    static TracerProvider getInstance() {
        return INSTANCE;
    }

    @Override // com.azure.core.util.tracing.TracerProvider
    public Tracer createTracer(String str, String str2, String str3, TracingOptions tracingOptions) {
        Objects.requireNonNull(str, "'libraryName' cannot be null.");
        return createTracer(new LibraryTelemetryOptions(str).setLibraryVersion(str2).setResourceProviderNamespace(str3), tracingOptions);
    }

    @Override // com.azure.core.util.tracing.TracerProvider
    public Tracer createTracer(final LibraryTelemetryOptions libraryTelemetryOptions, final TracingOptions tracingOptions) {
        Objects.requireNonNull(libraryTelemetryOptions, "'libraryOptions' cannot be null.");
        if (tracingOptions == null) {
            tracingOptions = DEFAULT_OPTIONS;
        }
        if (tracingOptions.isEnabled()) {
            return TRACER_PROVIDERS.create(new Function() { // from class: com.azure.core.util.tracing.DefaultTracerProvider$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((TracerProvider) obj).createTracer(libraryTelemetryOptions, tracingOptions);
                }
            }, FALLBACK_TRACER, tracingOptions.getTracerProvider());
        }
        return NoopTracer.INSTANCE;
    }
}
