package androidx.wear.compose.material;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a0\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a0\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"CalculateRippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "DefaultBoundedRipple", "Landroidx/wear/compose/material/RippleNodeFactory;", "DefaultUnboundedRipple", "LocalUseFallbackRippleImplementation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalUseFallbackRippleImplementation$annotations", "()V", "getLocalUseFallbackRippleImplementation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "RippleAlpha", "ripple", "Landroidx/compose/foundation/IndicationNodeFactory;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "bounded", "radius", "Landroidx/compose/ui/unit/Dp;", "ripple-wH6b6FI", "(Landroidx/compose/ui/graphics/ColorProducer;ZF)Landroidx/compose/foundation/IndicationNodeFactory;", "Landroidx/compose/ui/graphics/Color;", "ripple-H2RKhps", "(ZFJ)Landroidx/compose/foundation/IndicationNodeFactory;", "rippleOrFallbackImplementation", "Landroidx/compose/foundation/Indication;", "rippleOrFallbackImplementation-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RippleKt {
    private static final ProvidableCompositionLocal<Boolean> LocalUseFallbackRippleImplementation = CompositionLocalKt.staticCompositionLocalOf(new Function0<Boolean>() { // from class: androidx.wear.compose.material.RippleKt$LocalUseFallbackRippleImplementation$1
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m747invoke() {
            return false;
        }
    });
    private static final RippleNodeFactory DefaultBoundedRipple = new RippleNodeFactory(true, Dp.Companion.getUnspecified-D9Ej5fM(), Color.Companion.getUnspecified-0d7_KjU(), (DefaultConstructorMarker) null);
    private static final RippleNodeFactory DefaultUnboundedRipple = new RippleNodeFactory(false, Dp.Companion.getUnspecified-D9Ej5fM(), Color.Companion.getUnspecified-0d7_KjU(), (DefaultConstructorMarker) null);
    private static final Function0<RippleAlpha> CalculateRippleAlpha = new Function0<RippleAlpha>() { // from class: androidx.wear.compose.material.RippleKt$CalculateRippleAlpha$1
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RippleAlpha m746invoke() {
            return RippleKt.RippleAlpha;
        }
    };
    private static final RippleAlpha RippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.1f);

    public static /* synthetic */ void getLocalUseFallbackRippleImplementation$annotations() {
    }

    /* JADX INFO: renamed from: ripple-H2RKhps$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m742rippleH2RKhps$default(boolean z, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 4) != 0) {
            j = Color.Companion.getUnspecified-0d7_KjU();
        }
        return m741rippleH2RKhps(z, f, j);
    }

    /* JADX INFO: renamed from: ripple-H2RKhps, reason: not valid java name */
    public static final IndicationNodeFactory m741rippleH2RKhps(boolean z, float f, long j) {
        if (Dp.equals-impl0(f, Dp.Companion.getUnspecified-D9Ej5fM()) && Color.equals-impl0(j, Color.Companion.getUnspecified-0d7_KjU())) {
            return z ? DefaultBoundedRipple : DefaultUnboundedRipple;
        }
        return new RippleNodeFactory(z, f, j, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: ripple-wH6b6FI$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m744ripplewH6b6FI$default(ColorProducer colorProducer, boolean z, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return m743ripplewH6b6FI(colorProducer, z, f);
    }

    /* JADX INFO: renamed from: ripple-wH6b6FI, reason: not valid java name */
    public static final IndicationNodeFactory m743ripplewH6b6FI(ColorProducer colorProducer, boolean z, float f) {
        return new RippleNodeFactory(z, f, colorProducer, (DefaultConstructorMarker) null);
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUseFallbackRippleImplementation() {
        return LocalUseFallbackRippleImplementation;
    }

    /* JADX INFO: renamed from: rippleOrFallbackImplementation-9IZ8Weo, reason: not valid java name */
    public static final Indication m745rippleOrFallbackImplementation9IZ8Weo(boolean z, float f, long j, Composer composer, int i, int i2) {
        Composer composer2;
        Indication indicationM741rippleH2RKhps;
        ComposerKt.sourceInformationMarkerStart(composer, -247093069, "C(rippleOrFallbackImplementation)P(!1,2:c#ui.unit.Dp,1:c#ui.graphics.Color):Ripple.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        float f2 = f;
        if ((i2 & 4) != 0) {
            j = Color.Companion.getUnspecified-0d7_KjU();
        }
        long j2 = j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-247093069, i, -1, "androidx.wear.compose.material.rippleOrFallbackImplementation (Ripple.kt:179)");
        }
        composer.startReplaceGroup(-1538427163);
        ComposerKt.sourceInformation(composer, "180@8322L7,181@8374L38");
        CompositionLocal compositionLocal = LocalUseFallbackRippleImplementation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(compositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (((Boolean) objConsume).booleanValue()) {
            composer2 = composer;
            indicationM741rippleH2RKhps = androidx.compose.material.ripple.RippleKt.rememberRipple-9IZ8Weo(z2, f2, j2, composer2, i & 1022, 0);
        } else {
            composer2 = composer;
            indicationM741rippleH2RKhps = m741rippleH2RKhps(z2, f2, j2);
        }
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return indicationM741rippleH2RKhps;
    }
}
