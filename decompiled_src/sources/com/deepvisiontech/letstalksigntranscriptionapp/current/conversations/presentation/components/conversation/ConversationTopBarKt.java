package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.constant.ConversationScreenConstants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationTopBar.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001av\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"ConversationScreenTopBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "activeConversationName", "onEditTitleClick", "Lkotlin/Function0;", "searchBarPlaceHolder", "searchQuery", "onDrawerClick", "onSearchQueryChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "query", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$29(Modifier modifier, String str, String str2, Function0 function0, String str3, String str4, Function0 function1, Function1 function2, int i, int i2, Composer composer, int i3) {
        ConversationScreenTopBar(modifier, str, str2, function0, str3, str4, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ConversationScreenTopBar(Modifier modifier, final String str, final String str2, final Function0<Unit> function0, final String str3, final String str4, final Function0<Unit> function1, final Function1<? super String, Unit> function2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "activeConversationName");
        Intrinsics.checkNotNullParameter(function0, "onEditTitleClick");
        Intrinsics.checkNotNullParameter(str3, "searchBarPlaceHolder");
        Intrinsics.checkNotNullParameter(str4, "searchQuery");
        Intrinsics.checkNotNullParameter(function1, "onDrawerClick");
        Intrinsics.checkNotNullParameter(function2, "onSearchQueryChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(208856903);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConversationScreenTopBar)P(1,7!1,3,5,6)58@2625L25,58@2608L42,59@2682L7,63@2826L66,67@2967L3462,145@6456L357,155@6833L1333,65@2898L5274:ConversationTopBar.kt#hsonup");
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
            i3 |= composerStartRestartGroup.changedInstance(function0) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(str3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(str4) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if (!composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(208856903, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar (ConversationTopBar.kt:57)");
            }
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1151966656, "CC(remember):ConversationTopBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return ConversationTopBarKt.ConversationScreenTopBar$lambda$1$lambda$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            int i5 = R.string.conversation_help_video_url;
            final String str5 = ConversationScreenConstants.INFO_VIDEO_ID;
            final String strStringResource = StringResources_androidKt.stringResource(i5, new Object[]{ConversationScreenConstants.INFO_VIDEO_ID}, composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            AppBarKt.CenterAlignedTopAppBar-GHTll3U(ComposableLambdaKt.rememberComposableLambda(433663426, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$17(mutableState, str4, function2, str3, str, function0, str2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifier2, ComposableLambdaKt.rememberComposableLambda(-1184319360, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$21(mutableState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(245819703, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$28(mutableState, strStringResource, context, str5, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), 0.0f, (WindowInsets) null, (TopAppBarColors) null, (TopAppBarScrollBehavior) null, composer2, ((i3 << 3) & 112) | 3462, 240);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier3 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$29(modifier3, str, str2, function0, str3, str4, function1, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ConversationScreenTopBar$lambda$1$lambda$0() {
        return SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$17(final MutableState mutableState, final String str, final Function1 function1, final String str2, final String str3, final Function0 function0, final String str4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@3169L1311,68@2981L1499,106@4641L1778,102@4494L1925:ConversationTopBar.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(433663426, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar.<anonymous> (ConversationTopBar.kt:68)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(((Boolean) mutableState.getValue()).booleanValue(), (Modifier) null, EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null).plus(EnterExitTransitionKt.expandVertically$default((FiniteAnimationSpec) null, (Alignment.Vertical) null, false, (Function1) null, 15, (Object) null)), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null).plus(EnterExitTransitionKt.shrinkVertically$default((FiniteAnimationSpec) null, (Alignment.Vertical) null, false, (Function1) null, 15, (Object) null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-1091817494, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$17$lambda$11(str, function1, str2, mutableState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 200064, 18);
            AnimatedVisibilityKt.AnimatedVisibility(!((Boolean) mutableState.getValue()).booleanValue(), (Modifier) null, EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-451445101, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$17$lambda$16(str3, function0, str4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$17$lambda$11(String str, final Function1 function1, final String str2, final MutableState mutableState, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C97@4389L10,87@3888L27,85@3772L37,77@3360L376,89@3986L355,73@3187L1279:ConversationTopBar.kt#hsonup");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1091817494, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar.<anonymous>.<anonymous> (ConversationTopBar.kt:73)");
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), 0.0f, 1, (Object) null);
        TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall();
        ComposerKt.sourceInformationMarkerStart(composer, -1264568475, "CC(remember):ConversationTopBar.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$17$lambda$11$lambda$3$lambda$2(function1, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OutlinedTextFieldKt.OutlinedTextField(str, (Function1) objRememberedValue, modifierFillMaxWidth$default, false, false, bodySmall, (Function2) null, ComposableLambdaKt.rememberComposableLambda(-688625199, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                return ConversationTopBarKt.ConversationScreenTopBar$lambda$17$lambda$11$lambda$4(str2, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), ComposableLambdaKt.rememberComposableLambda(-1336808302, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                return ConversationTopBarKt.ConversationScreenTopBar$lambda$17$lambda$11$lambda$7(mutableState, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), ComposableLambdaKt.rememberComposableLambda(-1984991405, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                return ConversationTopBarKt.ConversationScreenTopBar$lambda$17$lambda$11$lambda$10(function1, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 918552960, 113246208, 0, 7994456);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$17$lambda$11$lambda$7(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C78@3407L29,78@3386L328:ConversationTopBar.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1336808302, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar.<anonymous>.<anonymous>.<anonymous> (ConversationTopBar.kt:78)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -477555185, "CC(remember):ConversationTopBar.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        return ConversationTopBarKt.ConversationScreenTopBar$lambda$17$lambda$11$lambda$7$lambda$6$lambda$5(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationTopBarKt.INSTANCE.getLambda$740143024$app_release(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$17$lambda$11$lambda$7$lambda$6$lambda$5(MutableState mutableState) {
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$17$lambda$11$lambda$4(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C85@3774L33:ConversationTopBar.kt#hsonup");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-688625199, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar.<anonymous>.<anonymous>.<anonymous> (ConversationTopBar.kt:85)");
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
    public static final Unit ConversationScreenTopBar$lambda$17$lambda$11$lambda$3$lambda$2(Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$17$lambda$11$lambda$10(final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C90@4033L27,90@4012L307:ConversationTopBar.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1984991405, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar.<anonymous>.<anonymous>.<anonymous> (ConversationTopBar.kt:90)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -611259250, "CC(remember):ConversationTopBar.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        return ConversationTopBarKt.ConversationScreenTopBar$lambda$17$lambda$11$lambda$10$lambda$9$lambda$8(function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationTopBarKt.INSTANCE.getLambda$91959921$app_release(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$17$lambda$11$lambda$10$lambda$9$lambda$8(Function1 function1) {
        function1.invoke("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$17$lambda$16(String str, final Function0 function0, String str2, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C107@4659L1746:ConversationTopBar.kt#hsonup");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-451445101, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar.<anonymous>.<anonymous> (ConversationTopBar.kt:107)");
        }
        Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
        Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        Modifier modifier = Modifier.Companion;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 54);
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
        Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1007879141, "C113@4930L10,114@4999L11,111@4840L200,120@5231L6,122@5332L58,123@5434L22,117@5062L1325:ConversationTopBar.kt#hsonup");
        TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), composer, 0, 0, 131066);
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        Modifier modifierClip = ClipKt.clip(Modifier.Companion, MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getSmall());
        String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_screen_cd_edit_title, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1695062733, "CC(remember):ConversationTopBar.kt#9igjgp");
        boolean zChanged = composer.changed(function0);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda14
                public final Object invoke() {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$17$lambda$16$lambda$15$lambda$13$lambda$12(function0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        float f = 4;
        Modifier modifier2 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifierClip, false, strStringResource, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue, 13, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(2));
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
        ComposerKt.sourceInformationMarkerStart(composer, 1547780949, "C129@5723L10,130@5796L11,127@5608L346,134@5979L39,137@6160L39,139@6311L11,135@6043L322:ConversationTopBar.kt#hsonup");
        TextKt.Text-Nvy7gAk(str2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), composer, 0, 24960, 110586);
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
        IconKt.Icon-ww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.global_cd_edit, composer, 0), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), composer, 384, 0);
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$17$lambda$16$lambda$15$lambda$13$lambda$12(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$21(MutableState mutableState, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C146@6519L284,146@6470L333:ConversationTopBar.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1184319360, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar.<anonymous> (ConversationTopBar.kt:146)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(!((Boolean) mutableState.getValue()).booleanValue(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1585167016, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$21$lambda$20(function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 196608, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$21$lambda$20(final Function0 function0, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C147@6558L19,147@6537L252:ConversationTopBar.kt#hsonup");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1585167016, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar.<anonymous>.<anonymous> (ConversationTopBar.kt:147)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1367886437, "CC(remember):ConversationTopBar.kt#9igjgp");
        boolean zChanged = composer.changed(function0);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$21$lambda$20$lambda$19$lambda$18(function0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationTopBarKt.INSTANCE.m1544getLambda$1495234486$app_release(), composer, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$21$lambda$20$lambda$19$lambda$18(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$28(final MutableState mutableState, final String str, final Context context, final String str2, RowScope rowScope, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(rowScope, "$this$CenterAlignedTopAppBar");
        ComposerKt.sourceInformation(composer, "C156@6886L1270,156@6847L1309:ConversationTopBar.kt#hsonup");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(rowScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(245819703, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar.<anonymous> (ConversationTopBar.kt:156)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(rowScope, !((Boolean) mutableState.getValue()).booleanValue(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(760206351, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$28$lambda$27(mutableState, str, context, str2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, (i2 & 14) | 1572864, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$28$lambda$27(final MutableState mutableState, final String str, final Context context, final String str2, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C157@6904L1238:ConversationTopBar.kt#hsonup");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(760206351, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationScreenTopBar.<anonymous>.<anonymous> (ConversationTopBar.kt:157)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        Modifier modifier = Modifier.Companion;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
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
        ComposerKt.sourceInformationMarkerStart(composer, -1546909306, "C158@6951L28,158@6930L285,165@7258L621,165@7237L887:ConversationTopBar.kt#hsonup");
        ComposerKt.sourceInformationMarkerStart(composer, 1335572527, "CC(remember):ConversationTopBar.kt#9igjgp");
        boolean zChanged = composer.changed(mutableState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda16
                public final Object invoke() {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$28$lambda$27$lambda$26$lambda$23$lambda$22(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationTopBarKt.INSTANCE.m1543getLambda$1174976623$app_release(), composer, 1572864, 62);
        ComposerKt.sourceInformationMarkerStart(composer, 1335582944, "CC(remember):ConversationTopBar.kt#9igjgp");
        boolean zChanged2 = composer.changed(str) | composer.changedInstance(context);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt$$ExternalSyntheticLambda17
                public final Object invoke() {
                    return ConversationTopBarKt.ConversationScreenTopBar$lambda$28$lambda$27$lambda$26$lambda$25$lambda$24(str2, str, context);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue2, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ConversationTopBarKt.INSTANCE.getLambda$1570955976$app_release(), composer, 1572864, 62);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$28$lambda$27$lambda$26$lambda$23$lambda$22(MutableState mutableState) {
        mutableState.setValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreenTopBar$lambda$28$lambda$27$lambda$26$lambda$25$lambda$24(String str, String str2, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + str));
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str2));
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            context.startActivity(intent2);
        }
        return Unit.INSTANCE;
    }
}
