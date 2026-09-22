package com.google.mediapipe.tasks.vision.core;

import android.graphics.RectF;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_ImageProcessingOptions extends ImageProcessingOptions {
    private final Optional<RectF> regionOfInterest;
    private final int rotationDegrees;

    private AutoValue_ImageProcessingOptions(Optional<RectF> regionOfInterest, int rotationDegrees) {
        this.regionOfInterest = regionOfInterest;
        this.rotationDegrees = rotationDegrees;
    }

    @Override // com.google.mediapipe.tasks.vision.core.ImageProcessingOptions
    public Optional<RectF> regionOfInterest() {
        return this.regionOfInterest;
    }

    @Override // com.google.mediapipe.tasks.vision.core.ImageProcessingOptions
    public int rotationDegrees() {
        return this.rotationDegrees;
    }

    public String toString() {
        return "ImageProcessingOptions{regionOfInterest=" + this.regionOfInterest + ", rotationDegrees=" + this.rotationDegrees + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ImageProcessingOptions) {
            ImageProcessingOptions imageProcessingOptions = (ImageProcessingOptions) o;
            if (this.regionOfInterest.equals(imageProcessingOptions.regionOfInterest()) && this.rotationDegrees == imageProcessingOptions.rotationDegrees()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.rotationDegrees ^ ((this.regionOfInterest.hashCode() ^ 1000003) * 1000003);
    }

    static final class Builder extends ImageProcessingOptions.Builder {
        private Optional<RectF> regionOfInterest = Optional.empty();
        private Integer rotationDegrees;

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.vision.core.ImageProcessingOptions.Builder
        public ImageProcessingOptions.Builder setRegionOfInterest(RectF regionOfInterest) {
            this.regionOfInterest = Optional.of(regionOfInterest);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.core.ImageProcessingOptions.Builder
        public ImageProcessingOptions.Builder setRotationDegrees(int rotationDegrees) {
            this.rotationDegrees = Integer.valueOf(rotationDegrees);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.core.ImageProcessingOptions.Builder
        ImageProcessingOptions autoBuild() {
            String str;
            if (this.rotationDegrees != null) {
                str = "";
            } else {
                str = " rotationDegrees";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_ImageProcessingOptions(this.regionOfInterest, this.rotationDegrees.intValue());
        }
    }
}
