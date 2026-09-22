package androidx.wear.compose.materialcore;

import android.content.Context;
import android.content.res.Configuration;
import android.text.format.DateFormat;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* JADX INFO: compiled from: Resources.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0007"}, d2 = {"currentTimeMillis", "", "is24HourFormat", "", "(Landroidx/compose/runtime/Composer;I)Z", "isLayoutDirectionRtl", "isRoundDevice", "compose-material-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ResourcesKt {
    public static final boolean isLayoutDirectionRtl(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 352688406, "C(isLayoutDirectionRtl)29@1148L7:Resources.kt#f7tims");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(352688406, i, -1, "androidx.wear.compose.materialcore.isLayoutDirectionRtl (Resources.kt:28)");
        }
        CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean z = ((LayoutDirection) objConsume) == LayoutDirection.Rtl;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return z;
    }

    public static final boolean isRoundDevice(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 18048629, "C(isRoundDevice)36@1339L7:Resources.kt#f7tims");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(18048629, i, -1, "androidx.wear.compose.materialcore.isRoundDevice (Resources.kt:35)");
        }
        CompositionLocal localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean zIsScreenRound = ((Configuration) objConsume).isScreenRound();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return zIsScreenRound;
    }

    public static final boolean is24HourFormat(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -667802338, "C(is24HourFormat)42@1516L7:Resources.kt#f7tims");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-667802338, i, -1, "androidx.wear.compose.materialcore.is24HourFormat (Resources.kt:42)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean zIs24HourFormat = DateFormat.is24HourFormat((Context) objConsume);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return zIs24HourFormat;
    }

    public static final long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
