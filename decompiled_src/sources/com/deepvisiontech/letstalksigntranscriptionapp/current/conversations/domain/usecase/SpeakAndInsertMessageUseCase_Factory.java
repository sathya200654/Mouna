package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SpeakAndInsertMessageUseCase_Factory implements Factory<SpeakAndInsertMessageUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationMessageRepository> conversationMessageRepositoryProvider;
    private final Provider<ConversationUsageRepository> conversationUsageRepositoryProvider;
    private final Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;
    private final Provider<TextToSpeechManager> textToSpeechManagerProvider;

    private SpeakAndInsertMessageUseCase_Factory(Provider<ConversationMessageRepository> conversationMessageRepositoryProvider, Provider<ConversationUsageRepository> conversationUsageRepositoryProvider, Provider<TextToSpeechManager> textToSpeechManagerProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        this.conversationMessageRepositoryProvider = conversationMessageRepositoryProvider;
        this.conversationUsageRepositoryProvider = conversationUsageRepositoryProvider;
        this.textToSpeechManagerProvider = textToSpeechManagerProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
        this.ltsTranslationRepositoryProvider = ltsTranslationRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SpeakAndInsertMessageUseCase m1495get() {
        return newInstance((ConversationMessageRepository) this.conversationMessageRepositoryProvider.get(), (ConversationUsageRepository) this.conversationUsageRepositoryProvider.get(), (TextToSpeechManager) this.textToSpeechManagerProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get(), (LtsTranslationRepository) this.ltsTranslationRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get());
    }

    public static SpeakAndInsertMessageUseCase_Factory create(Provider<ConversationMessageRepository> conversationMessageRepositoryProvider, Provider<ConversationUsageRepository> conversationUsageRepositoryProvider, Provider<TextToSpeechManager> textToSpeechManagerProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        return new SpeakAndInsertMessageUseCase_Factory(conversationMessageRepositoryProvider, conversationUsageRepositoryProvider, textToSpeechManagerProvider, analyticsManagerProvider, ltsTranslationRepositoryProvider, sessionRepositoryProvider);
    }

    public static SpeakAndInsertMessageUseCase newInstance(ConversationMessageRepository conversationMessageRepository, ConversationUsageRepository conversationUsageRepository, TextToSpeechManager textToSpeechManager, AnalyticsManager analyticsManager, LtsTranslationRepository ltsTranslationRepository, SessionRepository sessionRepository) {
        return new SpeakAndInsertMessageUseCase(conversationMessageRepository, conversationUsageRepository, textToSpeechManager, analyticsManager, ltsTranslationRepository, sessionRepository);
    }
}
