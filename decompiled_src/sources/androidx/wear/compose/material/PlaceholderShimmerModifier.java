package androidx.wear.compose.material;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/wear/compose/material/PlaceholderShimmerModifier;", "Landroidx/wear/compose/material/AbstractPlaceholderModifier;", "placeholderState", "Landroidx/wear/compose/material/PlaceholderState;", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/wear/compose/material/PlaceholderState;JFLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "equals", "", "other", "", "generateBrush", "Landroidx/compose/ui/graphics/Brush;", "offset", "Landroidx/compose/ui/geometry/Offset;", "generateBrush-k-4lQ0M", "(J)Landroidx/compose/ui/graphics/Brush;", "hashCode", "", "onGloballyPositioned", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PlaceholderShimmerModifier extends AbstractPlaceholderModifier {
    private final long color;
    private final PlaceholderState placeholderState;
    private final Shape shape;

    public /* synthetic */ PlaceholderShimmerModifier(PlaceholderState placeholderState, long j, float f, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(placeholderState, j, f, shape);
    }

    public /* synthetic */ PlaceholderShimmerModifier(PlaceholderState placeholderState, long j, float f, Shape shape, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(placeholderState, j, (i & 4) != 0 ? 1.0f : f, shape, null);
    }

    public final Shape getShape() {
        return this.shape;
    }

    private PlaceholderShimmerModifier(PlaceholderState placeholderState, long j, float f, Shape shape) {
        super(f, shape);
        this.placeholderState = placeholderState;
        this.color = j;
        this.shape = shape;
    }

    @Override // androidx.wear.compose.material.AbstractPlaceholderModifier
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.placeholderState.m679setBackgroundOffsetk4lQ0M$compose_material_release(LayoutCoordinatesKt.positionInRoot(coordinates));
        super.onGloballyPositioned(coordinates);
    }

    @Override // androidx.wear.compose.material.AbstractPlaceholderModifier
    /* JADX INFO: renamed from: generateBrush-k-4lQ0M */
    public Brush mo506generateBrushk4lQ0M(long offset) {
        if (!PlaceholderStage.m669equalsimpl0(this.placeholderState.m678getPlaceholderStage47HYLpQ$compose_material_release(), PlaceholderStage.INSTANCE.m675getShowPlaceholder47HYLpQ())) {
            return null;
        }
        float gradientXYWidth$compose_material_release = this.placeholderState.getGradientXYWidth$compose_material_release() / 2.0f;
        Brush.Companion companion = Brush.Companion;
        long jOffset = OffsetKt.Offset((this.placeholderState.getPlaceholderProgression() - gradientXYWidth$compose_material_release) - Offset.getX-impl(offset), (this.placeholderState.getPlaceholderProgression() - gradientXYWidth$compose_material_release) - Offset.getY-impl(offset));
        long jOffset2 = OffsetKt.Offset((this.placeholderState.getPlaceholderProgression() + gradientXYWidth$compose_material_release) - Offset.getX-impl(offset), (this.placeholderState.getPlaceholderProgression() + gradientXYWidth$compose_material_release) - Offset.getY-impl(offset));
        Pair[] pairArr = (Pair[]) CollectionsKt.listOf(new Pair[]{TuplesKt.to(Float.valueOf(0.1f), Color.box-impl(Color.copy-wmQWz5c$default(this.color, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), TuplesKt.to(Float.valueOf(0.65f), Color.box-impl(Color.copy-wmQWz5c$default(this.color, this.placeholderState.getPlaceholderShimmerAlpha$compose_material_release(), 0.0f, 0.0f, 0.0f, 14, (Object) null))), TuplesKt.to(Float.valueOf(0.9f), Color.box-impl(Color.copy-wmQWz5c$default(this.color, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null)))}).toArray(new Pair[0]);
        return Brush.Companion.linearGradient-mHitzGk$default(companion, (Pair[]) Arrays.copyOf(pairArr, pairArr.length), jOffset, jOffset2, 0, 8, (Object) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.wear.compose.material.PlaceholderShimmerModifier");
        PlaceholderShimmerModifier placeholderShimmerModifier = (PlaceholderShimmerModifier) other;
        return Intrinsics.areEqual(this.placeholderState, placeholderShimmerModifier.placeholderState) && Color.equals-impl0(this.color, placeholderShimmerModifier.color) && Intrinsics.areEqual(this.shape, placeholderShimmerModifier.shape);
    }

    public int hashCode() {
        return (((this.placeholderState.hashCode() * 31) + Color.hashCode-impl(this.color)) * 31) + this.shape.hashCode();
    }
}
