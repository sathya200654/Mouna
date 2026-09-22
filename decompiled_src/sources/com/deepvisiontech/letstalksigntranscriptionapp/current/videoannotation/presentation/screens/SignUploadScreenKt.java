package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens;

import android.content.Context;
import android.graphics.RectF;
import android.util.Log;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoOutput;
import androidx.camera.view.PreviewView;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
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
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.content.ContextCompat;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.DetectionUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.RecordingState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.mediapipe.tasks.components.containers.Detection;
import com.google.mediapipe.tasks.components.containers.NormalizedLandmark;
import com.google.mediapipe.tasks.vision.facedetector.FaceDetectorResult;
import com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarkerResult;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUploadScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001a/\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\f\u001a;\u0010\r\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0015\u001aS\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#\u001a\u0015\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010&\u001a%\u0010'\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010)¨\u0006*²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020\u001bX\u008a\u008e\u0002"}, d2 = {"SignUploadScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/VideoUploadViewModel;", "navigateBack", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/VideoUploadViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "CameraViewWithOverlay", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/DetectionUiState;", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/DetectionUiState;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/VideoUploadViewModel;Landroidx/compose/runtime/Composer;II)V", "DetectionOverlay", "faceDetectorResult", "Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetectorResult;", "handLandmarkerResult", "Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarkerResult;", "imageHeight", "", "imageWidth", "(Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetectorResult;Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarkerResult;IILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawMirroredBoundingBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boundingBox", "Landroid/graphics/RectF;", "isNormalized", "", "scaleFactor", "", "horizontalOffset", "verticalOffset", "boxColor", "Landroidx/compose/ui/graphics/Color;", "drawMirroredBoundingBox-aKPr-nQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroid/graphics/RectF;IIZFFFJ)V", "CountdownTimer", "seconds", "(ILandroidx/compose/runtime/Composer;I)V", "PermissionRationaleUI", "onRequest", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "hasPermissions"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SignUploadScreenKt {

    /* JADX INFO: compiled from: SignUploadScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecordingState.values().length];
            try {
                iArr[RecordingState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecordingState.RECORDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RecordingState.INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RecordingState.VALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit CameraViewWithOverlay$lambda$48(Modifier modifier, DetectionUiState detectionUiState, VideoUploadViewModel videoUploadViewModel, int i, int i2, Composer composer, int i3) throws NoWhenBranchMatchedException {
        CameraViewWithOverlay(modifier, detectionUiState, videoUploadViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountdownTimer$lambda$55(int i, int i2, Composer composer, int i3) {
        CountdownTimer(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetectionOverlay$lambda$54(FaceDetectorResult faceDetectorResult, HandLandmarkerResult handLandmarkerResult, int i, int i2, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        DetectionOverlay(faceDetectorResult, handLandmarkerResult, i, i2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionRationaleUI$lambda$57(Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        PermissionRationaleUI(modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignUploadScreen$lambda$12(Modifier modifier, VideoUploadViewModel videoUploadViewModel, Function0 function0, int i, int i2, Composer composer, int i3) {
        SignUploadScreen(modifier, videoUploadViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:66:0x014b  */
    public static final void SignUploadScreen(Modifier modifier, VideoUploadViewModel videoUploadViewModel, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        VideoUploadViewModel videoUploadViewModel2;
        final Modifier modifier3;
        final VideoUploadViewModel videoUploadViewModel3;
        CreationExtras defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(function0, "navigateBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(1019862492);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SignUploadScreen)P(!1,2)82@3820L169,88@3996L1282,78@3711L1567:SignUploadScreen.kt#j6w19p");
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
                videoUploadViewModel2 = videoUploadViewModel;
                int i5 = composerStartRestartGroup.changedInstance(videoUploadViewModel2) ? 32 : 16;
                i3 |= i5;
            } else {
                videoUploadViewModel2 = videoUploadViewModel;
            }
            i3 |= i5;
        } else {
            videoUploadViewModel2 = videoUploadViewModel;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "75@3657L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i6 &= -113;
                }
                modifier3 = modifier2;
            } else {
                modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel(VideoUploadViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    videoUploadViewModel3 = (VideoUploadViewModel) viewModel;
                    i6 &= -113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1019862492, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreen (SignUploadScreen.kt:77)");
                }
                ScaffoldKt.Scaffold-TvnljyQ(SizeKt.fillMaxSize$default(WindowInsetsPadding_androidKt.imePadding(modifier3), 0.0f, 1, (Object) null), ComposableLambdaKt.rememberComposableLambda(-2049706592, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2) {
                        return SignUploadScreenKt.SignUploadScreen$lambda$0(function0, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-778653525, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SignUploadScreenKt.SignUploadScreen$lambda$11(videoUploadViewModel3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 508);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            videoUploadViewModel3 = videoUploadViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1019862492, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreen (SignUploadScreen.kt:77)");
            }
            ScaffoldKt.Scaffold-TvnljyQ(SizeKt.fillMaxSize$default(WindowInsetsPadding_androidKt.imePadding(modifier3), 0.0f, 1, (Object) null), ComposableLambdaKt.rememberComposableLambda(-2049706592, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    return SignUploadScreenKt.SignUploadScreen$lambda$0(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-778653525, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignUploadScreenKt.SignUploadScreen$lambda$11(videoUploadViewModel3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 508);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            videoUploadViewModel3 = videoUploadViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    return SignUploadScreenKt.SignUploadScreen$lambda$12(modifier3, videoUploadViewModel3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignUploadScreen$lambda$0(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C84@3872L48,83@3834L145:SignUploadScreen.kt#j6w19p");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049706592, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreen.<anonymous> (SignUploadScreen.kt:83)");
            }
            SimpleTopBarKt.SimpleTopBar(null, StringResources_androidKt.stringResource(R.string.sign_video_screen_title, composer, 0), function0, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit SignUploadScreen$lambda$11(VideoUploadViewModel videoUploadViewModel, PaddingValues paddingValues, Composer composer, int i) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "C89@4050L7,90@4099L16,91@4146L327,99@4642L65,97@4507L210,101@4747L173,101@4726L194:SignUploadScreen.kt#j6w19p");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-778653525, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreen.<anonymous> (SignUploadScreen.kt:89)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Context context = (Context) objConsume;
            State stateCollectAsState = SnapshotStateKt.collectAsState(videoUploadViewModel.getUiState(), (CoroutineContext) null, composer, 0, 1);
            ComposerKt.sourceInformationMarkerStart(composer, -961722894, "CC(remember):SignUploadScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ActivityResultContract requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
            ComposerKt.sourceInformationMarkerStart(composer, -961707284, "CC(remember):SignUploadScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        return SignUploadScreenKt.SignUploadScreen$lambda$11$lambda$7$lambda$6(mutableState, (Map) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions, (Function1) objRememberedValue2, composer, 48);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -961703816, "CC(remember):SignUploadScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
            SignUploadScreenKt$SignUploadScreen$2$1$1 signUploadScreenKt$SignUploadScreen$2$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || signUploadScreenKt$SignUploadScreen$2$1$1RememberedValue == Composer.Companion.getEmpty()) {
                signUploadScreenKt$SignUploadScreen$2$1$1RememberedValue = new SignUploadScreenKt$SignUploadScreen$2$1$1(managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, null);
                composer.updateRememberedValue(signUploadScreenKt$SignUploadScreen$2$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(unit, (Function2) signUploadScreenKt$SignUploadScreen$2$1$1RememberedValue, composer, 6);
            if (SignUploadScreen$lambda$11$lambda$3(mutableState)) {
                composer.startReplaceGroup(252151829);
                ComposerKt.sourceInformation(composer, "108@4964L74");
                CameraViewWithOverlay(PaddingKt.padding(Modifier.Companion, paddingValues), SignUploadScreen$lambda$11$lambda$1(stateCollectAsState), videoUploadViewModel, composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(252258717);
                ComposerKt.sourceInformation(composer, "110@5134L128,110@5068L194");
                Modifier modifierPadding = PaddingKt.padding(Modifier.Companion, paddingValues);
                ComposerKt.sourceInformationMarkerStart(composer, -961691477, "CC(remember):SignUploadScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            return SignUploadScreenKt.SignUploadScreen$lambda$11$lambda$10$lambda$9(managedActivityResultLauncherRememberLauncherForActivityResult);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                PermissionRationaleUI(modifierPadding, (Function0) objRememberedValue3, composer, 0, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SignUploadScreen$lambda$11$lambda$3(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void SignUploadScreen$lambda$11$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignUploadScreen$lambda$11$lambda$7$lambda$6(MutableState mutableState, Map map) {
        Intrinsics.checkNotNullParameter(map, "permissions");
        Collection collectionValues = map.values();
        boolean z = true;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        SignUploadScreen$lambda$11$lambda$4(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignUploadScreen$lambda$11$lambda$10$lambda$9(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch(new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"});
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private static final void CameraViewWithOverlay(Modifier modifier, final DetectionUiState detectionUiState, final VideoUploadViewModel videoUploadViewModel, Composer composer, final int i, final int i2) throws NoWhenBranchMatchedException {
        Modifier modifier2;
        int i3;
        Composer composer2;
        Modifier modifier3;
        Object obj;
        final Preview preview;
        int i4;
        Context context;
        Composer composer3;
        final VideoUploadViewModel videoUploadViewModel2 = videoUploadViewModel;
        Composer composerStartRestartGroup = composer.startRestartGroup(1450873336);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CameraViewWithOverlay)123@5466L7,124@5519L7,125@5552L48,126@5628L38,127@5714L161,131@5917L109,135@6067L444,150@6540L737,150@6517L760,170@7283L4999:SignUploadScreen.kt#j6w19p");
        int i5 = i2 & 1;
        if (i5 != 0) {
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
            i3 |= composerStartRestartGroup.changedInstance(detectionUiState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(videoUploadViewModel2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            Modifier modifier4 = i5 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1450873336, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.CameraViewWithOverlay (SignUploadScreen.kt:122)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context2 = (Context) objConsume;
            CompositionLocal localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1575086616, "CC(remember):SignUploadScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = Executors.newSingleThreadExecutor();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ExecutorService executorService = (ExecutorService) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1575084194, "CC(remember):SignUploadScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Preview.Builder().build();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Preview preview2 = (Preview) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Intrinsics.checkNotNull(preview2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1575081319, "CC(remember):SignUploadScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                VideoOutput videoOutputBuild = new Recorder.Builder().setQualitySelector(QualitySelector.from(Quality.HD)).build();
                Intrinsics.checkNotNullExpressionValue(videoOutputBuild, "build(...)");
                objRememberedValue3 = VideoCapture.withOutput(videoOutputBuild);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final VideoCapture videoCapture = (VideoCapture) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Intrinsics.checkNotNull(videoCapture);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1575074875, "CC(remember):SignUploadScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new CameraSelector.Builder().requireLensFacing(0).build();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final CameraSelector cameraSelector = (CameraSelector) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Intrinsics.checkNotNull(cameraSelector);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1575069740, "CC(remember):SignUploadScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            Object obj2 = objRememberedValue5;
            if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
                imageAnalysisBuild.setAnalyzer(executorService, new ImageAnalysis.Analyzer() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda11
                    public final void analyze(ImageProxy imageProxy) {
                        SignUploadScreenKt.CameraViewWithOverlay$lambda$19$lambda$18$lambda$17(videoUploadViewModel2, imageProxy);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(imageAnalysisBuild);
                obj2 = imageAnalysisBuild;
            }
            final ImageAnalysis imageAnalysis = (ImageAnalysis) obj2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Intrinsics.checkNotNull(imageAnalysis);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1575054311, "CC(remember):SignUploadScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(videoUploadViewModel2) | composerStartRestartGroup.changedInstance(context2) | composerStartRestartGroup.changedInstance(lifecycleOwner) | composerStartRestartGroup.changedInstance(cameraSelector) | composerStartRestartGroup.changedInstance(preview2) | composerStartRestartGroup.changedInstance(videoCapture) | composerStartRestartGroup.changedInstance(imageAnalysis) | composerStartRestartGroup.changedInstance(executorService);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.Companion.getEmpty()) {
                preview = preview2;
                i4 = 1;
                obj = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj3) {
                        return SignUploadScreenKt.CameraViewWithOverlay$lambda$23$lambda$22(videoUploadViewModel2, context2, lifecycleOwner, cameraSelector, preview, videoCapture, imageAnalysis, executorService, (DisposableEffectScope) obj3);
                    }
                };
                context = context2;
                videoCapture = videoCapture;
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                context = context2;
                preview = preview2;
                obj = objRememberedValue6;
                i4 = 1;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1) obj, composerStartRestartGroup, 6);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, i4, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            final Context context3 = context;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            final VideoCapture videoCapture2 = videoCapture;
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
            Composer composer4 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 8470581, "C172@7367L79,171@7332L171,176@7513L244,183@7767L4509:SignUploadScreen.kt#j6w19p");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662837485, (String) r5);
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(preview);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue7 == Composer.Companion.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj3) {
                        return SignUploadScreenKt.CameraViewWithOverlay$lambda$47$lambda$26$lambda$25(preview, (Context) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue7, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, i4, (Object) null), (Function1) null, composerStartRestartGroup, 48, 4);
            DetectionOverlay(detectionUiState.getFaceDetectorResult(), detectionUiState.getHandLandmarkerResult(), detectionUiState.getImageHeight(), detectionUiState.getImageWidth(), null, composerStartRestartGroup, 0, 16);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, i4, (Object) null);
            Alignment bottomCenter = Alignment.Companion.getBottomCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(bottomCenter, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
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
            Composer composer5 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer5, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer5, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer5, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1546203028, "C:SignUploadScreen.kt#j6w19p");
            int i6 = WhenMappings.$EnumSwitchMapping$0[detectionUiState.getRecordingState().ordinal()];
            if (i6 != i4) {
                if (i6 == 2) {
                    videoUploadViewModel2 = videoUploadViewModel;
                    modifier3 = modifier4;
                    composer3 = composerStartRestartGroup;
                    composer3.startReplaceGroup(88677750);
                    ComposerKt.sourceInformation(composer3, "191@8247L50");
                    CountdownTimer(detectionUiState.getCountdownSeconds(), composer3, 0);
                    composer3.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                } else if (i6 == 3) {
                    videoUploadViewModel2 = videoUploadViewModel;
                    composerStartRestartGroup.startReplaceGroup(-1545844731);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "192@8340L697");
                    Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    float f = 16;
                    Modifier modifier5 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i4, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), Dp.constructor-impl(f));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
                    Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        modifier3 = modifier4;
                        ComposablesKt.invalidApplier();
                    }
                    modifier3 = modifier4;
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composer6 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer6, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl(composer6, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl(composer6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl(composer6, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1504489653, "C196@8585L58,196@8573L110,197@8716L61,197@8704L95,198@8837L27,198@8820L199:SignUploadScreen.kt#j6w19p");
                    TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.sign_video_feedback_title_invalid, composerStartRestartGroup, 0), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composerStartRestartGroup, 24960, 0, 262122);
                    TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.sign_video_feedback_desc_instruction, composerStartRestartGroup, 0), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composerStartRestartGroup, 384, 0, 262138);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 367118101, "CC(remember):SignUploadScreen.kt#9igjgp");
                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(videoUploadViewModel2);
                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue8 == Composer.Companion.getEmpty()) {
                        objRememberedValue8 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda15
                            public final Object invoke() {
                                return SignUploadScreenKt.CameraViewWithOverlay$lambda$47$lambda$46$lambda$31$lambda$30$lambda$29(videoUploadViewModel2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ButtonKt.Button((Function0) objRememberedValue8, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(f), 0.0f, 0.0f, 13, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SignUploadScreenKt.INSTANCE.getLambda$154618282$app_release(), composerStartRestartGroup, 805306416, 508);
                    composer3 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                } else {
                    if (i6 != 4) {
                        composerStartRestartGroup.startReplaceGroup(88669815);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(-1545035848);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (detectionUiState.isUploading()) {
                        composerStartRestartGroup.startReplaceGroup(-1545074133);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "204@9151L387");
                        Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
                        Modifier modifier6 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier6);
                        Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composer7 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer7, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer7, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl(composer7, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl(composer7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl(composer7, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1786088669, "C205@9276L27,206@9332L41,207@9414L58,207@9402L110:SignUploadScreen.kt#j6w19p");
                        modifier3 = modifier4;
                        ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8((Modifier) null, 0L, 0.0f, 0L, 0, 0.0f, composerStartRestartGroup, 0, 63);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composerStartRestartGroup, 6);
                        TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.sign_video_status_label_uploading, composerStartRestartGroup, 0), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composerStartRestartGroup, 24960, 0, 262122);
                        composer3 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        videoUploadViewModel2 = videoUploadViewModel;
                    } else if (detectionUiState.getUploadSuccess()) {
                        composerStartRestartGroup.startReplaceGroup(-1544598810);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9619L744");
                        Alignment.Horizontal centerHorizontally3 = Alignment.Companion.getCenterHorizontally();
                        Modifier modifier7 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i4, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), Dp.constructor-impl(32));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally3, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
                        Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            modifier3 = modifier4;
                            ComposablesKt.invalidApplier();
                        }
                        modifier3 = modifier4;
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor5);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composer8 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer8, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer8, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl(composer8, Integer.valueOf(iHashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl(composer8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl(composer8, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1470521999, "C211@9814L56,211@9802L108,212@9951L54,212@9939L147,213@10132L27,213@10115L222:SignUploadScreen.kt#j6w19p");
                        TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.sign_video_status_title_success, composerStartRestartGroup, 0), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composerStartRestartGroup, 24960, 0, 262122);
                        TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.sign_video_status_desc_thanks, composerStartRestartGroup, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composerStartRestartGroup, 25008, 0, 262120);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1476574408, "CC(remember):SignUploadScreen.kt#9igjgp");
                        boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(videoUploadViewModel);
                        Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue9 == Composer.Companion.getEmpty()) {
                            objRememberedValue9 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda16
                                public final Object invoke() {
                                    return SignUploadScreenKt.CameraViewWithOverlay$lambda$47$lambda$46$lambda$35$lambda$34$lambda$33(videoUploadViewModel);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ButtonKt.Button((Function0) objRememberedValue9, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(16), 0.0f, 0.0f, 13, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SignUploadScreenKt.INSTANCE.getLambda$434614605$app_release(), composerStartRestartGroup, 805306416, 508);
                        composer3 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        videoUploadViewModel2 = videoUploadViewModel;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1543774613);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "218@10417L1795");
                        Alignment.Horizontal centerHorizontally4 = Alignment.Companion.getCenterHorizontally();
                        float f2 = 16;
                        Modifier modifier8 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i4, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), Dp.constructor-impl(f2));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally4, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier8);
                        Function0 constructor6 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            modifier3 = modifier4;
                            ComposablesKt.invalidApplier();
                        }
                        modifier3 = modifier4;
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor6);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composer9 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer9, measurePolicyColumnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer9, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl(composer9, Integer.valueOf(iHashCode6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl(composer9, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl(composer9, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1779927116, "C219@10612L55,219@10600L107,222@10862L35,220@10736L438,233@11648L538:SignUploadScreen.kt#j6w19p");
                        int i7 = i4;
                        videoUploadViewModel2 = videoUploadViewModel;
                        TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.sign_video_form_title_complete, composerStartRestartGroup, 0), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composerStartRestartGroup, 24960, 0, 262122);
                        String videoName = detectionUiState.getVideoName();
                        float f3 = 8;
                        Modifier modifier9 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i7, (Object) null), 0.0f, Dp.constructor-impl(f3), i7, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1304336160, "CC(remember):SignUploadScreen.kt#9igjgp");
                        boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(videoUploadViewModel2);
                        Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue10 == Composer.Companion.getEmpty()) {
                            objRememberedValue10 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda17
                                public final Object invoke(Object obj3) {
                                    return SignUploadScreenKt.CameraViewWithOverlay$lambda$47$lambda$46$lambda$45$lambda$37$lambda$36(videoUploadViewModel2, (String) obj3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        OutlinedTextFieldKt.OutlinedTextField(videoName, (Function1) objRememberedValue10, modifier9, false, false, (TextStyle) null, ComposableSingletons$SignUploadScreenKt.INSTANCE.getLambda$699144343$app_release(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, 1573248, 12582912, 0, 8257464);
                        Composer composer10 = composerStartRestartGroup;
                        Integer uploadError = detectionUiState.getUploadError();
                        if (uploadError == null) {
                            composer10.startReplaceGroup(-1779351789);
                            composer10.endReplaceGroup();
                        } else {
                            composer10.startReplaceGroup(-1779351788);
                            ComposerKt.sourceInformation(composer10, "*228@11267L18,228@11309L11,228@11262L109");
                            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(uploadError.intValue(), composer10, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(f3), 7, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getError-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer10, 48, 0, 262136);
                            composer10 = composer10;
                            Unit unit4 = Unit.INSTANCE;
                            composer10.endReplaceGroup();
                            Unit unit5 = Unit.INSTANCE;
                        }
                        String uploadErrorMessage = detectionUiState.getUploadErrorMessage();
                        if (uploadErrorMessage == null) {
                            composer10.startReplaceGroup(-1779120157);
                            composer10.endReplaceGroup();
                        } else {
                            composer10.startReplaceGroup(-1779120156);
                            ComposerKt.sourceInformation(composer10, "*231@11527L11,231@11496L93");
                            Composer composer11 = composer10;
                            TextKt.Text-Nvy7gAk(uploadErrorMessage, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(f3), 7, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getError-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer11, 48, 0, 262136);
                            composer10 = composer11;
                            Unit unit6 = Unit.INSTANCE;
                            composer10.endReplaceGroup();
                            Unit unit7 = Unit.INSTANCE;
                        }
                        ComposerKt.sourceInformationMarkerStart(composer10, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier modifier10 = Modifier.Companion;
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer10, 0);
                        ComposerKt.sourceInformationMarkerStart(composer10, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer10, 0));
                        CompositionLocalMap currentCompositionLocalMap7 = composer10.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer10, modifier10);
                        Function0 constructor7 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer10, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer10.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer10.startReusableNode();
                        if (composer10.getInserting()) {
                            composer10.createNode(constructor7);
                        } else {
                            composer10.useNode();
                        }
                        Composer composer12 = Updater.constructor-impl(composer10);
                        Updater.set-impl(composer12, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer12, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl(composer12, Integer.valueOf(iHashCode7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl(composer12, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl(composer12, modifierMaterializeModifier7, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer10, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer10, 893732652, "C234@11703L27,234@11686L179,237@11898L40,238@11988L34,238@11971L185:SignUploadScreen.kt#j6w19p");
                        ComposerKt.sourceInformationMarkerStart(composer10, 1691398172, "CC(remember):SignUploadScreen.kt#9igjgp");
                        boolean zChangedInstance6 = composer10.changedInstance(videoUploadViewModel2);
                        Object objRememberedValue11 = composer10.rememberedValue();
                        if (zChangedInstance6 || objRememberedValue11 == Composer.Companion.getEmpty()) {
                            objRememberedValue11 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda18
                                public final Object invoke() {
                                    return SignUploadScreenKt.CameraViewWithOverlay$lambda$47$lambda$46$lambda$45$lambda$44$lambda$41$lambda$40(videoUploadViewModel2);
                                }
                            };
                            composer10.updateRememberedValue(objRememberedValue11);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer10);
                        Composer composer13 = composer10;
                        ButtonKt.Button((Function0) objRememberedValue11, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SignUploadScreenKt.INSTANCE.getLambda$622160337$app_release(), composer13, 805306368, 510);
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), composer13, 6);
                        ComposerKt.sourceInformationMarkerStart(composer13, 1691407299, "CC(remember):SignUploadScreen.kt#9igjgp");
                        boolean zChangedInstance7 = composer13.changedInstance(videoUploadViewModel2) | composer13.changedInstance(context3);
                        Object objRememberedValue12 = composer13.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue12 == Composer.Companion.getEmpty()) {
                            objRememberedValue12 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda19
                                public final Object invoke() {
                                    return SignUploadScreenKt.CameraViewWithOverlay$lambda$47$lambda$46$lambda$45$lambda$44$lambda$43$lambda$42(videoUploadViewModel2, context3);
                                }
                            };
                            composer13.updateRememberedValue(objRememberedValue12);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer13);
                        ButtonKt.Button((Function0) objRememberedValue12, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SignUploadScreenKt.INSTANCE.m1872getLambda$1649060664$app_release(), composer13, 805306368, 510);
                        composer3 = composer13;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                    }
                    composer3.endReplaceGroup();
                    Unit unit8 = Unit.INSTANCE;
                }
                composer2 = composer3;
            } else {
                videoUploadViewModel2 = videoUploadViewModel;
                composerStartRestartGroup.startReplaceGroup(88667952);
                ComposerKt.sourceInformation(composerStartRestartGroup, "186@7972L51,185@7934L268");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 88668951, "CC(remember):SignUploadScreen.kt#9igjgp");
                boolean zChangedInstance8 = composerStartRestartGroup.changedInstance(videoUploadViewModel2) | composerStartRestartGroup.changedInstance(context3) | composerStartRestartGroup.changedInstance(videoCapture2);
                Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance8 || objRememberedValue13 == Composer.Companion.getEmpty()) {
                    modifier3 = modifier4;
                    modifier3 = modifier4;
                    objRememberedValue13 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            return SignUploadScreenKt.CameraViewWithOverlay$lambda$47$lambda$46$lambda$28$lambda$27(videoUploadViewModel2, context3, videoCapture2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                }
                modifier3 = modifier4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                ButtonKt.Button((Function0) objRememberedValue13, PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SignUploadScreenKt.INSTANCE.m1873getLambda$771826196$app_release(), composer2, 805306416, 508);
                composer2.endReplaceGroup();
                Unit unit9 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final VideoUploadViewModel videoUploadViewModel3 = videoUploadViewModel2;
            final Modifier modifier11 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj3, Object obj4) {
                    return SignUploadScreenKt.CameraViewWithOverlay$lambda$48(modifier11, detectionUiState, videoUploadViewModel3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CameraViewWithOverlay$lambda$19$lambda$18$lambda$17(VideoUploadViewModel videoUploadViewModel, ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        try {
            videoUploadViewModel.processFrame(imageProxy);
        } finally {
            imageProxy.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult CameraViewWithOverlay$lambda$23$lambda$22(final VideoUploadViewModel videoUploadViewModel, Context context, final LifecycleOwner lifecycleOwner, final CameraSelector cameraSelector, final Preview preview, final VideoCapture videoCapture, final ImageAnalysis imageAnalysis, final ExecutorService executorService, DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        videoUploadViewModel.setupDetector();
        final ListenableFuture companion = ProcessCameraProvider.Companion.getInstance(context);
        companion.addListener(new Runnable() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SignUploadScreenKt.CameraViewWithOverlay$lambda$23$lambda$22$lambda$20(companion, lifecycleOwner, cameraSelector, preview, videoCapture, imageAnalysis);
            }
        }, ContextCompat.getMainExecutor(context));
        return new DisposableEffectResult() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$CameraViewWithOverlay$lambda$23$lambda$22$$inlined$onDispose$1
            public void dispose() {
                ((ProcessCameraProvider) companion.get()).unbindAll();
                executorService.shutdown();
                videoUploadViewModel.closeDetector();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void CameraViewWithOverlay$lambda$23$lambda$22$lambda$20(ListenableFuture listenableFuture, LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, Preview preview, VideoCapture videoCapture, ImageAnalysis imageAnalysis) {
        ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) listenableFuture.get();
        try {
            processCameraProvider.unbindAll();
            processCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, new UseCase[]{preview, videoCapture, imageAnalysis});
        } catch (Exception e) {
            Log.e("CameraViewWithOverlay", "Use case binding failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewView CameraViewWithOverlay$lambda$47$lambda$26$lambda$25(Preview preview, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        PreviewView previewView = new PreviewView(context);
        preview.setSurfaceProvider(previewView.getSurfaceProvider());
        return previewView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CameraViewWithOverlay$lambda$47$lambda$46$lambda$28$lambda$27(VideoUploadViewModel videoUploadViewModel, Context context, VideoCapture videoCapture) {
        videoUploadViewModel.startRecording(context, videoCapture);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CameraViewWithOverlay$lambda$47$lambda$46$lambda$31$lambda$30$lambda$29(VideoUploadViewModel videoUploadViewModel) {
        videoUploadViewModel.resetToIdle();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CameraViewWithOverlay$lambda$47$lambda$46$lambda$35$lambda$34$lambda$33(VideoUploadViewModel videoUploadViewModel) {
        videoUploadViewModel.resetToIdle();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CameraViewWithOverlay$lambda$47$lambda$46$lambda$45$lambda$37$lambda$36(VideoUploadViewModel videoUploadViewModel, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        videoUploadViewModel.onVideoNameChange(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CameraViewWithOverlay$lambda$47$lambda$46$lambda$45$lambda$44$lambda$41$lambda$40(VideoUploadViewModel videoUploadViewModel) {
        videoUploadViewModel.resetToIdle();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CameraViewWithOverlay$lambda$47$lambda$46$lambda$45$lambda$44$lambda$43$lambda$42(VideoUploadViewModel videoUploadViewModel, Context context) throws FileNotFoundException {
        videoUploadViewModel.startUpload(context);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x00af  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:75:? A[RETURN, SYNTHETIC] */
    private static final void DetectionOverlay(final FaceDetectorResult faceDetectorResult, final HandLandmarkerResult handLandmarkerResult, final int i, final int i2, Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        boolean z;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z2;
        boolean zChangedInstance;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1195450086);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DetectionOverlay)258@12549L1204,258@12507L1246:SignUploadScreen.kt#j6w19p");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(faceDetectorResult) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(handLandmarkerResult) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 2048 : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        int i6 = i4 & 16;
        if (i6 == 0) {
            if ((i3 & 24576) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i5 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1195450086, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.DetectionOverlay (SignUploadScreen.kt:257)");
                }
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2071274234, "CC(remember):SignUploadScreen.kt#9igjgp");
                if ((i5 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChangedInstance = z2 | ((i5 & 896) == 256) | composerStartRestartGroup.changedInstance(faceDetectorResult) | composerStartRestartGroup.changedInstance(handLandmarkerResult);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            return SignUploadScreenKt.DetectionOverlay$lambda$53$lambda$52(i2, i, faceDetectorResult, handLandmarkerResult, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        return SignUploadScreenKt.DetectionOverlay$lambda$54(faceDetectorResult, handLandmarkerResult, i, i2, modifier4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        modifier2 = modifier;
        if ((i5 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i6 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1195450086, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.DetectionOverlay (SignUploadScreen.kt:257)");
            }
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2071274234, "CC(remember):SignUploadScreen.kt#9igjgp");
            if ((i5 & 7168) == 2048) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChangedInstance = z2 | ((i5 & 896) == 256) | composerStartRestartGroup.changedInstance(faceDetectorResult) | composerStartRestartGroup.changedInstance(handLandmarkerResult);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        return SignUploadScreenKt.DetectionOverlay$lambda$53$lambda$52(i2, i, faceDetectorResult, handLandmarkerResult, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        return SignUploadScreenKt.DetectionOverlay$lambda$53$lambda$52(i2, i, faceDetectorResult, handLandmarkerResult, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierFillMaxSize$default2, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return SignUploadScreenKt.DetectionOverlay$lambda$54(faceDetectorResult, handLandmarkerResult, i, i2, modifier5, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetectionOverlay$lambda$53$lambda$52(int i, int i2, FaceDetectorResult faceDetectorResult, HandLandmarkerResult handLandmarkerResult, DrawScope drawScope) {
        List<List<NormalizedLandmark>> listLandmarks;
        List<Detection> listDetections;
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        if (i == 0 || i2 == 0) {
            return Unit.INSTANCE;
        }
        float f = i;
        float f2 = i2;
        float fMax = Math.max(Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() >> 32)) / f, Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() & 4294967295L)) / f2);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (4294967295L & drawScope.getSize-NH-jbRc())) - (f2 * fMax);
        float f3 = 2;
        float f4 = fIntBitsToFloat / f3;
        float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() >> 32)) - (f * fMax)) / f3;
        if (faceDetectorResult != null && (listDetections = faceDetectorResult.detections()) != null) {
            Iterator<T> it = listDetections.iterator();
            while (it.hasNext()) {
                RectF rectFBoundingBox = ((Detection) it.next()).boundingBox();
                Intrinsics.checkNotNullExpressionValue(rectFBoundingBox, "boundingBox(...)");
                float f5 = fMax;
                m1882drawMirroredBoundingBoxaKPrnQ(drawScope, rectFBoundingBox, i, i2, false, f5, fIntBitsToFloat2, f4, Color.Companion.getGreen-0d7_KjU());
                fMax = f5;
            }
        }
        float f6 = fMax;
        if (handLandmarkerResult != null && (listLandmarks = handLandmarkerResult.landmarks()) != null) {
            Iterator<T> it2 = listLandmarks.iterator();
            while (it2.hasNext()) {
                List<NormalizedLandmark> list = (List) it2.next();
                Intrinsics.checkNotNull(list);
                float fMax2 = Float.MIN_VALUE;
                float fMin = Float.MAX_VALUE;
                float fMin2 = Float.MAX_VALUE;
                float fMax3 = Float.MIN_VALUE;
                for (NormalizedLandmark normalizedLandmark : list) {
                    fMin = Math.min(fMin, normalizedLandmark.x());
                    fMin2 = Math.min(fMin2, normalizedLandmark.y());
                    fMax2 = Math.max(fMax2, normalizedLandmark.x());
                    fMax3 = Math.max(fMax3, normalizedLandmark.y());
                }
                m1882drawMirroredBoundingBoxaKPrnQ(drawScope, new RectF(fMin, fMin2, fMax2, fMax3), i, i2, true, f6, fIntBitsToFloat2, f4, Color.Companion.getMagenta-0d7_KjU());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawMirroredBoundingBox-aKPr-nQ, reason: not valid java name */
    private static final void m1882drawMirroredBoundingBoxaKPrnQ(DrawScope drawScope, RectF rectF, int i, int i2, boolean z, float f, float f2, float f3, long j) {
        float f4 = rectF.left;
        if (z) {
            f4 *= i;
        }
        float f5 = rectF.top;
        if (z) {
            f5 *= i2;
        }
        float f6 = rectF.right;
        if (z) {
            f6 *= i;
        }
        float f7 = rectF.bottom;
        if (z) {
            f7 *= i2;
        }
        float f8 = f5 * f;
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() >> 32)) - (f6 * f)) - f2;
        DrawScope.drawRect-n-J9OG0$default(drawScope, j, Offset.constructor-impl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f8 + f3)) & 4294967295L)), Size.constructor-impl((((long) Float.floatToRawIntBits(((Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() >> 32)) - (f4 * f)) - f2) - fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits((f7 * f) - f8)) & 4294967295L)), 0.0f, new Stroke(8.0f, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 104, (Object) null);
    }

    private static final void CountdownTimer(final int i, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-469885268);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CountdownTimer)302@14889L138:SignUploadScreen.kt#j6w19p");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-469885268, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.CountdownTimer (SignUploadScreen.kt:301)");
            }
            composer2 = composerStartRestartGroup;
            TextKt.Text-Nvy7gAk(String.valueOf(i), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(100), 7, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(80), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 1597872, 0, 262056);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    return SignUploadScreenKt.CountdownTimer$lambda$55(i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PermissionRationaleUI(Modifier modifier, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-876578824);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PermissionRationaleUI)307@15137L424:SignUploadScreen.kt#j6w19p");
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
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-876578824, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.PermissionRationaleUI (SignUploadScreen.kt:306)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
            Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1593309445, "C308@15295L61,308@15283L104,309@15396L159:SignUploadScreen.kt#j6w19p");
            composer2 = composerStartRestartGroup;
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.sign_video_permission_desc_rationale, composerStartRestartGroup, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 0, 0, 261118);
            modifier3 = modifier4;
            ButtonKt.Button(function0, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(16), 0.0f, 0.0f, 13, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SignUploadScreenKt.INSTANCE.getLambda$1346368478$app_release(), composer2, ((i3 >> 3) & 14) | 805306416, 508);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    return SignUploadScreenKt.PermissionRationaleUI$lambda$57(modifier3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final DetectionUiState SignUploadScreen$lambda$11$lambda$1(State<DetectionUiState> state) {
        return (DetectionUiState) state.getValue();
    }
}
