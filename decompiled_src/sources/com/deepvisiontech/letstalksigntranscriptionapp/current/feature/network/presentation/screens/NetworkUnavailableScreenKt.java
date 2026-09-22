package com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens;

import android.app.Activity;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.WarningKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.NetworkUnavailableViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkUnavailableScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"NetworkUnavailableScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "networkUnavailableViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/NetworkUnavailableViewModel;", "onNavigateToAuthGraph", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/NetworkUnavailableViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NetworkUnavailableScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NetworkUnavailableScreen$lambda$5(Modifier modifier, NetworkUnavailableViewModel networkUnavailableViewModel, Function0 function0, int i, int i2, Composer composer, int i3) {
        NetworkUnavailableScreen(modifier, networkUnavailableViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0052  */
    /* JADX WARN: Code duplicated, block: B:64:0x0117  */
    /* JADX WARN: Code duplicated, block: B:67:0x0139  */
    /* JADX WARN: Code duplicated, block: B:68:0x013c  */
    /* JADX WARN: Code duplicated, block: B:79:0x015f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0171  */
    /* JADX WARN: Code duplicated, block: B:87:0x01bf  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    public static final void NetworkUnavailableScreen(Modifier modifier, NetworkUnavailableViewModel networkUnavailableViewModel, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        Modifier modifier4;
        CreationExtras defaultViewModelCreationExtras;
        boolean z;
        ?? r5;
        Context context;
        final Activity activity;
        ?? r16;
        int i4;
        NetworkUnavailableScreenKt$NetworkUnavailableScreen$1$1 networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue;
        int i5;
        NetworkUnavailableViewModel networkUnavailableViewModel2 = networkUnavailableViewModel;
        Intrinsics.checkNotNullParameter(function0, "onNavigateToAuthGraph");
        Composer composerStartRestartGroup = composer.startRestartGroup(646733880);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NetworkUnavailableScreen)42@2005L7,45@2079L246,45@2058L267,58@2410L1459,55@2331L1538:NetworkUnavailableScreen.kt#nfxm87");
        int i6 = i2 & 1;
        if (i6 != 0) {
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
            if ((i2 & 2) != 0) {
                i5 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(networkUnavailableViewModel2) : composerStartRestartGroup.changedInstance(networkUnavailableViewModel2)) {
                    i5 = 32;
                } else {
                    i5 = 16;
                }
            }
            i3 |= i5;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i7 = i3;
        if (composerStartRestartGroup.shouldExecute((i7 & 147) != 146, i7 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "39@1915L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i7 &= -113;
                }
                modifier4 = modifier2;
            } else {
                modifier4 = i6 != 0 ? (Modifier) Modifier.Companion : modifier2;
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
                    z = false;
                    ViewModel viewModel = ViewModelKt.viewModel(NetworkUnavailableViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    NetworkUnavailableViewModel networkUnavailableViewModel3 = (NetworkUnavailableViewModel) viewModel;
                    i7 &= -113;
                    r5 = 1;
                    networkUnavailableViewModel2 = networkUnavailableViewModel3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(646733880, i7, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.NetworkUnavailableScreen (NetworkUnavailableScreen.kt:41)");
                }
                CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                if (context instanceof Activity) {
                    activity = (Activity) context;
                } else {
                    activity = null;
                }
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1258987986, "CC(remember):NetworkUnavailableScreen.kt#9igjgp");
                ?? r8 = ((((i7 & 112) ^ 48) > 32 || !composerStartRestartGroup.changedInstance(networkUnavailableViewModel2)) && (i7 & 48) != 32) ? z ? 1 : 0 : r5;
                r16 = z;
                if ((i7 & 896) == 256) {
                    r16 = r5;
                }
                i4 = r8 | r16;
                networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (i4 == 0 || networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                    networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue = new NetworkUnavailableScreenKt$NetworkUnavailableScreen$1$1(networkUnavailableViewModel2, function0, null);
                    composerStartRestartGroup.updateRememberedValue(networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2) networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue, composerStartRestartGroup, 6);
                ScaffoldKt.Scaffold-TvnljyQ(SizeKt.fillMaxSize$default(modifier4, 0.0f, (int) r5, (Object) null), ComposableSingletons$NetworkUnavailableScreenKt.INSTANCE.getLambda$1732889588$app_release(), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-122301303, (boolean) r5, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.NetworkUnavailableScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NetworkUnavailableScreenKt.NetworkUnavailableScreen$lambda$4(activity, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 508);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            z = false;
            r5 = 1;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(646733880, i7, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.NetworkUnavailableScreen (NetworkUnavailableScreen.kt:41)");
            }
            CompositionLocal localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume2;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1258987986, "CC(remember):NetworkUnavailableScreen.kt#9igjgp");
            if (((i7 & 112) ^ 48) > 32) {
            }
            r16 = z;
            if ((i7 & 896) == 256) {
                r16 = r5;
            }
            i4 = r8 | r16;
            networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (i4 == 0) {
                networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue = new NetworkUnavailableScreenKt$NetworkUnavailableScreen$1$1(networkUnavailableViewModel2, function0, null);
                composerStartRestartGroup.updateRememberedValue(networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue);
            } else {
                networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue = new NetworkUnavailableScreenKt$NetworkUnavailableScreen$1$1(networkUnavailableViewModel2, function0, null);
                composerStartRestartGroup.updateRememberedValue(networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit2, (Function2) networkUnavailableScreenKt$NetworkUnavailableScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            ScaffoldKt.Scaffold-TvnljyQ(SizeKt.fillMaxSize$default(modifier4, 0.0f, (int) r5, (Object) null), ComposableSingletons$NetworkUnavailableScreenKt.INSTANCE.getLambda$1732889588$app_release(), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-122301303, (boolean) r5, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.NetworkUnavailableScreenKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NetworkUnavailableScreenKt.NetworkUnavailableScreen$lambda$4(activity, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 508);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        final NetworkUnavailableViewModel networkUnavailableViewModel4 = networkUnavailableViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.NetworkUnavailableScreenKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return NetworkUnavailableScreenKt.NetworkUnavailableScreen$lambda$5(modifier3, networkUnavailableViewModel4, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NetworkUnavailableScreen$lambda$4(final Activity activity, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "innerPadding");
        ComposerKt.sourceInformation(composer, "C65@2706L11,59@2436L1427:NetworkUnavailableScreen.kt#nfxm87");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-122301303, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.NetworkUnavailableScreen.<anonymous> (NetworkUnavailableScreen.kt:59)");
            }
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.Companion, paddingValues), 0.0f, 1, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1727597817, "C69@2850L42,70@2931L11,67@2754L316,76@3112L57,78@3255L11,75@3083L353,86@3553L6,85@3483L30,84@3449L404:NetworkUnavailableScreen.kt#nfxm87");
            IconKt.Icon-ww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.global_cd_warning, composer, 0), SizeKt.size-3ABfNKs(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), Dp.constructor-impl(48)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary-0d7_KjU(), composer, 384, 0);
            float f = 16;
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_label_network_unavailable, composer, 0), PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(24), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 24624, 0, 261096);
            Shape medium = MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getMedium();
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(f), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 332845885, "CC(remember):NetworkUnavailableScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(activity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.NetworkUnavailableScreenKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        return NetworkUnavailableScreenKt.NetworkUnavailableScreen$lambda$4$lambda$3$lambda$2$lambda$1(activity);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.Button((Function0) objRememberedValue, modifier2, false, medium, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$NetworkUnavailableScreenKt.INSTANCE.getLambda$1290914287$app_release(), composer, 805306416, 500);
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
    public static final Unit NetworkUnavailableScreen$lambda$4$lambda$3$lambda$2$lambda$1(Activity activity) {
        if (activity != null) {
            activity.finishAffinity();
        }
        return Unit.INSTANCE;
    }
}
