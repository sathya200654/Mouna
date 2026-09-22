package androidx.wear.compose.materialcore;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RepeatableClickable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.materialcore.RepeatableClickableKt$repeatableClickable$1$2$1$1$1$repeatingJob$1", f = "RepeatableClickable.kt", i = {}, l = {109, 113}, m = "invokeSuspend", n = {}, s = {})
final class RepeatableClickableKt$repeatableClickable$1$2$1$1$1$repeatingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Unit>> $currentOnRepeatableClick$delegate;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableState<Boolean> $ignoreOnClick$delegate;
    final /* synthetic */ long $incrementalDelay;
    final /* synthetic */ long $initialDelay;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RepeatableClickableKt$repeatableClickable$1$2$1$1$1$repeatingJob$1(long j, boolean z, long j2, MutableState<Boolean> mutableState, State<? extends Function0<Unit>> state, Continuation<? super RepeatableClickableKt$repeatableClickable$1$2$1$1$1$repeatingJob$1> continuation) {
        super(2, continuation);
        this.$initialDelay = j;
        this.$enabled = z;
        this.$incrementalDelay = j2;
        this.$ignoreOnClick$delegate = mutableState;
        this.$currentOnRepeatableClick$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RepeatableClickableKt$repeatableClickable$1$2$1$1$1$repeatingJob$1(this.$initialDelay, this.$enabled, this.$incrementalDelay, this.$ignoreOnClick$delegate, this.$currentOnRepeatableClick$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    /* JADX WARN: Code duplicated, block: B:21:0x004e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:? A[LOOP:0: B:14:0x0034->B:24:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r6.$initialDelay, (kotlin.coroutines.Continuation) r6) == r0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r7)
            goto L34
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L2f
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            long r4 = r6.$initialDelay
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
            if (r7 != r0) goto L2f
            goto L4e
        L2f:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r7 = r6.$ignoreOnClick$delegate
            androidx.wear.compose.materialcore.RepeatableClickableKt$repeatableClickable$1.access$invoke$lambda$4(r7, r3)
        L34:
            boolean r7 = r6.$enabled
            if (r7 == 0) goto L4f
            androidx.compose.runtime.State<kotlin.jvm.functions.Function0<kotlin.Unit>> r7 = r6.$currentOnRepeatableClick$delegate
            kotlin.jvm.functions.Function0 r7 = androidx.wear.compose.materialcore.RepeatableClickableKt$repeatableClickable$1.access$invoke$lambda$0(r7)
            r7.invoke()
            long r3 = r6.$incrementalDelay
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.label = r2
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r3, r7)
            if (r7 != r0) goto L34
        L4e:
            return r0
        L4f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.materialcore.RepeatableClickableKt$repeatableClickable$1$2$1$1$1$repeatingJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
