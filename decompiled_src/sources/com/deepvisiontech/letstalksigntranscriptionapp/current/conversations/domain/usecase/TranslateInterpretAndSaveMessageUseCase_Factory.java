package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class TranslateInterpretAndSaveMessageUseCase_Factory implements Factory<TranslateInterpretAndSaveMessageUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationMessageRepository> conversationMessageRepositoryProvider;
    private final Provider<ConversationUsageRepository> conversationUsageRepositoryProvider;
    private final Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;
    private final Provider<WebViewManager> webViewManagerProvider;

    private TranslateInterpretAndSaveMessageUseCase_Factory(Provider<WebViewManager> webViewManagerProvider, Provider<ConversationMessageRepository> conversationMessageRepositoryProvider, Provider<ConversationUsageRepository> conversationUsageRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider) {
        this.webViewManagerProvider = webViewManagerProvider;
        this.conversationMessageRepositoryProvider = conversationMessageRepositoryProvider;
        this.conversationUsageRepositoryProvider = conversationUsageRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.ltsTranslationRepositoryProvider = ltsTranslationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public TranslateInterpretAndSaveMessageUseCase m1498get() {
        return newInstance((WebViewManager) this.webViewManagerProvider.get(), (ConversationMessageRepository) this.conversationMessageRepositoryProvider.get(), (ConversationUsageRepository) this.conversationUsageRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get(), (LtsTranslationRepository) this.ltsTranslationRepositoryProvider.get());
    }

    public static TranslateInterpretAndSaveMessageUseCase_Factory create(Provider<WebViewManager> webViewManagerProvider, Provider<ConversationMessageRepository> conversationMessageRepositoryProvider, Provider<ConversationUsageRepository> conversationUsageRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider) {
        return new TranslateInterpretAndSaveMessageUseCase_Factory(webViewManagerProvider, conversationMessageRepositoryProvider, conversationUsageRepositoryProvider, analyticsManagerProvider, sessionRepositoryProvider, ltsTranslationRepositoryProvider);
    }

    public static TranslateInterpretAndSaveMessageUseCase newInstance(WebViewManager webViewManager, ConversationMessageRepository conversationMessageRepository, ConversationUsageRepository conversationUsageRepository, AnalyticsManager analyticsManager, SessionRepository sessionRepository, LtsTranslationRepository ltsTranslationRepository) {
        return new TranslateInterpretAndSaveMessageUseCase(webViewManager, conversationMessageRepository, conversationUsageRepository, analyticsManager, sessionRepository, ltsTranslationRepository);
    }
}
