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
public class CardLayoutLandscape extends BaseModalLayout {
    private static double IMAGE_MAX_WIDTH_PCT = 0.6d;
    private View actionBarChild;
    private View imageChild;
    private View scrollChild;
    private View titleChild;

    public CardLayoutLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        View viewFindChildById = findChildById(R.id.action_bar);
        this.actionBarChild = viewFindChildById;
        int iMax = 0;
        List listAsList = Arrays.asList(this.titleChild, this.scrollChild, viewFindChildById);
        int iCalculateBaseWidth = calculateBaseWidth(i);
        int iCalculateBaseHeight = calculateBaseHeight(i2);
        int iRoundToNearest = roundToNearest((int) (IMAGE_MAX_WIDTH_PCT * ((double) iCalculateBaseWidth)), 4);
        Logging.logd("Measuring image");
        MeasureUtils.measureFullHeight(this.imageChild, iCalculateBaseWidth, iCalculateBaseHeight);
        if (getDesiredWidth(this.imageChild) > iRoundToNearest) {
            Logging.logd("Image exceeded maximum width, remeasuring image");
            MeasureUtils.measureFullWidth(this.imageChild, iRoundToNearest, iCalculateBaseHeight);
        }
        int desiredHeight = getDesiredHeight(this.imageChild);
        int desiredWidth = getDesiredWidth(this.imageChild);
        int i3 = iCalculateBaseWidth - desiredWidth;
        float f = desiredWidth;
        Logging.logdPair("Max col widths (l, r)", f, i3);
        Logging.logd("Measuring title");
        MeasureUtils.measureAtMost(this.titleChild, i3, desiredHeight);
        Logging.logd("Measuring action bar");
        MeasureUtils.measureAtMost(this.actionBarChild, i3, desiredHeight);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureFullHeight(this.scrollChild, i3, (desiredHeight - getDesiredHeight(this.titleChild)) - getDesiredHeight(this.actionBarChild));
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            iMax = Math.max(getDesiredWidth((View) it.next()), iMax);
        }
        Logging.logdPair("Measured columns (l, r)", f, iMax);
        int i4 = desiredWidth + iMax;
        Logging.logdPair("Measured dims", i4, desiredHeight);
        setMeasuredDimension(i4, desiredHeight);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Logging.logd("Layout image");
        int desiredWidth = getDesiredWidth(this.imageChild);
        layoutChild(this.imageChild, 0, 0, desiredWidth, getDesiredHeight(this.imageChild));
        Logging.logd("Layout title");
        int desiredHeight = getDesiredHeight(this.titleChild);
        layoutChild(this.titleChild, desiredWidth, 0, measuredWidth, desiredHeight);
        Logging.logd("Layout scroll");
        layoutChild(this.scrollChild, desiredWidth, desiredHeight, measuredWidth, desiredHeight + getDesiredHeight(this.scrollChild));
        Logging.logd("Layout action bar");
        layoutChild(this.actionBarChild, desiredWidth, measuredHeight - getDesiredHeight(this.actionBarChild), measuredWidth, measuredHeight);
    }
}
