package androidx.wear.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Expandable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BN\b\u0000\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/wear/compose/foundation/ExpandableStateMapping;", "T", "", "initiallyExpanded", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "expandAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "collapseAnimationSpec", "(Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "states", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/wear/compose/foundation/ExpandableState;", "getOrPutNew", "(Ljava/lang/Object;)Landroidx/wear/compose/foundation/ExpandableState;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExpandableStateMapping<T> {
    public static final int $stable = 8;
    private final AnimationSpec<Float> collapseAnimationSpec;
    private final CoroutineScope coroutineScope;
    private final AnimationSpec<Float> expandAnimationSpec;
    private final Function1<T, Boolean> initiallyExpanded;
    private final SnapshotStateMap<T, ExpandableState> states = SnapshotStateKt.mutableStateMapOf();

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandableStateMapping(Function1<? super T, Boolean> function1, CoroutineScope coroutineScope, AnimationSpec<Float> animationSpec, AnimationSpec<Float> animationSpec2) {
        this.initiallyExpanded = function1;
        this.coroutineScope = coroutineScope;
        this.expandAnimationSpec = animationSpec;
        this.collapseAnimationSpec = animationSpec2;
    }

    public final ExpandableState getOrPutNew(T key) {
        Map map = this.states;
        Object expandableState = map.get(key);
        if (expandableState == null) {
            expandableState = new ExpandableState(((Boolean) this.initiallyExpanded.invoke(key)).booleanValue(), this.coroutineScope, this.expandAnimationSpec, this.collapseAnimationSpec);
            map.put(key, expandableState);
        }
        return (ExpandableState) expandableState;
    }
}
