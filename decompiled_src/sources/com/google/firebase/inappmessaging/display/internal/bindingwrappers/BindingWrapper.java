package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class BindingWrapper {
    final InAppMessageLayoutConfig config;
    final LayoutInflater inflater;
    protected final InAppMessage message;

    public boolean canSwipeToDismiss() {
        return false;
    }

    public abstract View getDialogView();

    public View.OnClickListener getDismissListener() {
        return null;
    }

    public abstract ImageView getImageView();

    public abstract ViewGroup getRootView();

    public abstract ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener);

    protected BindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        this.config = inAppMessageLayoutConfig;
        this.inflater = layoutInflater;
        this.message = inAppMessage;
    }

    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    protected void setViewBgColorFromHex(View view, String str) {
        if (view == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            view.setBackgroundColor(Color.parseColor(str));
        } catch (IllegalArgumentException e) {
            Logging.loge("Error parsing background color: " + e.toString() + " color: " + str);
        }
    }

    public static void setButtonBgColorFromHex(Button button, String str) {
        try {
            Drawable drawableWrap = DrawableCompat.wrap(button.getBackground());
            DrawableCompat.setTint(drawableWrap, Color.parseColor(str));
            button.setBackground(drawableWrap);
        } catch (IllegalArgumentException e) {
            Logging.loge("Error parsing background color: " + e.toString());
        }
    }

    public static void setupViewButtonFromModel(Button button, com.google.firebase.inappmessaging.model.Button button2) {
        String hexColor = button2.getText().getHexColor();
        setButtonBgColorFromHex(button, button2.getButtonHexColor());
        button.setText(button2.getText().getText());
        button.setTextColor(Color.parseColor(hexColor));
    }

    protected void setButtonActionListener(Button button, View.OnClickListener onClickListener) {
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
    }
}
