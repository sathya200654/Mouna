package com.google.mediapipe.tasks.vision.holisticlandmarker;

import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.tasks.core.BaseOptions;
import com.google.mediapipe.tasks.core.ErrorListener;
import com.google.mediapipe.tasks.core.OutputHandler;
import com.google.mediapipe.tasks.vision.core.RunningMode;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_HolisticLandmarker_HolisticLandmarkerOptions extends HolisticLandmarker.HolisticLandmarkerOptions {
    private final BaseOptions baseOptions;
    private final Optional<ErrorListener> errorListener;
    private final Optional<Float> minFaceDetectionConfidence;
    private final Optional<Float> minFacePresenceConfidence;
    private final Optional<Float> minFaceSuppressionThreshold;
    private final Optional<Float> minHandLandmarksConfidence;
    private final Optional<Float> minPoseDetectionConfidence;
    private final Optional<Float> minPosePresenceConfidence;
    private final Optional<Float> minPoseSuppressionThreshold;
    private final boolean outputFaceBlendshapes;
    private final boolean outputPoseSegmentationMasks;
    private final Optional<OutputHandler.ResultListener<HolisticLandmarkerResult, MPImage>> resultListener;
    private final RunningMode runningMode;

    private AutoValue_HolisticLandmarker_HolisticLandmarkerOptions(BaseOptions baseOptions, RunningMode runningMode, Optional<Float> minFaceDetectionConfidence, Optional<Float> minFaceSuppressionThreshold, Optional<Float> minFacePresenceConfidence, Optional<Float> minPoseDetectionConfidence, Optional<Float> minPoseSuppressionThreshold, Optional<Float> minPosePresenceConfidence, Optional<Float> minHandLandmarksConfidence, boolean outputFaceBlendshapes, boolean outputPoseSegmentationMasks, Optional<OutputHandler.ResultListener<HolisticLandmarkerResult, MPImage>> resultListener, Optional<ErrorListener> errorListener) {
        this.baseOptions = baseOptions;
        this.runningMode = runningMode;
        this.minFaceDetectionConfidence = minFaceDetectionConfidence;
        this.minFaceSuppressionThreshold = minFaceSuppressionThreshold;
        this.minFacePresenceConfidence = minFacePresenceConfidence;
        this.minPoseDetectionConfidence = minPoseDetectionConfidence;
        this.minPoseSuppressionThreshold = minPoseSuppressionThreshold;
        this.minPosePresenceConfidence = minPosePresenceConfidence;
        this.minHandLandmarksConfidence = minHandLandmarksConfidence;
        this.outputFaceBlendshapes = outputFaceBlendshapes;
        this.outputPoseSegmentationMasks = outputPoseSegmentationMasks;
        this.resultListener = resultListener;
        this.errorListener = errorListener;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    BaseOptions baseOptions() {
        return this.baseOptions;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    RunningMode runningMode() {
        return this.runningMode;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    Optional<Float> minFaceDetectionConfidence() {
        return this.minFaceDetectionConfidence;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    Optional<Float> minFaceSuppressionThreshold() {
        return this.minFaceSuppressionThreshold;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    Optional<Float> minFacePresenceConfidence() {
        return this.minFacePresenceConfidence;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    Optional<Float> minPoseDetectionConfidence() {
        return this.minPoseDetectionConfidence;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    Optional<Float> minPoseSuppressionThreshold() {
        return this.minPoseSuppressionThreshold;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    Optional<Float> minPosePresenceConfidence() {
        return this.minPosePresenceConfidence;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    Optional<Float> minHandLandmarksConfidence() {
        return this.minHandLandmarksConfidence;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    boolean outputFaceBlendshapes() {
        return this.outputFaceBlendshapes;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    boolean outputPoseSegmentationMasks() {
        return this.outputPoseSegmentationMasks;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    Optional<OutputHandler.ResultListener<HolisticLandmarkerResult, MPImage>> resultListener() {
        return this.resultListener;
    }

    @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions
    Optional<ErrorListener> errorListener() {
        return this.errorListener;
    }

    public String toString() {
        return "HolisticLandmarkerOptions{baseOptions=" + this.baseOptions + ", runningMode=" + this.runningMode + ", minFaceDetectionConfidence=" + this.minFaceDetectionConfidence + ", minFaceSuppressionThreshold=" + this.minFaceSuppressionThreshold + ", minFacePresenceConfidence=" + this.minFacePresenceConfidence + ", minPoseDetectionConfidence=" + this.minPoseDetectionConfidence + ", minPoseSuppressionThreshold=" + this.minPoseSuppressionThreshold + ", minPosePresenceConfidence=" + this.minPosePresenceConfidence + ", minHandLandmarksConfidence=" + this.minHandLandmarksConfidence + ", outputFaceBlendshapes=" + this.outputFaceBlendshapes + ", outputPoseSegmentationMasks=" + this.outputPoseSegmentationMasks + ", resultListener=" + this.resultListener + ", errorListener=" + this.errorListener + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof HolisticLandmarker.HolisticLandmarkerOptions) {
            HolisticLandmarker.HolisticLandmarkerOptions holisticLandmarkerOptions = (HolisticLandmarker.HolisticLandmarkerOptions) o;
            if (this.baseOptions.equals(holisticLandmarkerOptions.baseOptions()) && this.runningMode.equals(holisticLandmarkerOptions.runningMode()) && this.minFaceDetectionConfidence.equals(holisticLandmarkerOptions.minFaceDetectionConfidence()) && this.minFaceSuppressionThreshold.equals(holisticLandmarkerOptions.minFaceSuppressionThreshold()) && this.minFacePresenceConfidence.equals(holisticLandmarkerOptions.minFacePresenceConfidence()) && this.minPoseDetectionConfidence.equals(holisticLandmarkerOptions.minPoseDetectionConfidence()) && this.minPoseSuppressionThreshold.equals(holisticLandmarkerOptions.minPoseSuppressionThreshold()) && this.minPosePresenceConfidence.equals(holisticLandmarkerOptions.minPosePresenceConfidence()) && this.minHandLandmarksConfidence.equals(holisticLandmarkerOptions.minHandLandmarksConfidence()) && this.outputFaceBlendshapes == holisticLandmarkerOptions.outputFaceBlendshapes() && this.outputPoseSegmentationMasks == holisticLandmarkerOptions.outputPoseSegmentationMasks() && this.resultListener.equals(holisticLandmarkerOptions.resultListener()) && this.errorListener.equals(holisticLandmarkerOptions.errorListener())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.errorListener.hashCode() ^ ((((((((((((((((((((((((this.baseOptions.hashCode() ^ 1000003) * 1000003) ^ this.runningMode.hashCode()) * 1000003) ^ this.minFaceDetectionConfidence.hashCode()) * 1000003) ^ this.minFaceSuppressionThreshold.hashCode()) * 1000003) ^ this.minFacePresenceConfidence.hashCode()) * 1000003) ^ this.minPoseDetectionConfidence.hashCode()) * 1000003) ^ this.minPoseSuppressionThreshold.hashCode()) * 1000003) ^ this.minPosePresenceConfidence.hashCode()) * 1000003) ^ this.minHandLandmarksConfidence.hashCode()) * 1000003) ^ (this.outputFaceBlendshapes ? 1231 : 1237)) * 1000003) ^ (this.outputPoseSegmentationMasks ? 1231 : 1237)) * 1000003) ^ this.resultListener.hashCode()) * 1000003);
    }

    static final class Builder extends HolisticLandmarker.HolisticLandmarkerOptions.Builder {
        private BaseOptions baseOptions;
        private Boolean outputFaceBlendshapes;
        private Boolean outputPoseSegmentationMasks;
        private RunningMode runningMode;
        private Optional<Float> minFaceDetectionConfidence = Optional.empty();
        private Optional<Float> minFaceSuppressionThreshold = Optional.empty();
        private Optional<Float> minFacePresenceConfidence = Optional.empty();
        private Optional<Float> minPoseDetectionConfidence = Optional.empty();
        private Optional<Float> minPoseSuppressionThreshold = Optional.empty();
        private Optional<Float> minPosePresenceConfidence = Optional.empty();
        private Optional<Float> minHandLandmarksConfidence = Optional.empty();
        private Optional<OutputHandler.ResultListener<HolisticLandmarkerResult, MPImage>> resultListener = Optional.empty();
        private Optional<ErrorListener> errorListener = Optional.empty();

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setBaseOptions(BaseOptions baseOptions) {
            if (baseOptions == null) {
                throw new NullPointerException("Null baseOptions");
            }
            this.baseOptions = baseOptions;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setRunningMode(RunningMode runningMode) {
            if (runningMode == null) {
                throw new NullPointerException("Null runningMode");
            }
            this.runningMode = runningMode;
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setMinFaceDetectionConfidence(Float minFaceDetectionConfidence) {
            this.minFaceDetectionConfidence = Optional.of(minFaceDetectionConfidence);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setMinFaceSuppressionThreshold(Float minFaceSuppressionThreshold) {
            this.minFaceSuppressionThreshold = Optional.of(minFaceSuppressionThreshold);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setMinFacePresenceConfidence(Float minFacePresenceConfidence) {
            this.minFacePresenceConfidence = Optional.of(minFacePresenceConfidence);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setMinPoseDetectionConfidence(Float minPoseDetectionConfidence) {
            this.minPoseDetectionConfidence = Optional.of(minPoseDetectionConfidence);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setMinPoseSuppressionThreshold(Float minPoseSuppressionThreshold) {
            this.minPoseSuppressionThreshold = Optional.of(minPoseSuppressionThreshold);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setMinPosePresenceConfidence(Float minPosePresenceConfidence) {
            this.minPosePresenceConfidence = Optional.of(minPosePresenceConfidence);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setMinHandLandmarksConfidence(Float minHandLandmarksConfidence) {
            this.minHandLandmarksConfidence = Optional.of(minHandLandmarksConfidence);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setOutputFaceBlendshapes(boolean outputFaceBlendshapes) {
            this.outputFaceBlendshapes = Boolean.valueOf(outputFaceBlendshapes);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setOutputPoseSegmentationMasks(boolean outputPoseSegmentationMasks) {
            this.outputPoseSegmentationMasks = Boolean.valueOf(outputPoseSegmentationMasks);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setResultListener(OutputHandler.ResultListener<HolisticLandmarkerResult, MPImage> resultListener) {
            this.resultListener = Optional.of(resultListener);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        public HolisticLandmarker.HolisticLandmarkerOptions.Builder setErrorListener(ErrorListener errorListener) {
            this.errorListener = Optional.of(errorListener);
            return this;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.HolisticLandmarkerOptions.Builder
        HolisticLandmarker.HolisticLandmarkerOptions autoBuild() {
            String str;
            if (this.baseOptions != null) {
                str = "";
            } else {
                str = " baseOptions";
            }
            if (this.runningMode == null) {
                str = str + " runningMode";
            }
            if (this.outputFaceBlendshapes == null) {
                str = str + " outputFaceBlendshapes";
            }
            if (this.outputPoseSegmentationMasks == null) {
                str = str + " outputPoseSegmentationMasks";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_HolisticLandmarker_HolisticLandmarkerOptions(this.baseOptions, this.runningMode, this.minFaceDetectionConfidence, this.minFaceSuppressionThreshold, this.minFacePresenceConfidence, this.minPoseDetectionConfidence, this.minPoseSuppressionThreshold, this.minPosePresenceConfidence, this.minHandLandmarksConfidence, this.outputFaceBlendshapes.booleanValue(), this.outputPoseSegmentationMasks.booleanValue(), this.resultListener, this.errorListener);
        }
    }
}
