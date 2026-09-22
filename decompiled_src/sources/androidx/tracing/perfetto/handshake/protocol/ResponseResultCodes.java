package androidx.tracing.perfetto.handshake.protocol;

import kotlin.Metadata;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/tracing/perfetto/handshake/protocol/ResponseResultCodes;", "", "()V", "RESULT_CODE_ALREADY_ENABLED", "", "RESULT_CODE_CANCELLED", "getRESULT_CODE_CANCELLED$annotations", "RESULT_CODE_ERROR_BINARY_MISSING", "RESULT_CODE_ERROR_BINARY_VERIFICATION_ERROR", "RESULT_CODE_ERROR_BINARY_VERSION_MISMATCH", "RESULT_CODE_ERROR_OTHER", "RESULT_CODE_SUCCESS", "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResponseResultCodes {
    public static final ResponseResultCodes INSTANCE = new ResponseResultCodes();
    public static final int RESULT_CODE_ALREADY_ENABLED = 2;
    public static final int RESULT_CODE_CANCELLED = 0;
    public static final int RESULT_CODE_ERROR_BINARY_MISSING = 11;
    public static final int RESULT_CODE_ERROR_BINARY_VERIFICATION_ERROR = 13;
    public static final int RESULT_CODE_ERROR_BINARY_VERSION_MISMATCH = 12;
    public static final int RESULT_CODE_ERROR_OTHER = 99;
    public static final int RESULT_CODE_SUCCESS = 1;

    public static /* synthetic */ void getRESULT_CODE_CANCELLED$annotations() {
    }

    private ResponseResultCodes() {
    }
}
