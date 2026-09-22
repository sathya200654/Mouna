package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class StopInterpretationAndTranscriptionUseCase_Factory implements Factory<StopInterpretationAndTranscriptionUseCase> {
    private final Provider<ConversationSpeechRecognizerService> conversationSpeechRecognizerServiceProvider;
    private final Provider<WebViewManager> webViewManagerProvider;

    private StopInterpretationAndTranscriptionUseCase_Factory(Provider<ConversationSpeechRecognizerService> conversationSpeechRecognizerServiceProvider, Provider<WebViewManager> webViewManagerProvider) {
        this.conversationSpeechRecognizerServiceProvider = conversationSpeechRecognizerServiceProvider;
        this.webViewManagerProvider = webViewManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public StopInterpretationAndTranscriptionUseCase m1497get() {
        return newInstance((ConversationSpeechRecognizerService) this.conversationSpeechRecognizerServiceProvider.get(), (WebViewManager) this.webViewManagerProvider.get());
    }

    public static StopInterpretationAndTranscriptionUseCase_Factory create(Provider<ConversationSpeechRecognizerService> conversationSpeechRecognizerServiceProvider, Provider<WebViewManager> webViewManagerProvider) {
        return new StopInterpretationAndTranscriptionUseCase_Factory(conversationSpeechRecognizerServiceProvider, webViewManagerProvider);
    }

    public static StopInterpretationAndTranscriptionUseCase newInstance(ConversationSpeechRecognizerService conversationSpeechRecognizerService, WebViewManager webViewManager) {
        return new StopInterpretationAndTranscriptionUseCase(conversationSpeechRecognizerService, webViewManager);
    }
}
