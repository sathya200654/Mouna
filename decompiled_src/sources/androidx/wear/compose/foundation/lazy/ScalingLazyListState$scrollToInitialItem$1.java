package androidx.wear.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ScalingLazyListState.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.lazy.ScalingLazyListState", f = "ScalingLazyListState.kt", i = {0}, l = {514, 523}, m = "scrollToInitialItem$compose_foundation_release", n = {"this"}, s = {"L$0"})
final class ScalingLazyListState$scrollToInitialItem$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScalingLazyListState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScalingLazyListState$scrollToInitialItem$1(ScalingLazyListState scalingLazyListState, Continuation<? super ScalingLazyListState$scrollToInitialItem$1> continuation) {
        super(continuation);
        this.this$0 = scalingLazyListState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.scrollToInitialItem$compose_foundation_release((Continuation) this);
    }
}
