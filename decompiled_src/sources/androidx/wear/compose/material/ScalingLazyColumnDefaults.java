package androidx.wear.compose.material;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ScalingLazyColumn.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jb\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fJ4\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/wear/compose/material/ScalingLazyColumnDefaults;", "", "()V", "scalingParams", "Landroidx/wear/compose/material/ScalingParams;", "edgeScale", "", "edgeAlpha", "minElementHeight", "maxElementHeight", "minTransitionArea", "maxTransitionArea", "scaleInterpolator", "Landroidx/compose/animation/core/Easing;", "viewportVerticalOffsetResolver", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Constraints;", "", "snapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/wear/compose/material/ScalingLazyListState;", "snapOffset", "Landroidx/compose/ui/unit/Dp;", "decay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapFlingBehavior-uFdPcIQ", "(Landroidx/wear/compose/material/ScalingLazyListState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScalingLazyColumnDefaults {
    public static final int $stable = 0;
    public static final ScalingLazyColumnDefaults INSTANCE = new ScalingLazyColumnDefaults();

    private ScalingLazyColumnDefaults() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScalingParams scalingParams$default(ScalingLazyColumnDefaults scalingLazyColumnDefaults, float f, float f2, float f3, float f4, float f5, float f6, Easing easing, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.7f;
        }
        if ((i & 2) != 0) {
            f2 = 0.5f;
        }
        if ((i & 4) != 0) {
            f3 = 0.2f;
        }
        if ((i & 8) != 0) {
            f4 = 0.6f;
        }
        if ((i & 16) != 0) {
            f5 = 0.35f;
        }
        if ((i & 32) != 0) {
            f6 = 0.55f;
        }
        if ((i & 64) != 0) {
            easing = (Easing) new CubicBezierEasing(0.3f, 0.0f, 0.7f, 1.0f);
        }
        if ((i & 128) != 0) {
            function1 = new Function1<Constraints, Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnDefaults.scalingParams.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return m750invokeBRTryo0(((Constraints) obj2).unbox-impl());
                }

                /* JADX INFO: renamed from: invoke-BRTryo0, reason: not valid java name */
                public final Integer m750invokeBRTryo0(long j) {
                    return Integer.valueOf((int) (Constraints.getMaxHeight-impl(j) / 20.0f));
                }
            };
        }
        return scalingLazyColumnDefaults.scalingParams(f, f2, f3, f4, f5, f6, easing, function1);
    }

    public final ScalingParams scalingParams(float edgeScale, float edgeAlpha, float minElementHeight, float maxElementHeight, float minTransitionArea, float maxTransitionArea, Easing scaleInterpolator, Function1<? super Constraints, Integer> viewportVerticalOffsetResolver) {
        return new DefaultScalingParams(edgeScale, edgeAlpha, minElementHeight, maxElementHeight, minTransitionArea, maxTransitionArea, scaleInterpolator, viewportVerticalOffsetResolver);
    }

    /* JADX INFO: renamed from: snapFlingBehavior-uFdPcIQ, reason: not valid java name */
    public final FlingBehavior m749snapFlingBehavioruFdPcIQ(ScalingLazyListState scalingLazyListState, float f, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -304825186, "C(snapFlingBehavior)P(2,1:c#ui.unit.Dp)*613@31334L7,614@31385L212:ScalingLazyColumn.kt#gj9v0t");
        if ((i2 & 2) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i2 & 4) != 0) {
            decayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-304825186, i, -1, "androidx.wear.compose.material.ScalingLazyColumnDefaults.snapFlingBehavior (ScalingLazyColumn.kt:612)");
        }
        CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i3 = ((Density) objConsume).roundToPx-0680j_4(f);
        ComposerKt.sourceInformationMarkerStart(composer, 718633196, "CC(remember):ScalingLazyColumn.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(scalingLazyListState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f)) || (i & 48) == 32) | composer.changed(decayAnimationSpec);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new ScalingLazyColumnSnapFlingBehavior(scalingLazyListState, i3, decayAnimationSpec);
            composer.updateRememberedValue(objRememberedValue);
        }
        ScalingLazyColumnSnapFlingBehavior scalingLazyColumnSnapFlingBehavior = (ScalingLazyColumnSnapFlingBehavior) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return scalingLazyColumnSnapFlingBehavior;
    }
}
