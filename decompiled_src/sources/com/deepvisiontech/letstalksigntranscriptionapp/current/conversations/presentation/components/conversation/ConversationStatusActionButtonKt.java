package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActivity;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationStatusActionButton.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"ConversationStatusActionButton", "", "activity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "isInterpretEnabled", "", "onStartParams", "Lkotlin/Function0;", "onStopParams", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationStatusActionButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationStatusActionButton$lambda$3(ConversationActivity conversationActivity, boolean z, Function0 function0, Function0 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ConversationStatusActionButton(conversationActivity, z, function0, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0096  */
    /* JADX WARN: Code duplicated, block: B:49:0x0098  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00af  */
    /* JADX WARN: Code duplicated, block: B:60:0x0117  */
    /* JADX WARN: Code duplicated, block: B:63:0x0123  */
    /* JADX WARN: Code duplicated, block: B:64:0x0127  */
    /* JADX WARN: Code duplicated, block: B:90:0x025b  */
    /* JADX WARN: Code duplicated, block: B:93:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:95:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:98:0x02c1  */
    public static final void ConversationStatusActionButton(final ConversationActivity conversationActivity, final boolean z, final Function0<Unit> function0, final Function0<Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function0 constructor;
        Modifier modifier5;
        boolean z3;
        Intrinsics.checkNotNullParameter(conversationActivity, "activity");
        Intrinsics.checkNotNullParameter(function0, "onStartParams");
        Intrinsics.checkNotNullParameter(function1, "onStopParams");
        Composer composerStartRestartGroup = composer.startRestartGroup(-854101516);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConversationStatusActionButton)P(!2,3,4)29@1296L7,31@1309L1714:ConversationStatusActionButton.kt#hsonup");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(conversationActivity) : composerStartRestartGroup.changedInstance(conversationActivity) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i3 & 9363) != 9362) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-854101516, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationStatusActionButton (ConversationStatusActionButton.kt:28)");
                }
                CompositionLocal localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localFocusManager);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final FocusManager focusManager = (FocusManager) objConsume;
                Modifier modifier6 = SizeKt.size-3ABfNKs(modifier4, Dp.constructor-impl(40));
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier6);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -532356943, "C:ConversationStatusActionButton.kt#hsonup");
                if (!Intrinsics.areEqual(conversationActivity, ConversationActivity.IsInitializing.INSTANCE) || Intrinsics.areEqual(conversationActivity, ConversationActivity.IsProcessingInputText.INSTANCE) || Intrinsics.areEqual(conversationActivity, ConversationActivity.IsSummarizing.INSTANCE) || Intrinsics.areEqual(conversationActivity, ConversationActivity.IsFetchingSuggestions.INSTANCE)) {
                    modifier5 = modifier4;
                    composerStartRestartGroup.startReplaceGroup(-532172959);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "40@1802L11,37@1640L199");
                    ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), Dp.constructor-impl(2), 0L, 0, 0.0f, composerStartRestartGroup, 390, 56);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else if (Intrinsics.areEqual(conversationActivity, ConversationActivity.IsTranscribing.INSTANCE) || (conversationActivity instanceof ConversationActivity.IsInterpreting)) {
                    modifier5 = modifier4;
                    composerStartRestartGroup.startReplaceGroup(-531843336);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "46@1976L80");
                    AnimatedStopButtonKt.AnimatedStopButton(null, function1, composerStartRestartGroup, (i3 >> 6) & 112, 1);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-531685515);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "59@2436L11,60@2523L11,58@2365L208,54@2202L113,52@2110L883");
                    modifier5 = modifier4;
                    IconButtonColors iconButtonColors = IconButtonDefaults.INSTANCE.iconButtonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, IconButtonDefaults.$stable << 12, 12);
                    Modifier modifier7 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1402621749, "CC(remember):ConversationStatusActionButton.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(focusManager);
                    if ((i3 & 896) == 256) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        z3 = true;
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        z3 = false;
                    }
                    boolean z4 = zChangedInstance | z3;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z4 || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationStatusActionButtonKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                return ConversationStatusActionButtonKt.ConversationStatusActionButton$lambda$2$lambda$1$lambda$0(focusManager, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    IconButtonKt.IconButton((Function0) objRememberedValue, modifier7, z, iconButtonColors, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationStatusActionButtonKt.INSTANCE.getLambda$2062386585$app_release(), composerStartRestartGroup, ((i3 << 3) & 896) | 1572912, 48);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationStatusActionButtonKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return ConversationStatusActionButtonKt.ConversationStatusActionButton$lambda$3(conversationActivity, z, function0, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i3 & 9363) != 9362) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-854101516, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationStatusActionButton (ConversationStatusActionButton.kt:28)");
            }
            CompositionLocal localFocusManager2 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localFocusManager2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager2 = (FocusManager) objConsume2;
            Modifier modifier8 = SizeKt.size-3ABfNKs(modifier4, Dp.constructor-impl(40));
            Alignment center2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier8);
            constructor = ComposeUiNode.Companion.getConstructor();
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
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -532356943, "C:ConversationStatusActionButton.kt#hsonup");
            if (!Intrinsics.areEqual(conversationActivity, ConversationActivity.IsInitializing.INSTANCE)) {
                modifier5 = modifier4;
                composerStartRestartGroup.startReplaceGroup(-532172959);
                ComposerKt.sourceInformation(composerStartRestartGroup, "40@1802L11,37@1640L199");
                ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), Dp.constructor-impl(2), 0L, 0, 0.0f, composerStartRestartGroup, 390, 56);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                modifier5 = modifier4;
                composerStartRestartGroup.startReplaceGroup(-532172959);
                ComposerKt.sourceInformation(composerStartRestartGroup, "40@1802L11,37@1640L199");
                ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), Dp.constructor-impl(2), 0L, 0, 0.0f, composerStartRestartGroup, 390, 56);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationStatusActionButtonKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationStatusActionButtonKt.ConversationStatusActionButton$lambda$3(conversationActivity, z, function0, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationStatusActionButton$lambda$2$lambda$1$lambda$0(FocusManager focusManager, Function0 function0) {
        FocusManager.clearFocus$default(focusManager, false, 1, (Object) null);
        function0.invoke();
        return Unit.INSTANCE;
    }
}
