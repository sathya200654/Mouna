package androidx.wear.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.BrushPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: Card.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001bR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\t\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/wear/compose/material/CardDefaults;", "", "()V", "AppImageSize", "Landroidx/compose/ui/unit/Dp;", "getAppImageSize-D9Ej5fM", "()F", "F", "CardHorizontalPadding", "CardVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "cardBackgroundPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "startBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "endBackgroundColor", "gradientDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cardBackgroundPainter-Klgx-Pg", "(JJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/painter/Painter;", "imageWithScrimBackgroundPainter", "backgroundImagePainter", "backgroundImageScrimBrush", "Landroidx/compose/ui/graphics/Brush;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/painter/Painter;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CardDefaults {
    public static final int $stable = 0;
    private static final float AppImageSize;
    private static final float CardHorizontalPadding;
    private static final float CardVerticalPadding;
    private static final PaddingValues ContentPadding;
    public static final CardDefaults INSTANCE = new CardDefaults();

    private CardDefaults() {
    }

    /* JADX INFO: renamed from: cardBackgroundPainter-Klgx-Pg, reason: not valid java name */
    public final Painter m526cardBackgroundPainterKlgxPg(long j, long j2, LayoutDirection layoutDirection, Composer composer, int i, int i2) {
        LayoutDirection layoutDirection2;
        ComposerKt.sourceInformationMarkerStart(composer, -453748206, "C(cardBackgroundPainter)P(2:c#ui.graphics.Color,0:c#ui.graphics.Color)373@17079L6,374@17159L6,376@17241L6,377@17330L6,378@17416L7:Card.kt#gj9v0t");
        long j3 = (i2 & 1) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).getBackground()) : j;
        long j4 = (i2 & 2) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurfaceVariant(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).getBackground()) : j2;
        if ((i2 & 4) != 0) {
            CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            layoutDirection2 = (LayoutDirection) objConsume;
        } else {
            layoutDirection2 = layoutDirection;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-453748206, i, -1, "androidx.wear.compose.material.CardDefaults.cardBackgroundPainter (Card.kt:379)");
        }
        Painter brushPainter = new BrushPainter(new FortyFiveDegreeLinearGradient(CollectionsKt.listOf(new Color[]{Color.box-impl(j3), Color.box-impl(j4)}), null, 0, layoutDirection2 == LayoutDirection.Ltr, 6, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return brushPainter;
    }

    public final Painter imageWithScrimBackgroundPainter(Painter painter, Brush brush, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1942825103, "C(imageWithScrimBackgroundPainter)409@18699L6,410@18764L6:Card.kt#gj9v0t");
        if ((i2 & 2) != 0) {
            brush = Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getSurface(), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getSurface(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), 0L, 0L, 0, 14, (Object) null);
        }
        Brush brush2 = brush;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1942825103, i, -1, "androidx.wear.compose.material.CardDefaults.imageWithScrimBackgroundPainter (Card.kt:413)");
        }
        ImageWithScrimPainter imageWithScrimPainter = new ImageWithScrimPainter(painter, brush2, 0.0f, 0.0f, 12, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return imageWithScrimPainter;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getAppImageSize-D9Ej5fM, reason: not valid java name */
    public final float m527getAppImageSizeD9Ej5fM() {
        return AppImageSize;
    }

    static {
        float f = 12;
        float f2 = Dp.constructor-impl(f);
        CardHorizontalPadding = f2;
        float f3 = Dp.constructor-impl(f);
        CardVerticalPadding = f3;
        ContentPadding = PaddingKt.PaddingValues-a9UjIt4(f2, f3, f2, f3);
        AppImageSize = Dp.constructor-impl(16);
    }
}
