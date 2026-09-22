package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ModalLayoutLandscape extends BaseModalLayout {
    private static final int ITEM_SPACING_DP = 24;
    private static final float MAX_IMG_WIDTH_PCT = 0.4f;
    private int barrierWidth;
    private View buttonChild;
    private View imageChild;
    private int leftContentHeight;
    private int rightContentHeight;
    private View scrollChild;
    private View titleChild;
    private int vertItemSpacing;

    public ModalLayoutLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        this.buttonChild = findChildById(R.id.button);
        int iMax = 0;
        this.barrierWidth = this.imageChild.getVisibility() == 8 ? 0 : dpToPixels(24);
        this.vertItemSpacing = dpToPixels(24);
        List listAsList = Arrays.asList(this.titleChild, this.scrollChild, this.buttonChild);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iCalculateBaseWidth = calculateBaseWidth(i);
        int iCalculateBaseHeight = calculateBaseHeight(i2) - paddingBottom;
        int i3 = iCalculateBaseWidth - paddingLeft;
        Logging.logd("Measuring image");
        MeasureUtils.measureAtMost(this.imageChild, (int) (i3 * MAX_IMG_WIDTH_PCT), iCalculateBaseHeight);
        int desiredWidth = getDesiredWidth(this.imageChild);
        int i4 = i3 - (this.barrierWidth + desiredWidth);
        float f = desiredWidth;
        Logging.logdPair("Max col widths (l, r)", f, i4);
        Iterator it = listAsList.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() != 8) {
                i5++;
            }
        }
        int iMax2 = Math.max(0, (i5 - 1) * this.vertItemSpacing);
        int i6 = iCalculateBaseHeight - iMax2;
        Logging.logd("Measuring getTitle");
        MeasureUtils.measureAtMost(this.titleChild, i4, i6);
        Logging.logd("Measuring button");
        MeasureUtils.measureAtMost(this.buttonChild, i4, i6);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureAtMost(this.scrollChild, i4, (i6 - getDesiredHeight(this.titleChild)) - getDesiredHeight(this.buttonChild));
        this.leftContentHeight = getDesiredHeight(this.imageChild);
        this.rightContentHeight = iMax2;
        Iterator it2 = listAsList.iterator();
        while (it2.hasNext()) {
            this.rightContentHeight += getDesiredHeight((View) it2.next());
        }
        int iMax3 = Math.max(this.leftContentHeight + paddingBottom, this.rightContentHeight + paddingBottom);
        Iterator it3 = listAsList.iterator();
        while (it3.hasNext()) {
            iMax = Math.max(getDesiredWidth((View) it3.next()), iMax);
        }
        Logging.logdPair("Measured columns (l, r)", f, iMax);
        int i7 = desiredWidth + iMax + this.barrierWidth + paddingLeft;
        Logging.logdPair("Measured dims", i7, iMax3);
        setMeasuredDimension(i7, iMax3);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i7 = this.leftContentHeight;
        int i8 = this.rightContentHeight;
        if (i7 < i8) {
            i6 = (i8 - i7) / 2;
            i5 = 0;
        } else {
            i5 = (i7 - i8) / 2;
            i6 = 0;
        }
        Logging.logd("Layout image");
        int i9 = i6 + paddingTop;
        int desiredWidth = paddingLeft + getDesiredWidth(this.imageChild);
        layoutChild(this.imageChild, paddingLeft, i9, desiredWidth, i9 + getDesiredHeight(this.imageChild));
        int i10 = desiredWidth + this.barrierWidth;
        Logging.logd("Layout getTitle");
        int i11 = paddingTop + i5;
        int desiredHeight = i11 + getDesiredHeight(this.titleChild);
        layoutChild(this.titleChild, i10, i11, measuredWidth, desiredHeight);
        Logging.logd("Layout getBody");
        int i12 = desiredHeight + (this.titleChild.getVisibility() == 8 ? 0 : this.vertItemSpacing);
        int desiredHeight2 = i12 + getDesiredHeight(this.scrollChild);
        layoutChild(this.scrollChild, i10, i12, measuredWidth, desiredHeight2);
        Logging.logd("Layout button");
        layoutChild(this.buttonChild, i10, desiredHeight2 + (this.scrollChild.getVisibility() != 8 ? this.vertItemSpacing : 0));
    }

    protected void layoutCenterHorizontal(View view, int i, int i2, int i3, int i4) {
        int measuredWidth = view.getMeasuredWidth() / 2;
        int i5 = i + ((i3 - i) / 2);
        layoutChild(view, i5 - measuredWidth, i2, i5 + measuredWidth, i4);
    }
}
