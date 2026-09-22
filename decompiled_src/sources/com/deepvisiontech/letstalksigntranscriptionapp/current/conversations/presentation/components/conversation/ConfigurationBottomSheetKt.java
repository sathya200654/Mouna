package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.LightbulbKt;
import androidx.compose.material.icons.filled.MeetingRoomKt;
import androidx.compose.material.icons.filled.PersonKt;
import androidx.compose.material.icons.filled.RecordVoiceOverKt;
import androidx.compose.material.icons.filled.SwapVertKt;
import androidx.compose.material.icons.filled.TranscribeKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.ExposedDropdownMenuAnchorType;
import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.material3.ExposedDropdownMenuDefaults;
import androidx.compose.material3.ExposedDropdownMenuKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuItemColors;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.RadioButtonColors;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.Constants;
import com.google.protobuf.Reader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConfigurationBottomSheet.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\u000e\u001a9\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\u0016\u001a;\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0007¢\u0006\u0002\u0010\u001d¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020\u0005X\u008a\u008e\u0002"}, d2 = {"ConfigBottomSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "isSuggestionsEnabled", "", "activeConversationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "userLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "speakerLanguage", "onAction", "Lkotlin/Function1;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "(Landroidx/compose/ui/Modifier;ZLcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LanguageSelector", Constants.ScionAnalytics.PARAM_LABEL, "", "selectedLanguage", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "onLanguageSelected", "(Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Landroidx/compose/ui/graphics/vector/ImageVector;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ModeSelectionItem", "title", "description", "selected", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "expanded"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConfigurationBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfigBottomSheet$lambda$19(Modifier modifier, boolean z, ConversationMode conversationMode, LanguageEnum languageEnum, LanguageEnum languageEnum2, Function1 function1, int i, int i2, Composer composer, int i3) {
        ConfigBottomSheet(modifier, z, conversationMode, languageEnum, languageEnum2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$38(String str, LanguageEnum languageEnum, ImageVector imageVector, Function1 function1, int i, Composer composer, int i2) {
        LanguageSelector(str, languageEnum, imageVector, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModeSelectionItem$lambda$41(String str, String str2, ImageVector imageVector, boolean z, Function0 function0, int i, Composer composer, int i2) {
        ModeSelectionItem(str, str2, imageVector, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ConfigBottomSheet(Modifier modifier, final boolean z, final ConversationMode conversationMode, final LanguageEnum languageEnum, final LanguageEnum languageEnum2, final Function1<? super ConversationUiAction, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(conversationMode, "activeConversationMode");
        Intrinsics.checkNotNullParameter(languageEnum, "userLanguage");
        Intrinsics.checkNotNullParameter(languageEnum2, "speakerLanguage");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(289103371);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConfigBottomSheet)P(2,1!1,5,4)63@3040L67,66@3114L4820,61@2966L4968:ConfigurationBottomSheet.kt#hsonup");
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
            z2 = z;
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        } else {
            z2 = z;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(conversationMode.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(languageEnum.ordinal()) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(languageEnum2.ordinal()) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(289103371, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigBottomSheet (ConfigurationBottomSheet.kt:60)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1344522322, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            boolean z3 = (458752 & i3) == 131072;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return ConfigurationBottomSheetKt.ConfigBottomSheet$lambda$1$lambda$0(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean z4 = z2;
            int i5 = (i3 << 3) & 112;
            composer2 = composerStartRestartGroup;
            Modifier modifier4 = modifier2;
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) objRememberedValue, modifier4, (SheetState) null, 0.0f, false, (Shape) null, 0L, 0L, 0.0f, 0L, (Function2) null, (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(-1099343379, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConfigurationBottomSheetKt.ConfigBottomSheet$lambda$18(function1, languageEnum, languageEnum2, conversationMode, z4, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, i5, 3072, 8188);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    return ConfigurationBottomSheetKt.ConfigBottomSheet$lambda$19(modifier3, z, conversationMode, languageEnum, languageEnum2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfigBottomSheet$lambda$1$lambda$0(Function1 function1) {
        function1.invoke(ConversationUiAction.OnHideDrawer.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfigBottomSheet$lambda$18(final Function1 function1, LanguageEnum languageEnum, LanguageEnum languageEnum2, ConversationMode conversationMode, boolean z, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C71@3269L21,67@3124L4804:ConfigurationBottomSheet.kt#hsonup");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1099343379, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigBottomSheet.<anonymous> (ConfigurationBottomSheet.kt:67)");
            }
            float f = 24;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(f), 7, (Object) null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
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
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1955010054, "C78@3552L58,74@3380L1347,107@4741L63,110@4847L59,111@4946L10,112@5008L11,109@4818L362,119@5236L64,122@5433L118,118@5194L371,127@5579L453,142@6088L67,145@6300L127,141@6046L395,150@6455L63,153@6561L56,154@6657L10,155@6719L11,152@6532L359,162@6948L68,163@7048L67,166@7274L124,161@6905L507,172@7469L63,173@7564L62,176@7783L121,171@7426L492:ConfigurationBottomSheet.kt#hsonup");
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 755802525, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        return ConfigurationBottomSheetKt.ConfigBottomSheet$lambda$18$lambda$17$lambda$3$lambda$2(function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(modifierFillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue, 15, (Object) null);
            float f2 = 16;
            Modifier modifier2 = PaddingKt.padding-VpY3zN4(modifier, Dp.constructor-impl(f2), Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifier2);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1562397807, "C81@3710L181,87@3909L40,89@3967L554,103@4637L58,101@4539L174:ConfigurationBottomSheet.kt#hsonup");
            IconKt.Icon-ww6aTOc(LightbulbKt.getLightbulb(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), 0L, composer, 432, 8);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), composer, 6);
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
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
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -365242389, "C91@4065L62,92@4175L10,90@4028L189,95@4275L61,96@4384L10,97@4453L11,94@4238L265:ConfigurationBottomSheet.kt#hsonup");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_config_suggestions_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 0, 131070);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_config_suggestions_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -743107871, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            boolean zChanged2 = composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        return ConfigurationBottomSheetKt.ConfigBottomSheet$lambda$18$lambda$17$lambda$7$lambda$6$lambda$5(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(z, (Function1) objRememberedValue2, (Modifier) null, (Function2) null, false, (SwitchColors) null, (MutableInteractionSource) null, composer, 0, 124);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            float f3 = 8;
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(f3), 1, (Object) null), 0.0f, 0L, composer, 6, 6);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_config_language_title, composer, 0), PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f2), Dp.constructor-impl(f3)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 48, 0, 131064);
            String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_config_user_language_label, composer, 0);
            ImageVector person = PersonKt.getPerson(Icons.INSTANCE.getDefault());
            ComposerKt.sourceInformationMarkerStart(composer, 755862777, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            boolean zChanged3 = composer.changed(function1);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return ConfigurationBottomSheetKt.ConfigBottomSheet$lambda$18$lambda$17$lambda$9$lambda$8(function1, (LanguageEnum) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LanguageSelector(strStringResource, languageEnum, person, (Function1) objRememberedValue3, composer, 0);
            Modifier modifier3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(32));
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            Updater.set-impl(composer5, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer5, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -914277880, "C136@5928L11,133@5776L242:ConfigurationBottomSheet.kt#hsonup");
            IconKt.Icon-ww6aTOc(SwapVertKt.getSwapVert(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOutline-0d7_KjU(), composer, 432, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_config_speaker_language_label, composer, 0);
            ImageVector recordVoiceOver = RecordVoiceOverKt.getRecordVoiceOver(Icons.INSTANCE.getDefault());
            ComposerKt.sourceInformationMarkerStart(composer, 755890530, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            boolean zChanged4 = composer.changed(function1);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        return ConfigurationBottomSheetKt.ConfigBottomSheet$lambda$18$lambda$17$lambda$12$lambda$11(function1, (LanguageEnum) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LanguageSelector(strStringResource2, languageEnum2, recordVoiceOver, (Function1) objRememberedValue4, composer, 0);
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(f3), 1, (Object) null), 0.0f, 0L, composer, 6, 6);
            boolean z2 = true;
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_config_mode_header, composer, 0), PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f2), Dp.constructor-impl(f3)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 48, 0, 131064);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.conversation_config_mode_conversation_title, composer, 0);
            String strStringResource4 = StringResources_androidKt.stringResource(R.string.conversation_config_mode_conversation_desc, composer, 0);
            ImageVector transcribe = TranscribeKt.getTranscribe(Icons.INSTANCE.getDefault());
            boolean z3 = conversationMode == ConversationMode.ONE_TO_ONE;
            ComposerKt.sourceInformationMarkerStart(composer, 755921695, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            boolean zChanged5 = composer.changed(function1);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged5 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        return ConfigurationBottomSheetKt.ConfigBottomSheet$lambda$18$lambda$17$lambda$14$lambda$13(function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ModeSelectionItem(strStringResource3, strStringResource4, transcribe, z3, (Function0) objRememberedValue5, composer, 0);
            String strStringResource5 = StringResources_androidKt.stringResource(R.string.conversation_config_mode_meeting_title, composer, 0);
            String strStringResource6 = StringResources_androidKt.stringResource(R.string.conversation_config_mode_meeting_desc, composer, 0);
            ImageVector meetingRoom = MeetingRoomKt.getMeetingRoom(Icons.INSTANCE.getDefault());
            if (conversationMode != ConversationMode.MEETING) {
                z2 = false;
            }
            ComposerKt.sourceInformationMarkerStart(composer, 755937980, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            boolean zChanged6 = composer.changed(function1);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged6 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        return ConfigurationBottomSheetKt.ConfigBottomSheet$lambda$18$lambda$17$lambda$16$lambda$15(function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ModeSelectionItem(strStringResource5, strStringResource6, meetingRoom, z2, (Function0) objRememberedValue6, composer, 0);
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
    public static final Unit ConfigBottomSheet$lambda$18$lambda$17$lambda$3$lambda$2(Function1 function1) {
        function1.invoke(ConversationUiAction.OnToggleInputSuggestion.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfigBottomSheet$lambda$18$lambda$17$lambda$7$lambda$6$lambda$5(Function1 function1, boolean z) {
        function1.invoke(ConversationUiAction.OnToggleInputSuggestion.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfigBottomSheet$lambda$18$lambda$17$lambda$9$lambda$8(Function1 function1, LanguageEnum languageEnum) {
        Intrinsics.checkNotNullParameter(languageEnum, "userLanguage");
        function1.invoke(new ConversationUiAction.OnSetUserLanguage(languageEnum));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfigBottomSheet$lambda$18$lambda$17$lambda$12$lambda$11(Function1 function1, LanguageEnum languageEnum) {
        Intrinsics.checkNotNullParameter(languageEnum, "speakerLanguage");
        function1.invoke(new ConversationUiAction.OnSetSpeakerLanguage(languageEnum));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfigBottomSheet$lambda$18$lambda$17$lambda$14$lambda$13(Function1 function1) {
        function1.invoke(new ConversationUiAction.OnSwitchConversationMode(ConversationMode.ONE_TO_ONE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfigBottomSheet$lambda$18$lambda$17$lambda$16$lambda$15(Function1 function1) {
        function1.invoke(new ConversationUiAction.OnSwitchConversationMode(ConversationMode.MEETING));
        return Unit.INSTANCE;
    }

    public static final void LanguageSelector(final String str, final LanguageEnum languageEnum, final ImageVector imageVector, final Function1<? super LanguageEnum, Unit> function1, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(str, Constants.ScionAnalytics.PARAM_LABEL);
        Intrinsics.checkNotNullParameter(languageEnum, "selectedLanguage");
        Intrinsics.checkNotNullParameter(imageVector, "icon");
        Intrinsics.checkNotNullParameter(function1, "onLanguageSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-796319485);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LanguageSelector)P(1,3)192@8161L34,194@8201L2069:ConfigurationBottomSheet.kt#hsonup");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(languageEnum.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(imageVector) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-796319485, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageSelector (ConfigurationBottomSheet.kt:191)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -758839227, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f = 16;
            Modifier modifier = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(4));
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            Composer composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 67196844, "C204@8547L11,200@8392L193,207@8595L40,211@8733L24,213@8812L1452,209@8645L1619:ConfigurationBottomSheet.kt#hsonup");
            IconKt.Icon-ww6aTOc(imageVector, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), composerStartRestartGroup, ((i2 >> 6) & 14) | 432, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composerStartRestartGroup, 6);
            boolean zLanguageSelector$lambda$21 = LanguageSelector$lambda$21(mutableState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1106201953, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        return ConfigurationBottomSheetKt.LanguageSelector$lambda$37$lambda$24$lambda$23(mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ExposedDropdownMenuKt.ExposedDropdownMenuBox(zLanguageSelector$lambda$21, (Function1) objRememberedValue2, RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null), ComposableLambdaKt.rememberComposableLambda(1927620989, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConfigurationBottomSheetKt.LanguageSelector$lambda$37$lambda$36(languageEnum, str, mutableState, function1, (ExposedDropdownMenuBoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3120, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    return ConfigurationBottomSheetKt.LanguageSelector$lambda$38(str, languageEnum, imageVector, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean LanguageSelector$lambda$21(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void LanguageSelector$lambda$22(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$37$lambda$24$lambda$23(MutableState mutableState, boolean z) {
        LanguageSelector$lambda$22(mutableState, !LanguageSelector$lambda$21(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$37$lambda$36(LanguageEnum languageEnum, final String str, final MutableState mutableState, final Function1 function1, ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(exposedDropdownMenuBoxScope, "$this$ExposedDropdownMenuBox");
        ComposerKt.sourceInformation(composer, "C220@9160L25,216@8931L2,218@8992L15,219@9040L65,214@8826L621,231@9554L20,232@9589L665,229@9461L793:ConfigurationBottomSheet.kt#hsonup");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composer.changed(exposedDropdownMenuBoxScope) : composer.changedInstance(exposedDropdownMenuBoxScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1927620989, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageSelector.<anonymous>.<anonymous> (ConfigurationBottomSheet.kt:214)");
            }
            String displayText = languageEnum.getDisplayText();
            int i3 = i2;
            TextFieldColors textFieldColors = ExposedDropdownMenuDefaults.INSTANCE.outlinedTextFieldColors-FD9MK7s(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, (TextSelectionColors) null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, ExposedDropdownMenuDefaults.$stable << 27, Reader.READ_DONE, com.google.firebase.perf.util.Constants.MAX_HOST_LENGTH);
            Modifier modifier = exposedDropdownMenuBoxScope.menuAnchor-2Hz36ac(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ExposedDropdownMenuAnchorType.Companion.getPrimaryNotEditable-oYjWRB4(), true);
            ComposerKt.sourceInformationMarkerStart(composer, 1312869663, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        return ConfigurationBottomSheetKt.LanguageSelector$lambda$37$lambda$36$lambda$26$lambda$25((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(displayText, (Function1) objRememberedValue, modifier, false, true, (TextStyle) null, ComposableLambdaKt.rememberComposableLambda(-1922088809, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    return ConfigurationBottomSheetKt.LanguageSelector$lambda$37$lambda$36$lambda$27(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), (Function2) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(1535828340, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    return ConfigurationBottomSheetKt.LanguageSelector$lambda$37$lambda$36$lambda$28(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColors, composer, 806903856, 0, 0, 4193704);
            boolean zLanguageSelector$lambda$21 = LanguageSelector$lambda$21(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1312889617, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda17
                    public final Object invoke() {
                        return ConfigurationBottomSheetKt.LanguageSelector$lambda$37$lambda$36$lambda$30$lambda$29(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            exposedDropdownMenuBoxScope.ExposedDropdownMenu-vNxi1II(zLanguageSelector$lambda$21, (Function0) objRememberedValue2, (Modifier) null, (ScrollState) null, false, (Shape) null, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1378193605, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConfigurationBottomSheetKt.LanguageSelector$lambda$37$lambda$36$lambda$35(function1, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 48, (ExposedDropdownMenuBoxScope.$stable << 3) | 6 | ((i3 << 3) & 112), 1020);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$37$lambda$36$lambda$26$lambda$25(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$37$lambda$36$lambda$27(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C218@8994L11:ConfigurationBottomSheet.kt#hsonup");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1922088809, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageSelector.<anonymous>.<anonymous>.<anonymous> (ConfigurationBottomSheet.kt:218)");
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$37$lambda$36$lambda$28(MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C219@9070L33:ConfigurationBottomSheet.kt#hsonup");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1535828340, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageSelector.<anonymous>.<anonymous>.<anonymous> (ConfigurationBottomSheet.kt:219)");
            }
            ExposedDropdownMenuDefaults.INSTANCE.TrailingIcon(LanguageSelector$lambda$21(mutableState), (Modifier) null, composer, ExposedDropdownMenuDefaults.$stable << 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$37$lambda$36$lambda$30$lambda$29(MutableState mutableState) {
        LanguageSelector$lambda$22(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$37$lambda$36$lambda$35(final Function1 function1, final MutableState mutableState, ColumnScope columnScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(columnScope, "$this$ExposedDropdownMenu");
        ComposerKt.sourceInformation(composer2, "C*235@9719L227,241@9982L129,234@9670L552:ConfigurationBottomSheet.kt#hsonup");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1378193605, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageSelector.<anonymous>.<anonymous>.<anonymous> (ConfigurationBottomSheet.kt:233)");
            }
            for (final LanguageEnum languageEnum : LanguageEnum.getEntries()) {
                Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(142207459, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda19
                    public final Object invoke(Object obj, Object obj2) {
                        return ConfigurationBottomSheetKt.LanguageSelector$lambda$37$lambda$36$lambda$35$lambda$34$lambda$31(languageEnum, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, 1005561524, "CC(remember):ConfigurationBottomSheet.kt#9igjgp");
                boolean zChanged = composer2.changed(function1) | composer2.changed(languageEnum.ordinal());
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return ConfigurationBottomSheetKt.LanguageSelector$lambda$37$lambda$36$lambda$35$lambda$34$lambda$33$lambda$32(function1, languageEnum, mutableState);
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
    public static final Unit LanguageSelector$lambda$37$lambda$36$lambda$35$lambda$34$lambda$31(LanguageEnum languageEnum, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C238@9870L10,236@9749L171:ConfigurationBottomSheet.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(142207459, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageSelector.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ConfigurationBottomSheet.kt:236)");
            }
            TextKt.Text-Nvy7gAk(languageEnum.getDisplayText(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$37$lambda$36$lambda$35$lambda$34$lambda$33$lambda$32(Function1 function1, LanguageEnum languageEnum, MutableState mutableState) {
        function1.invoke(languageEnum);
        LanguageSelector$lambda$22(mutableState, false);
        return Unit.INSTANCE;
    }

    public static final void ModeSelectionItem(final String str, final String str2, final ImageVector imageVector, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        long j;
        long j2;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(imageVector, "icon");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1465179865);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModeSelectionItem)P(4!2,3)261@10431L1239:ConfigurationBottomSheet.kt#hsonup");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(imageVector) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1465179865, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ModeSelectionItem (ConfigurationBottomSheet.kt:260)");
            }
            float f = 16;
            Modifier modifier = PaddingKt.padding-VpY3zN4(SelectableKt.selectable-oSLSa3U$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), z, false, Role.box-impl(Role.Companion.getRadioButton-o7Vup1c()), (MutableInteractionSource) null, function0, 10, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(12));
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -269003674, "C272@10774L245,279@11029L40,281@11079L490,294@11579L85:ConfigurationBottomSheet.kt#hsonup");
            Modifier modifier2 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24));
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-1117051318);
                ComposerKt.sourceInformation(composerStartRestartGroup, "276@10942L11");
                j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1117050061);
                ComposerKt.sourceInformation(composerStartRestartGroup, "276@10981L11");
                j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            IconKt.Icon-ww6aTOc(imageVector, (String) null, modifier2, j, composerStartRestartGroup, ((i3 >> 6) & 14) | 432, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composerStartRestartGroup, 6);
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1573205707, "C284@11206L10,282@11132L231,289@11456L10,290@11517L11,287@11376L183:ConfigurationBottomSheet.kt#hsonup");
            TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1020584598);
                ComposerKt.sourceInformation(composerStartRestartGroup, "285@11280L11");
                j2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface-0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(1020585917);
                ComposerKt.sourceInformation(composerStartRestartGroup, "285@11321L11");
                j2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            TextKt.Text-Nvy7gAk(str, (Modifier) null, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, bodyLarge, composer2, i3 & 14, 0, 131066);
            TextKt.Text-Nvy7gAk(str2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, (i3 >> 3) & 14, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            RadioButtonKt.RadioButton(z, function0, (Modifier) null, false, (RadioButtonColors) null, (MutableInteractionSource) null, composer2, (i3 >> 9) & 126, 60);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    return ConfigurationBottomSheetKt.ModeSelectionItem$lambda$41(str, str2, imageVector, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
