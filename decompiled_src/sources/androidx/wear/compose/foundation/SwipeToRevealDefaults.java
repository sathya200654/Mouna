package androidx.wear.compose.foundation;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\tX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR:\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0002\b\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/wear/compose/foundation/SwipeToRevealDefaults;", "", "()V", "animationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getAnimationSpec$compose_foundation_release", "()Landroidx/compose/animation/core/SpringSpec;", "padding", "Landroidx/compose/ui/unit/Dp;", "getPadding-D9Ej5fM$compose_foundation_release", "()F", "F", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", "name", "distance", "Lkotlin/ExtensionFunctionType;", "getPositionalThreshold$compose_foundation_release", "()Lkotlin/jvm/functions/Function2;", "revealingRatio", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeToRevealDefaults {
    public static final int $stable = 0;
    public static final SwipeToRevealDefaults INSTANCE = new SwipeToRevealDefaults();
    private static final SpringSpec<Float> animationSpec = SwipeableV2Defaults.INSTANCE.getAnimationSpec();
    private static final float padding = Dp.constructor-impl(2);
    private static final Function2<Density, Float, Float> positionalThreshold = SwipeableV2Kt.fractionalPositionalThreshold(0.5f);
    public static final float revealingRatio = 0.7f;

    private SwipeToRevealDefaults() {
    }

    public final SpringSpec<Float> getAnimationSpec$compose_foundation_release() {
        return animationSpec;
    }

    /* JADX INFO: renamed from: getPadding-D9Ej5fM$compose_foundation_release, reason: not valid java name */
    public final float m415getPaddingD9Ej5fM$compose_foundation_release() {
        return padding;
    }

    public final Function2<Density, Float, Float> getPositionalThreshold$compose_foundation_release() {
        return positionalThreshold;
    }
}
