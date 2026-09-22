package androidx.wear.compose.foundation;

import kotlin.Metadata;

/* JADX INFO: compiled from: CurvedLayout.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Landroidx/wear/compose/foundation/PartialLayoutInfo;", "", "sweepRadians", "", "outerRadius", "thickness", "measureRadius", "(FFFF)V", "getMeasureRadius", "()F", "getOuterRadius", "getSweepRadians", "getThickness", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialLayoutInfo {
    public static final int $stable = 0;
    private final float measureRadius;
    private final float outerRadius;
    private final float sweepRadians;
    private final float thickness;

    public PartialLayoutInfo(float f, float f2, float f3, float f4) {
        this.sweepRadians = f;
        this.outerRadius = f2;
        this.thickness = f3;
        this.measureRadius = f4;
    }

    public final float getSweepRadians() {
        return this.sweepRadians;
    }

    public final float getOuterRadius() {
        return this.outerRadius;
    }

    public final float getThickness() {
        return this.thickness;
    }

    public final float getMeasureRadius() {
        return this.measureRadius;
    }
}
