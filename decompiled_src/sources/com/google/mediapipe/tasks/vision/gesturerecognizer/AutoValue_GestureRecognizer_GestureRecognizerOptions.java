package com.google.mediapipe.tasks.vision.gesturerecognizer;

import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.tasks.components.processors.ClassifierOptions;
import com.google.mediapipe.tasks.core.BaseOptions;
import com.google.mediapipe.tasks.core.ErrorListener;
import com.google.mediapipe.tasks.core.OutputHandler;
import com.google.mediapipe.tasks.vision.core.RunningMode;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_GestureRecognizer_GestureRecognizerOptions extends GestureRecognizer.GestureRecognizerOptions {
    private final BaseOptions baseOptions;
    private final Optional<ClassifierOptions> cannedGesturesClassifierOptions;
    private final Optional<ClassifierOptions> customGesturesClassifierOptions;
    private final Optional<ErrorListener> errorListener;
    private final Optional<Float> minHandDetectionConfidence;
    private final Optional<Float> minHandPresenceConfidence;
    private final Optional<Float> minTrackingConfidence;
    private final Optional<Integer> numHands;
    private final Optional<OutputHandler.ResultListener<GestureRecognizerResult, MPImage>> resultListener;
    private final RunningMode runningMode;

    private AutoValue_GestureRecognizer_GestureRecognizerOptions(BaseOptions baseOptions, RunningMode runningMode, Optional<Integer> numHands, Optional<Float> minHandDetectionConfidence, Optional<Float> minHandPresenceConfidence, Optional<Float> minTrackingConfidence, Optional<ClassifierOptions> cannedGesturesClassifierOptions, Optional<ClassifierOptions> customGesturesClassifierOptions, Optional<OutputHandler.ResultListener<GestureRecognizerResult, MPImage>> resultListener, Optional<ErrorListener> errorListener) {
        this.baseOptions = baseOptions;
        this.runningMode = runningMode;
        this.numHands = numHands;
        this.minHandDetectionConfidence = minHandDetectionConfidence;
        this.minHandPresenceConfidence = minHandPresenceConfidence;
        this.minTrackingConfidence = minTrackingConfidence;
        this.cannedGesturesClassifierOptions = cannedGesturesClassifierOptions;
        this.customGesturesClassifierOptions = customGesturesClassifierOptions;
        this.resultListener = resultListener;
        this.errorListener = errorListener;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions
    BaseOptions baseOptions() {
        return this.baseOptions;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions
    RunningMode runningMode() {
        return this.runningMode;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions
    Optional<Integer> numHands() {
        return this.numHands;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions
    Optional<Float> minHandDetectionConfidence() {
        return this.minHandDetectionConfidence;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions
    Optional<Float> minHandPresenceConfidence() {
        return this.minHandPresenceConfidence;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions
    Optional<Float> minTrackingConfidence() {
        return this.minTrackingConfidence;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions
    Optional<ClassifierOptions> cannedGesturesClassifierOptions() {
        return this.cannedGesturesClassifierOptions;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions
    Optional<ClassifierOptions> customGesturesClassifierOptions() {
        return this.customGesturesClassifierOptions;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions
    Optional<OutputHandler.ResultListener<GestureRecognizerResult, MPImage>> resultListener() {
        return this.resultListener;
    }

    @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions
    Optional<ErrorListener> errorListener() {
        return this.errorListener;
    }

    public String toString() {
        return "GestureRecognizerOptions{baseOptions=" + this.baseOptions + ", runningMode=" + this.runningMode + ", numHands=" + this.numHands + ", minHandDetectionConfidence=" + this.minHandDetectionConfidence + ", minHandPresenceConfidence=" + this.minHandPresenceConfidence + ", minTrackingConfidence=" + this.minTrackingConfidence + ", cannedGesturesClassifierOptions=" + this.cannedGesturesClassifierOptions + ", customGesturesClassifierOptions=" + this.customGesturesClassifierOptions + ", resultListener=" + this.resultListener + ", errorListener=" + this.errorListener + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof GestureRecognizer.GestureRecognizerOptions) {
            GestureRecognizer.GestureRecognizerOptions gestureRecognizerOptions = (GestureRecognizer.GestureRecognizerOptions) o;
            if (this.baseOptions.equals(gestureRecognizerOptions.baseOptions()) && this.runningMode.equals(gestureRecognizerOptions.runningMode()) && this.numHands.equals(gestureRecognizerOptions.numHands()) && this.minHandDetectionConfidence.equals(gestureRecognizerOptions.minHandDetectionConfidence()) && this.minHandPresenceConfidence.equals(gestureRecognizerOptions.minHandPresenceConfidence()) && this.minTrackingConfidence.equals(gestureRecognizerOptions.minTrackingConfidence()) && this.cannedGesturesClassifierOptions.equals(gestureRecognizerOptions.cannedGesturesClassifierOptions()) && this.customGesturesClassifierOptions.equals(gestureRecognizerOptions.customGesturesClassifierOptions()) && this.resultListener.equals(gestureRecognizerOptions.resultListener()) && this.errorListener.equals(gestureRecognizerOptions.errorListener())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.errorListener.hashCode() ^ ((((((((((((((((((this.baseOptions.hashCode() ^ 1000003) * 1000003) ^ this.runningMode.hashCode()) * 1000003) ^ this.numHands.hashCode()) * 1000003) ^ this.minHandDetectionConfidence.hashCode()) * 1000003) ^ this.minHandPresenceConfidence.hashCode()) * 1000003) ^ this.minTrackingConfidence.hashCode()) * 1000003) ^ this.cannedGesturesClassifierOptions.hashCode()) * 1000003) ^ this.customGesturesClassifierOptions.hashCode()) * 1000003) ^ this.resultListener.hashCode()) * 1000003);
    }

    static final class Builder extends GestureRecognizer.GestureRecognizerOptions.Builder {
        private BaseOptions baseOptions;
        private RunningMode runningMode;
        private Optional<Integer> numHands = Optional.empty();
        private Optional<Float> minHandDetectionConfidence = Optional.empty();
        private Optional<Float> minHandPresenceConfidence = Optional.empty();
        private Optional<Float> minTrackingConfidence = Optional.empty();
        private Optional<ClassifierOptions> cannedGesturesClassifierOptions = Optional.empty();
        private Optional<ClassifierOptions> customGesturesClassifierOptions = Optional.empty();
        private Optional<OutputHandler.ResultListener<GestureRecognizerResult, MPImage>> resultListener = Optional.empty();
        private Optional<ErrorListener> errorListener = Optional.empty();

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        public GestureRecognizer.GestureRecognizerOptions.Builder setBaseOptions(BaseOptions baseOptions) {
            if (baseOptions == null) {
                throw new NullPointerException("Null baseOptions");
            }
            this.baseOptions = baseOptions;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        public GestureRecognizer.GestureRecognizerOptions.Builder setRunningMode(RunningMode runningMode) {
            if (runningMode == null) {
                throw new NullPointerException("Null runningMode");
            }
            this.runningMode = runningMode;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        public GestureRecognizer.GestureRecognizerOptions.Builder setNumHands(Integer numHands) {
            this.numHands = Optional.of(numHands);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        public GestureRecognizer.GestureRecognizerOptions.Builder setMinHandDetectionConfidence(Float minHandDetectionConfidence) {
            this.minHandDetectionConfidence = Optional.of(minHandDetectionConfidence);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        public GestureRecognizer.GestureRecognizerOptions.Builder setMinHandPresenceConfidence(Float minHandPresenceConfidence) {
            this.minHandPresenceConfidence = Optional.of(minHandPresenceConfidence);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        public GestureRecognizer.GestureRecognizerOptions.Builder setMinTrackingConfidence(Float minTrackingConfidence) {
            this.minTrackingConfidence = Optional.of(minTrackingConfidence);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        public GestureRecognizer.GestureRecognizerOptions.Builder setCannedGesturesClassifierOptions(ClassifierOptions cannedGesturesClassifierOptions) {
            this.cannedGesturesClassifierOptions = Optional.of(cannedGesturesClassifierOptions);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        public GestureRecognizer.GestureRecognizerOptions.Builder setCustomGesturesClassifierOptions(ClassifierOptions customGesturesClassifierOptions) {
            this.customGesturesClassifierOptions = Optional.of(customGesturesClassifierOptions);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        public GestureRecognizer.GestureRecognizerOptions.Builder setResultListener(OutputHandler.ResultListener<GestureRecognizerResult, MPImage> resultListener) {
            this.resultListener = Optional.of(resultListener);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        public GestureRecognizer.GestureRecognizerOptions.Builder setErrorListener(ErrorListener errorListener) {
            this.errorListener = Optional.of(errorListener);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.GestureRecognizerOptions.Builder
        GestureRecognizer.GestureRecognizerOptions autoBuild() {
            String str;
            if (this.baseOptions != null) {
                str = "";
            } else {
                str = " baseOptions";
            }
            if (this.runningMode == null) {
                str = str + " runningMode";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_GestureRecognizer_GestureRecognizerOptions(this.baseOptions, this.runningMode, this.numHands, this.minHandDetectionConfidence, this.minHandPresenceConfidence, this.minTrackingConfidence, this.cannedGesturesClassifierOptions, this.customGesturesClassifierOptions, this.resultListener, this.errorListener);
        }
    }
}
