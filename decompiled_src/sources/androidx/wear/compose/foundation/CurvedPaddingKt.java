package androidx.wear.compose.foundation;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: CurvedPadding.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a8\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001e\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a4\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"ArcPaddingValues", "Landroidx/wear/compose/foundation/ArcPaddingValues;", "all", "Landroidx/compose/ui/unit/Dp;", "ArcPaddingValues-0680j_4", "(F)Landroidx/wear/compose/foundation/ArcPaddingValues;", "radial", "angular", "ArcPaddingValues-YgX7TsA", "(FF)Landroidx/wear/compose/foundation/ArcPaddingValues;", "outer", "inner", "before", "after", "ArcPaddingValues-a9UjIt4", "(FFFF)Landroidx/wear/compose/foundation/ArcPaddingValues;", "padding", "Landroidx/wear/compose/foundation/CurvedModifier;", "padding-3ABfNKs", "(Landroidx/wear/compose/foundation/CurvedModifier;F)Landroidx/wear/compose/foundation/CurvedModifier;", "padding-VpY3zN4", "(Landroidx/wear/compose/foundation/CurvedModifier;FF)Landroidx/wear/compose/foundation/CurvedModifier;", "padding-qDBjuR0", "(Landroidx/wear/compose/foundation/CurvedModifier;FFFF)Landroidx/wear/compose/foundation/CurvedModifier;", "paddingValues", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurvedPaddingKt {
    public static final CurvedModifier padding(CurvedModifier curvedModifier, final ArcPaddingValues arcPaddingValues) {
        return CurvedModifierKt.then(curvedModifier, new Element() { // from class: androidx.wear.compose.foundation.CurvedPaddingKt$$ExternalSyntheticLambda0
            @Override // androidx.wear.compose.foundation.Element
            public final CurvedChild wrap(CurvedChild curvedChild) {
                return CurvedPaddingKt.padding$lambda$0(arcPaddingValues, curvedChild);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CurvedChild padding$lambda$0(ArcPaddingValues arcPaddingValues, CurvedChild curvedChild) {
        return new PaddingWrapper(curvedChild, arcPaddingValues);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final CurvedModifier m346paddingqDBjuR0(CurvedModifier curvedModifier, float f, float f2, float f3, float f4) {
        return padding(curvedModifier, new ArcPaddingValuesImpl(f, f2, f3, f4, null));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final CurvedModifier m344paddingVpY3zN4(CurvedModifier curvedModifier, float f, float f2) {
        return m346paddingqDBjuR0(curvedModifier, f, f, f2, f2);
    }

    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final CurvedModifier m342padding3ABfNKs(CurvedModifier curvedModifier, float f) {
        return m346paddingqDBjuR0(curvedModifier, f, f, f, f);
    }

    /* JADX INFO: renamed from: ArcPaddingValues-a9UjIt4, reason: not valid java name */
    public static final ArcPaddingValues m340ArcPaddingValuesa9UjIt4(float f, float f2, float f3, float f4) {
        return new ArcPaddingValuesImpl(f, f2, f3, f4, null);
    }

    /* JADX INFO: renamed from: ArcPaddingValues-0680j_4, reason: not valid java name */
    public static final ArcPaddingValues m337ArcPaddingValues0680j_4(float f) {
        return new ArcPaddingValuesImpl(f, f, f, f, null);
    }

    /* JADX INFO: renamed from: ArcPaddingValues-YgX7TsA, reason: not valid java name */
    public static final ArcPaddingValues m338ArcPaddingValuesYgX7TsA(float f, float f2) {
        return new ArcPaddingValuesImpl(f, f, f2, f2, null);
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ CurvedModifier m345paddingVpY3zN4$default(CurvedModifier curvedModifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.constructor-impl(0);
        }
        return m344paddingVpY3zN4(curvedModifier, f, f2);
    }

    /* JADX INFO: renamed from: padding-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ CurvedModifier m343padding3ABfNKs$default(CurvedModifier curvedModifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.constructor-impl(0);
        }
        return m342padding3ABfNKs(curvedModifier, f);
    }

    /* JADX INFO: renamed from: ArcPaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ ArcPaddingValues m341ArcPaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.constructor-impl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.constructor-impl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.constructor-impl(0);
        }
        return m340ArcPaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: ArcPaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ ArcPaddingValues m339ArcPaddingValuesYgX7TsA$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.constructor-impl(0);
        }
        return m338ArcPaddingValuesYgX7TsA(f, f2);
    }
}
