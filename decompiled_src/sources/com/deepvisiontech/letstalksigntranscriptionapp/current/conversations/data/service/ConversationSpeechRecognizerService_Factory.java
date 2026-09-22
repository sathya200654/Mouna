package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.factory.SpeechRecognizerFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationSpeechRecognizerService_Factory implements Factory<ConversationSpeechRecognizerService> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<SpeechRecognizerFactory> speechRecognizerFactoryProvider;

    private ConversationSpeechRecognizerService_Factory(Provider<SpeechRecognizerFactory> speechRecognizerFactoryProvider, Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.speechRecognizerFactoryProvider = speechRecognizerFactoryProvider;
        this.conversationSettingsRepositoryProvider = conversationSettingsRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSpeechRecognizerService m1469get() {
        return newInstance((SpeechRecognizerFactory) this.speechRecognizerFactoryProvider.get(), (ConversationSettingsRepository) this.conversationSettingsRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }

    public static ConversationSpeechRecognizerService_Factory create(Provider<SpeechRecognizerFactory> speechRecognizerFactoryProvider, Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new ConversationSpeechRecognizerService_Factory(speechRecognizerFactoryProvider, conversationSettingsRepositoryProvider, analyticsManagerProvider, ioDispatcherProvider);
    }

    public static ConversationSpeechRecognizerService newInstance(SpeechRecognizerFactory speechRecognizerFactory, ConversationSettingsRepository conversationSettingsRepository, AnalyticsManager analyticsManager, CoroutineDispatcher ioDispatcher) {
        return new ConversationSpeechRecognizerService(speechRecognizerFactory, conversationSettingsRepository, analyticsManager, ioDispatcher);
    }
}
