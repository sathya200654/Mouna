package coil3.compose;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: LocalAsyncImagePreviewHandler.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.AsyncImagePreviewHandler$Companion$Default$1", f = "LocalAsyncImagePreviewHandler.kt", i = {0, 0}, l = {38}, m = "handle", n = {"imageLoader", "request"}, s = {"L$0", "L$1"})
final class AsyncImagePreviewHandler$Companion$Default$1$handle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncImagePreviewHandler$Companion$Default$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncImagePreviewHandler$Companion$Default$1$handle$1(AsyncImagePreviewHandler$Companion$Default$1 asyncImagePreviewHandler$Companion$Default$1, Continuation<? super AsyncImagePreviewHandler$Companion$Default$1$handle$1> continuation) {
        super(continuation);
        this.this$0 = asyncImagePreviewHandler$Companion$Default$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handle(null, null, (Continuation) this);
    }
}
