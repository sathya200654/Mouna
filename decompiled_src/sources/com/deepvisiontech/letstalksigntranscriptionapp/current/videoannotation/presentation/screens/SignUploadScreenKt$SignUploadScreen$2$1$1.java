package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens;

import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SignUploadScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt$SignUploadScreen$2$1$1", f = "SignUploadScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SignUploadScreenKt$SignUploadScreen$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $hasPermissions$delegate;
    final /* synthetic */ ManagedActivityResultLauncher<String[], Map<String, Boolean>> $permissionLauncher;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignUploadScreenKt$SignUploadScreen$2$1$1(ManagedActivityResultLauncher<String[], Map<String, Boolean>> managedActivityResultLauncher, MutableState<Boolean> mutableState, Continuation<? super SignUploadScreenKt$SignUploadScreen$2$1$1> continuation) {
        super(2, continuation);
        this.$permissionLauncher = managedActivityResultLauncher;
        this.$hasPermissions$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignUploadScreenKt$SignUploadScreen$2$1$1(this.$permissionLauncher, this.$hasPermissions$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!SignUploadScreenKt.SignUploadScreen$lambda$11$lambda$3(this.$hasPermissions$delegate)) {
                this.$permissionLauncher.launch(new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"});
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
