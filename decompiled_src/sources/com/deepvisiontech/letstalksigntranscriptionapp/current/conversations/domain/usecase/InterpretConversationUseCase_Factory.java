package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class InterpretConversationUseCase_Factory implements Factory<InterpretConversationUseCase> {
    private final Provider<ConversationMessageRepository> conversationMessageRepositoryProvider;
    private final Provider<WebViewManager> webViewManagerProvider;

    private InterpretConversationUseCase_Factory(Provider<WebViewManager> webViewManagerProvider, Provider<ConversationMessageRepository> conversationMessageRepositoryProvider) {
        this.webViewManagerProvider = webViewManagerProvider;
        this.conversationMessageRepositoryProvider = conversationMessageRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InterpretConversationUseCase m1491get() {
        return newInstance((WebViewManager) this.webViewManagerProvider.get(), (ConversationMessageRepository) this.conversationMessageRepositoryProvider.get());
    }

    public static InterpretConversationUseCase_Factory create(Provider<WebViewManager> webViewManagerProvider, Provider<ConversationMessageRepository> conversationMessageRepositoryProvider) {
        return new InterpretConversationUseCase_Factory(webViewManagerProvider, conversationMessageRepositoryProvider);
    }

    public static InterpretConversationUseCase newInstance(WebViewManager webViewManager, ConversationMessageRepository conversationMessageRepository) {
        return new InterpretConversationUseCase(webViewManager, conversationMessageRepository);
    }
}
