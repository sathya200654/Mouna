package com.azure.core.util.tracing;

import com.azure.core.util.Context;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface Tracer {

    @Deprecated
    public static final String AZ_TRACING_NAMESPACE_KEY = "az.namespace";

    @Deprecated
    public static final String DIAGNOSTIC_ID_KEY = "Diagnostic-Id";
    public static final String DISABLE_TRACING_KEY = "disable-tracing";
    public static final String ENTITY_PATH_KEY = "entity-path";
    public static final String HOST_NAME_KEY = "hostname";

    @Deprecated
    public static final String MESSAGE_ENQUEUED_TIME = "x-opt-enqueued-time";

    @Deprecated
    public static final String PARENT_SPAN_KEY = "parent-span";
    public static final String PARENT_TRACE_CONTEXT_KEY = "trace-context";

    @Deprecated
    public static final String SCOPE_KEY = "scope";

    @Deprecated
    public static final String SPAN_BUILDER_KEY = "builder";
    public static final String SPAN_CONTEXT_KEY = "span-context";

    @Deprecated
    public static final String USER_SPAN_NAME_KEY = "user-span-name";

    default void addEvent(String str, Map<String, Object> map, OffsetDateTime offsetDateTime, Context context) {
    }

    void end(String str, Throwable th, Context context);

    default void injectContext(BiConsumer<String, String> biConsumer, Context context) {
    }

    default boolean isEnabled() {
        return true;
    }

    default boolean isRecording(Context context) {
        return true;
    }

    void setAttribute(String str, String str2, Context context);

    @Deprecated
    default Context setSpanName(String str, Context context) {
        return context;
    }

    Context start(String str, Context context);

    default Context start(String str, StartSpanOptions startSpanOptions, Context context) {
        return start(str, context);
    }

    @Deprecated
    default Context start(String str, Context context, ProcessKind processKind) {
        Objects.requireNonNull(str, "'spanName' cannot be null.");
        Objects.requireNonNull(context, "'context' cannot be null.");
        Objects.requireNonNull(processKind, "'processKind' cannot be null.");
        if (!isEnabled()) {
            return context;
        }
        int i = AnonymousClass1.$SwitchMap$com$azure$core$util$tracing$ProcessKind[processKind.ordinal()];
        if (i == 1) {
            StartSpanOptions startSpanOptions = (StartSpanOptions) Utils.getOrNull(context, SPAN_BUILDER_KEY, StartSpanOptions.class);
            if (startSpanOptions == null) {
                Utils.LOGGER.atWarning().addKeyValue("spanName", str).addKeyValue("processKind", processKind).log("Start span is called without builder on the context, creating default builder.");
                startSpanOptions = new StartSpanOptions(SpanKind.CLIENT);
            }
            Utils.addMessagingAttributes(startSpanOptions, context);
            return start(str, startSpanOptions, context);
        }
        if (i == 2) {
            StartSpanOptions startSpanOptions2 = new StartSpanOptions(SpanKind.PRODUCER);
            Utils.addMessagingAttributes(startSpanOptions2, context);
            Context contextStart = start(str, startSpanOptions2, context);
            final AtomicReference atomicReference = new AtomicReference();
            injectContext(new BiConsumer() { // from class: com.azure.core.util.tracing.Tracer$$ExternalSyntheticLambda1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    Tracer.lambda$start$0(atomicReference, (String) obj, (String) obj2);
                }
            }, contextStart);
            return contextStart.addData(DIAGNOSTIC_ID_KEY, atomicReference);
        }
        if (i == 3) {
            StartSpanOptions remoteParent = (StartSpanOptions) Utils.getOrNull(context, SPAN_BUILDER_KEY, StartSpanOptions.class);
            if (remoteParent == null) {
                remoteParent = new StartSpanOptions(SpanKind.CONSUMER).setRemoteParent(context);
            }
            Utils.addMessagingAttributes(remoteParent, context);
            return start(str, remoteParent, context);
        }
        Utils.LOGGER.atWarning().addKeyValue("spanName", str).addKeyValue("processKind", processKind).log("Start span is called with unknown process kind, suppressing the span.");
        return context;
    }

    /* JADX INFO: renamed from: com.azure.core.util.tracing.Tracer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$azure$core$util$tracing$ProcessKind;

        static {
            int[] iArr = new int[ProcessKind.values().length];
            $SwitchMap$com$azure$core$util$tracing$ProcessKind = iArr;
            try {
                iArr[ProcessKind.SEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$azure$core$util$tracing$ProcessKind[ProcessKind.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$azure$core$util$tracing$ProcessKind[ProcessKind.PROCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static /* synthetic */ void lambda$start$0(AtomicReference atomicReference, String str, String str2) {
        if (str.equals("traceparent")) {
            atomicReference.set(str2);
        }
    }

    @Deprecated
    default void end(int i, Throwable th, Context context) {
        end((String) null, th, context);
    }

    default void setAttribute(String str, long j, Context context) {
        setAttribute(str, Long.toString(j), context);
    }

    default void setAttribute(String str, Object obj, Context context) {
        Objects.requireNonNull(obj, "'value' cannot be null.");
        setAttribute(str, obj.toString(), context);
    }

    @Deprecated
    default void addLink(Context context) {
        StartSpanOptions startSpanOptions;
        TracingLink tracingLink;
        if (isEnabled() && (startSpanOptions = (StartSpanOptions) Utils.getOrNull(context, SPAN_BUILDER_KEY, StartSpanOptions.class)) != null) {
            Long l = (Long) Utils.getOrNull(context, MESSAGE_ENQUEUED_TIME, Long.class);
            if (l != null) {
                HashMap map = new HashMap(1);
                map.put(MESSAGE_ENQUEUED_TIME, l);
                tracingLink = new TracingLink(context, map);
            } else {
                tracingLink = new TracingLink(context);
            }
            startSpanOptions.addLink(tracingLink);
        }
    }

    @Deprecated
    default Context extractContext(final String str, Context context) {
        return extractContext(new Function() { // from class: com.azure.core.util.tracing.Tracer$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Tracer.lambda$extractContext$1(str, (String) obj);
            }
        });
    }

    static /* synthetic */ String lambda$extractContext$1(String str, String str2) {
        if (str2.equals("traceparent") || str2.equals(DIAGNOSTIC_ID_KEY)) {
            return str;
        }
        return null;
    }

    default Context extractContext(Function<String, String> function) {
        return Context.NONE;
    }

    @Deprecated
    default Context getSharedSpanBuilder(String str, Context context) {
        if (!isEnabled()) {
            return context;
        }
        SpanKind spanKind = (SpanKind) Utils.getOrNull(context, "span-kind", SpanKind.class);
        if (spanKind == null) {
            spanKind = SpanKind.CLIENT;
        }
        StartSpanOptions startSpanOptions = new StartSpanOptions(spanKind);
        Instant instant = (Instant) Utils.getOrNull(context, "span-start-time", Instant.class);
        if (instant != null) {
            startSpanOptions.setStartTimestamp(instant);
        }
        return context.addData(SPAN_BUILDER_KEY, startSpanOptions);
    }

    @Deprecated
    default void addEvent(String str, Map<String, Object> map, OffsetDateTime offsetDateTime) {
        addEvent(str, map, offsetDateTime, Context.NONE);
    }

    default AutoCloseable makeSpanCurrent(Context context) {
        return NoopTracer.INSTANCE.makeSpanCurrent(context);
    }
}
