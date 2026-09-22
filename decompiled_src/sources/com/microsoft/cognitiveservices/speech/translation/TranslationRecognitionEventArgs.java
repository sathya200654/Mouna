package com.microsoft.cognitiveservices.speech.translation;

import com.microsoft.cognitiveservices.speech.RecognitionEventArgs;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class TranslationRecognitionEventArgs extends RecognitionEventArgs {
    private TranslationRecognitionResult result;

    TranslationRecognitionEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    TranslationRecognitionEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }

    private void storeEventData(boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getRecognitionResult(this.eventHandle, intRef));
        this.result = new TranslationRecognitionResult(intRef.getValue());
        Contracts.throwIfNull(getSessionId(), "SessionId");
        if (z) {
            super.close();
        }
    }

    public final TranslationRecognitionResult getResult() {
        return this.result;
    }

    @Override // com.microsoft.cognitiveservices.speech.RecognitionEventArgs, com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        String str = "TranslationRecognitionResult " + super.toString();
        for (String str2 : this.result.getTranslations().keySet()) {
            str = str + "    Translation in " + str2 + ": <" + this.result.getTranslations().get(str2) + ">.\n";
        }
        return str;
    }
}
