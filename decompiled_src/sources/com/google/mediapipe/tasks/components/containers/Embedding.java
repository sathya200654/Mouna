package com.google.mediapipe.tasks.components.containers;

import com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class Embedding {
    public abstract float[] floatEmbedding();

    public abstract int headIndex();

    public abstract Optional<String> headName();

    public abstract byte[] quantizedEmbedding();

    public static Embedding create(float[] floatEmbedding, byte[] quantizedEmbedding, int headIndex, Optional<String> headName) {
        return new AutoValue_Embedding(floatEmbedding, quantizedEmbedding, headIndex, headName);
    }

    public static Embedding createFromProto(EmbeddingsProto.Embedding proto) {
        float[] fArr;
        byte[] byteArray;
        if (proto.hasFloatEmbedding()) {
            int valuesCount = proto.getFloatEmbedding().getValuesCount();
            fArr = new float[valuesCount];
            for (int i = 0; i < valuesCount; i++) {
                fArr[i] = proto.getFloatEmbedding().getValues(i);
            }
        } else {
            fArr = new float[0];
        }
        if (proto.hasQuantizedEmbedding()) {
            byteArray = proto.getQuantizedEmbedding().getValues().toByteArray();
        } else {
            byteArray = new byte[0];
        }
        return create(fArr, byteArray, proto.getHeadIndex(), proto.hasHeadName() ? Optional.of(proto.getHeadName()) : Optional.empty());
    }
}
