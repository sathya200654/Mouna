package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"ConsentPage", "", "onProceedClick", "Lkotlin/Function0;", "onSkipClick", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConsentPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsentPage$lambda$7(Function0 function0, Function0 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ConsentPage(function0, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:34:0x006c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:49:0x0258  */
    /* JADX WARN: Code duplicated, block: B:52:0x0264  */
    /* JADX WARN: Code duplicated, block: B:53:0x0268  */
    /* JADX WARN: Code duplicated, block: B:56:0x0369  */
    /* JADX WARN: Code duplicated, block: B:59:0x0375  */
    /* JADX WARN: Code duplicated, block: B:60:0x0379  */
    /* JADX WARN: Code duplicated, block: B:63:0x0407  */
    /* JADX WARN: Code duplicated, block: B:64:0x040a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0419  */
    /* JADX WARN: Code duplicated, block: B:72:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:73:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:78:0x0501  */
    /* JADX WARN: Code duplicated, block: B:81:0x0550  */
    /* JADX WARN: Code duplicated, block: B:83:0x0556  */
    /* JADX WARN: Code duplicated, block: B:86:0x0560  */
    /* JADX WARN: Code duplicated, block: B:88:? A[RETURN, SYNTHETIC] */
    public static final void ConsentPage(final Function0<Unit> function0, final Function0<Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function0 constructor;
        Function0 constructor2;
        int i4;
        Function0 constructor3;
        boolean z2;
        Object objRememberedValue;
        boolean z3;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(function0, "onProceedClick");
        Intrinsics.checkNotNullParameter(function1, "onSkipClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1406932522);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConsentPage)P(1,2)29@1164L3120:ConsentPage.kt#j5zu2x");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1406932522, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ConsentPage (ConsentPage.kt:28)");
                }
                Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1855693413, "C35@1355L39,36@1429L51,34@1326L227,41@1587L57,43@1722L11,44@1787L10,40@1562L260,53@2148L21,46@1831L2447:ConsentPage.kt#j5zu2x");
                Modifier modifier5 = modifier4;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.lts_logo_hd, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.onboarding_consent_cd_logo, composerStartRestartGroup, 0), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(144)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 384, 120);
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_consent_title_welcome, composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 0, 0, 130042);
                Arrangement.Vertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
                Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.padding-VpY3zN4(ColumnScope.weight$default(columnScope, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), Dp.constructor-impl(32), Dp.constructor-impl(8)), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(spaceEvenly, centerHorizontally2, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -648042848, "C56@2224L60,58@2370L10,55@2195L214,60@2422L906,83@3371L56,85@3513L10,82@3341L258,93@3808L11,94@3891L11,92@3745L192,89@3650L53,88@3612L656:ConsentPage.kt#j5zu2x");
                i4 = i3;
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_consent_desc_instruction, composerStartRestartGroup, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 0, 0, 130046);
                Arrangement.Vertical center2 = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal centerHorizontally3 = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier6 = Modifier.Companion;
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally3, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier6);
                constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composer4 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer4, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1085945832, "C69@2806L11,70@2893L11,68@2739L204,65@2629L64,64@2587L727:ConsentPage.kt#j5zu2x");
                ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12);
                float f = 4;
                Modifier modifier7 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1904632820, "CC(remember):ConsentPage.kt#9igjgp");
                if ((i4 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ConsentPageKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return ConsentPageKt.ConsentPage$lambda$6$lambda$5$lambda$2$lambda$1$lambda$0(function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonKt.TextButton((Function0) objRememberedValue, modifier7, false, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ConsentPageKt.INSTANCE.m1780getLambda$2028257321$app_release(), composerStartRestartGroup, 805306416, 492);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_consent_desc_privacy, composerStartRestartGroup, 0), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall(), composerStartRestartGroup, 48, 0, 130044);
                ButtonColors buttonColors2 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12);
                Modifier modifier8 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -990691393, "CC(remember):ConsentPage.kt#9igjgp");
                if ((i4 & 112) == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ConsentPageKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return ConsentPageKt.ConsentPage$lambda$6$lambda$5$lambda$4$lambda$3(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonKt.TextButton((Function0) objRememberedValue2, modifier8, false, (Shape) null, buttonColors2, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ConsentPageKt.INSTANCE.m1779getLambda$1236165491$app_release(), composerStartRestartGroup, 805306416, 492);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ConsentPageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        return ConsentPageKt.ConsentPage$lambda$7(function0, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1406932522, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ConsentPage (ConsentPage.kt:28)");
            }
            Alignment.Horizontal centerHorizontally4 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical center3 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(center3, centerHorizontally4, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer5 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer5, measurePolicyColumnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer5, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1855693413, "C35@1355L39,36@1429L51,34@1326L227,41@1587L57,43@1722L11,44@1787L10,40@1562L260,53@2148L21,46@1831L2447:ConsentPage.kt#j5zu2x");
            Modifier modifier9 = modifier4;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.lts_logo_hd, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.onboarding_consent_cd_logo, composerStartRestartGroup, 0), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(144)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 384, 120);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_consent_title_welcome, composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 0, 0, 130042);
            Arrangement.Vertical spaceEvenly2 = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Horizontal centerHorizontally5 = Alignment.Companion.getCenterHorizontally();
            Modifier modifierVerticalScroll$default2 = ScrollKt.verticalScroll$default(PaddingKt.padding-VpY3zN4(ColumnScope.weight$default(columnScope4, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), Dp.constructor-impl(32), Dp.constructor-impl(8)), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(spaceEvenly2, centerHorizontally5, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default2);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer6 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer6, Integer.valueOf(iHashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope5 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -648042848, "C56@2224L60,58@2370L10,55@2195L214,60@2422L906,83@3371L56,85@3513L10,82@3341L258,93@3808L11,94@3891L11,92@3745L192,89@3650L53,88@3612L656:ConsentPage.kt#j5zu2x");
            i4 = i3;
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_consent_desc_instruction, composerStartRestartGroup, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 0, 0, 130046);
            Arrangement.Vertical center4 = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally6 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier10 = Modifier.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(center4, centerHorizontally6, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier10);
            constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer7 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer7, measurePolicyColumnMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer7, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer7, Integer.valueOf(iHashCode6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer7, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope6 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1085945832, "C69@2806L11,70@2893L11,68@2739L204,65@2629L64,64@2587L727:ConsentPage.kt#j5zu2x");
            ButtonColors buttonColors3 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12);
            float f2 = 4;
            Modifier modifier11 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1904632820, "CC(remember):ConsentPage.kt#9igjgp");
            if ((i4 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ConsentPageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return ConsentPageKt.ConsentPage$lambda$6$lambda$5$lambda$2$lambda$1$lambda$0(function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ConsentPageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return ConsentPageKt.ConsentPage$lambda$6$lambda$5$lambda$2$lambda$1$lambda$0(function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.TextButton((Function0) objRememberedValue, modifier11, false, (Shape) null, buttonColors3, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ConsentPageKt.INSTANCE.m1780getLambda$2028257321$app_release(), composerStartRestartGroup, 805306416, 492);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_consent_desc_privacy, composerStartRestartGroup, 0), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall(), composerStartRestartGroup, 48, 0, 130044);
            ButtonColors buttonColors4 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12);
            Modifier modifier12 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -990691393, "CC(remember):ConsentPage.kt#9igjgp");
            if ((i4 & 112) == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ConsentPageKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        return ConsentPageKt.ConsentPage$lambda$6$lambda$5$lambda$4$lambda$3(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ConsentPageKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        return ConsentPageKt.ConsentPage$lambda$6$lambda$5$lambda$4$lambda$3(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.TextButton((Function0) objRememberedValue2, modifier12, false, (Shape) null, buttonColors4, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$ConsentPageKt.INSTANCE.m1779getLambda$1236165491$app_release(), composerStartRestartGroup, 805306416, 492);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier9;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ConsentPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return ConsentPageKt.ConsentPage$lambda$7(function0, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsentPage$lambda$6$lambda$5$lambda$2$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConsentPage$lambda$6$lambda$5$lambda$4$lambda$3(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
