package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import android.graphics.BlurMaskFilter;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.TranslateKt;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageAnnouncementPopUp.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001aS\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"LanguageAnnouncementPopup", "", "modifier", "Landroidx/compose/ui/Modifier;", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "onClick", "Lkotlin/Function0;", "onDismissRequest", "onTimerFinished", "timeoutMillis", "", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;II)V", "app_release", "isInteracted", "", "glowAlpha", "", "glowRadius"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LanguageAnnouncementPopUpKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageAnnouncementPopup$lambda$19(Modifier modifier, LanguageEnum languageEnum, Function0 function0, Function0 function1, Function0 function2, long j, int i, int i2, Composer composer, int i3) {
        LanguageAnnouncementPopup(modifier, languageEnum, function0, function1, function2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:69:0x013b  */
    /* JADX WARN: Code duplicated, block: B:71:0x0143  */
    /* JADX WARN: Code duplicated, block: B:74:0x0150  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    public static final void LanguageAnnouncementPopup(Modifier modifier, final LanguageEnum languageEnum, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        int i4;
        boolean z;
        final Modifier modifier3;
        Composer composer2;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Modifier modifier4;
        final long j4;
        Intrinsics.checkNotNullParameter(languageEnum, "language");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function1, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function2, "onTimerFinished");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2126307377);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LanguageAnnouncementPopup)P(1)60@2592L4031,55@2395L4228:LanguageAnnouncementPopUp.kt#hsonup");
        int i5 = i2 & 1;
        if (i5 != 0) {
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
            i3 |= composerStartRestartGroup.changed(languageEnum.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        int i6 = i2 & 32;
        if (i6 == 0) {
            if ((196608 & i) == 0) {
                j2 = j;
                i3 |= composerStartRestartGroup.changed(j2) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
            }
            i4 = i3;
            if ((74899 & i4) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                j3 = j2;
            } else {
                if (i5 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i6 != 0) {
                    j4 = 3000;
                } else {
                    j4 = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2126307377, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopup (LanguageAnnouncementPopUp.kt:54)");
                }
                long j5 = j4;
                Modifier modifier5 = modifier4;
                AndroidPopup_androidKt.Popup-K5zGePQ(Alignment.Companion.getTopCenter(), IntOffset.constructor-impl((((long) 0) << 32) | (((long) 50) & 4294967295L)), function1, new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(34562802, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        return LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup$lambda$18(j4, function2, modifier4, function0, languageEnum, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 3) & 896) | 27702, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                modifier3 = modifier5;
                j3 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup$lambda$19(modifier3, languageEnum, function0, function1, function2, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 196608;
        j2 = j;
        i4 = i3;
        if ((74899 & i4) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            j3 = j2;
        } else {
            if (i5 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i6 != 0) {
                j4 = 3000;
            } else {
                j4 = j2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2126307377, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopup (LanguageAnnouncementPopUp.kt:54)");
            }
            long j6 = j4;
            Modifier modifier6 = modifier4;
            AndroidPopup_androidKt.Popup-K5zGePQ(Alignment.Companion.getTopCenter(), IntOffset.constructor-impl((((long) 0) << 32) | (((long) 50) & 4294967295L)), function1, new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(34562802, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup$lambda$18(j4, function2, modifier4, function0, languageEnum, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 3) & 896) | 27702, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composerStartRestartGroup;
            modifier3 = modifier6;
            j3 = j6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup$lambda$19(modifier3, languageEnum, function0, function1, function2, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageAnnouncementPopup$lambda$18(long j, Function0 function0, Modifier modifier, final Function0 function1, final LanguageEnum languageEnum, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C61@2622L34,63@2687L125,63@2666L146,73@2921L89,77@3052L5,78@3099L14,80@3189L3428,70@2822L3795:LanguageAnnouncementPopUp.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(34562802, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopup.<anonymous> (LanguageAnnouncementPopUp.kt:61)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1144884652, "CC(remember):LanguageAnnouncementPopUp.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1144882481, "CC(remember):LanguageAnnouncementPopUp.kt#9igjgp");
            boolean zChanged = composer.changed(j) | composer.changed(function0);
            LanguageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1 languageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1RememberedValue = composer.rememberedValue();
            if (zChanged || languageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                languageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1RememberedValue = new LanguageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1(j, function0, mutableState, null);
                composer.updateRememberedValue(languageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(unit, (Function2) languageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1RememberedValue, composer, 6);
            Modifier modifier2 = PaddingKt.padding-3ABfNKs(modifier, Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart(composer, -1144875029, "CC(remember):LanguageAnnouncementPopUp.kt#9igjgp");
            boolean zChanged2 = composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        return LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup$lambda$18$lambda$5$lambda$4(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SurfaceKt.Surface-T9BRK9s(ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue2, 15, (Object) null), AlertDialogDefaults.INSTANCE.getShape(composer, AlertDialogDefaults.$stable), AlertDialogDefaults.INSTANCE.getContainerColor(composer, AlertDialogDefaults.$stable), 0L, AlertDialogDefaults.INSTANCE.getTonalElevation-D9Ej5fM(), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(86365261, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup$lambda$18$lambda$17(languageEnum, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582912, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LanguageAnnouncementPopup$lambda$18$lambda$1(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void LanguageAnnouncementPopup$lambda$18$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageAnnouncementPopup$lambda$18$lambda$5$lambda$4(Function0 function0, MutableState mutableState) {
        LanguageAnnouncementPopup$lambda$18$lambda$2(mutableState, true);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageAnnouncementPopup$lambda$18$lambda$17(LanguageEnum languageEnum, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C86@3439L97,81@3203L3404:LanguageAnnouncementPopUp.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(86365261, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopup.<anonymous>.<anonymous> (LanguageAnnouncementPopUp.kt:81)");
            }
            Arrangement.Horizontal center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart(composer, 1392645294, "CC(remember):LanguageAnnouncementPopUp.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup$lambda$18$lambda$17$lambda$7$lambda$6((GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierGraphicsLayer);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1302618646, "C91@3594L53,92@3700L358,101@4112L358,111@4518L11,112@4601L11,118@4840L798,114@4650L1670,151@6338L40,155@6491L10,156@6555L11,153@6396L197:LanguageAnnouncementPopUp.kt#hsonup");
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("glow_transition", composer, 6, 0);
            final State stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.75f, 1.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(500, 0, EasingKt.getLinearEasing(), 2, (Object) null), RepeatMode.Reverse, 0L, 4, (Object) null), "glow_alpha", composer, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            final State stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 36.0f, 52.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(500, 0, EasingKt.getLinearEasing(), 2, (Object) null), RepeatMode.Reverse, 0L, 4, (Object) null), "glow_radius", composer, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            final long j = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU();
            final long j2 = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU();
            Alignment center2 = Alignment.Companion.getCenter();
            Modifier modifier2 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1482039143, "CC(remember):LanguageAnnouncementPopUp.kt#9igjgp");
            boolean zChanged = composer.changed(stateAnimateFloat2) | composer.changed(j) | composer.changed(stateAnimateFloat);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        return LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup$lambda$18$lambda$17$lambda$16$lambda$12$lambda$11(j, stateAnimateFloat2, stateAnimateFloat, (DrawScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierDrawBehind = DrawModifierKt.drawBehind(modifier2, (Function1) objRememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierDrawBehind);
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
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 610371761, "C140@5888L414,136@5679L623:LanguageAnnouncementPopUp.kt#hsonup");
            SurfaceKt.Surface-T9BRK9s(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), RoundedCornerShapeKt.getCircleShape(), j, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-734314328, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    return LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14(j2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582918, 120);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer, 6);
            TextKt.Text-Nvy7gAk(languageEnum.getSpeakText(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 0, 131066);
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
    public static final Unit LanguageAnnouncementPopup$lambda$18$lambda$17$lambda$7$lambda$6(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setScaleY(-1.0f);
        graphicsLayerScope.setScaleX(-1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageAnnouncementPopup$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14(long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C141@5914L366:LanguageAnnouncementPopUp.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-734314328, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopup.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LanguageAnnouncementPopUp.kt:141)");
            }
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            ComposerKt.sourceInformationMarkerStart(composer, 559382120, "C144@6115L52,142@5985L269:LanguageAnnouncementPopUp.kt#hsonup");
            IconKt.Icon-ww6aTOc(TranslateKt.getTranslate(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.conversation_change_lang_cd, composer, 0), (Modifier) null, j, composer, 0, 4);
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

    private static final float LanguageAnnouncementPopup$lambda$18$lambda$17$lambda$16$lambda$8(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float LanguageAnnouncementPopup$lambda$18$lambda$17$lambda$16$lambda$9(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageAnnouncementPopup$lambda$18$lambda$17$lambda$16$lambda$12$lambda$11(long j, State state, State state2, DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        Paint Paint = AndroidPaint_androidKt.Paint();
        android.graphics.Paint paintAsFrameworkPaint = Paint.asFrameworkPaint();
        paintAsFrameworkPaint.setMaskFilter(new BlurMaskFilter(LanguageAnnouncementPopup$lambda$18$lambda$17$lambda$16$lambda$9(state), BlurMaskFilter.Blur.NORMAL));
        paintAsFrameworkPaint.setColor(ColorKt.toArgb-8_81llA(Color.copy-wmQWz5c$default(j, LanguageAnnouncementPopup$lambda$18$lambda$17$lambda$16$lambda$8(state2), 0.0f, 0.0f, 0.0f, 14, (Object) null)));
        canvas.drawCircle-9KIMszo(drawScope.getCenter-F1C5BW0(), Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() & 4294967295L)) / 2, Paint);
        return Unit.INSTANCE;
    }
}
