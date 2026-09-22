package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision;

import com.google.mediapipe.tasks.vision.facedetector.FaceDetectorResult;
import com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarkerResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VisionDetector.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/DetectionResult;", "", "faceDetectorResult", "Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetectorResult;", "handLandmarkerResult", "Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarkerResult;", "inputImageHeight", "", "inputImageWidth", "<init>", "(Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetectorResult;Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarkerResult;II)V", "getFaceDetectorResult", "()Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetectorResult;", "getHandLandmarkerResult", "()Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarkerResult;", "getInputImageHeight", "()I", "getInputImageWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DetectionResult {
    public static final int $stable = 8;
    private final FaceDetectorResult faceDetectorResult;
    private final HandLandmarkerResult handLandmarkerResult;
    private final int inputImageHeight;
    private final int inputImageWidth;

    public static /* synthetic */ DetectionResult copy$default(DetectionResult detectionResult, FaceDetectorResult faceDetectorResult, HandLandmarkerResult handLandmarkerResult, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            faceDetectorResult = detectionResult.faceDetectorResult;
        }
        if ((i3 & 2) != 0) {
            handLandmarkerResult = detectionResult.handLandmarkerResult;
        }
        if ((i3 & 4) != 0) {
            i = detectionResult.inputImageHeight;
        }
        if ((i3 & 8) != 0) {
            i2 = detectionResult.inputImageWidth;
        }
        return detectionResult.copy(faceDetectorResult, handLandmarkerResult, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FaceDetectorResult getFaceDetectorResult() {
        return this.faceDetectorResult;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HandLandmarkerResult getHandLandmarkerResult() {
        return this.handLandmarkerResult;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getInputImageHeight() {
        return this.inputImageHeight;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getInputImageWidth() {
        return this.inputImageWidth;
    }

    public final DetectionResult copy(FaceDetectorResult faceDetectorResult, HandLandmarkerResult handLandmarkerResult, int inputImageHeight, int inputImageWidth) {
        return new DetectionResult(faceDetectorResult, handLandmarkerResult, inputImageHeight, inputImageWidth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetectionResult)) {
            return false;
        }
        DetectionResult detectionResult = (DetectionResult) other;
        return Intrinsics.areEqual(this.faceDetectorResult, detectionResult.faceDetectorResult) && Intrinsics.areEqual(this.handLandmarkerResult, detectionResult.handLandmarkerResult) && this.inputImageHeight == detectionResult.inputImageHeight && this.inputImageWidth == detectionResult.inputImageWidth;
    }

    public int hashCode() {
        FaceDetectorResult faceDetectorResult = this.faceDetectorResult;
        int iHashCode = (faceDetectorResult == null ? 0 : faceDetectorResult.hashCode()) * 31;
        HandLandmarkerResult handLandmarkerResult = this.handLandmarkerResult;
        return ((((iHashCode + (handLandmarkerResult != null ? handLandmarkerResult.hashCode() : 0)) * 31) + Integer.hashCode(this.inputImageHeight)) * 31) + Integer.hashCode(this.inputImageWidth);
    }

    public String toString() {
        return "DetectionResult(faceDetectorResult=" + this.faceDetectorResult + ", handLandmarkerResult=" + this.handLandmarkerResult + ", inputImageHeight=" + this.inputImageHeight + ", inputImageWidth=" + this.inputImageWidth + ")";
    }

    public DetectionResult(FaceDetectorResult faceDetectorResult, HandLandmarkerResult handLandmarkerResult, int i, int i2) {
        this.faceDetectorResult = faceDetectorResult;
        this.handLandmarkerResult = handLandmarkerResult;
        this.inputImageHeight = i;
        this.inputImageWidth = i2;
    }

    public final FaceDetectorResult getFaceDetectorResult() {
        return this.faceDetectorResult;
    }

    public final HandLandmarkerResult getHandLandmarkerResult() {
        return this.handLandmarkerResult;
    }

    public final int getInputImageHeight() {
        return this.inputImageHeight;
    }

    public final int getInputImageWidth() {
        return this.inputImageWidth;
    }
}
