package androidx.tracing.perfetto.handshake.protocol;

import kotlin.Metadata;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/tracing/perfetto/handshake/protocol/ResponseKeys;", "", "()V", "KEY_MESSAGE", "", "KEY_REQUIRED_VERSION", "KEY_RESULT_CODE", "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResponseKeys {
    public static final ResponseKeys INSTANCE = new ResponseKeys();
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_REQUIRED_VERSION = "requiredVersion";
    public static final String KEY_RESULT_CODE = "exitCode";

    private ResponseKeys() {
    }
}
