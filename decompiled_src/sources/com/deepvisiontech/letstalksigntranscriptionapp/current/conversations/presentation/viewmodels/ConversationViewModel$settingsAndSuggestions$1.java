package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSuggestionsState;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationScreenSettingsState;", "sug", "set"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$settingsAndSuggestions$1", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationViewModel$settingsAndSuggestions$1 extends SuspendLambda implements Function3<ConversationSuggestionsState, ConversationScreenSettingsState, Continuation<? super Pair<? extends ConversationSuggestionsState, ? extends ConversationScreenSettingsState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    ConversationViewModel$settingsAndSuggestions$1(Continuation<? super ConversationViewModel$settingsAndSuggestions$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ConversationSuggestionsState conversationSuggestionsState, ConversationScreenSettingsState conversationScreenSettingsState, Continuation<? super Pair<ConversationSuggestionsState, ConversationScreenSettingsState>> continuation) {
        ConversationViewModel$settingsAndSuggestions$1 conversationViewModel$settingsAndSuggestions$1 = new ConversationViewModel$settingsAndSuggestions$1(continuation);
        conversationViewModel$settingsAndSuggestions$1.L$0 = conversationSuggestionsState;
        conversationViewModel$settingsAndSuggestions$1.L$1 = conversationScreenSettingsState;
        return conversationViewModel$settingsAndSuggestions$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConversationSuggestionsState conversationSuggestionsState = (ConversationSuggestionsState) this.L$0;
        ConversationScreenSettingsState conversationScreenSettingsState = (ConversationScreenSettingsState) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new Pair(conversationSuggestionsState, conversationScreenSettingsState);
    }
}
