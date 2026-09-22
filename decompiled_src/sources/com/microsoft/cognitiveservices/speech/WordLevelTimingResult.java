package com.microsoft.cognitiveservices.speech;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class WordLevelTimingResult extends TimingResult {
    private double accuracyScore;
    private String errorType;
    private List<PhonemeLevelTimingResult> phonemes;
    private List<SyllableLevelTimingResult> syllables;
    private String word;

    WordLevelTimingResult(JSONObject jSONObject) {
        super(jSONObject);
        this.word = jSONObject.optString("Word");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("PronunciationAssessment");
        if (jSONObjectOptJSONObject != null) {
            this.accuracyScore = jSONObjectOptJSONObject.optDouble("AccuracyScore");
            this.errorType = jSONObjectOptJSONObject.optString("ErrorType");
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("Phonemes");
        if (jSONArrayOptJSONArray != null) {
            this.phonemes = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                this.phonemes.add(new PhonemeLevelTimingResult(jSONArrayOptJSONArray.optJSONObject(i)));
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("Syllables");
        if (jSONArrayOptJSONArray2 != null) {
            this.syllables = new ArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                this.syllables.add(new SyllableLevelTimingResult(jSONArrayOptJSONArray2.optJSONObject(i2)));
            }
        }
    }

    public double getAccuracyScore() {
        return this.accuracyScore;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public List<PhonemeLevelTimingResult> getPhonemes() {
        return this.phonemes;
    }

    public List<SyllableLevelTimingResult> getSyllables() {
        return this.syllables;
    }

    public String getWord() {
        return this.word;
    }
}
