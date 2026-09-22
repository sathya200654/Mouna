package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens;

import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.ContextCompat;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpScreenEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpScreenUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorComponentKt;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: SetupScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a`\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"SetupScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "setUpViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpViewModel;", "navigateToOnBoardingScreen", "Lkotlin/Function0;", "navigateToConversationScreen", "navigateToNotification", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "notificationId", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenUiState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SetupScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit SetupScreen$lambda$12(Modifier modifier, SetUpViewModel setUpViewModel, Function0 function0, Function0 function1, Function1 function2, int i, int i2, Composer composer, int i3) throws NoWhenBranchMatchedException {
        SetupScreen(modifier, setUpViewModel, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:23:0x005f  */
    public static final void SetupScreen(Modifier modifier, SetUpViewModel setUpViewModel, final Function0<Unit> function0, final Function0<Unit> function1, final Function1<? super String, Unit> function2, Composer composer, final int i, final int i2) throws NoWhenBranchMatchedException {
        Modifier modifier2;
        int i3;
        final SetUpViewModel setUpViewModel2;
        final Modifier modifier3;
        int i4;
        int i5;
        final SetUpViewModel setUpViewModel3;
        Modifier modifier4;
        int i6;
        Unit unit;
        int i7;
        int i8;
        SetupScreenKt$SetupScreen$1$1 setupScreenKt$SetupScreen$1$1;
        final SetUpViewModel setUpViewModel4;
        int i9;
        Intrinsics.checkNotNullParameter(function0, "navigateToOnBoardingScreen");
        Intrinsics.checkNotNullParameter(function1, "navigateToConversationScreen");
        Intrinsics.checkNotNullParameter(function2, "navigateToNotification");
        Composer composerStartRestartGroup = composer.startRestartGroup(775498774);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SetupScreen)P(!1,4,3)42@2135L16,44@2223L7,48@2365L73,46@2261L177,52@2465L488,52@2444L509,72@3143L11,68@2959L2828:SetupScreen.kt#qjj2jn");
        int i10 = i2 & 1;
        if (i10 != 0) {
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
                i9 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(setUpViewModel) : composerStartRestartGroup.changedInstance(setUpViewModel)) {
                    i9 = 32;
                } else {
                    i9 = 16;
                }
            }
            i3 |= i9;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "37@1921L15");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                Modifier modifier5 = modifier2;
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
                    CreationExtras defaultViewModelCreationExtras = current instanceof HasDefaultViewModelProviderFactory ? current.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
                    i5 = 32;
                    ViewModel viewModel = ViewModelKt.viewModel(SetUpViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    setUpViewModel3 = (SetUpViewModel) viewModel;
                    i6 = i3 & (-113);
                    modifier4 = modifier5;
                    i4 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    int i11 = i3;
                    i4 = 2048;
                    i5 = 32;
                    setUpViewModel3 = setUpViewModel;
                    modifier4 = modifier5;
                    i6 = i11;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                setUpViewModel3 = setUpViewModel;
                modifier4 = modifier2;
                i6 = i3;
                i4 = 2048;
                i5 = 32;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(775498774, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SetupScreen (SetupScreen.kt:41)");
            }
            State stateCollectAsState = SnapshotStateKt.collectAsState(setUpViewModel3.getUiState(), (CoroutineContext) null, composerStartRestartGroup, 0, 1);
            SharedFlow<SetUpScreenEvent> events = setUpViewModel3.getEvents();
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            ActivityResultContract requestPermission = new ActivityResultContracts.RequestPermission();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2069970177, "CC(remember):SetupScreen.kt#9igjgp");
            int i12 = (i6 & 112) ^ 48;
            boolean z = (i12 > i5 && composerStartRestartGroup.changedInstance(setUpViewModel3)) || (i6 & 48) == i5;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SetupScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return SetupScreenKt.SetupScreen$lambda$2$lambda$1(setUpViewModel3, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2069966562, "CC(remember):SetupScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(events) | ((i6 & 7168) == i4) | ((i6 & 896) == 256) | ((57344 & i6) == 16384);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                unit = unit2;
                i7 = 1;
                i8 = 32;
                setupScreenKt$SetupScreen$1$1 = new SetupScreenKt$SetupScreen$1$1(events, function1, function0, function2, null);
                composerStartRestartGroup.updateRememberedValue(setupScreenKt$SetupScreen$1$1);
            } else {
                unit = unit2;
                setupScreenKt$SetupScreen$1$1 = objRememberedValue2;
                i7 = 1;
                i8 = 32;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2) setupScreenKt$SetupScreen$1$1, composerStartRestartGroup, 6);
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Modifier modifier6 = modifier4;
            float f = 16;
            Modifier modifier7 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxSize$default(BackgroundKt.background-bw27NRU$default(modifier4, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, i7, (Object) null), Dp.constructor-impl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
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
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2049185236, "C:SetupScreen.kt#qjj2jn");
            SetUpScreenUiState setUpScreenUiStateSetupScreen$lambda$0 = SetupScreen$lambda$0(stateCollectAsState);
            if (Intrinsics.areEqual(setUpScreenUiStateSetupScreen$lambda$0, SetUpScreenUiState.PromptEnvironmentRecognition.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(2049253125);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@3381L54,81@3529L10,82@3593L11,78@3348L287,84@3652L40,86@3742L62,88@3898L10,89@3963L11,85@3709L300,91@4026L41,92@4084L1021");
                final SetUpViewModel setUpViewModel5 = setUpViewModel3;
                int i13 = i6;
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.setup_sound_recognition_query, composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, 0, 0, 130042);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composerStartRestartGroup, 6);
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.setup_sound_recognition_settings_desc, composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 0, 0, 130042);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), composerStartRestartGroup, 6);
                Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f));
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier modifier8 = Modifier.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier8);
                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1278956979, "C96@4286L37,96@4269L151,99@4458L532,99@4441L646:SetupScreen.kt#qjj2jn");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1288182903, "CC(remember):SetupScreen.kt#9igjgp");
                boolean z2 = (i12 > 32 && composerStartRestartGroup.changedInstance(setUpViewModel5)) || (i13 & 48) == 32;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SetupScreenKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return SetupScreenKt.SetupScreen$lambda$11$lambda$8$lambda$5$lambda$4(setUpViewModel5);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                setUpViewModel4 = setUpViewModel5;
                ButtonKt.Button((Function0) objRememberedValue3, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SetupScreenKt.INSTANCE.m1379getLambda$17721964$app_release(), composerStartRestartGroup, 805306368, 510);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1288176904, "CC(remember):SetupScreen.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(context) | ((i12 > 32 && composerStartRestartGroup.changedInstance(setUpViewModel4)) || (i13 & 48) == 32) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SetupScreenKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            return SetupScreenKt.SetupScreen$lambda$11$lambda$8$lambda$7$lambda$6(context, setUpViewModel4, managedActivityResultLauncherRememberLauncherForActivityResult);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonKt.Button((Function0) objRememberedValue4, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SetupScreenKt.INSTANCE.getLambda$355747517$app_release(), composerStartRestartGroup, 805306368, 510);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                setUpViewModel4 = setUpViewModel3;
                int i14 = i6;
                if (setUpScreenUiStateSetupScreen$lambda$0 instanceof SetUpScreenUiState.Error) {
                    composerStartRestartGroup.startReplaceGroup(2051032556);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "118@5215L32,119@5291L11,121@5402L10,117@5182L258,123@5457L41,124@5532L28,124@5515L137");
                    int i15 = i8;
                    TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(((SetUpScreenUiState.Error) setUpScreenUiStateSetupScreen$lambda$0).getMessageRes(), composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, 0, 0, 130042);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1728741628, "CC(remember):SetupScreen.kt#9igjgp");
                    boolean z3 = (i12 > i15 && composerStartRestartGroup.changedInstance(setUpViewModel4)) || (i14 & 48) == i15;
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SetupScreenKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                return SetupScreenKt.SetupScreen$lambda$11$lambda$10$lambda$9(setUpViewModel4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ButtonKt.Button((Function0) objRememberedValue5, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SetupScreenKt.INSTANCE.m1380getLambda$462509329$app_release(), composerStartRestartGroup, 805306368, 510);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (!Intrinsics.areEqual(setUpScreenUiStateSetupScreen$lambda$0, SetUpScreenUiState.IsLoading.INSTANCE)) {
                        composerStartRestartGroup.startReplaceGroup(1728670735);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(2051562439);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "130@5730L27");
                    CircularProgressIndicatorComponentKt.CircularProgressComponent(null, composerStartRestartGroup, 0, 1);
                    composerStartRestartGroup.endReplaceGroup();
                }
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
            setUpViewModel2 = setUpViewModel4;
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            setUpViewModel2 = setUpViewModel;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SetupScreenKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    return SetupScreenKt.SetupScreen$lambda$12(modifier3, setUpViewModel2, function0, function1, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$2$lambda$1(SetUpViewModel setUpViewModel, boolean z) {
        setUpViewModel.onPermissionResult(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$11$lambda$8$lambda$5$lambda$4(SetUpViewModel setUpViewModel) {
        setUpViewModel.onSkipPermission();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$11$lambda$8$lambda$7$lambda$6(Context context, SetUpViewModel setUpViewModel, ManagedActivityResultLauncher managedActivityResultLauncher) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0) {
            setUpViewModel.onPermissionResult(true);
        } else {
            managedActivityResultLauncher.launch("android.permission.RECORD_AUDIO");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$11$lambda$10$lambda$9(SetUpViewModel setUpViewModel) {
        setUpViewModel.onRetry();
        return Unit.INSTANCE;
    }

    private static final SetUpScreenUiState SetupScreen$lambda$0(State<? extends SetUpScreenUiState> state) {
        return (SetUpScreenUiState) state.getValue();
    }
}
