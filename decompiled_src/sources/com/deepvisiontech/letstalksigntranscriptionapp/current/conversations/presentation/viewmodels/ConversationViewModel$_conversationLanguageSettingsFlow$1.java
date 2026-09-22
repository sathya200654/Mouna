package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "userLang", "speakerLang"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$_conversationLanguageSettingsFlow$1", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationViewModel$_conversationLanguageSettingsFlow$1 extends SuspendLambda implements Function3<LanguageEnum, LanguageEnum, Continuation<? super Pair<? extends LanguageEnum, ? extends LanguageEnum>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    ConversationViewModel$_conversationLanguageSettingsFlow$1(Continuation<? super ConversationViewModel$_conversationLanguageSettingsFlow$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(LanguageEnum languageEnum, LanguageEnum languageEnum2, Continuation<? super Pair<? extends LanguageEnum, ? extends LanguageEnum>> continuation) {
        ConversationViewModel$_conversationLanguageSettingsFlow$1 conversationViewModel$_conversationLanguageSettingsFlow$1 = new ConversationViewModel$_conversationLanguageSettingsFlow$1(continuation);
        conversationViewModel$_conversationLanguageSettingsFlow$1.L$0 = languageEnum;
        conversationViewModel$_conversationLanguageSettingsFlow$1.L$1 = languageEnum2;
        return conversationViewModel$_conversationLanguageSettingsFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LanguageEnum languageEnum = (LanguageEnum) this.L$0;
        LanguageEnum languageEnum2 = (LanguageEnum) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new Pair(languageEnum, languageEnum2);
    }
}
