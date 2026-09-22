package com.google.mediapipe.framework.image;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class MPImageProperties {
    public abstract int getImageFormat();

    public abstract int getStorageType();

    public abstract int hashCode();

    static Builder builder() {
        return new C$AutoValue_MPImageProperties.Builder();
    }

    static abstract class Builder {
        abstract MPImageProperties build();

        abstract Builder setImageFormat(int value);

        abstract Builder setStorageType(int value);

        Builder() {
        }
    }

    MPImageProperties() {
    }
}
