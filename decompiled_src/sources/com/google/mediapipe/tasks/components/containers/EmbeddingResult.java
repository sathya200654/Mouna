package com.google.mediapipe.tasks.components.containers;

import com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class EmbeddingResult {
    public abstract List<Embedding> embeddings();

    public abstract Optional<Long> timestampMs();

    public static EmbeddingResult create(List<Embedding> embeddings, Optional<Long> timestampMs) {
        return new AutoValue_EmbeddingResult(Collections.unmodifiableList(embeddings), timestampMs);
    }

    public static EmbeddingResult createFromProto(EmbeddingsProto.EmbeddingResult proto) {
        ArrayList arrayList = new ArrayList();
        Iterator<EmbeddingsProto.Embedding> it = proto.getEmbeddingsList().iterator();
        while (it.hasNext()) {
            arrayList.add(Embedding.createFromProto(it.next()));
        }
        return create(arrayList, proto.hasTimestampMs() ? Optional.of(Long.valueOf(proto.getTimestampMs())) : Optional.empty());
    }
}
