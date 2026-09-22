package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class CardLayoutPortrait extends BaseModalLayout {
    private static double IMAGE_MAX_HEIGHT_PCT = 0.8d;
    private View actionBarChild;
    private View imageChild;
    private View scrollChild;
    private View titleChild;

    public CardLayoutPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        this.actionBarChild = findChildById(R.id.action_bar);
        int iCalculateBaseWidth = calculateBaseWidth(i);
        int iCalculateBaseHeight = calculateBaseHeight(i2);
        int iRoundToNearest = roundToNearest((int) (IMAGE_MAX_HEIGHT_PCT * ((double) iCalculateBaseHeight)), 4);
        Logging.logd("Measuring image");
        MeasureUtils.measureFullWidth(this.imageChild, iCalculateBaseWidth, iCalculateBaseHeight);
        if (getDesiredHeight(this.imageChild) > iRoundToNearest) {
            Logging.logd("Image exceeded maximum height, remeasuring image");
            MeasureUtils.measureFullHeight(this.imageChild, iCalculateBaseWidth, iRoundToNearest);
        }
        int desiredWidth = getDesiredWidth(this.imageChild);
        Logging.logd("Measuring title");
        MeasureUtils.measureFullWidth(this.titleChild, desiredWidth, iCalculateBaseHeight);
        Logging.logd("Measuring action bar");
        MeasureUtils.measureFullWidth(this.actionBarChild, desiredWidth, iCalculateBaseHeight);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureFullWidth(this.scrollChild, desiredWidth, ((iCalculateBaseHeight - getDesiredHeight(this.imageChild)) - getDesiredHeight(this.titleChild)) - getDesiredHeight(this.actionBarChild));
        int size = getVisibleChildren().size();
        int desiredHeight = 0;
        for (int i3 = 0; i3 < size; i3++) {
            desiredHeight += getDesiredHeight(getVisibleChildren().get(i3));
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int size = getVisibleChildren().size();
        int measuredHeight = 0;
        for (int i5 = 0; i5 < size; i5++) {
            View view = getVisibleChildren().get(i5);
            int measuredHeight2 = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredHeight2 + measuredHeight;
            Logging.logd("Layout child " + i5);
            Logging.logdPair("\t(top, bottom)", measuredHeight, i6);
            Logging.logdPair("\t(left, right)", 0, measuredWidth);
            view.layout(0, measuredHeight, measuredWidth, i6);
            Logging.logdPair("Child " + i5 + " wants to be ", view.getMeasuredWidth(), view.getMeasuredHeight());
            measuredHeight += view.getMeasuredHeight();
        }
    }
}
