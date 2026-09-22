package com.google.mediapipe.tasks.vision.core;

import android.graphics.RectF;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ImageProcessingOptions {
    public abstract Optional<RectF> regionOfInterest();

    public abstract int rotationDegrees();

    public static abstract class Builder {
        abstract ImageProcessingOptions autoBuild();

        public abstract Builder setRegionOfInterest(RectF value);

        public abstract Builder setRotationDegrees(int value);

        public final ImageProcessingOptions build() {
            ImageProcessingOptions imageProcessingOptionsAutoBuild = autoBuild();
            if (imageProcessingOptionsAutoBuild.regionOfInterest().isPresent()) {
                RectF rectF = imageProcessingOptionsAutoBuild.regionOfInterest().get();
                if (rectF.left >= rectF.right || rectF.top >= rectF.bottom) {
                    throw new IllegalArgumentException(String.format("Expected left < right and top < bottom, found: %s.", rectF.toShortString()));
                }
                if (rectF.left < 0.0f || rectF.right > 1.0f || rectF.top < 0.0f || rectF.bottom > 1.0f) {
                    throw new IllegalArgumentException(String.format("Expected RectF values in [0,1], found: %s.", rectF.toShortString()));
                }
            }
            if (imageProcessingOptionsAutoBuild.rotationDegrees() % 90 == 0) {
                return imageProcessingOptionsAutoBuild;
            }
            throw new IllegalArgumentException(String.format("Expected rotation to be a multiple of 90°, found: %d.", Integer.valueOf(imageProcessingOptionsAutoBuild.rotationDegrees())));
        }
    }

    public static Builder builder() {
        return new AutoValue_ImageProcessingOptions.Builder().setRotationDegrees(0);
    }
}
