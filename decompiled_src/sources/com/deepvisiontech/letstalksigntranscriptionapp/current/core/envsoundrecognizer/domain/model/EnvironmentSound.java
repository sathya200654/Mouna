package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model;

import androidx.compose.ui.graphics.vector.ImageVector;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnvironSound.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "confidence", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "vibrationLevel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/VibrationLevel;", "<init>", "(Ljava/lang/String;FLandroidx/compose/ui/graphics/vector/ImageVector;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/VibrationLevel;)V", "getLabel", "()Ljava/lang/String;", "getConfidence", "()F", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getVibrationLevel", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/VibrationLevel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class EnvironmentSound {
    public static final int $stable = 0;
    private final float confidence;
    private final ImageVector icon;
    private final String label;
    private final VibrationLevel vibrationLevel;

    public static /* synthetic */ EnvironmentSound copy$default(EnvironmentSound environmentSound, String str, float f, ImageVector imageVector, VibrationLevel vibrationLevel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = environmentSound.label;
        }
        if ((i & 2) != 0) {
            f = environmentSound.confidence;
        }
        if ((i & 4) != 0) {
            imageVector = environmentSound.icon;
        }
        if ((i & 8) != 0) {
            vibrationLevel = environmentSound.vibrationLevel;
        }
        return environmentSound.copy(str, f, imageVector, vibrationLevel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getConfidence() {
        return this.confidence;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ImageVector getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final VibrationLevel getVibrationLevel() {
        return this.vibrationLevel;
    }

    public final EnvironmentSound copy(String label, float confidence, ImageVector icon, VibrationLevel vibrationLevel) {
        Intrinsics.checkNotNullParameter(label, Constants.ScionAnalytics.PARAM_LABEL);
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(vibrationLevel, "vibrationLevel");
        return new EnvironmentSound(label, confidence, icon, vibrationLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnvironmentSound)) {
            return false;
        }
        EnvironmentSound environmentSound = (EnvironmentSound) other;
        return Intrinsics.areEqual(this.label, environmentSound.label) && Float.compare(this.confidence, environmentSound.confidence) == 0 && Intrinsics.areEqual(this.icon, environmentSound.icon) && this.vibrationLevel == environmentSound.vibrationLevel;
    }

    public int hashCode() {
        return (((((this.label.hashCode() * 31) + Float.hashCode(this.confidence)) * 31) + this.icon.hashCode()) * 31) + this.vibrationLevel.hashCode();
    }

    public String toString() {
        return "EnvironmentSound(label=" + this.label + ", confidence=" + this.confidence + ", icon=" + this.icon + ", vibrationLevel=" + this.vibrationLevel + ")";
    }

    public EnvironmentSound(String str, float f, ImageVector imageVector, VibrationLevel vibrationLevel) {
        Intrinsics.checkNotNullParameter(str, Constants.ScionAnalytics.PARAM_LABEL);
        Intrinsics.checkNotNullParameter(imageVector, "icon");
        Intrinsics.checkNotNullParameter(vibrationLevel, "vibrationLevel");
        this.label = str;
        this.confidence = f;
        this.icon = imageVector;
        this.vibrationLevel = vibrationLevel;
    }

    public final String getLabel() {
        return this.label;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }

    public final VibrationLevel getVibrationLevel() {
        return this.vibrationLevel;
    }
}
