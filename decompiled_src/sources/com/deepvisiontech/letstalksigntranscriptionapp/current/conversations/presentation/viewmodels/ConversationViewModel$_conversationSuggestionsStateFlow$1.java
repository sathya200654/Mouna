package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSuggestionsState;", "isCorrectionSuggestionsEnabled", "", "allSuggestions", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "userLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$_conversationSuggestionsStateFlow$1", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationViewModel$_conversationSuggestionsStateFlow$1 extends SuspendLambda implements Function4<Boolean, List<? extends ConversationSuggestion>, LanguageEnum, Continuation<? super ConversationSuggestionsState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    int label;

    ConversationViewModel$_conversationSuggestionsStateFlow$1(Continuation<? super ConversationViewModel$_conversationSuggestionsStateFlow$1> continuation) {
        super(4, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke(((Boolean) obj).booleanValue(), (List<ConversationSuggestion>) obj2, (LanguageEnum) obj3, (Continuation<? super ConversationSuggestionsState>) obj4);
    }

    public final Object invoke(boolean z, List<ConversationSuggestion> list, LanguageEnum languageEnum, Continuation<? super ConversationSuggestionsState> continuation) {
        ConversationViewModel$_conversationSuggestionsStateFlow$1 conversationViewModel$_conversationSuggestionsStateFlow$1 = new ConversationViewModel$_conversationSuggestionsStateFlow$1(continuation);
        conversationViewModel$_conversationSuggestionsStateFlow$1.Z$0 = z;
        conversationViewModel$_conversationSuggestionsStateFlow$1.L$0 = list;
        conversationViewModel$_conversationSuggestionsStateFlow$1.L$1 = languageEnum;
        return conversationViewModel$_conversationSuggestionsStateFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z = this.Z$0;
        List list = (List) this.L$0;
        LanguageEnum languageEnum = (LanguageEnum) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((ConversationSuggestion) obj2).getLanguage() == languageEnum) {
                arrayList.add(obj2);
            }
        }
        return new ConversationSuggestionsState(z, arrayList);
    }
}
