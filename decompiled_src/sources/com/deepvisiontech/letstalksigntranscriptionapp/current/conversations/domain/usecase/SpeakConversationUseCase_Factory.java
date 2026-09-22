package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SpeakConversationUseCase_Factory implements Factory<SpeakConversationUseCase> {
    private final Provider<ConversationMessageRepository> conversationMessageRepositoryProvider;
    private final Provider<TextToSpeechManager> textToSpeechManagerProvider;

    private SpeakConversationUseCase_Factory(Provider<TextToSpeechManager> textToSpeechManagerProvider, Provider<ConversationMessageRepository> conversationMessageRepositoryProvider) {
        this.textToSpeechManagerProvider = textToSpeechManagerProvider;
        this.conversationMessageRepositoryProvider = conversationMessageRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SpeakConversationUseCase m1496get() {
        return newInstance((TextToSpeechManager) this.textToSpeechManagerProvider.get(), (ConversationMessageRepository) this.conversationMessageRepositoryProvider.get());
    }

    public static SpeakConversationUseCase_Factory create(Provider<TextToSpeechManager> textToSpeechManagerProvider, Provider<ConversationMessageRepository> conversationMessageRepositoryProvider) {
        return new SpeakConversationUseCase_Factory(textToSpeechManagerProvider, conversationMessageRepositoryProvider);
    }

    public static SpeakConversationUseCase newInstance(TextToSpeechManager textToSpeechManager, ConversationMessageRepository conversationMessageRepository) {
        return new SpeakConversationUseCase(textToSpeechManager, conversationMessageRepository);
    }
}
