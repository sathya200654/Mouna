package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.FastForwardKt;
import androidx.compose.material.icons.filled.FastRewindKt;
import androidx.compose.material.icons.filled.PauseKt;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuItemColors;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderKt;
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
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.PopupProperties;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.GrpcUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SignPracticeMediaPlayerController.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u0012\u001aA\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\f2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0003¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000eH\u0002¨\u0006#²\u0006\n\u0010$\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020\u0005X\u008a\u008e\u0002"}, d2 = {"SignPracticeMediaPlayerController", "", "modifier", "Landroidx/compose/ui/Modifier;", "isPlaying", "", "onPlayPause", "Lkotlin/Function0;", "onRewind", "onFastForward", "onSeek", "Lkotlin/Function1;", "", "duration", "", "currentPosition", "playbackSpeed", "onPlaybackSpeedChange", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;JJFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PlayerControlButton", "onClick", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "description", "", "iconSize", "Landroidx/compose/ui/unit/Dp;", "PlayerControlButton-FJfuzF0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "PlaybackSpeedControl", "currentSpeed", "onSpeedChange", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "formatDuration", "millis", "app_release", "sliderPosition", "expanded"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeMediaPlayerControllerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaybackSpeedControl$lambda$31(float f, Function1 function1, int i, Composer composer, int i2) {
        PlaybackSpeedControl(f, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayerControlButton_FJfuzF0$lambda$12(Function0 function0, ImageVector imageVector, String str, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m1853PlayerControlButtonFJfuzF0(function0, imageVector, str, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeMediaPlayerController$lambda$10(Modifier modifier, boolean z, Function0 function0, Function0 function1, Function0 function2, Function1 function3, long j, long j2, float f, Function1 function4, int i, int i2, Composer composer, int i3) {
        SignPracticeMediaPlayerController(modifier, z, function0, function1, function2, function3, j, j2, f, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SignPracticeMediaPlayerController(Modifier modifier, final boolean z, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, final Function1<? super Float, Unit> function3, final long j, final long j2, final float f, final Function1<? super Float, Unit> function4, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(function0, "onPlayPause");
        Intrinsics.checkNotNullParameter(function1, "onRewind");
        Intrinsics.checkNotNullParameter(function2, "onFastForward");
        Intrinsics.checkNotNullParameter(function3, "onSeek");
        Intrinsics.checkNotNullParameter(function4, "onPlaybackSpeedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(1742976120);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SignPracticeMediaPlayerController)P(3,2,5,7,4,8,1!1,9)67@2921L97,74@3107L38,75@3152L3689,72@3024L3817:SignPracticeMediaPlayerController.kt#1r82af");
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
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
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
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 536870912 : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1742976120, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerController (SignPracticeMediaPlayerController.kt:65)");
            }
            final State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(j > 0 ? j2 / j : 0.0f, (AnimationSpec) null, 0.0f, "sliderPosition", (Function1) null, composerStartRestartGroup, 3072, 22);
            Modifier modifier5 = modifier4;
            CardKt.Card(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), (Shape) null, (CardColors) null, CardDefaults.INSTANCE.cardElevation-aqJV_2Y(Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(476842182, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeMediaPlayerControllerKt.SignPracticeMediaPlayerController$lambda$9(function1, z, function2, function0, j2, j, function3, stateAnimateFloatAsState, f, function4, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196608, 22);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeMediaPlayerControllerKt.SignPracticeMediaPlayerController$lambda$10(modifier3, z, function0, function1, function2, function3, j, j2, f, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeMediaPlayerController$lambda$9(Function0 function0, boolean z, Function0 function1, final Function0 function2, long j, long j2, Function1 function3, final State state, float f, Function1 function4, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$Card");
        ComposerKt.sourceInformation(composer, "C76@3162L3673:SignPracticeMediaPlayerController.kt#1r82af");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(476842182, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerController.<anonymous> (SignPracticeMediaPlayerController.kt:76)");
            }
            float f2 = 8;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1081375843, "C81@3289L1749,125@5052L40,127@5106L1719:SignPracticeMediaPlayerController.kt#1r82af");
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1340174359, "C89@3654L101,86@3506L267,94@3847L885,94@3791L941,119@4904L102,116@4750L274:SignPracticeMediaPlayerController.kt#1r82af");
            m1853PlayerControlButtonFJfuzF0(function0, FastRewindKt.getFastRewind(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.sign_practice_button_cd_rewind, composer, 0), null, 0.0f, composer, 0, 24);
            CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, (FiniteAnimationSpec) null, "playPause", ComposableLambdaKt.rememberComposableLambda(-118381683, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeMediaPlayerControllerKt.SignPracticeMediaPlayerController$lambda$9$lambda$8$lambda$2$lambda$1(function2, ((Boolean) obj).booleanValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 27648, 6);
            m1853PlayerControlButtonFJfuzF0(function1, FastForwardKt.getFastForward(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.sign_practice_button_cd_forward, composer, 0), null, 0.0f, composer, 0, 24);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), composer, 6);
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default3);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1514594339, "C133@5413L94,136@5553L160,147@5938L422,142@5731L647,160@6484L10,161@6567L3,158@6396L192,164@6606L40,166@6664L147:SignPracticeMediaPlayerController.kt#1r82af");
            String duration = formatDuration(j);
            String duration2 = formatDuration(j2);
            final String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_slider_cd_seekbar, composer, 0);
            final String strStringResource2 = StringResources_androidKt.stringResource(R.string.sign_practice_slider_sd_duration, new Object[]{duration, duration2}, composer, 0);
            float fSignPracticeMediaPlayerController$lambda$0 = SignPracticeMediaPlayerController$lambda$0(state);
            Modifier modifierWeight$default = RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -48837253, "CC(remember):SignPracticeMediaPlayerController.kt#9igjgp");
            boolean zChanged = composer.changed(strStringResource) | composer.changed(strStringResource2) | composer.changed(state);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        return SignPracticeMediaPlayerControllerKt.SignPracticeMediaPlayerController$lambda$9$lambda$8$lambda$7$lambda$4$lambda$3(strStringResource, strStringResource2, state, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SliderKt.Slider(fSignPracticeMediaPlayerController$lambda$0, function3, SemanticsModifierKt.semantics$default(modifierWeight$default, false, (Function1) objRememberedValue, 1, (Object) null), false, (ClosedFloatingPointRange) null, 0, (Function0) null, (SliderColors) null, (MutableInteractionSource) null, composer, 0, 504);
            TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, -48817544, "CC(remember):SignPracticeMediaPlayerController.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return SignPracticeMediaPlayerControllerKt.SignPracticeMediaPlayerController$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.Text-Nvy7gAk(duration2, SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) objRememberedValue2), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, bodySmall, composer, 0, 0, 131068);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer, 6);
            PlaybackSpeedControl(f, function4, composer, 0);
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
    public static final Unit SignPracticeMediaPlayerController$lambda$9$lambda$8$lambda$2$lambda$1(Function0 function0, boolean z, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C:SignPracticeMediaPlayerController.kt#1r82af");
        if ((i & 6) == 0) {
            i2 = (composer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-118381683, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerController.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeMediaPlayerController.kt:95)");
            }
            if (z) {
                composer.startReplaceGroup(-540510017);
                ComposerKt.sourceInformation(composer, "100@4135L116,96@3919L358");
                m1853PlayerControlButtonFJfuzF0(function0, PauseKt.getPause(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.sign_practice_button_cd_pause, composer, 0), null, Dp.constructor-impl(48), composer, 24576, 8);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-540101220);
                ComposerKt.sourceInformation(composer, "109@4551L115,105@4331L361");
                m1853PlayerControlButtonFJfuzF0(function0, PlayArrowKt.getPlayArrow(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.sign_practice_button_cd_play, composer, 0), null, Dp.constructor-impl(48), composer, 24576, 8);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeMediaPlayerController$lambda$9$lambda$8$lambda$7$lambda$4$lambda$3(String str, String str2, State state, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(SignPracticeMediaPlayerController$lambda$0(state), RangesKt.rangeTo(0.0f, 1.0f), 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeMediaPlayerController$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$clearAndSetSemantics");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00db  */
    /* JADX WARN: Code duplicated, block: B:63:0x00df  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: PlayerControlButton-FJfuzF0, reason: not valid java name */
    private static final void m1853PlayerControlButtonFJfuzF0(final Function0<Unit> function0, final ImageVector imageVector, final String str, Modifier modifier, float f, Composer composer, final int i, final int i2) {
        Function0<Unit> function1;
        int i3;
        Modifier modifier2;
        int i4;
        float f2;
        int i5;
        boolean z;
        final float f3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1937587878);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlayerControlButton)P(4,1!1,3,2:c#ui.unit.Dp)183@7082L156,183@7031L207:SignPracticeMediaPlayerController.kt#1r82af");
        if ((i & 6) == 0) {
            function1 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            function1 = function0;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(imageVector) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    f3 = f2;
                } else {
                    if (i6 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i4 != 0) {
                        f3 = Dp.constructor-impl(32);
                    } else {
                        f3 = f2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1937587878, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.PlayerControlButton (SignPracticeMediaPlayerController.kt:182)");
                    }
                    IconButtonKt.IconButton(function1, modifier2, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(899183996, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda15
                        public final Object invoke(Object obj, Object obj2) {
                            return SignPracticeMediaPlayerControllerKt.PlayerControlButton_FJfuzF0$lambda$11(imageVector, str, f3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 1572864 | ((i3 >> 6) & 112), 60);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                modifier3 = modifier2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            return SignPracticeMediaPlayerControllerKt.PlayerControlButton_FJfuzF0$lambda$12(function0, imageVector, str, modifier3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            f2 = f;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                f3 = f2;
            } else {
                if (i6 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i4 != 0) {
                    f3 = Dp.constructor-impl(32);
                } else {
                    f3 = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1937587878, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.PlayerControlButton (SignPracticeMediaPlayerController.kt:182)");
                }
                IconButtonKt.IconButton(function1, modifier2, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(899183996, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeMediaPlayerControllerKt.PlayerControlButton_FJfuzF0$lambda$11(imageVector, str, f3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 1572864 | ((i3 >> 6) & 112), 60);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeMediaPlayerControllerKt.PlayerControlButton_FJfuzF0$lambda$12(function0, imageVector, str, modifier3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                f3 = f2;
            } else {
                if (i6 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i4 != 0) {
                    f3 = Dp.constructor-impl(32);
                } else {
                    f3 = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1937587878, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.PlayerControlButton (SignPracticeMediaPlayerController.kt:182)");
                }
                IconButtonKt.IconButton(function1, modifier2, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(899183996, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeMediaPlayerControllerKt.PlayerControlButton_FJfuzF0$lambda$11(imageVector, str, f3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 1572864 | ((i3 >> 6) & 112), 60);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeMediaPlayerControllerKt.PlayerControlButton_FJfuzF0$lambda$12(function0, imageVector, str, modifier3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        f2 = f;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            f3 = f2;
        } else {
            if (i6 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (i4 != 0) {
                f3 = Dp.constructor-impl(32);
            } else {
                f3 = f2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937587878, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.PlayerControlButton (SignPracticeMediaPlayerController.kt:182)");
            }
            IconButtonKt.IconButton(function1, modifier2, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(899183996, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeMediaPlayerControllerKt.PlayerControlButton_FJfuzF0$lambda$11(imageVector, str, f3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 1572864 | ((i3 >> 6) & 112), 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeMediaPlayerControllerKt.PlayerControlButton_FJfuzF0$lambda$12(function0, imageVector, str, modifier3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayerControlButton_FJfuzF0$lambda$11(ImageVector imageVector, String str, float f, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C184@7092L140:SignPracticeMediaPlayerController.kt#1r82af");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(899183996, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.PlayerControlButton.<anonymous> (SignPracticeMediaPlayerController.kt:184)");
            }
            IconKt.Icon-ww6aTOc(imageVector, str, SizeKt.size-3ABfNKs(Modifier.Companion, f), 0L, composer, 0, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void PlaybackSpeedControl(final float f, final Function1<? super Float, Unit> function1, Composer composer, final int i) {
        int i2;
        final MutableState mutableState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1901945622);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlaybackSpeedControl)198@7441L34,199@7518L68,202@7627L90,207@7723L1252:SignPracticeMediaPlayerController.kt#1r82af");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(f) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1901945622, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.PlaybackSpeedControl (SignPracticeMediaPlayerController.kt:196)");
            }
            final List listListOf = CollectionsKt.listOf(new Float[]{Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.25f), Float.valueOf(1.5f), Float.valueOf(1.75f)});
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1886331756, "CC(remember):SignPracticeMediaPlayerController.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_button_cd_speed, composerStartRestartGroup, 0);
            final String strStringResource2 = StringResources_androidKt.stringResource(R.string.sign_practice_button_sd_speed, new Object[]{Float.valueOf(f)}, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 503227471, "C209@7771L19,210@7834L190,215@8035L190,208@7737L488,225@8312L20,226@8343L626,223@8234L735:SignPracticeMediaPlayerController.kt#1r82af");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -122314313, "CC(remember):SignPracticeMediaPlayerController.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        return SignPracticeMediaPlayerControllerKt.PlaybackSpeedControl$lambda$30$lambda$17$lambda$16(mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -122312126, "CC(remember):SignPracticeMediaPlayerController.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strStringResource) | composerStartRestartGroup.changed(strStringResource2);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        return SignPracticeMediaPlayerControllerKt.PlaybackSpeedControl$lambda$30$lambda$19$lambda$18(strStringResource, strStringResource2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.TextButton(function0, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue3, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(469157511, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeMediaPlayerControllerKt.PlaybackSpeedControl$lambda$30$lambda$20(f, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306374, 508);
            boolean zPlaybackSpeedControl$lambda$14 = PlaybackSpeedControl$lambda$14(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -122297000, "CC(remember):SignPracticeMediaPlayerController.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                mutableState = mutableState2;
                objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda12
                    public final Object invoke() {
                        return SignPracticeMediaPlayerControllerKt.PlaybackSpeedControl$lambda$30$lambda$22$lambda$21(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                mutableState = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidMenu_androidKt.DropdownMenu-IlH_yew(zPlaybackSpeedControl$lambda$14, (Function0) objRememberedValue4, (Modifier) null, 0L, (ScrollState) null, (PopupProperties) null, (Shape) null, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1672687391, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeMediaPlayerControllerKt.PlaybackSpeedControl$lambda$30$lambda$29(listListOf, function1, f, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 48, 2044);
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeMediaPlayerControllerKt.PlaybackSpeedControl$lambda$31(f, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean PlaybackSpeedControl$lambda$14(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void PlaybackSpeedControl$lambda$15(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaybackSpeedControl$lambda$30$lambda$17$lambda$16(MutableState mutableState) {
        PlaybackSpeedControl$lambda$15(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaybackSpeedControl$lambda$30$lambda$19$lambda$18(String str, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getDropdownList-o7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaybackSpeedControl$lambda$30$lambda$20(float f, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C217@8078L123,216@8049L166:SignPracticeMediaPlayerController.kt#1r82af");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(469157511, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.PlaybackSpeedControl.<anonymous>.<anonymous> (SignPracticeMediaPlayerController.kt:216)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.sign_practice_action_speed, new Object[]{Float.valueOf(f)}, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaybackSpeedControl$lambda$30$lambda$22$lambda$21(MutableState mutableState) {
        PlaybackSpeedControl$lambda$15(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaybackSpeedControl$lambda$30$lambda$29(List list, final Function1 function1, final float f, final MutableState mutableState, ColumnScope columnScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(columnScope, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer2, "C*229@8450L202,235@8684L109,239@8845L82,228@8405L540:SignPracticeMediaPlayerController.kt#1r82af");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1672687391, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.PlaybackSpeedControl.<anonymous>.<anonymous> (SignPracticeMediaPlayerController.kt:227)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final float fFloatValue = ((Number) it.next()).floatValue();
                Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1880924148, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeMediaPlayerControllerKt.PlaybackSpeedControl$lambda$30$lambda$29$lambda$28$lambda$23(fFloatValue, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -898278959, "CC(remember):SignPracticeMediaPlayerController.kt#9igjgp");
                boolean zChanged = composer2.changed(function1) | composer2.changed(fFloatValue);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            return SignPracticeMediaPlayerControllerKt.PlaybackSpeedControl$lambda$30$lambda$29$lambda$28$lambda$25$lambda$24(function1, fFloatValue, mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(composer2, -898273834, "CC(remember):SignPracticeMediaPlayerController.kt#9igjgp");
                boolean zChanged2 = composer2.changed(fFloatValue) | composer2.changed(f);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            return SignPracticeMediaPlayerControllerKt.PlaybackSpeedControl$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26(fFloatValue, f, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                AndroidMenu_androidKt.DropdownMenuItem(function2RememberComposableLambda, function0, SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue2, 1, (Object) null), (Function2) null, (Function2) null, false, (MenuItemColors) null, (PaddingValues) null, (MutableInteractionSource) null, composer2, 6, 504);
                composer2 = composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaybackSpeedControl$lambda$30$lambda$29$lambda$28$lambda$23(float f, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C230@8488L140,229@8452L198:SignPracticeMediaPlayerController.kt#1r82af");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1880924148, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.PlaybackSpeedControl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeMediaPlayerController.kt:229)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.sign_practice_action_speed, new Object[]{Float.valueOf(f)}, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaybackSpeedControl$lambda$30$lambda$29$lambda$28$lambda$25$lambda$24(Function1 function1, float f, MutableState mutableState) {
        function1.invoke(Float.valueOf(f));
        PlaybackSpeedControl$lambda$15(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaybackSpeedControl$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26(float f, float f2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, f == f2);
        return Unit.INSTANCE;
    }

    private static final String formatDuration(long j) {
        long jCoerceAtLeast = RangesKt.coerceAtLeast(j, 0L);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(jCoerceAtLeast);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(jCoerceAtLeast) - TimeUnit.MINUTES.toSeconds(minutes);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private static final float SignPracticeMediaPlayerController$lambda$0(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }
}
