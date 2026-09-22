package com.google.firebase.inappmessaging.display.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ResizableImageView extends AppCompatImageView {
    private int mDensityDpi;

    public ResizableImageView(Context context) {
        super(context);
        init(context);
    }

    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ResizableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mDensityDpi = (int) (context.getResources().getDisplayMetrics().density * 160.0f);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Drawable drawable = getDrawable();
        boolean adjustViewBounds = getAdjustViewBounds();
        if (drawable == null || !adjustViewBounds) {
            return;
        }
        scalePxToDp(drawable);
        checkMinDim();
    }

    private void checkMinDim() {
        int iMax = Math.max(getMinimumWidth(), getSuggestedMinimumWidth());
        int iMax2 = Math.max(getMinimumHeight(), getSuggestedMinimumHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = iMax;
        float f2 = iMax2;
        Logging.logdPair("Image: min width, height", f, f2);
        float f3 = measuredWidth;
        float f4 = measuredHeight;
        Logging.logdPair("Image: actual width, height", f3, f4);
        float f5 = measuredWidth < iMax ? f / f3 : 1.0f;
        float f6 = measuredHeight < iMax2 ? f2 / f4 : 1.0f;
        if (f5 <= f6) {
            f5 = f6;
        }
        if (f5 > 1.0d) {
            int iCeil = (int) Math.ceil(f3 * f5);
            int iCeil2 = (int) Math.ceil(f4 * f5);
            Logging.logd("Measured dimension (" + measuredWidth + "x" + measuredHeight + ") too small.  Resizing to " + iCeil + "x" + iCeil2);
            Dimensions dimensionsBound = bound(iCeil, iCeil2);
            setMeasuredDimension(dimensionsBound.w, dimensionsBound.h);
        }
    }

    private void scalePxToDp(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Logging.logdPair("Image: intrinsic width, height", intrinsicWidth, intrinsicHeight);
        Dimensions dimensionsBound = bound((int) Math.ceil((intrinsicWidth * this.mDensityDpi) / 160), (int) Math.ceil((intrinsicHeight * this.mDensityDpi) / 160));
        Logging.logdPair("Image: new target dimensions", dimensionsBound.w, dimensionsBound.h);
        setMeasuredDimension(dimensionsBound.w, dimensionsBound.h);
    }

    private Dimensions bound(int i, int i2) {
        int maxWidth = getMaxWidth();
        int maxHeight = getMaxHeight();
        if (i > maxWidth) {
            Logging.logdNumber("Image: capping width", maxWidth);
            i2 = (i2 * maxWidth) / i;
            i = maxWidth;
        }
        if (i2 > maxHeight) {
            Logging.logdNumber("Image: capping height", maxHeight);
            i = (i * maxHeight) / i2;
        } else {
            maxHeight = i2;
        }
        return new Dimensions(i, maxHeight);
    }

    private static class Dimensions {
        final int h;
        final int w;

        private Dimensions(int i, int i2) {
            this.w = i;
            this.h = i2;
        }
    }
}
