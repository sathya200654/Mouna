package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class RecognizeSpeechInterpretAndInsertMessageUseCase_Factory implements Factory<RecognizeSpeechInterpretAndInsertMessageUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationMessageRepository> conversationMessageRepositoryProvider;
    private final Provider<ConversationSpeechRecognizerService> conversationSpeechRecognizerServiceProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<WebViewManager> webViewManagerProvider;

    private RecognizeSpeechInterpretAndInsertMessageUseCase_Factory(Provider<ConversationSpeechRecognizerService> conversationSpeechRecognizerServiceProvider, Provider<ConversationMessageRepository> conversationMessageRepositoryProvider, Provider<WebViewManager> webViewManagerProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.conversationSpeechRecognizerServiceProvider = conversationSpeechRecognizerServiceProvider;
        this.conversationMessageRepositoryProvider = conversationMessageRepositoryProvider;
        this.webViewManagerProvider = webViewManagerProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public RecognizeSpeechInterpretAndInsertMessageUseCase m1492get() {
        return newInstance((ConversationSpeechRecognizerService) this.conversationSpeechRecognizerServiceProvider.get(), (ConversationMessageRepository) this.conversationMessageRepositoryProvider.get(), (WebViewManager) this.webViewManagerProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }

    public static RecognizeSpeechInterpretAndInsertMessageUseCase_Factory create(Provider<ConversationSpeechRecognizerService> conversationSpeechRecognizerServiceProvider, Provider<ConversationMessageRepository> conversationMessageRepositoryProvider, Provider<WebViewManager> webViewManagerProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new RecognizeSpeechInterpretAndInsertMessageUseCase_Factory(conversationSpeechRecognizerServiceProvider, conversationMessageRepositoryProvider, webViewManagerProvider, analyticsManagerProvider, ioDispatcherProvider);
    }

    public static RecognizeSpeechInterpretAndInsertMessageUseCase newInstance(ConversationSpeechRecognizerService conversationSpeechRecognizerService, ConversationMessageRepository conversationMessageRepository, WebViewManager webViewManager, AnalyticsManager analyticsManager, CoroutineDispatcher ioDispatcher) {
        return new RecognizeSpeechInterpretAndInsertMessageUseCase(conversationSpeechRecognizerService, conversationMessageRepository, webViewManager, analyticsManager, ioDispatcher);
    }
}
