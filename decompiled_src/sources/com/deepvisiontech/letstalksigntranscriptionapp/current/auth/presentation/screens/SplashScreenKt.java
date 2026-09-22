package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SplashScreenUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SplashScreenViewModel;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplashScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a=\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"SplashScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navigateToSetupScreen", "Lkotlin/Function0;", "navigateToSignInScreen", "splashScreenViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenViewModel;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenViewModel;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SplashScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashScreen$lambda$4(Modifier modifier, Function0 function0, Function0 function1, SplashScreenViewModel splashScreenViewModel, int i, int i2, Composer composer, int i3) {
        SplashScreen(modifier, function0, function1, splashScreenViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r15v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r5v16 */
    public static final void SplashScreen(Modifier modifier, final Function0<Unit> function0, final Function0<Unit> function1, SplashScreenViewModel splashScreenViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        SplashScreenViewModel splashScreenViewModel2;
        final Modifier modifier3;
        final SplashScreenViewModel splashScreenViewModel3;
        int i4;
        boolean z;
        int i5;
        SplashScreenViewModel splashScreenViewModel4;
        Modifier modifier4;
        CreationExtras defaultViewModelCreationExtras;
        ?? r15;
        int i6;
        SplashScreenKt$SplashScreen$1$1 splashScreenKt$SplashScreen$1$1;
        int i7;
        Intrinsics.checkNotNullParameter(function0, "navigateToSetupScreen");
        Intrinsics.checkNotNullParameter(function1, "navigateToSignInScreen");
        Composer composerStartRestartGroup = composer.startRestartGroup(69795683);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SplashScreen)24@1203L16,25@1248L32,27@1310L583,27@1286L607,54@2121L55,47@1899L283:SplashScreen.kt#qjj2jn");
        int i8 = i2 & 1;
        if (i8 != 0) {
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
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                splashScreenViewModel2 = splashScreenViewModel;
                if (composerStartRestartGroup.changedInstance(splashScreenViewModel2)) {
                    i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i7;
            } else {
                splashScreenViewModel2 = splashScreenViewModel;
            }
            i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i7;
        } else {
            splashScreenViewModel2 = splashScreenViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "22@1134L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                i5 = i3;
                splashScreenViewModel4 = splashScreenViewModel2;
                r15 = 1;
                modifier4 = modifier2;
                i4 = 0;
            } else {
                Modifier modifier5 = i8 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if ((i2 & 8) != 0) {
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
                    z = true;
                    i4 = 0;
                    ViewModel viewModel = ViewModelKt.viewModel(SplashScreenViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    splashScreenViewModel2 = (SplashScreenViewModel) viewModel;
                    i3 &= -7169;
                } else {
                    i4 = 0;
                    z = true;
                }
                i5 = i3;
                splashScreenViewModel4 = splashScreenViewModel2;
                modifier4 = modifier5;
                r15 = z;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(69795683, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SplashScreen (SplashScreen.kt:23)");
            }
            State stateCollectAsState = SnapshotStateKt.collectAsState(splashScreenViewModel4.getUiState(), (CoroutineContext) null, composerStartRestartGroup, i4, (int) r15);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1645815453, "CC(remember):SplashScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SplashScreenUiState splashScreenUiStateSplashScreen$lambda$0 = SplashScreen$lambda$0(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1645812918, "CC(remember):SplashScreen.kt#9igjgp");
            ?? r5 = (composerStartRestartGroup.changed(stateCollectAsState) ? 1 : 0) | ((i5 & 896) == 256 ? r15 : i4) | ((i5 & 112) == 32 ? r15 : i4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (r5 != 0 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                i6 = i4;
                splashScreenKt$SplashScreen$1$1 = new SplashScreenKt$SplashScreen$1$1(snackbarHostState, function1, function0, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(splashScreenKt$SplashScreen$1$1);
            } else {
                splashScreenKt$SplashScreen$1$1 = objRememberedValue2;
                i6 = i4;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(splashScreenUiStateSplashScreen$lambda$0, (Function2) splashScreenKt$SplashScreen$1$1, composerStartRestartGroup, i6);
            ScaffoldKt.Scaffold-TvnljyQ(modifier4, (Function2) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(-115215703, (boolean) r15, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SplashScreenKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return SplashScreenKt.SplashScreen$lambda$3(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableSingletons$SplashScreenKt.INSTANCE.m1383getLambda$1035923150$app_release(), composerStartRestartGroup, (i5 & 14) | 805309440, 502);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            splashScreenViewModel3 = splashScreenViewModel4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            splashScreenViewModel3 = splashScreenViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SplashScreenKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return SplashScreenKt.SplashScreen$lambda$4(modifier3, function0, function1, splashScreenViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashScreen$lambda$3(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C55@2135L31:SplashScreen.kt#qjj2jn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-115215703, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SplashScreen.<anonymous> (SplashScreen.kt:55)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3) null, composer, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SplashScreenUiState SplashScreen$lambda$0(State<? extends SplashScreenUiState> state) {
        return (SplashScreenUiState) state.getValue();
    }
}
