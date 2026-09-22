package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationSpeakerLanguageUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationSettingsUseCases_Factory implements Factory<ConversationSettingsUseCases> {
    private final Provider<SetConversationSpeakerLanguageUseCase> setSpeakerLanguageProvider;
    private final Provider<SetConversationUserLanguageUseCase> setUserLanguageProvider;

    private ConversationSettingsUseCases_Factory(Provider<SetConversationUserLanguageUseCase> setUserLanguageProvider, Provider<SetConversationSpeakerLanguageUseCase> setSpeakerLanguageProvider) {
        this.setUserLanguageProvider = setUserLanguageProvider;
        this.setSpeakerLanguageProvider = setSpeakerLanguageProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSettingsUseCases m1523get() {
        return newInstance((SetConversationUserLanguageUseCase) this.setUserLanguageProvider.get(), (SetConversationSpeakerLanguageUseCase) this.setSpeakerLanguageProvider.get());
    }

    public static ConversationSettingsUseCases_Factory create(Provider<SetConversationUserLanguageUseCase> setUserLanguageProvider, Provider<SetConversationSpeakerLanguageUseCase> setSpeakerLanguageProvider) {
        return new ConversationSettingsUseCases_Factory(setUserLanguageProvider, setSpeakerLanguageProvider);
    }

    public static ConversationSettingsUseCases newInstance(SetConversationUserLanguageUseCase setUserLanguage, SetConversationSpeakerLanguageUseCase setSpeakerLanguage) {
        return new ConversationSettingsUseCases(setUserLanguage, setSpeakerLanguage);
    }
}
