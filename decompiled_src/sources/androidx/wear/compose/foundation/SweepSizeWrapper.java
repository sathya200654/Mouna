package androidx.wear.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CurvedSize.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u001a\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/wear/compose/foundation/SweepSizeWrapper;", "Landroidx/wear/compose/foundation/BaseSizeWrapper;", "child", "Landroidx/wear/compose/foundation/CurvedChild;", "minSweepDegrees", "", "maxSweepDegrees", "minThickness", "Landroidx/compose/ui/unit/Dp;", "maxThickness", "(Landroidx/wear/compose/foundation/CurvedChild;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMaxSweepDegrees", "()F", "getMinSweepDegrees", "calculateSweepRadians", "partialLayoutInfo", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "initializeMeasure", "", "Landroidx/wear/compose/foundation/CurvedMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SweepSizeWrapper extends BaseSizeWrapper {
    public static final int $stable = 0;
    private final float maxSweepDegrees;
    private final float minSweepDegrees;

    public /* synthetic */ SweepSizeWrapper(CurvedChild curvedChild, float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(curvedChild, f, f2, f3, f4);
    }

    public final float getMinSweepDegrees() {
        return this.minSweepDegrees;
    }

    public final float getMaxSweepDegrees() {
        return this.maxSweepDegrees;
    }

    private SweepSizeWrapper(CurvedChild curvedChild, float f, float f2, float f3, float f4) {
        super(curvedChild, f3, f4, null);
        this.minSweepDegrees = f;
        this.maxSweepDegrees = f2;
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    public void initializeMeasure(CurvedMeasureScope curvedMeasureScope, Iterator<? extends Measurable> it) {
        baseInitializeMeasure(curvedMeasureScope, it);
    }

    @Override // androidx.wear.compose.foundation.BaseSizeWrapper
    protected float calculateSweepRadians(PartialLayoutInfo partialLayoutInfo) {
        return RangesKt.coerceIn(partialLayoutInfo.getSweepRadians(), CurvedLayoutKt.toRadians(this.minSweepDegrees), CurvedLayoutKt.toRadians(this.maxSweepDegrees));
    }
}
