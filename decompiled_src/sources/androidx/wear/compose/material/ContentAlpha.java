package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContentAlpha.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/wear/compose/material/ContentAlpha;", "", "()V", "disabled", "", "getDisabled", "(Landroidx/compose/runtime/Composer;I)F", "high", "getHigh", Constants.ScionAnalytics.PARAM_MEDIUM, "getMedium", "contentAlpha", "highContrastAlpha", "lowContrastAlpha", "(FFLandroidx/compose/runtime/Composer;I)F", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContentAlpha {
    public static final int $stable = 0;
    public static final ContentAlpha INSTANCE = new ContentAlpha();

    private ContentAlpha() {
    }

    public final float getHigh(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1661933140, "C35@1222L146:ContentAlpha.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1661933140, i, -1, "androidx.wear.compose.material.ContentAlpha.<get-high> (ContentAlpha.kt:35)");
        }
        float fContentAlpha = contentAlpha(1.0f, 0.87f, composer, ((i << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fContentAlpha;
    }

    public final float getMedium(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2122645684, "C46@1580L150:ContentAlpha.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2122645684, i, -1, "androidx.wear.compose.material.ContentAlpha.<get-medium> (ContentAlpha.kt:46)");
        }
        float fContentAlpha = contentAlpha(0.74f, 0.6f, composer, ((i << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fContentAlpha;
    }

    public final float getDisabled(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -554360596, "C57@1934L154:ContentAlpha.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-554360596, i, -1, "androidx.wear.compose.material.ContentAlpha.<get-disabled> (ContentAlpha.kt:57)");
        }
        float fContentAlpha = contentAlpha(0.38f, 0.38f, composer, ((i << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fContentAlpha;
    }

    private final float contentAlpha(float f, float f2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1921297038, "C(contentAlpha)77@2744L7:ContentAlpha.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1921297038, i, -1, "androidx.wear.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:76)");
        }
        CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ColorKt.luminance-8_81llA(((Color) objConsume).unbox-impl()) >= 0.5d) {
            f = f2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return f;
    }
}
