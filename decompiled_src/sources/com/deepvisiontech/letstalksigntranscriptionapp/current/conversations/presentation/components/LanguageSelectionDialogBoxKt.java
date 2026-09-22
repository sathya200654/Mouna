package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components;

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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RadioButtonColors;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageSelectionDialogBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"LanguageSelectionDialogBox", "", "modifier", "Landroidx/compose/ui/Modifier;", "languagesForSelection", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "selectedLanguage", "onLanguageSelect", "Lkotlin/Function1;", "onDismiss", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LanguageSelectionDialogBoxKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelectionDialogBox$lambda$11(Modifier modifier, List list, LanguageEnum languageEnum, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        LanguageSelectionDialogBox(modifier, list, languageEnum, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void LanguageSelectionDialogBox(Modifier modifier, final List<? extends LanguageEnum> list, final LanguageEnum languageEnum, final Function1<? super LanguageEnum, Unit> function1, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(list, "languagesForSelection");
        Intrinsics.checkNotNullParameter(languageEnum, "selectedLanguage");
        Intrinsics.checkNotNullParameter(function1, "onLanguageSelect");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(1392930703);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LanguageSelectionDialogBox)P(1!1,4,3)58@2474L2730,58@2437L2767:LanguageSelectionDialogBox.kt#ur4zcg");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(languageEnum.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1392930703, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.LanguageSelectionDialogBox (LanguageSelectionDialogBox.kt:44)");
            }
            composerStartRestartGroup.startReplaceGroup(-1423382092);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*46@2048L55,51@2275L11");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            builder.append(StringResources_androidKt.stringResource(R.string.conversation_dialog_lang_title, composerStartRestartGroup, 0));
            composerStartRestartGroup.startReplaceGroup(-1423378905);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*54@2356L58");
            int iPushStyle = builder.pushStyle(new SpanStyle(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), TextUnitKt.getSp(14), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null));
            try {
                builder.append("\n" + StringResources_androidKt.stringResource(R.string.conversation_dialog_lang_subtitle, composerStartRestartGroup, 0));
                Unit unit = Unit.INSTANCE;
                builder.pop(iPushStyle);
                composerStartRestartGroup.endReplaceGroup();
                final AnnotatedString annotatedString = builder.toAnnotatedString();
                composerStartRestartGroup.endReplaceGroup();
                final Modifier modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(1643196262, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.LanguageSelectionDialogBoxKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        return LanguageSelectionDialogBoxKt.LanguageSelectionDialogBox$lambda$10(modifier3, annotatedString, list, languageEnum, function1, function0, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i3 >> 12) & 14) | 384, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } catch (Throwable th) {
                builder.pop(iPushStyle);
                throw th;
            }
        }
        final Modifier modifier4 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.LanguageSelectionDialogBoxKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return LanguageSelectionDialogBoxKt.LanguageSelectionDialogBox$lambda$11(modifier4, list, languageEnum, function1, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit LanguageSelectionDialogBox$lambda$10$lambda$9(AnnotatedString annotatedString, List list, LanguageEnum languageEnum, final Function1 function1, Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C67@2783L2405:LanguageSelectionDialogBox.kt#ur4zcg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1885627327, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.LanguageSelectionDialogBox.<anonymous>.<anonymous> (LanguageSelectionDialogBox.kt:67)");
            }
            float f = 24;
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composer2 = Updater.constructor-impl(composer);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1575228508, "C72@2960L10,73@3028L11,70@2874L193,76@3085L41,81@3275L21,78@3144L1597,112@4759L41,114@4818L356:LanguageSelectionDialogBox.kt#ur4zcg");
            int i2 = 0;
            int i3 = 1;
            TextKt.Text-Z58ophY(annotatedString, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 262138);
            Composer composer3 = composer;
            int i4 = 6;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer3, 6);
            Modifier modifierWeight = columnScope.weight(ScrollKt.verticalScroll$default(SelectableGroupKt.selectableGroup(Modifier.Companion), ScrollKt.rememberScrollState(0, composer3, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), 1.0f, false);
            ComposerKt.sourceInformationMarkerStart(composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            int i5 = -1159599143;
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, str);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierWeight);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            int i6 = -553112988;
            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, str2);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer3.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composer3);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -1931802912, "C:LanguageSelectionDialogBox.kt#ur4zcg");
            composer3.startReplaceGroup(-2140525523);
            ComposerKt.sourceInformation(composer3, "*89@3663L6,92@3845L28,85@3463L1238");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final LanguageEnum languageEnum2 = (LanguageEnum) it.next();
                Modifier modifierClip = ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i3, (Object) null), Dp.constructor-impl(56)), MaterialTheme.INSTANCE.getShapes(composer3, MaterialTheme.$stable).getSmall());
                boolean z = languageEnum2 == languageEnum ? 1 : i2;
                Role role = Role.box-impl(Role.Companion.getRadioButton-o7Vup1c());
                ComposerKt.sourceInformationMarkerStart(composer3, 1895906937, "CC(remember):LanguageSelectionDialogBox.kt#9igjgp");
                boolean zChanged = composer3.changed(languageEnum2.ordinal()) | composer3.changed(function1);
                Object objRememberedValue = composer3.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.LanguageSelectionDialogBoxKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            return LanguageSelectionDialogBoxKt.LanguageSelectionDialogBox$lambda$10$lambda$9$lambda$8$lambda$6$lambda$5$lambda$3$lambda$2(function1, languageEnum2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifier2 = PaddingKt.padding-VpY3zN4$default(SelectableKt.selectable-oSLSa3U$default(modifierClip, z, false, role, (MutableInteractionSource) null, (Function0) objRememberedValue, 10, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                ComposerKt.sourceInformationMarkerStart(composer3, i5, str);
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, i2));
                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifier2);
                Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, i6, str2);
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor3);
                } else {
                    composer3.useNode();
                }
                Composer composer5 = Updater.constructor-impl(composer3);
                Updater.set-impl(composer5, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer5, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer5, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -2080719103, "C98@4162L162,104@4472L10,105@4548L11,102@4353L322:LanguageSelectionDialogBox.kt#ur4zcg");
                RadioButtonKt.RadioButton(languageEnum2 == languageEnum ? 1 : i2, (Function0) null, (Modifier) null, false, (RadioButtonColors) null, (MutableInteractionSource) null, composer, 48, 60);
                TextKt.Text-Nvy7gAk(languageEnum2.getDisplayText(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 48, 0, 131064);
                composer3 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                i4 = 6;
                str2 = str2;
                str = str;
                i2 = 0;
                i3 = 1;
                i5 = -1159599143;
                i6 = -553112988;
            }
            int i7 = i4;
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer3, i7);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(end, Alignment.Companion.getTop(), composer3, i7);
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, str);
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, str2);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor4);
            } else {
                composer3.useNode();
            }
            Composer composer6 = Updater.constructor-impl(composer3);
            Updater.set-impl(composer6, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer6, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer6, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -552480725, "C118@4979L177:LanguageSelectionDialogBox.kt#ur4zcg");
            ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$LanguageSelectionDialogBoxKt.INSTANCE.getLambda$1581863946$app_release(), composer3, 805306368, 510);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelectionDialogBox$lambda$10$lambda$9$lambda$8$lambda$6$lambda$5$lambda$3$lambda$2(Function1 function1, LanguageEnum languageEnum) {
        function1.invoke(languageEnum);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelectionDialogBox$lambda$10(Modifier modifier, final AnnotatedString annotatedString, final List list, final LanguageEnum languageEnum, final Function1 function1, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C63@2650L6,64@2709L14,66@2769L2429,59@2484L2714:LanguageSelectionDialogBox.kt#ur4zcg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1643196262, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.LanguageSelectionDialogBox.<anonymous> (LanguageSelectionDialogBox.kt:59)");
            }
            SurfaceKt.Surface-T9BRK9s(SizeKt.wrapContentHeight$default(SizeKt.widthIn-VpY3zN4(modifier, Dp.constructor-impl(280), Dp.constructor-impl(560)), (Alignment.Vertical) null, false, 3, (Object) null), MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getExtraLarge(), AlertDialogDefaults.INSTANCE.getContainerColor(composer, AlertDialogDefaults.$stable), 0L, Dp.constructor-impl(6), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1885627327, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.LanguageSelectionDialogBoxKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return LanguageSelectionDialogBoxKt.LanguageSelectionDialogBox$lambda$10$lambda$9(annotatedString, list, languageEnum, function1, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12607488, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
