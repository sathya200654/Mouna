package com.google.firebase.inappmessaging.display.internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class InAppMessageLayoutConfig {
    private Boolean animate;
    private Boolean autoDismiss;
    private Boolean backgroundEnabled;
    private Float maxBodyHeightWeight;
    private Float maxBodyWidthWeight;
    private Integer maxDialogHeightPx;
    private Integer maxDialogWidthPx;
    private Float maxImageHeightWeight;
    private Float maxImageWidthWeight;
    private Integer viewWindowGravity;
    private Integer windowFlag;
    private Integer windowHeight;
    private Integer windowWidth;

    public static Builder builder() {
        return new Builder();
    }

    public Float maxImageHeightWeight() {
        return this.maxImageHeightWeight;
    }

    public Float maxImageWidthWeight() {
        return this.maxImageWidthWeight;
    }

    public Float maxBodyHeightWeight() {
        return this.maxBodyHeightWeight;
    }

    public Float maxBodyWidthWeight() {
        return this.maxBodyWidthWeight;
    }

    public Integer maxDialogHeightPx() {
        return this.maxDialogHeightPx;
    }

    public Integer maxDialogWidthPx() {
        return this.maxDialogWidthPx;
    }

    public Integer windowFlag() {
        return this.windowFlag;
    }

    public Integer viewWindowGravity() {
        return this.viewWindowGravity;
    }

    public Integer windowWidth() {
        return this.windowWidth;
    }

    public Integer windowHeight() {
        return this.windowHeight;
    }

    public Boolean backgroundEnabled() {
        return this.backgroundEnabled;
    }

    public Boolean animate() {
        return this.animate;
    }

    public Boolean autoDismiss() {
        return this.autoDismiss;
    }

    public int getMaxImageHeight() {
        return (int) (maxImageHeightWeight().floatValue() * maxDialogHeightPx().intValue());
    }

    public int getMaxImageWidth() {
        return (int) (maxImageWidthWeight().floatValue() * maxDialogWidthPx().intValue());
    }

    public int getMaxBodyHeight() {
        return (int) (maxBodyHeightWeight().floatValue() * maxDialogHeightPx().intValue());
    }

    public int getMaxBodyWidth() {
        return (int) (maxBodyWidthWeight().floatValue() * maxDialogWidthPx().intValue());
    }

    public static class Builder {
        private final InAppMessageLayoutConfig config = new InAppMessageLayoutConfig();

        public Builder setMaxImageHeightWeight(Float f) {
            this.config.maxImageHeightWeight = f;
            return this;
        }

        public Builder setMaxImageWidthWeight(Float f) {
            this.config.maxImageWidthWeight = f;
            return this;
        }

        public Builder setMaxBodyHeightWeight(Float f) {
            this.config.maxBodyHeightWeight = f;
            return this;
        }

        public Builder setMaxBodyWidthWeight(Float f) {
            this.config.maxBodyWidthWeight = f;
            return this;
        }

        public Builder setMaxDialogHeightPx(Integer num) {
            this.config.maxDialogHeightPx = num;
            return this;
        }

        public Builder setMaxDialogWidthPx(Integer num) {
            this.config.maxDialogWidthPx = num;
            return this;
        }

        public Builder setViewWindowGravity(Integer num) {
            this.config.viewWindowGravity = num;
            return this;
        }

        public Builder setWindowFlag(Integer num) {
            this.config.windowFlag = num;
            return this;
        }

        public Builder setWindowWidth(Integer num) {
            this.config.windowWidth = num;
            return this;
        }

        public Builder setWindowHeight(Integer num) {
            this.config.windowHeight = num;
            return this;
        }

        public Builder setBackgroundEnabled(Boolean bool) {
            this.config.backgroundEnabled = bool;
            return this;
        }

        public Builder setAnimate(Boolean bool) {
            this.config.animate = bool;
            return this;
        }

        public Builder setAutoDismiss(Boolean bool) {
            this.config.autoDismiss = bool;
            return this;
        }

        public InAppMessageLayoutConfig build() {
            return this.config;
        }
    }
}
