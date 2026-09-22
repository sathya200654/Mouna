package com.microsoft.cognitiveservices.speech;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SyllableLevelTimingResult extends TimingResult {
    private double accuracyScore;
    private String grapheme;
    private String syllable;

    SyllableLevelTimingResult(JSONObject jSONObject) {
        super(jSONObject);
        this.syllable = jSONObject.optString("Syllable");
        this.grapheme = jSONObject.optString("Grapheme");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("PronunciationAssessment");
        if (jSONObjectOptJSONObject != null) {
            this.accuracyScore = jSONObjectOptJSONObject.optDouble("AccuracyScore");
        }
    }

    public double getAccuracyScore() {
        return this.accuracyScore;
    }

    public String getGrapheme() {
        return this.grapheme;
    }

    public String getSyllable() {
        return this.syllable;
    }
}
