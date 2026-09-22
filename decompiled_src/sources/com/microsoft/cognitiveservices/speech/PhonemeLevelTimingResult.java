package com.microsoft.cognitiveservices.speech;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class PhonemeLevelTimingResult extends TimingResult {
    private double accuracyScore;
    private List<NBestPhoneme> nbestPhonemes;
    private String phoneme;

    PhonemeLevelTimingResult(JSONObject jSONObject) {
        super(jSONObject);
        this.phoneme = jSONObject.optString("Phoneme");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("PronunciationAssessment");
        if (jSONObjectOptJSONObject != null) {
            this.accuracyScore = jSONObjectOptJSONObject.optDouble("AccuracyScore");
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("NBestPhonemes");
        if (jSONArrayOptJSONArray != null) {
            this.nbestPhonemes = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                this.nbestPhonemes.add(new NBestPhoneme(jSONArrayOptJSONArray.optJSONObject(i)));
            }
        }
    }

    public double getAccuracyScore() {
        return this.accuracyScore;
    }

    public List<NBestPhoneme> getNBestPhonemes() {
        return this.nbestPhonemes;
    }

    public String getPhoneme() {
        return this.phoneme;
    }
}
