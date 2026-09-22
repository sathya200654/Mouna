package com.microsoft.cognitiveservices.speech;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class NBestPhoneme {
    private String phoneme;
    private double score;

    NBestPhoneme(JSONObject jSONObject) {
        this.phoneme = jSONObject.optString("Phoneme");
        this.score = jSONObject.optDouble("Score");
    }

    public String getPhoneme() {
        return this.phoneme;
    }

    public double getScore() {
        return this.score;
    }
}
