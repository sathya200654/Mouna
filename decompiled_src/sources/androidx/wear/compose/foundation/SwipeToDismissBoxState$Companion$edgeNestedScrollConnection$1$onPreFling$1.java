package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: BasicSwipeToDismissBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1", f = "BasicSwipeToDismissBox.kt", i = {0}, l = {383}, m = "onPreFling-QWom1Mo", n = {"available"}, s = {"J$0"})
final class SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1(SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1<T> swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1, Continuation<? super SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1> continuation) {
        super(continuation);
        this.this$0 = swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m413onPreFlingQWom1Mo(0L, (Continuation) this);
    }
}
