package androidx.wear.compose.material;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Picker.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jb\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH\u0007¢\u0006\u0002\u0010\u001bJd\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001e"}, d2 = {"Landroidx/wear/compose/material/PickerDefaults;", "", "()V", "DefaultGradientRatio", "", "getDefaultGradientRatio", "()F", "defaultScalingParams", "Landroidx/wear/compose/foundation/lazy/ScalingParams;", "edgeScale", "edgeAlpha", "minElementHeight", "maxElementHeight", "minTransitionArea", "maxTransitionArea", "scaleInterpolator", "Landroidx/compose/animation/core/Easing;", "viewportVerticalOffsetResolver", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Constraints;", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/wear/compose/material/PickerState;", "decay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/wear/compose/material/PickerState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "scalingParams", "Landroidx/wear/compose/material/ScalingParams;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PickerDefaults {
    public static final int $stable = 0;
    public static final PickerDefaults INSTANCE = new PickerDefaults();
    private static final float DefaultGradientRatio = 0.33f;

    private PickerDefaults() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScalingParams scalingParams$default(PickerDefaults pickerDefaults, float f, float f2, float f3, float f4, float f5, float f6, Easing easing, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.45f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        if ((i & 16) != 0) {
            f5 = 0.45f;
        }
        if ((i & 32) != 0) {
            f6 = 0.45f;
        }
        if ((i & 64) != 0) {
            easing = (Easing) new CubicBezierEasing(0.25f, 0.0f, 0.75f, 1.0f);
        }
        if ((i & 128) != 0) {
            function1 = new Function1<Constraints, Integer>() { // from class: androidx.wear.compose.material.PickerDefaults.scalingParams.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return m630invokeBRTryo0(((Constraints) obj2).unbox-impl());
                }

                /* JADX INFO: renamed from: invoke-BRTryo0, reason: not valid java name */
                public final Integer m630invokeBRTryo0(long j) {
                    return Integer.valueOf((int) (Constraints.getMaxHeight-impl(j) / 5.0f));
                }
            };
        }
        return pickerDefaults.scalingParams(f, f2, f3, f4, f5, f6, easing, function1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This overload is provided for backwards compatibility with Compose for Wear OS 1.1 and was deprecated. Use [defaultScalingParams] instead", replaceWith = @ReplaceWith(expression = "PickerDefaults.defaultScalingParams(edgeScale, edgeAlpha, minElementHeight, maxElementHeight, minTransitionArea, maxTransitionArea, scaleInterpolator, viewportVerticalOffsetResolver)", imports = {}))
    public final ScalingParams scalingParams(float edgeScale, float edgeAlpha, float minElementHeight, float maxElementHeight, float minTransitionArea, float maxTransitionArea, Easing scaleInterpolator, Function1<? super Constraints, Integer> viewportVerticalOffsetResolver) {
        return ScalingLazyColumnDefaults.INSTANCE.scalingParams(edgeScale, edgeAlpha, minElementHeight, maxElementHeight, minTransitionArea, maxTransitionArea, scaleInterpolator, viewportVerticalOffsetResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ androidx.wear.compose.foundation.lazy.ScalingParams defaultScalingParams$default(PickerDefaults pickerDefaults, float f, float f2, float f3, float f4, float f5, float f6, Easing easing, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.45f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        if ((i & 16) != 0) {
            f5 = 0.45f;
        }
        if ((i & 32) != 0) {
            f6 = 0.45f;
        }
        if ((i & 64) != 0) {
            easing = (Easing) new CubicBezierEasing(0.25f, 0.0f, 0.75f, 1.0f);
        }
        if ((i & 128) != 0) {
            function1 = new Function1<Constraints, Integer>() { // from class: androidx.wear.compose.material.PickerDefaults.defaultScalingParams.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return m629invokeBRTryo0(((Constraints) obj2).unbox-impl());
                }

                /* JADX INFO: renamed from: invoke-BRTryo0, reason: not valid java name */
                public final Integer m629invokeBRTryo0(long j) {
                    return Integer.valueOf((int) (Constraints.getMaxHeight-impl(j) / 5.0f));
                }
            };
        }
        return pickerDefaults.defaultScalingParams(f, f2, f3, f4, f5, f6, easing, function1);
    }

    public final androidx.wear.compose.foundation.lazy.ScalingParams defaultScalingParams(float edgeScale, float edgeAlpha, float minElementHeight, float maxElementHeight, float minTransitionArea, float maxTransitionArea, Easing scaleInterpolator, Function1<? super Constraints, Integer> viewportVerticalOffsetResolver) {
        return androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults.INSTANCE.scalingParams(edgeScale, edgeAlpha, minElementHeight, maxElementHeight, minTransitionArea, maxTransitionArea, scaleInterpolator, viewportVerticalOffsetResolver);
    }

    public final FlingBehavior flingBehavior(PickerState pickerState, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 700844275, "C(flingBehavior)P(1)829@38982L133:Picker.kt#gj9v0t");
        if ((i2 & 2) != 0) {
            decayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, (Object) null);
        }
        DecayAnimationSpec<Float> decayAnimationSpec2 = decayAnimationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700844275, i, -1, "androidx.wear.compose.material.PickerDefaults.flingBehavior (Picker.kt:828)");
        }
        FlingBehavior flingBehaviorM449snapFlingBehavioruFdPcIQ = androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults.INSTANCE.m449snapFlingBehavioruFdPcIQ(pickerState.getScalingLazyListState(), Dp.constructor-impl(0), decayAnimationSpec2, composer, ((i << 3) & 896) | 48 | (androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults.$stable << 9), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return flingBehaviorM449snapFlingBehavioruFdPcIQ;
    }

    public final float getDefaultGradientRatio() {
        return DefaultGradientRatio;
    }
}
