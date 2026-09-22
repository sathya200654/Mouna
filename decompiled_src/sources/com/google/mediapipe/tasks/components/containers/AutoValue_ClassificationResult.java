package com.google.mediapipe.tasks.components.containers;

import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_ClassificationResult extends ClassificationResult {
    private final List<Classifications> classifications;
    private final Optional<Long> timestampMs;

    AutoValue_ClassificationResult(List<Classifications> classifications, Optional<Long> timestampMs) {
        if (classifications == null) {
            throw new NullPointerException("Null classifications");
        }
        this.classifications = classifications;
        if (timestampMs == null) {
            throw new NullPointerException("Null timestampMs");
        }
        this.timestampMs = timestampMs;
    }

    @Override // com.google.mediapipe.tasks.components.containers.ClassificationResult
    public List<Classifications> classifications() {
        return this.classifications;
    }

    @Override // com.google.mediapipe.tasks.components.containers.ClassificationResult
    public Optional<Long> timestampMs() {
        return this.timestampMs;
    }

    public String toString() {
        return "ClassificationResult{classifications=" + this.classifications + ", timestampMs=" + this.timestampMs + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ClassificationResult) {
            ClassificationResult classificationResult = (ClassificationResult) o;
            if (this.classifications.equals(classificationResult.classifications()) && this.timestampMs.equals(classificationResult.timestampMs())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.timestampMs.hashCode() ^ ((this.classifications.hashCode() ^ 1000003) * 1000003);
    }
}
