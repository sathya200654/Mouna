package com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.theme;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DynamicTonalPaletteKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.WindowCompat;
import io.grpc.okhttp.OkHttpChannelBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"lightScheme", "Landroidx/compose/material3/ColorScheme;", "darkScheme", "LetsTalkSignTranscriptionAppTheme", "", "darkTheme", "", "dynamicColor", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ThemeKt {
    private static final ColorScheme darkScheme;
    private static final ColorScheme lightScheme;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LetsTalkSignTranscriptionAppTheme$lambda$2(boolean z, boolean z2, Function2 function2, int i, int i2, Composer composer, int i3) {
        LetsTalkSignTranscriptionAppTheme(z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static {
        long primaryLight = ColorKt.getPrimaryLight();
        long onPrimaryLight = ColorKt.getOnPrimaryLight();
        long primaryContainerLight = ColorKt.getPrimaryContainerLight();
        long onPrimaryContainerLight = ColorKt.getOnPrimaryContainerLight();
        long secondaryLight = ColorKt.getSecondaryLight();
        long onSecondaryLight = ColorKt.getOnSecondaryLight();
        long secondaryContainerLight = ColorKt.getSecondaryContainerLight();
        long onSecondaryContainerLight = ColorKt.getOnSecondaryContainerLight();
        long tertiaryLight = ColorKt.getTertiaryLight();
        long onTertiaryLight = ColorKt.getOnTertiaryLight();
        long tertiaryContainerLight = ColorKt.getTertiaryContainerLight();
        long onTertiaryContainerLight = ColorKt.getOnTertiaryContainerLight();
        long errorLight = ColorKt.getErrorLight();
        long onErrorLight = ColorKt.getOnErrorLight();
        long errorContainerLight = ColorKt.getErrorContainerLight();
        long onErrorContainerLight = ColorKt.getOnErrorContainerLight();
        long backgroundLight = ColorKt.getBackgroundLight();
        long onBackgroundLight = ColorKt.getOnBackgroundLight();
        long surfaceLight = ColorKt.getSurfaceLight();
        long onSurfaceLight = ColorKt.getOnSurfaceLight();
        long surfaceVariantLight = ColorKt.getSurfaceVariantLight();
        long onSurfaceVariantLight = ColorKt.getOnSurfaceVariantLight();
        long outlineLight = ColorKt.getOutlineLight();
        long outlineVariantLight = ColorKt.getOutlineVariantLight();
        long scrimLight = ColorKt.getScrimLight();
        lightScheme = ColorSchemeKt.lightColorScheme-_VG5OTI$default(primaryLight, onPrimaryLight, primaryContainerLight, onPrimaryContainerLight, ColorKt.getInversePrimaryLight(), secondaryLight, onSecondaryLight, secondaryContainerLight, onSecondaryContainerLight, tertiaryLight, onTertiaryLight, tertiaryContainerLight, onTertiaryContainerLight, backgroundLight, onBackgroundLight, surfaceLight, onSurfaceLight, surfaceVariantLight, onSurfaceVariantLight, 0L, ColorKt.getInverseSurfaceLight(), ColorKt.getInverseOnSurfaceLight(), errorLight, onErrorLight, errorContainerLight, onErrorContainerLight, outlineLight, outlineVariantLight, scrimLight, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536346624, OkHttpChannelBuilder.DEFAULT_FLOW_CONTROL_WINDOW, (Object) null);
        long primaryDark = ColorKt.getPrimaryDark();
        long onPrimaryDark = ColorKt.getOnPrimaryDark();
        long primaryContainerDark = ColorKt.getPrimaryContainerDark();
        long onPrimaryContainerDark = ColorKt.getOnPrimaryContainerDark();
        long secondaryDark = ColorKt.getSecondaryDark();
        long onSecondaryDark = ColorKt.getOnSecondaryDark();
        long secondaryContainerDark = ColorKt.getSecondaryContainerDark();
        long onSecondaryContainerDark = ColorKt.getOnSecondaryContainerDark();
        long tertiaryDark = ColorKt.getTertiaryDark();
        long onTertiaryDark = ColorKt.getOnTertiaryDark();
        long tertiaryContainerDark = ColorKt.getTertiaryContainerDark();
        long onTertiaryContainerDark = ColorKt.getOnTertiaryContainerDark();
        long errorDark = ColorKt.getErrorDark();
        long onErrorDark = ColorKt.getOnErrorDark();
        long errorContainerDark = ColorKt.getErrorContainerDark();
        long onErrorContainerDark = ColorKt.getOnErrorContainerDark();
        long backgroundDark = ColorKt.getBackgroundDark();
        long onBackgroundDark = ColorKt.getOnBackgroundDark();
        long surfaceDark = ColorKt.getSurfaceDark();
        long onSurfaceDark = ColorKt.getOnSurfaceDark();
        long surfaceVariantDark = ColorKt.getSurfaceVariantDark();
        long onSurfaceVariantDark = ColorKt.getOnSurfaceVariantDark();
        long outlineDark = ColorKt.getOutlineDark();
        long outlineVariantDark = ColorKt.getOutlineVariantDark();
        long scrimDark = ColorKt.getScrimDark();
        darkScheme = ColorSchemeKt.darkColorScheme-_VG5OTI$default(primaryDark, onPrimaryDark, primaryContainerDark, onPrimaryContainerDark, ColorKt.getInversePrimaryDark(), secondaryDark, onSecondaryDark, secondaryContainerDark, onSecondaryContainerDark, tertiaryDark, onTertiaryDark, tertiaryContainerDark, onTertiaryContainerDark, backgroundDark, onBackgroundDark, surfaceDark, onSurfaceDark, surfaceVariantDark, onSurfaceVariantDark, 0L, ColorKt.getInverseSurfaceDark(), ColorKt.getInverseOnSurfaceDark(), errorDark, onErrorDark, errorContainerDark, onErrorContainerDark, outlineDark, outlineVariantDark, scrimDark, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536346624, OkHttpChannelBuilder.DEFAULT_FLOW_CONTROL_WINDOW, (Object) null);
    }

    public static final void LetsTalkSignTranscriptionAppTheme(final boolean z, boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        ColorScheme colorSchemeDynamicDarkColorScheme;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2114982540);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LetsTalkSignTranscriptionAppTheme)P(1,2)95@3495L7,105@3805L15,103@3734L119:Theme.kt#cx00st");
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(z)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        boolean z3 = true;
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "81@2998L21");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    z = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                    i3 &= -15;
                }
                if (i4 != 0) {
                    z2 = true;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2114982540, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.theme.LetsTalkSignTranscriptionAppTheme (Theme.kt:85)");
            }
            if (z2 && Build.VERSION.SDK_INT >= 31) {
                composerStartRestartGroup.startReplaceGroup(-274289613);
                ComposerKt.sourceInformation(composerStartRestartGroup, "88@3288L7");
                CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Context context = (Context) objConsume;
                colorSchemeDynamicDarkColorScheme = z ? DynamicTonalPaletteKt.dynamicDarkColorScheme(context) : DynamicTonalPaletteKt.dynamicLightColorScheme(context);
                composerStartRestartGroup.endReplaceGroup();
            } else if (z) {
                composerStartRestartGroup.startReplaceGroup(-978673826);
                composerStartRestartGroup.endReplaceGroup();
                colorSchemeDynamicDarkColorScheme = darkScheme;
            } else {
                composerStartRestartGroup.startReplaceGroup(-978672961);
                composerStartRestartGroup.endReplaceGroup();
                colorSchemeDynamicDarkColorScheme = lightScheme;
            }
            CompositionLocal localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final View view = (View) objConsume2;
            if (view.isInEditMode()) {
                composerStartRestartGroup.startReplaceGroup(-277516434);
            } else {
                composerStartRestartGroup.startReplaceGroup(-274006583);
                ComposerKt.sourceInformation(composerStartRestartGroup, "97@3552L170,97@3541L181");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -978669602, "CC(remember):Theme.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(view);
                if ((((i3 & 14) ^ 6) <= 4 || !composerStartRestartGroup.changed(z)) && (i3 & 6) != 4) {
                    z3 = false;
                }
                boolean z4 = zChangedInstance | z3;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4 || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.theme.ThemeKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return ThemeKt.LetsTalkSignTranscriptionAppTheme$lambda$1$lambda$0(view, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            MaterialThemeKt.MaterialTheme(colorSchemeDynamicDarkColorScheme, (Shapes) null, TypeKt.appTypography(composerStartRestartGroup, 0), function2, composerStartRestartGroup, (i3 << 3) & 7168, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final boolean z5 = z;
        final boolean z6 = z2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.theme.ThemeKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.LetsTalkSignTranscriptionAppTheme$lambda$2(z5, z6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LetsTalkSignTranscriptionAppTheme$lambda$1$lambda$0(View view, boolean z) {
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        WindowCompat.getInsetsController(((Activity) context).getWindow(), view).setAppearanceLightStatusBars(!z);
        return Unit.INSTANCE;
    }
}
