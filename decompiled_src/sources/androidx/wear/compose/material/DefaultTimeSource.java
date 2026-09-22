package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TimeText.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/wear/compose/material/DefaultTimeSource;", "Landroidx/wear/compose/material/TimeSource;", "timeFormat", "", "(Ljava/lang/String;)V", "_timeFormat", "currentTime", "getCurrentTime", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultTimeSource implements TimeSource {
    public static final int $stable = 0;
    private final String _timeFormat;

    public DefaultTimeSource(String str) {
        this._timeFormat = str;
    }

    @Override // androidx.wear.compose.material.TimeSource
    public String getCurrentTime(Composer composer, int i) {
        composer.startReplaceGroup(1252599730);
        ComposerKt.sourceInformation(composer, "C311@12061L49:TimeText.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1252599730, i, -1, "androidx.wear.compose.material.DefaultTimeSource.<get-currentTime> (TimeText.kt:311)");
        }
        String str = (String) TimeTextKt.currentTime(new Function0<Long>() { // from class: androidx.wear.compose.material.DefaultTimeSource$currentTime$1
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Long m587invoke() {
                return Long.valueOf(androidx.wear.compose.materialcore.ResourcesKt.currentTimeMillis());
            }
        }, this._timeFormat, composer, 6).getValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return str;
    }
}
