package coil3.network.okhttp.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: compiled from: calls.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012#\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bB\u001d\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0096\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcoil3/network/okhttp/internal/ContinuationCallback;", "Lokhttp3/Callback;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "call", "Lokhttp3/Call;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lokhttp3/Response;", "<init>", "(Lokhttp3/Call;Lkotlinx/coroutines/CancellableContinuation;)V", "onResponse", "response", "onFailure", "e", "Ljava/io/IOException;", "Lokio/IOException;", "invoke", "coil-network-okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class ContinuationCallback implements Callback, Function1<Throwable, Unit> {
    private final Call call;
    private final CancellableContinuation<Response> continuation;

    public ContinuationCallback(Call call, CancellableContinuation<? super Response> cancellableContinuation) {
        this.call = call;
        this.continuation = cancellableContinuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void onResponse(Call call, Response response) {
        Continuation continuation = this.continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.constructor-impl(response));
    }

    public void onFailure(Call call, IOException e) {
        if (call.isCanceled()) {
            return;
        }
        Continuation continuation = this.continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
    }

    public void invoke(Throwable cause) {
        try {
            this.call.cancel();
        } catch (Throwable unused) {
        }
    }
}
