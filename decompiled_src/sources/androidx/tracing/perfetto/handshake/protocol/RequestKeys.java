package androidx.tracing.perfetto.handshake.protocol;

import kotlin.Metadata;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/tracing/perfetto/handshake/protocol/RequestKeys;", "", "()V", "ACTION_DISABLE_TRACING_COLD_START", "", "ACTION_ENABLE_TRACING", "ACTION_ENABLE_TRACING_COLD_START", "KEY_PATH", "KEY_PERSISTENT", "RECEIVER_CLASS_NAME", "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RequestKeys {
    public static final String ACTION_DISABLE_TRACING_COLD_START = "androidx.tracing.perfetto.action.DISABLE_TRACING_COLD_START";
    public static final String ACTION_ENABLE_TRACING = "androidx.tracing.perfetto.action.ENABLE_TRACING";
    public static final String ACTION_ENABLE_TRACING_COLD_START = "androidx.tracing.perfetto.action.ENABLE_TRACING_COLD_START";
    public static final RequestKeys INSTANCE = new RequestKeys();
    public static final String KEY_PATH = "path";
    public static final String KEY_PERSISTENT = "persistent";
    public static final String RECEIVER_CLASS_NAME = "androidx.tracing.perfetto.TracingReceiver";

    private RequestKeys() {
    }
}
