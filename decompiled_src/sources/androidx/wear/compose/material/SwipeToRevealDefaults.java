package androidx.wear.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DeleteKt;
import androidx.compose.material.icons.outlined.MoreVertKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0003\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/wear/compose/material/SwipeToRevealDefaults;", "", "()V", "ActionMaxHeight", "Landroidx/compose/ui/unit/Dp;", "getActionMaxHeight-D9Ej5fM$compose_material_release", "()F", "F", "CardActionShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getCardActionShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "Delete", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getDelete", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "MoreOptions", "getMoreOptions", "UndoButtonHorizontalPadding", "getUndoButtonHorizontalPadding-D9Ej5fM$compose_material_release", "UndoButtonVerticalPadding", "getUndoButtonVerticalPadding-D9Ej5fM$compose_material_release", "actionColors", "Landroidx/wear/compose/material/SwipeToRevealActionColors;", "primaryActionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "primaryActionContentColor", "secondaryActionBackgroundColor", "secondaryActionContentColor", "undoActionBackgroundColor", "undoActionContentColor", "actionColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/SwipeToRevealActionColors;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeToRevealDefaults {
    public static final int $stable = 0;
    public static final SwipeToRevealDefaults INSTANCE = new SwipeToRevealDefaults();
    private static final RoundedCornerShape CardActionShape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(40));
    private static final ImageVector Delete = DeleteKt.getDelete(Icons.Outlined.INSTANCE);
    private static final ImageVector MoreOptions = MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE);
    private static final float UndoButtonHorizontalPadding = Dp.constructor-impl(14);
    private static final float UndoButtonVerticalPadding = Dp.constructor-impl(6);
    private static final float ActionMaxHeight = Dp.constructor-impl(84);

    private SwipeToRevealDefaults() {
    }

    public final RoundedCornerShape getCardActionShape() {
        return CardActionShape;
    }

    /* JADX INFO: renamed from: actionColors-5tl4gsc, reason: not valid java name */
    public final SwipeToRevealActionColors m819actionColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2000948611, "C(actionColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color)320@14418L6,321@14489L6,322@14567L6,323@14642L6,324@14717L6,325@14787L6:SwipeToReveal.kt#gj9v0t");
        long error = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getError() : j;
        long onError = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnError() : j2;
        long surface = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j3;
        long onSurface = (i2 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface() : j4;
        long surface2 = (i2 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j5;
        long onSurface2 = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2000948611, i, -1, "androidx.wear.compose.material.SwipeToRevealDefaults.actionColors (SwipeToReveal.kt:326)");
        }
        SwipeToRevealActionColors swipeToRevealActionColors = new SwipeToRevealActionColors(error, onError, surface, onSurface, surface2, onSurface2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return swipeToRevealActionColors;
    }

    public final ImageVector getDelete() {
        return Delete;
    }

    public final ImageVector getMoreOptions() {
        return MoreOptions;
    }

    /* JADX INFO: renamed from: getUndoButtonHorizontalPadding-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m821getUndoButtonHorizontalPaddingD9Ej5fM$compose_material_release() {
        return UndoButtonHorizontalPadding;
    }

    /* JADX INFO: renamed from: getUndoButtonVerticalPadding-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m822getUndoButtonVerticalPaddingD9Ej5fM$compose_material_release() {
        return UndoButtonVerticalPadding;
    }

    /* JADX INFO: renamed from: getActionMaxHeight-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m820getActionMaxHeightD9Ej5fM$compose_material_release() {
        return ActionMaxHeight;
    }
}
