package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SetConversationTranscriptionFontSizeUseCase_Factory implements Factory<SetConversationTranscriptionFontSizeUseCase> {
    private final Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider;

    private SetConversationTranscriptionFontSizeUseCase_Factory(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider) {
        this.conversationSettingsRepositoryProvider = conversationSettingsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SetConversationTranscriptionFontSizeUseCase m1507get() {
        return newInstance((ConversationSettingsRepository) this.conversationSettingsRepositoryProvider.get());
    }

    public static SetConversationTranscriptionFontSizeUseCase_Factory create(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider) {
        return new SetConversationTranscriptionFontSizeUseCase_Factory(conversationSettingsRepositoryProvider);
    }

    public static SetConversationTranscriptionFontSizeUseCase newInstance(ConversationSettingsRepository conversationSettingsRepository) {
        return new SetConversationTranscriptionFontSizeUseCase(conversationSettingsRepository);
    }
}
