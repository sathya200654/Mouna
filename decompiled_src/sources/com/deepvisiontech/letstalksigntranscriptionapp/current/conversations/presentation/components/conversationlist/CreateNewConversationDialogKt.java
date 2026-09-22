package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist;

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
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CreateNewConversationDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u0005X\u008a\u008e\u0002"}, d2 = {"ConversationNameInputDialog", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "confirmButtonText", "initialName", "onDismissRequest", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release", "name"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CreateNewConversationDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationNameInputDialog$lambda$12(Modifier modifier, String str, String str2, String str3, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        ConversationNameInputDialog(modifier, str, str2, str3, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ConversationNameInputDialog(Modifier modifier, final String str, final String str2, final String str3, final Function0<Unit> function0, final Function1<? super String, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "confirmButtonText");
        Intrinsics.checkNotNullParameter(str3, "initialName");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function1, "onConfirm");
        Composer composerStartRestartGroup = composer.startRestartGroup(226713081);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConversationNameInputDialog)P(2,5!2,4)47@2039L53,49@2142L2031,49@2098L2075:CreateNewConversationDialog.kt#q5ez8f");
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
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(str3) ? 2048 : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(226713081, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.ConversationNameInputDialog (CreateNewConversationDialog.kt:46)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1172052210, "CC(remember):CreateNewConversationDialog.kt#9igjgp");
            boolean z = (i3 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(str3, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Modifier modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(32281232, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.CreateNewConversationDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return CreateNewConversationDialogKt.ConversationNameInputDialog$lambda$11(modifier3, str, mutableState, function0, function1, str3, str2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i3 >> 12) & 14) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier4 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.CreateNewConversationDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateNewConversationDialogKt.ConversationNameInputDialog$lambda$12(modifier4, str, str2, str3, function0, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String ConversationNameInputDialog$lambda$1(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationNameInputDialog$lambda$11$lambda$10(String str, final MutableState mutableState, Function0 function0, final Function1 function1, String str2, final String str3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C61@2567L21,58@2451L1706:CreateNewConversationDialog.kt#q5ez8f");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1725163221, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.ConversationNameInputDialog.<anonymous>.<anonymous> (CreateNewConversationDialog.kt:58)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -339340255, "C66@2772L10,67@2840L11,64@2690L189,70@2897L41,76@3210L8,74@3045L13,72@2956L481,82@3455L41,84@3514L629:CreateNewConversationDialog.kt#q5ez8f");
            TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            String strConversationNameInputDialog$lambda$1 = ConversationNameInputDialog$lambda$1(mutableState);
            TextFieldColors textFieldColorsColors = OutlinedTextFieldDefaults.INSTANCE.colors(composer, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.Companion.getSentences-IUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 126, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composer, 2067273442, "CC(remember):CreateNewConversationDialog.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.CreateNewConversationDialogKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        return CreateNewConversationDialogKt.ConversationNameInputDialog$lambda$11$lambda$10$lambda$9$lambda$4$lambda$3(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(strConversationNameInputDialog$lambda$1, (Function1) objRememberedValue, modifierFillMaxWidth$default, false, false, (TextStyle) null, ComposableSingletons$CreateNewConversationDialogKt.INSTANCE.m1609getLambda$1011275621$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsColors, composer, 1573248, 12779520, 0, 4030392);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, Alignment.Companion.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1234930544, "C88@3675L138,91@3834L39,93@3936L19,95@4054L71,92@3894L231:CreateNewConversationDialog.kt#q5ez8f");
            ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$CreateNewConversationDialogKt.INSTANCE.getLambda$764929076$app_release(), composer, 805306368, 510);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 237266116, "CC(remember):CreateNewConversationDialog.kt#9igjgp");
            boolean zChanged2 = composer.changed(function1) | composer.changed(mutableState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.CreateNewConversationDialogKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        return CreateNewConversationDialogKt.ConversationNameInputDialog$lambda$11$lambda$10$lambda$9$lambda$8$lambda$6$lambda$5(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function2 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.Button(function2, (Modifier) null, (StringsKt.isBlank(ConversationNameInputDialog$lambda$1(mutableState)) || Intrinsics.areEqual(ConversationNameInputDialog$lambda$1(mutableState), str2)) ? false : true, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(494111649, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.CreateNewConversationDialogKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CreateNewConversationDialogKt.ConversationNameInputDialog$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(str3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 506);
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
    public static final Unit ConversationNameInputDialog$lambda$11$lambda$10$lambda$9$lambda$4$lambda$3(MutableState mutableState, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationNameInputDialog$lambda$11$lambda$10$lambda$9$lambda$8$lambda$6$lambda$5(Function1 function1, MutableState mutableState) {
        function1.invoke(ConversationNameInputDialog$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationNameInputDialog$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(String str, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$Button");
        ComposerKt.sourceInformation(composer, "C96@4080L23:CreateNewConversationDialog.kt#q5ez8f");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(494111649, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.ConversationNameInputDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateNewConversationDialog.kt:96)");
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationNameInputDialog$lambda$11(Modifier modifier, final String str, final MutableState mutableState, final Function0 function0, final Function1 function1, final String str2, final String str3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C54@2318L6,55@2377L14,57@2437L1730,50@2152L2015:CreateNewConversationDialog.kt#q5ez8f");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(32281232, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.ConversationNameInputDialog.<anonymous> (CreateNewConversationDialog.kt:50)");
            }
            SurfaceKt.Surface-T9BRK9s(SizeKt.wrapContentHeight$default(SizeKt.widthIn-VpY3zN4(modifier, Dp.constructor-impl(280), Dp.constructor-impl(560)), (Alignment.Vertical) null, false, 3, (Object) null), MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getExtraLarge(), AlertDialogDefaults.INSTANCE.getContainerColor(composer, AlertDialogDefaults.$stable), 0L, Dp.constructor-impl(6), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1725163221, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.CreateNewConversationDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return CreateNewConversationDialogKt.ConversationNameInputDialog$lambda$11$lambda$10(str, mutableState, function0, function1, str2, str3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12607488, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
