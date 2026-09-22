package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SpeakAndInsertMessageUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SpeakConversationUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextToSpeechUseCases.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/TextToSpeechUseCases;", "", "speakAndInsert", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SpeakAndInsertMessageUseCase;", "speakMessage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SpeakConversationUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SpeakAndInsertMessageUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SpeakConversationUseCase;)V", "getSpeakAndInsert", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SpeakAndInsertMessageUseCase;", "getSpeakMessage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SpeakConversationUseCase;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextToSpeechUseCases {
    public static final int $stable = 8;
    private final SpeakAndInsertMessageUseCase speakAndInsert;
    private final SpeakConversationUseCase speakMessage;

    @Inject
    public TextToSpeechUseCases(SpeakAndInsertMessageUseCase speakAndInsertMessageUseCase, SpeakConversationUseCase speakConversationUseCase) {
        Intrinsics.checkNotNullParameter(speakAndInsertMessageUseCase, "speakAndInsert");
        Intrinsics.checkNotNullParameter(speakConversationUseCase, "speakMessage");
        this.speakAndInsert = speakAndInsertMessageUseCase;
        this.speakMessage = speakConversationUseCase;
    }

    public final SpeakAndInsertMessageUseCase getSpeakAndInsert() {
        return this.speakAndInsert;
    }

    public final SpeakConversationUseCase getSpeakMessage() {
        return this.speakMessage;
    }
}
