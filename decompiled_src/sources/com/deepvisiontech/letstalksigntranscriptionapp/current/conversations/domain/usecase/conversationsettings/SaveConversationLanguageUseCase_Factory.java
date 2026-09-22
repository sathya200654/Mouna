package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SaveConversationLanguageUseCase_Factory implements Factory<SaveConversationLanguageUseCase> {
    private final Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider;

    private SaveConversationLanguageUseCase_Factory(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider) {
        this.conversationSettingsRepositoryProvider = conversationSettingsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SaveConversationLanguageUseCase m1505get() {
        return newInstance((ConversationSettingsRepository) this.conversationSettingsRepositoryProvider.get());
    }

    public static SaveConversationLanguageUseCase_Factory create(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider) {
        return new SaveConversationLanguageUseCase_Factory(conversationSettingsRepositoryProvider);
    }

    public static SaveConversationLanguageUseCase newInstance(ConversationSettingsRepository conversationSettingsRepository) {
        return new SaveConversationLanguageUseCase(conversationSettingsRepository);
    }
}
