package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;

/* JADX INFO: compiled from: TimeText.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/wear/compose/material/TimeSource;", "", "currentTime", "", "getCurrentTime", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TimeSource {
    String getCurrentTime(Composer composer, int i);
}
