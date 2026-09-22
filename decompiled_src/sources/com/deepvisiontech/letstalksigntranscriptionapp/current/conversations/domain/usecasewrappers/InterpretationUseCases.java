package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.InterpretConversationUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.RecognizeSpeechInterpretAndInsertMessageUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.StopInterpretationAndTranscriptionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.TranslateInterpretAndSaveMessageUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterpretationUseCases.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/InterpretationUseCases;", "", "recognizeInterpretAndInsert", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/RecognizeSpeechInterpretAndInsertMessageUseCase;", "interpretMessage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/InterpretConversationUseCase;", "translateInterpretAndSaveInputText", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/TranslateInterpretAndSaveMessageUseCase;", "stopInterpretationAndTranscription", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/StopInterpretationAndTranscriptionUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/RecognizeSpeechInterpretAndInsertMessageUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/InterpretConversationUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/TranslateInterpretAndSaveMessageUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/StopInterpretationAndTranscriptionUseCase;)V", "getRecognizeInterpretAndInsert", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/RecognizeSpeechInterpretAndInsertMessageUseCase;", "getInterpretMessage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/InterpretConversationUseCase;", "getTranslateInterpretAndSaveInputText", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/TranslateInterpretAndSaveMessageUseCase;", "getStopInterpretationAndTranscription", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/StopInterpretationAndTranscriptionUseCase;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InterpretationUseCases {
    public static final int $stable = 8;
    private final InterpretConversationUseCase interpretMessage;
    private final RecognizeSpeechInterpretAndInsertMessageUseCase recognizeInterpretAndInsert;
    private final StopInterpretationAndTranscriptionUseCase stopInterpretationAndTranscription;
    private final TranslateInterpretAndSaveMessageUseCase translateInterpretAndSaveInputText;

    public static /* synthetic */ InterpretationUseCases copy$default(InterpretationUseCases interpretationUseCases, RecognizeSpeechInterpretAndInsertMessageUseCase recognizeSpeechInterpretAndInsertMessageUseCase, InterpretConversationUseCase interpretConversationUseCase, TranslateInterpretAndSaveMessageUseCase translateInterpretAndSaveMessageUseCase, StopInterpretationAndTranscriptionUseCase stopInterpretationAndTranscriptionUseCase, int i, Object obj) {
        if ((i & 1) != 0) {
            recognizeSpeechInterpretAndInsertMessageUseCase = interpretationUseCases.recognizeInterpretAndInsert;
        }
        if ((i & 2) != 0) {
            interpretConversationUseCase = interpretationUseCases.interpretMessage;
        }
        if ((i & 4) != 0) {
            translateInterpretAndSaveMessageUseCase = interpretationUseCases.translateInterpretAndSaveInputText;
        }
        if ((i & 8) != 0) {
            stopInterpretationAndTranscriptionUseCase = interpretationUseCases.stopInterpretationAndTranscription;
        }
        return interpretationUseCases.copy(recognizeSpeechInterpretAndInsertMessageUseCase, interpretConversationUseCase, translateInterpretAndSaveMessageUseCase, stopInterpretationAndTranscriptionUseCase);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RecognizeSpeechInterpretAndInsertMessageUseCase getRecognizeInterpretAndInsert() {
        return this.recognizeInterpretAndInsert;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InterpretConversationUseCase getInterpretMessage() {
        return this.interpretMessage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TranslateInterpretAndSaveMessageUseCase getTranslateInterpretAndSaveInputText() {
        return this.translateInterpretAndSaveInputText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StopInterpretationAndTranscriptionUseCase getStopInterpretationAndTranscription() {
        return this.stopInterpretationAndTranscription;
    }

    public final InterpretationUseCases copy(RecognizeSpeechInterpretAndInsertMessageUseCase recognizeInterpretAndInsert, InterpretConversationUseCase interpretMessage, TranslateInterpretAndSaveMessageUseCase translateInterpretAndSaveInputText, StopInterpretationAndTranscriptionUseCase stopInterpretationAndTranscription) {
        Intrinsics.checkNotNullParameter(recognizeInterpretAndInsert, "recognizeInterpretAndInsert");
        Intrinsics.checkNotNullParameter(interpretMessage, "interpretMessage");
        Intrinsics.checkNotNullParameter(translateInterpretAndSaveInputText, "translateInterpretAndSaveInputText");
        Intrinsics.checkNotNullParameter(stopInterpretationAndTranscription, "stopInterpretationAndTranscription");
        return new InterpretationUseCases(recognizeInterpretAndInsert, interpretMessage, translateInterpretAndSaveInputText, stopInterpretationAndTranscription);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InterpretationUseCases)) {
            return false;
        }
        InterpretationUseCases interpretationUseCases = (InterpretationUseCases) other;
        return Intrinsics.areEqual(this.recognizeInterpretAndInsert, interpretationUseCases.recognizeInterpretAndInsert) && Intrinsics.areEqual(this.interpretMessage, interpretationUseCases.interpretMessage) && Intrinsics.areEqual(this.translateInterpretAndSaveInputText, interpretationUseCases.translateInterpretAndSaveInputText) && Intrinsics.areEqual(this.stopInterpretationAndTranscription, interpretationUseCases.stopInterpretationAndTranscription);
    }

    public int hashCode() {
        return (((((this.recognizeInterpretAndInsert.hashCode() * 31) + this.interpretMessage.hashCode()) * 31) + this.translateInterpretAndSaveInputText.hashCode()) * 31) + this.stopInterpretationAndTranscription.hashCode();
    }

    public String toString() {
        return "InterpretationUseCases(recognizeInterpretAndInsert=" + this.recognizeInterpretAndInsert + ", interpretMessage=" + this.interpretMessage + ", translateInterpretAndSaveInputText=" + this.translateInterpretAndSaveInputText + ", stopInterpretationAndTranscription=" + this.stopInterpretationAndTranscription + ")";
    }

    @Inject
    public InterpretationUseCases(RecognizeSpeechInterpretAndInsertMessageUseCase recognizeSpeechInterpretAndInsertMessageUseCase, InterpretConversationUseCase interpretConversationUseCase, TranslateInterpretAndSaveMessageUseCase translateInterpretAndSaveMessageUseCase, StopInterpretationAndTranscriptionUseCase stopInterpretationAndTranscriptionUseCase) {
        Intrinsics.checkNotNullParameter(recognizeSpeechInterpretAndInsertMessageUseCase, "recognizeInterpretAndInsert");
        Intrinsics.checkNotNullParameter(interpretConversationUseCase, "interpretMessage");
        Intrinsics.checkNotNullParameter(translateInterpretAndSaveMessageUseCase, "translateInterpretAndSaveInputText");
        Intrinsics.checkNotNullParameter(stopInterpretationAndTranscriptionUseCase, "stopInterpretationAndTranscription");
        this.recognizeInterpretAndInsert = recognizeSpeechInterpretAndInsertMessageUseCase;
        this.interpretMessage = interpretConversationUseCase;
        this.translateInterpretAndSaveInputText = translateInterpretAndSaveMessageUseCase;
        this.stopInterpretationAndTranscription = stopInterpretationAndTranscriptionUseCase;
    }

    public final RecognizeSpeechInterpretAndInsertMessageUseCase getRecognizeInterpretAndInsert() {
        return this.recognizeInterpretAndInsert;
    }

    public final InterpretConversationUseCase getInterpretMessage() {
        return this.interpretMessage;
    }

    public final TranslateInterpretAndSaveMessageUseCase getTranslateInterpretAndSaveInputText() {
        return this.translateInterpretAndSaveInputText;
    }

    public final StopInterpretationAndTranscriptionUseCase getStopInterpretationAndTranscription() {
        return this.stopInterpretationAndTranscription;
    }
}
