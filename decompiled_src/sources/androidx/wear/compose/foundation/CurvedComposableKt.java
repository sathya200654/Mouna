package androidx.wear.compose.foundation;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CurvedComposable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001aF\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a,\u0010\u0011\u001a\u00020\u0004*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"pow2", "", "x", "curvedComposable", "", "Landroidx/wear/compose/foundation/CurvedScope;", "modifier", "Landroidx/wear/compose/foundation/CurvedModifier;", "radialAlignment", "Landroidx/wear/compose/foundation/CurvedAlignment$Radial;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "curvedComposable-E6nutXQ", "(Landroidx/wear/compose/foundation/CurvedScope;Landroidx/wear/compose/foundation/CurvedModifier;FLkotlin/jvm/functions/Function3;)V", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "layoutInfo", "Landroidx/wear/compose/foundation/CurvedLayoutInfo;", "parentSweepRadians", "clockwise", "", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurvedComposableKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float pow2(float f) {
        return f * f;
    }

    /* JADX INFO: renamed from: curvedComposable-E6nutXQ$default, reason: not valid java name */
    public static /* synthetic */ void m281curvedComposableE6nutXQ$default(CurvedScope curvedScope, CurvedModifier curvedModifier, float f, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            curvedModifier = CurvedModifier.INSTANCE;
        }
        if ((i & 2) != 0) {
            f = CurvedAlignment.Radial.INSTANCE.m271getCenterBjYtHoc();
        }
        m280curvedComposableE6nutXQ(curvedScope, curvedModifier, f, function3);
    }

    /* JADX INFO: renamed from: curvedComposable-E6nutXQ, reason: not valid java name */
    public static final void m280curvedComposableE6nutXQ(CurvedScope curvedScope, CurvedModifier curvedModifier, float f, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3) {
        curvedScope.add$compose_foundation_release(new CurvedComposableChild(curvedScope.getCurvedLayoutDirection().absoluteClockwise(), f, function3, null), curvedModifier);
    }

    public static final void place(Placeable.PlacementScope placementScope, Placeable placeable, CurvedLayoutInfo curvedLayoutInfo, float f, boolean z) {
        float fSqrt = ((float) Math.sqrt(RangesKt.coerceAtLeast(pow2(curvedLayoutInfo.getOuterRadius()) - pow2(placeable.getWidth() / 2.0f), 0.0f))) - (placeable.getHeight() / 2.0f);
        float startAngleRadians = curvedLayoutInfo.getStartAngleRadians() + (f / 2.0f);
        double d = startAngleRadians;
        float f2 = Offset.getX-impl(curvedLayoutInfo.getCenterOffset()) + (((float) Math.cos(d)) * fSqrt);
        float f3 = Offset.getY-impl(curvedLayoutInfo.getCenterOffset()) + (fSqrt * ((float) Math.sin(d)));
        int iRoundToInt = MathKt.roundToInt(f2 - (placeable.getWidth() / 2.0f));
        int iRoundToInt2 = MathKt.roundToInt(f3 - (placeable.getHeight() / 2.0f));
        final float f4 = startAngleRadians + (z ? 0.0f : 3.1415927f);
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, iRoundToInt, iRoundToInt2, 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedComposableKt$place$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                graphicsLayerScope.setRotationZ(CurvedLayoutKt.toDegrees(f4) - 270.0f);
                graphicsLayerScope.setTransformOrigin-__ExYCQ(TransformOrigin.Companion.getCenter-SzJe1aQ());
            }
        }, 4, (Object) null);
    }
}
