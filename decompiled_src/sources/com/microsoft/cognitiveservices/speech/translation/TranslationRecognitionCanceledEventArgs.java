package com.microsoft.cognitiveservices.speech.translation;

import com.microsoft.cognitiveservices.speech.CancellationDetails;
import com.microsoft.cognitiveservices.speech.CancellationErrorCode;
import com.microsoft.cognitiveservices.speech.CancellationReason;
import com.microsoft.cognitiveservices.speech.util.Contracts;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class TranslationRecognitionCanceledEventArgs extends TranslationRecognitionEventArgs {
    private CancellationReason cancellationReason;
    private CancellationErrorCode errorCode;
    private String errorDetails;

    TranslationRecognitionCanceledEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    TranslationRecognitionCanceledEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }

    private void storeEventData(boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        CancellationDetails cancellationDetailsFromResult = CancellationDetails.fromResult(getResult());
        this.cancellationReason = cancellationDetailsFromResult.getReason();
        this.errorCode = cancellationDetailsFromResult.getErrorCode();
        this.errorDetails = cancellationDetailsFromResult.getErrorDetails();
        if (z) {
            super.close();
        }
    }

    public CancellationErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDetails() {
        return this.errorDetails;
    }

    public CancellationReason getReason() {
        return this.cancellationReason;
    }

    @Override // com.microsoft.cognitiveservices.speech.translation.TranslationRecognitionEventArgs, com.microsoft.cognitiveservices.speech.RecognitionEventArgs, com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        return "SessionId:" + getSessionId() + " ResultId:" + getResult().getResultId() + " CancellationReason:" + this.cancellationReason + " CancellationErrorCode:" + this.errorCode + " Error details:" + this.errorDetails;
    }
}
