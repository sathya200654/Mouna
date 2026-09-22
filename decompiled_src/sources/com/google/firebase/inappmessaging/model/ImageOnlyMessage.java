package com.google.firebase.inappmessaging.model;

import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ImageOnlyMessage extends InAppMessage {

    @Nullable
    private Action action;
    private ImageData imageData;

    public int hashCode() {
        Action action = this.action;
        return this.imageData.hashCode() + (action != null ? action.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageOnlyMessage)) {
            return false;
        }
        ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) obj;
        if (hashCode() != imageOnlyMessage.hashCode()) {
            return false;
        }
        Action action = this.action;
        return (action != null || imageOnlyMessage.action == null) && (action == null || action.equals(imageOnlyMessage.action)) && this.imageData.equals(imageOnlyMessage.imageData);
    }

    private ImageOnlyMessage(CampaignMetadata campaignMetadata, ImageData imageData, @Nullable Action action, @Nullable Map<String, String> map) {
        super(campaignMetadata, MessageType.IMAGE_ONLY, map);
        this.imageData = imageData;
        this.action = action;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public ImageData getImageData() {
        return this.imageData;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public Action getAction() {
        return this.action;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        @Nullable
        Action action;

        @Nullable
        ImageData imageData;

        public Builder setImageData(@Nullable ImageData imageData) {
            this.imageData = imageData;
            return this;
        }

        public Builder setAction(@Nullable Action action) {
            this.action = action;
            return this;
        }

        public ImageOnlyMessage build(CampaignMetadata campaignMetadata, @Nullable Map<String, String> map) {
            if (this.imageData == null) {
                throw new IllegalArgumentException("ImageOnly model must have image data");
            }
            return new ImageOnlyMessage(campaignMetadata, this.imageData, this.action, map);
        }
    }
}
