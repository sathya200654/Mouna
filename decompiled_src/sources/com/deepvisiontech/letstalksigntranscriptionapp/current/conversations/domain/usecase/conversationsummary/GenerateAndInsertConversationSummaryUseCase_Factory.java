package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsummary;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GenerateAndInsertConversationSummaryUseCase_Factory implements Factory<GenerateAndInsertConversationSummaryUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationMessageRepository> conversationMessageRepositoryProvider;
    private final Provider<ConversationUsageRepository> conversationUsageRepositoryProvider;
    private final Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private GenerateAndInsertConversationSummaryUseCase_Factory(Provider<ConversationMessageRepository> conversationMessageRepositoryProvider, Provider<ConversationUsageRepository> conversationUsageRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider) {
        this.conversationMessageRepositoryProvider = conversationMessageRepositoryProvider;
        this.conversationUsageRepositoryProvider = conversationUsageRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
        this.ltsTranslationRepositoryProvider = ltsTranslationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GenerateAndInsertConversationSummaryUseCase m1519get() {
        return newInstance((ConversationMessageRepository) this.conversationMessageRepositoryProvider.get(), (ConversationUsageRepository) this.conversationUsageRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get(), (LtsTranslationRepository) this.ltsTranslationRepositoryProvider.get());
    }

    public static GenerateAndInsertConversationSummaryUseCase_Factory create(Provider<ConversationMessageRepository> conversationMessageRepositoryProvider, Provider<ConversationUsageRepository> conversationUsageRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider) {
        return new GenerateAndInsertConversationSummaryUseCase_Factory(conversationMessageRepositoryProvider, conversationUsageRepositoryProvider, sessionRepositoryProvider, analyticsManagerProvider, ltsTranslationRepositoryProvider);
    }

    public static GenerateAndInsertConversationSummaryUseCase newInstance(ConversationMessageRepository conversationMessageRepository, ConversationUsageRepository conversationUsageRepository, SessionRepository sessionRepository, AnalyticsManager analyticsManager, LtsTranslationRepository ltsTranslationRepository) {
        return new GenerateAndInsertConversationSummaryUseCase(conversationMessageRepository, conversationUsageRepository, sessionRepository, analyticsManager, ltsTranslationRepository);
    }
}
