package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "exception", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$_conversationMessageFlow$4", f = "ConversationViewModel.kt", i = {0, 0, 1, 1}, l = {395, 396}, m = "invokeSuspend", n = {"$this$catch", "exception", "$this$catch", "exception"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ConversationViewModel$_conversationMessageFlow$4 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends ConversationMessage>>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConversationViewModel$_conversationMessageFlow$4(ConversationViewModel conversationViewModel, Continuation<? super ConversationViewModel$_conversationMessageFlow$4> continuation) {
        super(3, continuation);
        this.this$0 = conversationViewModel;
    }

    public final Object invoke(FlowCollector<? super List<ConversationMessage>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        ConversationViewModel$_conversationMessageFlow$4 conversationViewModel$_conversationMessageFlow$4 = new ConversationViewModel$_conversationMessageFlow$4(this.this$0, continuation);
        conversationViewModel$_conversationMessageFlow$4.L$0 = flowCollector;
        conversationViewModel$_conversationMessageFlow$4.L$1 = th;
        return conversationViewModel$_conversationMessageFlow$4.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006a, code lost:
    
        if (r0.emit(kotlin.collections.CollectionsKt.emptyList(), (kotlin.coroutines.Continuation) r8) == r2) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = r8.L$1
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L26
            if (r3 == r5) goto L22
            if (r3 != r4) goto L1a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6d
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L22:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L51
        L26:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = "ConversationViewModel"
            java.lang.String r3 = "Failed to load conversation messages"
            android.util.Log.e(r9, r3, r1)
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r9 = r8.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r9 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$get_uiEvent$p(r9)
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error r3 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error
            int r6 = com.deepvisiontech.letstalksigntranscriptionapp.R.string.conversation_messages_load_error
            r3.<init>(r6)
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.L$0 = r0
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r8.L$1 = r7
            r8.label = r5
            java.lang.Object r9 = r9.emit(r3, r6)
            if (r9 != r2) goto L51
            goto L6c
        L51:
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
            r3 = r8
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r8.L$0 = r5
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r8.L$1 = r1
            r8.label = r4
            java.lang.Object r8 = r0.emit(r9, r3)
            if (r8 != r2) goto L6d
        L6c:
            return r2
        L6d:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$_conversationMessageFlow$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
