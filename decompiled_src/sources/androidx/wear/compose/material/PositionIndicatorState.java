package androidx.wear.compose.material;

import kotlin.Metadata;

/* JADX INFO: compiled from: PositionIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0003H'J\u001f\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0007\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/wear/compose/material/PositionIndicatorState;", "", "positionFraction", "", "getPositionFraction", "()F", "sizeFraction", "scrollableContainerSizePx", "visibility", "Landroidx/wear/compose/material/PositionIndicatorVisibility;", "visibility-KCSNhGQ", "(F)I", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PositionIndicatorState {
    float getPositionFraction();

    float sizeFraction(float scrollableContainerSizePx);

    /* JADX INFO: renamed from: visibility-KCSNhGQ */
    int mo597visibilityKCSNhGQ(float scrollableContainerSizePx);
}
