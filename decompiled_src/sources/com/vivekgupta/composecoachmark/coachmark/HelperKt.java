package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Helper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001ae\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001c\u001a \u0010\u001d\u001a\u00020\f*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\fH\u0000\u001a \u0010!\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\fH\u0000\u001a\u0017\u0010\"\u001a\u00020#*\u00020#ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a \u0010&\u001a\u00020\f*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\fH\u0000\u001a \u0010'\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\fH\u0000\" \u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"rectToVector", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "getRectToVector", "()Landroidx/compose/animation/core/TwoWayConverter;", "rememberCoachMarkState", "Lcom/vivekgupta/composecoachmark/coachmark/CoachMarkState;", "(Landroidx/compose/runtime/Composer;I)Lcom/vivekgupta/composecoachmark/coachmark/CoachMarkState;", "addTarget", "Landroidx/compose/ui/Modifier;", "position", "", RemoteConfigConstants.ResponseFieldKey.STATE, "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "revealEffect", "Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;", "backgroundCoachStyle", "Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;", "alignment", "Landroidx/compose/ui/Alignment;", "isForcedAlignment", "", "(Landroidx/compose/ui/Modifier;ILcom/vivekgupta/composecoachmark/coachmark/CoachMarkState;Lkotlin/jvm/functions/Function3;Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;Landroidx/compose/ui/Alignment;Z)Landroidx/compose/ui/Modifier;", "firstKey", "", "Lcom/vivekgupta/composecoachmark/coachmark/CoachData;", "dropCount", "hasNextValue", "invert", "Landroidx/compose/ui/graphics/Color;", "invert-8_81llA", "(J)J", "nextKey", "nextValue", "composecoachmark_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HelperKt {
    private static final TwoWayConverter<Rect, AnimationVector4D> rectToVector = VectorConvertersKt.TwoWayConverter(new Function1<Rect, AnimationVector4D>() { // from class: com.vivekgupta.composecoachmark.coachmark.HelperKt$rectToVector$1
        public final AnimationVector4D invoke(Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            return new AnimationVector4D(rect.getLeft(), rect.getTop(), rect.getWidth(), rect.getHeight());
        }
    }, new Function1<AnimationVector4D, Rect>() { // from class: com.vivekgupta.composecoachmark.coachmark.HelperKt$rectToVector$2
        public final Rect invoke(AnimationVector4D animationVector4D) {
            Intrinsics.checkNotNullParameter(animationVector4D, "vector");
            return RectKt.Rect-tz77jQw(OffsetKt.Offset(animationVector4D.getV1(), animationVector4D.getV2()), SizeKt.Size(animationVector4D.getV3(), animationVector4D.getV4()));
        }
    });

    public static final boolean hasNextValue(Map<Integer, CoachData> map, int i) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return CollectionsKt.drop(map.values(), RangesKt.coerceAtLeast(i, 0)).iterator().hasNext();
    }

    public static final int nextKey(Map<Integer, CoachData> map, int i) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return ((Number) CollectionsKt.drop(map.keySet(), RangesKt.coerceAtLeast(i, 0)).iterator().next()).intValue();
    }

    public static final int firstKey(Map<Integer, CoachData> map, int i) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return ((Number) CollectionsKt.first(CollectionsKt.drop(map.keySet(), RangesKt.coerceAtLeast(i, 0)))).intValue();
    }

    public static final CoachData nextValue(Map<Integer, CoachData> map, int i) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return (CoachData) CollectionsKt.drop(map.values(), RangesKt.coerceAtLeast(i, 0)).iterator().next();
    }

    public static final TwoWayConverter<Rect, AnimationVector4D> getRectToVector() {
        return rectToVector;
    }

    public static /* synthetic */ Modifier addTarget$default(Modifier modifier, int i, CoachMarkState coachMarkState, Function3 function3, RevealEffect revealEffect, CoachStyle coachStyle, Alignment alignment, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            revealEffect = new RectangleRevealEffect();
        }
        RevealEffect revealEffect2 = revealEffect;
        if ((i2 & 16) != 0) {
            coachStyle = new DefaultCoachStyle();
        }
        CoachStyle coachStyle2 = coachStyle;
        if ((i2 & 32) != 0) {
            alignment = Alignment.Companion.getBottomCenter();
        }
        return addTarget(modifier, i, coachMarkState, function3, revealEffect2, coachStyle2, alignment, (i2 & 64) != 0 ? false : z);
    }

    public static final Modifier addTarget(Modifier modifier, final int i, final CoachMarkState coachMarkState, final Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, final RevealEffect revealEffect, final CoachStyle coachStyle, final Alignment alignment, final boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(coachMarkState, RemoteConfigConstants.ResponseFieldKey.STATE);
        Intrinsics.checkNotNullParameter(function3, "content");
        Intrinsics.checkNotNullParameter(revealEffect, "revealEffect");
        Intrinsics.checkNotNullParameter(coachStyle, "backgroundCoachStyle");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, new Function1<LayoutCoordinates, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.HelperKt.addTarget.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutCoordinates layoutCoordinates) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                coachMarkState.getTargetList$composecoachmark_release().put(Integer.valueOf(i), new CoachData(layoutCoordinates, function3, revealEffect, alignment, z, coachStyle));
            }
        });
    }

    public static final CoachMarkState rememberCoachMarkState(Composer composer, int i) {
        composer.startReplaceableGroup(-2051623010);
        ComposerKt.sourceInformation(composer, "C(rememberCoachMarkState)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2051623010, i, -1, "com.vivekgupta.composecoachmark.coachmark.rememberCoachMarkState (Helper.kt:66)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new CoachMarkState();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        CoachMarkState coachMarkState = (CoachMarkState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return coachMarkState;
    }

    /* JADX INFO: renamed from: invert-8_81llA, reason: not valid java name */
    public static final long m2258invert8_81llA(long j) {
        return ColorKt.Color(1.0f - Color.getRed-impl(j), 1.0f - Color.getGreen-impl(j), 1.0f - Color.getBlue-impl(j), Color.getAlpha-impl(j), Color.getColorSpace-impl(j));
    }
}
