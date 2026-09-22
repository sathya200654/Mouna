package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ConversationBottomBar.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$BottomBarInputRow$1$1", f = "ConversationBottomBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationBottomBarKt$BottomBarInputRow$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isImeVisible;
    final /* synthetic */ Function1<ConversationUiAction, Unit> $onUiAction;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ConversationBottomBarKt$BottomBarInputRow$1$1(boolean z, Function1<? super ConversationUiAction, Unit> function1, Continuation<? super ConversationBottomBarKt$BottomBarInputRow$1$1> continuation) {
        super(2, continuation);
        this.$isImeVisible = z;
        this.$onUiAction = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationBottomBarKt$BottomBarInputRow$1$1(this.$isImeVisible, this.$onUiAction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$isImeVisible) {
            this.$onUiAction.invoke(ConversationUiAction.OnMinimizeWebView.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
