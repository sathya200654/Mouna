package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n¨\u0006\u0006"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$special$$inlined$flatMapLatest$1", f = "ConversationViewModel.kt", i = {0, 0}, l = {189}, m = "invokeSuspend", n = {"$this$transformLatest", "it"}, s = {"L$0", "L$1"})
public final class ConversationViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends ConversationMessage>>, Pair<? extends Conversation, ? extends String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$special$$inlined$flatMapLatest$1(Continuation continuation, ConversationViewModel conversationViewModel) {
        super(3, continuation);
        this.this$0 = conversationViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((FlowCollector<? super List<? extends ConversationMessage>>) obj, (Pair<? extends Conversation, ? extends String>) obj2, (Continuation<? super Unit>) obj3);
    }

    public final Object invoke(FlowCollector<? super List<? extends ConversationMessage>> flowCollector, Pair<? extends Conversation, ? extends String> pair, Continuation<? super Unit> continuation) {
        ConversationViewModel$special$$inlined$flatMapLatest$1 conversationViewModel$special$$inlined$flatMapLatest$1 = new ConversationViewModel$special$$inlined$flatMapLatest$1(continuation, this.this$0);
        conversationViewModel$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
        conversationViewModel$special$$inlined$flatMapLatest$1.L$1 = pair;
        return conversationViewModel$special$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Flow<List<ConversationMessage>> flowInvoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object obj2 = this.L$1;
            Continuation continuation = (Continuation) this;
            Pair pair = (Pair) obj2;
            Conversation conversation = (Conversation) pair.component1();
            String str = (String) pair.component2();
            if (conversation == null) {
                flowInvoke = FlowKt.flowOf(CollectionsKt.emptyList());
            } else {
                flowInvoke = this.this$0.conversationManagementUseCases.getGetFilteredMessages().invoke(conversation.getId(), str);
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flowInvoke, continuation) == coroutine_suspended) {
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
