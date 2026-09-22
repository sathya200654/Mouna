package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings;

import android.speech.tts.Voice;
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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
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
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsettings.VoiceOption;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Arrays;
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

/* JADX INFO: compiled from: VoiceSelectionDialogBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ag\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\bX\u008a\u008e\u0002"}, d2 = {"VoiceSelectionDialogBox", "", "modifier", "Landroidx/compose/ui/Modifier;", "voices", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsettings/VoiceOption;", "currentSavedVoiceId", "", "onPreviewVoice", "Lkotlin/Function1;", "onSaveVoice", "Landroid/speech/tts/Voice;", "onDismiss", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "tempSelectedVoiceId"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VoiceSelectionDialogBoxKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VoiceSelectionDialogBox$lambda$17(Modifier modifier, List list, String str, Function1 function1, Function1 function2, Function0 function0, int i, int i2, Composer composer, int i3) {
        VoiceSelectionDialogBox(modifier, list, str, function1, function2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void VoiceSelectionDialogBox(Modifier modifier, final List<VoiceOption> list, final String str, final Function1<? super VoiceOption, Unit> function1, final Function1<? super Voice, Unit> function2, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(list, "voices");
        Intrinsics.checkNotNullParameter(function1, "onPreviewVoice");
        Intrinsics.checkNotNullParameter(function2, "onSaveVoice");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1710162636);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VoiceSelectionDialogBox)P(1,5!1,3,4)52@2330L48,67@2859L3538,67@2822L3575:VoiceSelectionDialogBox.kt#k61bfg");
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
            i3 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            final Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1710162636, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.VoiceSelectionDialogBox (VoiceSelectionDialogBox.kt:51)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1506190180, "CC(remember):VoiceSelectionDialogBox.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(str, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startReplaceGroup(1506192788);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*55@2438L56,60@2666L11");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            builder.append(StringResources_androidKt.stringResource(R.string.conversation_dialog_voice_title, composerStartRestartGroup, 0));
            composerStartRestartGroup.startReplaceGroup(1506196006);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*63@2740L59");
            int iPushStyle = builder.pushStyle(new SpanStyle(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), TextUnitKt.getSp(14), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null));
            try {
                builder.append(StringResources_androidKt.stringResource(R.string.conversation_dialog_voice_subtitle, composerStartRestartGroup, 0));
                Unit unit = Unit.INSTANCE;
                builder.pop(iPushStyle);
                composerStartRestartGroup.endReplaceGroup();
                final AnnotatedString annotatedString = builder.toAnnotatedString();
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier5 = modifier4;
                AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(113436669, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.VoiceSelectionDialogBoxKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        return VoiceSelectionDialogBoxKt.VoiceSelectionDialogBox$lambda$16(modifier4, annotatedString, list, function1, mutableState, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 15) & 14) | 384, 2);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } catch (Throwable th) {
                builder.pop(iPushStyle);
                throw th;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.VoiceSelectionDialogBoxKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceSelectionDialogBoxKt.VoiceSelectionDialogBox$lambda$17(modifier3, list, str, function1, function2, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String VoiceSelectionDialogBox$lambda$1(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VoiceSelectionDialogBox$lambda$16$lambda$15(AnnotatedString annotatedString, final List list, final Function1 function1, final MutableState mutableState, final Function0 function0, final Function1 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C76@3168L3213:VoiceSelectionDialogBox.kt#k61bfg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2101649598, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.VoiceSelectionDialogBox.<anonymous>.<anonymous> (VoiceSelectionDialogBox.kt:76)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1452693479, "C81@3345L10,82@3413L11,79@3259L193,85@3470L41,90@3660L21,87@3529L1932,129@5479L41,131@5538L829:VoiceSelectionDialogBox.kt#k61bfg");
            int i2 = 0;
            int i3 = 1;
            TextKt.Text-Z58ophY(annotatedString, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 262138);
            Composer composer3 = composer;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer3, 6);
            Modifier modifierWeight = columnScope.weight(ScrollKt.verticalScroll$default(SelectableGroupKt.selectableGroup(Modifier.Companion), ScrollKt.rememberScrollState(0, composer3, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), 1.0f, false);
            ComposerKt.sourceInformationMarkerStart(composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            int i4 = -1159599143;
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, str);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierWeight);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
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
            ComposerKt.sourceInformationMarkerStart(composer3, 1970495352, "C:VoiceSelectionDialogBox.kt#k61bfg");
            composer3.startReplaceGroup(1033395908);
            ComposerKt.sourceInformation(composer3, "*100@4108L6,103@4272L174,96@3908L1513");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final VoiceOption voiceOption = (VoiceOption) it.next();
                boolean zAreEqual = Intrinsics.areEqual(VoiceSelectionDialogBox$lambda$1(mutableState), voiceOption.getId());
                Modifier modifierClip = ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i3, (Object) null), Dp.constructor-impl(56)), MaterialTheme.INSTANCE.getShapes(composer3, MaterialTheme.$stable).getSmall());
                Role role = Role.box-impl(Role.Companion.getRadioButton-o7Vup1c());
                ComposerKt.sourceInformationMarkerStart(composer3, 1636975916, "CC(remember):VoiceSelectionDialogBox.kt#9igjgp");
                boolean zChangedInstance = composer3.changedInstance(voiceOption) | composer3.changed(function1);
                Object objRememberedValue = composer3.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.VoiceSelectionDialogBoxKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            return VoiceSelectionDialogBoxKt.VoiceSelectionDialogBox$lambda$16$lambda$15$lambda$14$lambda$9$lambda$8$lambda$6$lambda$5(voiceOption, function1, mutableState);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifier2 = PaddingKt.padding-VpY3zN4$default(SelectableKt.selectable-oSLSa3U$default(modifierClip, zAreEqual, false, role, (MutableInteractionSource) null, (Function0) objRememberedValue, 10, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                ComposerKt.sourceInformationMarkerStart(composer3, i4, str);
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, i2));
                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifier2);
                Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, -553112988, str2);
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
                ComposerKt.sourceInformationMarkerStart(composer3, 1853727469, "C112@4735L144,117@4953L183,121@5192L10,122@5268L11,116@4908L487:VoiceSelectionDialogBox.kt#k61bfg");
                RadioButtonKt.RadioButton(zAreEqual, (Function0) null, (Modifier) null, false, (RadioButtonColors) null, (MutableInteractionSource) null, composer3, 48, 60);
                int displayNameRes = voiceOption.getDisplayNameRes();
                Object[] array = voiceOption.getDisplayNameArgs().toArray(new Object[i2]);
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(displayNameRes, Arrays.copyOf(array, array.length), composer3, i2), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyLarge(), composer, 48, 0, 131064);
                composer3 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                str2 = str2;
                str = str;
                i2 = 0;
                i3 = 1;
                i4 = -1159599143;
            }
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer3, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(end, Alignment.Companion.getTop(), composer3, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer3, -1816318499, "C135@5699L177,141@5898L39,144@6005L224,143@5959L390:VoiceSelectionDialogBox.kt#k61bfg");
            ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$VoiceSelectionDialogBoxKt.INSTANCE.getLambda$1631426777$app_release(), composer, 805306368, 510);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1465439100, "CC(remember):VoiceSelectionDialogBox.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(list) | composer.changed(function2) | composer.changed(function0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.VoiceSelectionDialogBoxKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        return VoiceSelectionDialogBoxKt.VoiceSelectionDialogBox$lambda$16$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11(list, function2, function0, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue2, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$VoiceSelectionDialogBoxKt.INSTANCE.getLambda$1489355472$app_release(), composer, 805306368, 510);
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
    public static final Unit VoiceSelectionDialogBox$lambda$16$lambda$15$lambda$14$lambda$9$lambda$8$lambda$6$lambda$5(VoiceOption voiceOption, Function1 function1, MutableState mutableState) {
        mutableState.setValue(voiceOption.getId());
        function1.invoke(voiceOption);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VoiceSelectionDialogBox$lambda$16$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11(List list, Function1 function1, Function0 function0, MutableState mutableState) {
        Object next;
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((VoiceOption) next).getId(), VoiceSelectionDialogBox$lambda$1(mutableState)));
        VoiceOption voiceOption = (VoiceOption) next;
        function1.invoke(voiceOption != null ? voiceOption.getVoice() : null);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VoiceSelectionDialogBox$lambda$16(Modifier modifier, final AnnotatedString annotatedString, final List list, final Function1 function1, final MutableState mutableState, final Function0 function0, final Function1 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@3035L6,73@3094L14,75@3154L3237,68@2869L3522:VoiceSelectionDialogBox.kt#k61bfg");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(113436669, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.VoiceSelectionDialogBox.<anonymous> (VoiceSelectionDialogBox.kt:68)");
            }
            SurfaceKt.Surface-T9BRK9s(SizeKt.wrapContentHeight$default(SizeKt.widthIn-VpY3zN4(modifier, Dp.constructor-impl(280), Dp.constructor-impl(560)), (Alignment.Vertical) null, false, 3, (Object) null), MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getExtraLarge(), AlertDialogDefaults.INSTANCE.getContainerColor(composer, AlertDialogDefaults.$stable), 0L, Dp.constructor-impl(6), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-2101649598, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.VoiceSelectionDialogBoxKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return VoiceSelectionDialogBoxKt.VoiceSelectionDialogBox$lambda$16$lambda$15(annotatedString, list, function1, mutableState, function0, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12607488, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
