package androidx.wear.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u000fH&ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\f\u0010\u001f\u001a\u00020\u001c*\u00020 H\u0016J\u0014\u0010!\u001a\u00020\u001c*\u00020 2\u0006\u0010\"\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R1\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/wear/compose/material/AbstractPlaceholderModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Shape;)V", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastSize", "Landroidx/compose/ui/geometry/Size;", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "offset", "getOffset-F1C5BW0", "()J", "setOffset-k-4lQ0M", "(J)V", "offset$delegate", "Landroidx/compose/runtime/MutableState;", "generateBrush", "Landroidx/compose/ui/graphics/Brush;", "generateBrush-k-4lQ0M", "(J)Landroidx/compose/ui/graphics/Brush;", "onGloballyPositioned", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawOutline", "brush", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
abstract class AbstractPlaceholderModifier implements DrawModifier, OnGloballyPositionedModifier {
    private final float alpha;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Size lastSize;

    /* JADX INFO: renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableState offset;
    private final Shape shape;

    /* JADX INFO: renamed from: generateBrush-k-4lQ0M, reason: not valid java name */
    public abstract Brush mo506generateBrushk4lQ0M(long offset);

    public AbstractPlaceholderModifier(float f, Shape shape) {
        this.alpha = f;
        this.shape = shape;
        this.offset = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ AbstractPlaceholderModifier(float f, Shape shape, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, shape);
    }

    /* JADX INFO: renamed from: getOffset-F1C5BW0, reason: not valid java name */
    private final long m504getOffsetF1C5BW0() {
        return ((Offset) this.offset.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: setOffset-k-4lQ0M, reason: not valid java name */
    private final void m505setOffsetk4lQ0M(long j) {
        this.offset.setValue(Offset.box-impl(j));
    }

    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        m505setOffsetk4lQ0M(LayoutCoordinatesKt.positionInRoot(coordinates));
    }

    public void draw(ContentDrawScope contentDrawScope) {
        Brush brushMo506generateBrushk4lQ0M = mo506generateBrushk4lQ0M(m504getOffsetF1C5BW0());
        contentDrawScope.drawContent();
        if (brushMo506generateBrushk4lQ0M != null) {
            if (this.shape == RectangleShapeKt.getRectangleShape()) {
                DrawScope.drawRect-AsUm42w$default((DrawScope) contentDrawScope, brushMo506generateBrushk4lQ0M, 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
            } else {
                drawOutline(contentDrawScope, brushMo506generateBrushk4lQ0M);
            }
        }
    }

    private final void drawOutline(ContentDrawScope contentDrawScope, Brush brush) {
        Outline outline;
        if (Size.equals-impl(contentDrawScope.getSize-NH-jbRc(), this.lastSize) && contentDrawScope.getLayoutDirection() == this.lastLayoutDirection) {
            outline = this.lastOutline;
            Intrinsics.checkNotNull(outline);
        } else {
            outline = this.shape.createOutline-Pq9zytI(contentDrawScope.getSize-NH-jbRc(), contentDrawScope.getLayoutDirection(), (Density) contentDrawScope);
        }
        Outline outline2 = outline;
        OutlineKt.drawOutline-hn5TExg$default((DrawScope) contentDrawScope, outline2, brush, this.alpha, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        this.lastOutline = outline2;
        this.lastSize = Size.box-impl(contentDrawScope.getSize-NH-jbRc());
    }
}
