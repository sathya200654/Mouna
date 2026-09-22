package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SetConversationUserLanguageUseCase_Factory implements Factory<SetConversationUserLanguageUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider;

    private SetConversationUserLanguageUseCase_Factory(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.conversationSettingsRepositoryProvider = conversationSettingsRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SetConversationUserLanguageUseCase m1508get() {
        return newInstance((ConversationSettingsRepository) this.conversationSettingsRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static SetConversationUserLanguageUseCase_Factory create(Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new SetConversationUserLanguageUseCase_Factory(conversationSettingsRepositoryProvider, analyticsManagerProvider);
    }

    public static SetConversationUserLanguageUseCase newInstance(ConversationSettingsRepository conversationSettingsRepository, AnalyticsManager analyticsManager) {
        return new SetConversationUserLanguageUseCase(conversationSettingsRepository, analyticsManager);
    }
}
