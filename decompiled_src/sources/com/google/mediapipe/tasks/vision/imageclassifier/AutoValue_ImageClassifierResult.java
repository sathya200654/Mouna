package com.google.mediapipe.tasks.vision.imageclassifier;

import com.google.mediapipe.tasks.components.containers.ClassificationResult;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_ImageClassifierResult extends ImageClassifierResult {
    private final ClassificationResult classificationResult;
    private final long timestampMs;

    AutoValue_ImageClassifierResult(ClassificationResult classificationResult, long timestampMs) {
        if (classificationResult == null) {
            throw new NullPointerException("Null classificationResult");
        }
        this.classificationResult = classificationResult;
        this.timestampMs = timestampMs;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifierResult
    public ClassificationResult classificationResult() {
        return this.classificationResult;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifierResult, com.google.mediapipe.tasks.core.TaskResult
    public long timestampMs() {
        return this.timestampMs;
    }

    public String toString() {
        return "ImageClassifierResult{classificationResult=" + this.classificationResult + ", timestampMs=" + this.timestampMs + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ImageClassifierResult) {
            ImageClassifierResult imageClassifierResult = (ImageClassifierResult) o;
            if (this.classificationResult.equals(imageClassifierResult.classificationResult()) && this.timestampMs == imageClassifierResult.timestampMs()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.classificationResult.hashCode() ^ 1000003) * 1000003;
        long j = this.timestampMs;
        return ((int) (j ^ (j >>> 32))) ^ iHashCode;
    }
}
