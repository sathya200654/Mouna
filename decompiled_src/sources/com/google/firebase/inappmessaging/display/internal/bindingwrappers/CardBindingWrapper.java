package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout;
import com.google.firebase.inappmessaging.display.internal.layout.FiamCardView;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class CardBindingWrapper extends BindingWrapper {
    private ScrollView bodyScroll;
    private BaseModalLayout cardContentRoot;
    private CardMessage cardMessage;
    private FiamCardView cardRoot;
    private View.OnClickListener dismissListener;
    private ImageView imageView;
    private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private TextView messageBody;
    private TextView messageTitle;
    private Button primaryButton;
    private Button secondaryButton;

    @Inject
    public CardBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
        this.layoutListener = new ScrollViewAdjustableListener();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View viewInflate = this.inflater.inflate(R.layout.card, (ViewGroup) null);
        this.bodyScroll = (ScrollView) viewInflate.findViewById(R.id.body_scroll);
        this.primaryButton = (Button) viewInflate.findViewById(R.id.primary_button);
        this.secondaryButton = (Button) viewInflate.findViewById(R.id.secondary_button);
        this.imageView = (ImageView) viewInflate.findViewById(R.id.image_view);
        this.messageBody = (TextView) viewInflate.findViewById(R.id.message_body);
        this.messageTitle = (TextView) viewInflate.findViewById(R.id.message_title);
        this.cardRoot = (FiamCardView) viewInflate.findViewById(R.id.card_root);
        this.cardContentRoot = (BaseModalLayout) viewInflate.findViewById(R.id.card_content_root);
        if (this.message.getMessageType().equals(MessageType.CARD)) {
            CardMessage cardMessage = (CardMessage) this.message;
            this.cardMessage = cardMessage;
            setMessage(cardMessage);
            setImage(this.cardMessage);
            setButtons(map);
            setLayoutConfig(this.config);
            setDismissListener(onClickListener);
            setViewBgColorFromHex(this.cardContentRoot, this.cardMessage.getBackgroundHexColor());
        }
        return this.layoutListener;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ImageView getImageView() {
        return this.imageView;
    }

    public View getScrollView() {
        return this.bodyScroll;
    }

    public View getTitleView() {
        return this.messageTitle;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewGroup getRootView() {
        return this.cardRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getDialogView() {
        return this.cardContentRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View.OnClickListener getDismissListener() {
        return this.dismissListener;
    }

    public Button getPrimaryButton() {
        return this.primaryButton;
    }

    public Button getSecondaryButton() {
        return this.secondaryButton;
    }

    private void setMessage(CardMessage cardMessage) {
        this.messageTitle.setText(cardMessage.getTitle().getText());
        this.messageTitle.setTextColor(Color.parseColor(cardMessage.getTitle().getHexColor()));
        if (cardMessage.getBody() != null && cardMessage.getBody().getText() != null) {
            this.bodyScroll.setVisibility(0);
            this.messageBody.setVisibility(0);
            this.messageBody.setText(cardMessage.getBody().getText());
            this.messageBody.setTextColor(Color.parseColor(cardMessage.getBody().getHexColor()));
            return;
        }
        this.bodyScroll.setVisibility(8);
        this.messageBody.setVisibility(8);
    }

    private void setButtons(Map<Action, View.OnClickListener> map) {
        Action primaryAction = this.cardMessage.getPrimaryAction();
        Action secondaryAction = this.cardMessage.getSecondaryAction();
        setupViewButtonFromModel(this.primaryButton, primaryAction.getButton());
        setButtonActionListener(this.primaryButton, map.get(primaryAction));
        this.primaryButton.setVisibility(0);
        if (secondaryAction != null && secondaryAction.getButton() != null) {
            setupViewButtonFromModel(this.secondaryButton, secondaryAction.getButton());
            setButtonActionListener(this.secondaryButton, map.get(secondaryAction));
            this.secondaryButton.setVisibility(0);
            return;
        }
        this.secondaryButton.setVisibility(8);
    }

    private void setImage(CardMessage cardMessage) {
        if (cardMessage.getPortraitImageData() != null || cardMessage.getLandscapeImageData() != null) {
            this.imageView.setVisibility(0);
        } else {
            this.imageView.setVisibility(8);
        }
    }

    private void setLayoutConfig(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        this.imageView.setMaxHeight(inAppMessageLayoutConfig.getMaxImageHeight());
        this.imageView.setMaxWidth(inAppMessageLayoutConfig.getMaxImageWidth());
    }

    private void setDismissListener(View.OnClickListener onClickListener) {
        this.dismissListener = onClickListener;
        this.cardRoot.setDismissListener(onClickListener);
    }

    public void setLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.layoutListener = onGlobalLayoutListener;
    }

    public class ScrollViewAdjustableListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public ScrollViewAdjustableListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            CardBindingWrapper.this.imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }
}
