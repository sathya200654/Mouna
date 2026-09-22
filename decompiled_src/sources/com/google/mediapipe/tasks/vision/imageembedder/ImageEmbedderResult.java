package com.google.mediapipe.tasks.vision.imageembedder;

import com.google.mediapipe.tasks.components.containers.EmbeddingResult;
import com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto;
import com.google.mediapipe.tasks.core.TaskResult;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ImageEmbedderResult implements TaskResult {
    public abstract EmbeddingResult embeddingResult();

    @Override // com.google.mediapipe.tasks.core.TaskResult
    public abstract long timestampMs();

    static ImageEmbedderResult create(EmbeddingResult embeddingResult, long timestampMs) {
        return new AutoValue_ImageEmbedderResult(embeddingResult, timestampMs);
    }

    static ImageEmbedderResult createFromProto(EmbeddingsProto.EmbeddingResult proto, long timestampMs) {
        return create(EmbeddingResult.createFromProto(proto), timestampMs);
    }
}
