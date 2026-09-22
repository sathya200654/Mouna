package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class KeywordRecognitionResult extends RecognitionResult {
    KeywordRecognitionResult(long j) {
        super(j);
        Contracts.throwIfNull(super.getImpl(), "resultHandle");
    }

    @Override // com.microsoft.cognitiveservices.speech.RecognitionResult, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    public String toString() {
        return "ResultId:" + getResultId() + " Reason:" + getReason() + "> Recognized text:<" + getText() + ">.";
    }
}
