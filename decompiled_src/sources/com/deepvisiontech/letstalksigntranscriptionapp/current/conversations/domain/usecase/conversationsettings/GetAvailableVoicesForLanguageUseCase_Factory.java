package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetAvailableVoicesForLanguageUseCase_Factory implements Factory<GetAvailableVoicesForLanguageUseCase> {
    private final Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider;
    private final Provider<TextToSpeechManager> textToSpeechManagerProvider;

    private GetAvailableVoicesForLanguageUseCase_Factory(Provider<TextToSpeechManager> textToSpeechManagerProvider, Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider) {
        this.textToSpeechManagerProvider = textToSpeechManagerProvider;
        this.conversationSettingsRepositoryProvider = conversationSettingsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetAvailableVoicesForLanguageUseCase m1501get() {
        return newInstance((TextToSpeechManager) this.textToSpeechManagerProvider.get(), (ConversationSettingsRepository) this.conversationSettingsRepositoryProvider.get());
    }

    public static GetAvailableVoicesForLanguageUseCase_Factory create(Provider<TextToSpeechManager> textToSpeechManagerProvider, Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider) {
        return new GetAvailableVoicesForLanguageUseCase_Factory(textToSpeechManagerProvider, conversationSettingsRepositoryProvider);
    }

    public static GetAvailableVoicesForLanguageUseCase newInstance(TextToSpeechManager textToSpeechManager, ConversationSettingsRepository conversationSettingsRepository) {
        return new GetAvailableVoicesForLanguageUseCase(textToSpeechManager, conversationSettingsRepository);
    }
}
