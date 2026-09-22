package androidx.wear.compose.material;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.compose.foundation.CompositionLocalsKt;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"MaterialTheme", "", "colors", "Landroidx/wear/compose/material/Colors;", "typography", "Landroidx/wear/compose/material/Typography;", "shapes", "Landroidx/wear/compose/material/Shapes;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/wear/compose/material/Colors;Landroidx/wear/compose/material/Typography;Landroidx/wear/compose/material/Shapes;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MaterialThemeKt {
    public static final void MaterialTheme(Colors colors, Typography typography, Shapes shapes, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        final Colors colors2;
        int i3;
        Typography typography2;
        Shapes shapes2;
        final Typography typography3;
        final Shapes shapes3;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(754081562);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MaterialTheme)P(!1,3,2)59@2951L6,60@3002L10,61@3049L6,64@3124L32,65@3183L35,71@3451L4,78@3870L77,67@3258L689:MaterialTheme.kt#gj9v0t");
        if ((i & 6) == 0) {
            if ((i2 & 1) == 0) {
                colors2 = colors;
                if (composerStartRestartGroup.changed(colors2)) {
                    i4 = 4;
                }
                i3 = i4 | i;
            } else {
                colors2 = colors;
            }
            i4 = 2;
            i3 = i4 | i;
        } else {
            colors2 = colors;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                typography2 = typography;
                int i5 = composerStartRestartGroup.changed(typography2) ? 32 : 16;
                i3 |= i5;
            } else {
                typography2 = typography;
            }
            i3 |= i5;
        } else {
            typography2 = typography;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shapes2 = shapes;
                int i6 = composerStartRestartGroup.changed(shapes2) ? 256 : 128;
                i3 |= i6;
            } else {
                shapes2 = shapes;
            }
            i3 |= i6;
        } else {
            shapes2 = shapes;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i3 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colors2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
            }
            final Typography typography4 = typography2;
            Shapes shapes4 = shapes2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(754081562, i3, -1, "androidx.wear.compose.material.MaterialTheme (MaterialTheme.kt:63)");
            }
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ColorsKt.getLocalColors().provides(colors2), ShapesKt.getLocalShapes().provides(shapes4), TypographyKt.getLocalTypography().provides(typography4), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6))), IndicationKt.getLocalIndication().provides(RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(CompatRippleTheme.INSTANCE), TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialTextSelectionColorsKt.rememberTextSelectionColors(colors2, composerStartRestartGroup, i3 & 14)), CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(colors2.getBackground())), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(colors2.getBackground()))}, ComposableLambdaKt.rememberComposableLambda(-1705557414, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.MaterialThemeKt.MaterialTheme.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    ComposerKt.sourceInformation(composer2, "C79@3880L61:MaterialTheme.kt#gj9v0t");
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1705557414, i7, -1, "androidx.wear.compose.material.MaterialTheme.<anonymous> (MaterialTheme.kt:79)");
                    }
                    TextKt.ProvideTextStyle(typography4.getBody1(), function2, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography3 = typography4;
            shapes3 = shapes4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            typography3 = typography2;
            shapes3 = shapes2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.MaterialThemeKt.MaterialTheme.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    MaterialThemeKt.MaterialTheme(colors2, typography3, shapes3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
