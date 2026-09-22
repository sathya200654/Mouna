package com.microsoft.cognitiveservices.speech;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public enum PronunciationAssessmentGradingSystem {
    FivePoint(1),
    HundredMark(2);

    private final int id;

    PronunciationAssessmentGradingSystem(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
