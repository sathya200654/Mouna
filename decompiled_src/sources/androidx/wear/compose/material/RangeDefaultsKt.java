package androidx.wear.compose.material;

import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.wear.compose.materialcore.RangeDefaults;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntProgression;

/* JADX INFO: compiled from: RangeDefaults.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\f\u0010\r\u001a\u00020\f*\u00020\u000eH\u0000¨\u0006\u000f"}, d2 = {"rangeSemantics", "Landroidx/compose/ui/Modifier;", "value", "", "enabled", "", "onValueChange", "Lkotlin/Function1;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "stepsNumber", "Lkotlin/ranges/IntProgression;", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RangeDefaultsKt {
    public static final Modifier rangeSemantics(Modifier modifier, float f, final boolean z, final Function1<? super Float, Unit> function1, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int i) {
        final int iSnapValueToStep = RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRange, i);
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics(modifier, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.RangeDefaultsKt.rangeSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                if (!z) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = closedFloatingPointRange;
                final int i2 = i;
                final int i3 = iSnapValueToStep;
                final Function1<Float, Unit> function2 = function1;
                SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, (String) null, new Function1<Float, Boolean>() { // from class: androidx.wear.compose.material.RangeDefaultsKt.rangeSemantics.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).floatValue());
                    }

                    public final Boolean invoke(float f2) {
                        boolean z2;
                        if (i3 == RangeDefaults.INSTANCE.snapValueToStep(f2, closedFloatingPointRange2, i2)) {
                            z2 = false;
                        } else {
                            function2.invoke(Float.valueOf(f2));
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    }
                }, 1, (Object) null);
            }
        }), RangeDefaults.INSTANCE.calculateCurrentStepValue(iSnapValueToStep, i, closedFloatingPointRange), closedFloatingPointRange, i);
    }

    public static final int stepsNumber(IntProgression intProgression) {
        return ((intProgression.getLast() - intProgression.getFirst()) / intProgression.getStep()) - 1;
    }
}
