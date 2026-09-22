package androidx.wear.compose.material;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScrollAway.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Landroidx/wear/compose/material/ScrollParams;", "", "valid", "", "yPx", "", "(ZLjava/lang/Float;)V", "getValid", "()Z", "getYPx", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "copy", "(ZLjava/lang/Float;)Landroidx/wear/compose/material/ScrollParams;", "equals", "other", "hashCode", "", "toString", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class ScrollParams {
    private final boolean valid;
    private final Float yPx;

    public static /* synthetic */ ScrollParams copy$default(ScrollParams scrollParams, boolean z, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            z = scrollParams.valid;
        }
        if ((i & 2) != 0) {
            f = scrollParams.yPx;
        }
        return scrollParams.copy(z, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getValid() {
        return this.valid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getYPx() {
        return this.yPx;
    }

    public final ScrollParams copy(boolean valid, Float yPx) {
        return new ScrollParams(valid, yPx);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollParams)) {
            return false;
        }
        ScrollParams scrollParams = (ScrollParams) other;
        return this.valid == scrollParams.valid && Intrinsics.areEqual(this.yPx, scrollParams.yPx);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.valid) * 31;
        Float f = this.yPx;
        return iHashCode + (f == null ? 0 : f.hashCode());
    }

    public String toString() {
        return "ScrollParams(valid=" + this.valid + ", yPx=" + this.yPx + ')';
    }

    public ScrollParams(boolean z, Float f) {
        this.valid = z;
        this.yPx = f;
    }

    public final boolean getValid() {
        return this.valid;
    }

    public final Float getYPx() {
        return this.yPx;
    }
}
