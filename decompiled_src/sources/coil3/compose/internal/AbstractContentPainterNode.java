package coil3.compose.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import coil3.compose.AsyncImagePainter;
import coil3.compose.ConstraintsSizeResolver;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ContentPainterModifier.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BE\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J#\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010D\u001a\u00020AH\u0016J\u001c\u0010E\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010D\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010G\u001a\u00020AH\u0016J\u001c\u0010H\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010G\u001a\u00020AH\u0016J\u0017\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020=2\u0006\u0010<\u001a\u00020=H\u0002¢\u0006\u0004\bO\u0010MJ\f\u0010P\u001a\u00020Q*\u00020RH\u0016J\f\u0010S\u001a\u00020Q*\u00020TH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0012\u00101\u001a\u000202X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010&¨\u0006U"}, d2 = {"Lcoil3/compose/internal/AbstractContentPainterNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clipToBounds", "", "contentDescription", "", "constraintSizeResolver", "Lcoil3/compose/ConstraintsSizeResolver;", "<init>", "(Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLjava/lang/String;Lcoil3/compose/ConstraintsSizeResolver;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "getContentDescription", "()Ljava/lang/String;", "setContentDescription", "(Ljava/lang/String;)V", "getConstraintSizeResolver", "()Lcoil3/compose/ConstraintsSizeResolver;", "setConstraintSizeResolver", "(Lcoil3/compose/ConstraintsSizeResolver;)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AbstractContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private Alignment alignment;
    private float alpha;
    private boolean clipToBounds;
    private ColorFilter colorFilter;
    private ConstraintsSizeResolver constraintSizeResolver;
    private String contentDescription;
    private ContentScale contentScale;

    public abstract Painter getPainter();

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    public final void setClipToBounds(boolean z) {
        this.clipToBounds = z;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final void setContentDescription(String str) {
        this.contentDescription = str;
    }

    public final ConstraintsSizeResolver getConstraintSizeResolver() {
        return this.constraintSizeResolver;
    }

    public final void setConstraintSizeResolver(ConstraintsSizeResolver constraintsSizeResolver) {
        this.constraintSizeResolver = constraintsSizeResolver;
    }

    public AbstractContentPainterNode(Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, String str, ConstraintsSizeResolver constraintsSizeResolver) {
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
        this.clipToBounds = z;
        this.contentDescription = str;
        this.constraintSizeResolver = constraintsSizeResolver;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1035measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m1012setConstraintsBRTryo0(j);
        }
        final Placeable placeable = measurable.measure-BRTryo0(m1034modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), placeable.getHeight(), (Map) null, new Function1() { // from class: coil3.compose.internal.AbstractContentPainterNode$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AbstractContentPainterNode.measure_3p2s80s$lambda$0(placeable, (Placeable.PlacementScope) obj);
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jConstraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m1012setConstraintsBRTryo0(jConstraints$default);
        }
        if (getPainter().getIntrinsicSize-NH-jbRc() != 9205357640488583168L) {
            long jM1034modifyConstraintsZezNO4M = m1034modifyConstraintsZezNO4M(jConstraints$default);
            return Math.max(Constraints.getMinWidth-impl(jM1034modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jConstraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m1012setConstraintsBRTryo0(jConstraints$default);
        }
        if (getPainter().getIntrinsicSize-NH-jbRc() != 9205357640488583168L) {
            long jM1034modifyConstraintsZezNO4M = m1034modifyConstraintsZezNO4M(jConstraints$default);
            return Math.max(Constraints.getMinWidth-impl(jM1034modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jConstraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m1012setConstraintsBRTryo0(jConstraints$default);
        }
        if (getPainter().getIntrinsicSize-NH-jbRc() != 9205357640488583168L) {
            long jM1034modifyConstraintsZezNO4M = m1034modifyConstraintsZezNO4M(jConstraints$default);
            return Math.max(Constraints.getMinHeight-impl(jM1034modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jConstraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m1012setConstraintsBRTryo0(jConstraints$default);
        }
        if (getPainter().getIntrinsicSize-NH-jbRc() != 9205357640488583168L) {
            long jM1034modifyConstraintsZezNO4M = m1034modifyConstraintsZezNO4M(jConstraints$default);
            return Math.max(Constraints.getMinHeight-impl(jM1034modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m1033calculateScaledSizeE7KxVPU(long dstSize) {
        if (Size.isEmpty-impl(dstSize)) {
            return Size.Companion.getZero-NH-jbRc();
        }
        long j = getPainter().getIntrinsicSize-NH-jbRc();
        if (j == 9205357640488583168L) {
            return dstSize;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        if (Math.abs(fIntBitsToFloat) > Float.MAX_VALUE) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (dstSize >> 32));
        }
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        if (Math.abs(fIntBitsToFloat2) > Float.MAX_VALUE) {
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (dstSize & 4294967295L));
        }
        long j2 = Size.constructor-impl((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32));
        long j3 = this.contentScale.computeScaleFactor-H7hwNQA(j2, dstSize);
        return (Math.abs(Float.intBitsToFloat((int) (j3 >> 32))) > Float.MAX_VALUE || Math.abs(Float.intBitsToFloat((int) (4294967295L & j3))) > Float.MAX_VALUE) ? dstSize : ScaleFactorKt.times-m-w2e94(j3, j2);
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m1034modifyConstraintsZezNO4M(long constraints) {
        float fM1042constrainWidthK40F9xA;
        int i;
        float fM1041constrainHeightK40F9xA;
        boolean z = Constraints.getHasFixedWidth-impl(constraints);
        boolean z2 = Constraints.getHasFixedHeight-impl(constraints);
        if (!z || !z2) {
            Painter painter = getPainter();
            boolean z3 = Constraints.getHasBoundedWidth-impl(constraints) && Constraints.getHasBoundedHeight-impl(constraints);
            long j = painter.getIntrinsicSize-NH-jbRc();
            if (j == 9205357640488583168L) {
                if (z3 && (!(painter instanceof AsyncImagePainter) || ((AsyncImagePainter.State) ((AsyncImagePainter) painter).getState().getValue()).getPainter() != null)) {
                    return Constraints.copy-Zbe2FdA$default(constraints, Constraints.getMaxWidth-impl(constraints), 0, Constraints.getMaxHeight-impl(constraints), 0, 10, (Object) null);
                }
            } else {
                if (z3 && (z || z2)) {
                    fM1042constrainWidthK40F9xA = Constraints.getMaxWidth-impl(constraints);
                    i = Constraints.getMaxHeight-impl(constraints);
                } else {
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
                    fM1042constrainWidthK40F9xA = Math.abs(fIntBitsToFloat) <= Float.MAX_VALUE ? UtilsKt.m1042constrainWidthK40F9xA(constraints, fIntBitsToFloat) : Constraints.getMinWidth-impl(constraints);
                    if (Math.abs(fIntBitsToFloat2) <= Float.MAX_VALUE) {
                        fM1041constrainHeightK40F9xA = UtilsKt.m1041constrainHeightK40F9xA(constraints, fIntBitsToFloat2);
                    } else {
                        i = Constraints.getMinHeight-impl(constraints);
                    }
                    long jM1033calculateScaledSizeE7KxVPU = m1033calculateScaledSizeE7KxVPU(Size.constructor-impl((((long) Float.floatToRawIntBits(fM1041constrainHeightK40F9xA)) & 4294967295L) | (((long) Float.floatToRawIntBits(fM1042constrainWidthK40F9xA)) << 32)));
                    return Constraints.copy-Zbe2FdA$default(constraints, ConstraintsKt.constrainWidth-K40F9xA(constraints, MathKt.roundToInt(Float.intBitsToFloat((int) (jM1033calculateScaledSizeE7KxVPU >> 32)))), 0, ConstraintsKt.constrainHeight-K40F9xA(constraints, MathKt.roundToInt(Float.intBitsToFloat((int) (jM1033calculateScaledSizeE7KxVPU & 4294967295L)))), 0, 10, (Object) null);
                }
                fM1041constrainHeightK40F9xA = i;
                long jM1033calculateScaledSizeE7KxVPU2 = m1033calculateScaledSizeE7KxVPU(Size.constructor-impl((((long) Float.floatToRawIntBits(fM1041constrainHeightK40F9xA)) & 4294967295L) | (((long) Float.floatToRawIntBits(fM1042constrainWidthK40F9xA)) << 32)));
                return Constraints.copy-Zbe2FdA$default(constraints, ConstraintsKt.constrainWidth-K40F9xA(constraints, MathKt.roundToInt(Float.intBitsToFloat((int) (jM1033calculateScaledSizeE7KxVPU2 >> 32)))), 0, ConstraintsKt.constrainHeight-K40F9xA(constraints, MathKt.roundToInt(Float.intBitsToFloat((int) (jM1033calculateScaledSizeE7KxVPU2 & 4294967295L)))), 0, 10, (Object) null);
            }
        }
        return constraints;
    }

    public void draw(ContentDrawScope contentDrawScope) {
        long jM1033calculateScaledSizeE7KxVPU = m1033calculateScaledSizeE7KxVPU(contentDrawScope.getSize-NH-jbRc());
        long j = this.alignment.align-KFBX0sM(UtilsKt.m1044toIntSizeuvyYCjk(jM1033calculateScaledSizeE7KxVPU), UtilsKt.m1044toIntSizeuvyYCjk(contentDrawScope.getSize-NH-jbRc()), contentDrawScope.getLayoutDirection());
        int i = IntOffset.getX-impl(j);
        int i2 = IntOffset.getY-impl(j);
        DrawScope drawScope = (DrawScope) contentDrawScope;
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            if (this.clipToBounds) {
                DrawTransform.clipRect-N_I0leg$default(transform, 0.0f, 0.0f, 0.0f, 0.0f, 0, 31, (Object) null);
            }
            transform.translate(i, i2);
            getPainter().draw-x_KDEd0(drawScope, jM1033calculateScaledSizeE7KxVPU, this.alpha, this.colorFilter);
            drawContext.getCanvas().restore();
            drawContext.setSize-uvyYCjk(j2);
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.setSize-uvyYCjk(j2);
            throw th;
        }
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        String str = this.contentDescription;
        if (str != null) {
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getImage-o7Vup1c());
        }
    }
}
