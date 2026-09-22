package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ConversationListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListScreenUiState;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$uiState$5", f = "ConversationListViewModel.kt", i = {0, 1}, l = {90, 93}, m = "invokeSuspend", n = {"$this$catch", "$this$catch"}, s = {"L$0", "L$0"})
final class ConversationListViewModel$uiState$5 extends SuspendLambda implements Function3<FlowCollector<? super ConversationListScreenUiState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConversationListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConversationListViewModel$uiState$5(ConversationListViewModel conversationListViewModel, Continuation<? super ConversationListViewModel$uiState$5> continuation) {
        super(3, continuation);
        this.this$0 = conversationListViewModel;
    }

    public final Object invoke(FlowCollector<? super ConversationListScreenUiState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        ConversationListViewModel$uiState$5 conversationListViewModel$uiState$5 = new ConversationListViewModel$uiState$5(this.this$0, continuation);
        conversationListViewModel$uiState$5.L$0 = flowCollector;
        return conversationListViewModel$uiState$5.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0062, code lost:
    
        if (r0.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenUiState(null, true, false, null, null, null, com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError.UnknownError.INSTANCE, 61, null), (kotlin.coroutines.Continuation) r14) == r1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r14.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L22
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.ResultKt.throwOnFailure(r15)
            goto L65
        L16:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L1e:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L40
        L22:
            kotlin.ResultKt.throwOnFailure(r15)
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel r15 = r14.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r15 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.access$get_uiEvent$p(r15)
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent$ShowUserMessage r2 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent$ShowUserMessage
            int r5 = com.deepvisiontech.letstalksigntranscriptionapp.R.string.conversation_list_load_error
            r2.<init>(r5)
            r5 = r14
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r14.L$0 = r0
            r14.label = r4
            java.lang.Object r15 = r15.emit(r2, r5)
            if (r15 != r1) goto L40
            goto L64
        L40:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError$UnknownError r15 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError.UnknownError.INSTANCE
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenUiState r4 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenUiState
            r11 = r15
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r11 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError) r11
            r12 = 61
            r13 = 0
            r5 = 0
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r15 = r14
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r14.L$0 = r2
            r14.label = r3
            java.lang.Object r14 = r0.emit(r4, r15)
            if (r14 != r1) goto L65
        L64:
            return r1
        L65:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$uiState$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
