package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUploadViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/ProcessedFrame;", "", "bitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "<init>", "(Landroid/graphics/Bitmap;II)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ProcessedFrame {
    public static final int $stable = 8;
    private final Bitmap bitmap;
    private final int height;
    private final int width;

    public static /* synthetic */ ProcessedFrame copy$default(ProcessedFrame processedFrame, Bitmap bitmap, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bitmap = processedFrame.bitmap;
        }
        if ((i3 & 2) != 0) {
            i = processedFrame.width;
        }
        if ((i3 & 4) != 0) {
            i2 = processedFrame.height;
        }
        return processedFrame.copy(bitmap, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final ProcessedFrame copy(Bitmap bitmap, int width, int height) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new ProcessedFrame(bitmap, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessedFrame)) {
            return false;
        }
        ProcessedFrame processedFrame = (ProcessedFrame) other;
        return Intrinsics.areEqual(this.bitmap, processedFrame.bitmap) && this.width == processedFrame.width && this.height == processedFrame.height;
    }

    public int hashCode() {
        return (((this.bitmap.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "ProcessedFrame(bitmap=" + this.bitmap + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public ProcessedFrame(Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
        this.width = i;
        this.height = i2;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }
}
