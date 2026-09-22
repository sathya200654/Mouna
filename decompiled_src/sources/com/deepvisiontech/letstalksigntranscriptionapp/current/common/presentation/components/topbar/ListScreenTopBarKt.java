package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuItemColors;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarScrollBehavior;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
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
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.PopupProperties;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListScreenTopBar.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a§\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000f2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"ListScreenTopBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "searchBarPlaceHolder", "searchQuery", "isSelecting", "", "onDrawerClick", "Lkotlin/Function0;", "onDeleteClick", "onDateFilterClick", "onSortOrderChange", "Lkotlin/Function1;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;", "Lkotlin/ParameterName;", "name", "sortOrder", "onSearchQueryChange", "query", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ListScreenTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$45(Modifier modifier, String str, String str2, String str3, boolean z, Function0 function0, Function0 function1, Function0 function2, Function1 function3, Function1 function4, int i, int i2, Composer composer, int i3) {
        ListScreenTopBar(modifier, str, str2, str3, z, function0, function1, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ListScreenTopBar(Modifier modifier, final String str, final String str2, final String str3, final boolean z, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, final Function1<? super ListSortOrder, Unit> function3, final Function1<? super String, Unit> function4, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "searchBarPlaceHolder");
        Intrinsics.checkNotNullParameter(str3, "searchQuery");
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        Intrinsics.checkNotNullParameter(function1, "onDeleteClick");
        Intrinsics.checkNotNullParameter(function2, "onDateFilterClick");
        Intrinsics.checkNotNullParameter(function3, "onSortOrderChange");
        Intrinsics.checkNotNullParameter(function4, "onSearchQueryChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-116863819);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ListScreenTopBar)P(1,9,7,8!1,4,3!1,6)48@2103L25,48@2086L42,49@2173L25,49@2156L42,53@2260L1904,106@4191L469,122@4680L4313,51@2204L6795:ListScreenTopBar.kt#u4jokp");
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
            i3 |= composerStartRestartGroup.changed(str3) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            z2 = z;
            i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        } else {
            z2 = z;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 536870912 : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-116863819, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar (ListScreenTopBar.kt:46)");
            }
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -636965522, "CC(remember):ListScreenTopBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        return ListScreenTopBarKt.ListScreenTopBar$lambda$1$lambda$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            Object[] objArr2 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -636963282, "CC(remember):ListScreenTopBar.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        return ListScreenTopBarKt.ListScreenTopBar$lambda$3$lambda$2();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
            final boolean z3 = z2;
            composer2 = composerStartRestartGroup;
            AppBarKt.TopAppBar-GHTll3U(ComposableLambdaKt.rememberComposableLambda(-75450759, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$15(mutableState, str3, function4, str2, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifier4, ComposableLambdaKt.rememberComposableLambda(80791419, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$19(mutableState, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1842618276, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$44(z3, mutableState, function1, function2, mutableState2, function3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), 0.0f, (WindowInsets) null, (TopAppBarColors) null, (TopAppBarScrollBehavior) null, composer2, ((i3 << 3) & 112) | 3462, 240);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$45(modifier3, str, str2, str3, z, function0, function1, function2, function3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ListScreenTopBar$lambda$1$lambda$0() {
        return SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ListScreenTopBar$lambda$3$lambda$2() {
        return SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$15(final MutableState mutableState, final String str, final Function1 function1, final String str2, final String str3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C56@2353L1557,54@2274L1636,99@4003L151,97@3923L231:ListScreenTopBar.kt#u4jokp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-75450759, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous> (ListScreenTopBar.kt:54)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(((Boolean) mutableState.getValue()).booleanValue(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(798927185, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$15$lambda$13(str, function1, str2, mutableState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 196608, 30);
            AnimatedVisibilityKt.AnimatedVisibility(!((Boolean) mutableState.getValue()).booleanValue(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1930362312, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$15$lambda$14(str3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 196608, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$15$lambda$13(String str, final Function1 function1, final String str2, final MutableState mutableState, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C93@3819L10,77@3195L71,73@3035L81,61@2544L455,81@3337L434,57@2371L1525:ListScreenTopBar.kt#u4jokp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(798927185, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous>.<anonymous> (ListScreenTopBar.kt:57)");
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), 0.0f, 1, (Object) null);
        TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall();
        ComposerKt.sourceInformationMarkerStart(composer, -1030094184, "CC(remember):ListScreenTopBar.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj) {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$15$lambda$13$lambda$5$lambda$4(function1, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OutlinedTextFieldKt.OutlinedTextField(str, (Function1) objRememberedValue, modifierFillMaxWidth$default, false, false, bodySmall, (Function2) null, ComposableLambdaKt.rememberComposableLambda(-99828150, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda26
            public final Object invoke(Object obj, Object obj2) {
                return ListScreenTopBarKt.ListScreenTopBar$lambda$15$lambda$13$lambda$6(str2, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), ComposableLambdaKt.rememberComposableLambda(211562921, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda27
            public final Object invoke(Object obj, Object obj2) {
                return ListScreenTopBarKt.ListScreenTopBar$lambda$15$lambda$13$lambda$9(mutableState, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), ComposableLambdaKt.rememberComposableLambda(522953992, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                return ListScreenTopBarKt.ListScreenTopBar$lambda$15$lambda$13$lambda$12(function1, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 918552960, 113246208, 0, 7994456);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$15$lambda$13$lambda$9(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C63@2620L89,62@2570L407:ListScreenTopBar.kt#u4jokp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(211562921, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous>.<anonymous>.<anonymous> (ListScreenTopBar.kt:62)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1448506690, "CC(remember):ListScreenTopBar.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda23
                    public final Object invoke() {
                        return ListScreenTopBarKt.ListScreenTopBar$lambda$15$lambda$13$lambda$9$lambda$8$lambda$7(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ListScreenTopBarKt.INSTANCE.m1439getLambda$946710965$app_release(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$15$lambda$13$lambda$9$lambda$8$lambda$7(MutableState mutableState) {
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$15$lambda$13$lambda$6(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C74@3061L33:ListScreenTopBar.kt#u4jokp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-99828150, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous>.<anonymous>.<anonymous> (ListScreenTopBar.kt:74)");
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$15$lambda$13$lambda$5$lambda$4(Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$15$lambda$13$lambda$12(final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C83@3413L87,82@3363L386:ListScreenTopBar.kt#u4jokp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(522953992, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous>.<anonymous>.<anonymous> (ListScreenTopBar.kt:82)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 47615199, "CC(remember):ListScreenTopBar.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda24
                    public final Object invoke() {
                        return ListScreenTopBarKt.ListScreenTopBar$lambda$15$lambda$13$lambda$12$lambda$11$lambda$10(function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ListScreenTopBarKt.INSTANCE.m1437getLambda$635319894$app_release(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$15$lambda$13$lambda$12$lambda$11$lambda$10(Function1 function1) {
        function1.invoke("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$15$lambda$14(String str, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C102@4103L11,100@4021L119:ListScreenTopBar.kt#u4jokp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1930362312, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous>.<anonymous> (ListScreenTopBar.kt:100)");
        }
        TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$19(MutableState mutableState, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C109@4284L366,107@4205L445:ListScreenTopBar.kt#u4jokp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(80791419, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous> (ListScreenTopBar.kt:107)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(!((Boolean) mutableState.getValue()).booleanValue(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(955169363, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$19$lambda$18(function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 196608, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$19$lambda$18(final Function0 function0, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C111@4344L63,110@4302L334:ListScreenTopBar.kt#u4jokp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(955169363, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous>.<anonymous> (ListScreenTopBar.kt:110)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1205241518, "CC(remember):ListScreenTopBar.kt#9igjgp");
        boolean zChanged = composer.changed(function0);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda18
                public final Object invoke() {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$19$lambda$18$lambda$17$lambda$16(function0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ListScreenTopBarKt.INSTANCE.getLambda$542153969$app_release(), composer, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$19$lambda$18$lambda$17$lambda$16(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44(boolean z, final MutableState mutableState, final Function0 function0, final Function0 function1, final MutableState mutableState2, final Function1 function2, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TopAppBar");
        ComposerKt.sourceInformation(composer, "C123@4694L4289:ListScreenTopBar.kt#u4jokp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1842618276, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous> (ListScreenTopBar.kt:123)");
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
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 942592518, "C126@4787L330,124@4716L401,139@5229L3740,137@5135L3834:ListScreenTopBar.kt#u4jokp");
            AnimatedVisibilityKt.AnimatedVisibility(rowScope2, z, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1083066136, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$22(function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 30);
            AnimatedVisibilityKt.AnimatedVisibility(rowScope2, (z || ((Boolean) mutableState.getValue()).booleanValue()) ? false : true, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1049400687, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$42(mutableState, function1, mutableState2, function2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 30);
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
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$22(final Function0 function0, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C127@4830L63,127@4809L290:ListScreenTopBar.kt#u4jokp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1083066136, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous>.<anonymous>.<anonymous> (ListScreenTopBar.kt:127)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1444469625, "CC(remember):ListScreenTopBar.kt#9igjgp");
        boolean zChanged = composer.changed(function0);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda19
                public final Object invoke() {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$22$lambda$21$lambda$20(function0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ListScreenTopBarKt.INSTANCE.getLambda$329301130$app_release(), composer, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$22$lambda$21$lambda$20(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$42(final MutableState mutableState, final Function0 function0, final MutableState mutableState2, final Function1 function1, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C140@5251L3700:ListScreenTopBar.kt#u4jokp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1049400687, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous>.<anonymous>.<anonymous> (ListScreenTopBar.kt:140)");
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
        ComposerKt.sourceInformationMarkerStart(composer, -365827146, "C141@5303L80,141@5281L348,150@5654L2925,206@8625L75,206@8604L325:ListScreenTopBar.kt#u4jokp");
        ComposerKt.sourceInformationMarkerStart(composer, 819480253, "CC(remember):ListScreenTopBar.kt#9igjgp");
        boolean zChanged = composer.changed(mutableState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$24$lambda$23(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ListScreenTopBarKt.INSTANCE.m1435getLambda$186126513$app_release(), composer, 1572864, 62);
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Modifier modifier2 = Modifier.Companion;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
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
        Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 2015089259, "C151@5710L93,151@5688L393,162@6242L34,163@6307L2246,160@6110L2443:ListScreenTopBar.kt#u4jokp");
        ComposerKt.sourceInformationMarkerStart(composer, 896284804, "CC(remember):ListScreenTopBar.kt#9igjgp");
        boolean zChanged2 = composer.changed(mutableState2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$26$lambda$25(mutableState2);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue2, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ListScreenTopBarKt.INSTANCE.getLambda$225368969$app_release(), composer, 1572864, 62);
        boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
        ComposerKt.sourceInformationMarkerStart(composer, 896301769, "CC(remember):ListScreenTopBar.kt#9igjgp");
        boolean zChanged3 = composer.changed(mutableState2);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$28$lambda$27(mutableState2);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        AndroidMenu_androidKt.DropdownMenu-IlH_yew(zBooleanValue, (Function0) objRememberedValue3, (Modifier) null, 0L, (ScrollState) null, (PopupProperties) null, (Shape) null, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-2092307550, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37(function1, mutableState2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 0, 48, 2044);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 819586552, "CC(remember):ListScreenTopBar.kt#9igjgp");
        boolean zChanged4 = composer.changed(function0);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$40$lambda$39(function0);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue4, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$ListScreenTopBarKt.INSTANCE.getLambda$271505144$app_release(), composer, 1572864, 62);
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
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$24$lambda$23(MutableState mutableState) {
        mutableState.setValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$26$lambda$25(MutableState mutableState) {
        mutableState.setValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$28$lambda$27(MutableState mutableState) {
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37(final Function1 function1, final MutableState mutableState, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C170@6679L195,164@6341L567,179@7194L196,175@6941L483,190@7787L196,184@7457L560,199@8294L195,195@8050L473:ListScreenTopBar.kt#u4jokp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2092307550, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ListScreenTopBar.kt:164)");
            }
            Function2<Composer, Integer, Unit> function2M1434getLambda$1674410126$app_release = ComposableSingletons$ListScreenTopBarKt.INSTANCE.m1434getLambda$1674410126$app_release();
            ComposerKt.sourceInformationMarkerStart(composer, -662848923, "CC(remember):ListScreenTopBar.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(mutableState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37$lambda$30$lambda$29(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem(function2M1434getLambda$1674410126$app_release, (Function0) objRememberedValue, (Modifier) null, (Function2) null, (Function2) null, false, (MenuItemColors) null, (PaddingValues) null, (MutableInteractionSource) null, composer, 6, 508);
            Function2<Composer, Integer, Unit> function2M1436getLambda$514861719$app_release = ComposableSingletons$ListScreenTopBarKt.INSTANCE.m1436getLambda$514861719$app_release();
            ComposerKt.sourceInformationMarkerStart(composer, -662832442, "CC(remember):ListScreenTopBar.kt#9igjgp");
            boolean zChanged2 = composer.changed(function1) | composer.changed(mutableState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37$lambda$32$lambda$31(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem(function2M1436getLambda$514861719$app_release, (Function0) objRememberedValue2, (Modifier) null, (Function2) null, (Function2) null, false, (MenuItemColors) null, (PaddingValues) null, (MutableInteractionSource) null, composer, 6, 508);
            Function2<Composer, Integer, Unit> function2M1438getLambda$786020630$app_release = ComposableSingletons$ListScreenTopBarKt.INSTANCE.m1438getLambda$786020630$app_release();
            ComposerKt.sourceInformationMarkerStart(composer, -662813466, "CC(remember):ListScreenTopBar.kt#9igjgp");
            boolean zChanged3 = composer.changed(function1) | composer.changed(mutableState);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda16
                    public final Object invoke() {
                        return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37$lambda$34$lambda$33(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem(function2M1438getLambda$786020630$app_release, (Function0) objRememberedValue3, (Modifier) null, (Function2) null, (Function2) null, false, (MenuItemColors) null, (PaddingValues) null, (MutableInteractionSource) null, composer, 6, 508);
            Function2<Composer, Integer, Unit> function2M1433getLambda$1057179541$app_release = ComposableSingletons$ListScreenTopBarKt.INSTANCE.m1433getLambda$1057179541$app_release();
            ComposerKt.sourceInformationMarkerStart(composer, -662797243, "CC(remember):ListScreenTopBar.kt#9igjgp");
            boolean zChanged4 = composer.changed(function1) | composer.changed(mutableState);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt$$ExternalSyntheticLambda17
                    public final Object invoke() {
                        return ListScreenTopBarKt.ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37$lambda$36$lambda$35(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem(function2M1433getLambda$1057179541$app_release, (Function0) objRememberedValue4, (Modifier) null, (Function2) null, (Function2) null, false, (MenuItemColors) null, (PaddingValues) null, (MutableInteractionSource) null, composer, 6, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37$lambda$30$lambda$29(Function1 function1, MutableState mutableState) {
        function1.invoke(ListSortOrder.BY_NAME_ASC);
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37$lambda$32$lambda$31(Function1 function1, MutableState mutableState) {
        function1.invoke(ListSortOrder.BY_NAME_DESC);
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37$lambda$34$lambda$33(Function1 function1, MutableState mutableState) {
        function1.invoke(ListSortOrder.BY_TIME_DESC);
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37$lambda$36$lambda$35(Function1 function1, MutableState mutableState) {
        function1.invoke(ListSortOrder.BY_TIME_ASC);
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListScreenTopBar$lambda$44$lambda$43$lambda$42$lambda$41$lambda$40$lambda$39(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
