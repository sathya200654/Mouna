package com.google.mediapipe.tasks.vision.gesturerecognizer;

import com.google.mediapipe.tasks.components.containers.Category;
import com.google.mediapipe.tasks.components.containers.Landmark;
import com.google.mediapipe.tasks.components.containers.NormalizedLandmark;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_GestureRecognizerResult extends GestureRecognizerResult {
    private final List<List<Category>> gestures;
    private final List<List<Category>> handedness;
    private final List<List<NormalizedLandmark>> landmarks;
    private final long timestampMs;
    private final List<List<Landmark>> worldLandmarks;

    AutoValue_GestureRecognizerResult(long timestampMs, List<List<NormalizedLandmark>> landmarks, List<List<Landmark>> worldLandmarks, List<List<Category>> handedness, List<List<Category>> gestures) {
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
        if (gestures == null) {
            throw new NullPointerException("Null gestures");
        }
        this.gestures = gestures;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizerResult, com.google.mediapipe.tasks.core.TaskResult
    public long timestampMs() {
        return this.timestampMs;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizerResult
    public List<List<NormalizedLandmark>> landmarks() {
        return this.landmarks;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizerResult
    public List<List<Landmark>> worldLandmarks() {
        return this.worldLandmarks;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizerResult
    public List<List<Category>> handedness() {
        return this.handedness;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizerResult
    public List<List<Category>> gestures() {
        return this.gestures;
    }

    public String toString() {
        return "GestureRecognizerResult{timestampMs=" + this.timestampMs + ", landmarks=" + this.landmarks + ", worldLandmarks=" + this.worldLandmarks + ", handedness=" + this.handedness + ", gestures=" + this.gestures + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof GestureRecognizerResult) {
            GestureRecognizerResult gestureRecognizerResult = (GestureRecognizerResult) o;
            if (this.timestampMs == gestureRecognizerResult.timestampMs() && this.landmarks.equals(gestureRecognizerResult.landmarks()) && this.worldLandmarks.equals(gestureRecognizerResult.worldLandmarks()) && this.handedness.equals(gestureRecognizerResult.handedness()) && this.gestures.equals(gestureRecognizerResult.gestures())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.timestampMs;
        return this.gestures.hashCode() ^ ((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.landmarks.hashCode()) * 1000003) ^ this.worldLandmarks.hashCode()) * 1000003) ^ this.handedness.hashCode()) * 1000003);
    }
}
