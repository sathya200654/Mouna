package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SetConversationModeUseCase_Factory implements Factory<SetConversationModeUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider;

    private SetConversationModeUseCase_Factory(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.conversationSettingsRepositoryProvider = conversationSettingsRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SetConversationModeUseCase m1494get() {
        return newInstance((ConversationSettingsRepository) this.conversationSettingsRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static SetConversationModeUseCase_Factory create(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new SetConversationModeUseCase_Factory(conversationSettingsRepositoryProvider, analyticsManagerProvider);
    }

    public static SetConversationModeUseCase newInstance(ConversationSettingsRepository conversationSettingsRepository, AnalyticsManager analyticsManager) {
        return new SetConversationModeUseCase(conversationSettingsRepository, analyticsManager);
    }
}
