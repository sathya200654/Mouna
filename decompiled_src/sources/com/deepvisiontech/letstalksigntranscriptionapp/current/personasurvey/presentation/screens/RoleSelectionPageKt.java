package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BorderStroke;
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
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Role;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoleSelectionPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001am\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000326\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"RoleSelectionPage", "", "persona", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "onRoleSelected", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "roleId", "personaId", "onSubmit", "Lkotlin/Function0;", "selectedRoleCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RoleSelectionPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleSelectionPage$lambda$9(Persona persona, Function2 function2, Function0 function0, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        RoleSelectionPage(persona, function2, function0, i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x044e  */
    /* JADX WARN: Code duplicated, block: B:104:0x045a  */
    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:48:0x0095  */
    /* JADX WARN: Code duplicated, block: B:51:0x009e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:59:0x0100  */
    /* JADX WARN: Code duplicated, block: B:62:0x010c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0110  */
    /* JADX WARN: Code duplicated, block: B:66:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:69:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:70:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x0339  */
    /* JADX WARN: Code duplicated, block: B:76:0x0351  */
    /* JADX WARN: Code duplicated, block: B:77:0x0353  */
    /* JADX WARN: Code duplicated, block: B:86:0x036b  */
    /* JADX WARN: Code duplicated, block: B:91:0x037b  */
    /* JADX WARN: Code duplicated, block: B:95:0x040d  */
    /* JADX WARN: Code duplicated, block: B:96:0x040f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0448  */
    public static final void RoleSelectionPage(final Persona persona, final Function2<? super String, ? super String, Unit> function2, final Function0<Unit> function0, final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function0 constructor;
        Composer composer3;
        int i4;
        Function0 constructor2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Object objRememberedValue;
        final Persona persona2 = persona;
        Intrinsics.checkNotNullParameter(persona2, "persona");
        Intrinsics.checkNotNullParameter(function2, "onRoleSelected");
        Intrinsics.checkNotNullParameter(function0, "onSubmit");
        Composer composerStartRestartGroup = composer.startRestartGroup(1950242169);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RoleSelectionPage)P(3,1,2,4)39@1738L2502:RoleSelectionPage.kt#j5zu2x");
        int i5 = (i2 & 6) == 0 ? ((i2 & 8) == 0 ? composerStartRestartGroup.changed(persona2) : composerStartRestartGroup.changedInstance(persona2) ? 4 : 2) | i2 : i2;
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        int i6 = i3 & 16;
        if (i6 == 0) {
            if ((i2 & 24576) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i5 & 9363) != 9362) {
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
                    ComposerKt.traceEventStart(1950242169, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPage (RoleSelectionPage.kt:38)");
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
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 164355650, "C45@1925L55,47@2058L10,44@1900L193,50@2127L74,52@2279L11,53@2334L10,49@2102L263,61@2658L21,55@2374L1119,86@3576L658,84@3502L732:RoleSelectionPage.kt#j5zu2x");
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_role_title_question, composerStartRestartGroup, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 0, 0, 130046);
                TextKt.Text-Nvy7gAk(StringResources_androidKt.pluralStringResource(R.plurals.onboarding_role_desc_selection_limit, 2, new Object[]{2}, composerStartRestartGroup, 48), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 0, 0, 130042);
                composer3 = composerStartRestartGroup;
                Arrangement.Vertical center2 = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
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
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -1741171892, "C:RoleSelectionPage.kt#j5zu2x");
                composer3.startReplaceGroup(-1857281719);
                ComposerKt.sourceInformation(composer3, "*66@2843L83,69@2956L325,64@2753L716");
                for (final Role role : persona2.getRoles()) {
                    boolean zIsSelected = role.isSelected();
                    ComposerKt.sourceInformationMarkerStart(composer3, 802977675, "CC(remember):RoleSelectionPage.kt#9igjgp");
                    if ((i5 & 112) == 32) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    boolean zChanged = composer3.changed(role) | z3;
                    if ((i5 & 14) != 4 || ((i5 & 8) != 0 && composer3.changedInstance(persona2))) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z5 = zChanged | z4;
                    objRememberedValue = composer3.rememberedValue();
                    if (!z5 || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPageKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                return RoleSelectionPageKt.RoleSelectionPage$lambda$8$lambda$4$lambda$3$lambda$1$lambda$0(function2, role, persona2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Composer composer6 = composer3;
                    ChipKt.FilterChip(zIsSelected, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(795000939, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPageKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            return RoleSelectionPageKt.RoleSelectionPage$lambda$8$lambda$4$lambda$3$lambda$2(role, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, i4), SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(2), 1, (Object) null), Dp.constructor-impl(56)), false, (Function2) null, (Function2) null, (Shape) null, (SelectableChipColors) null, (SelectableChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer6, 3456, 0, 4080);
                    i4 = i4;
                    composer3 = composer6;
                    persona2 = persona;
                }
                int i7 = i4;
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (i > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1609660309, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPageKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return RoleSelectionPageKt.RoleSelectionPage$lambda$8$lambda$7(function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, i7), composer3, 1572870, 30);
                composer2 = composer3;
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPageKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2) {
                        return RoleSelectionPageKt.RoleSelectionPage$lambda$9(persona, function2, function0, i, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        modifier2 = modifier;
        if ((i5 & 9363) != 9362) {
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
                ComposerKt.traceEventStart(1950242169, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPage (RoleSelectionPage.kt:38)");
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
            Modifier modifier6 = modifier4;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 164355650, "C45@1925L55,47@2058L10,44@1900L193,50@2127L74,52@2279L11,53@2334L10,49@2102L263,61@2658L21,55@2374L1119,86@3576L658,84@3502L732:RoleSelectionPage.kt#j5zu2x");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_role_title_question, composerStartRestartGroup, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 0, 0, 130046);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.pluralStringResource(R.plurals.onboarding_role_desc_selection_limit, 2, new Object[]{2}, composerStartRestartGroup, 48), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 0, 0, 130042);
            composer3 = composerStartRestartGroup;
            Arrangement.Vertical center4 = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally4 = Alignment.Companion.getCenterHorizontally();
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
            ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -1741171892, "C:RoleSelectionPage.kt#j5zu2x");
            composer3.startReplaceGroup(-1857281719);
            ComposerKt.sourceInformation(composer3, "*66@2843L83,69@2956L325,64@2753L716");
            while (r23.hasNext()) {
                boolean zIsSelected2 = role.isSelected();
                ComposerKt.sourceInformationMarkerStart(composer3, 802977675, "CC(remember):RoleSelectionPage.kt#9igjgp");
                if ((i5 & 112) == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean zChanged2 = composer3.changed(role) | z3;
                if ((i5 & 14) != 4) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                z5 = zChanged2 | z4;
                objRememberedValue = composer3.rememberedValue();
                if (!z5) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPageKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return RoleSelectionPageKt.RoleSelectionPage$lambda$8$lambda$4$lambda$3$lambda$1$lambda$0(function2, role, persona2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPageKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return RoleSelectionPageKt.RoleSelectionPage$lambda$8$lambda$4$lambda$3$lambda$1$lambda$0(function2, role, persona2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Composer composer9 = composer3;
                ChipKt.FilterChip(zIsSelected2, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(795000939, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        return RoleSelectionPageKt.RoleSelectionPage$lambda$8$lambda$4$lambda$3$lambda$2(role, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, i4), SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(2), 1, (Object) null), Dp.constructor-impl(56)), false, (Function2) null, (Function2) null, (Shape) null, (SelectableChipColors) null, (SelectableChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer9, 3456, 0, 4080);
                i4 = i4;
                composer3 = composer9;
                persona2 = persona;
            }
            int i8 = i4;
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (i > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            AnimatedVisibilityKt.AnimatedVisibility(columnScope3, z2, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1609660309, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RoleSelectionPageKt.RoleSelectionPage$lambda$8$lambda$7(function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, i8), composer3, 1572870, 30);
            composer2 = composer3;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    return RoleSelectionPageKt.RoleSelectionPage$lambda$9(persona, function2, function0, i, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleSelectionPage$lambda$8$lambda$4$lambda$3$lambda$1$lambda$0(Function2 function2, Role role, Persona persona) {
        function2.invoke(role.getId(), persona.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleSelectionPage$lambda$8$lambda$4$lambda$3$lambda$2(Role role, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@3091L10,70@2982L277:RoleSelectionPage.kt#j5zu2x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(795000939, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RoleSelectionPage.kt:70)");
            }
            TextKt.Text-Nvy7gAk(role.getDisplayText(), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 48, 0, 130044);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleSelectionPage$lambda$8$lambda$7$lambda$6$lambda$5(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleSelectionPage$lambda$8$lambda$7(final Function0 function0, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C92@3785L11,93@3864L11,91@3720L192,88@3628L50,87@3590L634:RoleSelectionPage.kt#j5zu2x");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1609660309, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPage.<anonymous>.<anonymous> (RoleSelectionPage.kt:87)");
        }
        ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composer, ButtonDefaults.$stable << 12, 12);
        Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4));
        ComposerKt.sourceInformationMarkerStart(composer, -695328675, "CC(remember):RoleSelectionPage.kt#9igjgp");
        boolean zChanged = composer.changed(function0);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.RoleSelectionPageKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    return RoleSelectionPageKt.RoleSelectionPage$lambda$8$lambda$7$lambda$6$lambda$5(function0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ButtonKt.TextButton((Function0) objRememberedValue, modifier, false, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$RoleSelectionPageKt.INSTANCE.m1781getLambda$272844658$app_release(), composer, 805306416, 492);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
