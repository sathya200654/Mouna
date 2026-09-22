package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import androidx.camera.core.SurfaceRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScannerViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerState;", "", "surfaceRequest", "Landroidx/camera/core/SurfaceRequest;", "isCapturing", "", "isPermissionGranted", "isEditDialogVisible", "scannedText", "", "<init>", "(Landroidx/camera/core/SurfaceRequest;ZZZLjava/lang/String;)V", "getSurfaceRequest", "()Landroidx/camera/core/SurfaceRequest;", "()Z", "getScannedText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DocumentScannerState {
    public static final int $stable = 8;
    private final boolean isCapturing;
    private final boolean isEditDialogVisible;
    private final boolean isPermissionGranted;
    private final String scannedText;
    private final SurfaceRequest surfaceRequest;

    public DocumentScannerState() {
        this(null, false, false, false, null, 31, null);
    }

    public static /* synthetic */ DocumentScannerState copy$default(DocumentScannerState documentScannerState, SurfaceRequest surfaceRequest, boolean z, boolean z2, boolean z3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            surfaceRequest = documentScannerState.surfaceRequest;
        }
        if ((i & 2) != 0) {
            z = documentScannerState.isCapturing;
        }
        if ((i & 4) != 0) {
            z2 = documentScannerState.isPermissionGranted;
        }
        if ((i & 8) != 0) {
            z3 = documentScannerState.isEditDialogVisible;
        }
        if ((i & 16) != 0) {
            str = documentScannerState.scannedText;
        }
        String str2 = str;
        boolean z4 = z2;
        return documentScannerState.copy(surfaceRequest, z, z4, z3, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SurfaceRequest getSurfaceRequest() {
        return this.surfaceRequest;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsCapturing() {
        return this.isCapturing;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsPermissionGranted() {
        return this.isPermissionGranted;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsEditDialogVisible() {
        return this.isEditDialogVisible;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getScannedText() {
        return this.scannedText;
    }

    public final DocumentScannerState copy(SurfaceRequest surfaceRequest, boolean isCapturing, boolean isPermissionGranted, boolean isEditDialogVisible, String scannedText) {
        Intrinsics.checkNotNullParameter(scannedText, "scannedText");
        return new DocumentScannerState(surfaceRequest, isCapturing, isPermissionGranted, isEditDialogVisible, scannedText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentScannerState)) {
            return false;
        }
        DocumentScannerState documentScannerState = (DocumentScannerState) other;
        return Intrinsics.areEqual(this.surfaceRequest, documentScannerState.surfaceRequest) && this.isCapturing == documentScannerState.isCapturing && this.isPermissionGranted == documentScannerState.isPermissionGranted && this.isEditDialogVisible == documentScannerState.isEditDialogVisible && Intrinsics.areEqual(this.scannedText, documentScannerState.scannedText);
    }

    public int hashCode() {
        SurfaceRequest surfaceRequest = this.surfaceRequest;
        return ((((((((surfaceRequest == null ? 0 : surfaceRequest.hashCode()) * 31) + Boolean.hashCode(this.isCapturing)) * 31) + Boolean.hashCode(this.isPermissionGranted)) * 31) + Boolean.hashCode(this.isEditDialogVisible)) * 31) + this.scannedText.hashCode();
    }

    public String toString() {
        return "DocumentScannerState(surfaceRequest=" + this.surfaceRequest + ", isCapturing=" + this.isCapturing + ", isPermissionGranted=" + this.isPermissionGranted + ", isEditDialogVisible=" + this.isEditDialogVisible + ", scannedText=" + this.scannedText + ")";
    }

    public DocumentScannerState(SurfaceRequest surfaceRequest, boolean z, boolean z2, boolean z3, String str) {
        Intrinsics.checkNotNullParameter(str, "scannedText");
        this.surfaceRequest = surfaceRequest;
        this.isCapturing = z;
        this.isPermissionGranted = z2;
        this.isEditDialogVisible = z3;
        this.scannedText = str;
    }

    public final SurfaceRequest getSurfaceRequest() {
        return this.surfaceRequest;
    }

    public final boolean isCapturing() {
        return this.isCapturing;
    }

    public final boolean isPermissionGranted() {
        return this.isPermissionGranted;
    }

    public final boolean isEditDialogVisible() {
        return this.isEditDialogVisible;
    }

    public /* synthetic */ DocumentScannerState(SurfaceRequest surfaceRequest, boolean z, boolean z2, boolean z3, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : surfaceRequest, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? "" : str);
    }

    public final String getScannedText() {
        return this.scannedText;
    }
}
