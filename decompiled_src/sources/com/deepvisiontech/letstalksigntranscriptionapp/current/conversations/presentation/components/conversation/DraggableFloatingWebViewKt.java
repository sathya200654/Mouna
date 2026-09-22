package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActionElement;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DraggableFloatingWebView.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u008e\u0002"}, d2 = {"ConversationWebView", "", "modifier", "Landroidx/compose/ui/Modifier;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement$InterpretationWebView;", "onRestore", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement$InterpretationWebView;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "offset", "Landroidx/compose/ui/unit/IntOffset;", "viewSize", "Landroidx/compose/ui/unit/IntSize;", "parentSize", "isInitialized", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DraggableFloatingWebViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationWebView$lambda$26(Modifier modifier, WebViewManager webViewManager, ConversationActionElement.InterpretationWebView interpretationWebView, Function0 function0, int i, int i2, Composer composer, int i3) {
        ConversationWebView(modifier, webViewManager, interpretationWebView, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ConversationWebView(Modifier modifier, final WebViewManager webViewManager, final ConversationActionElement.InterpretationWebView interpretationWebView, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Function0<Unit> function1;
        final Modifier modifier3;
        final MutableState mutableState;
        FiniteAnimationSpec finiteAnimationSpec;
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(interpretationWebView, RemoteConfigConstants.ResponseFieldKey.STATE);
        Intrinsics.checkNotNullParameter(function0, "onRestore");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1019852975);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConversationWebView)P(!1,3,2)51@2348L44,52@2413L41,53@2477L41,55@2545L34,61@2724L216,61@2687L253,70@2963L44,71@3031L53,72@3104L42,76@3219L161,80@3401L326,89@3760L326,98@4110L389,74@3152L2304:DraggableFloatingWebView.kt#hsonup");
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
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(webViewManager) : composerStartRestartGroup.changedInstance(webViewManager) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(interpretationWebView) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        int i5 = i3;
        if (!composerStartRestartGroup.shouldExecute((i5 & 1171) != 1170, i5 & 1)) {
            function1 = function0;
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1019852975, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationWebView (DraggableFloatingWebView.kt:50)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826158531, "CC(remember):DraggableFloatingWebView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                long j = 0;
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(IntOffset.constructor-impl((j << 32) | (j & 4294967295L))), (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826156454, "CC(remember):DraggableFloatingWebView.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826154406, "CC(remember):DraggableFloatingWebView.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826152237, "CC(remember):DraggableFloatingWebView.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f = Dp.constructor-impl(250);
            float f2 = Dp.constructor-impl(350);
            final boolean zIsMinimized = interpretationWebView.isMinimized();
            IntSize intSize = IntSize.box-impl(ConversationWebView$lambda$7(mutableState4));
            IntSize intSize2 = IntSize.box-impl(ConversationWebView$lambda$4(mutableState3));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826146327, "CC(remember):DraggableFloatingWebView.kt#9igjgp");
            DraggableFloatingWebViewKt$ConversationWebView$1$1 draggableFloatingWebViewKt$ConversationWebView$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (draggableFloatingWebViewKt$ConversationWebView$1$1RememberedValue == Composer.Companion.getEmpty()) {
                draggableFloatingWebViewKt$ConversationWebView$1$1RememberedValue = new DraggableFloatingWebViewKt$ConversationWebView$1$1(mutableState5, mutableState4, mutableState3, mutableState2, null);
                composerStartRestartGroup.updateRememberedValue(draggableFloatingWebViewKt$ConversationWebView$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(intSize, intSize2, (Function2) draggableFloatingWebViewKt$ConversationWebView$1$1RememberedValue, composerStartRestartGroup, 0);
            final String strStringResource = StringResources_androidKt.stringResource(R.string.webview_cd_minimize, composerStartRestartGroup, 0);
            final String strStringResource2 = StringResources_androidKt.stringResource(R.string.webview_button_label_restore, composerStartRestartGroup, 0);
            final String strStringResource3 = StringResources_androidKt.stringResource(R.string.webview_cd_active, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826130542, "CC(remember):DraggableFloatingWebView.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                mutableState = mutableState4;
                objRememberedValue5 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.DraggableFloatingWebViewKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return DraggableFloatingWebViewKt.ConversationWebView$lambda$14$lambda$13(mutableState3, mutableState, (LayoutCoordinates) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                mutableState = mutableState4;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, (Function1) objRememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826124553, "CC(remember):DraggableFloatingWebView.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            Modifier modifier5 = modifier4;
            if (objRememberedValue6 == Composer.Companion.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.DraggableFloatingWebViewKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return DraggableFloatingWebViewKt.ConversationWebView$lambda$16$lambda$15(mutableState, mutableState3, mutableState2, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOffset = OffsetKt.offset(modifierOnGloballyPositioned, (Function1) objRememberedValue6);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826113065, "CC(remember):DraggableFloatingWebView.kt#9igjgp");
            DraggableFloatingWebViewKt$ConversationWebView$4$1 draggableFloatingWebViewKt$ConversationWebView$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (draggableFloatingWebViewKt$ConversationWebView$4$1RememberedValue == Composer.Companion.getEmpty()) {
                draggableFloatingWebViewKt$ConversationWebView$4$1RememberedValue = new DraggableFloatingWebViewKt$ConversationWebView$4$1(mutableState2);
                composerStartRestartGroup.updateRememberedValue(draggableFloatingWebViewKt$ConversationWebView$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierOffset, unit, (PointerInputEventHandler) draggableFloatingWebViewKt$ConversationWebView$4$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826101802, "CC(remember):DraggableFloatingWebView.kt#9igjgp");
            int i6 = i5 & 7168;
            boolean zChanged = composerStartRestartGroup.changed(zIsMinimized) | composerStartRestartGroup.changed(strStringResource) | composerStartRestartGroup.changed(strStringResource2) | (i6 == 2048) | composerStartRestartGroup.changed(strStringResource3);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue7 == Composer.Companion.getEmpty()) {
                finiteAnimationSpec = null;
                objRememberedValue7 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.DraggableFloatingWebViewKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        return DraggableFloatingWebViewKt.ConversationWebView$lambda$20$lambda$19(zIsMinimized, strStringResource, strStringResource2, strStringResource3, function0, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                finiteAnimationSpec = null;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierAnimateContentSize$default = AnimationModifierKt.animateContentSize$default(ZIndexModifierKt.zIndex(SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) objRememberedValue7, 1, finiteAnimationSpec), 5.0f), finiteAnimationSpec, finiteAnimationSpec, 3, finiteAnimationSpec);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -710175124, "C:DraggableFloatingWebView.kt#hsonup");
            if (zIsMinimized) {
                composerStartRestartGroup.startReplaceGroup(-710172149);
                ComposerKt.sourceInformation(composerStartRestartGroup, "115@4638L43,120@4880L11,121@4945L15,114@4605L404");
                Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.small_logo, composerStartRestartGroup, 0);
                Modifier modifier6 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), RoundedCornerShapeKt.getCircleShape()), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurfaceContainerHigh-0d7_KjU(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2101107846, "CC(remember):DraggableFloatingWebView.kt#9igjgp");
                boolean z = i6 == 2048;
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue8 == Composer.Companion.getEmpty()) {
                    objRememberedValue8 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.DraggableFloatingWebViewKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            return DraggableFloatingWebViewKt.ConversationWebView$lambda$25$lambda$22$lambda$21(function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ImageKt.Image(painterPainterResource, (String) null, PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue8, 15, (Object) null), Dp.constructor-impl(8)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 48, 120);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-709741714);
                ComposerKt.sourceInformation(composerStartRestartGroup, "130@5250L176,125@5039L401");
                Modifier modifier7 = BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, f), f2), Color.Companion.getTransparent-0d7_KjU(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2101097925, (String) r6);
                boolean z2 = (i5 & 112) == 32 || ((i5 & 64) != 0 && composerStartRestartGroup.changedInstance(webViewManager));
                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue9 == Composer.Companion.getEmpty()) {
                    objRememberedValue9 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.DraggableFloatingWebViewKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            return DraggableFloatingWebViewKt.ConversationWebView$lambda$25$lambda$24$lambda$23(webViewManager, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue9, modifier7, (Function1) null, composerStartRestartGroup, 48, 4);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function2 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.DraggableFloatingWebViewKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    return DraggableFloatingWebViewKt.ConversationWebView$lambda$26(modifier3, webViewManager, interpretationWebView, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ConversationWebView$lambda$1(MutableState<IntOffset> mutableState) {
        return ((IntOffset) ((State) mutableState).getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ConversationWebView$lambda$2(MutableState<IntOffset> mutableState, long j) {
        mutableState.setValue(IntOffset.box-impl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ConversationWebView$lambda$4(MutableState<IntSize> mutableState) {
        return ((IntSize) ((State) mutableState).getValue()).unbox-impl();
    }

    private static final void ConversationWebView$lambda$5(MutableState<IntSize> mutableState, long j) {
        mutableState.setValue(IntSize.box-impl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ConversationWebView$lambda$7(MutableState<IntSize> mutableState) {
        return ((IntSize) ((State) mutableState).getValue()).unbox-impl();
    }

    private static final void ConversationWebView$lambda$8(MutableState<IntSize> mutableState, long j) {
        mutableState.setValue(IntSize.box-impl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ConversationWebView$lambda$10(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationWebView$lambda$14$lambda$13(MutableState mutableState, MutableState mutableState2, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        ConversationWebView$lambda$5(mutableState, layoutCoordinates.getSize-YbymL2g());
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        ConversationWebView$lambda$8(mutableState2, parentLayoutCoordinates != null ? parentLayoutCoordinates.getSize-YbymL2g() : IntSize.Companion.getZero-YbymL2g());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset ConversationWebView$lambda$16$lambda$15(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Density density) {
        Intrinsics.checkNotNullParameter(density, "$this$offset");
        int iCoerceAtLeast = RangesKt.coerceAtLeast(((int) (ConversationWebView$lambda$7(mutableState) >> 32)) - ((int) (ConversationWebView$lambda$4(mutableState2) >> 32)), 0);
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast(((int) (ConversationWebView$lambda$7(mutableState) & 4294967295L)) - ((int) (ConversationWebView$lambda$4(mutableState2) & 4294967295L)), 0);
        return IntOffset.box-impl(IntOffset.constructor-impl((((long) RangesKt.coerceIn(IntOffset.getX-impl(ConversationWebView$lambda$1(mutableState3)), 0, iCoerceAtLeast)) << 32) | (((long) RangesKt.coerceIn(IntOffset.getY-impl(ConversationWebView$lambda$1(mutableState3)), 0, iCoerceAtLeast2)) & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationWebView$lambda$20$lambda$19(boolean z, String str, String str2, String str3, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        if (z) {
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
            SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, str2, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.DraggableFloatingWebViewKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    return Boolean.valueOf(DraggableFloatingWebViewKt.ConversationWebView$lambda$20$lambda$19$lambda$18(function0));
                }
            });
        } else {
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str3);
            SemanticsPropertiesKt.setLiveRegion-hR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.getPolite-0phEisY());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ConversationWebView$lambda$20$lambda$19$lambda$18(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationWebView$lambda$25$lambda$22$lambda$21(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView ConversationWebView$lambda$25$lambda$24$lambda$23(WebViewManager webViewManager, Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        WebView webView = webViewManager.getWebView();
        ViewParent parent = webView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(webView);
        }
        return webView;
    }
}
