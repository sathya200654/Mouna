package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.internal.Logging;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Singleton
public class ProtoMarshallerClient {
    @Inject
    ProtoMarshallerClient() {
    }

    private static ModalMessage.Builder from(MessagesProto.ModalMessage modalMessage) {
        ModalMessage.Builder builder = ModalMessage.builder();
        if (!TextUtils.isEmpty(modalMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(modalMessage.getBackgroundHexColor());
        }
        if (!TextUtils.isEmpty(modalMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(modalMessage.getImageUrl()).build());
        }
        if (modalMessage.hasAction()) {
            builder.setAction(decode(modalMessage.getAction(), modalMessage.getActionButton()));
        }
        if (modalMessage.hasBody()) {
            builder.setBody(decode(modalMessage.getBody()));
        }
        if (modalMessage.hasTitle()) {
            builder.setTitle(decode(modalMessage.getTitle()));
        }
        return builder;
    }

    private static ImageOnlyMessage.Builder from(MessagesProto.ImageOnlyMessage imageOnlyMessage) {
        ImageOnlyMessage.Builder builder = ImageOnlyMessage.builder();
        if (!TextUtils.isEmpty(imageOnlyMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(imageOnlyMessage.getImageUrl()).build());
        }
        if (imageOnlyMessage.hasAction()) {
            builder.setAction(decode(imageOnlyMessage.getAction()).build());
        }
        return builder;
    }

    private static BannerMessage.Builder from(MessagesProto.BannerMessage bannerMessage) {
        BannerMessage.Builder builder = BannerMessage.builder();
        if (!TextUtils.isEmpty(bannerMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(bannerMessage.getBackgroundHexColor());
        }
        if (!TextUtils.isEmpty(bannerMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(bannerMessage.getImageUrl()).build());
        }
        if (bannerMessage.hasAction()) {
            builder.setAction(decode(bannerMessage.getAction()).build());
        }
        if (bannerMessage.hasBody()) {
            builder.setBody(decode(bannerMessage.getBody()));
        }
        if (bannerMessage.hasTitle()) {
            builder.setTitle(decode(bannerMessage.getTitle()));
        }
        return builder;
    }

    private static CardMessage.Builder from(MessagesProto.CardMessage cardMessage) {
        CardMessage.Builder builder = CardMessage.builder();
        if (cardMessage.hasTitle()) {
            builder.setTitle(decode(cardMessage.getTitle()));
        }
        if (cardMessage.hasBody()) {
            builder.setBody(decode(cardMessage.getBody()));
        }
        if (!TextUtils.isEmpty(cardMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(cardMessage.getBackgroundHexColor());
        }
        if (cardMessage.hasPrimaryAction() || cardMessage.hasPrimaryActionButton()) {
            builder.setPrimaryAction(decode(cardMessage.getPrimaryAction(), cardMessage.getPrimaryActionButton()));
        }
        if (cardMessage.hasSecondaryAction() || cardMessage.hasSecondaryActionButton()) {
            builder.setSecondaryAction(decode(cardMessage.getSecondaryAction(), cardMessage.getSecondaryActionButton()));
        }
        if (!TextUtils.isEmpty(cardMessage.getPortraitImageUrl())) {
            builder.setPortraitImageData(ImageData.builder().setImageUrl(cardMessage.getPortraitImageUrl()).build());
        }
        if (!TextUtils.isEmpty(cardMessage.getLandscapeImageUrl())) {
            builder.setLandscapeImageData(ImageData.builder().setImageUrl(cardMessage.getLandscapeImageUrl()).build());
        }
        return builder;
    }

    private static Button decode(MessagesProto.Button button) {
        Button.Builder builder = Button.builder();
        if (!TextUtils.isEmpty(button.getButtonHexColor())) {
            builder.setButtonHexColor(button.getButtonHexColor());
        }
        if (button.hasText()) {
            builder.setText(decode(button.getText()));
        }
        return builder.build();
    }

    private static Action decode(MessagesProto.Action action, MessagesProto.Button button) {
        Action.Builder builderDecode = decode(action);
        if (!button.equals(MessagesProto.Button.getDefaultInstance())) {
            Button.Builder builder = Button.builder();
            if (!TextUtils.isEmpty(button.getButtonHexColor())) {
                builder.setButtonHexColor(button.getButtonHexColor());
            }
            if (button.hasText()) {
                Text.Builder builder2 = Text.builder();
                MessagesProto.Text text = button.getText();
                if (!TextUtils.isEmpty(text.getText())) {
                    builder2.setText(text.getText());
                }
                if (!TextUtils.isEmpty(text.getHexColor())) {
                    builder2.setHexColor(text.getHexColor());
                }
                builder.setText(builder2.build());
            }
            builderDecode.setButton(builder.build());
        }
        return builderDecode.build();
    }

    private static Action.Builder decode(MessagesProto.Action action) {
        Action.Builder builder = Action.builder();
        if (!TextUtils.isEmpty(action.getActionUrl())) {
            builder.setActionUrl(action.getActionUrl());
        }
        return builder;
    }

    private static Text decode(MessagesProto.Text text) {
        Text.Builder builder = Text.builder();
        if (!TextUtils.isEmpty(text.getHexColor())) {
            builder.setHexColor(text.getHexColor());
        }
        if (!TextUtils.isEmpty(text.getText())) {
            builder.setText(text.getText());
        }
        return builder.build();
    }

    public static InAppMessage decode(MessagesProto.Content content, String str, String str2, boolean z, Map<String, String> map) {
        Preconditions.checkNotNull(content, "FirebaseInAppMessaging content cannot be null.");
        Preconditions.checkNotNull(str, "FirebaseInAppMessaging campaign id cannot be null.");
        Preconditions.checkNotNull(str2, "FirebaseInAppMessaging campaign name cannot be null.");
        Logging.logd("Decoding message: " + content.toString());
        CampaignMetadata campaignMetadata = new CampaignMetadata(str, str2, z);
        int i = AnonymousClass2.$SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[content.getMessageDetailsCase().ordinal()];
        if (i == 1) {
            return from(content.getBanner()).build(campaignMetadata, map);
        }
        if (i == 2) {
            return from(content.getImageOnly()).build(campaignMetadata, map);
        }
        if (i == 3) {
            return from(content.getModal()).build(campaignMetadata, map);
        }
        if (i == 4) {
            return from(content.getCard()).build(campaignMetadata, map);
        }
        return new InAppMessage(new CampaignMetadata(str, str2, z), MessageType.UNSUPPORTED, map) { // from class: com.google.firebase.inappmessaging.model.ProtoMarshallerClient.1
            @Override // com.google.firebase.inappmessaging.model.InAppMessage
            public Action getAction() {
                return null;
            }
        };
    }

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.model.ProtoMarshallerClient$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase;

        static {
            int[] iArr = new int[MessagesProto.Content.MessageDetailsCase.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase = iArr;
            try {
                iArr[MessagesProto.Content.MessageDetailsCase.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.IMAGE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto.Content.MessageDetailsCase.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
