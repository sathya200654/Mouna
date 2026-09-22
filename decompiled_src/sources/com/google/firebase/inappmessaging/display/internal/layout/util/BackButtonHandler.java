package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class BackButtonHandler {
    private View.OnClickListener listener;
    private ViewGroup viewGroup;

    public BackButtonHandler(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.viewGroup = viewGroup;
        this.listener = onClickListener;
    }

    public Boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return null;
        }
        View.OnClickListener onClickListener = this.listener;
        if (onClickListener != null) {
            onClickListener.onClick(this.viewGroup);
            return true;
        }
        return false;
    }
}
