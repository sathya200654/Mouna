package com.azure.core.util.tracing;

import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class Utils {
    static final String SPAN_KIND_KEY = "span-kind";
    static final String START_TIME_KEY = "span-start-time";
    static final AutoCloseable NOOP_CLOSEABLE = new AutoCloseable() { // from class: com.azure.core.util.tracing.Utils$$ExternalSyntheticLambda0
        @Override // java.lang.AutoCloseable
        public final void close() throws Exception {
            Utils.lambda$static$0();
        }
    };
    static final ClientLogger LOGGER = new ClientLogger((Class<?>) Utils.class);

    static /* synthetic */ void lambda$static$0() throws Exception {
    }

    private Utils() {
    }

    static void addMessagingAttributes(StartSpanOptions startSpanOptions, Context context) {
        String str = (String) getOrNull(context, Tracer.ENTITY_PATH_KEY, String.class);
        if (str != null) {
            startSpanOptions.setAttribute(Tracer.ENTITY_PATH_KEY, str);
        }
        String str2 = (String) getOrNull(context, Tracer.HOST_NAME_KEY, String.class);
        if (str2 != null) {
            startSpanOptions.setAttribute(Tracer.HOST_NAME_KEY, str2);
        }
        Long l = (Long) getOrNull(context, Tracer.MESSAGE_ENQUEUED_TIME, Long.class);
        if (l != null) {
            startSpanOptions.setAttribute(Tracer.MESSAGE_ENQUEUED_TIME, l);
        }
    }

    static <T> T getOrNull(Context context, String str, Class<T> cls) {
        T t = (T) context.getData(str).orElse(null);
        if (t == null || !cls.isAssignableFrom(t.getClass())) {
            return null;
        }
        return t;
    }
}
