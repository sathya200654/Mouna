package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.State;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OnBoardingScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$OnBoardingScreen$2$1", f = "OnBoardingScreen.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
final class OnBoardingScreenKt$OnBoardingScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ State<OnBoardingUiState> $uiState$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnBoardingScreenKt$OnBoardingScreen$2$1(PagerState pagerState, State<OnBoardingUiState> state, Continuation<? super OnBoardingScreenKt$OnBoardingScreen$2$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$uiState$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnBoardingScreenKt$OnBoardingScreen$2$1(this.$pagerState, this.$uiState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (OnBoardingScreenKt.OnBoardingScreen$lambda$0(this.$uiState$delegate).getPages().size() > this.$pagerState.getCurrentPage() + 1) {
                this.label = 1;
                if (PagerState.animateScrollToPage$default(this.$pagerState, OnBoardingScreenKt.OnBoardingScreen$lambda$0(this.$uiState$delegate).getPages().size() - 1, 0.0f, (AnimationSpec) null, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
