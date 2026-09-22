package androidx.wear.compose.foundation;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwipeableV2.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0082\u0001\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0000\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a26\u0010\u001b\u001a2\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\t2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001e0 H\u0001¢\u0006\u0002\b!R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R7\u0010\b\u001a(\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\b\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/wear/compose/foundation/SwipeableV2Defaults;", "", "()V", "AnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "PositionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", "name", "totalDistance", "Lkotlin/ExtensionFunctionType;", "getPositionalThreshold", "()Lkotlin/jvm/functions/Function2;", "VelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "getVelocityThreshold-D9Ej5fM", "()F", "F", "ReconcileAnimationOnAnchorChangeHandler", "Landroidx/wear/compose/foundation/AnchorChangeHandler;", "T", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/wear/compose/foundation/SwipeableV2State;", "animate", "target", "velocity", "", "snap", "Lkotlin/Function1;", "ReconcileAnimationOnAnchorChangeHandler$compose_foundation_release", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeableV2Defaults {
    public static final int $stable = 0;
    public static final SwipeableV2Defaults INSTANCE = new SwipeableV2Defaults();
    private static final SpringSpec<Float> AnimationSpec = new SpringSpec<>(0.0f, 0.0f, (Object) null, 7, (DefaultConstructorMarker) null);
    private static final float VelocityThreshold = Dp.constructor-impl(125);
    private static final Function2<Density, Float, Float> PositionalThreshold = SwipeableV2Kt.m425fixedPositionalThreshold0680j_4(Dp.constructor-impl(56));

    private SwipeableV2Defaults() {
    }

    public final SpringSpec<Float> getAnimationSpec() {
        return AnimationSpec;
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM, reason: not valid java name */
    public final float m424getVelocityThresholdD9Ej5fM() {
        return VelocityThreshold;
    }

    public final Function2<Density, Float, Float> getPositionalThreshold() {
        return PositionalThreshold;
    }

    public final <T> AnchorChangeHandler<T> ReconcileAnimationOnAnchorChangeHandler$compose_foundation_release(final SwipeableV2State<T> state, final Function2<? super T, ? super Float, Unit> animate, final Function1<? super T, Unit> snap) {
        return new AnchorChangeHandler() { // from class: androidx.wear.compose.foundation.SwipeableV2Defaults$$ExternalSyntheticLambda0
            @Override // androidx.wear.compose.foundation.AnchorChangeHandler
            public final void onAnchorsChanged(Object obj, Map map, Map map2) {
                SwipeableV2Defaults.ReconcileAnimationOnAnchorChangeHandler$lambda$0(animate, state, snap, obj, map, map2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReconcileAnimationOnAnchorChangeHandler$lambda$0(Function2 function2, SwipeableV2State swipeableV2State, Function1 function1, Object obj, Map map, Map map2) {
        Float f = (Float) map.get(obj);
        Float f2 = (Float) map2.get(obj);
        if (Intrinsics.areEqual(f, f2)) {
            return;
        }
        if (f2 != null) {
            function2.invoke(obj, Float.valueOf(swipeableV2State.getLastVelocity()));
        } else {
            function1.invoke(SwipeableV2Kt.closestAnchor$default(map2, swipeableV2State.requireOffset(), false, 2, null));
        }
    }
}
