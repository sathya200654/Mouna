package androidx.wear.compose.material;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScalingLazyListItemInfo.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0012\u0010\u000f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0012\u0010\u0011\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\tR\u0012\u0010\u0013\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\tR\u0012\u0010\u0015\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\t\u0082\u0001\u0001\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/wear/compose/material/ScalingLazyListItemInfo;", "", "alpha", "", "getAlpha", "()F", "index", "", "getIndex", "()I", "key", "getKey", "()Ljava/lang/Object;", "offset", "getOffset", "scale", "getScale", "size", "getSize", "unadjustedOffset", "getUnadjustedOffset", "unadjustedSize", "getUnadjustedSize", "Landroidx/wear/compose/material/DefaultScalingLazyListItemInfo;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ScalingLazyListItemInfo {
    float getAlpha();

    int getIndex();

    Object getKey();

    int getOffset();

    float getScale();

    int getSize();

    int getUnadjustedOffset();

    int getUnadjustedSize();
}
