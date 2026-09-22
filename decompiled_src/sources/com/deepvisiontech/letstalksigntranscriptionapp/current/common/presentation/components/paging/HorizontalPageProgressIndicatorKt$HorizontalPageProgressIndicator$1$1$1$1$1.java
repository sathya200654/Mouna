package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.pager.PagerState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HorizontalPageProgressIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt$HorizontalPageProgressIndicator$1$1$1$1$1", f = "HorizontalPageProgressIndicator.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
final class HorizontalPageProgressIndicatorKt$HorizontalPageProgressIndicator$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $iteration;
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HorizontalPageProgressIndicatorKt$HorizontalPageProgressIndicator$1$1$1$1$1(PagerState pagerState, int i, Continuation<? super HorizontalPageProgressIndicatorKt$HorizontalPageProgressIndicator$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$iteration = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HorizontalPageProgressIndicatorKt$HorizontalPageProgressIndicator$1$1$1$1$1(this.$pagerState, this.$iteration, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (PagerState.animateScrollToPage$default(this.$pagerState, this.$iteration, 0.0f, (AnimationSpec) null, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
