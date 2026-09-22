package androidx.wear.compose.foundation.lazy;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScalingLazyColumn.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000e\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\fJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u001c\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/wear/compose/foundation/lazy/CombinedPaddingValues;", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "extraPadding", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/foundation/layout/PaddingValues;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentPadding$annotations", "()V", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "getExtraPadding-D9Ej5fM$annotations", "getExtraPadding-D9Ej5fM", "()F", "F", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CombinedPaddingValues implements PaddingValues {
    public static final int $stable = 0;
    private final PaddingValues contentPadding;
    private final float extraPadding;

    public /* synthetic */ CombinedPaddingValues(PaddingValues paddingValues, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(paddingValues, f);
    }

    public static /* synthetic */ void getContentPadding$annotations() {
    }

    /* JADX INFO: renamed from: getExtraPadding-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m440getExtraPaddingD9Ej5fM$annotations() {
    }

    private CombinedPaddingValues(PaddingValues paddingValues, float f) {
        this.contentPadding = paddingValues;
        this.extraPadding = f;
    }

    public final PaddingValues getContentPadding() {
        return this.contentPadding;
    }

    /* JADX INFO: renamed from: getExtraPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getExtraPadding() {
        return this.extraPadding;
    }

    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM, reason: not valid java name */
    public float m442calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return this.contentPadding.calculateLeftPadding-u2uoSUM(layoutDirection);
    }

    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM, reason: not valid java name */
    public float m444calculateTopPaddingD9Ej5fM() {
        return Dp.constructor-impl(this.contentPadding.calculateTopPadding-D9Ej5fM() + this.extraPadding);
    }

    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM, reason: not valid java name */
    public float m443calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return this.contentPadding.calculateRightPadding-u2uoSUM(layoutDirection);
    }

    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM, reason: not valid java name */
    public float m441calculateBottomPaddingD9Ej5fM() {
        return Dp.constructor-impl(this.contentPadding.calculateBottomPadding-D9Ej5fM() + this.extraPadding);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CombinedPaddingValues combinedPaddingValues = (CombinedPaddingValues) other;
        return Intrinsics.areEqual(this.contentPadding, combinedPaddingValues.contentPadding) && Dp.equals-impl0(this.extraPadding, combinedPaddingValues.extraPadding);
    }

    public int hashCode() {
        return (this.contentPadding.hashCode() * 31) + Dp.hashCode-impl(this.extraPadding);
    }

    public String toString() {
        return "CombinedPaddingValuesImpl(contentPadding=" + this.contentPadding + ", extraPadding=" + ((Object) Dp.toString-impl(this.extraPadding)) + ')';
    }
}
