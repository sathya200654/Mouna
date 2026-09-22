package com.google.mediapipe.tasks.vision.imagesegmenter;

import com.google.mediapipe.tasks.vision.core.ImageProcessingOptions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_ImageSegmenter_SegmentationOptions extends ImageSegmenter.SegmentationOptions {
    private final ImageProcessingOptions imageProcessingOptions;
    private final int outputHeight;
    private final int outputWidth;

    private AutoValue_ImageSegmenter_SegmentationOptions(int outputWidth, int outputHeight, ImageProcessingOptions imageProcessingOptions) {
        this.outputWidth = outputWidth;
        this.outputHeight = outputHeight;
        this.imageProcessingOptions = imageProcessingOptions;
    }

    @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter.SegmentationOptions
    int outputWidth() {
        return this.outputWidth;
    }

    @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter.SegmentationOptions
    int outputHeight() {
        return this.outputHeight;
    }

    @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter.SegmentationOptions
    ImageProcessingOptions imageProcessingOptions() {
        return this.imageProcessingOptions;
    }

    public String toString() {
        return "SegmentationOptions{outputWidth=" + this.outputWidth + ", outputHeight=" + this.outputHeight + ", imageProcessingOptions=" + this.imageProcessingOptions + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ImageSegmenter.SegmentationOptions) {
            ImageSegmenter.SegmentationOptions segmentationOptions = (ImageSegmenter.SegmentationOptions) o;
            if (this.outputWidth == segmentationOptions.outputWidth() && this.outputHeight == segmentationOptions.outputHeight() && this.imageProcessingOptions.equals(segmentationOptions.imageProcessingOptions())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.imageProcessingOptions.hashCode() ^ ((((this.outputWidth ^ 1000003) * 1000003) ^ this.outputHeight) * 1000003);
    }

    static final class Builder extends ImageSegmenter.SegmentationOptions.Builder {
        private ImageProcessingOptions imageProcessingOptions;
        private Integer outputHeight;
        private Integer outputWidth;

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter.SegmentationOptions.Builder
        public ImageSegmenter.SegmentationOptions.Builder setOutputWidth(int outputWidth) {
            this.outputWidth = Integer.valueOf(outputWidth);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter.SegmentationOptions.Builder
        public ImageSegmenter.SegmentationOptions.Builder setOutputHeight(int outputHeight) {
            this.outputHeight = Integer.valueOf(outputHeight);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter.SegmentationOptions.Builder
        public ImageSegmenter.SegmentationOptions.Builder setImageProcessingOptions(ImageProcessingOptions imageProcessingOptions) {
            if (imageProcessingOptions == null) {
                throw new NullPointerException("Null imageProcessingOptions");
            }
            this.imageProcessingOptions = imageProcessingOptions;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter.SegmentationOptions.Builder
        ImageSegmenter.SegmentationOptions autoBuild() {
            String str;
            if (this.outputWidth != null) {
                str = "";
            } else {
                str = " outputWidth";
            }
            if (this.outputHeight == null) {
                str = str + " outputHeight";
            }
            if (this.imageProcessingOptions == null) {
                str = str + " imageProcessingOptions";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_ImageSegmenter_SegmentationOptions(this.outputWidth.intValue(), this.outputHeight.intValue(), this.imageProcessingOptions);
        }
    }
}
