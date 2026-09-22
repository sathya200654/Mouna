package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.ExtractTextFromImageUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: DocumentScannerViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00070\u0015¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00070\u001a¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerViewModel;", "Landroidx/lifecycle/ViewModel;", "extractTextFromImageUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/ExtractTextFromImageUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/ExtractTextFromImageUseCase;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "imageCaptureUseCase", "Landroidx/camera/core/ImageCapture;", "Lorg/jspecify/annotations/NonNull;", "getImageCaptureUseCase", "()Landroidx/camera/core/ImageCapture;", "previewUseCase", "Landroidx/camera/core/Preview;", "getPreviewUseCase", "()Landroidx/camera/core/Preview;", "updateScannedText", "", "text", "", "onAction", "action", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/DocumentScannerAction;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScannerViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<DocumentScannerEvent> _uiEvent;
    private final MutableStateFlow<DocumentScannerState> _uiState;
    private final ExtractTextFromImageUseCase extractTextFromImageUseCase;
    private final ImageCapture imageCaptureUseCase;
    private final Preview previewUseCase;
    private final SharedFlow<DocumentScannerEvent> uiEvent;
    private final StateFlow<DocumentScannerState> uiState;

    @Inject
    public DocumentScannerViewModel(ExtractTextFromImageUseCase extractTextFromImageUseCase) {
        Intrinsics.checkNotNullParameter(extractTextFromImageUseCase, "extractTextFromImageUseCase");
        this.extractTextFromImageUseCase = extractTextFromImageUseCase;
        MutableStateFlow<DocumentScannerState> MutableStateFlow = StateFlowKt.MutableStateFlow(new DocumentScannerState(null, false, false, false, null, 31, null));
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<DocumentScannerEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = mutableSharedFlowMutableSharedFlow$default;
        this.uiEvent = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        ImageCapture imageCaptureBuild = new ImageCapture.Builder().setCaptureMode(1).build();
        Intrinsics.checkNotNullExpressionValue(imageCaptureBuild, "build(...)");
        this.imageCaptureUseCase = imageCaptureBuild;
        Preview previewBuild = new Preview.Builder().build();
        previewBuild.setSurfaceProvider(new Preview.SurfaceProvider() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerViewModel$$ExternalSyntheticLambda0
            public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
                DocumentScannerViewModel.previewUseCase$lambda$2$lambda$1(this.f$0, surfaceRequest);
            }
        });
        Intrinsics.checkNotNullExpressionValue(previewBuild, "apply(...)");
        this.previewUseCase = previewBuild;
    }

    public final StateFlow<DocumentScannerState> getUiState() {
        return this.uiState;
    }

    public final SharedFlow<DocumentScannerEvent> getUiEvent() {
        return this.uiEvent;
    }

    public final ImageCapture getImageCaptureUseCase() {
        return this.imageCaptureUseCase;
    }

    public final Preview getPreviewUseCase() {
        return this.previewUseCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewUseCase$lambda$2$lambda$1(DocumentScannerViewModel documentScannerViewModel, SurfaceRequest surfaceRequest) {
        Intrinsics.checkNotNullParameter(surfaceRequest, "request");
        MutableStateFlow<DocumentScannerState> mutableStateFlow = documentScannerViewModel._uiState;
        while (true) {
            Object value = mutableStateFlow.getValue();
            SurfaceRequest surfaceRequest2 = surfaceRequest;
            if (mutableStateFlow.compareAndSet(value, DocumentScannerState.copy$default((DocumentScannerState) value, surfaceRequest2, false, false, false, null, 30, null))) {
                return;
            } else {
                surfaceRequest = surfaceRequest2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateScannedText(String text) {
        Object value;
        MutableStateFlow<DocumentScannerState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, DocumentScannerState.copy$default((DocumentScannerState) value, null, false, false, false, StringsKt.take(text, 1000), 15, null)));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final void onAction(DocumentScannerAction action) throws NoWhenBranchMatchedException {
        Object value;
        Object value2;
        Object value3;
        Object value4;
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof DocumentScannerAction.PermissionChanged) {
            MutableStateFlow<DocumentScannerState> mutableStateFlow = this._uiState;
            do {
                value4 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value4, DocumentScannerState.copy$default((DocumentScannerState) value4, null, false, ((DocumentScannerAction.PermissionChanged) action).isGranted(), false, null, 27, null)));
            return;
        }
        if (action instanceof DocumentScannerAction.CaptureButtonClicked) {
            MutableStateFlow<DocumentScannerState> mutableStateFlow2 = this._uiState;
            do {
                value3 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value3, DocumentScannerState.copy$default((DocumentScannerState) value3, null, true, false, false, null, 29, null)));
        } else {
            if (action instanceof DocumentScannerAction.ImageCaptured) {
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(action, null), 3, (Object) null);
                return;
            }
            if (action instanceof DocumentScannerAction.CaptureFailed) {
                MutableStateFlow<DocumentScannerState> mutableStateFlow3 = this._uiState;
                do {
                    value2 = mutableStateFlow3.getValue();
                } while (!mutableStateFlow3.compareAndSet(value2, DocumentScannerState.copy$default((DocumentScannerState) value2, null, false, false, false, null, 29, null)));
            } else {
                if (!Intrinsics.areEqual(action, DocumentScannerAction.EditDialogDismissed.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                MutableStateFlow<DocumentScannerState> mutableStateFlow4 = this._uiState;
                do {
                    value = mutableStateFlow4.getValue();
                } while (!mutableStateFlow4.compareAndSet(value, DocumentScannerState.copy$default((DocumentScannerState) value, null, false, false, false, null, 23, null)));
            }
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerViewModel$onAction$3, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScannerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerViewModel$onAction$3", f = "DocumentScannerViewModel.kt", i = {1}, l = {83, SignPracticeCreationViewModel.TOPIC_MAX_CHAR_LIMIT}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DocumentScannerAction $action;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(DocumentScannerAction documentScannerAction, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$action = documentScannerAction;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentScannerViewModel.this.new AnonymousClass3(this.$action, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
        
            if (r10.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toDocumentScannerErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r11).getError())), (kotlin.coroutines.Continuation) r10) == r0) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 207
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerViewModel.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
