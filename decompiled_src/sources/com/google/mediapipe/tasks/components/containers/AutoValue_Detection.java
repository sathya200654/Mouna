package com.google.mediapipe.tasks.components.containers;

import android.graphics.RectF;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_Detection extends Detection {
    private final RectF boundingBox;
    private final List<Category> categories;
    private final Optional<List<NormalizedKeypoint>> keypoints;

    AutoValue_Detection(List<Category> categories, RectF boundingBox, Optional<List<NormalizedKeypoint>> keypoints) {
        if (categories == null) {
            throw new NullPointerException("Null categories");
        }
        this.categories = categories;
        if (boundingBox == null) {
            throw new NullPointerException("Null boundingBox");
        }
        this.boundingBox = boundingBox;
        if (keypoints == null) {
            throw new NullPointerException("Null keypoints");
        }
        this.keypoints = keypoints;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Detection
    public List<Category> categories() {
        return this.categories;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Detection
    public RectF boundingBox() {
        return this.boundingBox;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Detection
    public Optional<List<NormalizedKeypoint>> keypoints() {
        return this.keypoints;
    }

    public String toString() {
        return "Detection{categories=" + this.categories + ", boundingBox=" + this.boundingBox + ", keypoints=" + this.keypoints + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Detection) {
            Detection detection = (Detection) o;
            if (this.categories.equals(detection.categories()) && this.boundingBox.equals(detection.boundingBox()) && this.keypoints.equals(detection.keypoints())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.keypoints.hashCode() ^ ((((this.categories.hashCode() ^ 1000003) * 1000003) ^ this.boundingBox.hashCode()) * 1000003);
    }
}
