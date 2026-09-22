package com.google.mediapipe.tasks.vision.objectdetector;

import com.google.mediapipe.formats.proto.DetectionProto;
import com.google.mediapipe.tasks.components.containers.Detection;
import com.google.mediapipe.tasks.core.TaskResult;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Deprecated
public abstract class ObjectDetectionResult implements TaskResult {
    public abstract List<Detection> detections();

    @Override // com.google.mediapipe.tasks.core.TaskResult
    public abstract long timestampMs();

    @Deprecated
    public static ObjectDetectionResult create(List<DetectionProto.Detection> detectionList, long timestampMs) {
        return ObjectDetectorResult.create(detectionList, timestampMs);
    }
}
