package androidx.wear.compose.material;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: SwipeToDismissBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Deprecated(message = "Please import SwipeToDismissBoxDefaults from androidx.wear.compose.foundation.")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/wear/compose/material/SwipeToDismissBoxDefaults;", "", "()V", "AnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getAnimationSpec$annotations", "getAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "EdgeWidth", "Landroidx/compose/ui/unit/Dp;", "getEdgeWidth-D9Ej5fM", "()F", "F", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeToDismissBoxDefaults {
    public static final int $stable = 0;
    public static final SwipeToDismissBoxDefaults INSTANCE = new SwipeToDismissBoxDefaults();
    private static final SpringSpec<Float> AnimationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
    private static final float EdgeWidth = Dp.constructor-impl(30);

    public static /* synthetic */ void getAnimationSpec$annotations() {
    }

    private SwipeToDismissBoxDefaults() {
    }

    public final SpringSpec<Float> getAnimationSpec() {
        return AnimationSpec;
    }

    /* JADX INFO: renamed from: getEdgeWidth-D9Ej5fM, reason: not valid java name */
    public final float m806getEdgeWidthD9Ej5fM() {
        return EdgeWidth;
    }
}
