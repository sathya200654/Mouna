package androidx.wear.compose.material.dialog;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt;
import androidx.wear.compose.foundation.SwipeToDismissBoxState;
import androidx.wear.compose.foundation.lazy.ScalingLazyListState;
import androidx.wear.compose.foundation.lazy.ScalingLazyListStateKt;
import androidx.wear.compose.material.AnimationKt;
import androidx.wear.compose.material.MaterialTheme;
import androidx.wear.compose.material.PositionIndicatorKt;
import androidx.wear.compose.material.ScaffoldKt;
import androidx.wear.compose.material.SwipeToDismissBoxKt;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Dialog.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a]\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000bH\u0003¢\u0006\u0002\u0010\r\u001aV\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0010\u001aV\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0012\u001a!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0003¢\u0006\u0002\u0010\u0019\u001a!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0003¢\u0006\u0002\u0010\u0019\u001a!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0003¢\u0006\u0002\u0010\u0019¨\u0006\u001c²\u0006\u0010\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eX\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"Dialog", "", "showDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "positionIndicator", "Landroidx/compose/runtime/Composable;", "content", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "scrollState", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroidx/wear/compose/material/ScalingLazyListState;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/wear/compose/material/ScalingLazyListState;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "animateBackgroundScrimAlpha", "Landroidx/compose/runtime/State;", "", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/wear/compose/material/dialog/DialogVisibility;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateContentAlpha", "animateDialogScale", "compose-material_release", "transitionState", "Landroidx/compose/animation/core/MutableTransitionState;", "pendingOnDismissCall", "backgroundScrimAlpha", "contentAlpha", "scale"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Dialog_androidKt {

    /* JADX INFO: compiled from: Dialog.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DialogVisibility.values().length];
            try {
                iArr[DialogVisibility.Hide.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DialogVisibility.Display.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x015e  */
    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0110  */
    /* JADX WARN: Code duplicated, block: B:94:0x011b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0152  */
    public static final void Dialog(final boolean z, final Function0<Unit> function0, Modifier modifier, ScalingLazyListState scalingLazyListState, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function0<Unit> function1;
        final Modifier modifier2;
        final ScalingLazyListState scalingLazyListState2;
        int i4;
        DialogProperties dialogProperties2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function3;
        int i6;
        Modifier modifier3;
        final ScalingLazyListState scalingLazyListStateRememberScalingLazyListState;
        Modifier modifier4;
        DialogProperties dialogProperties3;
        final DialogProperties dialogProperties4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(219283926);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Dialog)P(5,2,1,4,3)85@3988L30,94@4296L59,89@4120L268:Dialog.android.kt#iw0lpz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function1 = function0;
        } else {
            function1 = function0;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
        }
        int i8 = i2 & 4;
        if (i8 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    scalingLazyListState2 = scalingLazyListState;
                    if (composerStartRestartGroup.changed(scalingLazyListState2)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i7;
                } else {
                    scalingLazyListState2 = scalingLazyListState;
                }
                i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i7;
            } else {
                scalingLazyListState2 = scalingLazyListState;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                    function3 = function2;
                } else {
                    function3 = function2;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i6 = 131072;
                        } else {
                            i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i6;
                    }
                }
                if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        modifier4 = modifier2;
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    } else {
                        if (i8 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 8) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -7169;
                        } else {
                            scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            modifier4 = modifier3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:88)");
                        }
                        Dialog(z2, function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.1
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i9) {
                                ComposerKt.sourceInformation(composer2, "C94@4323L30:Dialog.android.kt#iw0lpz");
                                if ((i9 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:94)");
                                }
                                ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                                if (scalingLazyListState3 != null) {
                                    PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, composer2, 0, 62);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        modifier2 = modifier4;
                        dialogProperties4 = dialogProperties3;
                    }
                    dialogProperties3 = dialogProperties2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:88)");
                    }
                    Dialog(z2, function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.1
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            ComposerKt.sourceInformation(composer2, "C94@4323L30:Dialog.android.kt#iw0lpz");
                            if ((i9 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:94)");
                            }
                            ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                            if (scalingLazyListState3 != null) {
                                PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, composer2, 0, 62);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                    modifier2 = modifier4;
                    dialogProperties4 = dialogProperties3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    dialogProperties4 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            Dialog_androidKt.Dialog(z, function0, modifier2, scalingLazyListState2, dialogProperties4, (Function2<? super Composer, ? super Integer, Unit>) function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            dialogProperties2 = dialogProperties;
            if ((i2 & 32) != 0) {
                i3 |= 196608;
                function3 = function2;
            } else {
                function3 = function2;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 131072;
                    } else {
                        i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i6;
                }
            }
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:88)");
                }
                Dialog(z2, function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.1
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C94@4323L30:Dialog.android.kt#iw0lpz");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:94)");
                        }
                        ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                        if (scalingLazyListState3 != null) {
                            PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, composer2, 0, 62);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                modifier2 = modifier4;
                dialogProperties4 = dialogProperties3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:88)");
                }
                Dialog(z2, function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.1
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C94@4323L30:Dialog.android.kt#iw0lpz");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:94)");
                        }
                        ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                        if (scalingLazyListState3 != null) {
                            PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, composer2, 0, 62);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                modifier2 = modifier4;
                dialogProperties4 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        Dialog_androidKt.Dialog(z, function0, modifier2, scalingLazyListState2, dialogProperties4, (Function2<? super Composer, ? super Integer, Unit>) function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                scalingLazyListState2 = scalingLazyListState;
                if (composerStartRestartGroup.changed(scalingLazyListState2)) {
                    i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i7;
            } else {
                scalingLazyListState2 = scalingLazyListState;
            }
            i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i7;
        } else {
            scalingLazyListState2 = scalingLazyListState;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                dialogProperties2 = dialogProperties;
                if (composerStartRestartGroup.changed(dialogProperties2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i2 & 32) != 0) {
                i3 |= 196608;
                function3 = function2;
            } else {
                function3 = function2;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 131072;
                    } else {
                        i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i6;
                }
            }
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:88)");
                }
                Dialog(z2, function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.1
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C94@4323L30:Dialog.android.kt#iw0lpz");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:94)");
                        }
                        ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                        if (scalingLazyListState3 != null) {
                            PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, composer2, 0, 62);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                modifier2 = modifier4;
                dialogProperties4 = dialogProperties3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:88)");
                }
                Dialog(z2, function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.1
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C94@4323L30:Dialog.android.kt#iw0lpz");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:94)");
                        }
                        ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                        if (scalingLazyListState3 != null) {
                            PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, composer2, 0, 62);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                modifier2 = modifier4;
                dialogProperties4 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        Dialog_androidKt.Dialog(z, function0, modifier2, scalingLazyListState2, dialogProperties4, (Function2<? super Composer, ? super Integer, Unit>) function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        dialogProperties2 = dialogProperties;
        if ((i2 & 32) != 0) {
            i3 |= 196608;
            function3 = function2;
        } else {
            function3 = function2;
            if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 131072;
                } else {
                    i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i6;
            }
        }
        if ((74899 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -7169;
                } else {
                    scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    modifier4 = modifier3;
                    dialogProperties3 = dialogProperties2;
                }
            } else {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -7169;
                } else {
                    scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    modifier4 = modifier3;
                    dialogProperties3 = dialogProperties2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:88)");
            }
            Dialog(z2, function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.1
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    ComposerKt.sourceInformation(composer2, "C94@4323L30:Dialog.android.kt#iw0lpz");
                    if ((i9 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:94)");
                    }
                    ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                    if (scalingLazyListState3 != null) {
                        PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, composer2, 0, 62);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
            modifier2 = modifier4;
            dialogProperties4 = dialogProperties3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -7169;
                } else {
                    scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    modifier4 = modifier3;
                    dialogProperties3 = dialogProperties2;
                }
            } else {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -7169;
                } else {
                    scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    modifier4 = modifier3;
                    dialogProperties3 = dialogProperties2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:88)");
            }
            Dialog(z2, function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.1
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    ComposerKt.sourceInformation(composer2, "C94@4323L30:Dialog.android.kt#iw0lpz");
                    if ((i9 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:94)");
                    }
                    ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                    if (scalingLazyListState3 != null) {
                        PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, (AnimationSpec<Float>) null, composer2, 0, 62);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
            modifier2 = modifier4;
            dialogProperties4 = dialogProperties3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    Dialog_androidKt.Dialog(z, function0, modifier2, scalingLazyListState2, dialogProperties4, (Function2<? super Composer, ? super Integer, Unit>) function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x015e  */
    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0110  */
    /* JADX WARN: Code duplicated, block: B:94:0x011b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0152  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is provided for backwards compatibility with Compose for Wear OS 1.1.A newer overload is available which uses ScalingLazyListState from wear.compose.foundation.lazy package")
    public static final /* synthetic */ void Dialog(final boolean z, final Function0 function0, Modifier modifier, androidx.wear.compose.material.ScalingLazyListState scalingLazyListState, DialogProperties dialogProperties, final Function2 function2, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function0 function1;
        final Modifier modifier2;
        final androidx.wear.compose.material.ScalingLazyListState scalingLazyListState2;
        int i4;
        DialogProperties dialogProperties2;
        int i5;
        Function2 function3;
        int i6;
        Modifier modifier3;
        final androidx.wear.compose.material.ScalingLazyListState scalingLazyListStateRememberScalingLazyListState;
        Modifier modifier4;
        DialogProperties dialogProperties3;
        final DialogProperties dialogProperties4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(219283926);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Dialog)P(5,2,1,4,3)136@6288L30,145@6596L59,140@6420L268:Dialog.android.kt#iw0lpz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function1 = function0;
        } else {
            function1 = function0;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
        }
        int i8 = i2 & 4;
        if (i8 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    scalingLazyListState2 = scalingLazyListState;
                    if (composerStartRestartGroup.changed(scalingLazyListState2)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i7;
                } else {
                    scalingLazyListState2 = scalingLazyListState;
                }
                i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i7;
            } else {
                scalingLazyListState2 = scalingLazyListState;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                    function3 = function2;
                } else {
                    function3 = function2;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i6 = 131072;
                        } else {
                            i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i6;
                    }
                }
                if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        modifier4 = modifier2;
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    } else {
                        if (i8 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 8) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -7169;
                        } else {
                            scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                        }
                        if (i4 != 0) {
                            modifier4 = modifier3;
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            modifier4 = modifier3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:139)");
                        }
                        Dialog(z2, (Function0<Unit>) function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.3
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i9) {
                                ComposerKt.sourceInformation(composer2, "C145@6623L30:Dialog.android.kt#iw0lpz");
                                if ((i9 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:145)");
                                }
                                androidx.wear.compose.material.ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                                if (scalingLazyListState3 != null) {
                                    PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, composer2, 0, 6);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        modifier2 = modifier4;
                        dialogProperties4 = dialogProperties3;
                    }
                    dialogProperties3 = dialogProperties2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:139)");
                    }
                    Dialog(z2, (Function0<Unit>) function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.3
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            ComposerKt.sourceInformation(composer2, "C145@6623L30:Dialog.android.kt#iw0lpz");
                            if ((i9 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:145)");
                            }
                            androidx.wear.compose.material.ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                            if (scalingLazyListState3 != null) {
                                PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, composer2, 0, 6);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                    modifier2 = modifier4;
                    dialogProperties4 = dialogProperties3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    dialogProperties4 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            Dialog_androidKt.Dialog(z, function0, modifier2, scalingLazyListState2, dialogProperties4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            dialogProperties2 = dialogProperties;
            if ((i2 & 32) != 0) {
                i3 |= 196608;
                function3 = function2;
            } else {
                function3 = function2;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 131072;
                    } else {
                        i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i6;
                }
            }
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:139)");
                }
                Dialog(z2, (Function0<Unit>) function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.3
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C145@6623L30:Dialog.android.kt#iw0lpz");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:145)");
                        }
                        androidx.wear.compose.material.ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                        if (scalingLazyListState3 != null) {
                            PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, composer2, 0, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                modifier2 = modifier4;
                dialogProperties4 = dialogProperties3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:139)");
                }
                Dialog(z2, (Function0<Unit>) function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.3
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C145@6623L30:Dialog.android.kt#iw0lpz");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:145)");
                        }
                        androidx.wear.compose.material.ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                        if (scalingLazyListState3 != null) {
                            PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, composer2, 0, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                modifier2 = modifier4;
                dialogProperties4 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        Dialog_androidKt.Dialog(z, function0, modifier2, scalingLazyListState2, dialogProperties4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                scalingLazyListState2 = scalingLazyListState;
                if (composerStartRestartGroup.changed(scalingLazyListState2)) {
                    i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i7;
            } else {
                scalingLazyListState2 = scalingLazyListState;
            }
            i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i7;
        } else {
            scalingLazyListState2 = scalingLazyListState;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                dialogProperties2 = dialogProperties;
                if (composerStartRestartGroup.changed(dialogProperties2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i2 & 32) != 0) {
                i3 |= 196608;
                function3 = function2;
            } else {
                function3 = function2;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 131072;
                    } else {
                        i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i6;
                }
            }
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:139)");
                }
                Dialog(z2, (Function0<Unit>) function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.3
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C145@6623L30:Dialog.android.kt#iw0lpz");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:145)");
                        }
                        androidx.wear.compose.material.ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                        if (scalingLazyListState3 != null) {
                            PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, composer2, 0, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                modifier2 = modifier4;
                dialogProperties4 = dialogProperties3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -7169;
                    } else {
                        scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                    }
                    if (i4 != 0) {
                        modifier4 = modifier3;
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        modifier4 = modifier3;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:139)");
                }
                Dialog(z2, (Function0<Unit>) function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.3
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C145@6623L30:Dialog.android.kt#iw0lpz");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:145)");
                        }
                        androidx.wear.compose.material.ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                        if (scalingLazyListState3 != null) {
                            PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, composer2, 0, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                modifier2 = modifier4;
                dialogProperties4 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        Dialog_androidKt.Dialog(z, function0, modifier2, scalingLazyListState2, dialogProperties4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        dialogProperties2 = dialogProperties;
        if ((i2 & 32) != 0) {
            i3 |= 196608;
            function3 = function2;
        } else {
            function3 = function2;
            if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 131072;
                } else {
                    i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i6;
            }
        }
        if ((74899 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -7169;
                } else {
                    scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    modifier4 = modifier3;
                    dialogProperties3 = dialogProperties2;
                }
            } else {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -7169;
                } else {
                    scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    modifier4 = modifier3;
                    dialogProperties3 = dialogProperties2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:139)");
            }
            Dialog(z2, (Function0<Unit>) function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.3
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    ComposerKt.sourceInformation(composer2, "C145@6623L30:Dialog.android.kt#iw0lpz");
                    if ((i9 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:145)");
                    }
                    androidx.wear.compose.material.ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                    if (scalingLazyListState3 != null) {
                        PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, composer2, 0, 6);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
            modifier2 = modifier4;
            dialogProperties4 = dialogProperties3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -7169;
                } else {
                    scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    modifier4 = modifier3;
                    dialogProperties3 = dialogProperties2;
                }
            } else {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = androidx.wear.compose.material.ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -7169;
                } else {
                    scalingLazyListStateRememberScalingLazyListState = scalingLazyListState2;
                }
                if (i4 != 0) {
                    modifier4 = modifier3;
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    modifier4 = modifier3;
                    dialogProperties3 = dialogProperties2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(219283926, i3, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:139)");
            }
            Dialog(z2, (Function0<Unit>) function1, modifier4, dialogProperties3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(323447855, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.3
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    ComposerKt.sourceInformation(composer2, "C145@6623L30:Dialog.android.kt#iw0lpz");
                    if ((i9 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(323447855, i9, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:145)");
                    }
                    androidx.wear.compose.material.ScalingLazyListState scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                    if (scalingLazyListState3 != null) {
                        PositionIndicatorKt.PositionIndicator(scalingLazyListState3, (Modifier) null, false, composer2, 0, 6);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) function3, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | (i3 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
            modifier2 = modifier4;
            dialogProperties4 = dialogProperties3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    Dialog_androidKt.Dialog(z, function0, modifier2, scalingLazyListState2, dialogProperties4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x019b  */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:40:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:54:0x0094  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00da  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:85:0x010b  */
    /* JADX WARN: Code duplicated, block: B:88:0x013c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0150  */
    /* JADX WARN: Code duplicated, block: B:95:0x015d  */
    /* JADX WARN: Code duplicated, block: B:98:0x018f  */
    public static final void Dialog(final boolean z, final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function1;
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        DialogProperties dialogProperties2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i9;
        int i10;
        Modifier modifier3;
        DialogProperties dialogProperties3;
        Object objRememberedValue;
        MutableState mutableState;
        Transition transitionRememberTransition;
        Object objRememberedValue2;
        MutableState mutableState2;
        Composer composer2;
        DialogProperties dialogProperties4;
        Composer composer3;
        final Modifier modifier4;
        final DialogProperties dialogProperties5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-367054652);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Dialog)P(5,2,1,4,3)164@7212L86,167@7320L35,169@7389L46,177@7626L3076,174@7522L3180:Dialog.android.kt#iw0lpz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) == 0) {
            if ((i & 48) == 0) {
                function1 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        dialogProperties2 = dialogProperties;
                        if (composerStartRestartGroup.changed(dialogProperties2)) {
                            i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                        } else {
                            i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                        }
                        i3 |= i7;
                    }
                    if ((i2 & 16) != 0) {
                        if ((i & 24576) == 0) {
                            function4 = function2;
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i8 = 16384;
                            } else {
                                i8 = 8192;
                            }
                            i3 |= i8;
                        }
                        if ((i2 & 32) != 0) {
                            if ((i & 196608) == 0) {
                                function5 = function3;
                                if (composerStartRestartGroup.changedInstance(function5)) {
                                    i9 = 131072;
                                } else {
                                    i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                                }
                                i3 |= i9;
                            }
                            i10 = i3;
                            if ((74899 & i10) == 74898 || !composerStartRestartGroup.getSkipping()) {
                                if (i4 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i6 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties2;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableState = (MutableState) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                mutableState2 = (MutableState) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (!z || transitionRememberTransition.getCurrentState() == DialogVisibility.Display) {
                                    composer2 = composerStartRestartGroup;
                                    dialogProperties4 = dialogProperties3;
                                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    dialogProperties4 = dialogProperties3;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3 = composer2;
                                modifier4 = modifier3;
                                dialogProperties5 = dialogProperties4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier4 = modifier2;
                                dialogProperties5 = dialogProperties2;
                                composer3 = composerStartRestartGroup;
                            }
                            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i11) {
                                        Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                            }
                        }
                        i3 |= 196608;
                        function5 = function3;
                        i10 = i3;
                        if ((74899 & i10) == 74898) {
                            if (i4 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i6 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z) {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            } else {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            dialogProperties5 = dialogProperties4;
                        } else {
                            if (i4 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i6 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z) {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            } else {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            dialogProperties5 = dialogProperties4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i11) {
                                    Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    function4 = function2;
                    if ((i2 & 32) != 0) {
                        if ((i & 196608) == 0) {
                            function5 = function3;
                            if (composerStartRestartGroup.changedInstance(function5)) {
                                i9 = 131072;
                            } else {
                                i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                            i3 |= i9;
                        }
                        i10 = i3;
                        if ((74899 & i10) == 74898) {
                            if (i4 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i6 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z) {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            } else {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            dialogProperties5 = dialogProperties4;
                        } else {
                            if (i4 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i6 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z) {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            } else {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            dialogProperties5 = dialogProperties4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i11) {
                                    Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 196608;
                    function5 = function3;
                    i10 = i3;
                    if ((74899 & i10) == 74898) {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 3072;
                dialogProperties2 = dialogProperties;
                if ((i2 & 16) != 0) {
                    if ((i & 24576) == 0) {
                        function4 = function2;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((i2 & 32) != 0) {
                        if ((i & 196608) == 0) {
                            function5 = function3;
                            if (composerStartRestartGroup.changedInstance(function5)) {
                                i9 = 131072;
                            } else {
                                i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                            i3 |= i9;
                        }
                        i10 = i3;
                        if ((74899 & i10) == 74898) {
                            if (i4 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i6 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z) {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            } else {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            dialogProperties5 = dialogProperties4;
                        } else {
                            if (i4 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i6 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z) {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            } else {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            dialogProperties5 = dialogProperties4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i11) {
                                    Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 196608;
                    function5 = function3;
                    i10 = i3;
                    if ((74899 & i10) == 74898) {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                function4 = function2;
                if ((i2 & 32) != 0) {
                    if ((i & 196608) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((74899 & i10) == 74898) {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                function5 = function3;
                i10 = i3;
                if ((74899 & i10) == 74898) {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i11) {
                            Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            modifier2 = modifier;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i7;
                }
                if ((i2 & 16) != 0) {
                    if ((i & 24576) == 0) {
                        function4 = function2;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((i2 & 32) != 0) {
                        if ((i & 196608) == 0) {
                            function5 = function3;
                            if (composerStartRestartGroup.changedInstance(function5)) {
                                i9 = 131072;
                            } else {
                                i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                            i3 |= i9;
                        }
                        i10 = i3;
                        if ((74899 & i10) == 74898) {
                            if (i4 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i6 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z) {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            } else {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            dialogProperties5 = dialogProperties4;
                        } else {
                            if (i4 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i6 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z) {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            } else {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            dialogProperties5 = dialogProperties4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i11) {
                                    Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 196608;
                    function5 = function3;
                    i10 = i3;
                    if ((74899 & i10) == 74898) {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                function4 = function2;
                if ((i2 & 32) != 0) {
                    if ((i & 196608) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((74899 & i10) == 74898) {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                function5 = function3;
                i10 = i3;
                if ((74899 & i10) == 74898) {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i11) {
                            Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            dialogProperties2 = dialogProperties;
            if ((i2 & 16) != 0) {
                if ((i & 24576) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i2 & 32) != 0) {
                    if ((i & 196608) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((74899 & i10) == 74898) {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                function5 = function3;
                i10 = i3;
                if ((74899 & i10) == 74898) {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i11) {
                            Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function4 = function2;
            if ((i2 & 32) != 0) {
                if ((i & 196608) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((74899 & i10) == 74898) {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i11) {
                            Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            function5 = function3;
            i10 = i3;
            if ((74899 & i10) == 74898) {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z) {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                } else {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3 = composer2;
                modifier4 = modifier3;
                dialogProperties5 = dialogProperties4;
            } else {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z) {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                } else {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3 = composer2;
                modifier4 = modifier3;
                dialogProperties5 = dialogProperties4;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i11) {
                        Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        function1 = function0;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i7;
                }
                if ((i2 & 16) != 0) {
                    if ((i & 24576) == 0) {
                        function4 = function2;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((i2 & 32) != 0) {
                        if ((i & 196608) == 0) {
                            function5 = function3;
                            if (composerStartRestartGroup.changedInstance(function5)) {
                                i9 = 131072;
                            } else {
                                i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                            i3 |= i9;
                        }
                        i10 = i3;
                        if ((74899 & i10) == 74898) {
                            if (i4 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i6 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z) {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            } else {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            dialogProperties5 = dialogProperties4;
                        } else {
                            if (i4 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i6 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z) {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            } else {
                                composer2 = composerStartRestartGroup;
                                dialogProperties4 = dialogProperties3;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            dialogProperties5 = dialogProperties4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i11) {
                                    Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 196608;
                    function5 = function3;
                    i10 = i3;
                    if ((74899 & i10) == 74898) {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                function4 = function2;
                if ((i2 & 32) != 0) {
                    if ((i & 196608) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((74899 & i10) == 74898) {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                function5 = function3;
                i10 = i3;
                if ((74899 & i10) == 74898) {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i11) {
                            Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            dialogProperties2 = dialogProperties;
            if ((i2 & 16) != 0) {
                if ((i & 24576) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i2 & 32) != 0) {
                    if ((i & 196608) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((74899 & i10) == 74898) {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                function5 = function3;
                i10 = i3;
                if ((74899 & i10) == 74898) {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i11) {
                            Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function4 = function2;
            if ((i2 & 32) != 0) {
                if ((i & 196608) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((74899 & i10) == 74898) {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i11) {
                            Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            function5 = function3;
            i10 = i3;
            if ((74899 & i10) == 74898) {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z) {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                } else {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3 = composer2;
                modifier4 = modifier3;
                dialogProperties5 = dialogProperties4;
            } else {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z) {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                } else {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3 = composer2;
                modifier4 = modifier3;
                dialogProperties5 = dialogProperties4;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i11) {
                        Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                dialogProperties2 = dialogProperties;
                if (composerStartRestartGroup.changed(dialogProperties2)) {
                    i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i7;
            }
            if ((i2 & 16) != 0) {
                if ((i & 24576) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i2 & 32) != 0) {
                    if ((i & 196608) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((74899 & i10) == 74898) {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        if (i4 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i6 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z) {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        } else {
                            composer2 = composerStartRestartGroup;
                            dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3 = composer2;
                        modifier4 = modifier3;
                        dialogProperties5 = dialogProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i11) {
                                Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                function5 = function3;
                i10 = i3;
                if ((74899 & i10) == 74898) {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i11) {
                            Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function4 = function2;
            if ((i2 & 32) != 0) {
                if ((i & 196608) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((74899 & i10) == 74898) {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i11) {
                            Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            function5 = function3;
            i10 = i3;
            if ((74899 & i10) == 74898) {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z) {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                } else {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3 = composer2;
                modifier4 = modifier3;
                dialogProperties5 = dialogProperties4;
            } else {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z) {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                } else {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3 = composer2;
                modifier4 = modifier3;
                dialogProperties5 = dialogProperties4;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i11) {
                        Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        dialogProperties2 = dialogProperties;
        if ((i2 & 16) != 0) {
            if ((i & 24576) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((i2 & 32) != 0) {
                if ((i & 196608) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((74899 & i10) == 74898) {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i4 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i6 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z) {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    } else {
                        composer2 = composerStartRestartGroup;
                        dialogProperties4 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    dialogProperties5 = dialogProperties4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i11) {
                            Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            function5 = function3;
            i10 = i3;
            if ((74899 & i10) == 74898) {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z) {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                } else {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3 = composer2;
                modifier4 = modifier3;
                dialogProperties5 = dialogProperties4;
            } else {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z) {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                } else {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3 = composer2;
                modifier4 = modifier3;
                dialogProperties5 = dialogProperties4;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i11) {
                        Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        function4 = function2;
        if ((i2 & 32) != 0) {
            if ((i & 196608) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i9 = 131072;
                } else {
                    i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i9;
            }
            i10 = i3;
            if ((74899 & i10) == 74898) {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z) {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                } else {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3 = composer2;
                modifier4 = modifier3;
                dialogProperties5 = dialogProperties4;
            } else {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z) {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                } else {
                    composer2 = composerStartRestartGroup;
                    dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3 = composer2;
                modifier4 = modifier3;
                dialogProperties5 = dialogProperties4;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i11) {
                        Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 196608;
        function5 = function3;
        i10 = i3;
        if ((74899 & i10) == 74898) {
            if (i4 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i6 != 0) {
                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
            } else {
                dialogProperties3 = dialogProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z) {
                composer2 = composerStartRestartGroup;
                dialogProperties4 = dialogProperties3;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
            } else {
                composer2 = composerStartRestartGroup;
                dialogProperties4 = dialogProperties3;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer3 = composer2;
            modifier4 = modifier3;
            dialogProperties5 = dialogProperties4;
        } else {
            if (i4 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i6 != 0) {
                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
            } else {
                dialogProperties3 = dialogProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-367054652, i10, -1, "androidx.wear.compose.material.dialog.Dialog (Dialog.android.kt:162)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827721853, "CC(remember):Dialog.android.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(new MutableTransitionState(DialogVisibility.Hide), (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            transitionRememberTransition = TransitionKt.rememberTransition(Dialog$lambda$1(mutableState), (String) null, composerStartRestartGroup, MutableTransitionState.$stable, 2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827716229, "CC(remember):Dialog.android.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z) {
                composer2 = composerStartRestartGroup;
                dialogProperties4 = dialogProperties3;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
            } else {
                composer2 = composerStartRestartGroup;
                dialogProperties4 = dialogProperties3;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-899574702, true, new AnonymousClass5(transitionRememberTransition, modifier3, z, function1, mutableState, function5, function4, mutableState2), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 384 | ((i10 >> 6) & 112), 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer3 = composer2;
            modifier4 = modifier3;
            dialogProperties5 = dialogProperties4;
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i11) {
                    Dialog_androidKt.Dialog(z, function0, modifier4, dialogProperties5, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableTransitionState<DialogVisibility> Dialog$lambda$1(MutableState<MutableTransitionState<DialogVisibility>> mutableState) {
        return (MutableTransitionState) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Dialog$lambda$4(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dialog$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.dialog.Dialog_androidKt$Dialog$5, reason: invalid class name */
    /* JADX INFO: compiled from: Dialog.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass5 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function0<Unit> $onDismissRequest;
        final /* synthetic */ MutableState<Boolean> $pendingOnDismissCall$delegate;
        final /* synthetic */ Function2<Composer, Integer, Unit> $positionIndicator;
        final /* synthetic */ boolean $showDialog;
        final /* synthetic */ Transition<DialogVisibility> $transition;
        final /* synthetic */ MutableState<MutableTransitionState<DialogVisibility>> $transitionState$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Transition<DialogVisibility> transition, Modifier modifier, boolean z, Function0<Unit> function0, MutableState<MutableTransitionState<DialogVisibility>> mutableState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, MutableState<Boolean> mutableState2) {
            super(2);
            this.$transition = transition;
            this.$modifier = modifier;
            this.$showDialog = z;
            this.$onDismissRequest = function0;
            this.$transitionState$delegate = mutableState;
            this.$content = function2;
            this.$positionIndicator = function3;
            this.$pendingOnDismissCall$delegate = mutableState2;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final void invoke(Composer composer, int i) throws NoWhenBranchMatchedException {
            ComposerKt.sourceInformation(composer, "C179@7669L39,180@7741L31,181@7798L30,183@7878L667,199@8598L1123,182@7841L1880,226@9761L467,226@9734L494,237@10287L405,237@10242L450:Dialog.android.kt#iw0lpz");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-899574702, i, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous> (Dialog.android.kt:179)");
                }
                final State stateAnimateBackgroundScrimAlpha = Dialog_androidKt.animateBackgroundScrimAlpha(this.$transition, composer, 0);
                final State stateAnimateContentAlpha = Dialog_androidKt.animateContentAlpha(this.$transition, composer, 0);
                final State stateAnimateDialogScale = Dialog_androidKt.animateDialogScale(this.$transition, composer, 0);
                Modifier modifier = this.$modifier;
                final Transition<DialogVisibility> transition = this.$transition;
                Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-444205042, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.5.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i2) {
                        ComposerKt.sourceInformation(composer2, "C184@7900L627:Dialog.android.kt#iw0lpz");
                        if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-444205042, i2, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous>.<anonymous> (Dialog.android.kt:184)");
                            }
                            AnimatedVisibilityKt.AnimatedVisibility(transition.getTargetState() == DialogVisibility.Display, (Modifier) null, EnterExitTransitionKt.fadeIn$default(new TweenSpec(400, 0, AnimationKt.getSTANDARD_IN(), 2, (DefaultConstructorMarker) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(new TweenSpec(400, 0, AnimationKt.getSTANDARD_OUT(), 2, (DefaultConstructorMarker) null), 0.0f, 2, (Object) null), (String) null, ComposableSingletons$Dialog_androidKt.INSTANCE.m882getLambda1$compose_material_release(), composer2, 200064, 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composer, 54);
                final Function0<Unit> function0 = this.$onDismissRequest;
                final MutableState<MutableTransitionState<DialogVisibility>> mutableState = this.$transitionState$delegate;
                final Function2<Composer, Integer, Unit> function2 = this.$content;
                final Function2<Composer, Integer, Unit> function3 = this.$positionIndicator;
                ScaffoldKt.Scaffold(modifier, function2RememberComposableLambda, null, null, null, ComposableLambdaKt.rememberComposableLambda(-297279350, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.5.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i2) {
                        ComposerKt.sourceInformation(composer2, "C201@8663L32,207@8943L233,212@9195L512,200@8616L1091:Dialog.android.kt#iw0lpz");
                        if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-297279350, i2, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous>.<anonymous> (Dialog.android.kt:200)");
                            }
                            SwipeToDismissBoxState swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composer2, 0, 3);
                            Modifier modifier2 = Modifier.Companion;
                            Modifier modifier3 = modifier2;
                            Modifier modifier4 = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(modifier3, AnonymousClass5.invoke$lambda$2(stateAnimateDialogScale), AnonymousClass5.invoke$lambda$2(stateAnimateDialogScale), AnonymousClass5.invoke$lambda$0(stateAnimateBackgroundScrimAlpha), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 131064, (Object) null);
                            ComposerKt.sourceInformationMarkerStart(composer2, 1925732084, "CC(remember):Dialog.android.kt#9igjgp");
                            boolean zChanged = composer2.changed(function0);
                            final Function0<Unit> function1 = function0;
                            final MutableState<MutableTransitionState<DialogVisibility>> mutableState2 = mutableState;
                            Object objRememberedValue = composer2.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt$Dialog$5$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m904invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m904invoke() {
                                        function1.invoke();
                                        mutableState2.setValue(new MutableTransitionState(DialogVisibility.Hide));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            final State<Float> state = stateAnimateContentAlpha;
                            final Function2<Composer, Integer, Unit> function4 = function2;
                            final Function2<Composer, Integer, Unit> function5 = function3;
                            SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI((Function0<Unit>) objRememberedValue, modifier4, swipeToDismissBoxStateRememberSwipeToDismissBoxState, 0L, 0L, (Object) null, (Object) null, false, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1642620898, true, new Function4<BoxScope, Boolean, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.Dialog.5.2.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(4);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    invoke((BoxScope) obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(BoxScope boxScope, boolean z, Composer composer3, int i3) {
                                    int i4;
                                    ComposerKt.sourceInformation(composer3, "C218@9509L6,214@9278L389:Dialog.android.kt#iw0lpz");
                                    if ((i3 & 6) == 0) {
                                        i4 = i3 | (composer3.changed(boxScope) ? 4 : 2);
                                    } else {
                                        i4 = i3;
                                    }
                                    if ((i3 & 48) == 0) {
                                        i4 |= composer3.changed(z) ? 32 : 16;
                                    }
                                    if ((i4 & 147) != 146 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1642620898, i4, -1, "androidx.wear.compose.material.dialog.Dialog.<anonymous>.<anonymous>.<anonymous> (Dialog.android.kt:213)");
                                        }
                                        if (!z) {
                                            Modifier modifier5 = BackgroundKt.background-bw27NRU$default(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(boxScope.matchParentSize(Modifier.Companion), 0.0f, 0.0f, AnonymousClass5.invoke$lambda$1(state), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 131067, (Object) null), MaterialTheme.INSTANCE.getColors(composer3, 6).getBackground(), (Shape) null, 2, (Object) null);
                                            Function2<Composer, Integer, Unit> function6 = function4;
                                            Function2<Composer, Integer, Unit> function7 = function5;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifier5);
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer composer4 = Updater.constructor-impl(composer3);
                                            Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composer4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, -683128479, "C220@9584L9,221@9622L19:Dialog.android.kt#iw0lpz");
                                            function6.invoke(composer3, 0);
                                            function7.invoke(composer3, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54), composer2, 100663296, 248);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composer, 54), composer, 196656, 28);
                Boolean boolValueOf = Boolean.valueOf(this.$showDialog);
                ComposerKt.sourceInformationMarkerStart(composer, 1878941215, "CC(remember):Dialog.android.kt#9igjgp");
                boolean zChanged = composer.changed(this.$showDialog);
                boolean z = this.$showDialog;
                MutableState<MutableTransitionState<DialogVisibility>> mutableState2 = this.$transitionState$delegate;
                MutableState<Boolean> mutableState3 = this.$pendingOnDismissCall$delegate;
                Dialog_androidKt$Dialog$5$3$1 dialog_androidKt$Dialog$5$3$1RememberedValue = composer.rememberedValue();
                if (zChanged || dialog_androidKt$Dialog$5$3$1RememberedValue == Composer.Companion.getEmpty()) {
                    dialog_androidKt$Dialog$5$3$1RememberedValue = new Dialog_androidKt$Dialog$5$3$1(z, mutableState2, mutableState3, null);
                    composer.updateRememberedValue(dialog_androidKt$Dialog$5$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2) dialog_androidKt$Dialog$5$3$1RememberedValue, composer, 0);
                Object currentState = Dialog_androidKt.Dialog$lambda$1(this.$transitionState$delegate).getCurrentState();
                ComposerKt.sourceInformationMarkerStart(composer, 1878957985, "CC(remember):Dialog.android.kt#9igjgp");
                boolean zChanged2 = composer.changed(this.$onDismissRequest);
                Function0<Unit> function1 = this.$onDismissRequest;
                MutableState<Boolean> mutableState4 = this.$pendingOnDismissCall$delegate;
                MutableState<MutableTransitionState<DialogVisibility>> mutableState5 = this.$transitionState$delegate;
                Dialog_androidKt$Dialog$5$4$1 dialog_androidKt$Dialog$5$4$1RememberedValue = composer.rememberedValue();
                if (zChanged2 || dialog_androidKt$Dialog$5$4$1RememberedValue == Composer.Companion.getEmpty()) {
                    dialog_androidKt$Dialog$5$4$1RememberedValue = new Dialog_androidKt$Dialog$5$4$1(function1, mutableState4, mutableState5, null);
                    composer.updateRememberedValue(dialog_androidKt$Dialog$5$4$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(currentState, (Function2) dialog_androidKt$Dialog$5$4$1RememberedValue, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$0(State<Float> state) {
            return ((Number) state.getValue()).floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$1(State<Float> state) {
            return ((Number) state.getValue()).floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$2(State<Float> state) {
            return ((Number) state.getValue()).floatValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final State<Float> animateBackgroundScrimAlpha(final Transition<DialogVisibility> transition, Composer composer, int i) throws NoWhenBranchMatchedException {
        float f;
        ComposerKt.sourceInformationMarkerStart(composer, -1455003481, "C(animateBackgroundScrimAlpha)254@10825L647:Dialog.android.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1455003481, i, -1, "androidx.wear.compose.material.dialog.animateBackgroundScrimAlpha (Dialog.android.kt:254)");
        }
        Function3<Transition.Segment<DialogVisibility>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<DialogVisibility>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.animateBackgroundScrimAlpha.1

            /* JADX INFO: renamed from: androidx.wear.compose.material.dialog.Dialog_androidKt$animateBackgroundScrimAlpha$1$WhenMappings */
            /* JADX INFO: compiled from: Dialog.android.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[DialogVisibility.values().length];
                    try {
                        iArr[DialogVisibility.Display.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[DialogVisibility.Hide.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Transition.Segment<DialogVisibility>) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<DialogVisibility> segment, Composer composer2, int i2) throws NoWhenBranchMatchedException {
                FiniteAnimationSpec<Float> finiteAnimationSpecTween$default;
                composer2.startReplaceGroup(-1926450854);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1926450854, i2, -1, "androidx.wear.compose.material.dialog.animateBackgroundScrimAlpha.<anonymous> (Dialog.android.kt:256)");
                }
                int i3 = WhenMappings.$EnumSwitchMapping$0[((DialogVisibility) transition.getTargetState()).ordinal()];
                if (i3 == 1) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(166, 0, AnimationKt.getSTANDARD_OUT(), 2, (Object) null);
                } else {
                    if (i3 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    finiteAnimationSpecTween$default = (FiniteAnimationSpec) AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.animateBackgroundScrimAlpha.1.1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            keyframesSpecConfig.setDurationMillis(400);
                            keyframesSpecConfig.at(Float.valueOf(1.0f), 0);
                            keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.9f), AnimationKt.RAPID), AnimationKt.getSTANDARD_IN());
                            keyframesSpecConfig.at(Float.valueOf(0.0f), 400);
                        }
                    });
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return finiteAnimationSpecTween$default;
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        TwoWayConverter vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i2 = (((i & 14) | 384) & 14) | 3072;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        DialogVisibility dialogVisibility = (DialogVisibility) transition.getCurrentState();
        composer.startReplaceGroup(-1717434585);
        ComposerKt.sourceInformation(composer, "C:Dialog.android.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1717434585, 0, -1, "androidx.wear.compose.material.dialog.animateBackgroundScrimAlpha.<anonymous> (Dialog.android.kt:273)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[dialogVisibility.ordinal()];
        float f2 = 1.0f;
        if (i3 == 1) {
            f = 0.0f;
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        DialogVisibility dialogVisibility2 = (DialogVisibility) transition.getTargetState();
        composer.startReplaceGroup(-1717434585);
        ComposerKt.sourceInformation(composer, "C:Dialog.android.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1717434585, 0, -1, "androidx.wear.compose.material.dialog.animateBackgroundScrimAlpha.<anonymous> (Dialog.android.kt:273)");
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[dialogVisibility2.ordinal()];
        if (i4 == 1) {
            f2 = 0.0f;
        } else if (i4 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        State<Float> stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, 0), vectorConverter, "background-scrim-alpha", composer, (i2 & 14) | 196608);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCreateTransitionAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final State<Float> animateContentAlpha(final Transition<DialogVisibility> transition, Composer composer, int i) throws NoWhenBranchMatchedException {
        float f;
        ComposerKt.sourceInformationMarkerStart(composer, 1045608006, "C(animateContentAlpha)282@11579L638:Dialog.android.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1045608006, i, -1, "androidx.wear.compose.material.dialog.animateContentAlpha (Dialog.android.kt:282)");
        }
        Function3<Transition.Segment<DialogVisibility>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<DialogVisibility>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.animateContentAlpha.1

            /* JADX INFO: renamed from: androidx.wear.compose.material.dialog.Dialog_androidKt$animateContentAlpha$1$WhenMappings */
            /* JADX INFO: compiled from: Dialog.android.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[DialogVisibility.values().length];
                    try {
                        iArr[DialogVisibility.Display.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[DialogVisibility.Hide.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Transition.Segment<DialogVisibility>) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<DialogVisibility> segment, Composer composer2, int i2) throws NoWhenBranchMatchedException {
                FiniteAnimationSpec<Float> finiteAnimationSpecKeyframes;
                composer2.startReplaceGroup(-1757781511);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1757781511, i2, -1, "androidx.wear.compose.material.dialog.animateContentAlpha.<anonymous> (Dialog.android.kt:284)");
                }
                int i3 = WhenMappings.$EnumSwitchMapping$0[((DialogVisibility) transition.getTargetState()).ordinal()];
                if (i3 == 1) {
                    finiteAnimationSpecKeyframes = AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.animateContentAlpha.1.1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            keyframesSpecConfig.setDurationMillis(400);
                            keyframesSpecConfig.at(Float.valueOf(0.0f), 0);
                            keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.1f), AnimationKt.RAPID), AnimationKt.getSTANDARD_IN());
                            keyframesSpecConfig.at(Float.valueOf(1.0f), 400);
                        }
                    });
                } else {
                    if (i3 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    finiteAnimationSpecKeyframes = (FiniteAnimationSpec) AnimationSpecKt.tween$default(166, 0, AnimationKt.getSTANDARD_OUT(), 2, (Object) null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return finiteAnimationSpecKeyframes;
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        TwoWayConverter vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i2 = (((i & 14) | 384) & 14) | 3072;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        DialogVisibility dialogVisibility = (DialogVisibility) transition.getCurrentState();
        composer.startReplaceGroup(1232393414);
        ComposerKt.sourceInformation(composer, "C:Dialog.android.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1232393414, 0, -1, "androidx.wear.compose.material.dialog.animateContentAlpha.<anonymous> (Dialog.android.kt:301)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[dialogVisibility.ordinal()];
        float f2 = 1.0f;
        if (i3 == 1) {
            f = 0.0f;
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        DialogVisibility dialogVisibility2 = (DialogVisibility) transition.getTargetState();
        composer.startReplaceGroup(1232393414);
        ComposerKt.sourceInformation(composer, "C:Dialog.android.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1232393414, 0, -1, "androidx.wear.compose.material.dialog.animateContentAlpha.<anonymous> (Dialog.android.kt:301)");
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[dialogVisibility2.ordinal()];
        if (i4 == 1) {
            f2 = 0.0f;
        } else if (i4 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        State<Float> stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, 0), vectorConverter, "content-alpha", composer, (i2 & 14) | 196608);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCreateTransitionAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final State<Float> animateDialogScale(final Transition<DialogVisibility> transition, Composer composer, int i) throws NoWhenBranchMatchedException {
        float f;
        ComposerKt.sourceInformationMarkerStart(composer, 640449597, "C(animateDialogScale)310@12323L417:Dialog.android.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(640449597, i, -1, "androidx.wear.compose.material.dialog.animateDialogScale (Dialog.android.kt:310)");
        }
        Function3<Transition.Segment<DialogVisibility>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<DialogVisibility>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.wear.compose.material.dialog.Dialog_androidKt.animateDialogScale.1

            /* JADX INFO: renamed from: androidx.wear.compose.material.dialog.Dialog_androidKt$animateDialogScale$1$WhenMappings */
            /* JADX INFO: compiled from: Dialog.android.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[DialogVisibility.values().length];
                    try {
                        iArr[DialogVisibility.Display.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[DialogVisibility.Hide.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Transition.Segment<DialogVisibility>) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<DialogVisibility> segment, Composer composer2, int i2) throws NoWhenBranchMatchedException {
                FiniteAnimationSpec<Float> finiteAnimationSpecTween$default;
                composer2.startReplaceGroup(1519849002);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1519849002, i2, -1, "androidx.wear.compose.material.dialog.animateDialogScale.<anonymous> (Dialog.android.kt:312)");
                }
                int i3 = WhenMappings.$EnumSwitchMapping$0[((DialogVisibility) transition.getTargetState()).ordinal()];
                if (i3 == 1) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(400, 0, AnimationKt.getSTANDARD_IN(), 2, (Object) null);
                } else {
                    if (i3 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    finiteAnimationSpecTween$default = (FiniteAnimationSpec) AnimationSpecKt.tween$default(400, 0, AnimationKt.getSTANDARD_OUT(), 2, (Object) null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return finiteAnimationSpecTween$default;
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        TwoWayConverter vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i2 = (((i & 14) | 384) & 14) | 3072;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        DialogVisibility dialogVisibility = (DialogVisibility) transition.getCurrentState();
        composer.startReplaceGroup(923569597);
        ComposerKt.sourceInformation(composer, "C:Dialog.android.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(923569597, 0, -1, "androidx.wear.compose.material.dialog.animateDialogScale.<anonymous> (Dialog.android.kt:319)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[dialogVisibility.ordinal()];
        float f2 = 1.0f;
        if (i3 == 1) {
            f = 1.25f;
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        DialogVisibility dialogVisibility2 = (DialogVisibility) transition.getTargetState();
        composer.startReplaceGroup(923569597);
        ComposerKt.sourceInformation(composer, "C:Dialog.android.kt#iw0lpz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(923569597, 0, -1, "androidx.wear.compose.material.dialog.animateDialogScale.<anonymous> (Dialog.android.kt:319)");
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[dialogVisibility2.ordinal()];
        if (i4 == 1) {
            f2 = 1.25f;
        } else if (i4 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        State<Float> stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, 0), vectorConverter, "scale", composer, (i2 & 14) | 196608);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCreateTransitionAnimation;
    }
}
