package com.google.mediapipe.tasks.vision.facedetector;

import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.tasks.core.BaseOptions;
import com.google.mediapipe.tasks.core.ErrorListener;
import com.google.mediapipe.tasks.core.OutputHandler;
import com.google.mediapipe.tasks.vision.core.RunningMode;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_FaceDetector_FaceDetectorOptions extends FaceDetector.FaceDetectorOptions {
    private final BaseOptions baseOptions;
    private final Optional<ErrorListener> errorListener;
    private final float minDetectionConfidence;
    private final float minSuppressionThreshold;
    private final Optional<OutputHandler.ResultListener<FaceDetectorResult, MPImage>> resultListener;
    private final RunningMode runningMode;

    private AutoValue_FaceDetector_FaceDetectorOptions(BaseOptions baseOptions, RunningMode runningMode, float minDetectionConfidence, float minSuppressionThreshold, Optional<OutputHandler.ResultListener<FaceDetectorResult, MPImage>> resultListener, Optional<ErrorListener> errorListener) {
        this.baseOptions = baseOptions;
        this.runningMode = runningMode;
        this.minDetectionConfidence = minDetectionConfidence;
        this.minSuppressionThreshold = minSuppressionThreshold;
        this.resultListener = resultListener;
        this.errorListener = errorListener;
    }

    @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions
    BaseOptions baseOptions() {
        return this.baseOptions;
    }

    @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions
    RunningMode runningMode() {
        return this.runningMode;
    }

    @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions
    float minDetectionConfidence() {
        return this.minDetectionConfidence;
    }

    @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions
    float minSuppressionThreshold() {
        return this.minSuppressionThreshold;
    }

    @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions
    Optional<OutputHandler.ResultListener<FaceDetectorResult, MPImage>> resultListener() {
        return this.resultListener;
    }

    @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions
    Optional<ErrorListener> errorListener() {
        return this.errorListener;
    }

    public String toString() {
        return "FaceDetectorOptions{baseOptions=" + this.baseOptions + ", runningMode=" + this.runningMode + ", minDetectionConfidence=" + this.minDetectionConfidence + ", minSuppressionThreshold=" + this.minSuppressionThreshold + ", resultListener=" + this.resultListener + ", errorListener=" + this.errorListener + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof FaceDetector.FaceDetectorOptions) {
            FaceDetector.FaceDetectorOptions faceDetectorOptions = (FaceDetector.FaceDetectorOptions) o;
            if (this.baseOptions.equals(faceDetectorOptions.baseOptions()) && this.runningMode.equals(faceDetectorOptions.runningMode()) && Float.floatToIntBits(this.minDetectionConfidence) == Float.floatToIntBits(faceDetectorOptions.minDetectionConfidence()) && Float.floatToIntBits(this.minSuppressionThreshold) == Float.floatToIntBits(faceDetectorOptions.minSuppressionThreshold()) && this.resultListener.equals(faceDetectorOptions.resultListener()) && this.errorListener.equals(faceDetectorOptions.errorListener())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.errorListener.hashCode() ^ ((((((((((this.baseOptions.hashCode() ^ 1000003) * 1000003) ^ this.runningMode.hashCode()) * 1000003) ^ Float.floatToIntBits(this.minDetectionConfidence)) * 1000003) ^ Float.floatToIntBits(this.minSuppressionThreshold)) * 1000003) ^ this.resultListener.hashCode()) * 1000003);
    }

    static final class Builder extends FaceDetector.FaceDetectorOptions.Builder {
        private BaseOptions baseOptions;
        private Float minDetectionConfidence;
        private Float minSuppressionThreshold;
        private RunningMode runningMode;
        private Optional<OutputHandler.ResultListener<FaceDetectorResult, MPImage>> resultListener = Optional.empty();
        private Optional<ErrorListener> errorListener = Optional.empty();

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions.Builder
        public FaceDetector.FaceDetectorOptions.Builder setBaseOptions(BaseOptions baseOptions) {
            if (baseOptions == null) {
                throw new NullPointerException("Null baseOptions");
            }
            this.baseOptions = baseOptions;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions.Builder
        public FaceDetector.FaceDetectorOptions.Builder setRunningMode(RunningMode runningMode) {
            if (runningMode == null) {
                throw new NullPointerException("Null runningMode");
            }
            this.runningMode = runningMode;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions.Builder
        public FaceDetector.FaceDetectorOptions.Builder setMinDetectionConfidence(float minDetectionConfidence) {
            this.minDetectionConfidence = Float.valueOf(minDetectionConfidence);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions.Builder
        public FaceDetector.FaceDetectorOptions.Builder setMinSuppressionThreshold(float minSuppressionThreshold) {
            this.minSuppressionThreshold = Float.valueOf(minSuppressionThreshold);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions.Builder
        public FaceDetector.FaceDetectorOptions.Builder setResultListener(OutputHandler.ResultListener<FaceDetectorResult, MPImage> resultListener) {
            this.resultListener = Optional.of(resultListener);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions.Builder
        public FaceDetector.FaceDetectorOptions.Builder setErrorListener(ErrorListener errorListener) {
            this.errorListener = Optional.of(errorListener);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.FaceDetector.FaceDetectorOptions.Builder
        FaceDetector.FaceDetectorOptions autoBuild() {
            String str;
            if (this.baseOptions != null) {
                str = "";
            } else {
                str = " baseOptions";
            }
            if (this.runningMode == null) {
                str = str + " runningMode";
            }
            if (this.minDetectionConfidence == null) {
                str = str + " minDetectionConfidence";
            }
            if (this.minSuppressionThreshold == null) {
                str = str + " minSuppressionThreshold";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_FaceDetector_FaceDetectorOptions(this.baseOptions, this.runningMode, this.minDetectionConfidence.floatValue(), this.minSuppressionThreshold.floatValue(), this.resultListener, this.errorListener);
        }
    }
}
