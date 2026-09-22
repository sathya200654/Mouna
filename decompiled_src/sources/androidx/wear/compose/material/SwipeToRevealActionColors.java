package androidx.wear.compose.material;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/wear/compose/material/SwipeToRevealActionColors;", "", "primaryActionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "primaryActionContentColor", "secondaryActionBackgroundColor", "secondaryActionContentColor", "undoActionBackgroundColor", "undoActionContentColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPrimaryActionBackgroundColor-0d7_KjU", "()J", "J", "getPrimaryActionContentColor-0d7_KjU", "getSecondaryActionBackgroundColor-0d7_KjU", "getSecondaryActionContentColor-0d7_KjU", "getUndoActionBackgroundColor-0d7_KjU", "getUndoActionContentColor-0d7_KjU", "equals", "", "other", "hashCode", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeToRevealActionColors {
    public static final int $stable = 0;
    private final long primaryActionBackgroundColor;
    private final long primaryActionContentColor;
    private final long secondaryActionBackgroundColor;
    private final long secondaryActionContentColor;
    private final long undoActionBackgroundColor;
    private final long undoActionContentColor;

    public /* synthetic */ SwipeToRevealActionColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    private SwipeToRevealActionColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.primaryActionBackgroundColor = j;
        this.primaryActionContentColor = j2;
        this.secondaryActionBackgroundColor = j3;
        this.secondaryActionContentColor = j4;
        this.undoActionBackgroundColor = j5;
        this.undoActionContentColor = j6;
    }

    /* JADX INFO: renamed from: getPrimaryActionBackgroundColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getPrimaryActionBackgroundColor() {
        return this.primaryActionBackgroundColor;
    }

    /* JADX INFO: renamed from: getPrimaryActionContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getPrimaryActionContentColor() {
        return this.primaryActionContentColor;
    }

    /* JADX INFO: renamed from: getSecondaryActionBackgroundColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSecondaryActionBackgroundColor() {
        return this.secondaryActionBackgroundColor;
    }

    /* JADX INFO: renamed from: getSecondaryActionContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSecondaryActionContentColor() {
        return this.secondaryActionContentColor;
    }

    /* JADX INFO: renamed from: getUndoActionBackgroundColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUndoActionBackgroundColor() {
        return this.undoActionBackgroundColor;
    }

    /* JADX INFO: renamed from: getUndoActionContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUndoActionContentColor() {
        return this.undoActionContentColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        SwipeToRevealActionColors swipeToRevealActionColors = (SwipeToRevealActionColors) other;
        return Color.equals-impl0(this.primaryActionBackgroundColor, swipeToRevealActionColors.primaryActionBackgroundColor) && Color.equals-impl0(this.primaryActionContentColor, swipeToRevealActionColors.primaryActionContentColor) && Color.equals-impl0(this.secondaryActionBackgroundColor, swipeToRevealActionColors.secondaryActionBackgroundColor) && Color.equals-impl0(this.secondaryActionContentColor, swipeToRevealActionColors.secondaryActionContentColor) && Color.equals-impl0(this.undoActionBackgroundColor, swipeToRevealActionColors.undoActionBackgroundColor) && Color.equals-impl0(this.undoActionContentColor, swipeToRevealActionColors.undoActionContentColor);
    }

    public int hashCode() {
        return (((((((((Color.hashCode-impl(this.primaryActionBackgroundColor) * 31) + Color.hashCode-impl(this.primaryActionContentColor)) * 31) + Color.hashCode-impl(this.secondaryActionBackgroundColor)) * 31) + Color.hashCode-impl(this.secondaryActionContentColor)) * 31) + Color.hashCode-impl(this.undoActionBackgroundColor)) * 31) + Color.hashCode-impl(this.undoActionContentColor);
    }
}
