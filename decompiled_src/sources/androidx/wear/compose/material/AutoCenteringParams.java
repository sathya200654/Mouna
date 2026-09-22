package androidx.wear.compose.material;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ScalingLazyColumn.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/wear/compose/material/AutoCenteringParams;", "", "itemIndex", "", "itemOffset", "(II)V", "getItemIndex$compose_material_release", "()I", "getItemOffset$compose_material_release", "equals", "", "other", "hashCode", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AutoCenteringParams {
    public static final int $stable = 0;
    private final int itemIndex;
    private final int itemOffset;

    /* JADX WARN: Illegal instructions before constructor call */
    public AutoCenteringParams() {
        int i = 0;
        this(i, i, 3, null);
    }

    public AutoCenteringParams(int i, int i2) {
        this.itemIndex = i;
        this.itemOffset = i2;
    }

    public /* synthetic */ AutoCenteringParams(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    /* JADX INFO: renamed from: getItemIndex$compose_material_release, reason: from getter */
    public final int getItemIndex() {
        return this.itemIndex;
    }

    /* JADX INFO: renamed from: getItemOffset$compose_material_release, reason: from getter */
    public final int getItemOffset() {
        return this.itemOffset;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoCenteringParams)) {
            return false;
        }
        AutoCenteringParams autoCenteringParams = (AutoCenteringParams) other;
        return this.itemIndex == autoCenteringParams.itemIndex && this.itemOffset == autoCenteringParams.itemOffset;
    }

    public int hashCode() {
        return (this.itemIndex * 31) + this.itemOffset;
    }
}
