package com.google.mediapipe.tasks.vision.facedetector;

import com.google.mediapipe.tasks.components.containers.Detection;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_FaceDetectorResult extends FaceDetectorResult {
    private final List<Detection> detections;
    private final long timestampMs;

    AutoValue_FaceDetectorResult(long timestampMs, List<Detection> detections) {
        this.timestampMs = timestampMs;
        if (detections == null) {
            throw new NullPointerException("Null detections");
        }
        this.detections = detections;
    }

    @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetectorResult, com.google.mediapipe.tasks.core.TaskResult
    public long timestampMs() {
        return this.timestampMs;
    }

    @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetectorResult
    public List<Detection> detections() {
        return this.detections;
    }

    public String toString() {
        return "FaceDetectorResult{timestampMs=" + this.timestampMs + ", detections=" + this.detections + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof FaceDetectorResult) {
            FaceDetectorResult faceDetectorResult = (FaceDetectorResult) o;
            if (this.timestampMs == faceDetectorResult.timestampMs() && this.detections.equals(faceDetectorResult.detections())) {
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
