package androidx.tracing.perfetto.handshake;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PerfettoSdkHandshake.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/tracing/perfetto/handshake/PerfettoSdkHandshakeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", ResponseKeys.KEY_MESSAGE, "", "(Ljava/lang/String;)V", "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PerfettoSdkHandshakeException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PerfettoSdkHandshakeException(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
    }
}
