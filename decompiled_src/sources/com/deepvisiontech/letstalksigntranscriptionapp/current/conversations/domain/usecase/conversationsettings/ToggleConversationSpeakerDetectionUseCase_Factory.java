package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ToggleConversationSpeakerDetectionUseCase_Factory implements Factory<ToggleConversationSpeakerDetectionUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider;

    private ToggleConversationSpeakerDetectionUseCase_Factory(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.conversationSettingsRepositoryProvider = conversationSettingsRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ToggleConversationSpeakerDetectionUseCase m1512get() {
        return newInstance((ConversationSettingsRepository) this.conversationSettingsRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static ToggleConversationSpeakerDetectionUseCase_Factory create(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new ToggleConversationSpeakerDetectionUseCase_Factory(conversationSettingsRepositoryProvider, analyticsManagerProvider);
    }

    public static ToggleConversationSpeakerDetectionUseCase newInstance(ConversationSettingsRepository conversationSettingsRepository, AnalyticsManager analyticsManager) {
        return new ToggleConversationSpeakerDetectionUseCase(conversationSettingsRepository, analyticsManager);
    }
}
