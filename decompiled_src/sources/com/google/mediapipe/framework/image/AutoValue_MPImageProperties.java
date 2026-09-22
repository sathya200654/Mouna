package com.google.mediapipe.framework.image;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_MPImageProperties extends C$AutoValue_MPImageProperties {
    private volatile transient int hashCode;
    private volatile transient boolean hashCode$Memoized;

    AutoValue_MPImageProperties(int imageFormat$, int storageType$) {
        super(imageFormat$, storageType$);
    }

    @Override // com.google.mediapipe.framework.image.C$AutoValue_MPImageProperties, com.google.mediapipe.framework.image.MPImageProperties
    public int hashCode() {
        if (!this.hashCode$Memoized) {
            synchronized (this) {
                if (!this.hashCode$Memoized) {
                    this.hashCode = super.hashCode();
                    this.hashCode$Memoized = true;
                }
            }
        }
        return this.hashCode;
    }

    @Override // com.google.mediapipe.framework.image.C$AutoValue_MPImageProperties
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        return (that instanceof AutoValue_MPImageProperties) && hashCode() == that.hashCode() && super.equals(that);
    }
}
