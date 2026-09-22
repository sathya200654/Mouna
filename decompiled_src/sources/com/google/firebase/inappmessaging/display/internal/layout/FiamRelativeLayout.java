package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.firebase.inappmessaging.display.internal.layout.util.BackButtonHandler;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class FiamRelativeLayout extends RelativeLayout implements BackButtonLayout {
    private BackButtonHandler mBackHandler;

    public FiamRelativeLayout(Context context) {
        super(context);
    }

    public FiamRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FiamRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FiamRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BackButtonLayout
    public void setDismissListener(View.OnClickListener onClickListener) {
        this.mBackHandler = new BackButtonHandler(this, onClickListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean boolDispatchKeyEvent = this.mBackHandler.dispatchKeyEvent(keyEvent);
        if (boolDispatchKeyEvent != null) {
            return boolDispatchKeyEvent.booleanValue();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
