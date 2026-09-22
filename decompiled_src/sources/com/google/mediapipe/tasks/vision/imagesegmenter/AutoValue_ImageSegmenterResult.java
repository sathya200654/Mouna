package com.google.mediapipe.tasks.vision.imagesegmenter;

import com.google.mediapipe.framework.image.MPImage;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_ImageSegmenterResult extends ImageSegmenterResult {
    private final Optional<MPImage> categoryMask;
    private final Optional<List<MPImage>> confidenceMasks;
    private final List<Float> qualityScores;
    private final long timestampMs;

    AutoValue_ImageSegmenterResult(Optional<List<MPImage>> confidenceMasks, Optional<MPImage> categoryMask, List<Float> qualityScores, long timestampMs) {
        if (confidenceMasks == null) {
            throw new NullPointerException("Null confidenceMasks");
        }
        this.confidenceMasks = confidenceMasks;
        if (categoryMask == null) {
            throw new NullPointerException("Null categoryMask");
        }
        this.categoryMask = categoryMask;
        if (qualityScores == null) {
            throw new NullPointerException("Null qualityScores");
        }
        this.qualityScores = qualityScores;
        this.timestampMs = timestampMs;
    }

    @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenterResult
    public Optional<List<MPImage>> confidenceMasks() {
        return this.confidenceMasks;
    }

    @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenterResult
    public Optional<MPImage> categoryMask() {
        return this.categoryMask;
    }

    @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenterResult
    public List<Float> qualityScores() {
        return this.qualityScores;
    }

    @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenterResult, com.google.mediapipe.tasks.core.TaskResult
    public long timestampMs() {
        return this.timestampMs;
    }

    public String toString() {
        return "ImageSegmenterResult{confidenceMasks=" + this.confidenceMasks + ", categoryMask=" + this.categoryMask + ", qualityScores=" + this.qualityScores + ", timestampMs=" + this.timestampMs + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ImageSegmenterResult) {
            ImageSegmenterResult imageSegmenterResult = (ImageSegmenterResult) o;
            if (this.confidenceMasks.equals(imageSegmenterResult.confidenceMasks()) && this.categoryMask.equals(imageSegmenterResult.categoryMask()) && this.qualityScores.equals(imageSegmenterResult.qualityScores()) && this.timestampMs == imageSegmenterResult.timestampMs()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.confidenceMasks.hashCode() ^ 1000003) * 1000003) ^ this.categoryMask.hashCode()) * 1000003) ^ this.qualityScores.hashCode()) * 1000003;
        long j = this.timestampMs;
        return ((int) (j ^ (j >>> 32))) ^ iHashCode;
    }
}
