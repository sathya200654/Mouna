package androidx.wear.compose.materialcore;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HorizontalPageIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0003J\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0007J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u001e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006#"}, d2 = {"Landroidx/wear/compose/materialcore/PagesState;", "", "totalPages", "", "pagesOnScreen", "(II)V", "firstAlpha", "", "firstSize", "hiddenPagesToTheLeft", "lastAlpha", "lastButOneSize", "lastSize", "leftSpacerSizeRatio", "getLeftSpacerSizeRatio", "()F", "getPagesOnScreen", "()I", "rightSpacerSizeRatio", "getRightSpacerSizeRatio", "secondSize", "smoothProgress", "getTotalPages", "<set-?>", "visibleDotIndex", "getVisibleDotIndex", "alpha", "page", "calculateSelectedRatio", "targetPage", "offset", "recalculateState", "", "selectedPage", "sizeRatio", "compose-material-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagesState {
    public static final int $stable = 8;
    private int hiddenPagesToTheLeft;
    private float lastAlpha;
    private final int pagesOnScreen;
    private float smoothProgress;
    private final int totalPages;
    private int visibleDotIndex;
    private float firstAlpha = 1.0f;
    private float firstSize = 1.0f;
    private float secondSize = 1.0f;
    private float lastSize = 1.0f;
    private float lastButOneSize = 1.0f;

    public PagesState(int i, int i2) {
        this.totalPages = i;
        this.pagesOnScreen = i2;
    }

    public final int getTotalPages() {
        return this.totalPages;
    }

    public final int getPagesOnScreen() {
        return this.pagesOnScreen;
    }

    public final int getVisibleDotIndex() {
        return this.visibleDotIndex;
    }

    public final float getLeftSpacerSizeRatio() {
        return 1 - this.smoothProgress;
    }

    /* JADX INFO: renamed from: getRightSpacerSizeRatio, reason: from getter */
    public final float getSmoothProgress() {
        return this.smoothProgress;
    }

    public final float alpha(int page) {
        if (page == 0) {
            return this.firstAlpha;
        }
        if (page == this.pagesOnScreen) {
            return this.lastAlpha;
        }
        return 1.0f;
    }

    public final float sizeRatio(int page) {
        if (page == 0) {
            return this.firstSize;
        }
        if (page == 1) {
            return this.secondSize;
        }
        int i = this.pagesOnScreen;
        if (page == i - 1) {
            return this.lastButOneSize;
        }
        if (page == i) {
            return this.lastSize;
        }
        return 1.0f;
    }

    public final float calculateSelectedRatio(int targetPage, float offset) {
        return RangesKt.coerceAtLeast(1 - Math.abs((this.visibleDotIndex + offset) - targetPage), 0.0f);
    }

    public final void recalculateState(int selectedPage, float offset) {
        float f = selectedPage + offset;
        int i = this.hiddenPagesToTheLeft;
        int i2 = this.pagesOnScreen;
        boolean z = false;
        if (selectedPage > (i + i2) - 2) {
            this.hiddenPagesToTheLeft = RangesKt.coerceAtMost(selectedPage - (i2 - 2), this.totalPages - i2);
        } else if (f <= i) {
            this.hiddenPagesToTheLeft = RangesKt.coerceAtLeast(selectedPage - 1, 0);
        }
        int i3 = this.hiddenPagesToTheLeft;
        int i4 = this.pagesOnScreen;
        boolean z2 = f > ((float) ((i3 + i4) + (-2))) && f < ((float) (this.totalPages + (-2)));
        float f2 = 1.0f;
        if (f > 1.0f && f < i3 + 1) {
            z = true;
        }
        if (!z && !z2) {
            offset = 0.0f;
        }
        this.smoothProgress = offset;
        float f3 = 1;
        this.firstAlpha = f3 - offset;
        this.lastAlpha = offset;
        this.secondSize = f3 - (offset * 0.5f);
        this.firstSize = (i3 == 0 || (i3 == 1 && z)) ? f3 - offset : (f3 - offset) * 0.5f;
        int i5 = this.totalPages;
        this.lastSize = ((i3 == (i5 - i4) - 1 && z2) || (i3 == i5 - i4 && z)) ? offset : offset * 0.5f;
        if (z2 || z) {
            f2 = (f3 + offset) * 0.5f;
        } else if (i3 < i5 - i4) {
            f2 = 0.5f;
        }
        this.lastButOneSize = f2;
        this.visibleDotIndex = z ? 1 : selectedPage - i3;
    }
}
