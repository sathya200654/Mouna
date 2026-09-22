package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ResetSelectedVoiceUseCase_Factory implements Factory<ResetSelectedVoiceUseCase> {
    private final Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider;

    private ResetSelectedVoiceUseCase_Factory(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider) {
        this.conversationSettingsRepositoryProvider = conversationSettingsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ResetSelectedVoiceUseCase m1503get() {
        return newInstance((ConversationSettingsRepository) this.conversationSettingsRepositoryProvider.get());
    }

    public static ResetSelectedVoiceUseCase_Factory create(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider) {
        return new ResetSelectedVoiceUseCase_Factory(conversationSettingsRepositoryProvider);
    }

    public static ResetSelectedVoiceUseCase newInstance(ConversationSettingsRepository conversationSettingsRepository) {
        return new ResetSelectedVoiceUseCase(conversationSettingsRepository);
    }
}
