package androidx.wear.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedLayout.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0001\u0018\u00002\u00020\u0001B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ#\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/wear/compose/foundation/CurvedLayoutInfo;", "", "sweepRadians", "", "outerRadius", "thickness", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "measureRadius", "startAngleRadians", "(FFFJFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCenterOffset-F1C5BW0", "()J", "J", "innerRadius", "getInnerRadius", "()F", "getMeasureRadius", "getOuterRadius", "getStartAngleRadians", "getSweepRadians", "getThickness", "computePointOffset", "radialRatio", "angleRatio", "computePointOffset-dBAh8RU", "(FF)J", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedLayoutInfo {
    public static final int $stable = 0;
    private final long centerOffset;
    private final float innerRadius;
    private final float measureRadius;
    private final float outerRadius;
    private final float startAngleRadians;
    private final float sweepRadians;
    private final float thickness;

    public /* synthetic */ CurvedLayoutInfo(float f, float f2, float f3, long j, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, j, f4, f5);
    }

    private CurvedLayoutInfo(float f, float f2, float f3, long j, float f4, float f5) {
        this.sweepRadians = f;
        this.outerRadius = f2;
        this.thickness = f3;
        this.centerOffset = j;
        this.measureRadius = f4;
        this.startAngleRadians = f5;
        this.innerRadius = f2 - f3;
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

    /* JADX INFO: renamed from: getCenterOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getCenterOffset() {
        return this.centerOffset;
    }

    public final float getMeasureRadius() {
        return this.measureRadius;
    }

    public final float getStartAngleRadians() {
        return this.startAngleRadians;
    }

    public final float getInnerRadius() {
        return this.innerRadius;
    }

    /* JADX INFO: renamed from: computePointOffset-dBAh8RU, reason: not valid java name */
    public final long m319computePointOffsetdBAh8RU(float radialRatio, float angleRatio) {
        return Offset.plus-MK-Hz9U(this.centerOffset, CurvedLayoutKt.offsetFromDistanceAndAngle(this.outerRadius - (this.thickness * (1.0f - radialRatio)), this.startAngleRadians + (angleRatio * this.sweepRadians)));
    }
}
