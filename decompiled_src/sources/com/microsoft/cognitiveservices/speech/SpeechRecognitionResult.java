package com.microsoft.cognitiveservices.speech;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class SpeechRecognitionResult extends RecognitionResult {
    protected SpeechRecognitionResult(long j) {
        super(j);
    }

    @Override // com.microsoft.cognitiveservices.speech.RecognitionResult, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    public String toString() {
        return "ResultId:" + getResultId() + " Status:" + getReason() + " Recognized text:<" + getText() + ">.";
    }
}
