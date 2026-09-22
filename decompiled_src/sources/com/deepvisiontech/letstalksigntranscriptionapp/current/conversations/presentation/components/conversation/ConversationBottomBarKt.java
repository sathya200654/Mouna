package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.TranslateKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuItemColors;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.PopupProperties;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.CorrectionSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActivity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationDrawer;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.InputSource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationBottomBar.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u000b\u001a3\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\t\u001a\u0017\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u000e\u001a3\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\u0010"}, d2 = {"BottomBarConfigRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiState;", "onUiAction", "Lkotlin/Function1;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "BottomBarInfoRow", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiState;Landroidx/compose/runtime/Composer;II)V", "BottomBarInputRow", "BottomBarPrivacyPolicyRow", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ConversationBottomBar", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationBottomBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarConfigRow$lambda$9(Modifier modifier, ConversationUiState conversationUiState, Function1 function1, int i, int i2, Composer composer, int i3) {
        BottomBarConfigRow(modifier, conversationUiState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInfoRow$lambda$19(Modifier modifier, ConversationUiState conversationUiState, int i, int i2, Composer composer, int i3) {
        BottomBarInfoRow(modifier, conversationUiState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$58(Modifier modifier, ConversationUiState conversationUiState, Function1 function1, int i, int i2, Composer composer, int i3) {
        BottomBarInputRow(modifier, conversationUiState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarPrivacyPolicyRow$lambda$65(Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomBarPrivacyPolicyRow(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationBottomBar$lambda$75(Modifier modifier, ConversationUiState conversationUiState, Function1 function1, int i, int i2, Composer composer, int i3) {
        ConversationBottomBar(modifier, conversationUiState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final void BottomBarConfigRow(Modifier modifier, final ConversationUiState conversationUiState, final Function1<? super ConversationUiAction, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        ConversationUiState conversationUiState2;
        Composer composer2;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1718464364);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomBarConfigRow)P(!1,2)83@4294L1985:ConversationBottomBar.kt#hsonup");
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
            conversationUiState2 = conversationUiState;
            i3 |= composerStartRestartGroup.changedInstance(conversationUiState2) ? 32 : 16;
        } else {
            conversationUiState2 = conversationUiState;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1718464364, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarConfigRow (ConversationBottomBar.kt:82)");
            }
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
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
            Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -503506509, "C88@4457L1185,114@5651L622:ConversationBottomBar.kt#hsonup");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier5 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
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
            Composer composer4 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1368270978, "C95@4805L11,96@4888L11,94@4738L196,91@4581L111,89@4475L581,107@5364L11,108@5447L11,106@5297L196,103@5167L84,101@5069L563:ConversationBottomBar.kt#hsonup");
            boolean zIsInputBottomDrawerButtonEnabled = conversationUiState2.isInputBottomDrawerButtonEnabled();
            Modifier modifier6 = modifier4;
            IconButtonColors iconButtonColors = IconButtonDefaults.INSTANCE.iconButtonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, IconButtonDefaults.$stable << 12, 12);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -371501877, "CC(remember):ConversationBottomBar.kt#9igjgp");
            int i5 = i3 & 896;
            boolean z = i5 == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda21
                    public final Object invoke() {
                        return ConversationBottomBarKt.BottomBarConfigRow$lambda$8$lambda$4$lambda$1$lambda$0(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, zIsInputBottomDrawerButtonEnabled, iconButtonColors, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationBottomBarKt.INSTANCE.m1537getLambda$1032503046$app_release(), composerStartRestartGroup, 1572864, 50);
            boolean zIsSummarizeButtonEnabled = conversationUiState.isSummarizeButtonEnabled();
            IconButtonColors iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, IconButtonDefaults.$stable << 12, 12);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -371483152, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean z2 = i5 == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda23
                    public final Object invoke() {
                        return ConversationBottomBarKt.BottomBarConfigRow$lambda$8$lambda$4$lambda$3$lambda$2(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconButtonKt.IconButton((Function0) objRememberedValue2, (Modifier) null, zIsSummarizeButtonEnabled, iconButtonColors2, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationBottomBarKt.INSTANCE.m1538getLambda$1502258575$app_release(), composerStartRestartGroup, 1572864, 50);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier7 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
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
            Composer composer5 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer5, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer5, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer5, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 708287678, "C121@6003L11,122@6086L11,120@5936L196,117@5776L114,115@5669L594:ConversationBottomBar.kt#hsonup");
            boolean zIsConfigBottomDrawerButtonEnabled = conversationUiState.isConfigBottomDrawerButtonEnabled();
            IconButtonColors iconButtonColors3 = IconButtonDefaults.INSTANCE.iconButtonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, IconButtonDefaults.$stable << 12, 12);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -531338395, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean z3 = i5 == 256;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda24
                    public final Object invoke() {
                        return ConversationBottomBarKt.BottomBarConfigRow$lambda$8$lambda$7$lambda$6$lambda$5(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconButtonKt.IconButton((Function0) objRememberedValue3, (Modifier) null, zIsConfigBottomDrawerButtonEnabled, iconButtonColors3, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationBottomBarKt.INSTANCE.m1540getLambda$2019763791$app_release(), composerStartRestartGroup, 1572864, 50);
            composer2 = composerStartRestartGroup;
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
            modifier3 = modifier6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationBottomBarKt.BottomBarConfigRow$lambda$9(modifier3, conversationUiState, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarConfigRow$lambda$8$lambda$4$lambda$1$lambda$0(Function1 function1) {
        function1.invoke(new ConversationUiAction.OnShowDrawer(ConversationDrawer.Input.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarConfigRow$lambda$8$lambda$4$lambda$3$lambda$2(Function1 function1) {
        function1.invoke(ConversationUiAction.OnSummarize.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarConfigRow$lambda$8$lambda$7$lambda$6$lambda$5(Function1 function1) {
        function1.invoke(new ConversationUiAction.OnShowDrawer(ConversationDrawer.Settings.INSTANCE));
        return Unit.INSTANCE;
    }

    private static final void BottomBarInfoRow(Modifier modifier, final ConversationUiState conversationUiState, Composer composer, final int i, final int i2) {
        final Modifier modifier2;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1925393165);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomBarInfoRow)141@6640L71,142@6737L41,143@6796L68,144@6883L96,146@6985L2035:ConversationBottomBar.kt#hsonup");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = i | (composerStartRestartGroup.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(conversationUiState) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            Modifier modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1925393165, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarInfoRow (ConversationBottomBar.kt:135)");
            }
            String displayText = conversationUiState.getUserLang().getDisplayText();
            ConversationMode conversationMode = conversationUiState.getConversationMode();
            String inputText = conversationUiState.getInputText();
            final String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_bottom_cd_language, new Object[]{displayText}, composerStartRestartGroup, 0);
            final String strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_bottom_cd_mode, new Object[]{StringResources_androidKt.stringResource(conversationMode.getDisplayNameRes(), composerStartRestartGroup, 0)}, composerStartRestartGroup, 0);
            final String strStringResource3 = StringResources_androidKt.stringResource(R.string.conversation_bottom_cd_limit, new Object[]{Integer.valueOf(inputText.length()), 1000}, composerStartRestartGroup, 0);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Modifier modifier4 = modifier3;
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
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2109314306, "C153@7280L59,151@7148L735,174@8025L59,172@7893L762,195@8774L10,196@8830L11,197@8893L111,193@8665L349:ConversationBottomBar.kt#hsonup");
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            Modifier modifier5 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 206592146, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strStringResource);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        return ConversationBottomBarKt.BottomBarInfoRow$lambda$18$lambda$11$lambda$10(strStringResource, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier5, true, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
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
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 575871307, "C161@7554L11,157@7364L223,163@7600L39,166@7734L10,168@7840L11,164@7652L221:ConversationBottomBar.kt#hsonup");
            float f = 12;
            IconKt.Icon-ww6aTOc(TranslateKt.getTranslate(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), composerStartRestartGroup, 432, 0);
            float f2 = 4;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), composerStartRestartGroup, 6);
            TextKt.Text-Nvy7gAk(displayText, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, 1572864, 0, 131002);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
            Modifier modifier6 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 206615986, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(strStringResource2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        return ConversationBottomBarKt.BottomBarInfoRow$lambda$18$lambda$14$lambda$13(strStringResource2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics2 = SemanticsModifierKt.semantics(modifier6, true, (Function1) objRememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics2);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
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
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1966642567, "C182@8298L11,178@8109L222,184@8344L39,186@8425L41,187@8506L10,189@8612L11,185@8396L249:ConversationBottomBar.kt#hsonup");
            IconKt.Icon-ww6aTOc(conversationMode.getDisplayIcon(), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), composerStartRestartGroup, 432, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), composerStartRestartGroup, 6);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(conversationMode.getDisplayNameRes(), composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, 1572864, 0, 131002);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String str = inputText.length() + " / 1000";
            TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall();
            long j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU();
            Modifier modifier7 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 206643814, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(strStringResource3);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        return ConversationBottomBarKt.BottomBarInfoRow$lambda$18$lambda$17$lambda$16(strStringResource3, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextKt.Text-Nvy7gAk(str, SemanticsModifierKt.semantics$default(modifier7, false, (Function1) objRememberedValue3, 1, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, bodySmall, composerStartRestartGroup, 0, 0, 131064);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationBottomBarKt.BottomBarInfoRow$lambda$19(modifier2, conversationUiState, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInfoRow$lambda$18$lambda$11$lambda$10(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInfoRow$lambda$18$lambda$14$lambda$13(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInfoRow$lambda$18$lambda$17$lambda$16(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.getPolite-0phEisY());
        return Unit.INSTANCE;
    }

    private static final void BottomBarInputRow(Modifier modifier, final ConversationUiState conversationUiState, final Function1<? super ConversationUiAction, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        String strStringResource;
        String strStringResource2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1988518744);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomBarInputRow)P(!1,2)213@9309L7,214@9343L150,221@9593L12,223@9640L108,223@9611L137,248@11090L7248:ConversationBottomBar.kt#hsonup");
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
            i3 |= composerStartRestartGroup.changedInstance(conversationUiState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1988518744, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarInputRow (ConversationBottomBar.kt:211)");
            }
            final String inputText = conversationUiState.getInputText();
            CompositionLocal localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager = (FocusManager) objConsume;
            LanguageEnum userLang = conversationUiState.getUserLang();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 293944094, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(userLang.ordinal());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = KeyboardOptions.copy-INvB4aQ$default(KeyboardOptions.Companion.getDefault(), 0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, new LocaleList(conversationUiState.getUserLang().getLanguageCode()), 63, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            KeyboardOptions keyboardOptions = (KeyboardOptions) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final List<CorrectionSuggestion> correctionSuggestions = conversationUiState.getCorrectionSuggestions();
            boolean zIsImeVisible = WindowInsets_androidKt.isImeVisible(WindowInsets.Companion, composerStartRestartGroup, 6);
            Boolean boolValueOf = Boolean.valueOf(zIsImeVisible);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 293953556, "CC(remember):ConversationBottomBar.kt#9igjgp");
            int i5 = i3 & 896;
            boolean zChanged2 = composerStartRestartGroup.changed(zIsImeVisible) | (i5 == 256);
            ConversationBottomBarKt$BottomBarInputRow$1$1 conversationBottomBarKt$BottomBarInputRow$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || conversationBottomBarKt$BottomBarInputRow$1$1RememberedValue == Composer.Companion.getEmpty()) {
                conversationBottomBarKt$BottomBarInputRow$1$1RememberedValue = new ConversationBottomBarKt$BottomBarInputRow$1$1(zIsImeVisible, function1, null);
                composerStartRestartGroup.updateRememberedValue(conversationBottomBarKt$BottomBarInputRow$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) conversationBottomBarKt$BottomBarInputRow$1$1RememberedValue, composerStartRestartGroup, 0);
            ConversationActivity activity = conversationUiState.getActivity();
            if (Intrinsics.areEqual(activity, ConversationActivity.IsInitializing.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(293960480);
                ComposerKt.sourceInformation(composerStartRestartGroup, "230@9858L56");
                strStringResource = StringResources_androidKt.stringResource(R.string.conversation_state_initializing, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(activity, ConversationActivity.IsTranscribing.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(293963805);
                ComposerKt.sourceInformation(composerStartRestartGroup, "231@9962L53");
                strStringResource = StringResources_androidKt.stringResource(R.string.conversation_state_listening, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (activity instanceof ConversationActivity.IsInterpreting) {
                composerStartRestartGroup.startReplaceGroup(293967136);
                ComposerKt.sourceInformation(composerStartRestartGroup, "232@10066L56");
                strStringResource = StringResources_androidKt.stringResource(R.string.conversation_state_interpreting, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(activity, ConversationActivity.IsProcessingInputText.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(293970686);
                ComposerKt.sourceInformation(composerStartRestartGroup, "233@10177L54");
                strStringResource = StringResources_androidKt.stringResource(R.string.conversation_state_processing, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(activity, ConversationActivity.IsSummarizing.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(293973919);
                ComposerKt.sourceInformation(composerStartRestartGroup, "234@10278L55");
                strStringResource = StringResources_androidKt.stringResource(R.string.conversation_state_summarizing, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(293976217);
                ComposerKt.sourceInformation(composerStartRestartGroup, "235@10350L49");
                strStringResource = StringResources_androidKt.stringResource(R.string.conversation_state_ready, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            ConversationActivity activity2 = conversationUiState.getActivity();
            if (Intrinsics.areEqual(activity2, ConversationActivity.IsInitializing.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(293981219);
                ComposerKt.sourceInformation(composerStartRestartGroup, "239@10506L59");
                strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_input_hint_connecting, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(activity2, ConversationActivity.IsTranscribing.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(293984642);
                ComposerKt.sourceInformation(composerStartRestartGroup, "240@10613L58");
                strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_input_hint_listening, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (activity2 instanceof ConversationActivity.IsInterpreting) {
                composerStartRestartGroup.startReplaceGroup(293988133);
                ComposerKt.sourceInformation(composerStartRestartGroup, "241@10722L61");
                strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_input_hint_interpreting, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(activity2, ConversationActivity.IsProcessingInputText.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(293991843);
                ComposerKt.sourceInformation(composerStartRestartGroup, "242@10838L59");
                strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_input_hint_processing, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(activity2, ConversationActivity.IsSummarizing.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(293995236);
                ComposerKt.sourceInformation(composerStartRestartGroup, "243@10944L60");
                strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_input_hint_summarizing, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(293997696);
                ComposerKt.sourceInformation(composerStartRestartGroup, "244@11021L56");
                strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_input_hint_default, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
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
            Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -993963224, "C253@11273L77,258@11485L1921,251@11139L2267,310@13676L10,311@13733L6,312@13791L260,400@18239L83,306@13493L117,318@14079L446,368@16728L1331,326@14554L2146,304@13417L4915:ConversationBottomBar.kt#hsonup");
            boolean z = conversationUiState.getActiveDrawer() instanceof ConversationDrawer.CorrectionSuggestions;
            PopupProperties popupProperties = new PopupProperties(false, false, false, false, 14, (DefaultConstructorMarker) null);
            Modifier modifierAlign = boxScope.align(Modifier.Companion, Alignment.Companion.getBottomCenter());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 937765167, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean z2 = i5 == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda22
                    public final Object invoke() {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$23$lambda$22(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final String str = strStringResource;
            final String str2 = strStringResource2;
            AndroidMenu_androidKt.DropdownMenu-IlH_yew(z, (Function0) objRememberedValue2, modifierAlign, 0L, (ScrollState) null, popupProperties, (Shape) null, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-7360995, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda29
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$34(function1, inputText, correctionSuggestions, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196608, 48, 2008);
            TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
            Shape extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getExtraLarge();
            TextFieldColors textFieldColors = TextFieldDefaults.INSTANCE.colors-0hiis_0(0L, 0L, 0L, 0L, Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), 0L, 0L, 0L, 0L, (TextSelectionColors) null, Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 221184, 432, 0, 0, 3072, 2147477455, 4095);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(160), 1, (Object) null), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 937988085, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(str);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda30
                    public final Object invoke(Object obj) {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$36$lambda$35(str, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierFillMaxWidth$default, false, (Function1) objRememberedValue3, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 937836247, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean z3 = i5 == 256;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda31
                    public final Object invoke(Object obj) {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$38$lambda$37(function1, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextFieldKt.TextField(inputText, (Function1) objRememberedValue4, modifierSemantics$default, false, false, bodyMedium, (Function2) null, ComposableLambdaKt.rememberComposableLambda(1044354183, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda32
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$39(conversationUiState, str2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-412058872, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda33
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$47(conversationUiState, function1, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1868471927, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda34
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$56(conversationUiState, focusManager, function1, inputText, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 6, 0, (MutableInteractionSource) null, extraLarge, textFieldColors, composerStartRestartGroup, 918552576, 100663296, 0, 1801304);
            composer2 = composerStartRestartGroup;
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda35
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationBottomBarKt.BottomBarInputRow$lambda$58(modifier3, conversationUiState, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$23$lambda$22(Function1 function1) {
        function1.invoke(ConversationUiAction.OnHideDrawer.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$34(final Function1 function1, final String str, List list, ColumnScope columnScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(columnScope, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer2, "C260@11540L303,268@11871L124,259@11499L595,*276@12215L206,282@12453L136,285@12626L649,275@12170L1212:ConversationBottomBar.kt#hsonup");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-7360995, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarInputRow.<anonymous>.<anonymous> (ConversationBottomBar.kt:259)");
            }
            Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-29367827, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$34$lambda$24(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, 1516030873, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged = composer2.changed(function1) | composer2.changed(str);
            Object objRememberedValue = composer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$34$lambda$26$lambda$25(function1, str);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            float f = 16;
            float f2 = 0;
            AndroidMenu_androidKt.DropdownMenuItem(function2RememberComposableLambda, (Function0) objRememberedValue, (Modifier) null, (Function2) null, (Function2) null, false, (MenuItemColors) null, PaddingKt.PaddingValues-YgX7TsA(Dp.constructor-impl(f), Dp.constructor-impl(f2)), (MutableInteractionSource) null, composer2, 12582918, 380);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final CorrectionSuggestion correctionSuggestion = (CorrectionSuggestion) it.next();
                Function2 function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-28980402, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2) {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$34$lambda$33$lambda$27(correctionSuggestion, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1776827002, "CC(remember):ConversationBottomBar.kt#9igjgp");
                boolean zChanged2 = composer2.changed(function1) | composer2.changed(correctionSuggestion);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$34$lambda$33$lambda$29$lambda$28(function1, correctionSuggestion);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                AndroidMenu_androidKt.DropdownMenuItem(function2RememberComposableLambda2, (Function0) objRememberedValue2, (Modifier) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(1200693450, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2) {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$34$lambda$33$lambda$32(function1, correctionSuggestion, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), false, (MenuItemColors) null, PaddingKt.PaddingValues-YgX7TsA(Dp.constructor-impl(f), Dp.constructor-impl(f2)), (MutableInteractionSource) null, composer2, 12607494, 364);
                composer2 = composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$34$lambda$24(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C263@11662L10,264@11730L11,261@11562L263:ConversationBottomBar.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-29367827, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarInputRow.<anonymous>.<anonymous>.<anonymous> (ConversationBottomBar.kt:261)");
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 1572864, 0, 131002);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$34$lambda$26$lambda$25(Function1 function1, String str) {
        function1.invoke(new ConversationUiAction.OnCorrectionSuggestionChosenForTts(str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$34$lambda$33$lambda$27(CorrectionSuggestion correctionSuggestion, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C279@12353L10,277@12241L158:ConversationBottomBar.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-28980402, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarInputRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ConversationBottomBar.kt:277)");
            }
            TextKt.Text-Nvy7gAk(correctionSuggestion.getSentence(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$34$lambda$33$lambda$29$lambda$28(Function1 function1, CorrectionSuggestion correctionSuggestion) {
        function1.invoke(new ConversationUiAction.OnCorrectionSuggestionChosenForTts(correctionSuggestion.getSentence()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$34$lambda$33$lambda$32(final Function1 function1, final CorrectionSuggestion correctionSuggestion, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C287@12702L148,286@12652L601:ConversationBottomBar.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1200693450, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarInputRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ConversationBottomBar.kt:286)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1479794594, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(correctionSuggestion);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda28
                    public final Object invoke() {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$34$lambda$33$lambda$32$lambda$31$lambda$30(function1, correctionSuggestion);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationBottomBarKt.INSTANCE.getLambda$1161675116$app_release(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$34$lambda$33$lambda$32$lambda$31$lambda$30(Function1 function1, CorrectionSuggestion correctionSuggestion) {
        function1.invoke(new ConversationUiAction.OnShowCorrectionSuggestionSaveDialogBox(correctionSuggestion));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$38$lambda$37(Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(str, "updatedText");
        function1.invoke(new ConversationUiAction.OnInputTextChange(str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$39(ConversationUiState conversationUiState, String str, Composer composer, int i) {
        long j;
        ComposerKt.sourceInformation(composer, "C321@14189L10,319@14097L414:ConversationBottomBar.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1044354183, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarInputRow.<anonymous>.<anonymous> (ConversationBottomBar.kt:319)");
            }
            TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium();
            int i2 = !Intrinsics.areEqual(conversationUiState.getActivity(), ConversationActivity.Idle.INSTANCE) ? FontStyle.Companion.getItalic-_-LCdwA() : FontStyle.Companion.getNormal-_-LCdwA();
            if (Intrinsics.areEqual(conversationUiState.getActivity(), ConversationActivity.Idle.INSTANCE)) {
                composer.startReplaceGroup(-1397964649);
                ComposerKt.sourceInformation(composer, "323@14465L11");
                j = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            } else {
                composer.startReplaceGroup(-1397965906);
                ComposerKt.sourceInformation(composer, "323@14426L11");
                j = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
            }
            composer.endReplaceGroup();
            TextKt.Text-Nvy7gAk(str, (Modifier) null, j, (TextAutoSize) null, 0L, FontStyle.box-impl(i2), (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, bodyMedium, composer, 0, 0, 131034);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$56(ConversationUiState conversationUiState, final FocusManager focusManager, final Function1 function1, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C327@14572L2114:ConversationBottomBar.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1868471927, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarInputRow.<anonymous>.<anonymous> (ConversationBottomBar.kt:327)");
            }
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
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
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 2059220854, "C330@14737L313,330@14684L366,344@15488L11,345@15579L11,343@15413L220,339@15180L179,337@15071L839,360@16366L11,361@16457L11,359@16291L220,355@16045L192,353@15931L737:ConversationBottomBar.kt#hsonup");
            AnimatedVisibilityKt.AnimatedVisibility(rowScope, conversationUiState.isClearTextButtonVisible(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-804940859, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$56$lambda$55$lambda$50(function1, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 30);
            boolean zIsSendButtonEnabled = conversationUiState.isSendButtonEnabled();
            IconButtonColors iconButtonColors = IconButtonDefaults.INSTANCE.iconButtonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composer, IconButtonDefaults.$stable << 12, 12);
            ComposerKt.sourceInformationMarkerStart(composer, 2144650528, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(focusManager) | composer.changed(function1) | composer.changed(str);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda16
                    public final Object invoke() {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$56$lambda$55$lambda$52$lambda$51(focusManager, function1, str);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, zIsSendButtonEnabled, iconButtonColors, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationBottomBarKt.INSTANCE.getLambda$710228491$app_release(), composer, 1572864, 50);
            boolean zIsInputSuggestionEnabled = conversationUiState.isInputSuggestionEnabled();
            IconButtonColors iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composer, IconButtonDefaults.$stable << 12, 12);
            ComposerKt.sourceInformationMarkerStart(composer, 2144678221, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(focusManager) | composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda17
                    public final Object invoke() {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$56$lambda$55$lambda$54$lambda$53(focusManager, function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue2, (Modifier) null, zIsInputSuggestionEnabled, iconButtonColors2, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationBottomBarKt.INSTANCE.getLambda$59805378$app_release(), composer, 1572864, 50);
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
    public static final Unit BottomBarInputRow$lambda$57$lambda$56$lambda$55$lambda$50(final Function1 function1, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C332@14813L53,331@14763L265:ConversationBottomBar.kt#hsonup");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-804940859, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarInputRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ConversationBottomBar.kt:331)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -454049734, "CC(remember):ConversationBottomBar.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$56$lambda$55$lambda$50$lambda$49$lambda$48(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationBottomBarKt.INSTANCE.m1539getLambda$1728342557$app_release(), composer, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$56$lambda$55$lambda$50$lambda$49$lambda$48(Function1 function1) {
        function1.invoke(ConversationUiAction.OnClearInputText.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$56$lambda$55$lambda$52$lambda$51(FocusManager focusManager, Function1 function1, String str) {
        FocusManager.clearFocus$default(focusManager, false, 1, (Object) null);
        function1.invoke(new ConversationUiAction.OnSendButtonClicked(str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$56$lambda$55$lambda$54$lambda$53(FocusManager focusManager, Function1 function1) {
        FocusManager.clearFocus$default(focusManager, false, 1, (Object) null);
        function1.invoke(new ConversationUiAction.OnShowDrawer(ConversationDrawer.InputSuggestions.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$47(final ConversationUiState conversationUiState, final Function1 function1, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C369@16746L1299:ConversationBottomBar.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-412058872, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarInputRow.<anonymous>.<anonymous> (ConversationBottomBar.kt:369)");
            }
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
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
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1994074394, "C375@17062L497,385@17600L125,390@17898L107,372@16858L1169:ConversationBottomBar.kt#hsonup");
            ConversationActivity activity = conversationUiState.getActivity();
            boolean zIsInterpretButtonEnabled = conversationUiState.isInterpretButtonEnabled();
            ComposerKt.sourceInformationMarkerStart(composer, 1598248861, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(conversationUiState) | composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda18
                    public final Object invoke() {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$47$lambda$46$lambda$41$lambda$40(conversationUiState, function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1598265705, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda19
                    public final Object invoke() {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$47$lambda$46$lambda$43$lambda$42(function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function2 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            float f = 4;
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(f), 0.0f, Dp.constructor-impl(f), 0.0f, 10, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1598275223, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged2 = composer.changed(str);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda20
                    public final Object invoke(Object obj) {
                        return ConversationBottomBarKt.BottomBarInputRow$lambda$57$lambda$47$lambda$46$lambda$45$lambda$44(str, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ConversationStatusActionButtonKt.ConversationStatusActionButton(activity, zIsInterpretButtonEnabled, function0, function2, SemanticsModifierKt.semantics(modifier2, true, (Function1) objRememberedValue3), composer, 0, 0);
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
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit BottomBarInputRow$lambda$57$lambda$47$lambda$46$lambda$41$lambda$40(ConversationUiState conversationUiState, Function1 function1) throws NoWhenBranchMatchedException {
        InputSource inputSource = conversationUiState.getInputSource();
        if (Intrinsics.areEqual(inputSource, InputSource.Text.INSTANCE)) {
            function1.invoke(ConversationUiAction.OnInterpretInputText.INSTANCE);
        } else {
            if (!Intrinsics.areEqual(inputSource, InputSource.Voice.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            function1.invoke(ConversationUiAction.OnRequestMicrophonePermissionForInterpretation.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$47$lambda$46$lambda$43$lambda$42(Function1 function1) {
        function1.invoke(ConversationUiAction.OnStopInterpretationAndTranscription.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$47$lambda$46$lambda$45$lambda$44(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarInputRow$lambda$57$lambda$36$lambda$35(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    private static final void BottomBarPrivacyPolicyRow(Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-486743651);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomBarPrivacyPolicyRow)411@18462L7,436@19348L60,437@19436L70,441@19544L50,445@19664L10,446@19717L11,419@18686L1058:ConversationBottomBar.kt#hsonup");
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
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-486743651, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.BottomBarPrivacyPolicyRow (ConversationBottomBar.kt:410)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            composerStartRestartGroup.startReplaceGroup(390798823);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*421@18749L66,424@18923L11");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            builder.append(StringResources_androidKt.stringResource(R.string.conversation_bottom_msg_disclaimer_prefix, composerStartRestartGroup, 0) + " ");
            composerStartRestartGroup.startReplaceGroup(390802781);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*429@19113L59");
            int iPushStyle = builder.pushStyle(new SpanStyle(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontWeight) null, FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Companion.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61430, (DefaultConstructorMarker) null));
            try {
                builder.append(StringResources_androidKt.stringResource(R.string.conversation_bottom_action_privacy, composerStartRestartGroup, 0));
                Unit unit = Unit.INSTANCE;
                builder.pop(iPushStyle);
                composerStartRestartGroup.endReplaceGroup();
                AnnotatedString annotatedString = builder.toAnnotatedString();
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(modifier4, 0.0f, Dp.constructor-impl(4), 1, (Object) null), 0.0f, 1, (Object) null);
                String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_bottom_cd_privacy_link, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 390821731, "CC(remember):ConversationBottomBar.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(context);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            return ConversationBottomBarKt.BottomBarPrivacyPolicyRow$lambda$62$lambda$61(context);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier5 = ClickableKt.clickable-oSLSa3U$default(modifierFillMaxWidth$default, false, strStringResource, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue, 13, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 390825167, "CC(remember):ConversationBottomBar.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj) {
                            return ConversationBottomBarKt.BottomBarPrivacyPolicyRow$lambda$64$lambda$63((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                modifier3 = modifier4;
                TextKt.Text-Z58ophY(annotatedString, SemanticsModifierKt.semantics$default(modifier5, false, (Function1) objRememberedValue2, 1, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSecondary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Map) null, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall(), composer2, 0, 0, 261112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } catch (Throwable th) {
                builder.pop(iPushStyle);
                throw th;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationBottomBarKt.BottomBarPrivacyPolicyRow$lambda$65(modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BottomBarPrivacyPolicyRow$openPrivacyPolicyLink(Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://letstalksign.org/lts/app-privacy.php")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarPrivacyPolicyRow$lambda$62$lambda$61(Context context) {
        BottomBarPrivacyPolicyRow$openPrivacyPolicyLink(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBarPrivacyPolicyRow$lambda$64$lambda$63(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    public static final void ConversationBottomBar(Modifier modifier, final ConversationUiState conversationUiState, final Function1<? super ConversationUiAction, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(conversationUiState, "uiState");
        Intrinsics.checkNotNullParameter(function1, "onUiAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(1512358235);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConversationBottomBar)P(!1,2)458@19994L38,459@20039L1305,456@19911L1433:ConversationBottomBar.kt#hsonup");
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
            i3 |= composerStartRestartGroup.changedInstance(conversationUiState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1512358235, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBar (ConversationBottomBar.kt:455)");
            }
            CardKt.Card(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), (Shape) null, (CardColors) null, CardDefaults.INSTANCE.cardElevation-aqJV_2Y(Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(18262569, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationBottomBarKt.ConversationBottomBar$lambda$74(conversationUiState, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196608, 22);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationBottomBarKt.ConversationBottomBar$lambda$75(modifier3, conversationUiState, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationBottomBar$lambda$74(ConversationUiState conversationUiState, final Function1 function1, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$Card");
        ComposerKt.sourceInformation(composer, "C460@20049L1289:ConversationBottomBar.kt#hsonup");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(18262569, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBar.<anonymous> (ConversationBottomBar.kt:460)");
            }
            float f = 4;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(WindowInsetsPadding_androidKt.navigationBarsPadding(Modifier.Companion), Dp.constructor-impl(f)), 0.0f, 1, (Object) null);
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 441611268, "C468@20324L117,473@20454L324,484@20791L325,495@21129L199:ConversationBottomBar.kt#hsonup");
            BottomBarInfoRow(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), conversationUiState, composer, 6, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifier);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1347271732, "C479@20666L80,474@20476L288:ConversationBottomBar.kt#hsonup");
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(f), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 736202911, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda26
                    public final Object invoke(Object obj) {
                        return ConversationBottomBarKt.ConversationBottomBar$lambda$74$lambda$73$lambda$68$lambda$67$lambda$66(function1, (ConversationUiAction) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BottomBarInputRow(modifierFillMaxWidth$default2, conversationUiState, (Function1) objRememberedValue, composer, 6, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier2 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifier2);
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
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -339775926, "C490@21004L80,485@20813L289:ConversationBottomBar.kt#hsonup");
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(f), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -1257880600, "CC(remember):ConversationBottomBar.kt#9igjgp");
            boolean zChanged2 = composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt$$ExternalSyntheticLambda27
                    public final Object invoke(Object obj) {
                        return ConversationBottomBarKt.ConversationBottomBar$lambda$74$lambda$73$lambda$71$lambda$70$lambda$69(function1, (ConversationUiAction) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BottomBarConfigRow(modifierFillMaxWidth$default3, conversationUiState, (Function1) objRememberedValue2, composer, 6, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier3 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifier3);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composer5 = Updater.constructor-impl(composer);
            Updater.set-impl(composer5, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer5, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -643637367, "C496@21151L163:ConversationBottomBar.kt#hsonup");
            BottomBarPrivacyPolicyRow(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(f), 1, (Object) null), 0.0f, 1, (Object) null), composer, 6, 0);
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
    public static final Unit ConversationBottomBar$lambda$74$lambda$73$lambda$68$lambda$67$lambda$66(Function1 function1, ConversationUiAction conversationUiAction) {
        Intrinsics.checkNotNullParameter(conversationUiAction, "uiAction");
        function1.invoke(conversationUiAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationBottomBar$lambda$74$lambda$73$lambda$71$lambda$70$lambda$69(Function1 function1, ConversationUiAction conversationUiAction) {
        Intrinsics.checkNotNullParameter(conversationUiAction, "uiAction");
        function1.invoke(conversationUiAction);
        return Unit.INSTANCE;
    }
}
