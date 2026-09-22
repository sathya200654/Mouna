package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model;

import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: InterpretationSpeed.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "", "webViewKey", "", "labelRes", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getWebViewKey", "()Ljava/lang/String;", "getLabelRes", "()I", "UltraFast", "SuperFast", "Fast", "Normal", "Slow", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum InterpretationSpeed {
    UltraFast("ultra_fast", R.string.speed_level_ultra_fast),
    SuperFast("super_fast", R.string.speed_level_super_fast),
    Fast("fast", R.string.speed_level_fast),
    Normal("normal", R.string.speed_level_normal),
    Slow("slow", R.string.speed_level_slow);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int labelRes;
    private final String webViewKey;

    public static EnumEntries<InterpretationSpeed> getEntries() {
        return $ENTRIES;
    }

    InterpretationSpeed(String str, int i) {
        this.webViewKey = str;
        this.labelRes = i;
    }

    public final String getWebViewKey() {
        return this.webViewKey;
    }

    public final int getLabelRes() {
        return this.labelRes;
    }
}
