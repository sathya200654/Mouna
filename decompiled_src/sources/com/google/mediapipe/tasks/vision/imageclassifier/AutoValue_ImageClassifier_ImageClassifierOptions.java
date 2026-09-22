package com.google.mediapipe.tasks.vision.imageclassifier;

import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.tasks.core.BaseOptions;
import com.google.mediapipe.tasks.core.ErrorListener;
import com.google.mediapipe.tasks.core.OutputHandler;
import com.google.mediapipe.tasks.vision.core.RunningMode;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_ImageClassifier_ImageClassifierOptions extends ImageClassifier.ImageClassifierOptions {
    private final BaseOptions baseOptions;
    private final List<String> categoryAllowlist;
    private final List<String> categoryDenylist;
    private final Optional<String> displayNamesLocale;
    private final Optional<ErrorListener> errorListener;
    private final Optional<Integer> maxResults;
    private final Optional<OutputHandler.ResultListener<ImageClassifierResult, MPImage>> resultListener;
    private final RunningMode runningMode;
    private final Optional<Float> scoreThreshold;

    private AutoValue_ImageClassifier_ImageClassifierOptions(BaseOptions baseOptions, RunningMode runningMode, Optional<String> displayNamesLocale, Optional<Integer> maxResults, Optional<Float> scoreThreshold, List<String> categoryAllowlist, List<String> categoryDenylist, Optional<OutputHandler.ResultListener<ImageClassifierResult, MPImage>> resultListener, Optional<ErrorListener> errorListener) {
        this.baseOptions = baseOptions;
        this.runningMode = runningMode;
        this.displayNamesLocale = displayNamesLocale;
        this.maxResults = maxResults;
        this.scoreThreshold = scoreThreshold;
        this.categoryAllowlist = categoryAllowlist;
        this.categoryDenylist = categoryDenylist;
        this.resultListener = resultListener;
        this.errorListener = errorListener;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions
    BaseOptions baseOptions() {
        return this.baseOptions;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions
    RunningMode runningMode() {
        return this.runningMode;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions
    Optional<String> displayNamesLocale() {
        return this.displayNamesLocale;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions
    Optional<Integer> maxResults() {
        return this.maxResults;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions
    Optional<Float> scoreThreshold() {
        return this.scoreThreshold;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions
    List<String> categoryAllowlist() {
        return this.categoryAllowlist;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions
    List<String> categoryDenylist() {
        return this.categoryDenylist;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions
    Optional<OutputHandler.ResultListener<ImageClassifierResult, MPImage>> resultListener() {
        return this.resultListener;
    }

    @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions
    Optional<ErrorListener> errorListener() {
        return this.errorListener;
    }

    public String toString() {
        return "ImageClassifierOptions{baseOptions=" + this.baseOptions + ", runningMode=" + this.runningMode + ", displayNamesLocale=" + this.displayNamesLocale + ", maxResults=" + this.maxResults + ", scoreThreshold=" + this.scoreThreshold + ", categoryAllowlist=" + this.categoryAllowlist + ", categoryDenylist=" + this.categoryDenylist + ", resultListener=" + this.resultListener + ", errorListener=" + this.errorListener + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ImageClassifier.ImageClassifierOptions) {
            ImageClassifier.ImageClassifierOptions imageClassifierOptions = (ImageClassifier.ImageClassifierOptions) o;
            if (this.baseOptions.equals(imageClassifierOptions.baseOptions()) && this.runningMode.equals(imageClassifierOptions.runningMode()) && this.displayNamesLocale.equals(imageClassifierOptions.displayNamesLocale()) && this.maxResults.equals(imageClassifierOptions.maxResults()) && this.scoreThreshold.equals(imageClassifierOptions.scoreThreshold()) && this.categoryAllowlist.equals(imageClassifierOptions.categoryAllowlist()) && this.categoryDenylist.equals(imageClassifierOptions.categoryDenylist()) && this.resultListener.equals(imageClassifierOptions.resultListener()) && this.errorListener.equals(imageClassifierOptions.errorListener())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.errorListener.hashCode() ^ ((((((((((((((((this.baseOptions.hashCode() ^ 1000003) * 1000003) ^ this.runningMode.hashCode()) * 1000003) ^ this.displayNamesLocale.hashCode()) * 1000003) ^ this.maxResults.hashCode()) * 1000003) ^ this.scoreThreshold.hashCode()) * 1000003) ^ this.categoryAllowlist.hashCode()) * 1000003) ^ this.categoryDenylist.hashCode()) * 1000003) ^ this.resultListener.hashCode()) * 1000003);
    }

    static final class Builder extends ImageClassifier.ImageClassifierOptions.Builder {
        private BaseOptions baseOptions;
        private List<String> categoryAllowlist;
        private List<String> categoryDenylist;
        private RunningMode runningMode;
        private Optional<String> displayNamesLocale = Optional.empty();
        private Optional<Integer> maxResults = Optional.empty();
        private Optional<Float> scoreThreshold = Optional.empty();
        private Optional<OutputHandler.ResultListener<ImageClassifierResult, MPImage>> resultListener = Optional.empty();
        private Optional<ErrorListener> errorListener = Optional.empty();

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions.Builder
        public ImageClassifier.ImageClassifierOptions.Builder setBaseOptions(BaseOptions baseOptions) {
            if (baseOptions == null) {
                throw new NullPointerException("Null baseOptions");
            }
            this.baseOptions = baseOptions;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions.Builder
        public ImageClassifier.ImageClassifierOptions.Builder setRunningMode(RunningMode runningMode) {
            if (runningMode == null) {
                throw new NullPointerException("Null runningMode");
            }
            this.runningMode = runningMode;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions.Builder
        public ImageClassifier.ImageClassifierOptions.Builder setDisplayNamesLocale(String displayNamesLocale) {
            this.displayNamesLocale = Optional.of(displayNamesLocale);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions.Builder
        public ImageClassifier.ImageClassifierOptions.Builder setMaxResults(Integer maxResults) {
            this.maxResults = Optional.of(maxResults);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions.Builder
        public ImageClassifier.ImageClassifierOptions.Builder setScoreThreshold(Float scoreThreshold) {
            this.scoreThreshold = Optional.of(scoreThreshold);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions.Builder
        public ImageClassifier.ImageClassifierOptions.Builder setCategoryAllowlist(List<String> categoryAllowlist) {
            if (categoryAllowlist == null) {
                throw new NullPointerException("Null categoryAllowlist");
            }
            this.categoryAllowlist = categoryAllowlist;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions.Builder
        public ImageClassifier.ImageClassifierOptions.Builder setCategoryDenylist(List<String> categoryDenylist) {
            if (categoryDenylist == null) {
                throw new NullPointerException("Null categoryDenylist");
            }
            this.categoryDenylist = categoryDenylist;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions.Builder
        public ImageClassifier.ImageClassifierOptions.Builder setResultListener(OutputHandler.ResultListener<ImageClassifierResult, MPImage> resultListener) {
            this.resultListener = Optional.of(resultListener);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions.Builder
        public ImageClassifier.ImageClassifierOptions.Builder setErrorListener(ErrorListener errorListener) {
            this.errorListener = Optional.of(errorListener);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.ImageClassifierOptions.Builder
        ImageClassifier.ImageClassifierOptions autoBuild() {
            String str;
            if (this.baseOptions != null) {
                str = "";
            } else {
                str = " baseOptions";
            }
            if (this.runningMode == null) {
                str = str + " runningMode";
            }
            if (this.categoryAllowlist == null) {
                str = str + " categoryAllowlist";
            }
            if (this.categoryDenylist == null) {
                str = str + " categoryDenylist";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_ImageClassifier_ImageClassifierOptions(this.baseOptions, this.runningMode, this.displayNamesLocale, this.maxResults, this.scoreThreshold, this.categoryAllowlist, this.categoryDenylist, this.resultListener, this.errorListener);
        }
    }
}
