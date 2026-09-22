package androidx.wear.compose.foundation.rotary;

import android.view.ViewConfiguration;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import com.azure.core.implementation.logging.DefaultLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001a4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a@\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a7\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0019\b\u0002\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00030\u001e¢\u0006\u0002\b H\u0000\u001a$\u0010!\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u001c\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {DefaultLogger.DEBUG, "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "flingBehavior", "Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "rotaryHaptics", "Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "isLowRes", "viewConfiguration", "Landroid/view/ViewConfiguration;", "snapBehavior", "layoutInfoProvider", "Landroidx/wear/compose/foundation/rotary/RotarySnapLayoutInfoProvider;", "snapOffset", "", "maxThresholdDivider", "", "scrollDistanceDivider", "rotaryHandler", "Landroidx/compose/ui/Modifier;", "behavior", "reverseDirection", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "Lkotlin/ExtensionFunctionType;", "rotaryScrollable", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RotaryScrollableKt {
    private static final boolean DEBUG = false;

    private static final void debugLog(Function0<String> function0) {
    }

    public static /* synthetic */ Modifier rotaryScrollable$default(Modifier modifier, RotaryScrollableBehavior rotaryScrollableBehavior, FocusRequester focusRequester, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return rotaryScrollable(modifier, rotaryScrollableBehavior, focusRequester, z);
    }

    public static final Modifier rotaryScrollable(Modifier modifier, RotaryScrollableBehavior rotaryScrollableBehavior, FocusRequester focusRequester, boolean z) {
        return FocusModifierKt.focusTarget(FocusRequesterModifierKt.focusRequester(rotaryHandler$default(modifier, rotaryScrollableBehavior, z, null, 4, null), focusRequester));
    }

    static /* synthetic */ RotaryScrollableBehavior flingBehavior$default(ScrollableState scrollableState, RotaryHapticHandler rotaryHapticHandler, FlingBehavior flingBehavior, boolean z, ViewConfiguration viewConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        return flingBehavior(scrollableState, rotaryHapticHandler, flingBehavior, z, viewConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RotaryFlingHandler flingBehavior$rotaryFlingHandler(FlingBehavior flingBehavior, ScrollableState scrollableState, ViewConfiguration viewConfiguration, boolean z) {
        if (flingBehavior != null) {
            return new RotaryFlingHandler(scrollableState, flingBehavior, viewConfiguration, z ? 100L : 30L);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RotaryScrollHandler flingBehavior$scrollHandler(ScrollableState scrollableState) {
        return new RotaryScrollHandler(scrollableState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RotaryScrollableBehavior flingBehavior(final ScrollableState scrollableState, RotaryHapticHandler rotaryHapticHandler, final FlingBehavior flingBehavior, final boolean z, final ViewConfiguration viewConfiguration) {
        return new FlingRotaryScrollableBehavior(z, rotaryHapticHandler, new Function0<RotaryFlingHandler>() { // from class: androidx.wear.compose.foundation.rotary.RotaryScrollableKt.flingBehavior.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RotaryFlingHandler m497invoke() {
                return RotaryScrollableKt.flingBehavior$rotaryFlingHandler(flingBehavior, scrollableState, viewConfiguration, z);
            }
        }, new Function0<RotaryScrollHandler>() { // from class: androidx.wear.compose.foundation.rotary.RotaryScrollableKt.flingBehavior.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RotaryScrollHandler m498invoke() {
                return RotaryScrollableKt.flingBehavior$scrollHandler(scrollableState);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RotaryScrollableBehavior snapBehavior(final ScrollableState scrollableState, final RotarySnapLayoutInfoProvider rotarySnapLayoutInfoProvider, RotaryHapticHandler rotaryHapticHandler, final int i, final float f, float f2, boolean z) {
        if (z) {
            return new LowResSnapRotaryScrollableBehavior(rotaryHapticHandler, new Function0<RotarySnapHandler>() { // from class: androidx.wear.compose.foundation.rotary.RotaryScrollableKt.snapBehavior.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final RotarySnapHandler m499invoke() {
                    return new RotarySnapHandler(scrollableState, rotarySnapLayoutInfoProvider, i);
                }
            });
        }
        return new HighResSnapRotaryScrollableBehavior(rotaryHapticHandler, f2, new Function0<ThresholdHandler>() { // from class: androidx.wear.compose.foundation.rotary.RotaryScrollableKt.snapBehavior.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ThresholdHandler m500invoke() {
                float f3 = f;
                final RotarySnapLayoutInfoProvider rotarySnapLayoutInfoProvider2 = rotarySnapLayoutInfoProvider;
                return new ThresholdHandler(f3, 0.0f, 0.0f, 0.0f, new Function0<Float>() { // from class: androidx.wear.compose.foundation.rotary.RotaryScrollableKt.snapBehavior.2.1
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Float m501invoke() {
                        return Float.valueOf(rotarySnapLayoutInfoProvider2.getAverageItemSize());
                    }
                }, 14, null);
            }
        }, new Function0<RotarySnapHandler>() { // from class: androidx.wear.compose.foundation.rotary.RotaryScrollableKt.snapBehavior.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RotarySnapHandler m502invoke() {
                return new RotarySnapHandler(scrollableState, rotarySnapLayoutInfoProvider, i);
            }
        }, new Function0<RotaryScrollHandler>() { // from class: androidx.wear.compose.foundation.rotary.RotaryScrollableKt.snapBehavior.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RotaryScrollHandler m503invoke() {
                return new RotaryScrollHandler(scrollableState);
            }
        });
    }

    public static final Modifier rotaryHandler(Modifier modifier, RotaryScrollableBehavior rotaryScrollableBehavior, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        return modifier.then(new RotaryHandlerElement(rotaryScrollableBehavior, z, function1));
    }

    public static /* synthetic */ Modifier rotaryHandler$default(Modifier modifier, final RotaryScrollableBehavior rotaryScrollableBehavior, final boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.wear.compose.foundation.rotary.RotaryScrollableKt$rotaryHandler$default$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((InspectorInfo) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("rotaryHandler");
                    inspectorInfo.getProperties().set("behavior", rotaryScrollableBehavior);
                    inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(z));
                }
            } : InspectableValueKt.getNoInspectorInfo();
        }
        return rotaryHandler(modifier, rotaryScrollableBehavior, z, function1);
    }
}
