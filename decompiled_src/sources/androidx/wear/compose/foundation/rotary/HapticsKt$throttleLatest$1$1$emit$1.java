package androidx.wear.compose.foundation.rotary;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Haptics.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.rotary.HapticsKt$throttleLatest$1$1", f = "Haptics.kt", i = {0}, l = {387, 388}, m = "emit", n = {"this"}, s = {"L$0"})
final class HapticsKt$throttleLatest$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HapticsKt.AnonymousClass1.C00111<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HapticsKt$throttleLatest$1$1$emit$1(HapticsKt.AnonymousClass1.C00111<? super T> c00111, Continuation<? super HapticsKt$throttleLatest$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c00111;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (Continuation) this);
    }
}
