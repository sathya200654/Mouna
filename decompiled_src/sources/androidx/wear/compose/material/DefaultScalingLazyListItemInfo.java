package androidx.wear.compose.material;

import kotlin.Metadata;

/* JADX INFO: compiled from: ScalingLazyColumnMeasure.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006\u001b"}, d2 = {"Landroidx/wear/compose/material/DefaultScalingLazyListItemInfo;", "Landroidx/wear/compose/material/ScalingLazyListItemInfo;", "index", "", "key", "", "unadjustedOffset", "offset", "size", "scale", "", "alpha", "unadjustedSize", "(ILjava/lang/Object;IIIFFI)V", "getAlpha", "()F", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "getOffset", "getScale", "getSize", "getUnadjustedOffset", "getUnadjustedSize", "toString", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultScalingLazyListItemInfo implements ScalingLazyListItemInfo {
    public static final int $stable = 8;
    private final float alpha;
    private final int index;
    private final Object key;
    private final int offset;
    private final float scale;
    private final int size;
    private final int unadjustedOffset;
    private final int unadjustedSize;

    public DefaultScalingLazyListItemInfo(int i, Object obj, int i2, int i3, int i4, float f, float f2, int i5) {
        this.index = i;
        this.key = obj;
        this.unadjustedOffset = i2;
        this.offset = i3;
        this.size = i4;
        this.scale = f;
        this.alpha = f2;
        this.unadjustedSize = i5;
    }

    @Override // androidx.wear.compose.material.ScalingLazyListItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.wear.compose.material.ScalingLazyListItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.wear.compose.material.ScalingLazyListItemInfo
    public int getUnadjustedOffset() {
        return this.unadjustedOffset;
    }

    @Override // androidx.wear.compose.material.ScalingLazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.wear.compose.material.ScalingLazyListItemInfo
    public int getSize() {
        return this.size;
    }

    @Override // androidx.wear.compose.material.ScalingLazyListItemInfo
    public float getScale() {
        return this.scale;
    }

    @Override // androidx.wear.compose.material.ScalingLazyListItemInfo
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.wear.compose.material.ScalingLazyListItemInfo
    public int getUnadjustedSize() {
        return this.unadjustedSize;
    }

    public String toString() {
        return "DefaultScalingLazyListItemInfo(index=" + getIndex() + ", key=" + getKey() + ", unadjustedOffset=" + getUnadjustedOffset() + ", offset=" + getOffset() + ", size=" + getSize() + ", unadjustedSize=" + getUnadjustedSize() + ", scale=" + getScale() + ", alpha=" + getAlpha() + ')';
    }
}
