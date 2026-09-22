package androidx.wear.compose.foundation.rotary;

import android.content.Context;
import android.view.ViewConfiguration;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.wear.compose.foundation.lazy.ScalingLazyListState;
import kotlin.Metadata;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0013J6\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/wear/compose/foundation/rotary/RotaryScrollableDefaults;", "", "()V", "HighResFlingTimeframe", "", "LowResFlingTimeframe", "ResistanceFactor", "", "ThresholdDivider", "behavior", "Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "hapticFeedbackEnabled", "", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;", "isLowResInput", "(Landroidx/compose/runtime/Composer;I)Z", "snapBehavior", "layoutInfoProvider", "Landroidx/wear/compose/foundation/rotary/RotarySnapLayoutInfoProvider;", "snapOffset", "Landroidx/compose/ui/unit/Dp;", "snapBehavior-942rkJo", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/wear/compose/foundation/rotary/RotarySnapLayoutInfoProvider;FZLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", "snapBehavior-uFdPcIQ", "(Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;FZLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RotaryScrollableDefaults {
    public static final int $stable = 0;
    public static final long HighResFlingTimeframe = 30;
    public static final RotaryScrollableDefaults INSTANCE = new RotaryScrollableDefaults();
    public static final long LowResFlingTimeframe = 100;
    private static final float ResistanceFactor = 3.0f;
    private static final float ThresholdDivider = 1.5f;

    private RotaryScrollableDefaults() {
    }

    public final RotaryScrollableBehavior behavior(ScrollableState scrollableState, FlingBehavior flingBehavior, boolean z, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1776156332, "C(behavior)P(2)192@8086L15,195@8206L15,196@8289L7,198@8359L67:RotaryScrollable.kt#rtmq1y");
        if ((i2 & 2) != 0) {
            flingBehavior = ScrollableDefaults.INSTANCE.flingBehavior(composer, ScrollableDefaults.$stable);
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1776156332, i, -1, "androidx.wear.compose.foundation.rotary.RotaryScrollableDefaults.behavior (RotaryScrollable.kt:194)");
        }
        boolean zIsLowResInput = isLowResInput(composer, (i >> 9) & 14);
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        RotaryScrollableBehavior rotaryScrollableBehaviorFlingBehavior = RotaryScrollableKt.flingBehavior(scrollableState, HapticsKt.rememberRotaryHapticHandler(scrollableState, z, composer, ((i >> 3) & 112) | (i & 14)), flingBehavior, zIsLowResInput, ViewConfiguration.get((Context) objConsume));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rotaryScrollableBehaviorFlingBehavior;
    }

    /* JADX INFO: renamed from: snapBehavior-942rkJo, reason: not valid java name */
    public final RotaryScrollableBehavior m495snapBehavior942rkJo(ScrollableState scrollableState, RotarySnapLayoutInfoProvider rotarySnapLayoutInfoProvider, float f, boolean z, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2052367548, "C(snapBehavior)P(2,1,3:c#ui.unit.Dp)230@9682L15,*231@9743L7,233@9840L113,238@9970L391:RotaryScrollable.kt#rtmq1y");
        float f2 = (i2 & 4) != 0 ? Dp.constructor-impl(0) : f;
        boolean z2 = (i2 & 8) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2052367548, i, -1, "androidx.wear.compose.foundation.rotary.RotaryScrollableDefaults.snapBehavior (RotaryScrollable.kt:229)");
        }
        boolean zIsLowResInput = isLowResInput(composer, (i >> 12) & 14);
        CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i3 = ((Density) objConsume).roundToPx-0680j_4(f2);
        RotaryHapticHandler rotaryHapticHandlerRememberRotaryHapticHandler = HapticsKt.rememberRotaryHapticHandler(scrollableState, z2, composer, (i & 14) | ((i >> 6) & 112));
        ComposerKt.sourceInformationMarkerStart(composer, -1317374049, "CC(remember):RotaryScrollable.kt#9igjgp");
        boolean zChanged = composer.changed(scrollableState) | ((((i & 112) ^ 48) > 32 && composer.changed(rotarySnapLayoutInfoProvider)) || (i & 48) == 32) | composer.changed(rotaryHapticHandlerRememberRotaryHapticHandler) | ((((i & 896) ^ 384) > 256 && composer.changed(f2)) || (i & 384) == 256) | composer.changed(zIsLowResInput);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = RotaryScrollableKt.snapBehavior(scrollableState, rotarySnapLayoutInfoProvider, rotaryHapticHandlerRememberRotaryHapticHandler, i3, ThresholdDivider, ResistanceFactor, zIsLowResInput);
            composer.updateRememberedValue(objRememberedValue);
        }
        RotaryScrollableBehavior rotaryScrollableBehavior = (RotaryScrollableBehavior) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rotaryScrollableBehavior;
    }

    /* JADX INFO: renamed from: snapBehavior-uFdPcIQ, reason: not valid java name */
    public final RotaryScrollableBehavior m496snapBehavioruFdPcIQ(ScalingLazyListState scalingLazyListState, float f, boolean z, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2016387470, "C(snapBehavior)P(1,2:c#ui.unit.Dp)272@11362L112,270@11276L292:RotaryScrollable.kt#rtmq1y");
        float f2 = (i2 & 2) != 0 ? Dp.constructor-impl(0) : f;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2016387470, i, -1, "androidx.wear.compose.foundation.rotary.RotaryScrollableDefaults.snapBehavior (RotaryScrollable.kt:270)");
        }
        ScalingLazyListState scalingLazyListState2 = scalingLazyListState;
        ComposerKt.sourceInformationMarkerStart(composer, -1317329784, "CC(remember):RotaryScrollable.kt#9igjgp");
        int i3 = i & 14;
        boolean z3 = ((i3 ^ 6) > 4 && composer.changed(scalingLazyListState)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new ScalingLazyColumnRotarySnapLayoutInfoProvider(scalingLazyListState);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i4 = i << 3;
        RotaryScrollableBehavior rotaryScrollableBehaviorM495snapBehavior942rkJo = m495snapBehavior942rkJo(scalingLazyListState2, (ScalingLazyColumnRotarySnapLayoutInfoProvider) objRememberedValue, f2, z2, composer, (i4 & 57344) | i3 | (i4 & 896) | (i4 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rotaryScrollableBehaviorM495snapBehavior942rkJo;
    }

    private final boolean isLowResInput(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1913552806, "C(isLowResInput)283@11739L7:RotaryScrollable.kt#rtmq1y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1913552806, i, -1, "androidx.wear.compose.foundation.rotary.RotaryScrollableDefaults.isLowResInput (RotaryScrollable.kt:283)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean zHasSystemFeature = ((Context) objConsume).getPackageManager().hasSystemFeature("android.hardware.rotaryencoder.lowres");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return zHasSystemFeature;
    }
}
