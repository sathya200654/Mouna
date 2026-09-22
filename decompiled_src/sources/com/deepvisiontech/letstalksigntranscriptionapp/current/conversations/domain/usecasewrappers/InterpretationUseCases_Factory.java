package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.InterpretConversationUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.RecognizeSpeechInterpretAndInsertMessageUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.StopInterpretationAndTranscriptionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.TranslateInterpretAndSaveMessageUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class InterpretationUseCases_Factory implements Factory<InterpretationUseCases> {
    private final Provider<InterpretConversationUseCase> interpretMessageProvider;
    private final Provider<RecognizeSpeechInterpretAndInsertMessageUseCase> recognizeInterpretAndInsertProvider;
    private final Provider<StopInterpretationAndTranscriptionUseCase> stopInterpretationAndTranscriptionProvider;
    private final Provider<TranslateInterpretAndSaveMessageUseCase> translateInterpretAndSaveInputTextProvider;

    private InterpretationUseCases_Factory(Provider<RecognizeSpeechInterpretAndInsertMessageUseCase> recognizeInterpretAndInsertProvider, Provider<InterpretConversationUseCase> interpretMessageProvider, Provider<TranslateInterpretAndSaveMessageUseCase> translateInterpretAndSaveInputTextProvider, Provider<StopInterpretationAndTranscriptionUseCase> stopInterpretationAndTranscriptionProvider) {
        this.recognizeInterpretAndInsertProvider = recognizeInterpretAndInsertProvider;
        this.interpretMessageProvider = interpretMessageProvider;
        this.translateInterpretAndSaveInputTextProvider = translateInterpretAndSaveInputTextProvider;
        this.stopInterpretationAndTranscriptionProvider = stopInterpretationAndTranscriptionProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InterpretationUseCases m1524get() {
        return newInstance((RecognizeSpeechInterpretAndInsertMessageUseCase) this.recognizeInterpretAndInsertProvider.get(), (InterpretConversationUseCase) this.interpretMessageProvider.get(), (TranslateInterpretAndSaveMessageUseCase) this.translateInterpretAndSaveInputTextProvider.get(), (StopInterpretationAndTranscriptionUseCase) this.stopInterpretationAndTranscriptionProvider.get());
    }

    public static InterpretationUseCases_Factory create(Provider<RecognizeSpeechInterpretAndInsertMessageUseCase> recognizeInterpretAndInsertProvider, Provider<InterpretConversationUseCase> interpretMessageProvider, Provider<TranslateInterpretAndSaveMessageUseCase> translateInterpretAndSaveInputTextProvider, Provider<StopInterpretationAndTranscriptionUseCase> stopInterpretationAndTranscriptionProvider) {
        return new InterpretationUseCases_Factory(recognizeInterpretAndInsertProvider, interpretMessageProvider, translateInterpretAndSaveInputTextProvider, stopInterpretationAndTranscriptionProvider);
    }

    public static InterpretationUseCases newInstance(RecognizeSpeechInterpretAndInsertMessageUseCase recognizeInterpretAndInsert, InterpretConversationUseCase interpretMessage, TranslateInterpretAndSaveMessageUseCase translateInterpretAndSaveInputText, StopInterpretationAndTranscriptionUseCase stopInterpretationAndTranscription) {
        return new InterpretationUseCases(recognizeInterpretAndInsert, interpretMessage, translateInterpretAndSaveInputText, stopInterpretationAndTranscription);
    }
}
