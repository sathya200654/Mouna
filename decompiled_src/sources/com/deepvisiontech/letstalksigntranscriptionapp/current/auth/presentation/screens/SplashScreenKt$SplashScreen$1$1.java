package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.State;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SplashScreenUiState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.protobuf.DescriptorProtos;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SplashScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SplashScreenKt$SplashScreen$1$1", f = "SplashScreen.kt", i = {0}, l = {DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER}, m = "invokeSuspend", n = {RemoteConfigConstants.ResponseFieldKey.STATE}, s = {"L$0"})
final class SplashScreenKt$SplashScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $navigateToSetupScreen;
    final /* synthetic */ Function0<Unit> $navigateToSignInScreen;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ State<SplashScreenUiState> $uiState$delegate;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SplashScreenKt$SplashScreen$1$1(SnackbarHostState snackbarHostState, Function0<Unit> function0, Function0<Unit> function1, State<? extends SplashScreenUiState> state, Continuation<? super SplashScreenKt$SplashScreen$1$1> continuation) {
        super(2, continuation);
        this.$snackbarHostState = snackbarHostState;
        this.$navigateToSignInScreen = function0;
        this.$navigateToSetupScreen = function1;
        this.$uiState$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashScreenKt$SplashScreen$1$1(this.$snackbarHostState, this.$navigateToSignInScreen, this.$navigateToSetupScreen, this.$uiState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
        SplashScreenUiState splashScreenUiState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SplashScreenUiState splashScreenUiStateSplashScreen$lambda$0 = SplashScreenKt.SplashScreen$lambda$0(this.$uiState$delegate);
            if (splashScreenUiStateSplashScreen$lambda$0 instanceof SplashScreenUiState.Error) {
                this.L$0 = splashScreenUiStateSplashScreen$lambda$0;
                this.label = 1;
                if (SnackbarHostState.showSnackbar$default(this.$snackbarHostState, ((SplashScreenUiState.Error) splashScreenUiStateSplashScreen$lambda$0).getMessage(), (String) null, false, (SnackbarDuration) null, (Continuation) this, 14, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                splashScreenUiState = splashScreenUiStateSplashScreen$lambda$0;
            } else if (Intrinsics.areEqual(splashScreenUiStateSplashScreen$lambda$0, SplashScreenUiState.NavigateToCredentialScreen.INSTANCE)) {
                this.$navigateToSignInScreen.invoke();
            } else if (Intrinsics.areEqual(splashScreenUiStateSplashScreen$lambda$0, SplashScreenUiState.NavigateToLoadingScreen.INSTANCE)) {
                this.$navigateToSetupScreen.invoke();
            } else if (!Intrinsics.areEqual(splashScreenUiStateSplashScreen$lambda$0, SplashScreenUiState.Loading.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        splashScreenUiState = (SplashScreenUiState) this.L$0;
        ResultKt.throwOnFailure(obj);
        if (((SplashScreenUiState.Error) splashScreenUiState).getNavigateToCredential()) {
            this.$navigateToSignInScreen.invoke();
        }
        return Unit.INSTANCE;
    }
}
