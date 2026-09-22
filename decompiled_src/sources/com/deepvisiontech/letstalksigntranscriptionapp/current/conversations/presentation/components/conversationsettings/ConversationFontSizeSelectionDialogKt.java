package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ConversationFontSizeSelectionDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"ConversationFontSizeSelectionDialog", "", "modifier", "Landroidx/compose/ui/Modifier;", "currentFontSize", "", "onFontSizeChange", "Lkotlin/Function1;", "onDismiss", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationFontSizeSelectionDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationFontSizeSelectionDialog$lambda$5(Modifier modifier, float f, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        ConversationFontSizeSelectionDialog(modifier, f, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ConversationFontSizeSelectionDialog(final Modifier modifier, final float f, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(function1, "onFontSizeChange");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-15613164);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConversationFontSizeSelectionDialog)P(1!1,3)35@1507L1947,35@1470L1984:ConversationFontSizeSelectionDialog.kt#k61bfg");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-15613164, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ConversationFontSizeSelectionDialog (ConversationFontSizeSelectionDialog.kt:34)");
            }
            AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(569693405, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ConversationFontSizeSelectionDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationFontSizeSelectionDialogKt.ConversationFontSizeSelectionDialog$lambda$4(modifier, f, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 9) & 14) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ConversationFontSizeSelectionDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationFontSizeSelectionDialogKt.ConversationFontSizeSelectionDialog$lambda$5(modifier2, f, function1, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationFontSizeSelectionDialog$lambda$4$lambda$3(float f, Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C44@1816L1622:ConversationFontSizeSelectionDialog.kt#k61bfg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-336054494, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ConversationFontSizeSelectionDialog.<anonymous>.<anonymous> (ConversationFontSizeSelectionDialog.kt:44)");
            }
            float f2 = 24;
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2));
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
            ComposerKt.sourceInformationMarkerStart(composer, 1441484063, "C49@1941L55,50@2040L10,51@2108L11,48@1908L239,54@2165L41,56@2224L1200:ConversationFontSizeSelectionDialog.kt#k61bfg");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_dialog_font_title, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), composer, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composer3 = Updater.constructor-impl(composer);
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -939929372, "C61@2461L584,75@3067L40,77@3129L277:ConversationFontSizeSelectionDialog.kt#k61bfg");
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(80)), 0.0f, 1, (Object) null);
            Alignment center2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composer);
            Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1826588434, "C68@2747L58,70@2916L11,67@2706L317:ConversationFontSizeSelectionDialog.kt#k61bfg");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_font_sample, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(f), (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 1572864, 0, 262058);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer, 6);
            SliderKt.Slider(f, function1, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, RangesKt.rangeTo(16.0f, 48.0f), 8, (Function0) null, (SliderColors) null, (MutableInteractionSource) null, composer, 196992, 456);
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
    public static final Unit ConversationFontSizeSelectionDialog$lambda$4(Modifier modifier, final float f, final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C40@1683L6,41@1742L14,43@1802L1646,36@1517L1931:ConversationFontSizeSelectionDialog.kt#k61bfg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(569693405, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ConversationFontSizeSelectionDialog.<anonymous> (ConversationFontSizeSelectionDialog.kt:36)");
            }
            SurfaceKt.Surface-T9BRK9s(SizeKt.wrapContentHeight$default(SizeKt.widthIn-VpY3zN4(modifier, Dp.constructor-impl(280), Dp.constructor-impl(560)), (Alignment.Vertical) null, false, 3, (Object) null), MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getExtraLarge(), AlertDialogDefaults.INSTANCE.getContainerColor(composer, AlertDialogDefaults.$stable), 0L, Dp.constructor-impl(6), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-336054494, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ConversationFontSizeSelectionDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationFontSizeSelectionDialogKt.ConversationFontSizeSelectionDialog$lambda$4$lambda$3(f, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12607488, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
