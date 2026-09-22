package coil3.compose.internal;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class UtilsKt$UseMinConstraintsMeasurePolicy$1 implements MeasurePolicy {
    public static final UtilsKt$UseMinConstraintsMeasurePolicy$1 INSTANCE = new UtilsKt$UseMinConstraintsMeasurePolicy$1();

    UtilsKt$UseMinConstraintsMeasurePolicy$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m1047measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        return MeasureScope.layout$default(measureScope, Constraints.getMinWidth-impl(j), Constraints.getMinHeight-impl(j), (Map) null, new Function1() { // from class: coil3.compose.internal.UtilsKt$UseMinConstraintsMeasurePolicy$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return UtilsKt$UseMinConstraintsMeasurePolicy$1.measure_3p2s80s$lambda$0((Placeable.PlacementScope) obj);
            }
        }, 4, (Object) null);
    }
}
