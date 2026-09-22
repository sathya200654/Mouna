package com.microsoft.cognitiveservices.speech;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class TimingResult {
    private long duration;
    private long offset;

    TimingResult(JSONObject jSONObject) {
        this.offset = jSONObject.optLong("Offset");
        this.duration = jSONObject.optLong("Duration");
    }

    public long getDuration() {
        return this.duration;
    }

    public long getOffset() {
        return this.offset;
    }
}
