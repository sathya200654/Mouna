package androidx.wear.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ScalingLazyColumnMeasure.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/wear/compose/foundation/lazy/ScaleAndAlpha;", "", "scale", "", "alpha", "(FF)V", "getAlpha", "()F", "getScale", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ScaleAndAlpha {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ScaleAndAlpha noScaling = new ScaleAndAlpha(1.0f, 1.0f);
    private final float alpha;
    private final float scale;

    public static /* synthetic */ ScaleAndAlpha copy$default(ScaleAndAlpha scaleAndAlpha, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = scaleAndAlpha.scale;
        }
        if ((i & 2) != 0) {
            f2 = scaleAndAlpha.alpha;
        }
        return scaleAndAlpha.copy(f, f2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    public final ScaleAndAlpha copy(float scale, float alpha) {
        return new ScaleAndAlpha(scale, alpha);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScaleAndAlpha)) {
            return false;
        }
        ScaleAndAlpha scaleAndAlpha = (ScaleAndAlpha) other;
        return Float.compare(this.scale, scaleAndAlpha.scale) == 0 && Float.compare(this.alpha, scaleAndAlpha.alpha) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.scale) * 31) + Float.hashCode(this.alpha);
    }

    public String toString() {
        return "ScaleAndAlpha(scale=" + this.scale + ", alpha=" + this.alpha + ')';
    }

    public ScaleAndAlpha(float f, float f2) {
        this.scale = f;
        this.alpha = f2;
    }

    public final float getScale() {
        return this.scale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: compiled from: ScalingLazyColumnMeasure.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/wear/compose/foundation/lazy/ScaleAndAlpha$Companion;", "", "()V", "noScaling", "Landroidx/wear/compose/foundation/lazy/ScaleAndAlpha;", "getNoScaling$compose_foundation_release", "()Landroidx/wear/compose/foundation/lazy/ScaleAndAlpha;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScaleAndAlpha getNoScaling$compose_foundation_release() {
            return ScaleAndAlpha.noScaling;
        }
    }
}
