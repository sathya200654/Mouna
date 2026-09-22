package com.google.mediapipe.tasks.components.containers;

import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_EmbeddingResult extends EmbeddingResult {
    private final List<Embedding> embeddings;
    private final Optional<Long> timestampMs;

    AutoValue_EmbeddingResult(List<Embedding> embeddings, Optional<Long> timestampMs) {
        if (embeddings == null) {
            throw new NullPointerException("Null embeddings");
        }
        this.embeddings = embeddings;
        if (timestampMs == null) {
            throw new NullPointerException("Null timestampMs");
        }
        this.timestampMs = timestampMs;
    }

    @Override // com.google.mediapipe.tasks.components.containers.EmbeddingResult
    public List<Embedding> embeddings() {
        return this.embeddings;
    }

    @Override // com.google.mediapipe.tasks.components.containers.EmbeddingResult
    public Optional<Long> timestampMs() {
        return this.timestampMs;
    }

    public String toString() {
        return "EmbeddingResult{embeddings=" + this.embeddings + ", timestampMs=" + this.timestampMs + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof EmbeddingResult) {
            EmbeddingResult embeddingResult = (EmbeddingResult) o;
            if (this.embeddings.equals(embeddingResult.embeddings()) && this.timestampMs.equals(embeddingResult.timestampMs())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.timestampMs.hashCode() ^ ((this.embeddings.hashCode() ^ 1000003) * 1000003);
    }
}
