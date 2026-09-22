package androidx.wear.compose.material;

import android.content.Context;
import android.provider.Settings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Resources.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\r\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"imageResource", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Landroidx/wear/compose/material/ImageResources;", "(Landroidx/wear/compose/material/ImageResources;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "isLeftyModeEnabled", "", "(Landroidx/compose/runtime/Composer;I)Z", "screenHeightDp", "", "(Landroidx/compose/runtime/Composer;I)I", "screenWidthDp", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ResourcesKt {

    /* JADX INFO: compiled from: Resources.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageResources.values().length];
            try {
                iArr[ImageResources.CircularVignetteBottom.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageResources.CircularVignetteTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageResources.RectangularVignetteBottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageResources.RectangularVignetteTop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Painter imageResource(ImageResources imageResources, Composer composer, int i) throws NoWhenBranchMatchedException {
        int i2;
        ComposerKt.sourceInformationMarkerStart(composer, -1165767624, "C(imageResource)35@1180L411:Resources.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1165767624, i, -1, "androidx.wear.compose.material.imageResource (Resources.kt:35)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[imageResources.ordinal()];
        if (i3 == 1) {
            i2 = R.drawable.circular_vignette_bottom;
        } else if (i3 == 2) {
            i2 = R.drawable.circular_vignette_top;
        } else if (i3 == 3) {
            i2 = R.drawable.rectangular_vignette_bottom;
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = R.drawable.rectangular_vignette_top;
        }
        Painter painterPainterResource = PainterResources_androidKt.painterResource(i2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return painterPainterResource;
    }

    public static final boolean isLeftyModeEnabled(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1333600558, "C(isLeftyModeEnabled)46@1681L7,47@1700L202:Resources.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1333600558, i, -1, "androidx.wear.compose.material.isLeftyModeEnabled (Resources.kt:45)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, 1243168641, "CC(remember):Resources.kt#9igjgp");
        boolean zChanged = composer.changed(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = Boolean.valueOf(Settings.System.getInt(context.getContentResolver(), "user_rotation", 0) == 2);
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

    public static final int screenHeightDp(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -53150736, "C(screenHeightDp)57@1963L7:Resources.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-53150736, i, -1, "androidx.wear.compose.material.screenHeightDp (Resources.kt:57)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = ((Context) objConsume).getResources().getConfiguration().screenHeightDp;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return i2;
    }

    public static final int screenWidthDp(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2058309477, "C(screenWidthDp)60@2067L7:Resources.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2058309477, i, -1, "androidx.wear.compose.material.screenWidthDp (Resources.kt:60)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = ((Context) objConsume).getResources().getConfiguration().screenWidthDp;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return i2;
    }
}
