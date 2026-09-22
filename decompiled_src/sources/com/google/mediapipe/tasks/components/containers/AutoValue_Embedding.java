package com.google.mediapipe.tasks.components.containers;

import java.util.Arrays;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_Embedding extends Embedding {
    private final float[] floatEmbedding;
    private final int headIndex;
    private final Optional<String> headName;
    private final byte[] quantizedEmbedding;

    AutoValue_Embedding(float[] floatEmbedding, byte[] quantizedEmbedding, int headIndex, Optional<String> headName) {
        if (floatEmbedding == null) {
            throw new NullPointerException("Null floatEmbedding");
        }
        this.floatEmbedding = floatEmbedding;
        if (quantizedEmbedding == null) {
            throw new NullPointerException("Null quantizedEmbedding");
        }
        this.quantizedEmbedding = quantizedEmbedding;
        this.headIndex = headIndex;
        if (headName == null) {
            throw new NullPointerException("Null headName");
        }
        this.headName = headName;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Embedding
    public float[] floatEmbedding() {
        return this.floatEmbedding;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Embedding
    public byte[] quantizedEmbedding() {
        return this.quantizedEmbedding;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Embedding
    public int headIndex() {
        return this.headIndex;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Embedding
    public Optional<String> headName() {
        return this.headName;
    }

    public String toString() {
        return "Embedding{floatEmbedding=" + Arrays.toString(this.floatEmbedding) + ", quantizedEmbedding=" + Arrays.toString(this.quantizedEmbedding) + ", headIndex=" + this.headIndex + ", headName=" + this.headName + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Embedding) {
            Embedding embedding = (Embedding) o;
            boolean z = embedding instanceof AutoValue_Embedding;
            if (Arrays.equals(this.floatEmbedding, z ? ((AutoValue_Embedding) embedding).floatEmbedding : embedding.floatEmbedding())) {
                if (Arrays.equals(this.quantizedEmbedding, z ? ((AutoValue_Embedding) embedding).quantizedEmbedding : embedding.quantizedEmbedding()) && this.headIndex == embedding.headIndex() && this.headName.equals(embedding.headName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return this.headName.hashCode() ^ ((((((Arrays.hashCode(this.floatEmbedding) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.quantizedEmbedding)) * 1000003) ^ this.headIndex) * 1000003);
    }
}
