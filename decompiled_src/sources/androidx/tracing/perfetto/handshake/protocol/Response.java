package androidx.tracing.perfetto.handshake.protocol;

import kotlin.Metadata;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/tracing/perfetto/handshake/protocol/Response;", "", "resultCode", "", ResponseKeys.KEY_REQUIRED_VERSION, "", ResponseKeys.KEY_MESSAGE, "(ILjava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getRequiredVersion", "getResultCode", "()I", "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Response {
    private final String message;
    private final String requiredVersion;
    private final int resultCode;

    public Response(int i, String str, String str2) {
        this.resultCode = i;
        this.requiredVersion = str;
        this.message = str2;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String getRequiredVersion() {
        return this.requiredVersion;
    }

    public final String getMessage() {
        return this.message;
    }
}
