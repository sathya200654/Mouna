package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens;

import android.content.Context;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CheckboxDefaults;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
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
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.DisclaimerDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.GoogleSignInButton4Kt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialScreenUiEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: SignInPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"UserCredentialScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "credentialViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialViewModel;", "navigateToSetupScreen", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "showDialog", "", "isAgreementChecked"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SignInPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCredentialScreen$lambda$27(Modifier modifier, CredentialViewModel credentialViewModel, Function0 function0, int i, int i2, Composer composer, int i3) {
        UserCredentialScreen(modifier, credentialViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void UserCredentialScreen(Modifier modifier, CredentialViewModel credentialViewModel, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        CredentialViewModel credentialViewModel2;
        final CredentialViewModel credentialViewModel3;
        Modifier modifier3;
        final CredentialViewModel credentialViewModel4;
        CreationExtras defaultViewModelCreationExtras;
        final Context context;
        Intrinsics.checkNotNullParameter(function0, "navigateToSetupScreen");
        Composer composerStartRestartGroup = composer.startRestartGroup(1831786170);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UserCredentialScreen)P(1)59@2897L7,60@2933L32,62@2989L34,63@3054L34,69@3208L394,69@3187L415,103@4282L35,104@4337L5533,89@3775L6101:SignInPage.kt#qjj2jn");
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
            if ((i2 & 2) == 0) {
                credentialViewModel2 = credentialViewModel;
                int i5 = composerStartRestartGroup.changedInstance(credentialViewModel2) ? 32 : 16;
                i3 |= i5;
            } else {
                credentialViewModel2 = credentialViewModel;
            }
            i3 |= i5;
        } else {
            credentialViewModel2 = credentialViewModel;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        boolean z = false;
        boolean z2 = true;
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "56@2807L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                modifier3 = modifier2;
                credentialViewModel4 = credentialViewModel2;
                z = false;
                z2 = true;
            } else {
                Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel(CredentialViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    credentialViewModel2 = (CredentialViewModel) viewModel;
                    i3 &= -113;
                }
                modifier3 = modifier4;
                credentialViewModel4 = credentialViewModel2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1831786170, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.UserCredentialScreen (SignInPage.kt:58)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context2 = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -590072806, "CC(remember):SignInPage.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -590071012, "CC(remember):SignInPage.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -590068932, "CC(remember):SignInPage.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SharedFlow<CredentialScreenUiEvent> uiEvent = credentialViewModel4.getUiEvent();
            final long jColor = ColorKt.Color(4294965243L);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -590063644, "CC(remember):SignInPage.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(uiEvent) | composerStartRestartGroup.changedInstance(context2);
            if ((i3 & 896) == 256) {
                z = z2;
            }
            boolean z3 = zChangedInstance | z;
            SignInPageKt$UserCredentialScreen$1$1 signInPageKt$UserCredentialScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || signInPageKt$UserCredentialScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                context = context2;
                signInPageKt$UserCredentialScreen$1$1RememberedValue = new SignInPageKt$UserCredentialScreen$1$1(uiEvent, snackbarHostState, context, function0, null);
                composerStartRestartGroup.updateRememberedValue(signInPageKt$UserCredentialScreen$1$1RememberedValue);
            } else {
                context = context2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2) signInPageKt$UserCredentialScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            if (!UserCredentialScreen$lambda$2(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(-1115299320);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1111698825);
                ComposerKt.sourceInformation(composerStartRestartGroup, "84@3683L22,85@3731L22,83@3634L129");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -590048816, "CC(remember):SignInPage.kt#9igjgp");
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            return SignInPageKt.UserCredentialScreen$lambda$9$lambda$8(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function0 function1 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -590047280, "CC(remember):SignInPage.kt#9igjgp");
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            return SignInPageKt.UserCredentialScreen$lambda$11$lambda$10(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                DisclaimerDialogKt.DisclaimerDialog(null, function1, (Function0) objRememberedValue5, composerStartRestartGroup, 432, 1);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, z2, (Object) null);
            Function2<Composer, Integer, Unit> function2M1382getLambda$130017922$app_release = ComposableSingletons$SignInPageKt.INSTANCE.m1382getLambda$130017922$app_release();
            Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-6736256, z2, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    return SignInPageKt.UserCredentialScreen$lambda$12(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            CredentialViewModel credentialViewModel5 = credentialViewModel4;
            Function3 function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-605016119, z2, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignInPageKt.UserCredentialScreen$lambda$26(jColor, credentialViewModel4, context, mutableState, mutableState2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            modifier2 = modifier3;
            Composer composer2 = composerStartRestartGroup;
            ScaffoldKt.Scaffold-TvnljyQ(modifierFillMaxSize$default, function2M1382getLambda$130017922$app_release, (Function2) null, function2RememberComposableLambda, (Function2) null, 0, 0L, 0L, (WindowInsets) null, function3RememberComposableLambda, composer2, 805309488, 500);
            composerStartRestartGroup = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            credentialViewModel3 = credentialViewModel5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            credentialViewModel3 = credentialViewModel2;
        }
        final Modifier modifier5 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    return SignInPageKt.UserCredentialScreen$lambda$27(modifier5, credentialViewModel3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean UserCredentialScreen$lambda$2(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void UserCredentialScreen$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean UserCredentialScreen$lambda$5(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void UserCredentialScreen$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCredentialScreen$lambda$9$lambda$8(MutableState mutableState) {
        UserCredentialScreen$lambda$3(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCredentialScreen$lambda$11$lambda$10(MutableState mutableState) {
        UserCredentialScreen$lambda$3(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCredentialScreen$lambda$12(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C103@4284L31:SignInPage.kt#qjj2jn");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6736256, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.UserCredentialScreen.<anonymous> (SignInPage.kt:103)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3) null, composer, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCredentialScreen$lambda$26(final long j, final CredentialViewModel credentialViewModel, final Context context, final MutableState mutableState, final MutableState mutableState2, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "C105@4368L5492:SignInPage.kt#qjj2jn");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-605016119, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.UserCredentialScreen.<anonymous> (SignInPage.kt:105)");
            }
            float f = 16;
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues), Dp.constructor-impl(f), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, 978515702, "C117@4844L38,118@4901L4945,111@4572L5274:SignInPage.kt#qjj2jn");
            CardKt.Card(PaddingKt.padding-qDBjuR0$default(ColumnScope.weight$default(columnScope, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(f), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(f)), (CardColors) null, CardDefaults.INSTANCE.cardElevation-aqJV_2Y(Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer, (CardDefaults.$stable << 18) | 6, 62), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(767346401, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignInPageKt.UserCredentialScreen$lambda$26$lambda$25$lambda$24(j, credentialViewModel, context, mutableState, mutableState2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 196608, 20);
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
    public static final Unit UserCredentialScreen$lambda$26$lambda$25$lambda$24(long j, final CredentialViewModel credentialViewModel, final Context context, final MutableState mutableState, final MutableState mutableState2, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$Card");
        ComposerKt.sourceInformation(composer, "C119@4923L4905:SignInPage.kt#qjj2jn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(767346401, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.UserCredentialScreen.<anonymous>.<anonymous>.<anonymous> (SignInPage.kt:119)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -637597833, "C122@5034L42,121@4989L293,128@5308L4498:SignInPage.kt#qjj2jn");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.signup_bg, composer, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            float f = 16;
            Modifier modifier = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f));
            Arrangement.Vertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifier);
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
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1446532783, "C135@5671L942,151@6643L3137:SignInPage.kt#qjj2jn");
            Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier2 = Modifier.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(vertical, centerHorizontally2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifier2);
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
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1021711826, "C140@5962L44,141@6065L53,139@5909L321,145@6316L44,146@6419L53,144@6263L320:SignInPage.kt#qjj2jn");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.lts_logo_hd, composer, 0), StringResources_androidKt.stringResource(R.string.auth_credentials_cd_logo_lts, composer, 0), SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(160), Dp.constructor-impl(120)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 384, 120);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.dvt_logo_hd, composer, 0), StringResources_androidKt.stringResource(R.string.auth_credentials_cd_logo_dvt, composer, 0), SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(264), Dp.constructor-impl(64)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 384, 120);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierWeight = columnScope2.weight(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false);
            Arrangement.Vertical bottom = Arrangement.INSTANCE.getBottom();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(bottom, Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierWeight);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composer5 = Updater.constructor-impl(composer);
            Updater.set-impl(composer5, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer5, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -335235424, "C158@7004L51,159@7109L50,167@7627L21,157@6955L793,171@7782L1194:SignInPage.kt#qjj2jn");
            String str = StringResources_androidKt.stringResource(R.string.auth_disclaimer_title_info, composer, 0) + "\n" + StringResources_androidKt.stringResource(R.string.auth_disclaimer_desc_info, composer, 0);
            int i2 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            int i3 = TextAlign.Companion.getStart-e0LSkKk();
            long sp = TextUnitKt.getSp(16);
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScope4, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1097583341, "CC(remember):SignInPage.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return SignInPageKt.UserCredentialScreen$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22$lambda$21$lambda$15$lambda$14(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            float f2 = 8;
            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifierWeight$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue, 15, (Object) null), 0.0f, Dp.constructor-impl(f2), 1, (Object) null), j, (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i3), 0L, i2, false, 0, 0, (Function1) null, (TextStyle) null, composer, 24960, 384, 257000);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Modifier modifier3 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(f2), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifier3);
            Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            Composer composer6 = Updater.constructor-impl(composer);
            Updater.set-impl(composer6, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer6, Integer.valueOf(iHashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1981920569, "C177@8162L44,180@8434L11,178@8274L295,175@8024L583,186@8698L57,185@8645L297:SignInPage.kt#qjj2jn");
            boolean zUserCredentialScreen$lambda$5 = UserCredentialScreen$lambda$5(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composer, 618125792, "CC(remember):SignInPage.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return SignInPageKt.UserCredentialScreen$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22$lambda$21$lambda$18$lambda$17$lambda$16(mutableState2, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CheckboxKt.Checkbox(zUserCredentialScreen$lambda$5, (Function1) objRememberedValue2, (Modifier) null, false, CheckboxDefaults.INSTANCE.colors-5tl4gsc(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), j, Color.Companion.getWhite-0d7_KjU(), 0L, 0L, 0L, composer, (CheckboxDefaults.$stable << 18) | 432, 56), (MutableInteractionSource) null, composer, 48, 44);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.auth_credentials_label_agreement, composer, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(f2), 0.0f, 0.0f, 0.0f, 14, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 432, 0, 262136);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (UserCredentialScreen$lambda$5(mutableState2)) {
                composer.startReplaceGroup(-333241195);
                ComposerKt.sourceInformation(composer, "194@9139L55,195@9250L63,197@9424L135,193@9072L525");
                String strStringResource = StringResources_androidKt.stringResource(R.string.auth_credentials_action_signin, composer, 0);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.auth_credentials_action_signin_loading, composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, 1097640959, "CC(remember):SignInPage.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(credentialViewModel) | composer.changedInstance(context);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            return SignInPageKt.UserCredentialScreen$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19(credentialViewModel, context);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                GoogleSignInButton4Kt.GoogleSignInButton(strStringResource, strStringResource2, false, null, (Function0) objRememberedValue3, composer, 384, 8);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-332658023);
                ComposerKt.sourceInformation(composer, "202@9675L41");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), composer, 6);
                composer.endReplaceGroup();
            }
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
    public static final Unit UserCredentialScreen$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22$lambda$21$lambda$15$lambda$14(MutableState mutableState) {
        UserCredentialScreen$lambda$3(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCredentialScreen$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22$lambda$21$lambda$18$lambda$17$lambda$16(MutableState mutableState, boolean z) {
        UserCredentialScreen$lambda$6(mutableState, !UserCredentialScreen$lambda$5(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCredentialScreen$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19(CredentialViewModel credentialViewModel, Context context) {
        credentialViewModel.fetchAndSaveMailId(context);
        return Unit.INSTANCE;
    }
}
