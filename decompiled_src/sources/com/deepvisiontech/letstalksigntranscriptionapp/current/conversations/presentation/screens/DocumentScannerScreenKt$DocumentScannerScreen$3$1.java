package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import android.content.Context;
import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.compose.runtime.State;
import androidx.lifecycle.LifecycleOwner;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DocumentScannerScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$DocumentScannerScreen$3$1", f = "DocumentScannerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DocumentScannerScreenKt$DocumentScannerScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ DocumentScannerViewModel $documentScannerViewModel;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ State<DocumentScannerState> $uiState$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentScannerScreenKt$DocumentScannerScreen$3$1(Context context, LifecycleOwner lifecycleOwner, DocumentScannerViewModel documentScannerViewModel, State<DocumentScannerState> state, Continuation<? super DocumentScannerScreenKt$DocumentScannerScreen$3$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$lifecycleOwner = lifecycleOwner;
        this.$documentScannerViewModel = documentScannerViewModel;
        this.$uiState$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentScannerScreenKt$DocumentScannerScreen$3$1(this.$context, this.$lifecycleOwner, this.$documentScannerViewModel, this.$uiState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (DocumentScannerScreenKt.DocumentScannerScreen$lambda$0(this.$uiState$delegate).isPermissionGranted()) {
                ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) ProcessCameraProvider.Companion.getInstance(this.$context).get();
                try {
                    processCameraProvider.unbindAll();
                    LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
                    CameraSelector cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
                    Intrinsics.checkNotNullExpressionValue(cameraSelector, "DEFAULT_BACK_CAMERA");
                    processCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, new UseCase[]{this.$documentScannerViewModel.getPreviewUseCase(), this.$documentScannerViewModel.getImageCaptureUseCase()});
                } catch (Exception e) {
                    Boxing.boxInt(Log.e("Camera", "Binding failed", e));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
