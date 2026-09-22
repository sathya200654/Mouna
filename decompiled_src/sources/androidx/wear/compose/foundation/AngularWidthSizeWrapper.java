package androidx.wear.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CurvedSize.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u001a\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016R\u0019\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/wear/compose/foundation/AngularWidthSizeWrapper;", "Landroidx/wear/compose/foundation/BaseSizeWrapper;", "child", "Landroidx/wear/compose/foundation/CurvedChild;", "minAngularWidth", "Landroidx/compose/ui/unit/Dp;", "maxAngularWidth", "minThickness", "maxThickness", "(Landroidx/wear/compose/foundation/CurvedChild;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMaxAngularWidth-D9Ej5fM", "()F", "F", "maxAngularWidthPx", "", "getMinAngularWidth-D9Ej5fM", "minAngularWidthPx", "calculateSweepRadians", "partialLayoutInfo", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "initializeMeasure", "", "Landroidx/wear/compose/foundation/CurvedMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AngularWidthSizeWrapper extends BaseSizeWrapper {
    public static final int $stable = 8;
    private final float maxAngularWidth;
    private float maxAngularWidthPx;
    private final float minAngularWidth;
    private float minAngularWidthPx;

    public /* synthetic */ AngularWidthSizeWrapper(CurvedChild curvedChild, float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(curvedChild, f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: getMinAngularWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinAngularWidth() {
        return this.minAngularWidth;
    }

    /* JADX INFO: renamed from: getMaxAngularWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxAngularWidth() {
        return this.maxAngularWidth;
    }

    private AngularWidthSizeWrapper(CurvedChild curvedChild, float f, float f2, float f3, float f4) {
        super(curvedChild, f3, f4, null);
        this.minAngularWidth = f;
        this.maxAngularWidth = f2;
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    public void initializeMeasure(CurvedMeasureScope curvedMeasureScope, Iterator<? extends Measurable> it) {
        this.minAngularWidthPx = curvedMeasureScope.m331toPx0680j_4(this.minAngularWidth);
        this.maxAngularWidthPx = curvedMeasureScope.m331toPx0680j_4(this.maxAngularWidth);
        baseInitializeMeasure(curvedMeasureScope, it);
    }

    @Override // androidx.wear.compose.foundation.BaseSizeWrapper
    protected float calculateSweepRadians(PartialLayoutInfo partialLayoutInfo) {
        return RangesKt.coerceIn(partialLayoutInfo.getSweepRadians(), this.minAngularWidthPx / partialLayoutInfo.getMeasureRadius(), this.maxAngularWidthPx / partialLayoutInfo.getMeasureRadius());
    }
}
