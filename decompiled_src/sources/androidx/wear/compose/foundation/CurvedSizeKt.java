package androidx.wear.compose.foundation;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: CurvedSize.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\b\u001a&\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a<\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"angularSize", "Landroidx/wear/compose/foundation/CurvedModifier;", "sweepDegrees", "", "angularSizeDp", "angularWidth", "Landroidx/compose/ui/unit/Dp;", "angularSizeDp-3ABfNKs", "(Landroidx/wear/compose/foundation/CurvedModifier;F)Landroidx/wear/compose/foundation/CurvedModifier;", "radialSize", "thickness", "radialSize-3ABfNKs", "size", "size-wH6b6FI", "(Landroidx/wear/compose/foundation/CurvedModifier;FF)Landroidx/wear/compose/foundation/CurvedModifier;", "sizeIn", "minSweepDegrees", "maxSweepDegrees", "minThickness", "maxThickness", "sizeIn-oZzcvok", "(Landroidx/wear/compose/foundation/CurvedModifier;FFFF)Landroidx/wear/compose/foundation/CurvedModifier;", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurvedSizeKt {
    /* JADX INFO: renamed from: sizeIn-oZzcvok, reason: not valid java name */
    public static final CurvedModifier m355sizeInoZzcvok(CurvedModifier curvedModifier, final float f, final float f2, final float f3, final float f4) {
        return CurvedModifierKt.then(curvedModifier, new Element() { // from class: androidx.wear.compose.foundation.CurvedSizeKt$$ExternalSyntheticLambda1
            @Override // androidx.wear.compose.foundation.Element
            public final CurvedChild wrap(CurvedChild curvedChild) {
                return CurvedSizeKt.sizeIn_oZzcvok$lambda$0(f, f2, f3, f4, curvedChild);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CurvedChild sizeIn_oZzcvok$lambda$0(float f, float f2, float f3, float f4, CurvedChild curvedChild) {
        return new SweepSizeWrapper(curvedChild, f, f2, f3, f4, null);
    }

    /* JADX INFO: renamed from: size-wH6b6FI, reason: not valid java name */
    public static final CurvedModifier m354sizewH6b6FI(CurvedModifier curvedModifier, float f, float f2) {
        return m355sizeInoZzcvok(curvedModifier, f, f, f2, f2);
    }

    /* JADX INFO: renamed from: angularSizeDp-3ABfNKs, reason: not valid java name */
    public static final CurvedModifier m352angularSizeDp3ABfNKs(CurvedModifier curvedModifier, final float f) {
        return CurvedModifierKt.then(curvedModifier, new Element() { // from class: androidx.wear.compose.foundation.CurvedSizeKt$$ExternalSyntheticLambda0
            @Override // androidx.wear.compose.foundation.Element
            public final CurvedChild wrap(CurvedChild curvedChild) {
                return CurvedSizeKt.angularSizeDp_3ABfNKs$lambda$1(f, curvedChild);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CurvedChild angularSizeDp_3ABfNKs$lambda$1(float f, CurvedChild curvedChild) {
        return new AngularWidthSizeWrapper(curvedChild, f, f, Dp.constructor-impl(0), Dp.Companion.getInfinity-D9Ej5fM(), null);
    }

    public static final CurvedModifier angularSize(CurvedModifier curvedModifier, float f) {
        return m356sizeInoZzcvok$default(curvedModifier, f, f, 0.0f, 0.0f, 12, null);
    }

    /* JADX INFO: renamed from: radialSize-3ABfNKs, reason: not valid java name */
    public static final CurvedModifier m353radialSize3ABfNKs(CurvedModifier curvedModifier, float f) {
        return m356sizeInoZzcvok$default(curvedModifier, 0.0f, 0.0f, f, f, 3, null);
    }

    /* JADX INFO: renamed from: sizeIn-oZzcvok$default, reason: not valid java name */
    public static /* synthetic */ CurvedModifier m356sizeInoZzcvok$default(CurvedModifier curvedModifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 360.0f;
        }
        if ((i & 4) != 0) {
            f3 = Dp.constructor-impl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.getInfinity-D9Ej5fM();
        }
        return m355sizeInoZzcvok(curvedModifier, f, f2, f3, f4);
    }
}
