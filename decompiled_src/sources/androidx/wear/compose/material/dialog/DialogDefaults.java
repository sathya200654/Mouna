package androidx.wear.compose.material.dialog;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import androidx.wear.compose.materialcore.ResourcesKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Dialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\fX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\fX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u0018X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0018X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u0018X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\b8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010\nR\u0014\u0010!\u001a\u00020\b8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/wear/compose/material/dialog/DialogDefaults;", "", "()V", "AlertVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getAlertVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "BodyPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getBodyPadding", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/PaddingValues;", "ButtonSpacing", "Landroidx/compose/ui/unit/Dp;", "getButtonSpacing-D9Ej5fM$compose_material_release", "()F", "F", "ConfirmationVerticalArrangement", "getConfirmationVerticalArrangement", "ContentPadding", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "IconSpacing", "getIconSpacing-D9Ej5fM$compose_material_release", "IndefiniteDurationMillis", "", "getIndefiniteDurationMillis", "()J", "LongDurationMillis", "getLongDurationMillis", "ShortDurationMillis", "getShortDurationMillis", "TitleBottomPadding", "getTitleBottomPadding", "TitlePadding", "getTitlePadding", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialogDefaults {
    public static final int $stable = 0;
    private static final Arrangement.Vertical AlertVerticalArrangement;
    private static final float IconSpacing;
    public static final DialogDefaults INSTANCE = new DialogDefaults();
    private static final Arrangement.Vertical ConfirmationVerticalArrangement = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(8), Alignment.Companion.getCenterVertically());
    private static final PaddingValues ContentPadding = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
    private static final long ShortDurationMillis = 4000;
    private static final long LongDurationMillis = 10000;
    private static final long IndefiniteDurationMillis = Long.MAX_VALUE;
    private static final float ButtonSpacing = Dp.constructor-impl(12);

    private DialogDefaults() {
    }

    public final Arrangement.Vertical getAlertVerticalArrangement() {
        return AlertVerticalArrangement;
    }

    static {
        float f = 4;
        AlertVerticalArrangement = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(f), Alignment.Companion.getCenterVertically());
        IconSpacing = Dp.constructor-impl(f);
    }

    public final Arrangement.Vertical getConfirmationVerticalArrangement() {
        return ConfirmationVerticalArrangement;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final long getShortDurationMillis() {
        return ShortDurationMillis;
    }

    public final long getLongDurationMillis() {
        return LongDurationMillis;
    }

    public final long getIndefiniteDurationMillis() {
        return IndefiniteDurationMillis;
    }

    /* JADX INFO: renamed from: getButtonSpacing-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m883getButtonSpacingD9Ej5fM$compose_material_release() {
        return ButtonSpacing;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m884getIconSpacingD9Ej5fM$compose_material_release() {
        return IconSpacing;
    }

    public final PaddingValues getBodyPadding(Composer composer, int i) {
        PaddingValues paddingValues;
        ComposerKt.sourceInformationMarkerStart(composer, -1714706111, "C707@29879L15:Dialog.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714706111, i, -1, "androidx.wear.compose.material.dialog.DialogDefaults.<get-BodyPadding> (Dialog.kt:707)");
        }
        if (ResourcesKt.isRoundDevice(composer, 0)) {
            float f = 8;
            paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(f), Dp.constructor-impl(0), Dp.constructor-impl(f), Dp.constructor-impl(12));
        } else {
            float f2 = 5;
            paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(f2), Dp.constructor-impl(0), Dp.constructor-impl(f2), Dp.constructor-impl(12));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return paddingValues;
    }

    public final PaddingValues getTitlePadding(Composer composer, int i) {
        PaddingValues paddingValues;
        ComposerKt.sourceInformationMarkerStart(composer, 1471019919, "C717@30206L15:Dialog.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1471019919, i, -1, "androidx.wear.compose.material.dialog.DialogDefaults.<get-TitlePadding> (Dialog.kt:717)");
        }
        if (ResourcesKt.isRoundDevice(composer, 0)) {
            float f = 14;
            paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(f), Dp.constructor-impl(0), Dp.constructor-impl(f), Dp.constructor-impl(8));
        } else {
            float f2 = 5;
            paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(f2), Dp.constructor-impl(0), Dp.constructor-impl(f2), Dp.constructor-impl(8));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return paddingValues;
    }

    public final PaddingValues getTitleBottomPadding(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1324853713, "C:Dialog.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1324853713, i, -1, "androidx.wear.compose.material.dialog.DialogDefaults.<get-TitleBottomPadding> (Dialog.kt:732)");
        }
        float f = 0;
        PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(f), Dp.constructor-impl(f), Dp.constructor-impl(f), Dp.constructor-impl(16));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return paddingValues;
    }
}
