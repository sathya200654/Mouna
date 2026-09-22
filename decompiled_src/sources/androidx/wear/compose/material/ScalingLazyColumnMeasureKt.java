package androidx.wear.compose.material;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.wear.compose.foundation.lazy.ScaleAndAlpha;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ScalingLazyColumnMeasure.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a:\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001e\u0010 \u001a\u00020!*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001e\u0010$\u001a\u00020!*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"calculateItemInfo", "Landroidx/wear/compose/material/ScalingLazyListItemInfo;", "itemStart", "", "item", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "verticalAdjustment", "viewportHeightPx", "viewportCenterLinePx", "scalingParams", "Landroidx/wear/compose/material/ScalingParams;", "beforeContentPaddingPx", "anchorType", "Landroidx/wear/compose/material/ScalingLazyListAnchorType;", "autoCentering", "Landroidx/wear/compose/material/AutoCenteringParams;", "visible", "", "calculateItemInfo-CuKLY0U", "(ILandroidx/compose/foundation/lazy/LazyListItemInfo;IIILandroidx/wear/compose/material/ScalingParams;IILandroidx/wear/compose/material/AutoCenteringParams;Z)Landroidx/wear/compose/material/ScalingLazyListItemInfo;", "calculateScaleAndAlpha", "Landroidx/wear/compose/foundation/lazy/ScaleAndAlpha;", "viewPortStartPx", "viewPortEndPx", "itemTopPx", "itemBottomPx", "convertToCenterOffset", "itemScrollOffset", "beforeContentPaddingInPx", "itemSizeInPx", "convertToCenterOffset-FiSRsrk", "(IIIII)I", "startOffset", "", "startOffset-nK7FVxM", "(Landroidx/wear/compose/material/ScalingLazyListItemInfo;I)F", "unadjustedStartOffset", "unadjustedStartOffset-nK7FVxM", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScalingLazyColumnMeasureKt {
    /* JADX WARN: Code duplicated, block: B:7:0x0050  */
    public static final ScaleAndAlpha calculateScaleAndAlpha(int i, int i2, int i3, int i4, ScalingParams scalingParams) {
        float fLerp;
        float f = i4 - i3;
        float f2 = i2 - i;
        float f3 = 1.0f;
        if (f2 > 0.0f) {
            float fMin = Math.min(i2 - i3, i4 - i) / f2;
            float fLerp2 = MathHelpersKt.lerp(scalingParams.getMinTransitionArea(), scalingParams.getMaxTransitionArea(), androidx.wear.compose.foundation.lazy.ScalingLazyColumnMeasureKt.inverseLerp(scalingParams.getMinElementHeight(), scalingParams.getMaxElementHeight(), f / f2));
            if (fMin < fLerp2) {
                float fTransform = scalingParams.getScaleInterpolator().transform(1.0f - (fMin / fLerp2));
                float fLerp3 = MathHelpersKt.lerp(1.0f, scalingParams.getEdgeScale(), fTransform);
                fLerp = MathHelpersKt.lerp(1.0f, scalingParams.getEdgeAlpha(), fTransform);
                f3 = fLerp3;
            } else {
                fLerp = 1.0f;
            }
        } else {
            fLerp = 1.0f;
        }
        return new ScaleAndAlpha(f3, fLerp);
    }

    /* JADX INFO: renamed from: calculateItemInfo-CuKLY0U, reason: not valid java name */
    public static final ScalingLazyListItemInfo m755calculateItemInfoCuKLY0U(int i, LazyListItemInfo lazyListItemInfo, int i2, int i3, int i4, ScalingParams scalingParams, int i5, int i6, AutoCenteringParams autoCenteringParams, boolean z) {
        int i7 = i - i2;
        int size = (lazyListItemInfo.getSize() + i) - i2;
        ScaleAndAlpha scaleAndAlphaCalculateScaleAndAlpha = calculateScaleAndAlpha(0, i3, i7, size, scalingParams);
        boolean z2 = size + i7 < i3;
        int iRoundToInt = MathKt.roundToInt(lazyListItemInfo.getSize() * scaleAndAlphaCalculateScaleAndAlpha.getScale());
        int iM756convertToCenterOffsetFiSRsrk = m756convertToCenterOffsetFiSRsrk(i6, !z2 ? i : (lazyListItemInfo.getSize() + i) - iRoundToInt, i4, i5, iRoundToInt);
        int iM756convertToCenterOffsetFiSRsrk2 = m756convertToCenterOffsetFiSRsrk(i6, lazyListItemInfo.getOffset(), i4, i5, lazyListItemInfo.getSize());
        int index = lazyListItemInfo.getIndex();
        if (autoCenteringParams != null) {
            index--;
        }
        return new DefaultScalingLazyListItemInfo(index, lazyListItemInfo.getKey(), iM756convertToCenterOffsetFiSRsrk2, iM756convertToCenterOffsetFiSRsrk, iRoundToInt, scaleAndAlphaCalculateScaleAndAlpha.getScale(), z ? scaleAndAlphaCalculateScaleAndAlpha.getAlpha() : 0.0f, lazyListItemInfo.getSize());
    }

    /* JADX INFO: renamed from: convertToCenterOffset-FiSRsrk, reason: not valid java name */
    public static final int m756convertToCenterOffsetFiSRsrk(int i, int i2, int i3, int i4, int i5) {
        return (i2 - i3) + i4 + (ScalingLazyListAnchorType.m762equalsimpl0(i, ScalingLazyListAnchorType.INSTANCE.m767getItemStarthvgbs18()) ? 0 : i5 / 2);
    }

    /* JADX INFO: renamed from: startOffset-nK7FVxM, reason: not valid java name */
    public static final float m757startOffsetnK7FVxM(ScalingLazyListItemInfo scalingLazyListItemInfo, int i) {
        return scalingLazyListItemInfo.getOffset() - (ScalingLazyListAnchorType.m762equalsimpl0(i, ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18()) ? scalingLazyListItemInfo.getSize() / 2.0f : 0.0f);
    }

    /* JADX INFO: renamed from: unadjustedStartOffset-nK7FVxM, reason: not valid java name */
    public static final float m758unadjustedStartOffsetnK7FVxM(ScalingLazyListItemInfo scalingLazyListItemInfo, int i) {
        return scalingLazyListItemInfo.getUnadjustedOffset() - (ScalingLazyListAnchorType.m762equalsimpl0(i, ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18()) ? scalingLazyListItemInfo.getUnadjustedSize() / 2.0f : 0.0f);
    }
}
