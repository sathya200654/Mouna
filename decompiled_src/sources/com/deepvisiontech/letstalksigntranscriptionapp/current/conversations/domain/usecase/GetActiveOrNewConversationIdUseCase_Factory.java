package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetActiveOrNewConversationIdUseCase_Factory implements Factory<GetActiveOrNewConversationIdUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationRepository> conversationRepositoryProvider;
    private final Provider<ConversationSessionRepository> conversationSessionRepositoryProvider;

    private GetActiveOrNewConversationIdUseCase_Factory(Provider<ConversationSessionRepository> conversationSessionRepositoryProvider, Provider<ConversationRepository> conversationRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.conversationSessionRepositoryProvider = conversationSessionRepositoryProvider;
        this.conversationRepositoryProvider = conversationRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetActiveOrNewConversationIdUseCase m1486get() {
        return newInstance((ConversationSessionRepository) this.conversationSessionRepositoryProvider.get(), (ConversationRepository) this.conversationRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static GetActiveOrNewConversationIdUseCase_Factory create(Provider<ConversationSessionRepository> conversationSessionRepositoryProvider, Provider<ConversationRepository> conversationRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new GetActiveOrNewConversationIdUseCase_Factory(conversationSessionRepositoryProvider, conversationRepositoryProvider, analyticsManagerProvider);
    }

    public static GetActiveOrNewConversationIdUseCase newInstance(ConversationSessionRepository conversationSessionRepository, ConversationRepository conversationRepository, AnalyticsManager analyticsManager) {
        return new GetActiveOrNewConversationIdUseCase(conversationSessionRepository, conversationRepository, analyticsManager);
    }
}
