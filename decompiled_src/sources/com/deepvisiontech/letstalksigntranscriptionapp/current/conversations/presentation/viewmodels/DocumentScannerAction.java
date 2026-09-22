package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import androidx.camera.core.ImageProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScannerViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction;", "", "PermissionChanged", "CaptureButtonClicked", "ImageCaptured", "CaptureFailed", "EditDialogDismissed", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction$CaptureButtonClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction$CaptureFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction$EditDialogDismissed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction$ImageCaptured;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction$PermissionChanged;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DocumentScannerAction {

    /* JADX INFO: compiled from: DocumentScannerViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction$PermissionChanged;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction;", "isGranted", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionChanged implements DocumentScannerAction {
        public static final int $stable = 0;
        private final boolean isGranted;

        public static /* synthetic */ PermissionChanged copy$default(PermissionChanged permissionChanged, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = permissionChanged.isGranted;
            }
            return permissionChanged.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsGranted() {
            return this.isGranted;
        }

        public final PermissionChanged copy(boolean isGranted) {
            return new PermissionChanged(isGranted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PermissionChanged) && this.isGranted == ((PermissionChanged) other).isGranted;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isGranted);
        }

        public String toString() {
            return "PermissionChanged(isGranted=" + this.isGranted + ")";
        }

        public PermissionChanged(boolean z) {
            this.isGranted = z;
        }

        public final boolean isGranted() {
            return this.isGranted;
        }
    }

    /* JADX INFO: compiled from: DocumentScannerViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction$CaptureButtonClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CaptureButtonClicked implements DocumentScannerAction {
        public static final int $stable = 0;
        public static final CaptureButtonClicked INSTANCE = new CaptureButtonClicked();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CaptureButtonClicked)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2054349975;
        }

        public String toString() {
            return "CaptureButtonClicked";
        }

        private CaptureButtonClicked() {
        }
    }

    /* JADX INFO: compiled from: DocumentScannerViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction$ImageCaptured;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction;", "imageProxy", "Landroidx/camera/core/ImageProxy;", "<init>", "(Landroidx/camera/core/ImageProxy;)V", "getImageProxy", "()Landroidx/camera/core/ImageProxy;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ImageCaptured implements DocumentScannerAction {
        public static final int $stable = 8;
        private final ImageProxy imageProxy;

        public static /* synthetic */ ImageCaptured copy$default(ImageCaptured imageCaptured, ImageProxy imageProxy, int i, Object obj) {
            if ((i & 1) != 0) {
                imageProxy = imageCaptured.imageProxy;
            }
            return imageCaptured.copy(imageProxy);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ImageProxy getImageProxy() {
            return this.imageProxy;
        }

        public final ImageCaptured copy(ImageProxy imageProxy) {
            Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
            return new ImageCaptured(imageProxy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ImageCaptured) && Intrinsics.areEqual(this.imageProxy, ((ImageCaptured) other).imageProxy);
        }

        public int hashCode() {
            return this.imageProxy.hashCode();
        }

        public String toString() {
            return "ImageCaptured(imageProxy=" + this.imageProxy + ")";
        }

        public ImageCaptured(ImageProxy imageProxy) {
            Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
            this.imageProxy = imageProxy;
        }

        public final ImageProxy getImageProxy() {
            return this.imageProxy;
        }
    }

    /* JADX INFO: compiled from: DocumentScannerViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction$CaptureFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction;", "error", "", "<init>", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CaptureFailed implements DocumentScannerAction {
        public static final int $stable = 0;
        private final String error;

        public static /* synthetic */ CaptureFailed copy$default(CaptureFailed captureFailed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = captureFailed.error;
            }
            return captureFailed.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getError() {
            return this.error;
        }

        public final CaptureFailed copy(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new CaptureFailed(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CaptureFailed) && Intrinsics.areEqual(this.error, ((CaptureFailed) other).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "CaptureFailed(error=" + this.error + ")";
        }

        public CaptureFailed(String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            this.error = str;
        }

        public final String getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: DocumentScannerViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction$EditDialogDismissed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EditDialogDismissed implements DocumentScannerAction {
        public static final int $stable = 0;
        public static final EditDialogDismissed INSTANCE = new EditDialogDismissed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditDialogDismissed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1427523869;
        }

        public String toString() {
            return "EditDialogDismissed";
        }

        private EditDialogDismissed() {
        }
    }
}
