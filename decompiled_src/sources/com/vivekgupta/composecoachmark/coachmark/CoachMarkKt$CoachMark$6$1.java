package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CoachMark.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$6$1", f = "CoachMark.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CoachMarkKt$CoachMark$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoachMarkState $coachMarkState;
    final /* synthetic */ MutableState<Integer> $count$delegate;
    final /* synthetic */ Function2<Integer, Integer, Unit> $onBeforeShowingCoachMark;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CoachMarkKt$CoachMark$6$1(Function2<? super Integer, ? super Integer, Unit> function2, CoachMarkState coachMarkState, MutableState<Integer> mutableState, Continuation<? super CoachMarkKt$CoachMark$6$1> continuation) {
        super(2, continuation);
        this.$onBeforeShowingCoachMark = function2;
        this.$coachMarkState = coachMarkState;
        this.$count$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoachMarkKt$CoachMark$6$1(this.$onBeforeShowingCoachMark, this.$coachMarkState, this.$count$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onBeforeShowingCoachMark.invoke(Boxing.boxInt(CoachMarkKt.CoachMark$lambda$3(this.$count$delegate)), Boxing.boxInt(HelperKt.firstKey(this.$coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(this.$count$delegate))));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
