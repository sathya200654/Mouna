package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationSpeakerLanguageUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSettingsUseCases.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/ConversationSettingsUseCases;", "", "setUserLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationUserLanguageUseCase;", "setSpeakerLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationSpeakerLanguageUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationUserLanguageUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationSpeakerLanguageUseCase;)V", "getSetUserLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationUserLanguageUseCase;", "getSetSpeakerLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationSpeakerLanguageUseCase;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationSettingsUseCases {
    public static final int $stable = 8;
    private final SetConversationSpeakerLanguageUseCase setSpeakerLanguage;
    private final SetConversationUserLanguageUseCase setUserLanguage;

    @Inject
    public ConversationSettingsUseCases(SetConversationUserLanguageUseCase setConversationUserLanguageUseCase, SetConversationSpeakerLanguageUseCase setConversationSpeakerLanguageUseCase) {
        Intrinsics.checkNotNullParameter(setConversationUserLanguageUseCase, "setUserLanguage");
        Intrinsics.checkNotNullParameter(setConversationSpeakerLanguageUseCase, "setSpeakerLanguage");
        this.setUserLanguage = setConversationUserLanguageUseCase;
        this.setSpeakerLanguage = setConversationSpeakerLanguageUseCase;
    }

    public final SetConversationUserLanguageUseCase getSetUserLanguage() {
        return this.setUserLanguage;
    }

    public final SetConversationSpeakerLanguageUseCase getSetSpeakerLanguage() {
        return this.setSpeakerLanguage;
    }
}
