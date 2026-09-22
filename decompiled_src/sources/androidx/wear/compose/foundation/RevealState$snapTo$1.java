package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.RevealState", f = "SwipeToReveal.kt", i = {0, 0}, l = {267, 269}, m = "snapTo-HVQT5Qc", n = {"this", "targetValue"}, s = {"L$0", "I$0"})
final class RevealState$snapTo$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RevealState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RevealState$snapTo$1(RevealState revealState, Continuation<? super RevealState$snapTo$1> continuation) {
        super(continuation);
        this.this$0 = revealState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m396snapToHVQT5Qc(0, (Continuation) this);
    }
}
