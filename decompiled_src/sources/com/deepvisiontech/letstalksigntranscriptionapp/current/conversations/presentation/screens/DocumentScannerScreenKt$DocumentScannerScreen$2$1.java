package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerAction;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerViewModel;
import com.google.accompanist.permissions.PermissionState;
import com.google.accompanist.permissions.PermissionsUtilKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DocumentScannerScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt$DocumentScannerScreen$2$1", f = "DocumentScannerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DocumentScannerScreenKt$DocumentScannerScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PermissionState $cameraPermissionState;
    final /* synthetic */ DocumentScannerViewModel $documentScannerViewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentScannerScreenKt$DocumentScannerScreen$2$1(DocumentScannerViewModel documentScannerViewModel, PermissionState permissionState, Continuation<? super DocumentScannerScreenKt$DocumentScannerScreen$2$1> continuation) {
        super(2, continuation);
        this.$documentScannerViewModel = documentScannerViewModel;
        this.$cameraPermissionState = permissionState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentScannerScreenKt$DocumentScannerScreen$2$1(this.$documentScannerViewModel, this.$cameraPermissionState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$documentScannerViewModel.onAction(new DocumentScannerAction.PermissionChanged(PermissionsUtilKt.isGranted(this.$cameraPermissionState.getStatus())));
        if (!PermissionsUtilKt.isGranted(this.$cameraPermissionState.getStatus())) {
            this.$cameraPermissionState.launchPermissionRequest();
        }
        return Unit.INSTANCE;
    }
}
