package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CloudKt;
import androidx.compose.material.icons.filled.KeyboardArrowDownKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SwipeToDismissBoxKt;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
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
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.SuggestionCategory;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputSuggestionBottomSheet.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t\u001a.\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010\u0016\u001a+\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010\u001c¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002"}, d2 = {"InputSuggestionsBottomSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiState;", "onAction", "Lkotlin/Function1;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SwipeToDeleteContainer", "onDelete", "Lkotlin/Function0;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "CategoryHeader", "title", "", "isExpanded", "", "onToggle", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SuggestionItem", "suggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "isNetwork", "onClick", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "rotation", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputSuggestionBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryHeader$lambda$35(String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        CategoryHeader(str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputSuggestionsBottomSheet$lambda$27(Modifier modifier, ConversationUiState conversationUiState, Function1 function1, int i, int i2, Composer composer, int i3) {
        InputSuggestionsBottomSheet(modifier, conversationUiState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuggestionItem$lambda$37(ConversationSuggestion conversationSuggestion, boolean z, Function0 function0, int i, Composer composer, int i2) {
        SuggestionItem(conversationSuggestion, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeToDeleteContainer$lambda$32(Function0 function0, Function2 function2, int i, Composer composer, int i2) {
        SwipeToDeleteContainer(function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void InputSuggestionsBottomSheet(Modifier modifier, final ConversationUiState conversationUiState, final Function1<? super ConversationUiAction, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(conversationUiState, "uiState");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(-618967918);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputSuggestionsBottomSheet)P(!1,2)50@2510L113,54@2661L127,58@2815L46,62@2953L11,63@3001L67,66@3075L3358,60@2867L3566:InputSuggestionBottomSheet.kt#hsonup");
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
        } else {
            if (i4 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-618967918, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionsBottomSheet (InputSuggestionBottomSheet.kt:49)");
            }
            List<ConversationSuggestion> conversationSuggestions = conversationUiState.getConversationSuggestions();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2122674813, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(conversationSuggestions);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                obj = objRememberedValue;
                List<ConversationSuggestion> conversationSuggestions2 = conversationUiState.getConversationSuggestions();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj3 : conversationSuggestions2) {
                    SuggestionCategory category = ((ConversationSuggestion) obj3).getCategory();
                    Object obj4 = linkedHashMap.get(category);
                    if (obj4 == null) {
                        obj4 = (List) new ArrayList();
                        linkedHashMap.put(category, obj4);
                    }
                    ((List) obj4).add(obj3);
                }
                composerStartRestartGroup.updateRememberedValue(linkedHashMap);
                obj = linkedHashMap;
            }
            obj = objRememberedValue;
            final Map map = (Map) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            List<ConversationSuggestion> conversationSuggestionsNetwork = conversationUiState.getConversationSuggestionsNetwork();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2122669967, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(conversationSuggestionsNetwork);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                obj2 = objRememberedValue2;
                List<ConversationSuggestion> conversationSuggestionsNetwork2 = conversationUiState.getConversationSuggestionsNetwork();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Object obj5 : conversationSuggestionsNetwork2) {
                    SuggestionCategory category2 = ((ConversationSuggestion) obj5).getCategory();
                    Object obj6 = linkedHashMap2.get(category2);
                    if (obj6 == null) {
                        obj6 = (List) new ArrayList();
                        linkedHashMap2.put(category2, obj6);
                    }
                    ((List) obj6).add(obj5);
                }
                composerStartRestartGroup.updateRememberedValue(linkedHashMap2);
                obj2 = linkedHashMap2;
            }
            obj2 = objRememberedValue2;
            final Map map2 = (Map) obj2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2122665120, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.mutableStateMapOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final SnapshotStateMap snapshotStateMap = (SnapshotStateMap) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2122659147, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$6$lambda$5(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) objRememberedValue4, modifier2, (SheetState) null, 0.0f, false, (Shape) null, j, 0L, 0.0f, 0L, (Function2) null, (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(946743280, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj7, Object obj8, Object obj9) {
                    return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$26(map, function1, map2, snapshotStateMap, (ColumnScope) obj7, (Composer) obj8, ((Integer) obj9).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i3 << 3) & 112, 3072, 8124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier3 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj7, Object obj8) {
                    return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$27(modifier3, conversationUiState, function1, i, i2, (Composer) obj7, ((Integer) obj8).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputSuggestionsBottomSheet$lambda$6$lambda$5(Function1 function1) {
        function1.invoke(ConversationUiAction.OnHideDrawer.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputSuggestionsBottomSheet$lambda$26(final Map map, final Function1 function1, final Map map2, final SnapshotStateMap snapshotStateMap, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C71@3212L3215,67@3085L3342:InputSuggestionBottomSheet.kt#hsonup");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(946743280, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionsBottomSheet.<anonymous> (InputSuggestionBottomSheet.kt:67)");
            }
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(24), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -712767073, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(map) | composer.changed(function1) | composer.changedInstance(map2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24(map, map2, snapshotStateMap, function1, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyDslKt.LazyColumn(modifier, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) objRememberedValue, composer, 6, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$lambda$12(final Function1 function1, final SuggestionCategory suggestionCategory, final boolean z, final SnapshotStateMap snapshotStateMap, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C79@3562L61,80@3663L323,78@3499L513:InputSuggestionBottomSheet.kt#hsonup");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1979737093, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionsBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InputSuggestionBottomSheet.kt:78)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -143162846, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(suggestionCategory);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$lambda$12$lambda$8$lambda$7(function1, suggestionCategory);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwipeToDeleteContainer((Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-100292714, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$lambda$12$lambda$11(suggestionCategory, z, snapshotStateMap, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$lambda$12$lambda$8$lambda$7(Function1 function1, SuggestionCategory suggestionCategory) {
        function1.invoke(new ConversationUiAction.OnDeleteCategory(suggestionCategory));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$lambda$12$lambda$11(final SuggestionCategory suggestionCategory, final boolean z, final SnapshotStateMap snapshotStateMap, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C84@3880L42,81@3697L259:InputSuggestionBottomSheet.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-100292714, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionsBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InputSuggestionBottomSheet.kt:81)");
            }
            String name = suggestionCategory.getName();
            ComposerKt.sourceInformationMarkerStart(composer, -1892010656, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
            boolean zChanged = composer.changed(suggestionCategory) | composer.changed(z);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$lambda$12$lambda$11$lambda$10$lambda$9(snapshotStateMap, suggestionCategory, z);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CategoryHeader(name, z, (Function0) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$lambda$12$lambda$11$lambda$10$lambda$9(SnapshotStateMap snapshotStateMap, SuggestionCategory suggestionCategory, boolean z) {
        ((Map) snapshotStateMap).put(suggestionCategory, Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$lambda$13(ConversationSuggestion conversationSuggestion) {
        Intrinsics.checkNotNullParameter(conversationSuggestion, "it");
        return "local_suggestion_" + conversationSuggestion.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$lambda$19(final SuggestionCategory suggestionCategory, final boolean z, final SnapshotStateMap snapshotStateMap, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C123@5575L42,120@5416L227:InputSuggestionBottomSheet.kt#hsonup");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1583249518, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionsBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InputSuggestionBottomSheet.kt:120)");
            }
            String name = suggestionCategory.getName();
            ComposerKt.sourceInformationMarkerStart(composer, 1084369976, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
            boolean zChanged = composer.changed(suggestionCategory) | composer.changed(z);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$lambda$19$lambda$18$lambda$17(snapshotStateMap, suggestionCategory, z);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CategoryHeader(name, z, (Function0) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$lambda$19$lambda$18$lambda$17(SnapshotStateMap snapshotStateMap, SuggestionCategory suggestionCategory, boolean z) {
        ((Map) snapshotStateMap).put(suggestionCategory, Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$lambda$20(ConversationSuggestion conversationSuggestion) {
        Intrinsics.checkNotNullParameter(conversationSuggestion, "it");
        return "network_suggestion_" + conversationSuggestion.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwipeToDeleteContainer(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(368482765);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwipeToDeleteContainer)P(1)155@6675L187,154@6614L254,184@7565L223,165@6874L965:InputSuggestionBottomSheet.kt#hsonup");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(368482765, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SwipeToDeleteContainer (InputSuggestionBottomSheet.kt:153)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1924626696, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
            boolean z = (i2 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(InputSuggestionBottomSheetKt.SwipeToDeleteContainer$lambda$29$lambda$28(function0, (SwipeToDismissBoxValue) obj));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SwipeToDismissBoxKt.SwipeToDismissBox(SwipeToDismissBoxKt.rememberSwipeToDismissBoxState((SwipeToDismissBoxValue) null, (Function1) objRememberedValue, (Function1) null, composerStartRestartGroup, 0, 5), ComposableSingletons$InputSuggestionBottomSheetKt.INSTANCE.getLambda$1325224943$app_release(), (Modifier) null, false, false, false, (Function1) null, ComposableLambdaKt.rememberComposableLambda(-27490007, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InputSuggestionBottomSheetKt.SwipeToDeleteContainer$lambda$31(function2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, SwipeToDismissBoxState.$stable | 12586032, 116);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    return InputSuggestionBottomSheetKt.SwipeToDeleteContainer$lambda$32(function0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SwipeToDeleteContainer$lambda$29$lambda$28(Function0 function0, SwipeToDismissBoxValue swipeToDismissBoxValue) {
        Intrinsics.checkNotNullParameter(swipeToDismissBoxValue, "value");
        if (swipeToDismissBoxValue != SwipeToDismissBoxValue.EndToStart) {
            return false;
        }
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeToDeleteContainer$lambda$31(Function2 function2, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$SwipeToDismissBox");
        ComposerKt.sourceInformation(composer, "C188@7702L11,185@7579L199:InputSuggestionBottomSheet.kt#hsonup");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-27490007, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SwipeToDeleteContainer.<anonymous> (InputSuggestionBottomSheet.kt:185)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -42812469, "C190@7755L9:InputSuggestionBottomSheet.kt#hsonup");
            function2.invoke(composer, 0);
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

    private static final void CategoryHeader(final String str, boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        String strStringResource;
        final boolean z2 = z;
        Composer composerStartRestartGroup = composer.startRestartGroup(-472928829);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CategoryHeader)P(2)203@7976L105,208@8087L811:InputSuggestionBottomSheet.kt#hsonup");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-472928829, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.CategoryHeader (InputSuggestionBottomSheet.kt:202)");
            }
            State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z2 ? 180.0f : 0.0f, (AnimationSpec) null, 0.0f, "rotation", (Function1) null, composerStartRestartGroup, 3072, 22);
            int i3 = i2;
            Modifier modifier = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(12));
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2143493764, "C218@8446L10,219@8504L11,216@8380L195,222@8584L308:InputSuggestionBottomSheet.kt#hsonup");
            TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composerStartRestartGroup, (i3 & 14) | 1572864, 0, 131002);
            composer2 = composerStartRestartGroup;
            ImageVector keyboardArrowDown = KeyboardArrowDownKt.getKeyboardArrowDown(Icons.INSTANCE.getDefault());
            z2 = z;
            if (z2) {
                composer2.startReplaceGroup(-1039223478);
                ComposerKt.sourceInformation(composer2, "225@8714L43");
                strStringResource = StringResources_androidKt.stringResource(R.string.global_cd_collapse, composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1039221016);
                ComposerKt.sourceInformation(composer2, "227@8791L41");
                strStringResource = StringResources_androidKt.stringResource(R.string.global_cd_expand, composer2, 0);
                composer2.endReplaceGroup();
            }
            IconKt.Icon-ww6aTOc(keyboardArrowDown, strStringResource, RotateKt.rotate(Modifier.Companion, CategoryHeader$lambda$33(stateAnimateFloatAsState)), 0L, composer2, 0, 8);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    return InputSuggestionBottomSheetKt.CategoryHeader$lambda$35(str, z2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuggestionItem(final ConversationSuggestion conversationSuggestion, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composer3;
        Composer composerStartRestartGroup = composer.startRestartGroup(651459513);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SuggestionItem)P(2)239@9038L839:InputSuggestionBottomSheet.kt#hsonup");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(conversationSuggestion) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(651459513, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SuggestionItem (InputSuggestionBottomSheet.kt:238)");
            }
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            float f = 12;
            Modifier modifier = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(ClickableKt.clickable-oSLSa3U$default(Modifier.Companion, false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(24), Dp.constructor-impl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composerStartRestartGroup, 54);
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
            Composer composer4 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1674198742, "C262@9840L11,257@9662L209:InputSuggestionBottomSheet.kt#hsonup");
            if (!z) {
                composer3 = composerStartRestartGroup;
                composer3.startReplaceGroup(-1683465139);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1674191086);
                ComposerKt.sourceInformation(composerStartRestartGroup, "254@9601L11,248@9352L291");
                IconKt.Icon-ww6aTOc(CloudKt.getCloud(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f), 0.0f, 11, (Object) null), Dp.constructor-impl(20)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), composerStartRestartGroup, 432, 0);
                composer3 = composerStartRestartGroup;
            }
            composer3.endReplaceGroup();
            Composer composer5 = composer3;
            TextKt.Text-Nvy7gAk(conversationSuggestion.getText(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, composer5, 24576, 24960, 241642);
            composer2 = composer5;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    return InputSuggestionBottomSheetKt.SuggestionItem$lambda$37(conversationSuggestion, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24(Map map, Map map2, final SnapshotStateMap snapshotStateMap, final Function1 function1, LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            final SuggestionCategory suggestionCategory = (SuggestionCategory) entry.getKey();
            final List list = (List) entry.getValue();
            if (!list.isEmpty()) {
                Boolean bool = (Boolean) snapshotStateMap.get(suggestionCategory);
                final boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                LazyListScope.item$default(lazyListScope, "local_header_" + suggestionCategory.hashCode(), (Object) null, ComposableLambdaKt.composableLambdaInstance(1979737093, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$lambda$12(function1, suggestionCategory, zBooleanValue, snapshotStateMap, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 2, (Object) null);
                if (zBooleanValue) {
                    final Function1 function2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$lambda$13((ConversationSuggestion) obj);
                        }
                    };
                    final InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$$inlined$items$default$1 inputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$$inlined$items$default$1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$$inlined$items$default$1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final Void m1589invoke(ConversationSuggestion conversationSuggestion) {
                            return null;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return m1589invoke((ConversationSuggestion) obj);
                        }
                    };
                    lazyListScope.items(list.size(), new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$$inlined$items$default$2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Number) obj).intValue());
                        }

                        public final Object invoke(int i) {
                            return function2.invoke(list.get(i));
                        }
                    }, new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$$inlined$items$default$3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Number) obj).intValue());
                        }

                        public final Object invoke(int i) {
                            return inputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$$inlined$items$default$1.invoke(list.get(i));
                        }
                    }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$16$$inlined$items$default$4
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                            int i3;
                            ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                            if ((i2 & 6) == 0) {
                                i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                            } else {
                                i3 = i2;
                            }
                            if ((i2 & 48) == 0) {
                                i3 |= composer.changed(i) ? 32 : 16;
                            }
                            if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                            }
                            final ConversationSuggestion conversationSuggestion = (ConversationSuggestion) list.get(i);
                            composer.startReplaceGroup(1386820871);
                            ComposerKt.sourceInformation(composer, "C*97@4360L65,98@4469L541,96@4293L747:InputSuggestionBottomSheet.kt#hsonup");
                            ComposerKt.sourceInformationMarkerStart(composer, -1063641038, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
                            boolean zChanged = composer.changed(function1) | composer.changed(conversationSuggestion);
                            Object objRememberedValue = composer.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                final Function1 function3 = function1;
                                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$2$1$1$1$3$1$1
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m1586invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m1586invoke() {
                                        function3.invoke(new ConversationUiAction.OnDeleteSuggestion(conversationSuggestion));
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            final Function1 function4 = function1;
                            InputSuggestionBottomSheetKt.SwipeToDeleteContainer((Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-1424683840, true, new Function2<Composer, Integer, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$2$1$1$1$3$2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i4) {
                                    ComposerKt.sourceInformation(composer2, "C102@4697L241,99@4507L469:InputSuggestionBottomSheet.kt#hsonup");
                                    if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1424683840, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionsBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InputSuggestionBottomSheet.kt:99)");
                                    }
                                    ConversationSuggestion conversationSuggestion2 = conversationSuggestion;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 973404721, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
                                    boolean zChanged2 = composer2.changed(function4) | composer2.changed(conversationSuggestion);
                                    final Function1<ConversationUiAction, Unit> function5 = function4;
                                    final ConversationSuggestion conversationSuggestion3 = conversationSuggestion;
                                    Object objRememberedValue2 = composer2.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$2$1$1$1$3$2$1$1
                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m1587invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                            public final void m1587invoke() {
                                                function5.invoke(new ConversationUiAction.OnInputTextChange(conversationSuggestion3.getText()));
                                                function5.invoke(ConversationUiAction.OnHideDrawer.INSTANCE);
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    InputSuggestionBottomSheetKt.SuggestionItem(conversationSuggestion2, false, (Function0) objRememberedValue2, composer2, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer, 54), composer, 48);
                            composer.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                }
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            final SuggestionCategory suggestionCategory2 = (SuggestionCategory) entry2.getKey();
            final List list2 = (List) entry2.getValue();
            if (!list2.isEmpty()) {
                Boolean bool2 = (Boolean) snapshotStateMap.get(suggestionCategory2);
                final boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
                LazyListScope.item$default(lazyListScope, "network_header_" + suggestionCategory2.hashCode(), (Object) null, ComposableLambdaKt.composableLambdaInstance(1583249518, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$lambda$19(suggestionCategory2, zBooleanValue2, snapshotStateMap, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 2, (Object) null);
                if (zBooleanValue2) {
                    final Function1 function3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            return InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$lambda$20((ConversationSuggestion) obj);
                        }
                    };
                    final InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$$inlined$items$default$1 inputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$$inlined$items$default$1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$$inlined$items$default$1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final Void m1590invoke(ConversationSuggestion conversationSuggestion) {
                            return null;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return m1590invoke((ConversationSuggestion) obj);
                        }
                    };
                    lazyListScope.items(list2.size(), new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$$inlined$items$default$2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Number) obj).intValue());
                        }

                        public final Object invoke(int i) {
                            return function3.invoke(list2.get(i));
                        }
                    }, new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$$inlined$items$default$3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Number) obj).intValue());
                        }

                        public final Object invoke(int i) {
                            return inputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$$inlined$items$default$1.invoke(list2.get(i));
                        }
                    }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$lambda$26$lambda$25$lambda$24$lambda$23$$inlined$items$default$4
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                            int i3;
                            ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                            if ((i2 & 6) == 0) {
                                i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                            } else {
                                i3 = i2;
                            }
                            if ((i2 & 48) == 0) {
                                i3 |= composer.changed(i) ? 32 : 16;
                            }
                            if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                            }
                            final ConversationSuggestion conversationSuggestion = (ConversationSuggestion) list2.get(i);
                            composer.startReplaceGroup(633924237);
                            ComposerKt.sourceInformation(composer, "C*135@6090L217,132@5925L412:InputSuggestionBottomSheet.kt#hsonup");
                            ComposerKt.sourceInformationMarkerStart(composer, 1267380243, "CC(remember):InputSuggestionBottomSheet.kt#9igjgp");
                            boolean zChanged = composer.changed(function1) | composer.changed(conversationSuggestion);
                            Object objRememberedValue = composer.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                final Function1 function4 = function1;
                                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt$InputSuggestionsBottomSheet$2$1$1$2$3$1$1
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m1588invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m1588invoke() {
                                        function4.invoke(new ConversationUiAction.OnInputTextChange(conversationSuggestion.getText()));
                                        function4.invoke(ConversationUiAction.OnHideDrawer.INSTANCE);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            InputSuggestionBottomSheetKt.SuggestionItem(conversationSuggestion, true, (Function0) objRememberedValue, composer, 48);
                            composer.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                }
            }
        }
        return Unit.INSTANCE;
    }

    private static final float CategoryHeader$lambda$33(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }
}
