package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.OverscrollEffect;
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
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.NotificationsKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.viewmodel.EnvironmentSoundHistoryViewModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnvironmentSoundHistoryScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \u001a%\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\u0012\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rX\u008a\u0084\u0002"}, d2 = {"EnvironmentSoundHistoryScreen", "", "onDrawerClick", "Lkotlin/Function0;", "viewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/presentation/viewmodel/EnvironmentSoundHistoryViewModel;", "(Lkotlin/jvm/functions/Function0;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/presentation/viewmodel/EnvironmentSoundHistoryViewModel;Landroidx/compose/runtime/Composer;II)V", "HistoryItemCard", "entity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/entities/EnvironmentSoundHistoryEntity;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/entities/EnvironmentSoundHistoryEntity;Landroidx/compose/runtime/Composer;I)V", "app_release", "history", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EnvironmentSoundHistoryScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnvironmentSoundHistoryScreen$lambda$9(Function0 function0, EnvironmentSoundHistoryViewModel environmentSoundHistoryViewModel, int i, int i2, Composer composer, int i3) {
        EnvironmentSoundHistoryScreen(function0, environmentSoundHistoryViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryItemCard$lambda$17(EnvironmentSoundHistoryEntity environmentSoundHistoryEntity, int i, Composer composer, int i2) {
        HistoryItemCard(environmentSoundHistoryEntity, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0045  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:53:0x012e  */
    public static final void EnvironmentSoundHistoryScreen(final Function0<Unit> function0, EnvironmentSoundHistoryViewModel environmentSoundHistoryViewModel, Composer composer, final int i, final int i2) {
        int i3;
        Composer composer2;
        CreationExtras defaultViewModelCreationExtras;
        int i4;
        final EnvironmentSoundHistoryViewModel environmentSoundHistoryViewModel2 = environmentSoundHistoryViewModel;
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1447698805);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EnvironmentSoundHistoryScreen)57@2844L29,60@2906L368,70@3281L1195,59@2879L1597:EnvironmentSoundHistoryScreen.kt#rau839");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) != 0) {
                i4 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(environmentSoundHistoryViewModel2) : composerStartRestartGroup.changedInstance(environmentSoundHistoryViewModel2)) {
                    i4 = 32;
                } else {
                    i4 = 16;
                }
            }
            i3 |= i4;
        }
        int i5 = i3;
        if (composerStartRestartGroup.shouldExecute((i5 & 19) != 18, i5 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "55@2787L15");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 2) != 0) {
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = current.getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel(EnvironmentSoundHistoryViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    environmentSoundHistoryViewModel2 = (EnvironmentSoundHistoryViewModel) viewModel;
                    i5 &= -113;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1447698805, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreen (EnvironmentSoundHistoryScreen.kt:56)");
                }
                Composer composer3 = composer2;
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(environmentSoundHistoryViewModel2.getHistory(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer3, 0, 7);
                ScaffoldKt.Scaffold-TvnljyQ((Modifier) null, ComposableLambdaKt.rememberComposableLambda(-700554161, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2) {
                        return EnvironmentSoundHistoryScreenKt.EnvironmentSoundHistoryScreen$lambda$2(function0, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(1488303578, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return EnvironmentSoundHistoryScreenKt.EnvironmentSoundHistoryScreen$lambda$8(stateCollectAsStateWithLifecycle, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), composer2, 805306416, 509);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i5 &= -113;
                }
            }
            composer2 = composerStartRestartGroup;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1447698805, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreen (EnvironmentSoundHistoryScreen.kt:56)");
            }
            Composer composer4 = composer2;
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(environmentSoundHistoryViewModel2.getHistory(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer4, 0, 7);
            ScaffoldKt.Scaffold-TvnljyQ((Modifier) null, ComposableLambdaKt.rememberComposableLambda(-700554161, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    return EnvironmentSoundHistoryScreenKt.EnvironmentSoundHistoryScreen$lambda$2(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer4, 54), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(1488303578, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EnvironmentSoundHistoryScreenKt.EnvironmentSoundHistoryScreen$lambda$8(stateCollectAsStateWithLifecycle2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54), composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    return EnvironmentSoundHistoryScreenKt.EnvironmentSoundHistoryScreen$lambda$9(function0, environmentSoundHistoryViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnvironmentSoundHistoryScreen$lambda$2(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C63@3040L210,61@2920L344:EnvironmentSoundHistoryScreen.kt#rau839");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-700554161, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreen.<anonymous> (EnvironmentSoundHistoryScreen.kt:61)");
            }
            AppBarKt.TopAppBar-GHTll3U(ComposableSingletons$EnvironmentSoundHistoryScreenKt.INSTANCE.m1681getLambda$2020703989$app_release(), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(956131145, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return EnvironmentSoundHistoryScreenKt.EnvironmentSoundHistoryScreen$lambda$2$lambda$1(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), (Function3) null, 0.0f, (WindowInsets) null, (TopAppBarColors) null, (TopAppBarScrollBehavior) null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnvironmentSoundHistoryScreen$lambda$2$lambda$1(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C64@3062L170:EnvironmentSoundHistoryScreen.kt#rau839");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(956131145, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreen.<anonymous>.<anonymous> (EnvironmentSoundHistoryScreen.kt:64)");
            }
            IconButtonKt.IconButton(function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$EnvironmentSoundHistoryScreenKt.INSTANCE.m1680getLambda$161520533$app_release(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnvironmentSoundHistoryScreen$lambda$8(final State state, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "C:EnvironmentSoundHistoryScreen.kt#rau839");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1488303578, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreen.<anonymous> (EnvironmentSoundHistoryScreen.kt:71)");
            }
            if (EnvironmentSoundHistoryScreen$lambda$0(state) == null) {
                composer.startReplaceGroup(1104547021);
                ComposerKt.sourceInformation(composer, "72@3343L99");
                CircularProgressIndicatorComponentKt.CircularProgressComponent(PaddingKt.padding(Modifier.Companion, paddingValues), composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                List<EnvironmentSoundHistoryEntity> listEnvironmentSoundHistoryScreen$lambda$0 = EnvironmentSoundHistoryScreen$lambda$0(state);
                Intrinsics.checkNotNull(listEnvironmentSoundHistoryScreen$lambda$0);
                if (listEnvironmentSoundHistoryScreen$lambda$0.isEmpty()) {
                    composer.startReplaceGroup(1104710856);
                    ComposerKt.sourceInformation(composer, "76@3497L456");
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues);
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
                    ComposerKt.sourceInformationMarkerStart(composer, -945192474, "C83@3735L50,84@3829L10,85@3893L11,82@3702L237:EnvironmentSoundHistoryScreen.kt#rau839");
                    TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.env_sound_list_info_empty, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1105193619);
                    ComposerKt.sourceInformation(composer, "95@4246L214,89@3983L477");
                    Modifier modifierPadding2 = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues);
                    PaddingValues paddingValues2 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(16));
                    Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
                    ComposerKt.sourceInformationMarkerStart(composer, 35659984, "CC(remember):EnvironmentSoundHistoryScreen.kt#9igjgp");
                    boolean zChanged = composer.changed(state);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                return EnvironmentSoundHistoryScreenKt.EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6(state, (LazyListScope) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    LazyDslKt.LazyColumn(modifierPadding2, (LazyListState) null, paddingValues2, false, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) objRememberedValue, composer, 24960, 490);
                    composer.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6(State state, LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        final List<EnvironmentSoundHistoryEntity> listEnvironmentSoundHistoryScreen$lambda$0 = EnvironmentSoundHistoryScreen$lambda$0(state);
        Intrinsics.checkNotNull(listEnvironmentSoundHistoryScreen$lambda$0);
        final Function1 function1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return EnvironmentSoundHistoryScreenKt.EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6$lambda$4((EnvironmentSoundHistoryEntity) obj);
            }
        };
        final EnvironmentSoundHistoryScreenKt$EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6$$inlined$items$default$1 environmentSoundHistoryScreenKt$EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6$$inlined$items$default$1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6$$inlined$items$default$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final Void m1686invoke(EnvironmentSoundHistoryEntity environmentSoundHistoryEntity) {
                return null;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m1686invoke((EnvironmentSoundHistoryEntity) obj);
            }
        };
        lazyListScope.items(listEnvironmentSoundHistoryScreen$lambda$0.size(), new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6$$inlined$items$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i) {
                return function1.invoke(listEnvironmentSoundHistoryScreen$lambda$0.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i) {
                return environmentSoundHistoryScreenKt$EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6$$inlined$items$default$1.invoke(listEnvironmentSoundHistoryScreen$lambda$0.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6$$inlined$items$default$4
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
                EnvironmentSoundHistoryEntity environmentSoundHistoryEntity = (EnvironmentSoundHistoryEntity) listEnvironmentSoundHistoryScreen$lambda$0.get(i);
                composer.startReplaceGroup(-423167529);
                ComposerKt.sourceInformation(composer, "C*100@4396L32:EnvironmentSoundHistoryScreen.kt#rau839");
                EnvironmentSoundHistoryScreenKt.HistoryItemCard(environmentSoundHistoryEntity, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object EnvironmentSoundHistoryScreen$lambda$8$lambda$7$lambda$6$lambda$4(EnvironmentSoundHistoryEntity environmentSoundHistoryEntity) {
        Intrinsics.checkNotNullParameter(environmentSoundHistoryEntity, "it");
        return Long.valueOf(environmentSoundHistoryEntity.getId());
    }

    public static final void HistoryItemCard(final EnvironmentSoundHistoryEntity environmentSoundHistoryEntity, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(environmentSoundHistoryEntity, "entity");
        Composer composerStartRestartGroup = composer.startRestartGroup(-604860959);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HistoryItemCard)109@4577L74,110@4676L75,115@4892L11,114@4837L91,117@4935L2011,112@4757L2189:EnvironmentSoundHistoryScreen.kt#rau839");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(environmentSoundHistoryEntity) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-604860959, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.HistoryItemCard (EnvironmentSoundHistoryScreen.kt:108)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1450793461, "CC(remember):EnvironmentSoundHistoryScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long timestamp = environmentSoundHistoryEntity.getTimestamp();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1450790292, "CC(remember):EnvironmentSoundHistoryScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(timestamp);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = simpleDateFormat.format(new Date(environmentSoundHistoryEntity.getTimestamp()));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final String str = (String) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Shape) null, CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-141521, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EnvironmentSoundHistoryScreenKt.HistoryItemCard$lambda$16(environmentSoundHistoryEntity, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 196614, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    return EnvironmentSoundHistoryScreenKt.HistoryItemCard$lambda$17(environmentSoundHistoryEntity, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryItemCard$lambda$16(final EnvironmentSoundHistoryEntity environmentSoundHistoryEntity, String str, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$Card");
        ComposerKt.sourceInformation(composer, "C118@4945L1995:EnvironmentSoundHistoryScreen.kt#rau839");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-141521, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.HistoryItemCard.<anonymous> (EnvironmentSoundHistoryScreen.kt:118)");
            }
            float f = 16;
            Modifier modifier = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f));
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
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
            ComposerKt.sourceInformationMarkerStart(composer, 155873040, "C128@5275L11,124@5130L535,140@5679L40,142@5733L589,157@6336L39,161@6487L11,162@6562L11,163@6607L323,159@6389L541:EnvironmentSoundHistoryScreen.kt#rau839");
            Modifier modifier2 = BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.getCircleShape());
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1810392701, "C136@5614L11,133@5458L193:EnvironmentSoundHistoryScreen.kt#rau839");
            IconKt.Icon-ww6aTOc(NotificationsKt.getNotifications(Icons.Filled.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), composer, 48, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
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
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 431920712, "C145@5879L10,147@5995L11,143@5790L244,149@6051L40,152@6198L10,153@6262L11,150@6108L200:EnvironmentSoundHistoryScreen.kt#rau839");
            TextKt.Text-Nvy7gAk(environmentSoundHistoryEntity.getLabel(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 1572864, 0, 131002);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), composer, 6);
            Intrinsics.checkNotNull(str);
            TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer, 6);
            SurfaceKt.Surface-T9BRK9s((Modifier) null, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-154457776, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return EnvironmentSoundHistoryScreenKt.HistoryItemCard$lambda$16$lambda$15$lambda$14(environmentSoundHistoryEntity, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582912, 113);
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
    public static final Unit HistoryItemCard$lambda$16$lambda$15$lambda$14(EnvironmentSoundHistoryEntity environmentSoundHistoryEntity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C166@6741L10,164@6625L291:EnvironmentSoundHistoryScreen.kt#rau839");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-154457776, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.HistoryItemCard.<anonymous>.<anonymous>.<anonymous> (EnvironmentSoundHistoryScreen.kt:164)");
            }
            TextKt.Text-Nvy7gAk(((int) (environmentSoundHistoryEntity.getConfidence() * 100)) + "%", PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(8), Dp.constructor-impl(4)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelMedium(), composer, 1572912, 0, 131004);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final List<EnvironmentSoundHistoryEntity> EnvironmentSoundHistoryScreen$lambda$0(State<? extends List<EnvironmentSoundHistoryEntity>> state) {
        return (List) state.getValue();
    }
}
