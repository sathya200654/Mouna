package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Expandable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.ExpandableState$expanded$1", f = "Expandable.kt", i = {}, l = {261, 263}, m = "invokeSuspend", n = {}, s = {})
final class ExpandableState$expanded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $newValue;
    int label;
    final /* synthetic */ ExpandableState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpandableState$expanded$1(boolean z, ExpandableState expandableState, Continuation<? super ExpandableState$expanded$1> continuation) {
        super(2, continuation);
        this.$newValue = z;
        this.this$0 = expandableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpandableState$expanded$1(this.$newValue, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r12.this$0._expandProgress, kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f), r12.this$0.expandAnimationSpec, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, (kotlin.coroutines.Continuation) r12, 12, (java.lang.Object) null) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r12.this$0._expandProgress, kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), r12.this$0.collapseAnimationSpec, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, (kotlin.coroutines.Continuation) r12, 12, (java.lang.Object) null) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L17:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L67
        L1b:
            kotlin.ResultKt.throwOnFailure(r13)
            boolean r13 = r12.$newValue
            if (r13 == 0) goto L45
            androidx.wear.compose.foundation.ExpandableState r13 = r12.this$0
            androidx.compose.animation.core.Animatable r4 = androidx.wear.compose.foundation.ExpandableState.access$get_expandProgress$p(r13)
            r13 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            androidx.wear.compose.foundation.ExpandableState r13 = r12.this$0
            androidx.compose.animation.core.AnimationSpec r6 = androidx.wear.compose.foundation.ExpandableState.access$getExpandAnimationSpec$p(r13)
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r12.label = r3
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r12 != r0) goto L67
            goto L66
        L45:
            androidx.wear.compose.foundation.ExpandableState r13 = r12.this$0
            androidx.compose.animation.core.Animatable r3 = androidx.wear.compose.foundation.ExpandableState.access$get_expandProgress$p(r13)
            r13 = 0
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            androidx.wear.compose.foundation.ExpandableState r13 = r12.this$0
            androidx.compose.animation.core.AnimationSpec r5 = androidx.wear.compose.foundation.ExpandableState.access$getCollapseAnimationSpec$p(r13)
            r8 = r12
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r12.label = r2
            r6 = 0
            r7 = 0
            r9 = 12
            r10 = 0
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L67
        L66:
            return r0
        L67:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.ExpandableState$expanded$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
