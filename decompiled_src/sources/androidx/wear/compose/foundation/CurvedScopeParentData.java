package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedParentData.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Landroidx/wear/compose/foundation/CurvedScopeParentData;", "", "weight", "", "(F)V", "getWeight", "()F", "setWeight", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CurvedScopeParentData {
    public static final int $stable = 8;
    private float weight;

    public CurvedScopeParentData() {
        this(0.0f, 1, null);
    }

    public static /* synthetic */ CurvedScopeParentData copy$default(CurvedScopeParentData curvedScopeParentData, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = curvedScopeParentData.weight;
        }
        return curvedScopeParentData.copy(f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getWeight() {
        return this.weight;
    }

    public final CurvedScopeParentData copy(float weight) {
        return new CurvedScopeParentData(weight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CurvedScopeParentData) && Float.compare(this.weight, ((CurvedScopeParentData) other).weight) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.weight);
    }

    public String toString() {
        return "CurvedScopeParentData(weight=" + this.weight + ')';
    }

    public CurvedScopeParentData(float f) {
        this.weight = f;
    }

    public /* synthetic */ CurvedScopeParentData(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f);
    }

    public final float getWeight() {
        return this.weight;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }
}
