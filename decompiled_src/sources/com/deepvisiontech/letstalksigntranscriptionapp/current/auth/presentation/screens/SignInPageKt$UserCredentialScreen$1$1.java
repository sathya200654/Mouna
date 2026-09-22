package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens;

import android.content.Context;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialScreenUiEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: SignInPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$UserCredentialScreen$1$1", f = "SignInPage.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
final class SignInPageKt$UserCredentialScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $navigateToSetupScreen;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ SharedFlow<CredentialScreenUiEvent> $uiEvent;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SignInPageKt$UserCredentialScreen$1$1(SharedFlow<? extends CredentialScreenUiEvent> sharedFlow, SnackbarHostState snackbarHostState, Context context, Function0<Unit> function0, Continuation<? super SignInPageKt$UserCredentialScreen$1$1> continuation) {
        super(2, continuation);
        this.$uiEvent = sharedFlow;
        this.$snackbarHostState = snackbarHostState;
        this.$context = context;
        this.$navigateToSetupScreen = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignInPageKt$UserCredentialScreen$1$1(this.$uiEvent, this.$snackbarHostState, this.$context, this.$navigateToSetupScreen, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$UserCredentialScreen$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignInPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialScreenUiEvent;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt$UserCredentialScreen$1$1$1", f = "SignInPage.kt", i = {0}, l = {74}, m = "invokeSuspend", n = {"event"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CredentialScreenUiEvent, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Function0<Unit> $navigateToSetupScreen;
        final /* synthetic */ SnackbarHostState $snackbarHostState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SnackbarHostState snackbarHostState, Context context, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$snackbarHostState = snackbarHostState;
            this.$context = context;
            this.$navigateToSetupScreen = function0;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$snackbarHostState, this.$context, this.$navigateToSetupScreen, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CredentialScreenUiEvent credentialScreenUiEvent, Continuation<? super Unit> continuation) {
            return create(credentialScreenUiEvent, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
            CredentialScreenUiEvent credentialScreenUiEvent = (CredentialScreenUiEvent) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (credentialScreenUiEvent instanceof CredentialScreenUiEvent.Error) {
                    SnackbarHostState snackbarHostState = this.$snackbarHostState;
                    String string = this.$context.getString(((CredentialScreenUiEvent.Error) credentialScreenUiEvent).getMessage());
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    this.L$0 = SpillingKt.nullOutSpilledVariable(credentialScreenUiEvent);
                    this.label = 1;
                    if (SnackbarHostState.showSnackbar$default(snackbarHostState, string, (String) null, false, (SnackbarDuration) null, (Continuation) this, 14, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!Intrinsics.areEqual(credentialScreenUiEvent, CredentialScreenUiEvent.NavigateToNextScreen.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.$navigateToSetupScreen.invoke();
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (FlowKt.collectLatest(this.$uiEvent, new AnonymousClass1(this.$snackbarHostState, this.$context, this.$navigateToSetupScreen, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
