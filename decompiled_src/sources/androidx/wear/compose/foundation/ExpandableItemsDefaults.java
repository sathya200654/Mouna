package androidx.wear.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Expandable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/wear/compose/foundation/ExpandableItemsDefaults;", "", "()V", "collapseAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getCollapseAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "expandAnimationSpec", "getExpandAnimationSpec", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExpandableItemsDefaults {
    public static final ExpandableItemsDefaults INSTANCE = new ExpandableItemsDefaults();
    private static final AnimationSpec<Float> expandAnimationSpec = new TweenSpec<>(1000, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final AnimationSpec<Float> collapseAnimationSpec = new TweenSpec<>(1000, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    public static final int $stable = 8;

    private ExpandableItemsDefaults() {
    }

    public final AnimationSpec<Float> getExpandAnimationSpec() {
        return expandAnimationSpec;
    }

    public final AnimationSpec<Float> getCollapseAnimationSpec() {
        return collapseAnimationSpec;
    }
}
