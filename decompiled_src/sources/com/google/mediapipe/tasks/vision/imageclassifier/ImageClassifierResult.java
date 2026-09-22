package com.google.mediapipe.tasks.vision.imageclassifier;

import com.google.mediapipe.tasks.components.containers.ClassificationResult;
import com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto;
import com.google.mediapipe.tasks.core.TaskResult;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ImageClassifierResult implements TaskResult {
    public abstract ClassificationResult classificationResult();

    @Override // com.google.mediapipe.tasks.core.TaskResult
    public abstract long timestampMs();

    static ImageClassifierResult create(ClassificationResult classificationResult, long timestampMs) {
        return new AutoValue_ImageClassifierResult(classificationResult, timestampMs);
    }

    static ImageClassifierResult createFromProto(ClassificationsProto.ClassificationResult proto, long timestampMs) {
        return create(ClassificationResult.createFromProto(proto), timestampMs);
    }
}
