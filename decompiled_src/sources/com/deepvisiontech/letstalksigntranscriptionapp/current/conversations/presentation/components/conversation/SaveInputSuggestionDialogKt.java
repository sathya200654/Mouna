package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ExposedDropdownMenuAnchorType;
import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.material3.ExposedDropdownMenuDefaults;
import androidx.compose.material3.ExposedDropdownMenuKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuItemColors;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.CorrectionSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.SuggestionCategory;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import com.google.protobuf.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SaveInputSuggestionDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\u001a\u008a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2M\u0010\u000b\u001aI\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\bX\u008a\u008e\u0002"}, d2 = {"SaveInputSuggestionDialog", "", "modifier", "Landroidx/compose/ui/Modifier;", "suggestionToSave", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "existingCategories", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "onDismissRequest", "Lkotlin/Function0;", "onSave", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "selectedCategory", "", "categoryName", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "app_release", "categoryInputText", "expanded", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SaveInputSuggestionDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$33(Modifier modifier, CorrectionSuggestion correctionSuggestion, List list, Function0 function0, Function3 function3, int i, int i2, Composer composer, int i3) {
        SaveInputSuggestionDialog(modifier, correctionSuggestion, list, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SaveInputSuggestionDialog(Modifier modifier, final CorrectionSuggestion correctionSuggestion, final List<SuggestionCategory> list, final Function0<Unit> function0, final Function3<? super SuggestionCategory, ? super String, ? super CorrectionSuggestion, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        MutableState mutableState;
        Intrinsics.checkNotNullParameter(correctionSuggestion, "suggestionToSave");
        Intrinsics.checkNotNullParameter(list, "existingCategories");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function3, "onSave");
        Composer composerStartRestartGroup = composer.startRestartGroup(651292239);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SaveInputSuggestionDialog)P(1,4)53@2691L31,54@2743L34,55@2806L54,57@2891L233,63@3173L5990,63@3129L6034:SaveInputSuggestionDialog.kt#hsonup");
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
            i3 |= composerStartRestartGroup.changed(correctionSuggestion) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        int i5 = i3;
        if (!composerStartRestartGroup.shouldExecute((i5 & 9363) != 9362, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            final Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(651292239, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialog (SaveInputSuggestionDialog.kt:52)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173370674, "CC(remember):SaveInputSuggestionDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173369007, "CC(remember):SaveInputSuggestionDialog.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173366971, "CC(remember):SaveInputSuggestionDialog.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strSaveInputSuggestionDialog$lambda$1 = SaveInputSuggestionDialog$lambda$1(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1173364072, "CC(remember):SaveInputSuggestionDialog.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strSaveInputSuggestionDialog$lambda$1) | composerStartRestartGroup.changed(list);
            ArrayList arrayListRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || arrayListRememberedValue == Composer.Companion.getEmpty()) {
                if (StringsKt.isBlank(SaveInputSuggestionDialog$lambda$1(mutableState2))) {
                    mutableState = mutableState3;
                    arrayListRememberedValue = list;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        MutableState mutableState5 = mutableState3;
                        if (StringsKt.contains(((SuggestionCategory) obj).getName(), SaveInputSuggestionDialog$lambda$1(mutableState2), true)) {
                            arrayList.add(obj);
                        }
                        mutableState3 = mutableState5;
                    }
                    mutableState = mutableState3;
                    arrayListRememberedValue = arrayList;
                }
                composerStartRestartGroup.updateRememberedValue(arrayListRememberedValue);
            } else {
                mutableState = mutableState3;
            }
            final List list2 = (List) arrayListRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState6 = mutableState;
            Function2 function2 = new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj2, Object obj3) {
                    return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32(modifier4, correctionSuggestion, mutableState6, list, list2, mutableState2, mutableState4, function0, function3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Modifier modifier5 = modifier4;
            composer2 = composerStartRestartGroup;
            AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(-1820075752, true, function2, composerStartRestartGroup, 54), composer2, ((i5 >> 9) & 14) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj2, Object obj3) {
                    return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$33(modifier3, correctionSuggestion, list, function0, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final String SaveInputSuggestionDialog$lambda$1(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final boolean SaveInputSuggestionDialog$lambda$4(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void SaveInputSuggestionDialog$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final SuggestionCategory SaveInputSuggestionDialog$lambda$7(MutableState<SuggestionCategory> mutableState) {
        return (SuggestionCategory) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31(final CorrectionSuggestion correctionSuggestion, MutableState mutableState, final List list, final List list2, final MutableState mutableState2, final MutableState mutableState3, Function0 function0, final Function3 function3, Composer composer, int i) {
        final MutableState mutableState4;
        String strStringResource;
        final MutableState mutableState5;
        ComposerKt.sourceInformation(composer, "C75@3598L21,72@3482L5665:SaveInputSuggestionDialog.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(259805277, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialog.<anonymous>.<anonymous> (SaveInputSuggestionDialog.kt:72)");
            }
            float f = 24;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), ScrollKt.rememberScrollState(0, composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -9362452, "C79@3754L66,80@3864L10,81@3932L11,78@3721L250,84@3989L41,95@4540L10,96@4605L6,98@4741L11,99@4824L11,100@4904L11,101@4997L11,97@4675L389,88@4158L3,86@4048L1034,105@5100L41,109@5263L24,111@5362L2114,107@5159L2317,160@7954L10,161@8018L11,158@7869L328,167@8215L41,169@8274L859:SaveInputSuggestionDialog.kt#hsonup");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_dialog_save_suggestion_title, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            String sentence = correctionSuggestion.getSentence();
            Modifier modifier = SizeKt.heightIn-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(100), Dp.constructor-impl(180));
            TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium();
            Shape medium = MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getMedium();
            TextFieldColors textFieldColors = OutlinedTextFieldDefaults.INSTANCE.colors-0hiis_0(0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), 0L, 0L, 0L, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0L, (TextSelectionColors) null, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOutline-0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, 0, 3072, 2113920955, 4095);
            ComposerKt.sourceInformationMarkerStart(composer, 1800821878, "CC(remember):SaveInputSuggestionDialog.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$12$lambda$11((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(sentence, (Function1) objRememberedValue, modifier, false, true, bodyMedium, ComposableSingletons$SaveInputSuggestionDialogKt.INSTANCE.m1548getLambda$1872300307$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, medium, textFieldColors, composer, 1600944, 0, 0, 2097024);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer, 6);
            boolean zSaveInputSuggestionDialog$lambda$4 = SaveInputSuggestionDialog$lambda$4(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1800857259, "CC(remember):SaveInputSuggestionDialog.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                mutableState4 = mutableState;
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$14$lambda$13(mutableState4, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                mutableState4 = mutableState;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ExposedDropdownMenuKt.ExposedDropdownMenuBox(zSaveInputSuggestionDialog$lambda$4, (Function1) objRememberedValue2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ComposableLambdaKt.rememberComposableLambda(-645141783, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26(list, list2, mutableState2, mutableState3, mutableState4, (ExposedDropdownMenuBoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3504, 0);
            if (SaveInputSuggestionDialog$lambda$7(mutableState3) != null) {
                composer.startReplaceGroup(-5739266);
                ComposerKt.sourceInformation(composer, "151@7561L73");
                strStringResource = StringResources_androidKt.stringResource(R.string.conversation_dialog_save_suggestion_msg_existing, composer, 0);
                composer.endReplaceGroup();
            } else if (!StringsKt.isBlank(SaveInputSuggestionDialog$lambda$1(mutableState2))) {
                composer.startReplaceGroup(-5585661);
                ComposerKt.sourceInformation(composer, "153@7716L68");
                strStringResource = StringResources_androidKt.stringResource(R.string.conversation_dialog_save_suggestion_msg_new, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-5474588);
                composer.endReplaceGroup();
                strStringResource = " ";
            }
            float f2 = 4;
            TextKt.Text-Nvy7gAk(strStringResource, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f2), Dp.constructor-impl(f2), 0.0f, 0.0f, 12, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131064);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer, 54);
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
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1016520264, "C174@8503L184,180@8709L39,183@8812L117,182@8770L345:SaveInputSuggestionDialog.kt#hsonup");
            ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SaveInputSuggestionDialogKt.INSTANCE.m1549getLambda$302085644$app_release(), composer, 805306368, 510);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1214125620, "CC(remember):SaveInputSuggestionDialog.kt#9igjgp");
            boolean zChanged = composer.changed(function3) | composer.changed(correctionSuggestion);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.Companion.getEmpty()) {
                mutableState5 = mutableState2;
                objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27(function3, correctionSuggestion, mutableState3, mutableState5);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            } else {
                mutableState5 = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.Button((Function0) objRememberedValue3, (Modifier) null, !StringsKt.isBlank(SaveInputSuggestionDialog$lambda$1(mutableState5)), (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SaveInputSuggestionDialogKt.INSTANCE.getLambda$1455481255$app_release(), composer, 805306368, 506);
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
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$12$lambda$11(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$14$lambda$13(MutableState mutableState, boolean z) {
        SaveInputSuggestionDialog$lambda$5(mutableState, !SaveInputSuggestionDialog$lambda$4(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26(final List list, final List list2, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(exposedDropdownMenuBoxScope, "$this$ExposedDropdownMenuBox");
        ComposerKt.sourceInformation(composer, "C122@6149L25,114@5494L243,121@6021L65,112@5384L1132:SaveInputSuggestionDialog.kt#hsonup");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composer.changed(exposedDropdownMenuBoxScope) : composer.changedInstance(exposedDropdownMenuBoxScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-645141783, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaveInputSuggestionDialog.kt:112)");
            }
            String strSaveInputSuggestionDialog$lambda$1 = SaveInputSuggestionDialog$lambda$1(mutableState);
            int i3 = i2;
            TextFieldColors textFieldColors = ExposedDropdownMenuDefaults.INSTANCE.outlinedTextFieldColors-FD9MK7s(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, (TextSelectionColors) null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, ExposedDropdownMenuDefaults.$stable << 27, Reader.READ_DONE, Constants.MAX_HOST_LENGTH);
            Modifier modifier = exposedDropdownMenuBoxScope.menuAnchor-2Hz36ac(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ExposedDropdownMenuAnchorType.Companion.getPrimaryEditable-oYjWRB4(), true);
            KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.Companion.getSentences-IUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 126, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composer, -1505958372, "CC(remember):SaveInputSuggestionDialog.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(list);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$17$lambda$16(list, mutableState, mutableState2, mutableState3, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(strSaveInputSuggestionDialog$lambda$1, (Function1) objRememberedValue, modifier, false, false, (TextStyle) null, ComposableSingletons$SaveInputSuggestionDialogKt.INSTANCE.m1547getLambda$1789668221$app_release(), ComposableSingletons$SaveInputSuggestionDialogKt.INSTANCE.m1546getLambda$1254386718$app_release(), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-183823712, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$18(mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColors, composer, 819462144, 12779520, 0, 4029752);
            if (list2.isEmpty()) {
                composer.startReplaceGroup(554472153);
            } else {
                composer.startReplaceGroup(561022918);
                ComposerKt.sourceInformation(composer, "133@6718L20,134@6765L671,131@6601L835");
                boolean zSaveInputSuggestionDialog$lambda$4 = SaveInputSuggestionDialog$lambda$4(mutableState3);
                ComposerKt.sourceInformationMarkerStart(composer, -1505919427, "CC(remember):SaveInputSuggestionDialog.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$20$lambda$19(mutableState3);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                exposedDropdownMenuBoxScope.ExposedDropdownMenu-vNxi1II(zSaveInputSuggestionDialog$lambda$4, (Function0) objRememberedValue2, (Modifier) null, (ScrollState) null, false, (Shape) null, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(593730498, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$25(list2, mutableState, mutableState2, mutableState3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 48, (ExposedDropdownMenuBoxScope.$stable << 3) | 6 | ((i3 << 3) & 112), 1020);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$17$lambda$16(List list, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        mutableState.setValue(str);
        for (Object obj : list) {
            if (StringsKt.equals(((SuggestionCategory) obj).getName(), str, true)) {
                mutableState2.setValue((SuggestionCategory) obj);
                SaveInputSuggestionDialog$lambda$5(mutableState3, true);
                return Unit.INSTANCE;
            }
        }
        obj = null;
        mutableState2.setValue((SuggestionCategory) obj);
        SaveInputSuggestionDialog$lambda$5(mutableState3, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$18(MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C121@6051L33:SaveInputSuggestionDialog.kt#hsonup");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-183823712, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaveInputSuggestionDialog.kt:121)");
            }
            ExposedDropdownMenuDefaults.INSTANCE.TrailingIcon(SaveInputSuggestionDialog$lambda$4(mutableState), (Modifier) null, composer, ExposedDropdownMenuDefaults.$stable << 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$20$lambda$19(MutableState mutableState) {
        SaveInputSuggestionDialog$lambda$5(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$25(List list, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, ColumnScope columnScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(columnScope, "$this$ExposedDropdownMenu");
        ComposerKt.sourceInformation(composer2, "C*137@6929L30,138@7007L238,136@6868L512:SaveInputSuggestionDialog.kt#hsonup");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(593730498, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaveInputSuggestionDialog.kt:135)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final SuggestionCategory suggestionCategory = (SuggestionCategory) it.next();
                Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(754637779, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj, Object obj2) {
                        return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$25$lambda$24$lambda$21(suggestionCategory, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -2018247439, "CC(remember):SaveInputSuggestionDialog.kt#9igjgp");
                boolean zChanged = composer2.changed(suggestionCategory);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda11
                        public final Object invoke() {
                            return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22(suggestionCategory, mutableState, mutableState2, mutableState3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                AndroidMenu_androidKt.DropdownMenuItem(function2RememberComposableLambda, (Function0) objRememberedValue, (Modifier) null, (Function2) null, (Function2) null, false, (MenuItemColors) null, ExposedDropdownMenuDefaults.INSTANCE.getItemContentPadding(), (MutableInteractionSource) null, composer2, 6, 380);
                composer2 = composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$25$lambda$24$lambda$21(SuggestionCategory suggestionCategory, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C137@6931L26:SaveInputSuggestionDialog.kt#hsonup");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(754637779, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaveInputSuggestionDialog.kt:137)");
            }
            TextKt.Text-Nvy7gAk(suggestionCategory.getName(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22(SuggestionCategory suggestionCategory, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        mutableState.setValue(suggestionCategory.getName());
        mutableState2.setValue(suggestionCategory);
        SaveInputSuggestionDialog$lambda$5(mutableState3, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27(Function3 function3, CorrectionSuggestion correctionSuggestion, MutableState mutableState, MutableState mutableState2) {
        function3.invoke(SaveInputSuggestionDialog$lambda$7(mutableState), SaveInputSuggestionDialog$lambda$1(mutableState2), correctionSuggestion);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveInputSuggestionDialog$lambda$32(Modifier modifier, final CorrectionSuggestion correctionSuggestion, final MutableState mutableState, final List list, final List list2, final MutableState mutableState2, final MutableState mutableState3, final Function0 function0, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C68@3349L6,69@3408L14,71@3468L5689,64@3183L5974:SaveInputSuggestionDialog.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1820075752, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialog.<anonymous> (SaveInputSuggestionDialog.kt:64)");
            }
            SurfaceKt.Surface-T9BRK9s(SizeKt.wrapContentHeight$default(SizeKt.widthIn-VpY3zN4(modifier, Dp.constructor-impl(280), Dp.constructor-impl(560)), (Alignment.Vertical) null, false, 3, (Object) null), MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getExtraLarge(), AlertDialogDefaults.INSTANCE.getContainerColor(composer, AlertDialogDefaults.$stable), 0L, Dp.constructor-impl(6), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(259805277, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return SaveInputSuggestionDialogKt.SaveInputSuggestionDialog$lambda$32$lambda$31(correctionSuggestion, mutableState, list, list2, mutableState2, mutableState3, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12607488, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
