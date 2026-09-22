package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "", "conversation", "query"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$_conversationMessageFlow$2", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationViewModel$_conversationMessageFlow$2 extends SuspendLambda implements Function3<Conversation, String, Continuation<? super Pair<? extends Conversation, ? extends String>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    ConversationViewModel$_conversationMessageFlow$2(Continuation<? super ConversationViewModel$_conversationMessageFlow$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(Conversation conversation, String str, Continuation<? super Pair<Conversation, String>> continuation) {
        ConversationViewModel$_conversationMessageFlow$2 conversationViewModel$_conversationMessageFlow$2 = new ConversationViewModel$_conversationMessageFlow$2(continuation);
        conversationViewModel$_conversationMessageFlow$2.L$0 = conversation;
        conversationViewModel$_conversationMessageFlow$2.L$1 = str;
        return conversationViewModel$_conversationMessageFlow$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Conversation conversation = (Conversation) this.L$0;
        String str = (String) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new Pair(conversation, str);
    }
}
