package androidx.wear.compose.foundation;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Resources.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"isRoundDevice", "", "(Landroidx/compose/runtime/Composer;I)Z", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ResourcesKt {
    public static final boolean isRoundDevice(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1264813214, "C(isRoundDevice)24@894L7,25@913L67:Resources.kt#m5emhl");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1264813214, i, -1, "androidx.wear.compose.foundation.isRoundDevice (Resources.kt:23)");
        }
        CompositionLocal localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Configuration configuration = (Configuration) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, 594740296, "CC(remember):Resources.kt#9igjgp");
        boolean zChanged = composer.changed(configuration);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = Boolean.valueOf(configuration.isScreenRound());
            composer.updateRememberedValue(objRememberedValue);
        }
        boolean zBooleanValue = ((Boolean) objRememberedValue).booleanValue();
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return zBooleanValue;
    }
}
