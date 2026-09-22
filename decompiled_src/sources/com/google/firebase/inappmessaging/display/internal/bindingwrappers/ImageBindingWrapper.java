package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ImageBindingWrapper extends BindingWrapper {
    private Button collapseButton;
    private ViewGroup imageContentRoot;
    private FiamFrameLayout imageRoot;
    private ImageView imageView;

    @Inject
    public ImageBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View viewInflate = this.inflater.inflate(R.layout.image, (ViewGroup) null);
        this.imageRoot = (FiamFrameLayout) viewInflate.findViewById(R.id.image_root);
        this.imageContentRoot = (ViewGroup) viewInflate.findViewById(R.id.image_content_root);
        this.imageView = (ImageView) viewInflate.findViewById(R.id.image_view);
        this.collapseButton = (Button) viewInflate.findViewById(R.id.collapse_button);
        this.imageView.setMaxHeight(this.config.getMaxImageHeight());
        this.imageView.setMaxWidth(this.config.getMaxImageWidth());
        if (this.message.getMessageType().equals(MessageType.IMAGE_ONLY)) {
            ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) this.message;
            this.imageView.setVisibility((imageOnlyMessage.getImageData() == null || TextUtils.isEmpty(imageOnlyMessage.getImageData().getImageUrl())) ? 8 : 0);
            this.imageView.setOnClickListener(map.get(imageOnlyMessage.getAction()));
        }
        this.imageRoot.setDismissListener(onClickListener);
        this.collapseButton.setOnClickListener(onClickListener);
        return null;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ImageView getImageView() {
        return this.imageView;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewGroup getRootView() {
        return this.imageRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getDialogView() {
        return this.imageContentRoot;
    }

    public View getCollapseButton() {
        return this.collapseButton;
    }
}
