package com.google.mediapipe.tasks.vision.handlandmarker;

import com.google.mediapipe.tasks.components.containers.Category;
import com.google.mediapipe.tasks.components.containers.Landmark;
import com.google.mediapipe.tasks.components.containers.NormalizedLandmark;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_HandLandmarkerResult extends HandLandmarkerResult {
    private final List<List<Category>> handedness;
    private final List<List<NormalizedLandmark>> landmarks;
    private final long timestampMs;
    private final List<List<Landmark>> worldLandmarks;

    AutoValue_HandLandmarkerResult(long timestampMs, List<List<NormalizedLandmark>> landmarks, List<List<Landmark>> worldLandmarks, List<List<Category>> handedness) {
        this.timestampMs = timestampMs;
        if (landmarks == null) {
            throw new NullPointerException("Null landmarks");
        }
        this.landmarks = landmarks;
        if (worldLandmarks == null) {
            throw new NullPointerException("Null worldLandmarks");
        }
        this.worldLandmarks = worldLandmarks;
        if (handedness == null) {
            throw new NullPointerException("Null handedness");
        }
        this.handedness = handedness;
    }

    @Override // com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarkerResult, com.google.mediapipe.tasks.core.TaskResult
    public long timestampMs() {
        return this.timestampMs;
    }

    @Override // com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarkerResult
    public List<List<NormalizedLandmark>> landmarks() {
        return this.landmarks;
    }

    @Override // com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarkerResult
    public List<List<Landmark>> worldLandmarks() {
        return this.worldLandmarks;
    }

    @Override // com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarkerResult
    public List<List<Category>> handedness() {
        return this.handedness;
    }

    public String toString() {
        return "HandLandmarkerResult{timestampMs=" + this.timestampMs + ", landmarks=" + this.landmarks + ", worldLandmarks=" + this.worldLandmarks + ", handedness=" + this.handedness + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof HandLandmarkerResult) {
            HandLandmarkerResult handLandmarkerResult = (HandLandmarkerResult) o;
            if (this.timestampMs == handLandmarkerResult.timestampMs() && this.landmarks.equals(handLandmarkerResult.landmarks()) && this.worldLandmarks.equals(handLandmarkerResult.worldLandmarks()) && this.handedness.equals(handLandmarkerResult.handedness())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.timestampMs;
        return this.handedness.hashCode() ^ ((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.landmarks.hashCode()) * 1000003) ^ this.worldLandmarks.hashCode()) * 1000003);
    }
}
