package com.google.mediapipe.tasks.vision.objectdetector;

import com.google.mediapipe.tasks.components.containers.Detection;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_ObjectDetectorResult extends ObjectDetectorResult {
    private final List<Detection> detections;
    private final long timestampMs;

    AutoValue_ObjectDetectorResult(long timestampMs, List<Detection> detections) {
        this.timestampMs = timestampMs;
        if (detections == null) {
            throw new NullPointerException("Null detections");
        }
        this.detections = detections;
    }

    @Override // com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectionResult, com.google.mediapipe.tasks.core.TaskResult
    public long timestampMs() {
        return this.timestampMs;
    }

    @Override // com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectionResult
    public List<Detection> detections() {
        return this.detections;
    }

    public String toString() {
        return "ObjectDetectorResult{timestampMs=" + this.timestampMs + ", detections=" + this.detections + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ObjectDetectorResult) {
            ObjectDetectorResult objectDetectorResult = (ObjectDetectorResult) o;
            if (this.timestampMs == objectDetectorResult.timestampMs() && this.detections.equals(objectDetectorResult.detections())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.timestampMs;
        return this.detections.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }
}
