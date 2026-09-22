package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "input", "sessionTarget"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$speakerLanguage$1", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationSettingsRepositoryImpl$speakerLanguage$1 extends SuspendLambda implements Function3<LanguageEnum, LanguageEnum, Continuation<? super LanguageEnum>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    ConversationSettingsRepositoryImpl$speakerLanguage$1(Continuation<? super ConversationSettingsRepositoryImpl$speakerLanguage$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(LanguageEnum languageEnum, LanguageEnum languageEnum2, Continuation<? super LanguageEnum> continuation) {
        ConversationSettingsRepositoryImpl$speakerLanguage$1 conversationSettingsRepositoryImpl$speakerLanguage$1 = new ConversationSettingsRepositoryImpl$speakerLanguage$1(continuation);
        conversationSettingsRepositoryImpl$speakerLanguage$1.L$0 = languageEnum;
        conversationSettingsRepositoryImpl$speakerLanguage$1.L$1 = languageEnum2;
        return conversationSettingsRepositoryImpl$speakerLanguage$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LanguageEnum languageEnum = (LanguageEnum) this.L$0;
        LanguageEnum languageEnum2 = (LanguageEnum) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return languageEnum2 == null ? languageEnum : languageEnum2;
    }
}
