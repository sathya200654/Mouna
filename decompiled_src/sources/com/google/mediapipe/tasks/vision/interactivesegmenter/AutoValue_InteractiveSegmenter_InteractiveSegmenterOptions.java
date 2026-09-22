package com.google.mediapipe.tasks.vision.interactivesegmenter;

import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.tasks.core.BaseOptions;
import com.google.mediapipe.tasks.core.ErrorListener;
import com.google.mediapipe.tasks.core.OutputHandler;
import com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenterResult;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_InteractiveSegmenter_InteractiveSegmenterOptions extends InteractiveSegmenter.InteractiveSegmenterOptions {
    private final BaseOptions baseOptions;
    private final Optional<ErrorListener> errorListener;
    private final boolean outputCategoryMask;
    private final boolean outputConfidenceMasks;
    private final Optional<OutputHandler.ResultListener<ImageSegmenterResult, MPImage>> resultListener;

    private AutoValue_InteractiveSegmenter_InteractiveSegmenterOptions(BaseOptions baseOptions, boolean outputConfidenceMasks, boolean outputCategoryMask, Optional<OutputHandler.ResultListener<ImageSegmenterResult, MPImage>> resultListener, Optional<ErrorListener> errorListener) {
        this.baseOptions = baseOptions;
        this.outputConfidenceMasks = outputConfidenceMasks;
        this.outputCategoryMask = outputCategoryMask;
        this.resultListener = resultListener;
        this.errorListener = errorListener;
    }

    @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions
    BaseOptions baseOptions() {
        return this.baseOptions;
    }

    @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions
    boolean outputConfidenceMasks() {
        return this.outputConfidenceMasks;
    }

    @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions
    boolean outputCategoryMask() {
        return this.outputCategoryMask;
    }

    @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions
    Optional<OutputHandler.ResultListener<ImageSegmenterResult, MPImage>> resultListener() {
        return this.resultListener;
    }

    @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions
    Optional<ErrorListener> errorListener() {
        return this.errorListener;
    }

    public String toString() {
        return "InteractiveSegmenterOptions{baseOptions=" + this.baseOptions + ", outputConfidenceMasks=" + this.outputConfidenceMasks + ", outputCategoryMask=" + this.outputCategoryMask + ", resultListener=" + this.resultListener + ", errorListener=" + this.errorListener + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof InteractiveSegmenter.InteractiveSegmenterOptions) {
            InteractiveSegmenter.InteractiveSegmenterOptions interactiveSegmenterOptions = (InteractiveSegmenter.InteractiveSegmenterOptions) o;
            if (this.baseOptions.equals(interactiveSegmenterOptions.baseOptions()) && this.outputConfidenceMasks == interactiveSegmenterOptions.outputConfidenceMasks() && this.outputCategoryMask == interactiveSegmenterOptions.outputCategoryMask() && this.resultListener.equals(interactiveSegmenterOptions.resultListener()) && this.errorListener.equals(interactiveSegmenterOptions.errorListener())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.errorListener.hashCode() ^ ((((((((this.baseOptions.hashCode() ^ 1000003) * 1000003) ^ (this.outputConfidenceMasks ? 1231 : 1237)) * 1000003) ^ (this.outputCategoryMask ? 1231 : 1237)) * 1000003) ^ this.resultListener.hashCode()) * 1000003);
    }

    static final class Builder extends InteractiveSegmenter.InteractiveSegmenterOptions.Builder {
        private BaseOptions baseOptions;
        private Boolean outputCategoryMask;
        private Boolean outputConfidenceMasks;
        private Optional<OutputHandler.ResultListener<ImageSegmenterResult, MPImage>> resultListener = Optional.empty();
        private Optional<ErrorListener> errorListener = Optional.empty();

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions.Builder
        public InteractiveSegmenter.InteractiveSegmenterOptions.Builder setBaseOptions(BaseOptions baseOptions) {
            if (baseOptions == null) {
                throw new NullPointerException("Null baseOptions");
            }
            this.baseOptions = baseOptions;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions.Builder
        public InteractiveSegmenter.InteractiveSegmenterOptions.Builder setOutputConfidenceMasks(boolean outputConfidenceMasks) {
            this.outputConfidenceMasks = Boolean.valueOf(outputConfidenceMasks);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions.Builder
        public InteractiveSegmenter.InteractiveSegmenterOptions.Builder setOutputCategoryMask(boolean outputCategoryMask) {
            this.outputCategoryMask = Boolean.valueOf(outputCategoryMask);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions.Builder
        public InteractiveSegmenter.InteractiveSegmenterOptions.Builder setResultListener(OutputHandler.ResultListener<ImageSegmenterResult, MPImage> resultListener) {
            this.resultListener = Optional.of(resultListener);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions.Builder
        public InteractiveSegmenter.InteractiveSegmenterOptions.Builder setErrorListener(ErrorListener errorListener) {
            this.errorListener = Optional.of(errorListener);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.InteractiveSegmenterOptions.Builder
        InteractiveSegmenter.InteractiveSegmenterOptions autoBuild() {
            String str;
            if (this.baseOptions != null) {
                str = "";
            } else {
                str = " baseOptions";
            }
            if (this.outputConfidenceMasks == null) {
                str = str + " outputConfidenceMasks";
            }
            if (this.outputCategoryMask == null) {
                str = str + " outputCategoryMask";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_InteractiveSegmenter_InteractiveSegmenterOptions(this.baseOptions, this.outputConfidenceMasks.booleanValue(), this.outputCategoryMask.booleanValue(), this.resultListener, this.errorListener);
        }
    }
}
