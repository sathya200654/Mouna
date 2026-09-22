package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.SelectableChipElevation;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PersonaSelectionPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"PersonaSelectionPage", "", "personas", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "onPersonaSelected", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "personaId", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PersonaSelectionPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaSelectionPage$lambda$6(List list, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PersonaSelectionPage(list, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:49:0x0289  */
    /* JADX WARN: Code duplicated, block: B:52:0x0295  */
    /* JADX WARN: Code duplicated, block: B:53:0x0299  */
    /* JADX WARN: Code duplicated, block: B:57:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:59:0x0332  */
    /* JADX WARN: Code duplicated, block: B:60:0x0334  */
    /* JADX WARN: Code duplicated, block: B:65:0x0349  */
    /* JADX WARN: Code duplicated, block: B:69:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x03de  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    public static final void PersonaSelectionPage(final List<Persona> list, final Function1<? super String, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function0 constructor;
        int i3;
        Composer composer3;
        float f;
        Object obj;
        boolean z2;
        int i4;
        Function0 constructor2;
        final ColumnScope columnScope;
        boolean z3;
        boolean zChangedInstance;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(list, "personas");
        Intrinsics.checkNotNullParameter(function1, "onPersonaSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(165147935);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PersonaSelectionPage)P(2,1)32@1351L1761:PersonaSelectionPage.kt#j5zu2x");
        int i5 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i5 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(165147935, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.PersonaSelectionPage (PersonaSelectionPage.kt:31)");
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
                Modifier modifier5 = modifier4;
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
                Composer composer4 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer4, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1974064885, "C38@1538L58,40@1674L10,37@1513L196,43@1743L77,45@1898L11,46@1953L10,42@1718L266,54@2277L21,48@1993L1113:PersonaSelectionPage.kt#j5zu2x");
                i3 = i5;
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_persona_title_question, composerStartRestartGroup, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 0, 0, 130046);
                TextKt.Text-Nvy7gAk(StringResources_androidKt.pluralStringResource(R.plurals.onboarding_persona_desc_selection_limit, 1, new Object[]{1}, composerStartRestartGroup, 48), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 0, 0, 130042);
                composer3 = composerStartRestartGroup;
                Arrangement.Vertical center2 = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
                f = 0.0f;
                obj = null;
                z2 = false;
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(32), Dp.constructor-impl(8)), ScrollKt.rememberScrollState(0, composer3, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                i4 = 54;
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, composer3, 54);
                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierVerticalScroll$default);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor2);
                } else {
                    composer3.useNode();
                }
                Composer composer5 = Updater.constructor-impl(composer3);
                Updater.set-impl(composer5, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer5, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer5, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146533676, "C:PersonaSelectionPage.kt#j5zu2x");
                composer3.startReplaceGroup(900588582);
                ComposerKt.sourceInformation(composer3, "*58@2412L77,62@2570L324,57@2370L712");
                for (final Persona persona : list) {
                    boolean zIsSelected = persona.isSelected();
                    Modifier modifier6 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, f, Dp.constructor-impl(2), 1, obj), f, 1, obj), Dp.constructor-impl(56));
                    ComposerKt.sourceInformationMarkerStart(composer3, -1546866355, "CC(remember):PersonaSelectionPage.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    zChangedInstance = z3 | composer3.changedInstance(persona);
                    objRememberedValue = composer3.rememberedValue();
                    if (!zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.PersonaSelectionPageKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                return PersonaSelectionPageKt.PersonaSelectionPage$lambda$5$lambda$4$lambda$3$lambda$1$lambda$0(function1, persona);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Composer composer6 = composer3;
                    ChipKt.FilterChip(zIsSelected, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-2072109869, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.PersonaSelectionPageKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2, Object obj3) {
                            return PersonaSelectionPageKt.PersonaSelectionPage$lambda$5$lambda$4$lambda$3$lambda$2(persona, columnScope, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer3, i4), modifier6, false, (Function2) null, (Function2) null, (Shape) null, (SelectableChipColors) null, (SelectableChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer6, 3456, 0, 4080);
                    composer3 = composer6;
                    obj = obj;
                    f = f;
                    i4 = i4;
                    z2 = false;
                }
                composer2 = composer3;
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.PersonaSelectionPageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2, Object obj3) {
                        return PersonaSelectionPageKt.PersonaSelectionPage$lambda$6(list, function1, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i5 |= 384;
        modifier2 = modifier;
        if ((i5 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i6 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(165147935, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.PersonaSelectionPage (PersonaSelectionPage.kt:31)");
            }
            Alignment.Horizontal centerHorizontally3 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical center3 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(center3, centerHorizontally3, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            constructor = ComposeUiNode.Companion.getConstructor();
            Modifier modifier7 = modifier4;
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
            Composer composer7 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer7, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer7, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer7, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer7, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1974064885, "C38@1538L58,40@1674L10,37@1513L196,43@1743L77,45@1898L11,46@1953L10,42@1718L266,54@2277L21,48@1993L1113:PersonaSelectionPage.kt#j5zu2x");
            i3 = i5;
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_persona_title_question, composerStartRestartGroup, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 0, 0, 130046);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.pluralStringResource(R.plurals.onboarding_persona_desc_selection_limit, 1, new Object[]{1}, composerStartRestartGroup, 48), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 0, 0, 130042);
            composer3 = composerStartRestartGroup;
            Arrangement.Vertical center4 = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally4 = Alignment.Companion.getCenterHorizontally();
            f = 0.0f;
            obj = null;
            z2 = false;
            Modifier modifierVerticalScroll$default2 = ScrollKt.verticalScroll$default(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(32), Dp.constructor-impl(8)), ScrollKt.rememberScrollState(0, composer3, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            i4 = 54;
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(center4, centerHorizontally4, composer3, 54);
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer3, modifierVerticalScroll$default2);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer3.useNode();
            }
            Composer composer8 = Updater.constructor-impl(composer3);
            Updater.set-impl(composer8, measurePolicyColumnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer8, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer8, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer8, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -2146533676, "C:PersonaSelectionPage.kt#j5zu2x");
            composer3.startReplaceGroup(900588582);
            ComposerKt.sourceInformation(composer3, "*58@2412L77,62@2570L324,57@2370L712");
            while (r21.hasNext()) {
                boolean zIsSelected2 = persona.isSelected();
                Modifier modifier8 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, f, Dp.constructor-impl(2), 1, obj), f, 1, obj), Dp.constructor-impl(56));
                ComposerKt.sourceInformationMarkerStart(composer3, -1546866355, "CC(remember):PersonaSelectionPage.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                zChangedInstance = z3 | composer3.changedInstance(persona);
                objRememberedValue = composer3.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.PersonaSelectionPageKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return PersonaSelectionPageKt.PersonaSelectionPage$lambda$5$lambda$4$lambda$3$lambda$1$lambda$0(function1, persona);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.PersonaSelectionPageKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return PersonaSelectionPageKt.PersonaSelectionPage$lambda$5$lambda$4$lambda$3$lambda$1$lambda$0(function1, persona);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Composer composer9 = composer3;
                ChipKt.FilterChip(zIsSelected2, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-2072109869, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.PersonaSelectionPageKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2, Object obj3) {
                        return PersonaSelectionPageKt.PersonaSelectionPage$lambda$5$lambda$4$lambda$3$lambda$2(persona, columnScope, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, i4), modifier8, false, (Function2) null, (Function2) null, (Shape) null, (SelectableChipColors) null, (SelectableChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer9, 3456, 0, 4080);
                composer3 = composer9;
                obj = obj;
                f = f;
                i4 = i4;
                z2 = false;
            }
            composer2 = composer3;
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier7;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.PersonaSelectionPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2, Object obj3) {
                    return PersonaSelectionPageKt.PersonaSelectionPage$lambda$6(list, function1, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaSelectionPage$lambda$5$lambda$4$lambda$3$lambda$1$lambda$0(Function1 function1, Persona persona) {
        function1.invoke(persona.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaSelectionPage$lambda$5$lambda$4$lambda$3$lambda$2(Persona persona, ColumnScope columnScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C65@2708L10,63@2596L276:PersonaSelectionPage.kt#j5zu2x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2072109869, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.PersonaSelectionPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PersonaSelectionPage.kt:63)");
            }
            TextKt.Text-Nvy7gAk(persona.getDisplayText(), ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 0, 130044);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
