package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels;

import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.mediapipe.tasks.vision.facedetector.FaceDetectorResult;
import com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarkerResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUploadViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b/\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u00108\u001a\u00020\u0013HÆ\u0003J\t\u00109\u001a\u00020\u0013HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010;\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u009a\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u00132\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0007HÖ\u0001J\t\u0010A\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010)R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&¨\u0006B"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/DetectionUiState;", "", "faceDetectorResult", "Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetectorResult;", "handLandmarkerResult", "Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarkerResult;", "imageHeight", "", "imageWidth", "confidence", "", "recordingState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/RecordingState;", "countdownSeconds", "videoName", "", "recordedVideoUri", "Landroid/net/Uri;", "isUploading", "", "uploadSuccess", "uploadError", "uploadErrorMessage", "<init>", "(Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetectorResult;Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarkerResult;IIFLcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/RecordingState;ILjava/lang/String;Landroid/net/Uri;ZZLjava/lang/Integer;Ljava/lang/String;)V", "getFaceDetectorResult", "()Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetectorResult;", "getHandLandmarkerResult", "()Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarkerResult;", "getImageHeight", "()I", "getImageWidth", "getConfidence", "()F", "getRecordingState", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/RecordingState;", "getCountdownSeconds", "getVideoName", "()Ljava/lang/String;", "getRecordedVideoUri", "()Landroid/net/Uri;", "()Z", "getUploadSuccess", "getUploadError", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUploadErrorMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetectorResult;Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarkerResult;IIFLcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/RecordingState;ILjava/lang/String;Landroid/net/Uri;ZZLjava/lang/Integer;Ljava/lang/String;)Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/DetectionUiState;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DetectionUiState {
    public static final int $stable = 8;
    private final float confidence;
    private final int countdownSeconds;
    private final FaceDetectorResult faceDetectorResult;
    private final HandLandmarkerResult handLandmarkerResult;
    private final int imageHeight;
    private final int imageWidth;
    private final boolean isUploading;
    private final Uri recordedVideoUri;
    private final RecordingState recordingState;
    private final Integer uploadError;
    private final String uploadErrorMessage;
    private final boolean uploadSuccess;
    private final String videoName;

    public DetectionUiState() {
        this(null, null, 0, 0, 0.0f, null, 0, null, null, false, false, null, null, 8191, null);
    }

    public static /* synthetic */ DetectionUiState copy$default(DetectionUiState detectionUiState, FaceDetectorResult faceDetectorResult, HandLandmarkerResult handLandmarkerResult, int i, int i2, float f, RecordingState recordingState, int i3, String str, Uri uri, boolean z, boolean z2, Integer num, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            faceDetectorResult = detectionUiState.faceDetectorResult;
        }
        return detectionUiState.copy(faceDetectorResult, (i4 & 2) != 0 ? detectionUiState.handLandmarkerResult : handLandmarkerResult, (i4 & 4) != 0 ? detectionUiState.imageHeight : i, (i4 & 8) != 0 ? detectionUiState.imageWidth : i2, (i4 & 16) != 0 ? detectionUiState.confidence : f, (i4 & 32) != 0 ? detectionUiState.recordingState : recordingState, (i4 & 64) != 0 ? detectionUiState.countdownSeconds : i3, (i4 & 128) != 0 ? detectionUiState.videoName : str, (i4 & 256) != 0 ? detectionUiState.recordedVideoUri : uri, (i4 & 512) != 0 ? detectionUiState.isUploading : z, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? detectionUiState.uploadSuccess : z2, (i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? detectionUiState.uploadError : num, (i4 & 4096) != 0 ? detectionUiState.uploadErrorMessage : str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FaceDetectorResult getFaceDetectorResult() {
        return this.faceDetectorResult;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsUploading() {
        return this.isUploading;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getUploadSuccess() {
        return this.uploadSuccess;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getUploadError() {
        return this.uploadError;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getUploadErrorMessage() {
        return this.uploadErrorMessage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HandLandmarkerResult getHandLandmarkerResult() {
        return this.handLandmarkerResult;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getImageHeight() {
        return this.imageHeight;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getImageWidth() {
        return this.imageWidth;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getConfidence() {
        return this.confidence;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final RecordingState getRecordingState() {
        return this.recordingState;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getCountdownSeconds() {
        return this.countdownSeconds;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getVideoName() {
        return this.videoName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Uri getRecordedVideoUri() {
        return this.recordedVideoUri;
    }

    public final DetectionUiState copy(FaceDetectorResult faceDetectorResult, HandLandmarkerResult handLandmarkerResult, int imageHeight, int imageWidth, float confidence, RecordingState recordingState, int countdownSeconds, String videoName, Uri recordedVideoUri, boolean isUploading, boolean uploadSuccess, Integer uploadError, String uploadErrorMessage) {
        Intrinsics.checkNotNullParameter(recordingState, "recordingState");
        Intrinsics.checkNotNullParameter(videoName, "videoName");
        return new DetectionUiState(faceDetectorResult, handLandmarkerResult, imageHeight, imageWidth, confidence, recordingState, countdownSeconds, videoName, recordedVideoUri, isUploading, uploadSuccess, uploadError, uploadErrorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetectionUiState)) {
            return false;
        }
        DetectionUiState detectionUiState = (DetectionUiState) other;
        return Intrinsics.areEqual(this.faceDetectorResult, detectionUiState.faceDetectorResult) && Intrinsics.areEqual(this.handLandmarkerResult, detectionUiState.handLandmarkerResult) && this.imageHeight == detectionUiState.imageHeight && this.imageWidth == detectionUiState.imageWidth && Float.compare(this.confidence, detectionUiState.confidence) == 0 && this.recordingState == detectionUiState.recordingState && this.countdownSeconds == detectionUiState.countdownSeconds && Intrinsics.areEqual(this.videoName, detectionUiState.videoName) && Intrinsics.areEqual(this.recordedVideoUri, detectionUiState.recordedVideoUri) && this.isUploading == detectionUiState.isUploading && this.uploadSuccess == detectionUiState.uploadSuccess && Intrinsics.areEqual(this.uploadError, detectionUiState.uploadError) && Intrinsics.areEqual(this.uploadErrorMessage, detectionUiState.uploadErrorMessage);
    }

    public int hashCode() {
        FaceDetectorResult faceDetectorResult = this.faceDetectorResult;
        int iHashCode = (faceDetectorResult == null ? 0 : faceDetectorResult.hashCode()) * 31;
        HandLandmarkerResult handLandmarkerResult = this.handLandmarkerResult;
        int iHashCode2 = (((((((((((((iHashCode + (handLandmarkerResult == null ? 0 : handLandmarkerResult.hashCode())) * 31) + Integer.hashCode(this.imageHeight)) * 31) + Integer.hashCode(this.imageWidth)) * 31) + Float.hashCode(this.confidence)) * 31) + this.recordingState.hashCode()) * 31) + Integer.hashCode(this.countdownSeconds)) * 31) + this.videoName.hashCode()) * 31;
        Uri uri = this.recordedVideoUri;
        int iHashCode3 = (((((iHashCode2 + (uri == null ? 0 : uri.hashCode())) * 31) + Boolean.hashCode(this.isUploading)) * 31) + Boolean.hashCode(this.uploadSuccess)) * 31;
        Integer num = this.uploadError;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.uploadErrorMessage;
        return iHashCode4 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DetectionUiState(faceDetectorResult=" + this.faceDetectorResult + ", handLandmarkerResult=" + this.handLandmarkerResult + ", imageHeight=" + this.imageHeight + ", imageWidth=" + this.imageWidth + ", confidence=" + this.confidence + ", recordingState=" + this.recordingState + ", countdownSeconds=" + this.countdownSeconds + ", videoName=" + this.videoName + ", recordedVideoUri=" + this.recordedVideoUri + ", isUploading=" + this.isUploading + ", uploadSuccess=" + this.uploadSuccess + ", uploadError=" + this.uploadError + ", uploadErrorMessage=" + this.uploadErrorMessage + ")";
    }

    public DetectionUiState(FaceDetectorResult faceDetectorResult, HandLandmarkerResult handLandmarkerResult, int i, int i2, float f, RecordingState recordingState, int i3, String str, Uri uri, boolean z, boolean z2, Integer num, String str2) {
        Intrinsics.checkNotNullParameter(recordingState, "recordingState");
        Intrinsics.checkNotNullParameter(str, "videoName");
        this.faceDetectorResult = faceDetectorResult;
        this.handLandmarkerResult = handLandmarkerResult;
        this.imageHeight = i;
        this.imageWidth = i2;
        this.confidence = f;
        this.recordingState = recordingState;
        this.countdownSeconds = i3;
        this.videoName = str;
        this.recordedVideoUri = uri;
        this.isUploading = z;
        this.uploadSuccess = z2;
        this.uploadError = num;
        this.uploadErrorMessage = str2;
    }

    public final FaceDetectorResult getFaceDetectorResult() {
        return this.faceDetectorResult;
    }

    public final HandLandmarkerResult getHandLandmarkerResult() {
        return this.handLandmarkerResult;
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public /* synthetic */ DetectionUiState(FaceDetectorResult faceDetectorResult, HandLandmarkerResult handLandmarkerResult, int i, int i2, float f, RecordingState recordingState, int i3, String str, Uri uri, boolean z, boolean z2, Integer num, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : faceDetectorResult, (i4 & 2) != 0 ? null : handLandmarkerResult, (i4 & 4) != 0 ? 1 : i, (i4 & 8) == 0 ? i2 : 1, (i4 & 16) != 0 ? 0.0f : f, (i4 & 32) != 0 ? RecordingState.IDLE : recordingState, (i4 & 64) != 0 ? 5 : i3, (i4 & 128) != 0 ? "" : str, (i4 & 256) != 0 ? null : uri, (i4 & 512) != 0 ? false : z, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0 ? z2 : false, (i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? null : num, (i4 & 4096) != 0 ? null : str2);
    }

    public final RecordingState getRecordingState() {
        return this.recordingState;
    }

    public final int getCountdownSeconds() {
        return this.countdownSeconds;
    }

    public final String getVideoName() {
        return this.videoName;
    }

    public final Uri getRecordedVideoUri() {
        return this.recordedVideoUri;
    }

    public final boolean isUploading() {
        return this.isUploading;
    }

    public final boolean getUploadSuccess() {
        return this.uploadSuccess;
    }

    public final Integer getUploadError() {
        return this.uploadError;
    }

    public final String getUploadErrorMessage() {
        return this.uploadErrorMessage;
    }
}
