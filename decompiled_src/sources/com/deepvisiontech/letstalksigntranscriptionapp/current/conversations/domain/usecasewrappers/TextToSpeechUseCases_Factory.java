package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SpeakAndInsertMessageUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SpeakConversationUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class TextToSpeechUseCases_Factory implements Factory<TextToSpeechUseCases> {
    private final Provider<SpeakAndInsertMessageUseCase> speakAndInsertProvider;
    private final Provider<SpeakConversationUseCase> speakMessageProvider;

    private TextToSpeechUseCases_Factory(Provider<SpeakAndInsertMessageUseCase> speakAndInsertProvider, Provider<SpeakConversationUseCase> speakMessageProvider) {
        this.speakAndInsertProvider = speakAndInsertProvider;
        this.speakMessageProvider = speakMessageProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public TextToSpeechUseCases m1526get() {
        return newInstance((SpeakAndInsertMessageUseCase) this.speakAndInsertProvider.get(), (SpeakConversationUseCase) this.speakMessageProvider.get());
    }

    public static TextToSpeechUseCases_Factory create(Provider<SpeakAndInsertMessageUseCase> speakAndInsertProvider, Provider<SpeakConversationUseCase> speakMessageProvider) {
        return new TextToSpeechUseCases_Factory(speakAndInsertProvider, speakMessageProvider);
    }

    public static TextToSpeechUseCases newInstance(SpeakAndInsertMessageUseCase speakAndInsert, SpeakConversationUseCase speakMessage) {
        return new TextToSpeechUseCases(speakAndInsert, speakMessage);
    }
}
