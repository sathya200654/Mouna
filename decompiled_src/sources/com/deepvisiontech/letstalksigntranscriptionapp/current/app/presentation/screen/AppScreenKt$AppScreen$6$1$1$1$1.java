package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen;

import androidx.compose.material3.DrawerState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AppScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$AppScreen$6$1$1$1$1", f = "AppScreen.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
final class AppScreenKt$AppScreen$6$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DrawerState $drawerState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppScreenKt$AppScreen$6$1$1$1$1(DrawerState drawerState, Continuation<? super AppScreenKt$AppScreen$6$1$1$1$1> continuation) {
        super(2, continuation);
        this.$drawerState = drawerState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppScreenKt$AppScreen$6$1$1$1$1(this.$drawerState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$drawerState.open((Continuation) this) == coroutine_suspended) {
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
