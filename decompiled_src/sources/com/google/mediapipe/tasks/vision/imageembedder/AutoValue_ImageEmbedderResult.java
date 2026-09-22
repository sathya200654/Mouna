package com.google.mediapipe.tasks.vision.imageembedder;

import com.google.mediapipe.tasks.components.containers.EmbeddingResult;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_ImageEmbedderResult extends ImageEmbedderResult {
    private final EmbeddingResult embeddingResult;
    private final long timestampMs;

    AutoValue_ImageEmbedderResult(EmbeddingResult embeddingResult, long timestampMs) {
        if (embeddingResult == null) {
            throw new NullPointerException("Null embeddingResult");
        }
        this.embeddingResult = embeddingResult;
        this.timestampMs = timestampMs;
    }

    @Override // com.google.mediapipe.tasks.vision.imageembedder.ImageEmbedderResult
    public EmbeddingResult embeddingResult() {
        return this.embeddingResult;
    }

    @Override // com.google.mediapipe.tasks.vision.imageembedder.ImageEmbedderResult, com.google.mediapipe.tasks.core.TaskResult
    public long timestampMs() {
        return this.timestampMs;
    }

    public String toString() {
        return "ImageEmbedderResult{embeddingResult=" + this.embeddingResult + ", timestampMs=" + this.timestampMs + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ImageEmbedderResult) {
            ImageEmbedderResult imageEmbedderResult = (ImageEmbedderResult) o;
            if (this.embeddingResult.equals(imageEmbedderResult.embeddingResult()) && this.timestampMs == imageEmbedderResult.timestampMs()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.embeddingResult.hashCode() ^ 1000003) * 1000003;
        long j = this.timestampMs;
        return ((int) (j ^ (j >>> 32))) ^ iHashCode;
    }
}
