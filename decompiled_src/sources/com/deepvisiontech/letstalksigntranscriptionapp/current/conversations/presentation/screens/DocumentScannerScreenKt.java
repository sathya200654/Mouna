package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import android.content.Context;
import androidx.camera.compose.CameraXViewfinderKt;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.viewfinder.compose.MutableCoordinateTransformer;
import androidx.camera.viewfinder.core.ImplementationMode;
import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CameraKt;
import androidx.compose.material.icons.filled.WarningKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
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
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
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
import androidx.core.content.ContextCompat;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.ConversationSharedViewModel;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerAction;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerViewModel;
import com.google.accompanist.permissions.PermissionState;
import com.google.accompanist.permissions.PermissionStateKt;
import com.google.accompanist.permissions.PermissionStatus;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: DocumentScannerScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"DocumentScannerScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navigateBack", "Lkotlin/Function0;", "conversationSharedViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/presentation/viewmodels/ConversationSharedViewModel;", "documentScannerViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerViewModel;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/presentation/viewmodels/ConversationSharedViewModel;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerViewModel;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DocumentScannerScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentScannerScreen$lambda$31(Modifier modifier, Function0 function0, ConversationSharedViewModel conversationSharedViewModel, DocumentScannerViewModel documentScannerViewModel, int i, int i2, Composer composer, int i3) {
        DocumentScannerScreen(modifier, function0, conversationSharedViewModel, documentScannerViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0082  */
    public static final void DocumentScannerScreen(Modifier modifier, final Function0<Unit> function0, ConversationSharedViewModel conversationSharedViewModel, DocumentScannerViewModel documentScannerViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final DocumentScannerViewModel documentScannerViewModel2;
        final Modifier modifier3;
        DocumentScannerViewModel documentScannerViewModel3;
        int i4;
        Modifier modifier4;
        CreationExtras defaultViewModelCreationExtras;
        final Context context;
        final SnackbarHostState snackbarHostState;
        DocumentScannerScreenKt$DocumentScannerScreen$1$1 documentScannerScreenKt$DocumentScannerScreen$1$1;
        final State state;
        int i5;
        final ConversationSharedViewModel conversationSharedViewModel2 = conversationSharedViewModel;
        Intrinsics.checkNotNullParameter(function0, "navigateBack");
        Intrinsics.checkNotNullParameter(conversationSharedViewModel2, "conversationSharedViewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-316611091);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DocumentScannerScreen)P(2,3)72@3790L7,73@3843L7,74@3903L29,76@4012L32,78@4071L468,78@4050L489,94@4625L114,94@4573L166,98@4790L255,98@4745L300,105@5095L591,105@5051L635,125@5822L172,131@6016L3078,124@5768L35,193@9101L2095,122@5692L5504:DocumentScannerScreen.kt#6g1srx");
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
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(conversationSharedViewModel2) : composerStartRestartGroup.changedInstance(conversationSharedViewModel2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) != 0) {
                i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            } else {
                if ((i & 4096) == 0 ? composerStartRestartGroup.changed(documentScannerViewModel) : composerStartRestartGroup.changedInstance(documentScannerViewModel)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
            }
            i3 |= i5;
        }
        int i7 = i3;
        if (composerStartRestartGroup.shouldExecute((i7 & 1171) != 1170, i7 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "70@3739L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i7 &= -7169;
                }
                documentScannerViewModel3 = documentScannerViewModel;
                i4 = i7;
                modifier4 = modifier2;
            } else {
                Modifier modifier5 = i6 != 0 ? (Modifier) Modifier.Companion : modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel(DocumentScannerViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    documentScannerViewModel3 = (DocumentScannerViewModel) viewModel;
                    i4 = i7 & (-7169);
                    modifier4 = modifier5;
                } else {
                    documentScannerViewModel3 = documentScannerViewModel;
                    i4 = i7;
                    modifier4 = modifier5;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-316611091, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreen (DocumentScannerScreen.kt:71)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context2 = (Context) objConsume;
            CompositionLocal localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume2;
            int i8 = i4;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(documentScannerViewModel3.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            SharedFlow<DocumentScannerEvent> uiEvent = documentScannerViewModel3.getUiEvent();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 679436813, "CC(remember):DocumentScannerScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 679439137, "CC(remember):DocumentScannerScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(uiEvent) | composerStartRestartGroup.changedInstance(context2) | ((i8 & 896) == 256 || ((i8 & 512) != 0 && composerStartRestartGroup.changedInstance(conversationSharedViewModel2)));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                context = context2;
                snackbarHostState = snackbarHostState2;
                conversationSharedViewModel2 = conversationSharedViewModel;
                documentScannerScreenKt$DocumentScannerScreen$1$1 = new DocumentScannerScreenKt$DocumentScannerScreen$1$1(uiEvent, snackbarHostState, context, conversationSharedViewModel, null);
                composerStartRestartGroup.updateRememberedValue(documentScannerScreenKt$DocumentScannerScreen$1$1);
            } else {
                snackbarHostState = snackbarHostState2;
                context = context2;
                documentScannerScreenKt$DocumentScannerScreen$1$1 = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2) documentScannerScreenKt$DocumentScannerScreen$1$1, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 679456511, "CC(remember):DocumentScannerScreen.kt#9igjgp");
            int i9 = (i8 & 7168) ^ 3072;
            final DocumentScannerViewModel documentScannerViewModel4 = documentScannerViewModel3;
            boolean z = (i9 > 2048 && composerStartRestartGroup.changedInstance(documentScannerViewModel4)) || (i8 & 3072) == 2048;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        return DocumentScannerScreenKt.DocumentScannerScreen$lambda$4$lambda$3(documentScannerViewModel4, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PermissionState permissionStateRememberPermissionState = PermissionStateKt.rememberPermissionState("android.permission.CAMERA", (Function1) objRememberedValue3, composerStartRestartGroup, 6, 0);
            PermissionStatus status = permissionStateRememberPermissionState.getStatus();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 679461932, "CC(remember):DocumentScannerScreen.kt#9igjgp");
            boolean zChanged = ((i9 > 2048 && composerStartRestartGroup.changedInstance(documentScannerViewModel4)) || (i8 & 3072) == 2048) | composerStartRestartGroup.changed(permissionStateRememberPermissionState);
            DocumentScannerScreenKt$DocumentScannerScreen$2$1 documentScannerScreenKt$DocumentScannerScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || documentScannerScreenKt$DocumentScannerScreen$2$1RememberedValue == Composer.Companion.getEmpty()) {
                documentScannerScreenKt$DocumentScannerScreen$2$1RememberedValue = new DocumentScannerScreenKt$DocumentScannerScreen$2$1(documentScannerViewModel4, permissionStateRememberPermissionState, null);
                composerStartRestartGroup.updateRememberedValue(documentScannerScreenKt$DocumentScannerScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(status, (Function2) documentScannerScreenKt$DocumentScannerScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            Boolean boolValueOf = Boolean.valueOf(DocumentScannerScreen$lambda$0(stateCollectAsStateWithLifecycle).isPermissionGranted());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 679472028, "CC(remember):DocumentScannerScreen.kt#9igjgp");
            boolean zChanged2 = ((i9 > 2048 && composerStartRestartGroup.changedInstance(documentScannerViewModel4)) || (i8 & 3072) == 2048) | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(lifecycleOwner);
            DocumentScannerScreenKt$DocumentScannerScreen$3$1 documentScannerScreenKt$DocumentScannerScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || documentScannerScreenKt$DocumentScannerScreen$3$1RememberedValue == Composer.Companion.getEmpty()) {
                documentScannerViewModel2 = documentScannerViewModel4;
                state = stateCollectAsStateWithLifecycle;
                documentScannerScreenKt$DocumentScannerScreen$3$1RememberedValue = new DocumentScannerScreenKt$DocumentScannerScreen$3$1(context, lifecycleOwner, documentScannerViewModel4, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(documentScannerScreenKt$DocumentScannerScreen$3$1RememberedValue);
            } else {
                state = stateCollectAsStateWithLifecycle;
                documentScannerViewModel2 = documentScannerViewModel4;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) documentScannerScreenKt$DocumentScannerScreen$3$1RememberedValue, composerStartRestartGroup, 0);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
            Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-223811151, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentScannerScreenKt.DocumentScannerScreen$lambda$7(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            Function2 function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1060606094, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentScannerScreenKt.DocumentScannerScreen$lambda$17(state, documentScannerViewModel2, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            Function2 function2RememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1897401037, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentScannerScreenKt.DocumentScannerScreen$lambda$18(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            Function3 function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-558465604, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DocumentScannerScreenKt.DocumentScannerScreen$lambda$30(documentScannerViewModel2, conversationSharedViewModel2, function0, state, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            Composer composer2 = composerStartRestartGroup;
            Modifier modifier6 = modifier4;
            ScaffoldKt.Scaffold-TvnljyQ(modifierFillMaxSize$default, function2RememberComposableLambda, function2RememberComposableLambda2, function2RememberComposableLambda3, (Function2) null, 0, 0L, 0L, (WindowInsets) null, function3RememberComposableLambda, composer2, 805309872, 496);
            composerStartRestartGroup = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            documentScannerViewModel2 = documentScannerViewModel;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentScannerScreenKt.DocumentScannerScreen$lambda$31(modifier3, function0, conversationSharedViewModel2, documentScannerViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit DocumentScannerScreen$lambda$4$lambda$3(DocumentScannerViewModel documentScannerViewModel, boolean z) throws NoWhenBranchMatchedException {
        documentScannerViewModel.onAction(new DocumentScannerAction.PermissionChanged(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentScannerScreen$lambda$18(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C124@5770L31:DocumentScannerScreen.kt#6g1srx");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1897401037, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreen.<anonymous> (DocumentScannerScreen.kt:124)");
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
    public static final Unit DocumentScannerScreen$lambda$7(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C127@5874L51,126@5836L148:DocumentScannerScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-223811151, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreen.<anonymous> (DocumentScannerScreen.kt:126)");
            }
            SimpleTopBarKt.SimpleTopBar(null, StringResources_androidKt.stringResource(R.string.conversation_scanner_title, composer, 0), function0, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentScannerScreen$lambda$17(final State state, final DocumentScannerViewModel documentScannerViewModel, final Context context, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C135@6139L27,136@6209L38,137@6262L2822,132@6030L3054:DocumentScannerScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1060606094, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreen.<anonymous> (DocumentScannerScreen.kt:132)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -1335203219, "CC(remember):DocumentScannerScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return DocumentScannerScreenKt.DocumentScannerScreen$lambda$17$lambda$9$lambda$8((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CardKt.Card(SemanticsModifierKt.semantics$default(modifierFillMaxWidth$default, false, (Function1) objRememberedValue, 1, (Object) null), (Shape) null, (CardColors) null, CardDefaults.INSTANCE.cardElevation-aqJV_2Y(Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer, (CardDefaults.$stable << 18) | 6, 62), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(378744292, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DocumentScannerScreenKt.DocumentScannerScreen$lambda$17$lambda$16(state, documentScannerViewModel, context, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 196608, 22);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentScannerScreen$lambda$17$lambda$9$lambda$8(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentScannerScreen$lambda$17$lambda$16(final State state, final DocumentScannerViewModel documentScannerViewModel, final Context context, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$Card");
        ComposerKt.sourceInformation(composer, "C139@6362L2708:DocumentScannerScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(378744292, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreen.<anonymous>.<anonymous> (DocumentScannerScreen.kt:138)");
            }
            boolean z = DocumentScannerScreen$lambda$0(state).isPermissionGranted() && !DocumentScannerScreen$lambda$0(state).isCapturing();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(WindowInsetsPadding_androidKt.navigationBarsPadding(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4))), 0.0f, 1, (Object) null);
            Arrangement.Horizontal center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
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
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1760173838, "C147@6726L56,148@6825L59,154@7107L212,158@7355L956,174@8334L718,150@6906L2146:DocumentScannerScreen.kt#6g1srx");
            final String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_scanner_cd_capture, composer, 0);
            final String strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_scanner_cd_processing, composer, 0);
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            ComposerKt.sourceInformationMarkerStart(composer, -1857884452, "CC(remember):DocumentScannerScreen.kt#9igjgp");
            boolean zChanged = composer.changed(state) | composer.changed(strStringResource2) | composer.changed(strStringResource);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        return DocumentScannerScreenKt.DocumentScannerScreen$lambda$17$lambda$16$lambda$15$lambda$11$lambda$10(strStringResource2, strStringResource, state, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierMinimumInteractiveComponentSize, false, (Function1) objRememberedValue, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -1857875772, "CC(remember):DocumentScannerScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(documentScannerViewModel) | composer.changedInstance(context);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        return DocumentScannerScreenKt.DocumentScannerScreen$lambda$17$lambda$16$lambda$15$lambda$13$lambda$12(documentScannerViewModel, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue2, modifierSemantics$default, z, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(1757814886, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentScannerScreenKt.DocumentScannerScreen$lambda$17$lambda$16$lambda$15$lambda$14(state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 56);
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
    public static final Unit DocumentScannerScreen$lambda$17$lambda$16$lambda$15$lambda$11$lambda$10(String str, String str2, State state, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        if (!DocumentScannerScreen$lambda$0(state).isCapturing()) {
            str = null;
        }
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, String.valueOf(str));
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit DocumentScannerScreen$lambda$17$lambda$16$lambda$15$lambda$13$lambda$12(final DocumentScannerViewModel documentScannerViewModel, Context context) throws NoWhenBranchMatchedException {
        documentScannerViewModel.onAction(DocumentScannerAction.CaptureButtonClicked.INSTANCE);
        documentScannerViewModel.getImageCaptureUseCase().takePicture(ContextCompat.getMainExecutor(context), new ImageCapture.OnImageCapturedCallback() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$DocumentScannerScreen$5$2$1$2$1$1
            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            public void onCaptureSuccess(ImageProxy image) throws NoWhenBranchMatchedException {
                Intrinsics.checkNotNullParameter(image, "image");
                documentScannerViewModel.onAction(new DocumentScannerAction.ImageCaptured(image));
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            public void onError(ImageCaptureException exception) throws NoWhenBranchMatchedException {
                Intrinsics.checkNotNullParameter(exception, "exception");
                DocumentScannerViewModel documentScannerViewModel2 = documentScannerViewModel;
                String message = exception.getMessage();
                if (message == null) {
                    message = "Unknown";
                }
                documentScannerViewModel2.onAction(new DocumentScannerAction.CaptureFailed(message));
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentScannerScreen$lambda$17$lambda$16$lambda$15$lambda$14(State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:DocumentScannerScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757814886, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DocumentScannerScreen.kt:175)");
            }
            if (DocumentScannerScreen$lambda$0(state).isCapturing()) {
                composer.startReplaceGroup(-1472911997);
                ComposerKt.sourceInformation(composer, "176@8415L225");
                ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), Color.Companion.getWhite-0d7_KjU(), Dp.constructor-impl(2), 0L, 0, 0.0f, composer, 438, 56);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1472624906);
                ComposerKt.sourceInformation(composer, "185@8888L11,182@8702L302");
                IconKt.Icon-ww6aTOc(CameraKt.getCamera(Icons.INSTANCE.getDefault()), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), composer, 432, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentScannerScreen$lambda$30(final DocumentScannerViewModel documentScannerViewModel, final ConversationSharedViewModel conversationSharedViewModel, final Function0 function0, State state, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "C194@9128L2062:DocumentScannerScreen.kt#6g1srx");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-558465604, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreen.<anonymous> (DocumentScannerScreen.kt:194)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1004926286, "C:DocumentScannerScreen.kt#6g1srx");
            if (DocumentScannerScreen$lambda$0(state).isEditDialogVisible()) {
                composer.startReplaceGroup(1004915497);
                ComposerKt.sourceInformation(composer, "204@9477L124,207@9634L143,201@9312L483");
                Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8));
                String scannedText = DocumentScannerScreen$lambda$0(state).getScannedText();
                ComposerKt.sourceInformationMarkerStart(composer, 170969426, "CC(remember):DocumentScannerScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(documentScannerViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return DocumentScannerScreenKt.DocumentScannerScreen$lambda$30$lambda$29$lambda$20$lambda$19(documentScannerViewModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function1 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 170974469, "CC(remember):DocumentScannerScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(conversationSharedViewModel) | composer.changed(function0);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            return DocumentScannerScreenKt.DocumentScannerScreen$lambda$30$lambda$29$lambda$22$lambda$21(conversationSharedViewModel, function0, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                str = "CC(remember):DocumentScannerScreen.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                TextEditDialogKt.TextEditDialog(modifier, null, null, null, null, scannedText, 0, function1, (Function1) objRememberedValue2, composer, 6, 94);
            } else {
                str = "CC(remember):DocumentScannerScreen.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                composer.startReplaceGroup(995678892);
            }
            composer.endReplaceGroup();
            if (DocumentScannerScreen$lambda$0(state).isPermissionGranted()) {
                composer.startReplaceGroup(1005474272);
                ComposerKt.sourceInformation(composer, "");
                SurfaceRequest surfaceRequest = DocumentScannerScreen$lambda$0(state).getSurfaceRequest();
                if (surfaceRequest == null) {
                    composer.startReplaceGroup(1005514199);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1005514200);
                    ComposerKt.sourceInformation(composer, "*216@9970L59,221@10245L113,217@10050L330");
                    final String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_scanner_cd_viewfinder, composer, 0);
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composer, 1316002690, str);
                    boolean zChanged = composer.changed(strStringResource);
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChanged || objRememberedValue3 == Composer.Companion.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj) {
                                return DocumentScannerScreenKt.DocumentScannerScreen$lambda$30$lambda$29$lambda$25$lambda$24$lambda$23(strStringResource, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    CameraXViewfinderKt.CameraXViewfinder(surfaceRequest, SemanticsModifierKt.semantics$default(modifierFillMaxSize$default, false, (Function1) objRememberedValue3, 1, (Object) null), (ImplementationMode) null, (MutableCoordinateTransformer) null, (Alignment) null, (ContentScale) null, composer, 0, 60);
                    Unit unit = Unit.INSTANCE;
                    composer.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1006038162);
                ComposerKt.sourceInformation(composer, "230@10583L3,227@10436L730");
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer, 171004697, str);
                Object objRememberedValue4 = composer.rememberedValue();
                if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            return DocumentScannerScreenKt.DocumentScannerScreen$lambda$30$lambda$29$lambda$27$lambda$26((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierFillMaxSize$default2, true, (Function1) objRememberedValue4);
                Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, str2);
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierSemantics);
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
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1526177541, "C237@10910L11,234@10761L245,240@11027L30,241@11083L64,241@11078L70:DocumentScannerScreen.kt#6g1srx");
                IconKt.Icon-ww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError-0d7_KjU(), composer, 432, 0);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer, 6);
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_scanner_permission_warning, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            }
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
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit DocumentScannerScreen$lambda$30$lambda$29$lambda$20$lambda$19(DocumentScannerViewModel documentScannerViewModel) throws NoWhenBranchMatchedException {
        documentScannerViewModel.onAction(DocumentScannerAction.EditDialogDismissed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentScannerScreen$lambda$30$lambda$29$lambda$22$lambda$21(ConversationSharedViewModel conversationSharedViewModel, Function0 function0, String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        conversationSharedViewModel.setScannedText(str);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentScannerScreen$lambda$30$lambda$29$lambda$25$lambda$24$lambda$23(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentScannerScreen$lambda$30$lambda$29$lambda$27$lambda$26(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DocumentScannerState DocumentScannerScreen$lambda$0(State<DocumentScannerState> state) {
        return (DocumentScannerState) state.getValue();
    }
}
