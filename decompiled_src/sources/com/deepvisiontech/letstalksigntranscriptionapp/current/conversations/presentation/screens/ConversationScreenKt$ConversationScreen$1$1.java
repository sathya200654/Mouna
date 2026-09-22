package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.State;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActivity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ConversationScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$1$1", f = "ConversationScreen.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
final class ConversationScreenKt$ConversationScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ State<ConversationUiState> $uiState$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConversationScreenKt$ConversationScreen$1$1(LazyListState lazyListState, State<ConversationUiState> state, Continuation<? super ConversationScreenKt$ConversationScreen$1$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$uiState$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenKt$ConversationScreen$1$1(this.$listState, this.$uiState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!ConversationScreenKt.ConversationScreen$lambda$1(this.$uiState$delegate).getConversationMessages().isEmpty() || ConversationScreenKt.ConversationScreen$lambda$1(this.$uiState$delegate).isPartialTextVisible() || (ConversationScreenKt.ConversationScreen$lambda$1(this.$uiState$delegate).getActivity() instanceof ConversationActivity.IsInterpreting)) {
                this.label = 1;
                if (LazyListState.animateScrollToItem$default(this.$listState, 0, 0, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
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
