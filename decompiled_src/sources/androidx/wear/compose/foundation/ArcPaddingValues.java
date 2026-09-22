package androidx.wear.compose.foundation;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* JADX INFO: compiled from: CurvedPadding.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0010ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Landroidx/wear/compose/foundation/ArcPaddingValues;", "", "calculateAfterPadding", "Landroidx/compose/ui/unit/Dp;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "angularDirection", "Landroidx/wear/compose/foundation/CurvedDirection$Angular;", "calculateAfterPadding-h2ZJBLU", "(Landroidx/compose/ui/unit/LayoutDirection;I)F", "calculateBeforePadding", "calculateBeforePadding-h2ZJBLU", "calculateInnerPadding", "radialDirection", "Landroidx/wear/compose/foundation/CurvedDirection$Radial;", "calculateInnerPadding-bxc3Tjc", "(I)F", "calculateOuterPadding", "calculateOuterPadding-bxc3Tjc", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ArcPaddingValues {
    /* JADX INFO: renamed from: calculateAfterPadding-h2ZJBLU, reason: not valid java name */
    float mo226calculateAfterPaddingh2ZJBLU(LayoutDirection layoutDirection, int angularDirection);

    /* JADX INFO: renamed from: calculateBeforePadding-h2ZJBLU, reason: not valid java name */
    float mo227calculateBeforePaddingh2ZJBLU(LayoutDirection layoutDirection, int angularDirection);

    /* JADX INFO: renamed from: calculateInnerPadding-bxc3Tjc, reason: not valid java name */
    float mo228calculateInnerPaddingbxc3Tjc(int radialDirection);

    /* JADX INFO: renamed from: calculateOuterPadding-bxc3Tjc, reason: not valid java name */
    float mo229calculateOuterPaddingbxc3Tjc(int radialDirection);
}
