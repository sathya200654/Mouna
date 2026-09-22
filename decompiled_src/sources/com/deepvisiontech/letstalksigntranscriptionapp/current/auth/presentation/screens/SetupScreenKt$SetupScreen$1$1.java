package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpScreenEvent;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: SetupScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SetupScreenKt$SetupScreen$1$1", f = "SetupScreen.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
final class SetupScreenKt$SetupScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $navigateToConversationScreen;
    final /* synthetic */ Function1<String, Unit> $navigateToNotification;
    final /* synthetic */ Function0<Unit> $navigateToOnBoardingScreen;
    final /* synthetic */ SharedFlow<SetUpScreenEvent> $uiEvent;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SetupScreenKt$SetupScreen$1$1(SharedFlow<? extends SetUpScreenEvent> sharedFlow, Function0<Unit> function0, Function0<Unit> function1, Function1<? super String, Unit> function2, Continuation<? super SetupScreenKt$SetupScreen$1$1> continuation) {
        super(2, continuation);
        this.$uiEvent = sharedFlow;
        this.$navigateToConversationScreen = function0;
        this.$navigateToOnBoardingScreen = function1;
        this.$navigateToNotification = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SetupScreenKt$SetupScreen$1$1(this.$uiEvent, this.$navigateToConversationScreen, this.$navigateToOnBoardingScreen, this.$navigateToNotification, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    public final Object invokeSuspend(Object obj) throws KotlinNothingValueException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<SetUpScreenEvent> sharedFlow = this.$uiEvent;
            final Function0<Unit> function0 = this.$navigateToConversationScreen;
            final Function0<Unit> function1 = this.$navigateToOnBoardingScreen;
            final Function1<String, Unit> function2 = this.$navigateToNotification;
            this.label = 1;
            if (sharedFlow.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SetupScreenKt$SetupScreen$1$1.1
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((SetUpScreenEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public final Object emit(SetUpScreenEvent setUpScreenEvent, Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
                    if (Intrinsics.areEqual(setUpScreenEvent, SetUpScreenEvent.NavigateToHome.INSTANCE)) {
                        function0.invoke();
                    } else if (Intrinsics.areEqual(setUpScreenEvent, SetUpScreenEvent.NavigateToOnBoarding.INSTANCE)) {
                        function1.invoke();
                    } else {
                        if (!(setUpScreenEvent instanceof SetUpScreenEvent.NavigateToNotification)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        function2.invoke(((SetUpScreenEvent.NavigateToNotification) setUpScreenEvent).getNotificationId());
                    }
                    return Unit.INSTANCE;
                }
            }, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
