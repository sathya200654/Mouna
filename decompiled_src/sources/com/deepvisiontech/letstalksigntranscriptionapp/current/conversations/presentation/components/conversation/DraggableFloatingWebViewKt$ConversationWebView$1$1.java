package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DraggableFloatingWebView.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.DraggableFloatingWebViewKt$ConversationWebView$1$1", f = "DraggableFloatingWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DraggableFloatingWebViewKt$ConversationWebView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isInitialized$delegate;
    final /* synthetic */ MutableState<IntOffset> $offset$delegate;
    final /* synthetic */ MutableState<IntSize> $parentSize$delegate;
    final /* synthetic */ MutableState<IntSize> $viewSize$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DraggableFloatingWebViewKt$ConversationWebView$1$1(MutableState<Boolean> mutableState, MutableState<IntSize> mutableState2, MutableState<IntSize> mutableState3, MutableState<IntOffset> mutableState4, Continuation<? super DraggableFloatingWebViewKt$ConversationWebView$1$1> continuation) {
        super(2, continuation);
        this.$isInitialized$delegate = mutableState;
        this.$parentSize$delegate = mutableState2;
        this.$viewSize$delegate = mutableState3;
        this.$offset$delegate = mutableState4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DraggableFloatingWebViewKt$ConversationWebView$1$1(this.$isInitialized$delegate, this.$parentSize$delegate, this.$viewSize$delegate, this.$offset$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!DraggableFloatingWebViewKt.ConversationWebView$lambda$10(this.$isInitialized$delegate) && ((int) (DraggableFloatingWebViewKt.ConversationWebView$lambda$7(this.$parentSize$delegate) >> 32)) > 0 && ((int) (DraggableFloatingWebViewKt.ConversationWebView$lambda$4(this.$viewSize$delegate) >> 32)) > 0) {
                DraggableFloatingWebViewKt.ConversationWebView$lambda$2(this.$offset$delegate, IntOffset.constructor-impl((((long) (((int) (DraggableFloatingWebViewKt.ConversationWebView$lambda$7(this.$parentSize$delegate) >> 32)) - ((int) (DraggableFloatingWebViewKt.ConversationWebView$lambda$4(this.$viewSize$delegate) >> 32)))) << 32) | (((long) 0) & 4294967295L)));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
