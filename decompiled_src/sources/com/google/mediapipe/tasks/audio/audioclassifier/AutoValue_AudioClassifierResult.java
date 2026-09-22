package com.google.mediapipe.tasks.audio.audioclassifier;

import com.google.mediapipe.tasks.components.containers.ClassificationResult;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_AudioClassifierResult extends AudioClassifierResult {
    private final List<ClassificationResult> classificationResults;
    private final long timestampMs;

    AutoValue_AudioClassifierResult(List<ClassificationResult> classificationResults, long timestampMs) {
        if (classificationResults == null) {
            throw new NullPointerException("Null classificationResults");
        }
        this.classificationResults = classificationResults;
        this.timestampMs = timestampMs;
    }

    @Override // com.google.mediapipe.tasks.audio.audioclassifier.AudioClassifierResult
    public List<ClassificationResult> classificationResults() {
        return this.classificationResults;
    }

    @Override // com.google.mediapipe.tasks.audio.audioclassifier.AudioClassifierResult, com.google.mediapipe.tasks.core.TaskResult
    public long timestampMs() {
        return this.timestampMs;
    }

    public String toString() {
        return "AudioClassifierResult{classificationResults=" + this.classificationResults + ", timestampMs=" + this.timestampMs + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof AudioClassifierResult) {
            AudioClassifierResult audioClassifierResult = (AudioClassifierResult) o;
            if (this.classificationResults.equals(audioClassifierResult.classificationResults()) && this.timestampMs == audioClassifierResult.timestampMs()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.classificationResults.hashCode() ^ 1000003) * 1000003;
        long j = this.timestampMs;
        return ((int) (j ^ (j >>> 32))) ^ iHashCode;
    }
}
